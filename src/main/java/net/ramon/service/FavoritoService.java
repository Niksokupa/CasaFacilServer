package net.ramon.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import net.ramon.bean.ReplyBean;
import net.ramon.bean.UsuarioBean;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.connection.publicinterface.ConnectionInterface;
import net.ramon.constant.ConnectionConstants;
import net.ramon.dao.FavoritoDao;
import net.ramon.factory.ConnectionFactory;
import net.ramon.helper.ParameterCook;
import net.ramon.service.genericServiceImplementation.GenericServiceImplementation;
import net.ramon.service.publicServiceInterface.ServiceInterface;

public class FavoritoService extends GenericServiceImplementation implements ServiceInterface {

    public FavoritoService(HttpServletRequest oRequest) {
        super(oRequest);
        ob = oRequest.getParameter("ob");
    }

    public ReplyBean getpagespecific() throws Exception {
        ReplyBean oReplyBean;
        ConnectionInterface oConnectionPool = null;
        Connection oConnection;
        try {
            Integer iRpp = Integer.parseInt(oRequest.getParameter("rpp"));
            Integer iPage = Integer.parseInt(oRequest.getParameter("page"));
            Integer id = ((UsuarioBean) oRequest.getSession().getAttribute("user")).getId();
            HashMap<String, String> hmOrder = ParameterCook.getOrderParams(oRequest.getParameter("order"));
            oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
            oConnection = oConnectionPool.newConnection();
            FavoritoDao oFavoritoDao = new FavoritoDao(oConnection, "favorito");
            ArrayList<BeanInterface> alBean = oFavoritoDao.getpagespecific(iRpp, iPage, hmOrder, id, 1);
            Gson oGson = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();
            oReplyBean = new ReplyBean(200, oGson.toJson(alBean));
        } catch (Exception ex) {
            throw new Exception("ERROR: Service level: get page: " + ob + " object", ex);
        } finally {
            oConnectionPool.disposeConnection();
        }
        return oReplyBean;
    }
    
    public ReplyBean getcountspecific() throws Exception {
        ReplyBean oReplyBean;
        ConnectionInterface oConnectionPool = null;
        Connection oConnection;
        try {
            Integer id = ((UsuarioBean) oRequest.getSession().getAttribute("user")).getId();
            oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
            oConnection = oConnectionPool.newConnection();
            FavoritoDao oFavoritoDao = new FavoritoDao(oConnection, "favorito");
            Integer count = oFavoritoDao.getcountspecific(id);
            Gson oGson = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();
            oReplyBean = new ReplyBean(200, oGson.toJson(count));
        } catch (Exception ex) {
            throw new Exception("ERROR: Service level: get page: " + ob + " object", ex);
        } finally {
            oConnectionPool.disposeConnection();
        }
        return oReplyBean;
    }

    @Override
    public ReplyBean remove() throws Exception {
        ReplyBean oReplyBean;
        ConnectionInterface oConnectionPool = null;
        Connection oConnection;
        try {
            Integer id_anuncio = Integer.parseInt(oRequest.getParameter("id_anuncio"));
            Integer id_usuario = ((UsuarioBean) oRequest.getSession().getAttribute("user")).getId();
            oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
            oConnection = oConnectionPool.newConnection();
            FavoritoDao oFavoritoDao = new FavoritoDao(oConnection, ob);
            int iRes = oFavoritoDao.removefav(id_anuncio, id_usuario);
            oReplyBean = new ReplyBean(200, Integer.toString(iRes));
        } catch (Exception ex) {
            throw new Exception("ERROR: Service level: remove method: " + ob + " object", ex);
        } finally {
            oConnectionPool.disposeConnection();
        }
        return oReplyBean;
    }
}
