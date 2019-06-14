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
@Table(name = "casilla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casilla.findAll", query = "SELECT c FROM Casilla c"),
    @NamedQuery(name = "Casilla.findByEstado", query = "SELECT c FROM Casilla c WHERE c.estado = :estado")})
public class Casilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Boolean estado;

    public Casilla() {
    }

    public Casilla(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estado != null ? estado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casilla)) {
            return false;
        }
        Casilla other = (Casilla) object;
        if ((this.estado == null && other.estado != null) || (this.estado != null && !this.estado.equals(other.estado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cuatro_en_linea.modelo.Casilla[ estado=" + estado + " ]";
    }
    
}
