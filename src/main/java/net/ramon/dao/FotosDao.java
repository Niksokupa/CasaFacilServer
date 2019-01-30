package net.ramon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.ramon.dao.genericDaoImplementation.GenericDaoImplementation;
import net.ramon.dao.publicDaoInterface.DaoInterface;

/**
 *
 * @author Ramón
 */
public class FotosDao extends GenericDaoImplementation implements DaoInterface {

    public FotosDao(Connection oConnection, String ob) {
        super(oConnection, ob);
    }

    public int getcountspecific(int id) throws Exception {
        String strSQL = "SELECT COUNT(id) FROM " + ob + " WHERE id_anuncio=" + id;
        int res = 0;
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                res = oResultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new Exception("Error en Dao get de " + ob, e);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return res;
    }
}
