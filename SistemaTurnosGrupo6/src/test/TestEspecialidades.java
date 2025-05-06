package test;

import java.util.List;

import datos.Especialidad;
import negocio.EspecialidadABM;

public class TestEspecialidades {

	public static void main(String[] args){
		// TODO Auto-generated method stub

			EspecialidadABM especialidadABM = new EspecialidadABM();
		try {	

				List<Especialidad> listEspecialidad = especialidadABM.traerTodos();
				System.out.println("********************* TRAER TODAS LAS ESPECIALIDADES ********************************************");
				  for (Especialidad e : listEspecialidad) {
		              System.out.println(e.toStringConProfesionales());
		        }

				System.out.println("********************* CONSULTA ESPECIALIDAD POR NOMBRE ********************************************");

				System.out.println(especialidadABM.traer("Medico Clinico"));
				System.out.println(especialidadABM.traer("Alergista"));
		
			} catch (Exception e) {
	        System.err.println("Error en TestEspecialidad: " + e.getMessage());
	    }
	}

}
