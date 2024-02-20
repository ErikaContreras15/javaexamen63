package ups.javaexamen63.bussines;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.javaexamen63.DAO.ClienteDAO;
import ups.javaexamen63.model.Cliente;

@Stateless
public class gestionCliente {
	 @Inject
	    private ClienteDAO clienteDAO;

	    public void guardarCliente(Cliente cliente) {
	        Cliente cli = clienteDAO.read(cliente.getId());
	        if (cli != null) {
	            clienteDAO.update(cliente);
	        } else {
	            clienteDAO.insert(cliente);
	        }
	    }

	    public void actualizarCliente(Cliente cliente) throws Exception {
	        Cliente cli = clienteDAO.read(cliente.getId());
	        if (cli != null) {
	            clienteDAO.update(cliente);
	        } else {
	            throw new Exception("Cliente no existe");
	        }
	    }

	    public Cliente getClientePorCodigo(int codigo) throws Exception {
	        return clienteDAO.getClientePorCodigo(codigo);
	    }

	    public void borrarCliente(int codigo) {
	        clienteDAO.remove(codigo);
	    }

	    public List<Cliente> getClientes() {
	        return clienteDAO.getAll();
	    }

}
