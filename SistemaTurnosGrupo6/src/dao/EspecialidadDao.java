package dao;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Especialidad;
import datos.EstadoTurno;

public class EspecialidadDao {
	
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
	
	    public int agregarEspecialidad(Especialidad objeto) throws HibernateException {
	        int id = 0;
	        try {
	            iniciaOperacion(); // Abre session y comienza tx
	            id = Integer.parseInt(session.save(objeto).toString());
	            tx.commit();
	        } catch (HibernateException he) {
	            manejaExcepcion(he);
	            throw he;
	        } finally {
	            session.close();
	        }
	        return id;
	    }
	
	    public void modificarEspecialidad(Especialidad objeto) throws HibernateException {
	        try {
	            iniciaOperacion();
	            session.update(objeto);
	            tx.commit();
	        } catch (HibernateException he) {
	            manejaExcepcion(he);
	            throw he;
	        } finally {
	            session.close();
	        }
	    }
	
	    public void eliminarEspecialidad(Especialidad objeto) throws HibernateException {
	        try {
	            iniciaOperacion();
	            session.delete(objeto);
	            tx.commit();
	        } catch (HibernateException he) {
	            manejaExcepcion(he);
	            throw he;
	        } finally {
	            session.close();
	        }
	    }
	
	    public Especialidad traerEspecialidad(int idEspecialidad) throws HibernateException {
	    	Especialidad objeto = null;
	        try {
	            iniciaOperacion();
	            objeto = (Especialidad) session.get(Especialidad.class, idEspecialidad);
	        } finally {
	            session.close();
	        }
	        return objeto;
	    }
	
	    @SuppressWarnings("unchecked")
	    public List<Especialidad> traerTodosLasEspecialidad() throws HibernateException {
	    	Session session = HibernateUtil.getSessionFactory().openSession();
	        List<Especialidad> lista = session.createQuery(
	            "select distinct e from Especialidad e left join fetch e.profesionales", 
	            Especialidad.class
	        ).list();
	        session.close();
	        return lista;
	    }

	    public Especialidad traerEspecialidadYProfesionales(int idEspecialidad) {
	    	Especialidad objeto = null;
	        try {
	            iniciaOperacion();
	            String hql="from Especialidad e  where e.idEspecialidad = :idEspecialidad";
	            objeto = (Especialidad) session.createQuery(hql).setParameter("idEspecialidad", idEspecialidad).uniqueResult();
	            Hibernate.initialize(objeto.getProfesionales());
	        } finally {
	            session.close();
	        }
	        return objeto;
	    }

		public Especialidad traerEspecialidadNombre(String nombre) {
			// TODO Auto-generated method stub
			Especialidad objeto = null;
	        try {
	            iniciaOperacion();
				objeto = (Especialidad) session.createQuery("from Especialidad e where e.nombre = :nombre")
						.setParameter("nombre", nombre)
						.uniqueResult();	        } finally {
	            session.close();
	        }
	        return objeto;
		}
}