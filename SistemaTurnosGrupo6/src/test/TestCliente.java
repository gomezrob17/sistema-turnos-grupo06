package test;

import java.time.LocalDate;
import java.util.List;

import datos.Cliente;
import negocio.ClienteABM;

public class TestCliente {

    public static void main(String[] args) {
    	
        ClienteABM clienteABM = new ClienteABM();

        try {
            // Agregar los cliente
//        	System.out.println("********************* AGREGAR CLIENTES ********************************************");
//        	Cliente c1 = new Cliente(42555555, "Roberto", "Juarez", LocalDate.now(), true);
//        	Cliente c2 = new Cliente(37349646, "Tomas", "Palma", LocalDate.now(), true);
//        	Cliente c3 = new Cliente(36347647, "Rodrigo", "Parada", LocalDate.now(), false);
//        	Cliente c4 = new Cliente(41341644, "Julian", "Gonzalez", LocalDate.now(), true);
//        	
//       	clienteABM.agregarCliente(c1);
//        	clienteABM.agregarCliente(c2);
//        	clienteABM.agregarCliente(c3);
//        	clienteABM.agregarCliente(c4);
//        	
//        	System.out.println("CLIENTE AGREGADO : " + c1);
//        	System.out.println("CLIENTE AGREGADO : " + c2);
//        	System.out.println("CLIENTE AGREGADO : " + c3);
//        	System.out.println("CLIENTE AGREGADO : " + c4);

        	// Traer un cliente por DNI
//        	System.out.println("********************* TRAER CLIENTE DNI********************************************");
//        	System.out.println("Cliente DNI: " + clienteABM.traerPorDni(c1));
        	
        	/*
            //Modificar un cliente
            System.out.println("********************* MODIFICAR CLIENTE********************************************");
            Cliente orig = clienteABM.traerPorDni(c1);
            System.out.println("Cliente Antes de modificar: " + orig);
            orig.setApellido("Gomez");
        	clienteABM.modificarCliente(orig);
        	Cliente mod = clienteABM.traerPorDni(c1);
        	System.out.println("Cliente Despues de modificar: " + mod);
			*/
        	
            /*
        	//Eliminar un cliente
          System.out.println("********************* ELIMINAR CLIENTE********************************************");
            Cliente existeEnDB = clienteABM.traerPorDni(c1);
            clienteABM.eliminarCliente(existeEnDB);
            */       	
 

            /*
          //Traer todos los clientes guardados
          System.out.println("********************* TRAER TODOS LOS CLIENTES********************************************");
            List<Cliente> todos = clienteABM.traerTodos();
            System.out.println("\n*** Todos los clientes ***");
            for (Cliente clientes : todos) {
                System.out.println(clientes);
            }
            */      	
        	
        	
            //CONSULTAR CLIENTE POR DNI
            System.out.println("********************* CONSULTAR CLIENTE POR DNI ********************************************");
            int buscarDNI = 37349646;
            try {
                Cliente encontrado = clienteABM.consultarPorDni(buscarDNI);
                System.out.println("Buscar DNI: " + encontrado);
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        	
          //LISTAR CLIENTES ACTIVOS es decir ACTIVO = TRUE
            System.out.println("********************* LISTAR CLIENTES ACTIVOS ********************************************");
            List<Cliente> clientesActivos = clienteABM.listarClientesActivos();
            for (Cliente c : clientesActivos) {
                System.out.println(c);
            }
        	
          //LISTAR CLIENTES DADOS DE BAJA es decir ACTIVO = FALSE
            System.out.println("********************* LISTAR CLIENTES DADOS DE BAJA ********************************************");
            List<Cliente> clientesBaja = clienteABM.listarClientesDadosDeBaja();
            for (Cliente c : clientesBaja) {
                System.out.println(c);
            }
        	
          //LISTAR CLIENTES DADOS DE ALTA EN UN INTERVALO DE FECHAS
            System.out.println("********************* LISTAR CLIENTES DADOS DE ALTA ENTRE FECHAS ********************************************");
            //LocalDate desde = LocalDate.now().minusDays(1);
            LocalDate desde = LocalDate.now().minusDays(7);
            LocalDate hasta = LocalDate.now().plusDays(1);
            List<Cliente> clientes = clienteABM.listarPorFechaAltaEntre(desde, hasta);
            if (clientes.isEmpty()) {
                System.out.println("NO SE ENCONTRARON CLIENTES EN ESE RANGO DE FECHAS.");
            } else {
                for (Cliente c : clientes) {
                    System.out.println(c);
                }
            }
            
            
            
        	
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
