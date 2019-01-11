/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ramon.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import com.google.gson.annotations.Expose;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import net.ramon.bean.genericBeanInterface.GenericBeanImplementation;
import net.ramon.bean.publicBeanInterface.BeanInterface;
import net.ramon.helper.EncodingHelper;
import net.ramon.dao.publicDaoInterface.DaoInterface;
import net.ramon.factory.DaoFactory;

/**
 *
 * @author ramon
 */
public class AnuncioBean extends GenericBeanImplementation implements BeanInterface {

    @Expose
    private String titulo;
    @Expose
    private String descripcion;
    @Expose
    private Integer habitaciones;
    @Expose
    private Integer banyos;
    @Expose
    private Integer metroscasa;
    @Expose
    private Integer metrosterreno;
    @Expose
    private String direccion;
    @Expose
    private Integer precio;
    @Expose
    private Date fechacreacion;
    @Expose
    private Date fechaupdate;
    @Expose
    private Integer id_Usuario;
    @Expose(deserialize = false)
    private UsuarioBean obj_Usuario;
    @Expose
    private Integer id_Tipoinmueble;
    @Expose(deserialize = false)
    private TipoinmuebleBean obj_Tipoinmueble;
    @Expose
    private Integer id_Tipovia;
    @Expose(deserialize = false)
    private TipoviaBean obj_Tipovia;
    @Expose
    private Integer id_Barrio;
    @Expose(deserialize = false)
    private BarrioBean obj_Barrio;
    @Expose
    private Integer numFotos;

    public Integer getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Integer id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public Integer getId_Tipoinmueble() {
        return id_Tipoinmueble;
    }

    public void setId_Tipoinmueble(Integer id_Tipoinmueble) {
        this.id_Tipoinmueble = id_Tipoinmueble;
    }

    public Integer getId_Tipovia() {
        return id_Tipovia;
    }

    public void setId_Tipovia(Integer id_Tipovia) {
        this.id_Tipovia = id_Tipovia;
    }

    public Integer getId_Barrio() {
        return id_Barrio;
    }

    public void setId_Barrio(Integer id_Barrio) {
        this.id_Barrio = id_Barrio;
    }

    public Integer getNumFotos() {
        return numFotos;
    }

    public void setNumFotos(Integer numFotos) {
        this.numFotos = numFotos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Integer habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Integer getBanyos() {
        return banyos;
    }

    public void setBanyos(Integer banyos) {
        this.banyos = banyos;
    }

    public Integer getMetroscasa() {
        return metroscasa;
    }

    public void setMetroscasa(Integer metroscasa) {
        this.metroscasa = metroscasa;
    }

    public Integer getMetrosterreno() {
        return metrosterreno;
    }

    public void setMetrosterreno(Integer metrosterreno) {
        this.metrosterreno = metrosterreno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechaupdate() {
        return fechaupdate;
    }

    public void setFechaupdate(Date fechaupdate) {
        this.fechaupdate = fechaupdate;
    }

    public UsuarioBean getObj_Usuario() {
        return obj_Usuario;
    }

    public void setObj_Usuario(UsuarioBean obj_Usuario) {
        this.obj_Usuario = obj_Usuario;
    }

    public TipoinmuebleBean getObj_Tipoinmueble() {
        return obj_Tipoinmueble;
    }

    public void setObj_Tipoinmueble(TipoinmuebleBean obj_Tipoinmueble) {
        this.obj_Tipoinmueble = obj_Tipoinmueble;
    }

    public TipoviaBean getObj_Tipovia() {
        return obj_Tipovia;
    }

    public void setObj_Tipovia(TipoviaBean obj_Tipovia) {
        this.obj_Tipovia = obj_Tipovia;
    }

    public BarrioBean getObj_Barrio() {
        return obj_Barrio;
    }

    public void setObj_Barrio(BarrioBean obj_Barrio) {
        this.obj_Barrio = obj_Barrio;
    }

    @Override
    public AnuncioBean fill(ResultSet oResultSet, Connection oConnection, Integer expand) throws Exception {
        this.setId(oResultSet.getInt("id"));
        this.setTitulo(oResultSet.getString("titulo"));
        this.setDescripcion(oResultSet.getString("descripcion"));
        this.setDireccion(oResultSet.getString("direccion"));
        this.setHabitaciones(oResultSet.getInt("habitaciones"));
        this.setBanyos(oResultSet.getInt("banyos"));
        this.setMetroscasa(oResultSet.getInt("metroscasa"));
        this.setMetrosterreno(oResultSet.getInt("metrosterreno"));
        this.setPrecio(oResultSet.getInt("precio"));
        this.setFechacreacion(oResultSet.getDate("fechacreacion"));
        this.setFechaupdate(oResultSet.getDate("fechaupdate"));
//        AnuncioDao oAnuncioDao = new AnuncioDao(oConnection, "anuncio");
//        this.setNumAnuncios(oAnuncioDao.getcountspecific(this.getId()));
        this.setNumFotos(3);
        if (expand > 0) {
            DaoInterface oUsuarioDao = DaoFactory.getDao(oConnection, "usuario");
            this.setObj_Usuario((UsuarioBean) oUsuarioDao.get(oResultSet.getInt("id_usuario"), expand));
            DaoInterface oTipoinmueble = DaoFactory.getDao(oConnection, "tipoinmueble");
            this.setObj_Tipoinmueble((TipoinmuebleBean) oTipoinmueble.get(oResultSet.getInt("id_tipoinmueble"), expand));
            DaoInterface oTipovia = DaoFactory.getDao(oConnection, "tipovia");
            this.setObj_Tipovia((TipoviaBean) oTipovia.get(oResultSet.getInt("id_tipovia"), expand));
            DaoInterface oBarrio = DaoFactory.getDao(oConnection, "barrio");
            this.setObj_Barrio((BarrioBean) oBarrio.get(oResultSet.getInt("id_barrio"), expand));
            expand--;
        } else {
            this.setId_Usuario(oResultSet.getInt("id_usuario"));
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
        if (id_Usuario == 0) {
            id_Usuario = obj_Usuario.getId();
        }
        if (id_Barrio == 0) {
            id_Barrio = obj_Barrio.getId();
        }
        if (id_Tipoinmueble == 0) {
            id_Tipoinmueble = obj_Tipoinmueble.getId();
        }
        if (id_Tipovia == 0) {
            id_Tipovia = obj_Tipovia.getId();
        }

        //Getting the default zone id
        ZoneId defaultZoneId = ZoneId.systemDefault();

        //Converting the date to Instant
        Instant instant = fechacreacion.toInstant();
        Instant instant2 = fechaupdate.toInstant();

        //Converting the Date to LocalDate
        LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
        LocalDateTime updateDateTime = instant2.atZone(defaultZoneId).toLocalDateTime();

        String strColumns = "";
        strColumns += "null,";
        strColumns += EncodingHelper.quotate(titulo) + ",";
        strColumns += habitaciones + ",";
        strColumns += banyos + ",";
        strColumns += metroscasa + ",";
        strColumns += metrosterreno + ",";
        strColumns += EncodingHelper.quotate(direccion) + ",";
        strColumns += EncodingHelper.quotate(localDateTime.toString()) + ",";
        strColumns += id_tipoUsuario;
        return strColumns;
    }

    @Override
    public String getPairs() {
        if (id_Usuario == 0) {
            id_Usuario = obj_Usuario.getId();
        }
        if (id_Barrio == 0) {
            id_Barrio = obj_Barrio.getId();
        }
        if (id_Tipoinmueble == 0) {
            id_Tipoinmueble = obj_Tipoinmueble.getId();
        }
        if (id_Tipovia == 0) {
            id_Tipovia = obj_Tipovia.getId();
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
