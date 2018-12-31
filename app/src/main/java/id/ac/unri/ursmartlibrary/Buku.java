package id.ac.unri.ursmartlibrary;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Buku {

    String judul;
    String pengarang;
    String tahun;
    String id;

    public Buku (String judul, String pengarang, String tahun, String id) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahun = tahun;
        this.id = id;
    }

    public String getJudulBuku() {
        return judul;
    }

    public String getPengarangBuku() {
        return pengarang;
    }

    public String getTahunTerbit() {
        return tahun;
    }

    public String getId() { return id; }
}
