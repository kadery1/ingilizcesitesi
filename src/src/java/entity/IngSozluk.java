/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

public class IngSozluk {
    private Long ing_id;
    private String kelime,anlam;

    public IngSozluk() {
    }

    public IngSozluk(Long ing_id, String kelime, String anlam) {
        this.ing_id = ing_id;
        this.kelime = kelime;
        this.anlam = anlam;
    }

    public Long getIng_id() {
        return ing_id;
    }

    public void setIng_id(Long ing_id) {
        this.ing_id = ing_id;
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
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.ing_id);
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
        final IngSozluk other = (IngSozluk) obj;
        return Objects.equals(this.ing_id, other.ing_id);
    }
    
}
