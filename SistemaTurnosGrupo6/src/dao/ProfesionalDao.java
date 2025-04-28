package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Profesional;

public class ProfesionalDao {
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

    public int agregarProfesional(Profesional objeto) throws HibernateException {
        int id = 0;
        try {
            iniciaOperacion();
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

    public void modificarProfesional(Profesional objeto) throws HibernateException {
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

    public void eliminarProfesional(Profesional objeto) throws HibernateException {
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

    public Profesional traerProfesionalPorId(int idProfesional) throws HibernateException {
        Profesional objeto = null;
        try {
            iniciaOperacion();
            objeto = (Profesional) session.get(Profesional.class, idProfesional);
        } finally {
            session.close();
        }
        return objeto;
    }

    public Profesional traerDniProfesional(int dni) throws HibernateException {
        Profesional objeto = null;
        try {
            iniciaOperacion();
            objeto = (Profesional) session.createQuery("from Profesional p where p.dni = :dni").setParameter("dni", dni).uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    }

    @SuppressWarnings("unchecked")
    public List<Profesional> traerTodosLosProfesionales() throws HibernateException {
        List<Profesional> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Profesional p order by p.apellido asc, p.nombre asc").list();
        } finally {
            session.close();
        }
        return lista;
    }
}
