package test;

import java.util.List;

import datos.Sucursal;
import negocio.SucursalABM;

public class TestSucursal {

    public static void main(String[] args) {

        SucursalABM sucursalABM = new SucursalABM();

        try {
        	System.out.println("********************* AGREGAR SUCURSALES ********************************************");
        	Sucursal s1 = new Sucursal("Sucursal A", "Calle Falsa 123");
            Sucursal s2 = new Sucursal("Sucursal B", "Avenida Siempre Viva 456");
            Sucursal s3 = new Sucursal("Sucursal C", "Calle Real 789");

            sucursalABM.agregarSucursal(s1);
            sucursalABM.agregarSucursal(s2);
            sucursalABM.agregarSucursal(s3);

            System.out.println("SUCURSAL AGREGADA : " + s1);
            System.out.println("SUCURSAL AGREGADA : " + s2);
            System.out.println("SUCURSAL AGREGADA : " + s3);
            
            System.out.println("********************* TRAER SUCURSAL POR NOMBRE Y DIRECCIÓN *************************");
            System.out.println("Sucursal encontrada: " + sucursalABM.traerSucursalPorNombreYDireccion("Sucursal A", "Calle Falsa 123"));
            
            System.out.println("********************* CONSULTAR SUCURSAL POR NOMBRE ******************************");
            System.out.println(sucursalABM.consultarSucursalPorNombre("Sucursal B"));
            
            System.out.println("********************* TRAER TODAS LAS SUCURSALES **********************************");
            System.out.println(sucursalABM.traerTodasLasSucursales());
            
//            System.out.println("********************* MODIFICAR SUCURSAL ********************************************");
//            Sucursal sucursalAModificar = new Sucursal("Sucursal A Modificada", "Calle Nueva 123");
//            sucursalABM.modificarSucursal(1,sucursalAModificar);
//            
//            System.out.println("********************* ELIMINAR SUCURSAL ********************************************");
//            sucursalABM.eliminarSucursal(3);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}