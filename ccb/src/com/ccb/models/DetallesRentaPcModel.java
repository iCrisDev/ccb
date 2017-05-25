package com.ccb.models;

import com.ccb.pojos.DetalleRentaPc;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class DetallesRentaPcModel extends CCBModel<DetalleRentaPc>{

    @Override
    public Integer create(Connection connection, DetalleRentaPc detalleRentaPc) throws SQLException{
        String query = "INSERT INTO detalle_renta_pc (venta_id_venta, id_pc, hora_inicio, hora_fin, tiempo_total) VALUES ("
                + detalleRentaPc.venta_id_venta + ", "
                + detalleRentaPc.id_pc + ", '"
                +  detalleRentaPc.hora_inicio + "' , '"
                + detalleRentaPc.hora_fin + "', '"
                + detalleRentaPc.tiempo_total + "');";
        Statement st = connection.createStatement();
        return st.executeUpdate(query);
    }
    
    @Override
    public Integer update(Connection connection, DetalleRentaPc o, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer delete(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleRentaPc getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleRentaPc> getAll(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
