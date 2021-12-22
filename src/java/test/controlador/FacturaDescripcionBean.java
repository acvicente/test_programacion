/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package test.controlador;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author carlosvicente
 */
@Named(value = "facturaDescripcionBean")
@RequestScoped
public class FacturaDescripcionBean {

    @EJB
    private FacturaFacade facturaFacade;
    private List<Object[]> listado;

    public List<Object[]> getListado() {
        return listado;
    }

    public void setListado(List<Object[]> listado) {
        this.listado = listado;
    }
    /**
     * Creates a new instance of FacturaDescripcionBean
     */
    public FacturaDescripcionBean() {
    }
    
    @PostConstruct
    public void llenarTabla(){
        listado = facturaFacade.obtenerFacturas();
    }
}
