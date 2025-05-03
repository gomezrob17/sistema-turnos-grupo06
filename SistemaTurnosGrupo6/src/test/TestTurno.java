package test;

import datos.Cliente;
import datos.Profesional;
import datos.Sucursal;
import negocio.ClienteABM;
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
        ClienteABM clienteABm= new ClienteABM (); 
        ProfesionalABM profesionalABM= new ProfesionalABM (); 
        SucursalABM sucursalABM= new SucursalABM (); 
        try {
            // Agregar un turno (altaTurno)
            System.out.println("********************* ALTA DE TURNO ********************************************");

            // Crear un nuevo turno
            LocalDate fecha = LocalDate.of(2025, 9, 15);
            LocalTime hora = LocalTime.of(17, 0);

            // Registrar el turno (altaTurno)
            turnoABM.modificarTurno(1, fecha, hora);
            System.out.println("OK");

        } catch (Exception e) {
            System.err.println("Error en TestTurno: " + e.getMessage());
        }
    }
}