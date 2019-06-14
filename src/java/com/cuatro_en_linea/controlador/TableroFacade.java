/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuatro_en_linea.controlador;

import com.cuatro_en_linea.modelo.Tablero;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DANIELA
 */
@Stateless
public class TableroFacade extends AbstractFacade<Tablero> {

    @PersistenceContext(unitName = "cuatro_en_lineaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TableroFacade() {
        super(Tablero.class);
    }
    
}
