package net.ramon.factory;

import javax.servlet.http.HttpServletRequest;

import net.ramon.bean.ReplyBean;
import net.ramon.bean.UsuarioBean;
import net.ramon.service.AnuncioService;
import net.ramon.service.BarrioService;
import net.ramon.service.CiudadService;
import net.ramon.service.ExtrasService;
import net.ramon.service.FavoritoService;
import net.ramon.service.FotosService;
import net.ramon.service.TipoinmuebleService;
import net.ramon.service.TipousuarioService;
import net.ramon.service.TipoviaService;
import net.ramon.service.UsuarioService;

public class ServiceFactory {

    public static ReplyBean executeService(HttpServletRequest oRequest) throws Exception {

        int tipoUsuario;
        String ob = oRequest.getParameter("ob");
        String op = oRequest.getParameter("op");
        ReplyBean oReplyBean;

        if (ob.equals("usuario") && op.equals("login")) {
            UsuarioService oUsuarioService = new UsuarioService(oRequest);
            oReplyBean = oUsuarioService.login();
        } else {

            UsuarioBean sesion = (UsuarioBean) oRequest.getSession().getAttribute("user");

            if (sesion == null) {
                tipoUsuario = 0;
            } else {
                tipoUsuario = sesion.getObj_tipoUsuario().getId();
            }

            switch (tipoUsuario) {
                case 1:
                    switch (ob) {
                        case "tipousuario":
                            TipousuarioService oTipousuarioService = new TipousuarioService(oRequest);
                            switch (op) {
                                case "get":
                                    oReplyBean = oTipousuarioService.get();
                                    break;
                                case "create":
                                    oReplyBean = oTipousuarioService.create();
                                    break;
                                case "update":
                                    oReplyBean = oTipousuarioService.update();
                                    break;
                                case "remove":
                                    oReplyBean = oTipousuarioService.remove();
                                    break;
                                case "getcount":
                                    oReplyBean = oTipousuarioService.getcount();
                                    break;
                                case "getpage":
                                    oReplyBean = oTipousuarioService.getpage();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "tipoinmueble":
                            TipoinmuebleService oTipoinmuebleService = new TipoinmuebleService(oRequest);
                            switch (op) {
                                case "get":
                                    oReplyBean = oTipoinmuebleService.get();
                                    break;
                                case "create":
                                    oReplyBean = oTipoinmuebleService.create();
                                    break;
                                case "update":
                                    oReplyBean = oTipoinmuebleService.update();
                                    break;
                                case "remove":
                                    oReplyBean = oTipoinmuebleService.remove();
                                    break;
                                case "getcount":
                                    oReplyBean = oTipoinmuebleService.getcount();
                                    break;
                                case "getpage":
                                    oReplyBean = oTipoinmuebleService.getpage();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "tipovia":
                            TipoviaService oTipoviaService = new TipoviaService(oRequest);
                            switch (op) {
                                case "get":
                                    oReplyBean = oTipoviaService.get();
                                    break;
                                case "create":
                                    oReplyBean = oTipoviaService.create();
                                    break;
                                case "update":
                                    oReplyBean = oTipoviaService.update();
                                    break;
                                case "remove":
                                    oReplyBean = oTipoviaService.remove();
                                    break;
                                case "getcount":
                                    oReplyBean = oTipoviaService.getcount();
                                    break;
                                case "getpage":
                                    oReplyBean = oTipoviaService.getpage();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "anuncio":
                            AnuncioService oAnuncioService = new AnuncioService(oRequest);
                            switch (op) {
                                case "get":
                                    oReplyBean = oAnuncioService.get();
                                    break;
                                case "create":
                                    oReplyBean = oAnuncioService.create();
                                    break;
                                case "update":
                                    oReplyBean = oAnuncioService.update();
                                    break;
                                case "remove":
                                    oReplyBean = oAnuncioService.remove();
                                    break;
                                case "getcount":
                                    oReplyBean = oAnuncioService.getcount();
                                    break;
                                case "getpage":
                                    oReplyBean = oAnuncioService.getpage();
                                    break;
                                case "addimage":
                                    oReplyBean = oAnuncioService.addimage();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "extras":
                            ExtrasService oExtrasService = new ExtrasService(oRequest);
                            switch (op) {
                                case "get":
                                    oReplyBean = oExtrasService.get();
                                    break;
                                case "getall":
                                    oReplyBean = oExtrasService.getall();
                                    break;
                                case "create":
                                    oReplyBean = oExtrasService.create();
                                    break;
                                case "update":
                                    oReplyBean = oExtrasService.update();
                                    break;
                                case "remove":
                                    oReplyBean = oExtrasService.remove();
                                    break;
                                case "getcount":
                                    oReplyBean = oExtrasService.getcount();
                                    break;
                                case "getpage":
                                    oReplyBean = oExtrasService.getpage();
                                    break;
                                case "getspecific":
                                    oReplyBean = oExtrasService.getspecific();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "fotos":
                            FotosService oFotosService = new FotosService(oRequest);
                            switch (op) {
                                case "get":
                                    oReplyBean = oFotosService.get();
                                    break;
                                case "create":
                                    oReplyBean = oFotosService.create();
                                    break;
                                case "update":
                                    oReplyBean = oFotosService.update();
                                    break;
                                case "remove":
                                    oReplyBean = oFotosService.remove();
                                    break;
                                case "getcount":
                                    oReplyBean = oFotosService.getcount();
                                    break;
                                case "getpage":
                                    oReplyBean = oFotosService.getpage();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "usuario":
                            UsuarioService oUsuarioService = new UsuarioService(oRequest);
                            switch (op) {
                                case "get":
                                    oReplyBean = oUsuarioService.get();
                                    break;
                                case "create":
                                    oReplyBean = oUsuarioService.create();
                                    break;
                                case "update":
                                    oReplyBean = oUsuarioService.update();
                                    break;
                                case "remove":
                                    oReplyBean = oUsuarioService.remove();
                                    break;
                                case "getcount":
                                    oReplyBean = oUsuarioService.getcount();
                                    break;
                                case "getpage":
                                    oReplyBean = oUsuarioService.getpage();
                                    break;
//                                case "fill":
//                                    oReplyBean = oUsuarioService.fill();
//                                    break;
                                case "logout":
                                    oReplyBean = oUsuarioService.logout();
                                    break;
                                case "check":
                                    oReplyBean = oUsuarioService.check();
                                    break;
                                case "updatepass":
                                    oReplyBean = oUsuarioService.updatePass();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "ciudad":
                            CiudadService oCiudadService = new CiudadService(oRequest);
                            switch (op) {
                                case "get":
                                    oReplyBean = oCiudadService.get();
                                    break;
                                case "create":
                                    oReplyBean = oCiudadService.create();
                                    break;
                                case "update":
                                    oReplyBean = oCiudadService.update();
                                    break;
                                case "remove":
                                    oReplyBean = oCiudadService.remove();
                                    break;
                                case "getcount":
                                    oReplyBean = oCiudadService.getcount();
                                    break;
                                case "getpage":
                                    oReplyBean = oCiudadService.getpage();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "barrio":
                            BarrioService oBarrioService = new BarrioService(oRequest);
                            switch (op) {
                                case "get":
                                    oReplyBean = oBarrioService.get();
                                    break;
                                case "getall":
                                    oReplyBean = oBarrioService.getall();
                                    break;
                                case "create":
                                    oReplyBean = oBarrioService.create();
                                    break;
                                case "update":
                                    oReplyBean = oBarrioService.update();
                                    break;
                                case "remove":
                                    oReplyBean = oBarrioService.remove();
                                    break;
                                case "getcount":
                                    oReplyBean = oBarrioService.getcount();
                                    break;
                                case "getpage":
                                    oReplyBean = oBarrioService.getpage();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        default:
                            oReplyBean = new ReplyBean(500, "Object doesn't exist");
                            break;
                    }
                    break;
                case 2:
                    switch (ob) {
                        case "usuario":
                            UsuarioService oUsuarioService = new UsuarioService(oRequest);
                            switch (op) {
                                case "get":
                                    oReplyBean = oUsuarioService.get();
                                    break;
                                case "create":
                                    oReplyBean = oUsuarioService.create();
                                    break;
                                case "update":
                                    oReplyBean = oUsuarioService.update();
                                    break;
                                case "remove":
                                    oReplyBean = oUsuarioService.remove();
                                    break;
                                case "logout":
                                    oReplyBean = oUsuarioService.logout();
                                    break;
                                case "check":
                                    oReplyBean = oUsuarioService.check();
                                    break;
                                case "updatepass":
                                    oReplyBean = oUsuarioService.updatePass();
                                    break;
                                case "profile":
                                    oReplyBean = oUsuarioService.profile();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "favorito":
                            FavoritoService oFavoritoService = new FavoritoService(oRequest);
                            switch (op) {
                                case "get":
                                    oReplyBean = oFavoritoService.get();
                                    break;
                                case "create":
                                    oReplyBean = oFavoritoService.create();
                                    break;
                                case "update":
                                    oReplyBean = oFavoritoService.update();
                                    break;
                                case "remove":
                                    oReplyBean = oFavoritoService.remove();
                                    break;
                                case "getcount":
                                    oReplyBean = oFavoritoService.getcount();
                                    break;
                                case "getpagespecific":
                                    oReplyBean = oFavoritoService.getpagespecific();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "anuncio":
                            AnuncioService oAnuncioService = new AnuncioService(oRequest);
                            switch (op) {
                                case "get":
                                    oReplyBean = oAnuncioService.get();
                                    break;
                                case "create":
                                    oReplyBean = oAnuncioService.create();
                                    break;
                                case "update":
                                    oReplyBean = oAnuncioService.update();
                                    break;
                                case "remove":
                                    oReplyBean = oAnuncioService.remove();
                                    break;
                                case "getcount":
                                    oReplyBean = oAnuncioService.getcount();
                                    break;
                                case "getpage":
                                    oReplyBean = oAnuncioService.getpage();
                                    break;
                                case "getpagespecific":
                                    oReplyBean = oAnuncioService.getpagespecific();
                                    break;
                                case "addimage":
                                    oReplyBean = oAnuncioService.addimage();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "fotos":
                            FotosService oFotosService = new FotosService(oRequest);
                            switch (op) {
                                case "getall":
                                    oReplyBean = oFotosService.getall();
                                    break;
                                case "removeimage":
                                    oReplyBean = oFotosService.removeimage();
                                    break;
                                case "remove":
                                    oReplyBean = oFotosService.remove();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "extras":
                            ExtrasService oExtrasService = new ExtrasService(oRequest);
                            switch (op) {
                                case "getall":
                                    oReplyBean = oExtrasService.getall();
                                    break;
                                case "getspecific":
                                    oReplyBean = oExtrasService.getspecific();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "barrio":
                            BarrioService oBarrioService = new BarrioService(oRequest);
                            switch (op) {
                                case "getall":
                                    oReplyBean = oBarrioService.getall();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        default:
                            oReplyBean = new ReplyBean(500, "Object doesn't exist");
                            break;
                    }
                    break;
                case 0:
                    switch (ob) {
                        case "usuario":
                            UsuarioService oUsuarioService = new UsuarioService(oRequest);
                            switch (op) {
                                case "login":
                                    oReplyBean = oUsuarioService.login();
                                    break;
                                case "check":
                                    oReplyBean = oUsuarioService.check();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "barrio":
                            BarrioService oBarrioService = new BarrioService(oRequest);
                            switch (op) {
                                case "getall":
                                    oReplyBean = oBarrioService.getall();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "extras":
                            ExtrasService oExtrasService = new ExtrasService(oRequest);
                            switch (op) {
                                case "getall":
                                    oReplyBean = oExtrasService.getall();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        case "anuncio":
                            AnuncioService oAnuncioService = new AnuncioService(oRequest);
                            switch (op) {
                                case "get":
                                    oReplyBean = oAnuncioService.get();
                                    break;
                                case "getcount":
                                    oReplyBean = oAnuncioService.getcount();
                                    break;
                                case "getpage":
                                    oReplyBean = oAnuncioService.getpage();
                                    break;
                                default:
                                    oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                    break;
                            }
                            break;
                        default:
                            oReplyBean = new ReplyBean(500, "Object doesn't exist");
                            break;
                    }
                    break;
                default:
                    oReplyBean = new ReplyBean(500, "Error Permisos");
                    break;
            }
        }
        return oReplyBean;
    }
}
