package id.ac.unri.ursmartlibrary;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signUpActivity extends AppCompatActivity {

    EditText etRmail, etRpass, etRnama, etRjurusan, etNotlpn, etRnim;
    Button btnSignUp, btnBatal;

    private FirebaseAuth mAuth;
    DatabaseReference databaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        databaseUser = FirebaseDatabase.getInstance().getReference("user");

        etRmail = findViewById(R.id.etREmail);
        etRpass = findViewById(R.id.etRPass);
        etRjurusan = findViewById(R.id.etRjurusan);
        etNotlpn= findViewById(R.id.etRNotlp);
        etRnim = findViewById(R.id.etRNim);
        etRnama = findViewById(R.id.etRnama);
        btnSignUp = findViewById(R.id.btnRDaftar);
        btnBatal = findViewById(R.id.btnRCancel);

        mAuth = FirebaseAuth.getInstance();

        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signUpActivity.this,loginActivity.class));
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formCheck();
                UserRegister();
            }
        });

    }

    private void formCheck() {
        String email = etRmail.getText().toString().trim();
        String pass = etRpass.getText().toString().trim();
        String nim = etRnim.getText().toString().trim();
        String nama = etRnama.getText().toString().trim();
        String jurusan = etRjurusan.getText().toString().trim();
        String notlp = etNotlpn.getText().toString().trim();

        if(email.isEmpty()){
            etRmail.setError("Email Belum Terisi");
            etRmail.requestFocus();
            return;
        }
        else if(pass.isEmpty()){
            etRpass.setError("Password Belum Terisi");
            etRpass.requestFocus();
            return;
        }
        else if(nim.isEmpty()){
            etRpass.setError("NIM Belum Terisi");
            etRpass.requestFocus();
            return;
        }
        else if(nama.isEmpty()){
            etRpass.setError("Nama Belum Terisi");
            etRpass.requestFocus();
            return;
        }
        else if(jurusan.isEmpty()){
            etRpass.setError("Jurusan Belum Terisi");
            etRpass.requestFocus();
            return;
        }
        else if(notlp.isEmpty()){
            etRpass.setError("No Telepon Belum Terisi");
            etRpass.requestFocus();
            return;
        }
    }

    private void UserRegister(){
        final String email,pass;
        email = etRmail.getText().toString();
        pass = etRpass.getText().toString();
        final String nim = etRnim.getText().toString();
        final String nama = etRnama.getText().toString();
        final String jurusan = etRjurusan.getText().toString();
        final String notlp = etNotlpn.getText().toString();

        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    //fungsi untuk memasukkan data kedatabase, jangan lupa buat getter dan constructor
                    String id = databaseUser.push().getKey();
                    User user = new User(id, nama, jurusan, nim, notlp, email);
                    databaseUser.child(id).setValue(user);

                    Toast.makeText(signUpActivity.this,"Pendaftaran Berhasil",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(signUpActivity.this,loginActivity.class));
                }
                else
                {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"Anda Sudah Terdaftar",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}
