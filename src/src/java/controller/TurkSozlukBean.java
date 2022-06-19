/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TurkSozlukDAO;
import entity.TurkSozluk;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named("turkSozlukBean")
@SessionScoped
public class TurkSozlukBean implements Serializable{
    TurkSozluk entity;
    TurkSozlukDAO dao;
    private List<TurkSozluk> list;

    public void create() throws ClassNotFoundException, SQLException{
        this.getDao().create(entity);
        this.entity=new TurkSozluk();
    }
    public void clearForm(){
        this.entity=new TurkSozluk();
    }
    public void update(){
        this.getDao().update(entity);
        this.entity=new TurkSozluk();
    }
    public void delete(){
        this.getDao().delete(entity);
        this.entity=new TurkSozluk();
    }
    public TurkSozluk getEntity() {
        if(this.entity==null){
            this.entity=new TurkSozluk();
        }
        return entity;
    }

    public void setEntity(TurkSozluk entity) {
        this.entity = entity;
    }

    public TurkSozlukDAO getDao() {
        if(this.dao==null){
            this.dao=new TurkSozlukDAO();
        }
        return dao;
    }

    public void setDao(TurkSozlukDAO dao) {
        this.dao = dao;
    }

    public List<TurkSozluk> getList() {
        this.list=this.getDao().readList();
        return list;
    }

    public void setList(List<TurkSozluk> list) {
        this.list = list;
    }
    
    
}
