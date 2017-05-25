package com.ccb.controllers;

import com.ccb.models.CompraModel;
import com.ccb.models.DetallesCompraModel;
import com.ccb.models.ProductoModel;
import com.ccb.pojos.Compra;
import com.ccb.pojos.DetalleCompra;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class CompraController extends CCBController<Compra>{
    
    CompraModel compraModel;
    DetallesCompraModel detallesCompraModel;
    ProductoModel productoModel;
    
    public CompraController(){
        compraModel = new CompraModel();
        detallesCompraModel = new DetallesCompraModel();
        productoModel = new ProductoModel();
    }

    @Override
    public boolean create(Connection connection, Compra o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean create(Connection connection, Compra compra, List detalles) {
        List<DetalleCompra> detallesCompra = detalles;
        try {
            connection.setAutoCommit(false);
            int id_compra = compraModel.create(connection, compra);
            for (DetalleCompra detalleCompra : detallesCompra) {
                detalleCompra.compra_id_compra = id_compra;
                detallesCompraModel.create(connection, detalleCompra);
                productoModel.aumentarExistencia(connection, detalleCompra.producto_cod_producto, detalleCompra.cantidad);
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

    @Override
    public boolean update(Connection connection, Compra o, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Compra getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Compra> getAll(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
