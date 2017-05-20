package com.ccb.controllers;

import com.ccb.models.ProductoModel;
import com.ccb.pojos.Producto;
import java.sql.Connection;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */

public class ProductoController extends CCBController<Producto>{
    
    ProductoModel productoModel = null;
    
    public ProductoController(){
        productoModel = new ProductoModel();
    }

    @Override
    public boolean create(Connection connection, Producto producto) {
        return productoModel.create(connection, producto) == 1;
    }
    
    public boolean validarCodProducto(Connection connection, Object cod_producto){
        return productoModel.validarCodProducto(connection, cod_producto);
    }
    
    public boolean cambiarEstado(Connection connection, Object estado, Object cod_producto){
        return productoModel.cambiarEstado(connection, estado, cod_producto)==1;
    }
    
    @Override
    public boolean update(Connection connection, Producto producto, Object id) {
        return productoModel.update(connection, producto, id) == 1;
    }

    @Override
    public boolean delete(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto getById(Connection connection, Object cod_producto) {
        return productoModel.getById(connection, cod_producto);
    }

    @Override
    public List<Producto> getAll(Connection connection) {
        return productoModel.getAll(connection);
    }
    
    public List<Producto> getAllVenta(Connection connection, Object desc) {
        return productoModel.getAllVenta(connection, desc);
    }
    
}
