package id.ac.unri.ursmartlibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PinjamBuku {

    String judul;
    String pengarang;
    String tahun;
    String idBuku;
    String mURL;

    String tanggalPeminjaman;
    String idPinjamBuku;

    public PinjamBuku(String judul, String pengarang, String tahun, String idBuku, String mURL, String tanggalPeminjaman, String idPinjamBuku) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahun = tahun;
        this.idBuku = idBuku;
        this.mURL = mURL;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.idPinjamBuku = idPinjamBuku;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getTahun() {
        return tahun;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public String getmURL() {
        return mURL;
    }

    public String getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }

    public String getIdPinjamBuku() {
        return idPinjamBuku;
    }

    //tanggalPeminjaman = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());


}
