/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

public class TurkSozluk {
    private Long turk_id;
    private String kelime,anlam;

    public TurkSozluk() {
    }

    public TurkSozluk(Long turk_id, String kelime, String anlam) {
        this.turk_id = turk_id;
        this.kelime = kelime;
        this.anlam = anlam;
    }

    public Long getTurk_id() {
        return turk_id;
    }

    public void setTurk_id(Long turk_id) {
        this.turk_id = turk_id;
    }

    public String getKelime() {
        return kelime;
    }

    public void setKelime(String kelime) {
        this.kelime = kelime;
    }

    public String getAnlam() {
        return anlam;
    }

    public void setAnlam(String anlam) {
        this.anlam = anlam;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.turk_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TurkSozluk other = (TurkSozluk) obj;
        return Objects.equals(this.turk_id, other.turk_id);
    }
    
}
