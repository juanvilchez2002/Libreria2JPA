
package libreria.persistencia;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import libreria.entidad.Cliente;


public class ClienteDAO extends DAO<Cliente>{

    @Override
    public void editar(Cliente objeto) {
        super.editar(objeto); 
    }

    @Override
    public void guardar(Cliente objeto) {
        super.guardar(objeto); 
    }
    
    public List<Cliente> buscarClientePorDNI(Long doc){
        conectar();
        List<Cliente> cliente = em.createQuery(" SELECT c FROM Cliente c "+
                "WHERE c.documento = :doc").setParameter("doc", doc).getResultList();
        desconectar();
        return cliente;
    }
    
    public List<Cliente> listarCliente() {
        conectar();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
            Query q = em.createQuery(cq);            
            return q.getResultList();
        } finally {
            desconectar();
        }
    }
    
    public Cliente buscarClientePorId(Integer id){
        conectar();
        Cliente cliente= (Cliente) em.find(Cliente.class, id);        
        return cliente;
    }
}
