package net.ramon.service;

import javax.servlet.http.HttpServletRequest;
import net.ramon.service.genericServiceImplementation.GenericServiceImplementation;
import net.ramon.service.publicServiceInterface.ServiceInterface;

public class TipousuarioService extends GenericServiceImplementation implements ServiceInterface {

    public TipousuarioService(HttpServletRequest oRequest) {
        super(oRequest);
        ob = oRequest.getParameter("ob");
    }
}
