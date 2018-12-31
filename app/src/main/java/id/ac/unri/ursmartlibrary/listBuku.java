package id.ac.unri.ursmartlibrary;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class listBuku extends ArrayAdapter<Buku> {

    private Activity context;
    private List<Buku> daftarBuku;

    public listBuku (Activity context, List<Buku> daftarBuku) {
        super(context, R.layout.list_layout, daftarBuku);
        this.context = context;
        this.daftarBuku = daftarBuku;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);
        TextView textViewJudul = (TextView) listViewItem.findViewById(R.id.tv_judulBuku);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.tv_idBuku);
        TextView textViewPengarang = (TextView) listViewItem.findViewById(R.id.tv_pengarangBuku);
        TextView textViewTahun = (TextView) listViewItem.findViewById(R.id.tv_tahunBuku);

        Buku buku = daftarBuku.get(position);

        textViewJudul.setText(buku.getJudulBuku());
        textViewId.setText(buku.getId());
        textViewPengarang.setText(buku.getPengarangBuku());
        textViewTahun.setText(buku.getTahunTerbit());

        return listViewItem;
    }
}
