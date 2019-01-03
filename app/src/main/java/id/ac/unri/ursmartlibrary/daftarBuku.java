package id.ac.unri.ursmartlibrary;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

    List<Buku> bukuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_buku);

        listViewBuku = (ListView) findViewById(R.id.lvDaftarBuku);
        databaseBuku = FirebaseDatabase.getInstance().getReference("buku");
        bukuList = new ArrayList<Buku>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseBuku.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bukuList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Buku buku = snapshot.getValue(Buku.class);

                    bukuList.add(buku);
                }

                listBuku adapter = new listBuku(daftarBuku.this, bukuList);
                listViewBuku.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
