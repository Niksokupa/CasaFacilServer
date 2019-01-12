/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ramon.bean;

import com.google.gson.annotations.Expose;

/**
 *
 * @author ramon
 */
public class FotosAnuncioBean {
    
    @Expose
    private Integer id_anuncio;
    @Expose
    private Integer id_fotos;

    public Integer getId_anuncio() {
        return id_anuncio;
    }

    public void setId_anuncio(Integer id_anuncio) {
        this.id_anuncio = id_anuncio;
    }

    public Integer getId_fotos() {
        return id_fotos;
    }

    public void setId_fotos(Integer id_fotos) {
        this.id_fotos = id_fotos;
    }
    
}
