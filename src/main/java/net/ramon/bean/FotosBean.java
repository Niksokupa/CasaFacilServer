package net.ramon.bean;

import java.sql.Connection;
import java.sql.ResultSet;

import com.google.gson.annotations.Expose;
import net.ramon.bean.genericBeanInterface.GenericBeanImplementation;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.dao.publicDaoInterface.DaoInterface;
import net.ramon.factory.DaoFactory;
import net.ramon.helper.EncodingHelper;

public class FotosBean extends GenericBeanImplementation implements BeanInterface {

    @Expose
    private String ruta;
    @Expose
    private Integer id_anuncio;
    @Expose(deserialize = false)
    private AnuncioBean obj_Anuncio;

    public AnuncioBean getObj_Anuncio() {
        return obj_Anuncio;
    }

    public void setObj_Anuncio(AnuncioBean obj_Anuncio) {
        this.obj_Anuncio = obj_Anuncio;
    }

    public Integer getId_anuncio() {
        return id_anuncio;
    }

    public void setId_anuncio(Integer id_anuncio) {
        this.id_anuncio = id_anuncio;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public FotosBean fill(ResultSet oResultSet, Connection oConnection, Integer expand) throws Exception {
        this.setId(oResultSet.getInt("id"));
        this.setRuta(oResultSet.getString("ruta"));
        if (expand > 0) {
            DaoInterface oAnuncioDao = DaoFactory.getDao(oConnection, "anuncio");
            this.setObj_Anuncio((AnuncioBean) oAnuncioDao.get(oResultSet.getInt("id_anuncio"), expand));
        } else {
            this.setId_anuncio(oResultSet.getInt("id_anuncio"));
        }
        return this;
    }

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "fotos.id,";
        strColumns += "fotos.ruta,";
        strColumns += "fotos.id_anuncio";
        return strColumns;
    }

    @Override
    public String getValues() {
        if (id_anuncio == 0) {
            id_anuncio = obj_Anuncio.getId();
        }
        
        String strColumns = "";
        strColumns += "null,";
        strColumns += EncodingHelper.quotate(ruta) + ",";
        strColumns += id_anuncio;
        return strColumns;
    }

    @Override
    public String getPairs() {
        if (id_anuncio == 0) {
            id_anuncio = obj_Anuncio.getId();
        }
        
        String strPairs = "";
        strPairs += "fotos.id=" + id + ",";
        strPairs += "fotos.desc=" + ruta + ",";
        strPairs += "fotos.id_anuncio=" + id_anuncio;
        strPairs += " WHERE fotos.id=" + id;
        return strPairs;
    }
}
