/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.IngSozlukDAO;
import entity.IngSozluk;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author berat
 */
@FacesConverter("ingConverter")
public class IngConverter implements Converter{
    private IngSozlukDAO ingdao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id=Long.valueOf(string);
        return this.getIngdao().getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        IngSozluk ing=(IngSozluk) t;
        return  String.valueOf(ing.getIng_id());
    }

    public IngSozlukDAO getIngdao() {
        if(this.ingdao==null){
            this.ingdao=new IngSozlukDAO();
        }
        return ingdao;
    }

    public void setIngdao(IngSozlukDAO ingdao) {
        this.ingdao = ingdao;
    }
    
}
