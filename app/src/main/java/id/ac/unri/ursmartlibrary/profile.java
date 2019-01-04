package id.ac.unri.ursmartlibrary;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    private TextView tvtNama, tvtNim, tvtEmail, tvtPhone, tvtJurusan;
    private Button btnKembali;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvtNama = findViewById(R.id.tvPIsiNama);
        tvtEmail = findViewById(R.id.tvPIsiEmail);
        tvtJurusan = findViewById(R.id.tvPIsiProdi);
        tvtNim = findViewById(R.id.tvPIsiNim);
        tvtPhone = findViewById(R.id.tvPIsiNoTlpn);
        btnKembali = findViewById(R.id.btnPKembali);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

         databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ProfileAdapter profileAdapter = dataSnapshot.getValue(ProfileAdapter.class);
                tvtNama.setText(profileAdapter.getNama());
                tvtEmail.setText(profileAdapter.getEmail());
                tvtJurusan.setText(profileAdapter.getJurusan());
                tvtNim.setText(profileAdapter.getNim());
                tvtPhone.setText(profileAdapter.getNoTlpnn());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(profile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
