package id.ac.unri.ursmartlibrary;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class daftarBuku extends AppCompatActivity {

    ListView listViewBuku;
    DatabaseReference databaseBuku;

    ValueEventListener valueEventListener;

    List<Buku> bukuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_buku);

        listViewBuku = (ListView) findViewById(R.id.lvDaftarBuku);
        databaseBuku = FirebaseDatabase.getInstance().getReference("Buku");
        bukuList = new ArrayList<>();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseBuku.removeEventListener(valueEventListener);
    }

    @Override
    protected void onStart() {
        super.onStart();

        valueEventListener = databaseBuku.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bukuList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //Buku buku = snapshot.child("Buku").getValue(Buku.class).toString();
                    //bukuList.add(buku);

                    String judul = snapshot.child("judul").getValue().toString();
                    String uploadId = snapshot.child("id").getValue().toString();
                    String pengarang = snapshot.child("pengarang").getValue().toString();
                    String tahun = snapshot.child("tahun").getValue().toString();

                    Buku buku = new Buku (judul, pengarang, tahun, uploadId, "No Name");
                    bukuList.add(buku);
                    }

                listBuku adapter = new listBuku(daftarBuku.this, bukuList);
                listViewBuku.setAdapter(adapter);

                /*listViewBuku.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int possition, long id) {
                        Intent intent = new Intent(daftarBuku.this, pinjamBukuActivity.class);
                        startActivity(intent);
                    }
                });*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}