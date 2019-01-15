/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ramon.bean;

import com.google.gson.annotations.Expose;
import java.sql.Connection;
import java.sql.ResultSet;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.helper.EncodingHelper;

/**
 *
 * @author ramon
 */
public class ExtrasAnuncioBean implements BeanInterface {

    @Expose
    private Integer id_anuncio;
    @Expose
    private Integer id_extras;

    public Integer getId_anuncio() {
        return id_anuncio;
    }

    public void setId_anuncio(Integer id_anuncio) {
        this.id_anuncio = id_anuncio;
    }

    public Integer getId_extras() {
        return id_extras;
    }

    public void setId_extras(Integer id_extras) {
        this.id_extras = id_extras;
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExtrasAnuncioBean fill(ResultSet oResultSet, Connection oConnection, Integer expand) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "extras_anuncio.id_anuncio,";
        strColumns += "extras_anuncio.id_extras";
        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += id_anuncio + ",";
        strColumns += id_extras;
        return strColumns;
    }

    @Override
    public String getPairs() {
        String strPairs = "";
        strPairs += "extras_anuncio.id_anuncio=" + id_anuncio + ",";
        strPairs += "extras_anuncio.id_extras=" + id_extras;
//        strPairs += " WHERE ciudad.id=" + id;
        return strPairs;
    }

}
