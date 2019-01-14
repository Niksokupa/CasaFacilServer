package net.ramon.service;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import net.ramon.bean.ReplyBean;
import net.ramon.connection.publicinterface.ConnectionInterface;
import net.ramon.constant.ConnectionConstants;
import net.ramon.factory.ConnectionFactory;
import net.ramon.service.genericServiceImplementation.GenericServiceImplementation;
import net.ramon.service.publicServiceInterface.ServiceInterface;

public class AnuncioService extends GenericServiceImplementation implements ServiceInterface {

    public AnuncioService(HttpServletRequest oRequest) {
        super(oRequest);
        ob = oRequest.getParameter("ob");
    }

    @Override
    public ReplyBean create() throws Exception {
        ReplyBean oReplyBean;
        ConnectionInterface oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
        Connection oConnection = oConnectionPool.newConnection();
        try {
            oConnection.setAutoCommit(false);
            //Recojo los datos del anuncio
            String strJsonAnuncioFromClient = oRequest.getParameter("anuncio");
            //Recojo los nombres de la foto
            String strJsonExtrasFromClient = oRequest.getParameter("extras");
            //Recojo las ID's de los extras
            String strJsonFotosFromClient = oRequest.getParameter("fotos");
            if(strJsonFotosFromClient != null){
                
            }
        } catch (Exception ex) {
            throw new Exception("ERROR: Service level: create method: " + ob + " object", ex);
        } finally {
            oConnectionPool.disposeConnection();
        }
        return oReplyBean;
    }
}
