package id.ac.unri.ursmartlibrary;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class addBookActivity extends AppCompatActivity {

    private static final String TAG = "TambahBuku";

    private static final int PICK_IMAGE_REQUEST = 1;

    EditText etJudulBuku;
    EditText etPengarangBuku;
    EditText etTahunBuku;
    Button buttonAddBook;
    Button btnTambahGambar;
    EditText etNamaFile;
    ImageView imgGambarBuku;
    ProgressBar progressBar;

    Uri mImageUri;

    //FirebaseDatabase
    StorageReference mStorageRef;
    DatabaseReference databaseBuku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        buttonAddBook = findViewById(R.id.btnTBTambah);
        etJudulBuku = findViewById(R.id.etJudulBuku);
        etPengarangBuku =  findViewById(R.id.etPengarangBuku);
        etTahunBuku =  findViewById(R.id.etTahunBuku);
        btnTambahGambar = findViewById(R.id.btnTmbahGambarBuku);
        etNamaFile = findViewById(R.id.namaFile);
        imgGambarBuku = findViewById(R.id.image_view);
        progressBar = findViewById(R.id.progresbar);

        mStorageRef = FirebaseStorage.getInstance().getReference("Buku");
        databaseBuku = FirebaseDatabase.getInstance().getReference("Buku");

        btnTambahGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFile();
            }
        });

        buttonAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBook();
                uploadFile();
            }
        });
    }

    private void openFile(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            mImageUri = data.getData();

            Picasso.with(this).load(mImageUri).into(imgGambarBuku);
        }
    }

    private String getFileExtension (Uri uri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }

    private void uploadFile(){

        if(mImageUri != null){
            mStorageRef.putFile(mImageUri).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if(!task.isSuccessful()){
                        throw task.getException();
                    }
                    return mStorageRef.getDownloadUrl();
                }
            })
                    .addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            if(task.isSuccessful()){
                                Uri downloadUri = task.getResult();
                                Log.e(TAG, "then" + downloadUri.toString());
                                Upload upload = new Upload(etNamaFile.getText().toString().trim(), downloadUri.toString());
                                String uploadId = databaseBuku.push().getKey();
                                databaseBuku.child(uploadId).setValue(upload);
                            }
                            else{

                                Toast.makeText(addBookActivity.this, "gagal upload : "+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
            /*StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()+ "." + getFileExtension(mImageUri));
            fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(0);
                                }
                            }, 5000);

                            Toast.makeText(addBookActivity.this, "Berhasil diUpload", Toast.LENGTH_SHORT).show();
                            Upload upload = new Upload(etNamaFile.getText().toString().trim(), taskSnapshot.getDownloadurl.toString());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(addBookActivity.this, e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            progressBar.setProgress((int) progress);
                        }
                    });*/
        }
    }

    private void addBook () {
        String judul = etJudulBuku.getText().toString().trim();
        String pengarang = etPengarangBuku.getText().toString().trim();
        String tahun = etTahunBuku.getText().toString();

        if(!TextUtils.isEmpty(judul) || !TextUtils.isEmpty(pengarang) || !TextUtils.isEmpty(tahun)) {
            String id = databaseBuku.push().getKey();
            Buku buku = new Buku (id, judul, pengarang, tahun);
            databaseBuku.child(id).setValue(buku);

            Toast.makeText(this, "Buku telah ditambahkan", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Judul, pengarang dan tahun buku tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }
    }

}
