package negocio;

import dao.ProfesionalDao;
import datos.Profesional;

import java.util.List;

public class ProfesionalABM {

    ProfesionalDao dao = new ProfesionalDao();
    
/*AGREGAR PROFESIONAL*/    
    public int agregarProfesional(int dni, String nombre, String apellido, String matricula, double sueldo, boolean activo) throws Exception {
        
        Profesional encontrado = dao.traerDniProfesional(dni);
        
        if (encontrado != null) {
            throw new Exception("YA EXISTE UN PROFESIONAL CON ESE DNI");
        }
        
        Profesional p = new Profesional(dni, nombre, apellido, matricula, sueldo, activo);
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
    public void eliminarProfesional(int idProfesional) throws Exception {
        
        Profesional p = dao.traerProfesionalPorId(idProfesional);
        
        if (p == null) {
            throw new Exception("PROFESIONAL NO ENCONTRADO");
        }
        
        dao.eliminarProfesional(p);
    }

/*TRAER PROFESIONAL POR ID*/    
    public Profesional traer(int idProfesional) {
        return dao.traerProfesionalPorId(idProfesional);
    }

/*TRAER PROFESIONAL POR DNI*/    
    public Profesional traerPorDni(int dni) {
        return dao.traerDniProfesional(dni);
    }

/*TRAER TODOS LOS PROFESIONALES*/    
    public List<Profesional> traerTodos() {
        return dao.traerTodosLosProfesionales();
    }
}
