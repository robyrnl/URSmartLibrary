package id.ac.unri.ursmartlibrary;

import android.accounts.Account;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class pinjamBukuActivity extends AppCompatActivity {

    EditText etCode;
    Button btnCek;
    Button btnPinjam;

    TextView tvJudul;
    TextView tvPengarang;
    TextView tvTahun;

    DatabaseReference databaseBuku;
    ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinjam_buku);

        tvJudul = (TextView) findViewById(R.id.txtJudul);
        tvPengarang = (TextView) findViewById(R.id.txtPengarang);
        tvTahun = (TextView) findViewById(R.id.txtTahun);

        btnCek = (Button) findViewById(R.id.btnCek);
        btnPinjam = (Button) findViewById(R.id.btnPinjam);

        etCode = (EditText) findViewById(R.id.etCodeBukuPinjaman);
        final String Code = etCode.getText().toString();

        databaseBuku = FirebaseDatabase.getInstance().getReference("Buku");

        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckData(Code);
            }
        });

        btnPinjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputData();
            }
        });
    }

    void CheckData (final String code) {
        valueEventListener = databaseBuku.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String uploadId = snapshot.child("id").getValue().toString();

                if(code.equals(uploadId)) {
                    String judul = snapshot.child("judul").getValue().toString();
                    String pengarang = snapshot.child("pengarang").getValue().toString();
                    String tahun = snapshot.child("tahun").getValue().toString();

                    tvJudul.setText(judul);
                    tvPengarang.setText(pengarang);
                    tvTahun.setText(tahun);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    void InputData() {
        valueEventListener = databaseBuku.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
