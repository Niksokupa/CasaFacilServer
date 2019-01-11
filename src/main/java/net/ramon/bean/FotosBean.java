package net.ramon.bean;

import java.sql.Connection;
import java.sql.ResultSet;

import com.google.gson.annotations.Expose;
import net.ramon.bean.genericBeanInterface.GenericBeanImplementation;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.helper.EncodingHelper;

public class FotosBean extends GenericBeanImplementation implements BeanInterface{

    @Expose
    private String ruta;

    public String getDesc() {
        return ruta;
    }

    public void setDesc(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public FotosBean fill(ResultSet oResultSet, Connection oConnection, Integer expand) throws Exception {
        this.setId(oResultSet.getInt("id"));
        this.setDesc(oResultSet.getString("ruta"));
        return this;
    }

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "fotos.id,";
        strColumns += "fotos.ruta";
        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += "null,";
        strColumns += EncodingHelper.quotate(ruta);
        return strColumns;
    }

    @Override
    public String getPairs() {
        String strPairs = "";
        strPairs += "fotos.id=" + id + ",";
        strPairs += "fotos.desc=" + ruta;
        strPairs += " WHERE fotos.id=" + id;
        return strPairs;
    }
}
