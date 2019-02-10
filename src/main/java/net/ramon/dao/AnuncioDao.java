package net.ramon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.dao.genericDaoImplementation.GenericDaoImplementation;
import net.ramon.dao.publicDaoInterface.DaoInterface;
import net.ramon.factory.BeanFactory;
import net.ramon.helper.EncodingHelper;
import net.ramon.helper.SqlBuilder;

/**
 *
 * @author Ramón
 */
public class AnuncioDao extends GenericDaoImplementation implements DaoInterface {

    public AnuncioDao(Connection oConnection, String ob) {
        super(oConnection, ob);
    }

    public ArrayList<BeanInterface> getpagefiltered(int iRpp, int iPage, HashMap<String, String> hmOrder, int ciudad, Integer barrio, String extras, Integer expand) throws Exception {
        String strSQL = "SELECT DISTINCT a.* FROM anuncio a, barrio b ";
        //Si vienen extras añadimos la tabla
        if (extras != null) {
            strSQL += ", extras_anuncio e";
        }
//        if(barrio != null) {
//            strSQL += ", barrio b";
//        }

        ArrayList<BeanInterface> alBean;
        strSQL += " WHERE ";
        strSQL += " b.id_ciudad = " + ciudad + " AND a.id_barrio = b.id";
        //Si viene barrio añadimos filtro
        if (barrio != null) {
            strSQL += " AND b.id = " + barrio;
        }
        //Si vienen extras añadimos filtro
        if (extras != null) {
            strSQL += " AND e.id_extras IN(" + extras + ") AND a.id = e.id_anuncio";
        }

        strSQL += SqlBuilder.buildSqlOrder(hmOrder);
        if (iRpp > 0 && iRpp < 100000 && iPage > 0 && iPage < 100000000) {
            strSQL += " LIMIT " + (iPage - 1) * iRpp + ", " + iRpp;
            ResultSet oResultSet = null;
            PreparedStatement oPreparedStatement = null;
            try {
                oPreparedStatement = oConnection.prepareStatement(strSQL);
                oResultSet = oPreparedStatement.executeQuery();
                alBean = new ArrayList<BeanInterface>();
                while (oResultSet.next()) {
                    BeanInterface oBean = BeanFactory.getBean(ob);
                    oBean.fill(oResultSet, oConnection, expand);
                    alBean.add(oBean);
                }
            } catch (SQLException e) {
                throw new Exception("Error en Dao getpage de " + ob, e);
            } finally {
                if (oResultSet != null) {
                    oResultSet.close();
                }
                if (oPreparedStatement != null) {
                    oPreparedStatement.close();
                }
            }
        } else {
            throw new Exception("Error en Dao getpage de " + ob);
        }
        return alBean;
    }

    public ArrayList<BeanInterface> getpagespecific(int iRpp, int iPage, HashMap<String, String> hmOrder, Integer id, Integer expand) throws Exception {
        String strSQL = "SELECT a.* FROM anuncio a WHERE a.id_usuario = " + id;
        strSQL += SqlBuilder.buildSqlOrder(hmOrder);
        ArrayList<BeanInterface> alBean;
        if (iRpp > 0 && iRpp < 100000 && iPage > 0 && iPage < 100000000) {
            strSQL += " LIMIT " + (iPage - 1) * iRpp + ", " + iRpp;
            ResultSet oResultSet = null;
            PreparedStatement oPreparedStatement = null;
            try {
                oPreparedStatement = oConnection.prepareStatement(strSQL);
                oResultSet = oPreparedStatement.executeQuery();
                alBean = new ArrayList<BeanInterface>();
                while (oResultSet.next()) {
                    BeanInterface oBean = BeanFactory.getBean("anuncio");
                    oBean.fill(oResultSet, oConnection, expand);
                    alBean.add(oBean);
                }
            } catch (SQLException e) {
                throw new Exception("Error en Dao getpage de " + ob, e);
            } finally {
                if (oResultSet != null) {
                    oResultSet.close();
                }
                if (oPreparedStatement != null) {
                    oPreparedStatement.close();
                }
            }
        } else {
            throw new Exception("Error en Dao getpage de " + ob);
        }
        return alBean;
    }
}
