package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Sucursal;

public class SucursalDao {
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

    public int agregarSucursal(Sucursal sucursal) throws HibernateException {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(sucursal).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }

    public void modificarSucursal(Sucursal sucursal) throws HibernateException {
        try {
            iniciaOperacion();
            session.update(sucursal);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public void eliminarSucursal(Sucursal sucursal) throws HibernateException {
        try {
            iniciaOperacion();
            session.delete(sucursal);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public Sucursal traerSucursalPorId(int idSucursal) throws HibernateException {
        Sucursal objeto = null;
        try {
            iniciaOperacion();
            objeto = session.get(Sucursal.class, idSucursal);
        } finally {
            session.close();
        }
        return objeto;
    }

    public Sucursal traerSucursalPorNombreYDireccion(String nombre, String direccion) throws HibernateException {
        Sucursal sucursal = null;
        try {
            iniciaOperacion();
            Query<Sucursal> query = session.createQuery(
                "from Sucursal s where s.nombre = :nombre and s.direccion = :direccion", Sucursal.class);
            query.setParameter("nombre", nombre);
            query.setParameter("direccion", direccion);
            sucursal = query.uniqueResult();
        } finally {
            session.close();
        }
        return sucursal;
    }


    public List<Sucursal> traerSucursalesPorNombre(String nombre) throws HibernateException {
        List<Sucursal> lista = null;
        try {
            iniciaOperacion();
            Query<Sucursal> query = session.createQuery(
                "from Sucursal s where s.nombre = :nombre", Sucursal.class);
            query.setParameter("nombre", nombre);
            lista = query.getResultList();
        } finally {
            session.close();
        }
        return lista;
    }


    public List<Sucursal> traerTodas() throws HibernateException {
        List<Sucursal> lista = null;
        try {
            iniciaOperacion();
            Query<Sucursal> query = session.createQuery("from Sucursal", Sucursal.class);
            lista = query.getResultList();
        } finally {
            session.close();
        }
        return lista;
    }
}