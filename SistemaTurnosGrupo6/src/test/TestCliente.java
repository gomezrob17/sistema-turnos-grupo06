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
        	System.out.println("********************* AGREGAR CLIENTES ********************************************");
        	Cliente c1 = new Cliente(42555555, "Roberto", "Juarez", LocalDate.now(), true);
        	Cliente c2 = new Cliente(37349646, "Tomás", "Palma", LocalDate.now(), true);
        	Cliente c3 = new Cliente(36347647, "Rodrigo", "Parada", LocalDate.now(), false);
        	Cliente c4 = new Cliente(41341644, "Julian", "Gonzalez", LocalDate.now(), true);
        	
       	    clienteABM.agregarCliente(c1);
        	clienteABM.agregarCliente(c2);
        	clienteABM.agregarCliente(c3);
        	clienteABM.agregarCliente(c4);
        	
        	System.out.println("CLIENTE AGREGADO : " + c1);
        	System.out.println("CLIENTE AGREGADO : " + c2);
        	System.out.println("CLIENTE AGREGADO : " + c3);
        	System.out.println("CLIENTE AGREGADO : " + c4);

        	// Traer un cliente por DNI
        	System.out.println("********************* TRAER CLIENTE DNI********************************************");
        	System.out.println("Cliente DNI: " + clienteABM.traerPorDni(42555555));
        	
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
        	
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
