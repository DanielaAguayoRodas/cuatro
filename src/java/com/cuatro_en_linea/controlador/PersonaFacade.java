/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuatro_en_linea.controlador;

import com.cuatro_en_linea.modelo.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DANIELA
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "cuatro_en_lineaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    public Persona findByEmail(String email)
    {
        Query q = em.createNamedQuery("Persona.findByCorreo", Persona.class).setParameter("correo", email);
        
        List list= q.getResultList();
        
        if(list.isEmpty())
        {
            return null;
        }
        return (Persona) list.get(0);
    }
    
}
