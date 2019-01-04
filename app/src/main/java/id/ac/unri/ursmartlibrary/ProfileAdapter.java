package id.ac.unri.ursmartlibrary;

public class ProfileAdapter {

    public String nama;
    public String nim;
    public String email;
    public String noTlpn;
    public String jurusan;
    public String userId;

    public ProfileAdapter(){

    }

    public ProfileAdapter(String nama, String nim, String email, String noTlpn, String jurusan, String userId) {
        this.nama = nama;
        this.nim = nim;
        this.email = email;
        this.noTlpn = noTlpn;
        this.jurusan = jurusan;
        this.userId = userId;
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
        return noTlpn;
    }

    public void setNoTlpnn(String noTlpnn) {
        this.noTlpn = noTlpnn;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String jurusan) {
        this.userId = userId;
    }
}
