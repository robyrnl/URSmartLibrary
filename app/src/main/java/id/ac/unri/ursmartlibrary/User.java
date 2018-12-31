package id.ac.unri.ursmartlibrary;

public class User {

    String userId;
    String nama;
    String jurusan;
    String nim;
    String noTlpn;
    String email;

    public User (){

    }

    public User(String userId, String nama, String jurusan, String nim, String noTlpn, String email) {
        this.userId = userId;
        this.nama = nama;
        this.jurusan = jurusan;
        this.nim = nim;
        this.noTlpn = noTlpn;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getNim() {
        return nim;
    }

    public String getNoTlpn() {
        return noTlpn;
    }

    public String getEmail() {
        return email;
    }
}
