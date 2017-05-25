package com.ccb.components.tableModels;

import com.ccb.controllers.ProductoController;
import com.ccb.pojos.Producto;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class BuscarProductoCompraTableModel extends CCBTableModel{
    
    ProductoController productoController;
    
    public BuscarProductoCompraTableModel(){
        objects = new ArrayList<>();
        header = new String[]{"Código","Descripción","Costo","Existencia"};
        productoController = new ProductoController();
    }

    @Override
    public void initData(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initData(Connection connection, Object descripcion) {
        objects = (List<Object>)(Object)productoController.getAllCompra(connection, descripcion);
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int column) {
        String value = null;
        Producto producto = (Producto)objects.get(row);
        switch (column) {
            case 0: value = producto.cod_producto.toUpperCase();break;
            case 1: value = producto.descripcion.toUpperCase();break;
            case 2: value = String.valueOf(producto.costo).toUpperCase();break;
            case 3: value = String.valueOf(producto.existencia);break;
        }
        return value;
    }

}
