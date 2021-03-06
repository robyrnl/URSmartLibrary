package id.ac.unri.ursmartlibrary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class loginActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    Button btnLogin;
    EditText etUser,etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        etUser = findViewById(R.id.etLUser);
        etPass = findViewById(R.id.etLPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //formCheck();
                openHome();
            }
        });
    }

    public void openHome () {

        final String email = etUser.getText().toString();
        String pass = etPass.getText().toString();

        if(email.isEmpty()){
            etUser.setError("Mohon Diisi");
            etUser.requestFocus();
            return;
        }

        if(pass.isEmpty()){
            etPass.setError("Mohon Diisi");
            etPass.requestFocus();
            return;

        }

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    SaveAccount(email);

                    Intent intent = new Intent(loginActivity.this, homeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void signUpPage(View view) {
        startActivity(new Intent(loginActivity.this,signUpActivity.class));
    }

    public void SaveAccount (String account) {
        //SharedPreferences sharedPreferences = getSharedPreferences(Account, 0);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(loginActivity.this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Account", account);
        editor.commit();
    }
}
