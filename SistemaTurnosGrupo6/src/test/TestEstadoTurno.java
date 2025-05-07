package test;

import datos.EstadoTurno;
import negocio.EstadoTurnoABM;

public class TestEstadoTurno {

	public static void main(String[] args) {

		EstadoTurnoABM estado = new EstadoTurnoABM();
		
		// --- AGREGO ESTADOS ---
		EstadoTurno e1 = new EstadoTurno("Pendiente");
		EstadoTurno e2 = new EstadoTurno("Atendido");
		EstadoTurno e3 = new EstadoTurno("Cancelado");

		try {
			System.out.println("Agrego Estado: ");
			estado.agregarEstado(e1);
			System.out.println("Cliente agregado: " + e1);
			estado.agregarEstado(e2);
			System.out.println("Cliente agregado: " + e2);
			estado.agregarEstado(e3);
			System.out.println("Cliente agregado: " + e3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		// --- Modifico Estados ---
		try {
			EstadoTurno e4 = estado.traerEstadoPorId(2);
			System.out.println("Estado actual: " + e4);
			e4.setNombre("En Proceso");
			estado.modificarEstado(e4);
			System.out.println("Estado modificado: " + e4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		// --- Elimino un Estado ---
		try {
			EstadoTurno e5 = estado.traerEstadoPorId(3);
			estado.EliminarEstado(e5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		// --- Traer estado por ID ---
		try {
			System.out.println(estado.traerEstadoPorId(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// --- Traer estado por Nombre ---
		try {
			System.out.println(estado.traerEstadoPorNombre("Atendido"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// --- Traer todos los estados ---
		System.out.println(estado.traerTodosLosEstados());
		
	}
}
