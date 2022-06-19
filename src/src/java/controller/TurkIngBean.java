package controller;

import dao.TurkIngDAO;
import entity.IngSozluk;
import entity.TurkIng;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named("turkIngBean")
@SessionScoped
public class TurkIngBean implements Serializable{
    private TurkIng entity;
    private TurkIngDAO dao;
    private List<TurkIng> list;

    public void create() throws ClassNotFoundException, SQLException {
        this.getDao().create(entity);
        this.entity = new TurkIng();
    }

    public void clearForm() {
        this.entity = new TurkIng();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new TurkIng();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new TurkIng();
    }

    
    public TurkIng getEntity() {
        if(this.entity==null){
            this.dao=new TurkIngDAO();
        }
        return entity;
    }

    public void setEntity(TurkIng entity) {
        this.entity = entity;
    }

    public TurkIngDAO getDao() {
        if(this.dao==null){
            this.dao=new TurkIngDAO();
        }
        return dao;
    }

    public void setDao(TurkIngDAO dao) {
        this.dao = dao;
    }

    public List<TurkIng> getList() {
        this.list=this.getDao().readList();
        return list;
    }

    public void setList(List<TurkIng> list) {
        this.list = list;
    }
    
}
