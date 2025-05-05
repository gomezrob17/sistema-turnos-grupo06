package negocio;

import datos.Cliente;
import datos.Contacto;
import datos.Especialidad;

import java.util.List;

import dao.ContactoDao;

public class ContactoABM {

	ContactoDao contactoDao = new ContactoDao();
	
	public int agregarContacto (Contacto c) throws Exception
	{
		return contactoDao.agregarContacto(c);
	}
	
	public Contacto traer(int idContacto) {
		Contacto c = contactoDao.traerContacto(idContacto);
		return c;
	}
	
	public void modificar(Contacto c) {
		contactoDao.modificarContacto(c);
	}

	public void eliminar(int idContacto) {
		Contacto c = contactoDao.traerContacto(idContacto);
		contactoDao.eliminarContacto(c);
	}
	
	public List<Contacto> traerTodos() {
        return contactoDao.traerTodosLosContactos();
}
	
}
