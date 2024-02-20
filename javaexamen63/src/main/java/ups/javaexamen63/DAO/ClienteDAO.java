package ups.javaexamen63.DAO;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.javaexamen63.model.Cliente;

@Stateless
public class ClienteDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(Cliente Cliente) {
        em.persist(Cliente);
    }

    public void update(Cliente cliente) {
        em.merge(cliente);
    }

    public void remove(int codigo) {
        Cliente cliente = em.find(Cliente.class, codigo);
        em.remove(cliente);
    }

    public Cliente read(int codigo) {
        Cliente cliente = em.find(Cliente.class, codigo);
        return cliente;
    }

    public List<Cliente> getAll() {
        String jpql = "SELECT c FROM Cliente c";
        Query q = em.createQuery(jpql, Cliente.class);
        return q.getResultList();
    }

    public Cliente getClientePorCodigo(int codigo) {
        String jpql = "SELECT c FROM Cliente c WHERE c.codigo = :codigo";
        Query q = em.createQuery(jpql, Cliente.class);
        q.setParameter("codigo", codigo);
        List<Cliente> clientes = q.getResultList();
        if (clientes.size() > 0) {
            return clientes.get(0);
        }
        return null;
    }
}
