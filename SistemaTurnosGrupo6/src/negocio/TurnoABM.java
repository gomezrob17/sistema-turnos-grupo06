package negocio;

import dao.TurnoDao;
import datos.Cliente;
import datos.Profesional;
import datos.Sucursal;
import datos.Turno;
import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoABM {

    TurnoDao dao = new TurnoDao();

    // Alta de turno
    public int altaTurno(LocalDate fecha, LocalTime hora, Cliente cliente, Profesional profesional, Sucursal sucursal) throws Exception {
        // Validación para asegurarse de que no haya un turno en la misma fecha y hora
        // Puedes hacer más validaciones si lo necesitas

        Turno turnoExistente = dao.traerTurnoPorFechaYHora(fecha, hora, sucursal);

        if (turnoExistente != null) {
            throw new Exception("Ya existe un turno para esta fecha y hora en esta sucursal.");
        }

        // Crear el nuevo turno
        Turno turno = new Turno(fecha, hora, cliente, profesional, sucursal);
        return dao.agregarTurno(turno);
    }
    
    public void modificarTurno(int idTurno, LocalDate nuevaFecha, LocalTime nuevaHora) throws Exception {
        Turno turno = dao.traerTurnoPorId(idTurno);
        if (turno == null) throw new Exception("No existe turno con ID: " + idTurno);

        turno.setFecha(nuevaFecha);
        turno.setHora(nuevaHora);

        dao.modificarTurno(turno);
    }
    
    
}