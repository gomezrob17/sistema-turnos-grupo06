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
        
        LocalDate fecha = LocalDate.of(2025, 11, 25);
        LocalTime hora = LocalTime.of(17, 0);
        
        try {
            // Agregar un turno (altaTurno)
            System.out.println("********************* ALTA DE TURNO ********************************************");
            
            // Crear un nuevo turno
            
            turnoABM.altaTurno(fecha, hora, clienteABM.consultarPorDni(42555555), profesionalABM.consultarPorMatricula("MATR-1001"), 
            		sucursalABM.traerSucursalPorNombreYDireccion("Sucursal A", "Calle Falsa 123"), estadoTurnoABM.traerEstadoPorNombre("Pendiente"));
            
            turnoABM.altaTurno(fecha, hora, clienteABM.consultarPorDni(41341644), profesionalABM.consultarPorMatricula("MATR-1003"), 
            		sucursalABM.traerSucursalPorNombreYDireccion("Sucursal C", "Calle Real 789"), estadoTurnoABM.traerEstadoPorNombre("Atendido"));
            
            turnoABM.altaTurno(fecha, hora, clienteABM.consultarPorDni(36347647), profesionalABM.consultarPorMatricula("MATR-1002"), 
            		sucursalABM.traerSucursalPorNombreYDireccion("Sucursal B", "Avenida Siempre Viva 456"), estadoTurnoABM.traerEstadoPorNombre("Cancelado"));
   
//          turnoABM.modificarTurno(1, fecha, hora);
        } catch (Exception e) {
            System.err.println("Error en TestTurno: " + e.getMessage());
        }
        
        try {
        	
        	// --------------------- Parte de Tomas ----------------------
        	
        	System.out.println("Traemos Turno con Cliente de Id 1: ");
            System.out.println(turnoABM.traerTurnosPorCliente(1));
            System.out.println("Traemos Turno con Profesional de Id 5: ");
            System.out.println(turnoABM.traerTurnosPorProfesional(5));
            System.out.println("Traemos Turnos entre fechas 25-10 y 25-12");
            System.out.println(turnoABM.traerTurnosPorFechas(LocalDate.of(2025, 10, 25), LocalDate.of(2025, 12, 25)));
            System.out.println("Traemos Turnos en Sucursal A");
            System.out.println(turnoABM.traerTurnosPorNombreSucursal("Sucursal A"));
            System.out.println("Traemos Turnos en Sucursal A en la fecha 25-11");
            System.out.println(turnoABM.traerTurnosPorFechaYSucursal(fecha, "Sucursal A"));
        	
            // --------------------- Parte de Julian ----------------------
            
            System.out.println("Traemos Turnos por Especialidad: Cardiologia");
            System.out.println(turnoABM.traerTurnosPorEspecialidad("Cardiologia"));
            System.out.println("Traemos todos los turnos disponibles");
            System.out.println(turnoABM.traerDetallesTurnos());
            System.out.println("Traemos Turnos Pendientes");
            System.out.println(turnoABM.traerTurnosPorEstados("Pendiente"));
            System.out.println("Traemos Turnos Confirmados entre 25-10 y 25-12");
            System.out.println(turnoABM.traerTurnosConfirmadosEntreFechas(LocalDate.of(2025, 10, 25), LocalDate.of(2025, 12, 25)));
            System.out.println("Traemos Turnos Cancelados entre 25-10 y 25-12");
            System.out.println(turnoABM.traerTurnosCanceladosEntreFechas(LocalDate.of(2025, 10, 25), LocalDate.of(2025, 12, 25)));
            System.out.println("Tramos Turnos con Estado: Pendiente, en la fecha 25-11");
            System.out.println(turnoABM.traerTurnosPorFechaYEstado(LocalDate.of(2025, 11, 25), "Pendiente"));
            System.out.println("Traemos Turnos por Especialidad: Administracion en la fecha 25-11");
            System.out.println(turnoABM.traerTurnosPorFechaYEspecialidad(LocalDate.of(2025, 11, 25), "Administracion"));
            System.out.println("Traemos Turnos por Profesional");
            System.out.println(turnoABM.traerTurnosPorFechaYProfesional(LocalDate.of(2025, 11, 25), "Laura"));
            System.out.println("FIN");

        } catch (Exception e) {
            System.err.println("Error en TestTurno: " + e.getMessage());
        }
    }
}