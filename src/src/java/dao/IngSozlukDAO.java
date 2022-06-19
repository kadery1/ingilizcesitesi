/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.IngSozluk;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class IngSozlukDAO extends DBConnection {

    public IngSozluk getById(Long id) {
        IngSozluk ing = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from ingsozluk where ing_id="+id);
            rs.next();
            ing=new IngSozluk(rs.getLong("ing_id"), rs.getString("kelime"),
                        rs.getString("anlam"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ing;
    }

    public List<IngSozluk> readList() {
        List<IngSozluk> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from ingsozluk");
            while (rs.next()) {
                list.add(new IngSozluk(rs.getLong("ing_id"), rs.getString("kelime"),
                        rs.getString("anlam")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;

    }

    public void create(IngSozluk s) {
        try {
            Statement st = this.getConnection().createStatement();
            int r = st.executeUpdate("insert into ingsozluk(kelime,anlam) values ('" + s.getKelime() + "','" + s.getAnlam() + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(IngSozluk s) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update ingsozluk set anlam='" + s.getKelime() + "' where ing_id=" + s.getIng_id());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(IngSozluk s) {
        try {
            Statement st = this.getConnection().createStatement();
            int r = st.executeUpdate("delete from ingsozluk where ing_id=" + s.getIng_id());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
