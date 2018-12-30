package id.ac.unri.ursmartlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btnProfilHome:
                intent = new Intent(this, profile.class);
                startActivity(intent);
                break;
            case R.id.btnDaftarBukuHome:
                intent = new Intent(this, daftarBukuActivity.class);
                startActivity(intent);
                break;
            case R.id.btnTambahBukuHome:
                intent = new Intent(this, addBookActivity.class);
                startActivity(intent);
                break;
            case R.id.btnPinjamBukuHome:
                intent = new Intent(this, pinjamBukuActivity.class);
                startActivity(intent);
                break;
            case R.id.btnAboutHome:
                intent = new Intent(this, about.class);
                startActivity(intent);
                break;
        }
    }
}