package net.ramon.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import net.ramon.bean.ExtrasAnuncioBean;
import net.ramon.bean.FotosBean;
import net.ramon.bean.ReplyBean;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.connection.publicinterface.ConnectionInterface;
import net.ramon.constant.ConnectionConstants;
import net.ramon.dao.ExtrasAnuncioDao;
import net.ramon.dao.FotosDao;
import net.ramon.dao.publicDaoInterface.DaoInterface;
import net.ramon.factory.BeanFactory;
import net.ramon.factory.ConnectionFactory;
import net.ramon.factory.DaoFactory;
import net.ramon.service.genericServiceImplementation.GenericServiceImplementation;
import net.ramon.service.publicServiceInterface.ServiceInterface;

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

            if (strJsonExtrasFromClient != null) {
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
            if (strJsonFotosFromClient != null) {
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
                    //Falta poner el addImage de FotosService cuando sepa como funciona desde Angular7
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
}
