package id.ac.unri.ursmartlibrary;

public class Buku {

    String judul;
    String pengarang;
    String tahun;

    public Buku(String id, String judul, String pengarang, String tahun) {

    }

    public Buku (String judul, String pengarang, String tahun) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahun = tahun;
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
}
