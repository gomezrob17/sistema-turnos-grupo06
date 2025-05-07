package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
	
	private int idTurno; 
	private LocalDate fecha;
	private LocalTime hora; 
	private Cliente cliente; 
	private Profesional profesional; 
	private Sucursal sucursal;
	private EstadoTurno estado; 
	
	public Turno() {
    }
	
	public Turno(LocalDate fecha, LocalTime hora, Cliente cliente, Profesional profesional,
			Sucursal sucursal, EstadoTurno estado) {
		super();

		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
		this.profesional = profesional;
		this.sucursal = sucursal;
		this.estado = estado;
	}
	public int getIdTurno() {
		return idTurno;
	}
	protected void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Profesional getProfesional() {
		return profesional;
	}
	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public EstadoTurno getEstado() {
		return estado;
	}
	public void setEstado(EstadoTurno estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", fecha=" + fecha + ", hora=" + hora + ", cliente=" + cliente
				+ ", profesional=" + profesional + ", sucursal=" + sucursal + ", estado=" + estado + "]";
	}
	
	
}
