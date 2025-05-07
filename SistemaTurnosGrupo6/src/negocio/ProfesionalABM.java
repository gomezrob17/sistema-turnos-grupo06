package negocio;

import dao.ProfesionalDao;
import datos.Cliente;
import datos.Profesional;

import java.util.List;

public class ProfesionalABM {

    ProfesionalDao dao = new ProfesionalDao();
    
/*AGREGAR PROFESIONAL*/    
    public int agregarProfesional(Profesional p) throws Exception {
        
        if (dao.traerDniProfesional(p.getDni()) != null) {
            throw new Exception("YA EXISTE UN PROFESIONAL CON ESE DNI");
        }
        return dao.agregarProfesional(p);
    }

/*MODIFICAR PROFESIONAL*/  
    public void modificarProfesional(Profesional p) throws Exception {
        
        Profesional encontrado = dao.traerProfesionalPorId(p.getIdPersona());
        
        if (encontrado == null) {
            throw new Exception("PROFESIONAL NO ENCONTRADO");
        }
        
        dao.modificarProfesional(p);
    }

/*ELIMINAR PROFESIONAL*/  
    public void eliminarProfesional(Profesional p) throws Exception {
    	
        Profesional encontrado = dao.traerProfesionalPorId(p.getIdPersona());
        
        if (encontrado == null) {
            throw new Exception("PROFESIONAL NO ENCONTRADO");
        }
        
        dao.eliminarProfesional(p);
    }


/*TRAER PROFESIONAL POR DNI*/    
    public Profesional traerPorDni(Profesional p) {
        return dao.traerDniProfesional(p.getDni());
    }

/*TRAER TODOS LOS PROFESIONALES*/    
    public List<Profesional> traerTodos() {
        return dao.traerTodosLosProfesionales();
    }
    
/*CONSULTAR PROFESIONAL POR MATRICULA*/
    public Profesional consultarPorMatricula(String matricula) throws Exception {
        Profesional p = dao.traerPorMatricula(matricula);
        if (p == null) {
            throw new Exception("NO EXISTE NINGUN PROFESIONAL CON MATRICULA: " + matricula);
        }
        return p;
    }
    
/*LISTAR PROFESIONALES ACTIVOS ES DECIR, ACTIVO = TRUE*/    
    public List<Profesional> listarProfesionalesActivos() {
        return dao.listarProfesionalesActivos();
    }    
    
/*LISTAR PROFESIONALES CON SUELDO MAYOR A EL MONTO RECIBIDO POR PARAMETRO*/        
    public List<Profesional> listarPorSueldoMayor(double sueldoMin) {
        return dao.listarProfesionalesConSueldoMayor(sueldoMin);
    }
    
}
