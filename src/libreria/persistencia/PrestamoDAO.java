

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import java.util.List;
import libreria.entidad.Prestamo;

/**
 *
 * @author JUAN VILCHEZ
 */
public class PrestamoDAO extends DAO<Prestamo>{

    @Override
    public void editar(Prestamo objeto) {
        super.editar(objeto); 
    }

    @Override
    public void guardar(Prestamo objeto) {
        super.guardar(objeto);
    }
    
    public List<Prestamo> buscarPretamoPorCliente(Long dni){
        conectar();
        List<Prestamo> prestamos = em.createQuery("SELECT p FROM Prestamo p "
            +"JOIN p.cliente c WHERE c.documento = :dni").setParameter("dni", dni)
            .getResultList();
        desconectar();
        return prestamos;
    }
    
    public Prestamo buscarPrestamoPorId(Integer id){
        conectar();
        Prestamo prestamo = (Prestamo) em.find(Prestamo.class, id);
        desconectar();
        return prestamo;
    }
}
