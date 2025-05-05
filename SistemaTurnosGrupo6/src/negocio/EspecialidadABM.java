package negocio;

import java.util.List;
import java.util.Set;

import dao.EspecialidadDao;
import datos.Cliente;
import datos.Especialidad;
import datos.Profesional;


public class EspecialidadABM {
	EspecialidadDao especialidadDao = new EspecialidadDao();
		
		public int agregarEspecialidad (Especialidad e)
		{
			return especialidadDao.agregarEspecialidad(e);
		}
		
		public Especialidad traer(int idEspecialidad) {
			Especialidad e = especialidadDao.traerEspecialidad(idEspecialidad);
			return e;
		}
		
		public Especialidad traer(String nombre) throws Exception {
			Especialidad e = especialidadDao.traerEspecialidadNombre(nombre);
			if(e == null) throw new Exception("Nombre no encontrado");
			return e;
		}
		
		public Especialidad traerConProfesionales(int idEspecialidad) {
			Especialidad e = especialidadDao.traerEspecialidadYProfesionales(idEspecialidad);
			return e;
		}
		
		public void modificar(Especialidad e) {
			especialidadDao.modificarEspecialidad(e);
		}
	
		public void eliminar(int idEspecialidad) {
			Especialidad e = especialidadDao.traerEspecialidad(idEspecialidad);
			especialidadDao.eliminarEspecialidad(e);
		}
		
		 public List<Especialidad> traerTodos() {
		        return especialidadDao.traerTodosLasEspecialidad();
		}

}
