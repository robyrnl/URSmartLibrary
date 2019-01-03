package id.ac.unri.ursmartlibrary;

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

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getTahun() {
        return tahun;
    }

    public String getId() {
        return id;
    }
}