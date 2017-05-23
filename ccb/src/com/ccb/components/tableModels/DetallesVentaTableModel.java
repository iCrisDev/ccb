package com.ccb.components.tableModels;

import com.ccb.pojos.DetalleVenta;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class DetallesVentaTableModel extends CCBTableModel{
    
    public DetallesVentaTableModel(){
        objects = new ArrayList<>();
        header = new String[]{"Cant.", "Código", "Descripción", "Existencia","Precio U.", "Total"};
    }

    @Override
    public void initData(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initData(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void initData(Object detalleVenta){
        objects = (List<Object>)(Object)detalleVenta;
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int column) {
        String value = null;
        DetalleVenta detalleVenta = (DetalleVenta)objects.get(row);
        switch(column){
            case 0: value = String.valueOf(detalleVenta.cantidad); break;
            case 1: value = detalleVenta.producto_cod_producto.toUpperCase(); break;
            case 2: value = detalleVenta.producto_descripcion.toUpperCase(); break;
            case 3: value = detalleVenta.producto_tipo_producto == 0 ? String.valueOf(detalleVenta.producto_existencia):"-"; break;
            case 4: value = String.valueOf(detalleVenta.producto_precio); break;
            case 5: value = String.valueOf(detalleVenta.cantidad*detalleVenta.producto_precio);
        }
        return value;
    }

}
