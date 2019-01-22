package net.ramon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.dao.genericDaoImplementation.GenericDaoImplementation;
import net.ramon.dao.publicDaoInterface.DaoInterface;
import net.ramon.factory.BeanFactory;

/**
 *
 * @author Ramón
 */
public class BarrioDao extends GenericDaoImplementation implements DaoInterface {

    public BarrioDao(Connection oConnection, String ob) {
        super(oConnection, ob);
    }

    public ArrayList<BeanInterface> getall(Integer expand, int ciudad) throws Exception {
        String strSQL = "SELECT * FROM " + ob + " WHERE id_ciudad="+ciudad;
        ArrayList<BeanInterface> alBean;
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
            throw new Exception("Error en Dao get de " + ob, e);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return alBean;
    }
}
