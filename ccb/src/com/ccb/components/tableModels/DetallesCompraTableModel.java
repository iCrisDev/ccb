package com.ccb.components.tableModels;

import com.ccb.pojos.DetalleCompra;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class DetallesCompraTableModel extends CCBTableModel{
    
    public DetallesCompraTableModel(){
        objects = new ArrayList<>();
        header = new String[]{"Cant.", "Código", "Descripción", "Existencia","Costo U.", "Total"};
    }
    
    @Override
    public void initData(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initData(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void initData(Object detalleCompra){
        objects = (List<Object>)(Object)detalleCompra;
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int column) {
        String value = null;
        DetalleCompra detalleCompra = (DetalleCompra)objects.get(row);
        switch(column){
            case 0: value = String.valueOf(detalleCompra.cantidad); break;
            case 1: value = detalleCompra.producto_cod_producto.toUpperCase(); break;
            case 2: value = detalleCompra.producto_descripcion.toUpperCase(); break;
            case 3: value = String.valueOf(detalleCompra.producto_existencia); break;
            case 4: value = String.valueOf(detalleCompra.producto_costo); break;
            case 5: value = String.valueOf(detalleCompra.cantidad * detalleCompra.producto_costo);
        }
        return value;
    }

}
