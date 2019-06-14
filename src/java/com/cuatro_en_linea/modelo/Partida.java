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
@Table(name = "partida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partida.findAll", query = "SELECT p FROM Partida p"),
    @NamedQuery(name = "Partida.findByIdpartida", query = "SELECT p FROM Partida p WHERE p.idpartida = :idpartida"),
    @NamedQuery(name = "Partida.findByGanador", query = "SELECT p FROM Partida p WHERE p.ganador = :ganador"),
    @NamedQuery(name = "Partida.findByTiempototalpartida", query = "SELECT p FROM Partida p WHERE p.tiempototalpartida = :tiempototalpartida")})
public class Partida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "idpartida")
    private String idpartida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ganador")
    private String ganador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempototalpartida")
    private double tiempototalpartida;
    @JoinColumn(name = "jugador", referencedColumnName = "color")
    @ManyToOne(optional = false)
    private Jugador jugador;

    public Partida() {
    }

    public Partida(String idpartida) {
        this.idpartida = idpartida;
    }

    public Partida(String idpartida, String ganador, double tiempototalpartida) {
        this.idpartida = idpartida;
        this.ganador = ganador;
        this.tiempototalpartida = tiempototalpartida;
    }

    public String getIdpartida() {
        return idpartida;
    }

    public void setIdpartida(String idpartida) {
        this.idpartida = idpartida;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public double getTiempototalpartida() {
        return tiempototalpartida;
    }

    public void setTiempototalpartida(double tiempototalpartida) {
        this.tiempototalpartida = tiempototalpartida;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpartida != null ? idpartida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partida)) {
            return false;
        }
        Partida other = (Partida) object;
        if ((this.idpartida == null && other.idpartida != null) || (this.idpartida != null && !this.idpartida.equals(other.idpartida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cuatro_en_linea.modelo.Partida[ idpartida=" + idpartida + " ]";
    }
    
}
