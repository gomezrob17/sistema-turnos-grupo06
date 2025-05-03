package dao;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    // Agregar un turno
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
    
    public Turno traerTurnoPorFechaYHora(LocalDate fecha, LocalTime hora, Sucursal sucursal) throws HibernateException {
        Turno turno = null;
        try {
            iniciaOperacion();
            turno = (Turno) session.createQuery("from Turno t where t.fecha = :fecha and t.hora = :hora and t.sucursal = :sucursal")
                .setParameter("fecha", fecha)
                .setParameter("hora", hora)
                .setParameter("sucursal", sucursal)
                .uniqueResult();
        } finally {
            session.close();
        }
        return turno;
    }
    
    public Turno traerTurnoPorId(int idTurno) throws HibernateException {
        Turno turno = null;
        try {
            iniciaOperacion(); // 🔧 abre la sesión y la transacción
            String hql = "FROM Turno t WHERE t.idTurno = :idTurno";
            turno = (Turno) session.createQuery(hql)
                                   .setParameter("idTurno", idTurno)
                                   .uniqueResult();
        } finally {
            if (session != null) session.close(); // 🔧 cierra la sesión
        }
        return turno;
    }
    
    
    public void modificarTurno(Turno turno) throws HibernateException {
        try {
            iniciaOperacion(); // ⚠️ Si esto falta, session es null y da el error que vos tenés
            session.update(turno);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
}