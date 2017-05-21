package com.ccb.controllers;

import com.ccb.models.DetallesRentaPcModel;
import com.ccb.models.DetallesVentaModel;
import com.ccb.models.ProductoModel;
import com.ccb.models.VentaModel;
import com.ccb.pojos.DetalleRentaPc;
import com.ccb.pojos.DetalleVenta;
import com.ccb.pojos.Venta;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VentaController extends CCBController<Venta>{
    
    VentaModel ventaModel;
    DetallesVentaModel detallesVentaModel;
    DetallesRentaPcModel detallesRentaPcModel;
    ProductoModel productoModel;
 
    public VentaController(){
        ventaModel = new VentaModel();
        detallesVentaModel = new DetallesVentaModel();
        detallesRentaPcModel = new DetallesRentaPcModel();
        productoModel = new ProductoModel();
    }

    @Override
    public boolean create(Connection connection, Venta o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean create(Connection connection, Venta venta, List detalles) {
        List<DetalleVenta> detallesVenta = detalles;
        try {
            connection.setAutoCommit(false);
            int id_venta = ventaModel.create(connection, venta);
            for (DetalleVenta detalleVenta : detallesVenta) {
                detalleVenta.venta_id_venta = id_venta;
                detallesVentaModel.create(connection, detalleVenta);
                if(detalleVenta.producto_tipo_producto == 0){
                    productoModel.reducirExistencia(connection, detalleVenta.producto_cod_producto, detalleVenta.cantidad);
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ex1) {
                System.out.println(ex1.getMessage());
            }
            return false;
        } 
        return true;
    }
    
    public boolean create(Connection connection, Venta venta, DetalleRentaPc detallesRentaPc){
        
        try {
            connection.setAutoCommit(false);
            detallesRentaPc.venta_id_venta = ventaModel.create(connection, venta);
            detallesRentaPcModel.create(connection, detallesRentaPc);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ex1) {
                System.out.println(ex1.getMessage());

            }
            return false;
        } 
        
        return true;
    }

    @Override
    public boolean update(Connection connection, Venta o, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venta> getAll(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
