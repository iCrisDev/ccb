package com.ccb.components.tableModels;

import com.ccb.controllers.ProductoController;
import com.ccb.pojos.Producto;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BuscarProductoTableModel extends CCBTableModel{
    
    ProductoController productoController = null;
    
    public BuscarProductoTableModel(){
        objects = new ArrayList<>();
        header = new String[]{"Código","Descripción","Precio","Existencia"};
        productoController = new ProductoController();
    }

    @Override
    public void initData(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void initData(Connection connection, Object desc) {
        objects = (List<Object>)(Object)productoController.getAllVenta(connection, desc);
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int column) {
        String value = null;
        Producto producto = (Producto)objects.get(row);
        switch (column) {
            case 0: value = producto.cod_producto.toUpperCase();break;
            case 1: value = producto.descripcion.toUpperCase();break;
            case 2: value = String.valueOf(producto.precio).toUpperCase();break;
            case 3: value = producto.tipo_producto==0 ? String.valueOf(producto.existencia).toUpperCase():"-";break;
        }
        return value;
    }

    
}
