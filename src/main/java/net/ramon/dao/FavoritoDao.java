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
import net.ramon.helper.SqlBuilder;

/**
 *
 * @author Ramón
 */
public class FavoritoDao extends GenericDaoImplementation implements DaoInterface {

    public FavoritoDao(Connection oConnection, String ob) {
        super(oConnection, ob);
    }

    @Override
    public BeanInterface create(BeanInterface oBean) throws Exception {
        String strSQL = "INSERT INTO " + ob;
        strSQL += "(" + oBean.getColumns() + ")";
        strSQL += " VALUES ";
        strSQL += "(" + oBean.getValues() + ")";
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error en Dao create de " + ob, e);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return oBean;
    }
    
    
    public int removefav(int id_anuncio, int id_usuario) throws Exception {
        int iRes = 0;
        String strSQL = "DELETE FROM " + ob + " WHERE id_anuncio=? AND id_usuario=?";
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setInt(1, id_anuncio);
            oPreparedStatement.setInt(2, id_usuario);
            iRes = oPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error en Dao remove de " + ob, e);
        } finally {
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iRes;
    }

    public ArrayList<BeanInterface> getpagespecific(int iRpp, int iPage, HashMap<String, String> hmOrder, Integer id, Integer expand) throws Exception {
        String strSQL = "SELECT a.* FROM anuncio a, favorito f, usuario u WHERE f.id_usuario = " + id;
        strSQL += " AND u.id = " + id + " AND a.id = f.id_anuncio";
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
