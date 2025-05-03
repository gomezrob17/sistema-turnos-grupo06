package negocio;

import dao.ClienteDao;
import datos.Cliente;

import java.time.LocalDate;
import java.util.List;

public class ClienteABM {

    ClienteDao dao = new ClienteDao();
    
    
/*AGREGAR CLIENTE*/
    public int agregarCliente(Cliente c) throws Exception {
      
        if (dao.traerDniCliente(c.getDni()) != null) {
            throw new Exception("YA EXISTE UN CLIENTE CON ESE DNI");
        }
        return dao.agregarCliente(c);
    }
	
	
/*MODIFICAR CLIENTE*/	
    public void modificarCliente(Cliente c) throws Exception {
    	
        Cliente encontrado = dao.traerClientePorId(c.getIdPersona());
        
        if (encontrado == null) {
            throw new Exception("CLIENTE NO ENCONTRADO");
        }
        dao.modificarCliente(c);
    }

/*ELIMINAR CLIENTE*/
    public void eliminarCliente(Cliente c) throws Exception {
    	
        Cliente encontrado = dao.traerClientePorId(c.getIdPersona());
        
        if (encontrado == null) {
            throw new Exception("CLIENTE NO ENCONTRADO");
        }
        
        dao.eliminarCliente(c);
    }


/*TRAER CLIENTE POR DNI*/
    public Cliente traerPorDni(Cliente c) {
        return dao.traerDniCliente(c.getDni());
    }

/*TRAER TODOS LOS CLIENTES*/    
    public List<Cliente> traerTodos() {
        return dao.traerTodosLosClientes();
    }
    
/*CONSULTAR CLIENTE POR DNI*/    
    public Cliente consultarPorDni(int dni) throws Exception {
        Cliente c = dao.traerDniCliente(dni);
        if (c == null) {
            throw new Exception("NO EXISTE NINGUN CLIENTE CON ESE DNI: " + dni);
        }
        return c;
    }
    
/*LISTAR CLIENTES ACTIVOS ES DECIR, ACTIVO = TRUE*/    
    public List<Cliente> listarClientesActivos() {
        return dao.listarClientesActivos();
    }
    
/*LISTAR CLIENTES DADOS DE BAJA ES DECIR, ACTIVO = FALSE*/    
    public List<Cliente> listarClientesDadosDeBaja() {
        return dao.listarClientesDadosDeBaja();
    }
    
/*LISTAR CLIENTES POR FECHA DE ALTA DESDE-HASTA*/ 
    public List<Cliente> listarPorFechaAltaEntre(LocalDate desde, LocalDate hasta) {
        return dao.traerClientesPorFechaAltaEntre(desde, hasta);
    }
    
}
