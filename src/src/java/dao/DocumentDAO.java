/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Document;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author berat
 */
public class DocumentDAO extends DBConnection{
    public List<Document> findAll(){
        List<Document> dList=new ArrayList<>();
        try{
            PreparedStatement pst=this.getConnection().prepareStatement("select * from documents");
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()){
                Document d=new Document();
                d.setId(rs.getLong("id"));
                d.setFilePath(rs.getString("path"));
                d.setFileName(rs.getString("name"));
                d.setFileType(rs.getString("type"));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return dList;
    }
    public void insert(Document d){
        String query="insert into documents(path,name,type) values(?,?,?)";
        try{
            PreparedStatement pst=this.getConnection().prepareStatement(query);
            pst.setString(1, d.getFilePath());
            pst.setString(2, d.getFileName());
            pst.setString(3, d.getFileType());
            pst.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
