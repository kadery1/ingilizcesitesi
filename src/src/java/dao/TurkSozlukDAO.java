/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.TurkSozluk;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class TurkSozlukDAO extends DBConnection{
    
    public TurkSozluk getById(Long id) {
        TurkSozluk tr = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from turksozluk where turk_id="+id);
            rs.next();
            tr=new TurkSozluk(rs.getLong("turk_id"), rs.getString("kelime"),
                        rs.getString("anlam"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tr;
    }
    public List<TurkSozluk> readList(){
        List<TurkSozluk> list =new ArrayList<>();
        try{
            Statement st=this.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from turksozluk");
            while(rs.next()){
                list.add(new TurkSozluk(rs.getLong("turk_id"), rs.getString("kelime"),
                    rs.getString("anlam")));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
        
    }
    
    public void create(TurkSozluk s){
        try{
            Statement st=this.getConnection().createStatement();
            int r = st.executeUpdate("insert into turksozluk(kelime,anlam) values ('"+s.getKelime()+"','"+s.getAnlam()+"')");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update(TurkSozluk s){
        try{
            Statement st=this.getConnection().createStatement();
            st.executeUpdate("update turksozluk set anlam='"+s.getKelime()+"' where turk_id="+s.getTurk_id());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(TurkSozluk s){
        try{
            Statement st=this.getConnection().createStatement();
            int r=st.executeUpdate("delete from turksozluk where turk_id="+s.getTurk_id());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
