package com.ccb.models;

import com.ccb.pojos.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class VentaModel extends CCBModel<Venta>{

    @Override
    public Integer create(Connection connection, Venta venta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    
    public Integer createExc(Connection connection, Venta venta) throws SQLException{
        Integer res = null;
        String query = "INSERT INTO venta (importe, fecha, empleado_id_empleado, tipo_venta) VALUES ("
                + venta.importe + ", "
                + "CURDATE(), "
                + venta.empleado_id_empleado + ", "
                + venta.tipo_venta + ");";
        
        PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.executeUpdate();
        ResultSet insertID = pstm.getGeneratedKeys();
        insertID.next();
        res = insertID.getInt(1);
            System.out.println(query);
        return res;
    }

    @Override
    public Integer update(Connection connection, Venta o, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer delete(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venta> getAll(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
