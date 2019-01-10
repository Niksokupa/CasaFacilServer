package net.ramon.factory;

import javax.servlet.http.HttpServletRequest;

import net.ramon.bean.ReplyBean;
import net.ramon.bean.UsuarioBean;
import net.ramon.service.TipousuarioService;
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
