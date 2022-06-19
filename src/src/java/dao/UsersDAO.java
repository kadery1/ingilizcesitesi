package dao;

import entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class UsersDAO extends DBConnection {

   
public List<User> readList() {
        List<User> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from users ");
            while (rs.next()) {
                list.add(new User(rs.getLong("user_id"), rs.getInt("kelime_ekleme_sayisi"), rs.getString("email"), rs.getString("pass")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;

    }
    
    public List<User> readList(int page) {
        List<User> list = new ArrayList<>();
        int offset = (page - 1) * 5;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from users limit 5 offset " + offset );
            while (rs.next()) {
                list.add(new User(rs.getLong("user_id"), rs.getInt("kelime_ekleme_sayisi"), rs.getString("email"), rs.getString("pass")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;

    }

    public User getUser(String eposta, String sifre) {
        User u = null;
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from users where email='" + eposta + "' and pass='" + sifre + "'");
            rs.next();
            u = new User(rs.getLong("user_id"), rs.getInt("kelime_ekleme_sayisi"),
                    rs.getString("email"), rs.getString("pass"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return u;
    }

    public void create(User s) {
        try {
            Statement st = this.getConnection().createStatement();
            int r = st.executeUpdate("insert into users(email,pass,kelime_ekleme_sayisi) values ('" + s.getEmail() + "','" + s.getPass() + "',0)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(User s) {
        try {
            Statement st = this.getConnection().createStatement();
            int r = st.executeUpdate("update users set email='" + s.getEmail() + "' where user_id=" + s.getUser_id());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(User s) {
        try {
            Statement st = this.getConnection().createStatement();
            int r = st.executeUpdate("delete from users where user_id=" + s.getUser_id());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
