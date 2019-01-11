package net.ramon.service;

import javax.servlet.http.HttpServletRequest;
import net.ramon.service.genericServiceImplementation.GenericServiceImplementation;
import net.ramon.service.publicServiceInterface.ServiceInterface;

public class BarrioService extends GenericServiceImplementation implements ServiceInterface {

    public BarrioService(HttpServletRequest oRequest) {
        super(oRequest);
        ob = oRequest.getParameter("ob");
    }
}
