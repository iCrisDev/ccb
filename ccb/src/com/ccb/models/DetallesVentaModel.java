package com.ccb.models;

import com.ccb.pojos.DetalleVenta;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class DetallesVentaModel extends CCBModel<DetalleVenta>{

    @Override
    public Integer create(Connection connection, DetalleVenta detalleVenta) throws SQLException{
        String query = "INSERT INTO detalle_venta (venta_id_venta, producto_cod_producto, producto_precio, cantidad) VALUES ("
                + detalleVenta.venta_id_venta+", '"
                + detalleVenta.producto_cod_producto + "', "
                + detalleVenta.producto_precio +  ", "
                + detalleVenta.cantidad+");";
        Statement st = connection.createStatement();
        return st.executeUpdate(query);
    }

    @Override
    public Integer update(Connection connection, DetalleVenta o, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer delete(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleVenta getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleVenta> getAll(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
