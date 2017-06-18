package com.ccb.models;

import com.ccb.pojos.Ajuste;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class AjusteModel extends CCBModel<Ajuste>{

    @Override
    public Integer create(Connection connection, Ajuste ajuste) throws SQLException {
        String query = "INSERT INTO ajuste (producto_cod_producto, existencia_pre_ajuste, existencia_post_ajuste,"
                + "tipo_ajuste, observacion, empleado_id_empleado) VALUES ('"
                + ajuste.producto_cod_producto + "',"
                + ajuste.existencia_pre_ajuste + ","
                + ajuste.existencia_post_ajuste + ","
                + ajuste.tipo_ajuste + ",'"
                + ajuste.observacion + "',"
                + ajuste.empleado_id_empleado + ");";
        Statement st = connection.createStatement();
        return st.executeUpdate(query);
    }

    @Override
    public Integer update(Connection connection, Ajuste o, Object id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer delete(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ajuste getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ajuste> getAll(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
