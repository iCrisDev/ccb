package com.ccb.models;

import com.ccb.pojos.DetalleCompra;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class DetallesCompraModel extends CCBModel<DetalleCompra>{

    @Override
    public Integer create(Connection connection, DetalleCompra detalleCompra) throws SQLException {
        String query = "INSERT INTO detalle_compra (compra_id_compra, producto_cod_producto, producto_costo, cantidad) VALUES ("
                + detalleCompra.compra_id_compra+", '"
                + detalleCompra.producto_cod_producto + "', "
                + detalleCompra.producto_costo+  ", "
                + detalleCompra.cantidad+");";
        Statement st = connection.createStatement();
        return st.executeUpdate(query);
    }

    @Override
    public Integer update(Connection connection, DetalleCompra o, Object id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer delete(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleCompra getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleCompra> getAll(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
