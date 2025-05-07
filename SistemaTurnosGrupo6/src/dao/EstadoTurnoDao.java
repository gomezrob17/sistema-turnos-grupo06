package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.EstadoTurno;

public class EstadoTurnoDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregarEstado(EstadoTurno objeto) throws HibernateException{
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		}finally {
			session.close();
		}
		return id;
	}
	
	public void actualizarEstado(EstadoTurno objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}
	
	public void eliminarEstado(EstadoTurno objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}
	
	public EstadoTurno traerEstadoPorId(int idEstado) throws HibernateException{
		EstadoTurno estado = null;
		try {
			iniciaOperacion();
			estado = (EstadoTurno) session.get(EstadoTurno.class, idEstado);
		} finally {
			session.close();
		}
		return estado;
	}
	
	public EstadoTurno traerEstadoPorNombre(String nombre) throws HibernateException{
		EstadoTurno estado = null;
		try {
			iniciaOperacion();
			estado = (EstadoTurno) session.createQuery("from EstadoTurno c where c.nombre = :nombre", EstadoTurno.class)
					.setParameter("nombre", nombre).uniqueResult();
		} finally {
			session.close();
		}
		return estado;
	}
	
	// Caso de uso: Traer todos los Estados de turno
	public List<EstadoTurno> traerTodosLosEstado() throws HibernateException{
		List<EstadoTurno> estados = null;
		try {
			iniciaOperacion();
			Query<EstadoTurno> query = session.createQuery("from EstadoTurno", EstadoTurno.class);
			estados = query.getResultList();
		} finally {
			session.close();
		}
		return estados;
	}
	
}
