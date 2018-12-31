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
import com.google.firebase.auth.FirebaseUser;

public class signUpActivity extends AppCompatActivity {

    EditText etRmail, etRpass;
    Button btnSignUp, btnBatal;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etRmail = findViewById(R.id.etREmail);
        etRpass = findViewById(R.id.etRPass);
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
                UserRegister();
            }
        });

    }
    private void UserRegister(){
        String email,pass;
        email = etRmail.getText().toString();
        pass = etRpass.getText().toString();

        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(signUpActivity.this,"Pendaftaran Berhasil",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(signUpActivity.this,loginActivity.class));
                }
                else
                {
                    Toast.makeText(signUpActivity.this,"Pendaftaran Gagal",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
