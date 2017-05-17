package com.ccb.components.tableModels;

import com.ccb.controllers.ProductoController;
import com.ccb.pojos.Producto;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProductoTableModel extends CCBTableModel{
    
    ProductoController productoController = null;
    
    public ProductoTableModel(){
        objects = new ArrayList<>();
        header = new String[]{"Código","Descripción","Tipo","Estado"};
        productoController = new ProductoController();
    }

    @Override
    public void initData(Connection connection) {
        objects = (List<Object>)(Object)productoController.getAll(connection);
        fireTableDataChanged();
    }
    @Override
    public Object getValueAt(int row, int column) {
        String value = null;
        Producto producto = (Producto)objects.get(row);
        
        switch (column) {
            case 0: value = producto.cod_producto.toUpperCase();break;
            case 1: value = producto.descripcion.toUpperCase();break;
            case 2: value = (producto.tipo_producto == 1 ? "Servicio" : "Producto").toUpperCase();break;
            case 3: value = (producto.estado == 1 ? "En linea" : "Descontinuado").toUpperCase();break;
        }
        
        return value;
    }

    @Override
    public void initData(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
