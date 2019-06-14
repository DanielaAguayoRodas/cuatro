package com.cuatro_en_linea.controlador;

import com.cuatro_en_linea.modelo.Casilla;
import com.cuatro_en_linea.controlador.util.JsfUtil;
import com.cuatro_en_linea.controlador.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("casillaController")
@SessionScoped
public class CasillaController implements Serializable {

    @EJB
    private com.cuatro_en_linea.controlador.CasillaFacade ejbFacade;
    private List<Casilla> items = null;
    private Casilla selected;

    public CasillaController() {
    }

    public Casilla getSelected() {
        return selected;
    }

    public void setSelected(Casilla selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CasillaFacade getFacade() {
        return ejbFacade;
    }

    public Casilla prepareCreate() {
        selected = new Casilla();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CasillaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CasillaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CasillaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Casilla> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Casilla getCasilla(java.lang.Boolean id) {
        return getFacade().find(id);
    }

    public List<Casilla> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Casilla> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Casilla.class)
    public static class CasillaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CasillaController controller = (CasillaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "casillaController");
            return controller.getCasilla(getKey(value));
        }

        java.lang.Boolean getKey(String value) {
            java.lang.Boolean key;
            key = Boolean.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Boolean value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Casilla) {
                Casilla o = (Casilla) object;
                return getStringKey(o.getEstado());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Casilla.class.getName()});
                return null;
            }
        }

    }

}
