package datos;

public class EstadoTurno {

	private int idEstado;
	private String nombre;
	
	public EstadoTurno() {}
	
	public EstadoTurno(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public int getIdEstado() {
		return idEstado;
	}
	protected void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "EstadoTurno [idEstado=" + idEstado + ", nombre=" + nombre + "]";
	}
}
