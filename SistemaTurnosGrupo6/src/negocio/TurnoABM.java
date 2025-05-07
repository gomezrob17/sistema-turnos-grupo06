package negocio;

import dao.EstadoTurnoDao;
import dao.TurnoDao;
import datos.Cliente;
import datos.EstadoTurno;
import datos.Profesional;
import datos.Sucursal;
import datos.Turno;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TurnoABM {

    TurnoDao dao = new TurnoDao();
    private EstadoTurnoDao daoEstadoTurno = new EstadoTurnoDao();
  
    public int altaTurno(LocalDate fecha, LocalTime hora, Cliente cliente, Profesional profesional, Sucursal sucursal, EstadoTurno estado) throws Exception {
        
        Turno turnoExistente = dao.traerTurnoPorFechaYHoraYProfesional(fecha, hora, sucursal, profesional);

        if (turnoExistente != null) {
            throw new Exception("Ya existe un turno para esta fecha y hora en esta sucursal.");
        }

 
        Turno turno = new Turno(fecha, hora, cliente, profesional, sucursal, estado);
        return dao.agregarTurno(turno);
    }
    
    public void modificarTurno(int idTurno, LocalDate nuevaFecha, LocalTime nuevaHora) throws Exception {
        Turno turno = dao.traerTurnoPorId(idTurno);
        if (turno == null) throw new Exception("No existe turno con ID: " + idTurno);

        Turno turnoExistente = dao.traerTurnoPorFechaYHoraYProfesional(nuevaFecha, nuevaHora, turno.getSucursal(), turno.getProfesional());
        
        if (turnoExistente != null && turnoExistente.getIdTurno() != turno.getIdTurno()) {
            throw new Exception("Ya existe un turno asignado a ese profesional en la fecha y hora indicadas.");
        }

        turno.setFecha(nuevaFecha);
        turno.setHora(nuevaHora);


        dao.modificarTurno(turno);
    }
    
    public void cancelarTurno(int idTurno) throws Exception {
        Turno turno = dao.traerTurnoPorId(idTurno);
        if (turno == null) throw new Exception("No existe un turno con ID: " + idTurno);

        EstadoTurno estadoCancelado = daoEstadoTurno.traerEstadoPorNombre("Cancelado");
        if (estadoCancelado == null) throw new Exception("No se encontró el estado 'Cancelado' en la base de datos");

        turno.setEstado(estadoCancelado);

        dao.modificarTurno(turno);
    }
    
    public List<Turno> traerTurnosPorCliente(int idCliente) throws Exception {
        List<Turno> turnos = dao.traerTurnosPorCliente(idCliente);
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("No se encontraron turnos para el cliente con id: " + idCliente);
        }
        return turnos;
    }

    public List<Turno> traerTurnosPorProfesional(int idProfesional) throws Exception {
        List<Turno> turnos = dao.traerTurnosPorProfesional(idProfesional);
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("No se encontraron turnos reservados para el profesional con id: " + idProfesional);
        }
        return turnos;
    }

    public List<Turno> traerTurnosPorFechas(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
        List<Turno> turnos = dao.traerTurnosPorFechas(fechaInicio, fechaFin);
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("No se encontraron turnos entre las fechas " + fechaInicio + " y " + fechaFin);
        }
        return turnos;
    }

    public List<Turno> traerTurnosPorNombreSucursal(String nombreSucursal) throws Exception {
        List<Turno> turnos = dao.traerTurnosPorNombreSucursal(nombreSucursal);
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("No se encontraron turnos en la sucursal: " + nombreSucursal);
        }
        return turnos;
    }

    public List<Turno> traerTurnosPorFechaYSucursal(LocalDate fecha, String nombreSucursal) throws Exception {
        List<Turno> turnos = dao.traerTurnosPorFechaYSucursal(fecha, nombreSucursal);
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("No se encontraron turnos para la fecha " + fecha + " en la sucursal: " + nombreSucursal);
        }
        return turnos;
    }
    
    
    // --- 2da Parte ---
    
    public List<Turno> traerTurnosPorEspecialidad(String nombreEspecialidad) throws Exception {
        List<Turno> turnos = dao.traerTurnosPorEspecialidad(nombreEspecialidad);
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("No se encontraron turnos para la especialidad: " + nombreEspecialidad);
        }
        return turnos;
    }
    
    public List<Turno> traerDetallesTurnos() throws Exception {
        List<Turno> turnos = dao.traerTurnos();
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("No se encontraron turnos disponibles.");
        }
        return turnos;
    }
    
    public List<Turno> traerTurnosPorEstados(String nombreEstado) throws Exception {
        List<Turno> turnos = dao.traerTurnosPorEstado(nombreEstado);
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("No se encontraron turnos en estado: " + nombreEstado);
        }
        return turnos;
    }
    
    public List<Turno> traerTurnosConfirmadosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
        List<Turno> turnos = dao.traerTurnosConfirmadosPorFecha(fechaInicio, fechaFin);
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("No se encontraron turnos Confirmador en las fechas " + fechaInicio + " y " + fechaFin);
        }
        return turnos;
    }
    
    public List<Turno> traerTurnosCanceladosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
        List<Turno> turnos = dao.traerTurnosCanceladosPorFecha(fechaInicio, fechaFin);
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("No se encontraron turnos Cancelados en las fechas " + fechaInicio + " y " + fechaFin);
        }
        return turnos;
    }
    
    public List<Turno> traerTurnosPorFechaYEstado(LocalDate fecha, String nombreEstado) throws Exception {
        List<Turno> turnos = dao.traerTurnosPorFechaYEstado(fecha, nombreEstado);
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("No se encontraron turnos " + nombreEstado + " para la fecha " + fecha);
        }
        return turnos;
    }

    public List<Turno> traerTurnosPorFechaYEspecialidad(LocalDate fecha, String nombreEspecialidad) throws Exception {
        List<Turno> turnos = dao.traerTurnosPorFechaYEspecialidad(fecha, nombreEspecialidad);
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("No se encontraron turnos para la fecha " + fecha + " con especialidad: " + nombreEspecialidad);
        }
        return turnos;
    }
    
    public List<Turno> traerTurnosPorFechaYProfesional(LocalDate fecha, String nombreProfesional) throws Exception {
        List<Turno> turnos = dao.traerTurnosPorFechaYProfesional(fecha, nombreProfesional);
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("No se encontraron turnos para la fecha " + fecha + " con el profesional: " + nombreProfesional);
        }
        return turnos;
    }
    
}