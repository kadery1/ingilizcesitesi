package entity;

import java.io.Serializable;

public class User{

    private Long user_id;
    private int kelime_ekleme_sayisi;
    private String email, pass;

    public User() {
        
    }

    public User(Long user_id, int kelime_ekleme_sayisi, String email, String pass) {
        this.user_id = user_id;
        this.kelime_ekleme_sayisi = kelime_ekleme_sayisi; 
        this.email = email;
        this.pass = pass;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getKelime_ekleme_sayisi() {
        return kelime_ekleme_sayisi;
    }

    public void setKelime_ekleme_sayisi(int kelime_ekleme_sayisi) {
        this.kelime_ekleme_sayisi = kelime_ekleme_sayisi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
