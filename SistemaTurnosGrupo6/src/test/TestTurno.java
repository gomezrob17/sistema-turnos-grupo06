package test;

import datos.Cliente;
import datos.EstadoTurno;
import datos.Profesional;
import datos.Sucursal;
import negocio.ClienteABM;
import negocio.EstadoTurnoABM;
import negocio.ProfesionalABM;
import negocio.SucursalABM;
import negocio.TurnoABM;
import datos.Turno;
import test.TestCliente;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestTurno {

    public static void main(String[] args) {
        TurnoABM turnoABM = new TurnoABM();
        ClienteABM clienteABM = new ClienteABM (); 
        ProfesionalABM profesionalABM= new ProfesionalABM (); 
        SucursalABM sucursalABM= new SucursalABM (); 
        EstadoTurnoABM estadoTurnoABM= new EstadoTurnoABM(); 
        try {
            // Agregar un turno (altaTurno)
            System.out.println("********************* ALTA DE TURNO ********************************************");
            
            // Crear un nuevo turno
            LocalDate fecha = LocalDate.of(2025, 11, 25);
            LocalTime hora = LocalTime.of(17, 0);
            
            turnoABM.altaTurno(fecha, hora, clienteABM.consultarPorDni(42555555), profesionalABM.consultarPorMatricula("MATR-1001"), sucursalABM.traerSucursalPorNombreYDireccion("Sucursal A", "Calle Falsa 123"), estadoTurnoABM.traerEstadoPorNombre("Pendiente"));
            turnoABM.altaTurno(fecha, hora, clienteABM.consultarPorDni(36347647), profesionalABM.consultarPorMatricula("MATR-1003"), sucursalABM.traerSucursalPorNombreYDireccion("Sucursal B", "Avenida Siempre Viva 456"), estadoTurnoABM.traerEstadoPorNombre("Cancelado"));
//            
//            turnoABM.modificarTurno(1, fecha, hora);
            
            System.out.println(turnoABM.traerTurnosPorCliente(1));
            System.out.println(turnoABM.traerTurnosPorProfesional(5));
            System.out.println(turnoABM.traerTurnosPorFechas(LocalDate.of(2025, 10, 25), LocalDate.of(2025, 12, 25)));
            System.out.println(turnoABM.traerTurnosPorNombreSucursal("Sucursal A"));
            System.out.println(turnoABM.traerTurnosPorFechaYSucursal(fecha, "Sucursal A"));
            System.out.println("2da parte");
            System.out.println(turnoABM.traerTurnosPorEspecialidad("Cardiologia"));
            System.out.println(turnoABM.traerDetallesTurnos());
            System.out.println(turnoABM.traerTurnosPorEstados("Pendiente"));
            System.out.println(turnoABM.traerTurnosConfirmadosEntreFechas(LocalDate.of(2025, 10, 25), LocalDate.of(2025, 12, 25)));
            System.out.println(turnoABM.traerTurnosCanceladosEntreFechas(LocalDate.of(2025, 10, 25), LocalDate.of(2025, 12, 25)));
            System.out.println(turnoABM.traerTurnosPorFechaYEstado(LocalDate.of(2025, 11, 25), "Pendiente"));
            System.out.println(turnoABM.traerTurnosPorFechaYEspecialidad(LocalDate.of(2025, 11, 25), "Administracion"));
            System.out.println(turnoABM.traerTurnosPorFechaYProfesional(LocalDate.of(2025, 11, 25), "Laura"));
            System.out.println("OK");

        } catch (Exception e) {
            System.err.println("Error en TestTurno: " + e.getMessage());
        }
    }
}