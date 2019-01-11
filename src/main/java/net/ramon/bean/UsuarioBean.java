/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ramon.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import com.google.gson.annotations.Expose;
import net.ramon.bean.genericBeanInterface.GenericBeanImplementation;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.helper.EncodingHelper;
import net.ramon.dao.publicDaoInterface.DaoInterface;
import net.ramon.factory.DaoFactory;

/**
 *
 * @author ramon
 */
public class UsuarioBean extends GenericBeanImplementation implements BeanInterface {

    @Expose
    private String nombre;
    @Expose
    private String correo;
    @Expose
    private Integer telefono;
    @Expose
    private String ape1;
    @Expose
    private String ape2;
    @Expose
    private String nickname;
    @Expose(serialize = false)
    private String pass;
    @Expose(serialize = false)
    private int id_tipoUsuario;
    @Expose(deserialize = false)
    private TipousuarioBean obj_tipoUsuario;
    @Expose(deserialize = false)
    private int numAnuncios;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId_tipoUsuario() {
        return id_tipoUsuario;
    }

    public void setId_tipoUsuario(int id_tipoUsuario) {
        this.id_tipoUsuario = id_tipoUsuario;
    }

    public int getNumAnuncios() {
        return numAnuncios;
    }

    public void setNumAnuncios(int numAnuncios) {
        this.numAnuncios = numAnuncios;
    }

    public TipousuarioBean getObj_tipoUsuario() {
        return obj_tipoUsuario;
    }

    public void setObj_tipoUsuario(TipousuarioBean obj_tipoUsuario) {
        this.obj_tipoUsuario = obj_tipoUsuario;
    }

    @Override
    public UsuarioBean fill(ResultSet oResultSet, Connection oConnection, Integer expand) throws Exception {
        this.setId(oResultSet.getInt("id"));
        this.setNickname(oResultSet.getString("nickname"));
        this.setNombre(oResultSet.getString("nombre"));
        this.setApe1(oResultSet.getString("apellido1"));
        this.setApe2(oResultSet.getString("apellido2"));
        this.setCorreo(oResultSet.getString("correo"));
        this.setPass(oResultSet.getString("password"));
//        AnuncioDao oAnuncioDao = new AnuncioDao(oConnection, "anuncio");
//        this.setNumAnuncios(oAnuncioDao.getcountspecific(this.getId()));
        this.setNumAnuncios(3);
        if (expand > 0) {
            DaoInterface oTipousuarioDao = DaoFactory.getDao(oConnection, "tipousuario");
            this.setObj_tipoUsuario((TipousuarioBean) oTipousuarioDao.get(oResultSet.getInt("id_tipousuario"), expand - 1));
        } else {
            this.setId_tipoUsuario(oResultSet.getInt("id_tipousuario"));
        }
        return this;
    }

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "nickname,";
        strColumns += "nombre,";
        strColumns += "apellido1,";
        strColumns += "apellido2,";
        strColumns += "correo,";
        strColumns += "telefono,";
        strColumns += "password,";
        strColumns += "id_tipousuario";
        return strColumns;
    }

    @Override
    public String getValues() {
        if (id_tipoUsuario == 0) {
            id_tipoUsuario = obj_tipoUsuario.getId();
        }
        String strColumns = "";
        strColumns += "null,";
        strColumns += EncodingHelper.quotate(nickname) + ",";
        strColumns += EncodingHelper.quotate(nombre) + ",";
        strColumns += EncodingHelper.quotate(ape1) + ",";
        strColumns += EncodingHelper.quotate(ape2) + ",";
        strColumns += EncodingHelper.quotate(correo) + ",";
        strColumns += telefono + ",";
        strColumns += EncodingHelper.quotate(pass) + ",";
        strColumns += id_tipoUsuario;
        return strColumns;
    }

    @Override
    public String getPairs() {
        if (id_tipoUsuario == 0) {
            id_tipoUsuario = obj_tipoUsuario.getId();
        }
        String strPairs = "";
        strPairs += "id=" + id + ",";
        strPairs += "nickname=" + EncodingHelper.quotate(nickname) + ",";
        strPairs += "nombre=" + EncodingHelper.quotate(nombre) + ",";
        strPairs += "apellido1=" + EncodingHelper.quotate(ape1) + ",";
        strPairs += "apellido2=" + EncodingHelper.quotate(ape2) + ",";
        strPairs += "correo=" + EncodingHelper.quotate(correo) + ",";
        strPairs += "telefono=" + telefono + ",";
        strPairs += "password=" + EncodingHelper.quotate(pass) + ",";
        strPairs += "id_tipousuario=" + id_tipoUsuario;
        strPairs += " WHERE id=" + id;
        return strPairs;

    }

}
