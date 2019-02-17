package net.ramon.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.ramon.bean.ExtrasAnuncioBean;
import net.ramon.bean.FotosBean;
import net.ramon.bean.ReplyBean;
import net.ramon.bean.UsuarioBean;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.connection.publicinterface.ConnectionInterface;
import net.ramon.constant.ConnectionConstants;
import net.ramon.dao.AnuncioDao;
import net.ramon.dao.ExtrasAnuncioDao;
import net.ramon.dao.FavoritoDao;
import net.ramon.dao.FotosDao;
import net.ramon.dao.publicDaoInterface.DaoInterface;
import net.ramon.factory.BeanFactory;
import net.ramon.factory.ConnectionFactory;
import net.ramon.factory.DaoFactory;
import net.ramon.helper.ParameterCook;
import net.ramon.service.genericServiceImplementation.GenericServiceImplementation;
import net.ramon.service.publicServiceInterface.ServiceInterface;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class AnuncioService extends GenericServiceImplementation implements ServiceInterface {

    public AnuncioService(HttpServletRequest oRequest) {
        super(oRequest);
        ob = oRequest.getParameter("ob");
    }

    @Override
    public ReplyBean create() throws Exception {
        ReplyBean oReplyBean = null;
        ConnectionInterface oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
        Connection oConnection = oConnectionPool.newConnection();
        try {
            oConnection.setAutoCommit(false);
            Gson oGson = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();
            String delimiter = "\\,";
            //Recojo los datos del anuncio
            String strJsonAnuncioFromClient = oRequest.getParameter("anuncio");
            //Recojo los ID de los extras
            String strJsonExtrasFromClient = oRequest.getParameter("extras");
            //Recojo los nombres de las fotos
            String strJsonFotosFromClient = oRequest.getParameter("fotos");

            BeanInterface oBeanAnuncio = BeanFactory.getBeanFromJson(ob, oGson, strJsonAnuncioFromClient);
            DaoInterface oDao = DaoFactory.getDao(oConnection, ob);
            oBeanAnuncio = oDao.create(oBeanAnuncio);

            if (strJsonExtrasFromClient != null && !strJsonExtrasFromClient.equals("[]")) {
                strJsonExtrasFromClient = strJsonExtrasFromClient.replace("[", "");
                strJsonExtrasFromClient = strJsonExtrasFromClient.replace("]", "");
                //Aquí tengo un array con todos los extras elegidos para el anuncio.
                String extrasArray[] = strJsonExtrasFromClient.split(delimiter);
                for (int i = 0; i < extrasArray.length; i++) {
                    ExtrasAnuncioBean extrasAnuncioBean = new ExtrasAnuncioBean();
                    extrasAnuncioBean.setId_anuncio(oBeanAnuncio.getId());
                    extrasAnuncioBean.setId_extras(Integer.parseInt(extrasArray[i]));
                    ExtrasAnuncioDao extrasAnuncioDao = new ExtrasAnuncioDao(oConnection, "extras_anuncio");
                    extrasAnuncioBean = (ExtrasAnuncioBean) extrasAnuncioDao.create(extrasAnuncioBean);
                }
            }
            if (strJsonFotosFromClient != null && !strJsonFotosFromClient.equals("[]")) {
                strJsonFotosFromClient = strJsonFotosFromClient.replace("[", "");
                strJsonFotosFromClient = strJsonFotosFromClient.replace("\"", "");
                strJsonFotosFromClient = strJsonFotosFromClient.replace("]", "");
                //Aquí tengo un array con todos los nombres elegidos para cada foto.
                String fotosArray[] = strJsonFotosFromClient.split(delimiter);
                for (int i = 0; i < fotosArray.length; i++) {
                    FotosBean fotosBean = new FotosBean();
                    fotosBean.setRuta(fotosArray[i]);
                    fotosBean.setId_anuncio(oBeanAnuncio.getId());
                    FotosDao fotosDao = new FotosDao(oConnection, "fotos");
                    fotosBean = (FotosBean) fotosDao.create(fotosBean);
                }
            }
            oConnection.commit();
            oReplyBean = new ReplyBean(200, oGson.toJson(oBeanAnuncio));
        } catch (Exception ex) {
            throw new Exception("ERROR: Service level: create method: " + ob + " object", ex);
        } finally {
            oConnectionPool.disposeConnection();
        }
        return oReplyBean;
    }

    @Override
    public ReplyBean getpage() throws Exception {
        ReplyBean oReplyBean;
        ConnectionInterface oConnectionPool = null;
        Connection oConnection;
        try {
            Integer iRpp = Integer.parseInt(oRequest.getParameter("rpp"));
            Integer iPage = Integer.parseInt(oRequest.getParameter("page"));
            Integer ciudad = Integer.parseInt(oRequest.getParameter("ciudad"));
            Integer barrio = null;
            String extras = null;
            String prueba = oRequest.getParameter("barrio");
            if (oRequest.getParameter("barrio") != null && !prueba.equals("undefined")) {
                barrio = Integer.parseInt(oRequest.getParameter("barrio"));
            }
            if (oRequest.getParameter("extras") != null && !"undefined".equals(oRequest.getParameter("extras")) && !"".equals(oRequest.getParameter("extras"))) {
                extras = oRequest.getParameter("extras");
            }
            HashMap<String, String> hmOrder = ParameterCook.getOrderParams(oRequest.getParameter("order"));
            oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
            oConnection = oConnectionPool.newConnection();
            AnuncioDao anuncioDao = new AnuncioDao(oConnection, "anuncio");
            ArrayList<BeanInterface> alBean = anuncioDao.getpagefiltered(iRpp, iPage, hmOrder, ciudad, barrio, extras, 1);
            Gson oGson = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();
            oReplyBean = new ReplyBean(200, oGson.toJson(alBean));
        } catch (Exception ex) {
            throw new Exception("ERROR: Service level: get page: " + ob + " object", ex);
        } finally {
            oConnectionPool.disposeConnection();
        }
        return oReplyBean;
    }
    
    public ReplyBean getcountfiltered() throws Exception {
        ReplyBean oReplyBean;
        ConnectionInterface oConnectionPool = null;
        Connection oConnection;
        try {
            Integer iRpp = Integer.parseInt(oRequest.getParameter("rpp"));
            Integer iPage = Integer.parseInt(oRequest.getParameter("page"));
            Integer ciudad = Integer.parseInt(oRequest.getParameter("ciudad"));
            Integer barrio = null;
            String extras = null;
            String prueba = oRequest.getParameter("barrio");
            if (oRequest.getParameter("barrio") != null && !prueba.equals("undefined")) {
                barrio = Integer.parseInt(oRequest.getParameter("barrio"));
            }
            if (oRequest.getParameter("extras") != null && !"undefined".equals(oRequest.getParameter("extras")) && !"".equals(oRequest.getParameter("extras"))) {
                extras = oRequest.getParameter("extras");
            }
            HashMap<String, String> hmOrder = ParameterCook.getOrderParams(oRequest.getParameter("order"));
            oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
            oConnection = oConnectionPool.newConnection();
            AnuncioDao anuncioDao = new AnuncioDao(oConnection, "anuncio");
            int registros = anuncioDao.getcountfiltered(hmOrder, ciudad, barrio, extras);
            Gson oGson = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();
            oReplyBean = new ReplyBean(200, oGson.toJson(registros));
        } catch (Exception ex) {
            throw new Exception("ERROR: Service level: get page: " + ob + " object", ex);
        } finally {
            oConnectionPool.disposeConnection();
        }
        return oReplyBean;
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
            AnuncioDao oAnuncioDao = new AnuncioDao(oConnection, "anuncio");
            ArrayList<BeanInterface> alBean = oAnuncioDao.getpagespecific(iRpp, iPage, hmOrder, id, 1);
            Gson oGson = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();
            oReplyBean = new ReplyBean(200, oGson.toJson(alBean));
        } catch (Exception ex) {
            throw new Exception("ERROR: Service level: get page: " + ob + " object", ex);
        } finally {
            oConnectionPool.disposeConnection();
        }
        return oReplyBean;
    }

    public ReplyBean update() throws Exception {
        int iRes = 0;
        ReplyBean oReplyBean;
        ConnectionInterface oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
        Connection oConnection = oConnectionPool.newConnection();
        try {
            oConnection.setAutoCommit(false);
            String delimiter = "\\,";
            //Recojo los datos del anuncio
            String strJsonAnuncioFromClient = oRequest.getParameter("anuncio");
            //Recojo los ID de los extras
            String strJsonExtrasFromClient = oRequest.getParameter("extras");
            //Recojo los nombres de las fotos
            String strJsonFotosFromClient = oRequest.getParameter("fotos");
            Gson oGson = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();
            BeanInterface oBeanAnuncio = BeanFactory.getBeanFromJson(ob, oGson, strJsonAnuncioFromClient);
            DaoInterface oDao = DaoFactory.getDao(oConnection, ob);
            iRes = oDao.update(oBeanAnuncio);

            if (strJsonExtrasFromClient != null && !strJsonExtrasFromClient.equals("[]")) {
                strJsonExtrasFromClient = strJsonExtrasFromClient.replace("[", "");
                strJsonExtrasFromClient = strJsonExtrasFromClient.replace("]", "");
                //Aquí tengo un array con todos los extras elegidos para el anuncio.
                String extrasArray[] = strJsonExtrasFromClient.split(delimiter);
                ExtrasAnuncioDao extrasAnuncioDao = new ExtrasAnuncioDao(oConnection, "extras_anuncio");
                iRes = extrasAnuncioDao.remove(oBeanAnuncio.getId());
                for (int i = 0; i < extrasArray.length; i++) {
                    ExtrasAnuncioBean extrasAnuncioBean = new ExtrasAnuncioBean();
                    extrasAnuncioBean.setId_anuncio(oBeanAnuncio.getId());
                    extrasAnuncioBean.setId_extras(Integer.parseInt(extrasArray[i]));
                    iRes = extrasAnuncioDao.remove(oBeanAnuncio.getId());
                    extrasAnuncioBean = (ExtrasAnuncioBean) extrasAnuncioDao.create(extrasAnuncioBean);
                }
            } else {
                ExtrasAnuncioDao extrasAnuncioDao = new ExtrasAnuncioDao(oConnection, "extras_anuncio");
                iRes = extrasAnuncioDao.remove(oBeanAnuncio.getId());
            }
            if (strJsonFotosFromClient != null && !strJsonFotosFromClient.equals("[]")) {
                strJsonFotosFromClient = strJsonFotosFromClient.replace("[", "");
                strJsonFotosFromClient = strJsonFotosFromClient.replace("\"", "");
                strJsonFotosFromClient = strJsonFotosFromClient.replace("]", "");
                //Aquí tengo un array con todos los nombres elegidos para cada foto.
                String fotosArray[] = strJsonFotosFromClient.split(delimiter);
                for (int i = 0; i < fotosArray.length; i++) {
                    FotosBean fotosBean = new FotosBean();
                    fotosBean.setRuta(fotosArray[i]);
                    fotosBean.setId_anuncio(oBeanAnuncio.getId());
                    FotosDao fotosDao = new FotosDao(oConnection, "fotos");
                    fotosBean = (FotosBean) fotosDao.create(fotosBean);
                }
            }

            oConnection.commit();
            oReplyBean = new ReplyBean(200, Integer.toString(iRes));
        } catch (Exception ex) {
            throw new Exception("ERROR: Service level: update method: " + ob + " object", ex);
        } finally {
            oConnectionPool.disposeConnection();
        }
        return oReplyBean;
    }

    public ReplyBean addimage() throws Exception {

        String name = "";
        ReplyBean oReplyBean;
        Gson oGson = new Gson();

        HashMap<String, String> hash = new HashMap<>();

        if (ServletFileUpload.isMultipartContent(oRequest)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(oRequest);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        name = new File(item.getName()).getName();
                        //Creo la carpeta con la ID de usuario
                        (new File(".//..//webapps//imagenes//" + ((UsuarioBean) oRequest.getSession().getAttribute("user")).getId())).mkdirs();
                        item.write(new File(".//..//webapps//imagenes//" + ((UsuarioBean) oRequest.getSession().getAttribute("user")).getId() + "//" + name));
                    } else {
                        hash.put(item.getFieldName(), item.getString());
                    }
                }
                oReplyBean = new ReplyBean(200, oGson.toJson("File upload: " + name));
            } catch (Exception ex) {
                oReplyBean = new ReplyBean(500, oGson.toJson("Error while uploading file: " + name));
            }
        } else {
            oReplyBean = new ReplyBean(500, oGson.toJson("Can't read image"));
        }

        return oReplyBean;
    }
}
