/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ramon.factory;

import java.sql.Connection;
import net.ramon.dao.BarrioDao;
import net.ramon.dao.CiudadDao;
import net.ramon.dao.ExtrasDao;
import net.ramon.dao.FotosDao;
import net.ramon.dao.TipoinmuebleDao;
import net.ramon.dao.TipousuarioDao;
import net.ramon.dao.TipoviaDao;
import net.ramon.dao.UsuarioDao;
import net.ramon.dao.publicDaoInterface.DaoInterface;

/**
 *
 * @author Ramón
 */
public class DaoFactory {

    public static DaoInterface getDao(Connection oConnection, String ob) {
        DaoInterface oDao = null;
        switch (ob) {
            case "usuario":
                oDao = new UsuarioDao(oConnection, ob);
                break;
            case "tipousuario":
                oDao = new TipousuarioDao(oConnection, ob);
                break;
            case "tipoinmueble":
                oDao = new TipoinmuebleDao(oConnection, ob);
                break;
            case "tipovia":
                oDao = new TipoviaDao(oConnection, ob);
                break;
            case "ciudad":
                oDao = new CiudadDao(oConnection, ob);
                break;
            case "barrio":
                oDao = new BarrioDao(oConnection, ob);
                break;
            case "extras":
                oDao = new ExtrasDao(oConnection, ob);
                break;
            case "fotos":
                oDao = new FotosDao(oConnection, ob);
                break;
//            case "tipoproducto":
//                oDao = new TipoproductoDao(oConnection, ob);
//                break;
//            case "producto":
//                oDao = new ProductoDao(oConnection, ob);
//                break;
//            case "factura":
//                oDao = new FacturaDao(oConnection, ob);
//                break;
//            case "linea":
//                oDao = new LineaDao(oConnection, ob);
//                break;
        }
        return oDao;
    }
}
