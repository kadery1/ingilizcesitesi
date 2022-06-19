package dao;

import entity.IngSozluk;
import entity.TurkIng;
import entity.TurkSozluk;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class TurkIngDAO extends DBConnection {

    private TurkSozlukDAO trdao;
    private IngSozlukDAO ingdao;

    public List<TurkIng> readList() {
        List<TurkIng> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from turkceIngilizceCeviri");
            while (rs.next()) {
                TurkSozluk tr = this.getTrdao().getById(rs.getLong("turk_id"));
                IngSozluk ing = this.getIngdao().getById(rs.getLong("ing_id"));

                list.add(new TurkIng(rs.getLong("turk_id"), tr, ing));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;

    }

    public void create(TurkIng s) {
        try {
            Statement st = this.getConnection().createStatement();
            int r = st.executeUpdate("insert into turkceIngilizceCeviri(turk_id,ing_id) values (" + s.getTr().getTurk_id() + "," + s.getIng().getIng_id() + ")");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(TurkIng s) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update turkceIngilizceCeviri set turk_id='" + s.getTr().getTurk_id() + "' where id=" + s.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(TurkIng s) {
        try {
            Statement st = this.getConnection().createStatement();
            int r = st.executeUpdate("delete from turkceIngilizceCeviri where id=" + s.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public TurkSozlukDAO getTrdao() {
        if (this.trdao == null) {
            this.trdao = new TurkSozlukDAO();
        }
        return trdao;
    }

    public void setTrdao(TurkSozlukDAO trdao) {
        this.trdao = trdao;
    }

    public IngSozlukDAO getIngdao() {
        if (this.ingdao == null) {
            this.ingdao = new IngSozlukDAO();
        }
        return ingdao;
    }

    public void setIngdao(IngSozlukDAO ingdao) {
        this.ingdao = ingdao;
    }

}
