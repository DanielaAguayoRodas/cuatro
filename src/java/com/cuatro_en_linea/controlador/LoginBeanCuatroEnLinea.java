/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuatro_en_linea.controlador;

import com.cuatro_en_linea.controlador.util.JsfUtil;
import com.cuatro_en_linea.modelo.Persona;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author DANIELA
 */
@Named(value = "loginBeanCuatroEnLinea")
@ViewScoped
public class LoginBeanCuatroEnLinea implements Serializable {

    private Persona persona;
    @EJB
    private PersonaFacade personaFacade;

   
 public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
 
    public LoginBeanCuatroEnLinea() {
    }

    @PostConstruct
    private void iniciar() {
        persona = new Persona();
        //hacemos el llamado al llenado del arbol en el evento del posconstruct
        //para que se ejecute despues de instanciar el bean   

    }

    public String ingresar() {
        Persona personaEncontrada = personaFacade.findByEmail(persona.getCorreo());
        if (personaEncontrada != null) {
            
            
            if (persona.getContrasena().compareTo(personaEncontrada.getContrasena()) == 0) {
                if ("admin@hotmail.com".equals(persona.getCorreo())){
                    return "ingresar";
                
                }else if(persona.getCorreo() !="admin@hotmail.com" ){
                    return "jugar";
                }else
                    JsfUtil.addErrorMessage("No tiene permisos para acceder");
                      JsfUtil.addErrorMessage("Ingrese por el boton Jugar");

            }else  JsfUtil.addErrorMessage("Contraseña errada");
        } else {
            JsfUtil.addErrorMessage("El correo ingresado no existe");
        }
       
    
         return null;
    }

}
