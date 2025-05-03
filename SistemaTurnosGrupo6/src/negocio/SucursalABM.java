package negocio;

import java.util.List; // Import correcto para List
import dao.SucursalDao;
import datos.Sucursal;

public class SucursalABM {

    SucursalDao dao = new SucursalDao();

    public int agregarSucursal(Sucursal sucursal) throws Exception {
        // Validación si ya existe una sucursal con el mismo nombre y dirección
        Sucursal existente = dao.traerSucursalPorNombreYDireccion(sucursal.getNombre(), sucursal.getDireccion());

        if (existente != null) {
            throw new Exception("YA EXISTE UNA SUCURSAL CON ESE NOMBRE Y DIRECCIÓN");
        }

        // Agregar la nueva sucursal
        return dao.agregarSucursal(sucursal);
    }

    public void modificarSucursal(int id, Sucursal sucursal) throws Exception {
        Sucursal encontrada = dao.traerSucursalPorId(id);

        if (encontrada == null) {
            throw new Exception("SUCURSAL NO ENCONTRADA");
        }
        
        encontrada.setDireccion(sucursal.getDireccion());
        encontrada.setNombre(sucursal.getNombre());
        dao.modificarSucursal(encontrada);
    }

    public void eliminarSucursal(int id) throws Exception {
        Sucursal encontrada = dao.traerSucursalPorId(id);

        if (encontrada == null) {
            throw new Exception("SUCURSAL NO ENCONTRADA");
        }

        dao.eliminarSucursal(dao.traerSucursalPorId(id));
    }

    // ✅ Obtener todas las sucursales
    public List<Sucursal> traerTodasLasSucursales() throws Exception {
        List<Sucursal> sucursales = dao.traerTodas();

        if (sucursales == null || sucursales.isEmpty()) {
            throw new Exception("NO HAY SUCURSALES REGISTRADAS");
        }

        return sucursales;
    }

    // ✅ Consultar sucursal por nombre
    public List<Sucursal> consultarSucursalPorNombre(String nombre) throws Exception {
        List<Sucursal> sucursales = dao.traerSucursalesPorNombre(nombre);

        if (sucursales == null || sucursales.isEmpty()) {
            throw new Exception("NO SE ENCONTRARON SUCURSALES CON ESE NOMBRE");
        }

        return sucursales;
    }
    
    public Sucursal traerSucursalPorNombreYDireccion(String nombre, String direccion) throws Exception {
        Sucursal sucursal = dao.traerSucursalPorNombreYDireccion(nombre, direccion);

        if (sucursal == null) {
            throw new Exception("NO SE ENCONTRÓ UNA SUCURSAL CON ESE NOMBRE Y DIRECCIÓN");
        }

        return sucursal;
    }
}