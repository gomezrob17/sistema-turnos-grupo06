package dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Contacto;

public class ContactoDao {
	
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

	    public int agregarContacto(Contacto objeto) throws HibernateException {
	        int id = 0;
	        try {
	            iniciaOperacion(); // Abre session y comienza tx
	            session.persist(objeto); // No usar save() cuando el ID es foreign
	            tx.commit();
	            id = objeto.getIdContacto(); // El ID se asigna desde el cliente
	            //id = Integer.parseInt(session.save(objeto).toString());
	            //tx.commit();
	        } catch (HibernateException he) {
	            manejaExcepcion(he);
	            throw he;
	        } finally {
	            session.close();
	        }
	        return id;
	    }

	    public void modificarContacto(Contacto objeto) throws HibernateException {
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

	    public void eliminarContacto(Contacto objeto) throws HibernateException {
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

	    public Contacto traerContacto(int idContacto) throws HibernateException {
	    	Contacto objeto = null;
	        try {
	            iniciaOperacion();
	            objeto = (Contacto) session.get(Contacto.class, idContacto);
	            if (objeto.getCliente() != null) {
	                objeto.getCliente().getNombre(); // fuerza la carga
	            }
	        } finally {
	            session.close();
	        }
	        return objeto;
	    }

	    @SuppressWarnings("unchecked")
	    public List<Contacto> traerTodosLosContactos() throws HibernateException {
	        List<Contacto> lista = null;
	        try {
	            iniciaOperacion();
	            lista = session.createQuery("from Contacto c").list();
	        } finally {
	            session.close();
	        }
	        return lista;
	    }
}