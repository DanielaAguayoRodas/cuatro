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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DANIELA
 */
@Entity
@Table(name = "turno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t"),
    @NamedQuery(name = "Turno.findByTiempoparajugar", query = "SELECT t FROM Turno t WHERE t.tiempoparajugar = :tiempoparajugar"),
    @NamedQuery(name = "Turno.findByJugadorturno", query = "SELECT t FROM Turno t WHERE t.jugadorturno = :jugadorturno")})
public class Turno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempoparajugar")
    private short tiempoparajugar;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "jugadorturno")
    private String jugadorturno;
    @JoinColumn(name = "jugadorturno", referencedColumnName = "color", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Jugador jugador;

    public Turno() {
    }

    public Turno(String jugadorturno) {
        this.jugadorturno = jugadorturno;
    }

    public Turno(String jugadorturno, short tiempoparajugar) {
        this.jugadorturno = jugadorturno;
        this.tiempoparajugar = tiempoparajugar;
    }

    public short getTiempoparajugar() {
        return tiempoparajugar;
    }

    public void setTiempoparajugar(short tiempoparajugar) {
        this.tiempoparajugar = tiempoparajugar;
    }

    public String getJugadorturno() {
        return jugadorturno;
    }

    public void setJugadorturno(String jugadorturno) {
        this.jugadorturno = jugadorturno;
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
        hash += (jugadorturno != null ? jugadorturno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.jugadorturno == null && other.jugadorturno != null) || (this.jugadorturno != null && !this.jugadorturno.equals(other.jugadorturno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cuatro_en_linea.modelo.Turno[ jugadorturno=" + jugadorturno + " ]";
    }
    
}
