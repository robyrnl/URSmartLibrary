package id.ac.unri.ursmartlibrary;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class addBookActivity extends AppCompatActivity {

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
    DatabaseReference databaseBuku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        etJudulBuku = findViewById(R.id.etJudulBuku);
        etPengarangBuku =  findViewById(R.id.etPengarangBuku);
        etTahunBuku =  findViewById(R.id.etTahunBuku);
        btnTambahGambar = findViewById(R.id.btnTmbahGambarBuku);
        etNamaFile = findViewById(R.id.namaFile);
        imgGambarBuku = findViewById(R.id.image_view);
        progressBar = findViewById(R.id.progresbar);

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
