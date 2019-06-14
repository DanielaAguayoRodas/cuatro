/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuatro_en_linea.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DANIELA
 */
@Entity
@Table(name = "tablero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tablero.findAll", query = "SELECT t FROM Tablero t"),
    @NamedQuery(name = "Tablero.findByAlto", query = "SELECT t FROM Tablero t WHERE t.alto = :alto"),
    @NamedQuery(name = "Tablero.findByAncho", query = "SELECT t FROM Tablero t WHERE t.ancho = :ancho")})
public class Tablero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "alto")
    private Integer alto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ancho")
    private int ancho;

    public Tablero() {
    }

    public Tablero(Integer alto) {
        this.alto = alto;
    }

    public Tablero(Integer alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    public Integer getAlto() {
        return alto;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alto != null ? alto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tablero)) {
            return false;
        }
        Tablero other = (Tablero) object;
        if ((this.alto == null && other.alto != null) || (this.alto != null && !this.alto.equals(other.alto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cuatro_en_linea.modelo.Tablero[ alto=" + alto + " ]";
    }
    
}
