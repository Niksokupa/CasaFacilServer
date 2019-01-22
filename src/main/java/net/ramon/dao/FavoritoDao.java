package net.ramon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.dao.genericDaoImplementation.GenericDaoImplementation;
import net.ramon.dao.publicDaoInterface.DaoInterface;

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
}
