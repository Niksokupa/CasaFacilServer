package net.ramon.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import net.ramon.bean.ReplyBean;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.connection.publicinterface.ConnectionInterface;
import net.ramon.constant.ConnectionConstants;
import net.ramon.dao.BarrioDao;
import net.ramon.dao.ExtrasDao;
import net.ramon.factory.ConnectionFactory;
import net.ramon.service.genericServiceImplementation.GenericServiceImplementation;
import net.ramon.service.publicServiceInterface.ServiceInterface;

public class BarrioService extends GenericServiceImplementation implements ServiceInterface {

    public BarrioService(HttpServletRequest oRequest) {
        super(oRequest);
        ob = oRequest.getParameter("ob");
    }

    public ReplyBean getall() throws Exception {
        ReplyBean oReplyBean;
        ConnectionInterface oConnectionPool = null;
        Connection oConnection;
        try {
            oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
            Integer ciudad = Integer.parseInt(oRequest.getParameter("ciudad"));
            oConnection = oConnectionPool.newConnection();
            BarrioDao oBarrioDao = new BarrioDao(oConnection, ob);
            ArrayList<BeanInterface> oBean = oBarrioDao.getall(1, ciudad);
            Gson oGson = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();
            oReplyBean = new ReplyBean(200, oGson.toJson(oBean));
        } catch (Exception ex) {
            throw new Exception("ERROR: Service level: get method: " + ob + " object", ex);
        } finally {
            oConnectionPool.disposeConnection();
        }
        return oReplyBean;
    }
}
