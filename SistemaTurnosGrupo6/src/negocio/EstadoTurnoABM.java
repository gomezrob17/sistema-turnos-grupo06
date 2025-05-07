package negocio;

import java.util.List;

import dao.EstadoTurnoDao;
import datos.EstadoTurno;

public class EstadoTurnoABM {
	EstadoTurnoDao dao = new EstadoTurnoDao();
	
	public int agregarEstado(EstadoTurno e) throws Exception {
		if(dao.traerEstadoPorNombre(e.getNombre()) != null) throw new Exception("Estado ya existente");
		return dao.agregarEstado(e);
	}
	
	public void modificarEstado(EstadoTurno e) throws Exception {
		EstadoTurno estado = dao.traerEstadoPorId(e.getIdEstado());
		if(estado == null) throw new Exception("Estado no encontrado");
		
		dao.actualizarEstado(e);
	}
	
	public void EliminarEstado(EstadoTurno e) throws Exception {
		EstadoTurno estado = dao.traerEstadoPorId(e.getIdEstado());
		if(estado == null) throw new Exception("Estado no encontrado");
		
		dao.eliminarEstado(e);
	}
	
	public EstadoTurno traerEstadoPorId(int id) throws Exception {
		EstadoTurno estado = dao.traerEstadoPorId(id);
		if(estado == null) throw new Exception("Id no encontrado");
		return estado;
	}
	
	public EstadoTurno traerEstadoPorNombre(String nombre) throws Exception {
		EstadoTurno estado = dao.traerEstadoPorNombre(nombre);
		if(estado == null) throw new Exception("Nombre de estado no encontrado");
		return estado;
	}
	
	public List<EstadoTurno> traerTodosLosEstados(){
		return dao.traerTodosLosEstado();
	}
	
}
