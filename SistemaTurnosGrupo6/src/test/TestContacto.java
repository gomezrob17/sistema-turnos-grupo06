package test;

import java.util.List;

import datos.Cliente;
import datos.Contacto;
import datos.Especialidad;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactoABM contactoABM = new ContactoABM();
		ClienteABM clienteABM = new ClienteABM();
		try {
//		Cliente cliente = new Cliente();
//    	System.out.println("********************* AGREGAR CONTACTOS ********************************************");
//		
//    	Contacto c2 = new Contacto("rober@gmail.com", "1123456789");
//		cliente.setDni(42555555);
//		clienteABM.traerPorDni(cliente).vincularContacto(c2);
//		contactoABM.agregarContacto(c2);
//		System.out.println(clienteABM.traerPorDni(cliente).toStringConContacto());
//
//		Contacto c3 = new Contacto("tomi@gmail.com", "1133557799");
//		cliente.setDni(37349646);
//		clienteABM.traerPorDni(cliente).vincularContacto(c3);
//		contactoABM.agregarContacto(c3);
//		System.out.println(clienteABM.traerPorDni(cliente).toStringConContacto());
//
//		Contacto c1 = new Contacto("rodri@gmail.com", "1122585383");
//		cliente.setDni(36347647);
//		clienteABM.traerPorDni(cliente).vincularContacto(c1);
//		contactoABM.agregarContacto(c1);
//		System.out.println(clienteABM.traerPorDni(cliente).toStringConContacto());
//
//		
//		Contacto c4 = new Contacto("juli@gmail.com", "1124689722");
//		cliente.setDni(41341644);
//		clienteABM.traerPorDni(cliente).vincularContacto(c4);
//		contactoABM.agregarContacto(c4);
//		System.out.println(clienteABM.traerPorDni(cliente).toStringConContacto());

    	 List<Contacto> listaContacto = contactoABM.traerTodos();
     	System.out.println("********************* TRAER TODOS LOS CONTACTOS ********************************************");
    	for (Contacto c : listaContacto) {
             System.out.println(c.toString());
    	 }
		} catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}

}
