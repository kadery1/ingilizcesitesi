package controller;

import dao.IngTurkDAO;
import entity.IngTurk;
import entity.IngTurk;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
@Named("ingTurkBean")
@SessionScoped
public class IngTurkBean implements Serializable{

    private IngTurk entity;
    private IngTurkDAO dao;
    private List<IngTurk> list;

    public void create() throws ClassNotFoundException, SQLException {
        this.getDao().create(entity);
        this.entity = new IngTurk();
    }

    public void clearForm() {
        this.entity = new IngTurk();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new IngTurk();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new IngTurk();
    }

    public IngTurk getEntity() {
        if (this.entity == null) {
            this.dao = new IngTurkDAO();
        }
        return entity;
    }

    public void setEntity(IngTurk entity) {
        this.entity = entity;
    }

    public IngTurkDAO getDao() {
        if (this.dao == null) {
            this.dao = new IngTurkDAO();
        }
        return dao;
    }

    public void setDao(IngTurkDAO dao) {
        this.dao = dao;
    }

    public List<IngTurk> getList() {
        this.list = this.getDao().readList();
        return list;
    }

    public void setList(List<IngTurk> list) {
        this.list = list;
    }

}
