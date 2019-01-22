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

/**
 *
 * @author ramon
 */
public class FavoritoBean implements BeanInterface {

    @Expose
    private Integer id_anuncio;
    @Expose
    private Integer id_usuario;

    public Integer getId_anuncio() {
        return id_anuncio;
    }

    public void setId_anuncio(Integer id_anuncio) {
        this.id_anuncio = id_anuncio;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
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
        strColumns += "favorito.id_usuario,";
        strColumns += "favorito.id_anuncio";
        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += id_usuario + ",";
        strColumns += id_anuncio;
        return strColumns;
    }

    @Override
    public String getPairs() {
        String strPairs = "";
        strPairs += "favorito.id_anuncio=" + id_anuncio + ",";
        strPairs += "favorito.id_usuario=" + id_usuario;
//        strPairs += " WHERE ciudad.id=" + id;
        return strPairs;
    }

}
