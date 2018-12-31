package id.ac.unri.ursmartlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;

public class loginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etUser,etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin =(Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });
    }

    public void openHome () {
        Intent intent = new Intent(this, homeActivityFragmen.class);
        startActivity(intent);
    }

    public void signUpPage(View view) {
        startActivity(new Intent(loginActivity.this,signUpActivity.class));
    }
}
