/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.TurkSozlukDAO;
import entity.TurkSozluk;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author berat
 */
@FacesConverter("turkConverter")
public class TurkConverter implements Converter{
    private TurkSozlukDAO trdao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id=Long.valueOf(string);
        return this.getTrdao().getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        TurkSozluk tr=(TurkSozluk) t;
        return String.valueOf(tr.getTurk_id());
    }

    public TurkSozlukDAO getTrdao() {
        if(this.trdao==null){
            this.trdao=new TurkSozlukDAO();
        }
        return trdao;
    }

    public void setTrdao(TurkSozlukDAO trdao) {
        this.trdao = trdao;
    }
    
}
