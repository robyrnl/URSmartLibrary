package id.ac.unri.ursmartlibrary;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class tabFragment1 extends Fragment {

    private static final String TAG = "tabFragment";

    Button btnTambahBuku;
    Button btnPinjamBuku;
    Button btnProfile;
    Button btnDaftarBuku;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_home,container,false);

        btnTambahBuku = (Button) view.findViewById(R.id.btnTambahBukuHome);
        btnDaftarBuku = (Button) view.findViewById(R.id.btnDaftarBukuHome);
        btnProfile = (Button) view.findViewById(R.id.btnProfilHome);
        btnPinjamBuku = (Button) view.findViewById(R.id.btnPinjamBukuHome);

        btnTambahBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                tabFragment1 tb = new tabFragment1();
                //ft.replace(R.id.)
            }
        });

        btnPinjamBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), pinjamBukuActivity.class));
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), profile.class));
            }
        });

        btnDaftarBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),daftarBuku.class));
            }
        });

        return view;
    }


}
