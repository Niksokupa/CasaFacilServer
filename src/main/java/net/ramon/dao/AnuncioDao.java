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

    public ArrayList<BeanInterface> getpagefiltered(int iRpp, int iPage, HashMap<String, String> hmOrder, int ciudad, Integer expand) throws Exception {
        String strSQL = "SELECT * FROM " + ob + ",barrio ";
        strSQL += SqlBuilder.buildSqlOrder(hmOrder);
        ArrayList<BeanInterface> alBean;
        strSQL += " WHERE barrio.id_ciudad = " + ciudad + " AND " + ob + ".id_barrio=barrio.id";
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
}
