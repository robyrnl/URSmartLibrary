package id.ac.unri.ursmartlibrary;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homeActivity extends AppCompatActivity {

    Button btnTambahBuku;
    Button btnPinjamBuku;
    Button btnProfile;
    Button btnDaftarBuku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnTambahBuku = findViewById(R.id.btnTambahBukuHome);
        btnDaftarBuku = findViewById(R.id.btnDaftarBukuHome);
        btnProfile = findViewById(R.id.btnProfilHome);
        btnPinjamBuku = findViewById(R.id.btnPinjamBukuHome);

        btnTambahBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeActivity.this, addBookActivity.class));
            }
        });

        btnPinjamBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeActivity.this, pinjamBukuActivity.class));
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeActivity.this, profile.class));
            }
        });

        btnDaftarBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeActivity.this,daftarBuku.class));
            }
        });

    }
}