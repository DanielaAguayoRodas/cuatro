/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuatro_en_linea.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DANIELA
 */
@Entity
@Table(name = "jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j"),
    @NamedQuery(name = "Jugador.findById", query = "SELECT j FROM Jugador j WHERE j.id = :id"),
    @NamedQuery(name = "Jugador.findByNombre", query = "SELECT j FROM Jugador j WHERE j.nombre = :nombre"),
    @NamedQuery(name = "Jugador.findByCorreo", query = "SELECT j FROM Jugador j WHERE j.correo = :correo"),
    @NamedQuery(name = "Jugador.findByContrasena", query = "SELECT j FROM Jugador j WHERE j.contrasena = :contrasena"),
    @NamedQuery(name = "Jugador.findByColor", query = "SELECT j FROM Jugador j WHERE j.color = :color")})
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "contrasena")
    private String contrasena;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "color")
    private String color;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<Tablaposiciones> tablaposicionesList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "jugador")
    private Turno turno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugador")
    private List<Partida> partidaList;

    public Jugador() {
    }

    public Jugador(String color) {
        this.color = color;
    }

    public Jugador(String color, String id, String nombre, String correo, String contrasena) {
        this.color = color;
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @XmlTransient
    public List<Tablaposiciones> getTablaposicionesList() {
        return tablaposicionesList;
    }

    public void setTablaposicionesList(List<Tablaposiciones> tablaposicionesList) {
        this.tablaposicionesList = tablaposicionesList;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @XmlTransient
    public List<Partida> getPartidaList() {
        return partidaList;
    }

    public void setPartidaList(List<Partida> partidaList) {
        this.partidaList = partidaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (color != null ? color.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.color == null && other.color != null) || (this.color != null && !this.color.equals(other.color))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cuatro_en_linea.modelo.Jugador[ color=" + color + " ]";
    }
    
}
