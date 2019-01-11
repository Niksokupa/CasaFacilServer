/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ramon.factory;

import com.google.gson.Gson;
import net.ramon.bean.BarrioBean;
import net.ramon.bean.CiudadBean;
import net.ramon.bean.ExtrasBean;
import net.ramon.bean.FotosBean;
import net.ramon.bean.TipoinmuebleBean;
import net.ramon.bean.TipousuarioBean;
import net.ramon.bean.TipoviaBean;
import net.ramon.bean.UsuarioBean;
import net.ramon.bean.publicBeanInterface.BeanInterface;

/**
 *
 * @author Ramón
 */
public class BeanFactory {

    public static BeanInterface getBean(String ob) {
        BeanInterface oBean = null;
        switch (ob) {
            case "usuario":
                oBean = new UsuarioBean();
                break;
            case "tipousuario":
                oBean = new TipousuarioBean();
                break;
            case "tipovia":
                oBean = new TipoviaBean();
                break;
            case "tipoinmueble":
                oBean = new TipoinmuebleBean();
                break;
            case "ciudad":
                oBean = new CiudadBean();
                break;
            case "barrio":
                oBean = new BarrioBean();
                break;
            case "extras":
                oBean = new ExtrasBean();
                break;
            case "fotos":
                oBean = new FotosBean();
                break;
//            case "tipoproducto":
//                oBean = new TipoproductoBean();
//                break;
//            case "producto":
//                oBean = new ProductoBean();
//                break;
//            case "anuncio":
//                oBean = new AnuncioBean();
//                break;
//            case "linea":
//                oBean = new LineaBean();
//                break;
        }
        return oBean;
    }
    
    public static BeanInterface getBeanFromJson(String ob, Gson oGson, String strJsonFromClient) {
        BeanInterface oBean = null;
        switch (ob) {
            case "usuario":
                oBean = oGson.fromJson(strJsonFromClient, UsuarioBean.class);
                break;
            case "tipousuario":
                oBean = oGson.fromJson(strJsonFromClient, TipousuarioBean.class);
                break;
            case "tipoinmueble":
                oBean = oGson.fromJson(strJsonFromClient, TipoinmuebleBean.class);
                break;
            case "tipovia":
                oBean = oGson.fromJson(strJsonFromClient, TipoviaBean.class);
                break;
            case "extras":
                oBean = oGson.fromJson(strJsonFromClient, ExtrasBean.class);
                break;
            case "fotos":
                oBean = oGson.fromJson(strJsonFromClient, FotosBean.class);
                break;
            case "ciudad":
                oBean = oGson.fromJson(strJsonFromClient, CiudadBean.class);
                break;
            case "barrio":
                oBean = oGson.fromJson(strJsonFromClient, BarrioBean.class);
                break;
//            case "tipoproducto":
//                oBean = oGson.fromJson(strJsonFromClient, TipoproductoBean.class);
//                break;
//            case "producto":
//                oBean = oGson.fromJson(strJsonFromClient, ProductoBean.class);
//                break;
//            case "factura":
//                oBean = oGson.fromJson(strJsonFromClient, FacturaBean.class);
//                break;
//            case "linea":
//                oBean = oGson.fromJson(strJsonFromClient, LineaBean.class);
//                break;
        }
        return oBean;
    }
}
