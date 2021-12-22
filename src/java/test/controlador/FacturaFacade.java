/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import test.entidades.Factura;

import javax.faces.bean.ManagedBean;
/**
 *
 * @author carlosvicente
 */
@Stateless
public class FacturaFacade extends AbstractFacade<Factura> {

    @PersistenceContext(unitName = "test_crudPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaFacade() {
        super(Factura.class);
    }
    
    public List obtenerFacturas(){
        Query q = em.createNativeQuery("Select * From Factura JOIN Detalle_Factura ON Factura.id = Detalle_Factura.id_factura");
        List<Object[]> listado = q.getResultList();
        return listado;
    }
           
    
}
