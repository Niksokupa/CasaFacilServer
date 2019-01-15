package net.ramon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.ramon.bean.ExtrasAnuncioBean;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.dao.genericDaoImplementation.GenericDaoImplementation;
import net.ramon.dao.publicDaoInterface.DaoInterface;

/**
 *
 * @author Ramón
 */
public class ExtrasAnuncioDao extends GenericDaoImplementation implements DaoInterface {

    public ExtrasAnuncioDao(Connection oConnection, String ob) {
        super(oConnection, ob);
    }

    public ExtrasAnuncioBean create(ExtrasAnuncioBean oBean) throws Exception {
        String strSQL = "INSERT INTO " + ob;
        strSQL += "(" + oBean.getColumns() + ")";
        strSQL += " VALUES ";
        strSQL += "(" + oBean.getValues() + ")";
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.executeUpdate();
            oResultSet = oPreparedStatement.getGeneratedKeys();
//            if (oResultSet.next()) {
//                oBean.setId(oResultSet.getInt(1));
//            } else {
//                oBean.setId(0);
//            }
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
