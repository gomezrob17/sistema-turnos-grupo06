package dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.EstadoTurno;
import datos.Profesional;
import datos.Sucursal;
import datos.Turno;

public class TurnoDao {
    private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        if (tx != null) tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }


    public int agregarTurno(Turno turno) throws HibernateException {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(turno).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }
    
    public Turno traerTurnoPorFechaYHoraYProfesional(LocalDate fecha, LocalTime hora, Sucursal sucursal, Profesional profesional) throws HibernateException {
        Turno turno = null;
        try {
            iniciaOperacion();
            turno = (Turno) session.createQuery(
                "from Turno t where t.fecha = :fecha and t.hora = :hora and t.sucursal = :sucursal and t.profesional = :profesional")
                .setParameter("fecha", fecha)
                .setParameter("hora", hora)
                .setParameter("sucursal", sucursal)
                .setParameter("profesional", profesional)
                .uniqueResult();
        } finally {
            session.close();
        }
        return turno;
    }
    
    public Turno traerTurnoPorId(int idTurno) throws HibernateException {
        Turno turno = null;
        try {
            iniciaOperacion();
            String hql = "FROM Turno t WHERE t.idTurno = :idTurno";
            turno = (Turno) session.createQuery(hql)
                                   .setParameter("idTurno", idTurno)
                                   .uniqueResult();
        } finally {
            if (session != null) session.close();
        }
        return turno;
    }
    
    
    public void modificarTurno(Turno turno) throws HibernateException {
        try {
            iniciaOperacion();
            session.update(turno);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
    
    
    public List<Turno> traerTurnosPorCliente(int idCliente) throws HibernateException {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            String hql = "FROM Turno t " +
                         "JOIN FETCH t.cliente " +
                         "JOIN FETCH t.profesional " +
                         "JOIN FETCH t.sucursal " +
                         "JOIN FETCH t.estado " +
                         "WHERE t.cliente.idPersona = :idCliente AND t.estado.nombre = 'Pendiente'";
            lista = session.createQuery(hql, Turno.class)
                           .setParameter("idCliente", idCliente)
                           .list();
        } finally {
            if (session != null) session.close();
        }
        return lista;
    }
    
    public List<Turno> traerTurnosPorProfesional(int idProfesional) throws HibernateException {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            String hql = "FROM Turno t " +
                         "JOIN FETCH t.profesional " +
                         "JOIN FETCH t.cliente " +
                         "JOIN FETCH t.sucursal " +
                         "JOIN FETCH t.estado " +
                         "WHERE t.profesional.idPersona = :idProfesional AND t.estado.nombre = 'Pendiente'";
            lista = session.createQuery(hql, Turno.class)
                           .setParameter("idProfesional", idProfesional)
                           .list();
        } finally {
            if (session != null) session.close();
        }
        return lista;
    }
    
    public List<Turno> traerTurnosPorFechas(LocalDate fechaInicio, LocalDate fechaFin) throws HibernateException {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            String hql = "FROM Turno t " +
                         "JOIN FETCH t.cliente " +
                         "JOIN FETCH t.profesional " +
                         "JOIN FETCH t.sucursal " +
                         "JOIN FETCH t.estado " +
                         "WHERE t.fecha BETWEEN :fechaInicio AND :fechaFin";
            lista = session.createQuery(hql, Turno.class)
                           .setParameter("fechaInicio", fechaInicio)
                           .setParameter("fechaFin", fechaFin)
                           .list();
        } finally {
            if (session != null) session.close();
        }
        return lista;
    }
    
    public List<Turno> traerTurnosPorNombreSucursal(String nombreSucursal) throws HibernateException {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            String hql = "FROM Turno t " +
                         "JOIN FETCH t.cliente " +
                         "JOIN FETCH t.profesional " +
                         "JOIN FETCH t.sucursal " +
                         "JOIN FETCH t.estado " +
                         "WHERE t.sucursal.nombre = :nombreSucursal";
            lista = session.createQuery(hql, Turno.class)
                           .setParameter("nombreSucursal", nombreSucursal)
                           .list();
        } finally {
            if (session != null) session.close();
        }
        return lista;
    }
    
    public List<Turno> traerTurnosPorFechaYSucursal(LocalDate fecha, String nombreSucursal) throws HibernateException {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            String hql = "FROM Turno t " +
                         "JOIN FETCH t.cliente " +
                         "JOIN FETCH t.profesional " +
                         "JOIN FETCH t.sucursal " +
                         "JOIN FETCH t.estado " +
                         "WHERE t.fecha = :fecha AND t.sucursal.nombre = :nombreSucursal";
            lista = session.createQuery(hql, Turno.class)
                           .setParameter("fecha", fecha)
                           .setParameter("nombreSucursal", nombreSucursal)
                           .list();
        } finally {
            if (session != null) session.close();
        }
        return lista;
    }
    
    // --- 2da Parte ---
    
    // Traer Turnos por Especialidad
    public List<Turno> traerTurnosPorEspecialidad(String nombreEspecialidad) throws HibernateException {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            String hql = "SELECT DISTINCT t FROM Turno t " +
                         "JOIN FETCH t.cliente " +
                         "JOIN FETCH t.profesional p " +
                         "JOIN FETCH p.especialidades e " +       // Profesional tiene el set llamado "especialidades" para este caso
                         "JOIN FETCH t.sucursal " +
                         "JOIN FETCH t.estado " +
                         "WHERE e.nombre = :nombreEspecialidad AND t.estado.nombre = 'Pendiente'";
            lista = session.createQuery(hql, Turno.class)
                           .setParameter("nombreEspecialidad", nombreEspecialidad)
                           .list();
        } finally {
        	if (session != null) session.close();
        }
        return lista;
    }
    
    // Ver Detalles de Turnos
    public List<Turno> traerTurnos() throws HibernateException{
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			String hql = "SELECT DISTINCT t FROM Turno t " +
                    		"JOIN FETCH t.cliente " +
                    		"JOIN FETCH t.profesional " +
                    		"JOIN FETCH t.sucursal " +
                    		"JOIN FETCH t.estado";
			lista = session.createQuery(hql, Turno.class).list();
		} finally {
			if (session != null) session.close();
		}
		return  lista;
	}
    
    //Traer Turnos por Estado (Pendiente/Atendido/Cancelado)
    public List<Turno> traerTurnosPorEstado(String nombreEstado) throws HibernateException {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            String hql = "FROM Turno t " +
                         "JOIN FETCH t.profesional " +
                         "JOIN FETCH t.cliente " +
                         "JOIN FETCH t.sucursal " +
                         "JOIN FETCH t.estado " +
                         "WHERE t.estado.nombre = :nombreEstado";
            Query<Turno> query = session.createQuery(hql, Turno.class)
                           .setParameter("nombreEstado", nombreEstado);
            lista = query.getResultList();
        } finally {
        	if (session != null) session.close();
        }
        return lista;
    }
    
    // Confirmados = Pendientes (No Atendidos)
    public List<Turno> traerTurnosConfirmadosPorFecha(LocalDate fechaInicio, LocalDate fechaFin) throws HibernateException {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            String hql = "FROM Turno t " +
                         "JOIN FETCH t.cliente " +
                         "JOIN FETCH t.profesional " +
                         "JOIN FETCH t.sucursal " +
                         "JOIN FETCH t.estado " +
                         "WHERE t.estado.nombre = 'Pendiente' AND t.fecha BETWEEN :fechaInicio AND :fechaFin";
            Query<Turno> query = session.createQuery(hql, Turno.class)
                           .setParameter("fechaInicio", fechaInicio)
                           .setParameter("fechaFin", fechaFin);
            lista = query.getResultList();
        } finally {
        	if (session != null) session.close();
        }
        return lista;
    }
    
    public List<Turno> traerTurnosCanceladosPorFecha(LocalDate fechaInicio, LocalDate fechaFin) throws HibernateException {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            String hql = "FROM Turno t " +
                         "JOIN FETCH t.cliente " +
                         "JOIN FETCH t.profesional " +
                         "JOIN FETCH t.sucursal " +
                         "JOIN FETCH t.estado " +
                         "WHERE t.estado.nombre = 'Cancelado' AND t.fecha BETWEEN :fechaInicio AND :fechaFin";
            Query<Turno> query = session.createQuery(hql, Turno.class)
                           .setParameter("fechaInicio", fechaInicio)
                           .setParameter("fechaFin", fechaFin);
            lista = query.getResultList();
        } finally {
        	if (session != null) session.close();
        }
        return lista;
    }
    
    
    public List<Turno> traerTurnosPorFechaYEstado(LocalDate fecha, String nombreEstado) throws HibernateException {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            String hql = "SELECT DISTINCT t FROM Turno t " +
                         "JOIN FETCH t.cliente " +
                         "JOIN FETCH t.profesional " +
                         "JOIN FETCH t.sucursal " +
                         "JOIN FETCH t.estado " +
                         "WHERE t.fecha = :fecha AND t.estado.nombre = :nombreEstado";
            Query<Turno> query = session.createQuery(hql, Turno.class)
                           .setParameter("fecha", fecha)
                           .setParameter("nombreEstado", nombreEstado);
            lista = query.getResultList();
        } finally {
        	if (session != null) session.close();
        }
        return lista;
    }
    
    public List<Turno> traerTurnosPorFechaYProfesional(LocalDate fecha, String nombreProfesional) throws HibernateException {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            String hql = "FROM Turno t " +
                         "JOIN FETCH t.cliente " +
                         "JOIN FETCH t.profesional " +
                         "JOIN FETCH t.sucursal " +
                         "JOIN FETCH t.estado " +
                         "WHERE t.fecha = :fecha AND t.profesional.nombre = :nombreProfesional";
            Query<Turno> query = session.createQuery(hql, Turno.class)
                           .setParameter("fecha", fecha)
                           .setParameter("nombreProfesional", nombreProfesional);
            lista = query.getResultList();
        } finally {
        	if (session != null) session.close();
        }
        return lista;
    }
    
    // Punto importante!
    public List<Turno> traerTurnosPorFechaYEspecialidad(LocalDate fecha, String nombreEspecialidad) throws HibernateException {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            String hql = "FROM Turno t " +
                         "JOIN FETCH t.cliente " +
                         "JOIN FETCH t.profesional p " +
                         "JOIN FETCH p.especialidades e " +		// Profesional tiene el set llamado "especialidades" para este caso
                         "JOIN FETCH t.sucursal " +
                         "JOIN FETCH t.estado " +
                         "WHERE t.fecha = :fecha AND e.nombre = :nombreEspecialidad";
            Query<Turno> query = session.createQuery(hql, Turno.class)
                           .setParameter("fecha", fecha)
                           .setParameter("nombreEspecialidad", nombreEspecialidad);
            lista = query.getResultList();
        } finally {
        	if (session != null) session.close();
        }
        return lista;
    }
    
    
    
}