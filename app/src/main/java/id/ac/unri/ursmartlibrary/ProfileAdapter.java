package id.ac.unri.ursmartlibrary;

public class ProfileAdapter {

    public String nama;
    public String nim;
    public String email;
    public String noTlpnn;
    public String jurusan;

    public ProfileAdapter(){

    }

    public ProfileAdapter(String nama, String nim, String email, String noTlpnn, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.email = email;
        this.noTlpnn = noTlpnn;
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoTlpnn() {
        return noTlpnn;
    }

    public void setNoTlpnn(String noTlpnn) {
        this.noTlpnn = noTlpnn;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}
