package net.ramon.bean;

import java.sql.Connection;
import java.sql.ResultSet;

import com.google.gson.annotations.Expose;
import net.ramon.bean.genericBeanInterface.GenericBeanImplementation;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.helper.EncodingHelper;

public class ExtrasBean extends GenericBeanImplementation implements BeanInterface{

    @Expose
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public ExtrasBean fill(ResultSet oResultSet, Connection oConnection, Integer expand) throws Exception {
        this.setId(oResultSet.getInt("id"));
        this.setDesc(oResultSet.getString("desc"));
        return this;
    }

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "extras.id,";
        strColumns += "extras.desc";
        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += "null,";
        strColumns += EncodingHelper.quotate(desc);
        return strColumns;
    }

    @Override
    public String getPairs() {
        String strPairs = "";
        strPairs += "extras.id=" + id + ",";
        strPairs += "extras.desc=" + desc;
        strPairs += " WHERE extras.id=" + id;
        return strPairs;
    }
}
