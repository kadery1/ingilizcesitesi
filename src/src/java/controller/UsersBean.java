package controller;

import dao.UsersDAO;
import entity.User;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named("usersBean")
@SessionScoped
public class UsersBean implements Serializable {

    User entity;
    UsersDAO dao;
    private List<User> list;

    private int page = 1;
    private int pageCount;

    public void create() throws ClassNotFoundException, SQLException {
        this.getDao().create(entity);
        this.entity = new User();
    }

    public void clearForm() {
        this.entity = new User();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new User();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new User();
    }

    public User getEntity() {
        if (this.entity == null) {
            this.entity = new User();
        }
        return entity;
    }

    public void setEntity(User entity) {
        this.entity = entity;
    }

    public UsersDAO getDao() {
        if (this.dao == null) {
            this.dao = new UsersDAO();
        }
        return dao;
    }

    public void setDao(UsersDAO dao) {
        this.dao = dao;
    }

    public List<User> getList() {
        this.list = this.getDao().readList(page);
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        List<User> uList=this.getDao().readList();
        int size=uList.size();
        pageCount=(int) Math.ceil(size/5);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void next() {
        page++;
        if(page>this.getPageCount()){
            page=1;
        }
    }

    public void previus() {
        page--;
        if(page<1){
            page=this.getPageCount();
        }
    }

}
