package controller;

import dao.IngSozlukDAO;
import entity.IngSozluk;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named("ingSozlukBean")
@SessionScoped
public class IngSozlukBean implements Serializable {

    private IngSozluk entity;
    private IngSozlukDAO dao;
    private List<IngSozluk> list;

    public void create() throws ClassNotFoundException, SQLException {
        this.getDao().create(entity);
        this.entity = new IngSozluk();
    }

    public void clearForm() {
        this.entity = new IngSozluk();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new IngSozluk();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new IngSozluk();
    }

    
    public IngSozluk getEntity() {
        if (this.entity == null) {
            this.entity = new IngSozluk();
        }
        return entity;
    }

    public void setEntity(IngSozluk entity) {
        this.entity = entity;
    }

    public IngSozlukDAO getDao() {
        if (this.dao == null) {
            this.dao = new IngSozlukDAO();
        }
        return dao;
    }

    public void setDao(IngSozlukDAO dao) {
        this.dao = dao;
    }

    public List<IngSozluk> getList() {
        this.list = this.getDao().readList();
        return list;
    }

    public void setList(List<IngSozluk> list) {
        this.list = list;
    }

}
