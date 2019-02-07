package net.ramon.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import net.ramon.bean.ReplyBean;
import net.ramon.bean.UsuarioBean;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.connection.publicinterface.ConnectionInterface;
import net.ramon.constant.ConnectionConstants;
import net.ramon.dao.FotosDao;
import net.ramon.factory.ConnectionFactory;
import net.ramon.service.genericServiceImplementation.GenericServiceImplementation;
import net.ramon.service.publicServiceInterface.ServiceInterface;

public class FotosService extends GenericServiceImplementation implements ServiceInterface {

    public FotosService(HttpServletRequest oRequest) {
        super(oRequest);
        ob = oRequest.getParameter("ob");
    }

    public ReplyBean getall() throws Exception {
        ReplyBean oReplyBean;
        ConnectionInterface oConnectionPool = null;
        Connection oConnection;
        try {
            Integer id = Integer.parseInt(oRequest.getParameter("id"));
            oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
            oConnection = oConnectionPool.newConnection();
            FotosDao oFotosDao = new FotosDao(oConnection, ob);
            ArrayList<BeanInterface> oBean = oFotosDao.getall(1, id);
            Gson oGson = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();
            oReplyBean = new ReplyBean(200, oGson.toJson(oBean));
        } catch (Exception ex) {
            throw new Exception("ERROR: Service level: get method: " + ob + " object", ex);
        } finally {
            oConnectionPool.disposeConnection();
        }
        return oReplyBean;
    }

    public ReplyBean removeimage() throws Exception {

        String ruta = oRequest.getParameter("ruta");
        String dir = System.getProperty("user.dir");
        dir = dir.substring(0, dir.length() - 4);
        Path rutaCompleta = Paths.get(dir + "/webapps/imagenes/" + ((UsuarioBean) oRequest.getSession().getAttribute("user")).getId() + "/" + ruta);
        ReplyBean oReplyBean = null;
        try {
            Files.delete(rutaCompleta);
            oReplyBean = new ReplyBean(200, "Imagen borrada con éxito ");
        } catch (IOException e) {
            oReplyBean = new ReplyBean(200, e.toString());
        }

        return oReplyBean;
    }

}
