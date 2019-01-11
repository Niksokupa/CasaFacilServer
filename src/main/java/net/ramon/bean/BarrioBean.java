/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ramon.bean;

import java.sql.Connection;
import java.sql.ResultSet;

import com.google.gson.annotations.Expose;
import net.ramon.bean.genericBeanInterface.GenericBeanImplementation;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.dao.publicDaoInterface.DaoInterface;
import net.ramon.factory.DaoFactory;
import net.ramon.helper.EncodingHelper;

public class BarrioBean extends GenericBeanImplementation implements BeanInterface {

    @Expose
    private String desc;
    @Expose
    private Integer codpostal;
    @Expose(serialize = false)
    private int id_ciudad;
    @Expose(deserialize = false)
    private CiudadBean obj_ciudad;

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public Integer getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(Integer codpostal) {
        this.codpostal = codpostal;
    }

    public CiudadBean getObj_ciudad() {
        return obj_ciudad;
    }

    public void setObj_ciudad(CiudadBean obj_ciudad) {
        this.obj_ciudad = obj_ciudad;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public BarrioBean fill(ResultSet oResultSet, Connection oConnection, Integer expand) throws Exception {
        this.setId(oResultSet.getInt("id"));
        this.setCodpostal(oResultSet.getInt("codpostal"));
        this.setDesc(oResultSet.getString("desc"));
        if (expand > 0) {
            DaoInterface oCiudadDao = DaoFactory.getDao(oConnection, "ciudad");
            this.setObj_ciudad((CiudadBean) oCiudadDao.get(oResultSet.getInt("id_ciudad"), expand - 1));
        } else {
            this.setId_ciudad(oResultSet.getInt("id_ciudad"));
        }
        return this;
    }

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "barrio.id,";
        strColumns += "barrio.desc,";
        strColumns += "barrio.codpostal,";
        strColumns += "barrio.id_ciudad";
        return strColumns;
    }

    @Override
    public String getValues() {

        if (id_ciudad == 0) {
            id_ciudad = obj_ciudad.getId();
        }

        String strColumns = "";
        strColumns += "null,";
        strColumns += EncodingHelper.quotate(desc) + ",";
        strColumns += codpostal + ",";
        strColumns += id_ciudad;
        return strColumns;
    }

    @Override
    public String getPairs() {

        if (id_ciudad == 0) {
            id_ciudad = obj_ciudad.getId();
        }
        
        String strPairs = "";
        strPairs += "barrio.id=" + id + ",";
        strPairs += "barrio.desc=" + desc + ",";
        strPairs += "barrio.codpostal=" + codpostal;
        strPairs += "barrio.id_ciudad=" + id_ciudad;
        strPairs += " WHERE barrio.id=" + id;
        return strPairs;
    }
}
