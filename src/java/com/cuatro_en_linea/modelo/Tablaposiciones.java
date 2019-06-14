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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DANIELA
 */
@Entity
@Table(name = "tablaposiciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tablaposiciones.findAll", query = "SELECT t FROM Tablaposiciones t"),
    @NamedQuery(name = "Tablaposiciones.findByJugador", query = "SELECT t FROM Tablaposiciones t WHERE t.jugador = :jugador"),
    @NamedQuery(name = "Tablaposiciones.findByPosicion", query = "SELECT t FROM Tablaposiciones t WHERE t.posicion = :posicion")})
public class Tablaposiciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "jugador")
    private String jugador;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "posicion")
    private Short posicion;
    @JoinColumn(name = "id", referencedColumnName = "color")
    @ManyToOne(optional = false)
    private Jugador id;

    public Tablaposiciones() {
    }

    public Tablaposiciones(Short posicion) {
        this.posicion = posicion;
    }

    public Tablaposiciones(Short posicion, String jugador) {
        this.posicion = posicion;
        this.jugador = jugador;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public Short getPosicion() {
        return posicion;
    }

    public void setPosicion(Short posicion) {
        this.posicion = posicion;
    }

    public Jugador getId() {
        return id;
    }

    public void setId(Jugador id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (posicion != null ? posicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tablaposiciones)) {
            return false;
        }
        Tablaposiciones other = (Tablaposiciones) object;
        if ((this.posicion == null && other.posicion != null) || (this.posicion != null && !this.posicion.equals(other.posicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cuatro_en_linea.modelo.Tablaposiciones[ posicion=" + posicion + " ]";
    }
    
}
