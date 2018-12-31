package id.ac.unri.ursmartlibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PinjamBuku extends Buku {

    String tanggalPeminjaman;

    public PinjamBuku(String judul, String pengarang, String tahun, String id) {
        super(judul, pengarang, tahun, id);
    }

    public void PinjamBuku (String id) {
        //tanggalPeminjaman = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
    }

}
