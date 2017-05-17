package com.ccb.models;

import com.ccb.pojos.Config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConfigModel {
    
    public Boolean getTarifasInternet(Connection connection){
        
        Boolean resp = false;
        
        String query = "SELECT * from config;";
        
        
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if (rs.next()) {
                resp = true;
                Config.min15 = rs.getFloat("min15");
                Config.min30 = rs.getFloat("min30");
                Config.min45 = rs.getFloat("min45");
                Config.hora = rs.getFloat("hora");
                Config.num_pcs = rs.getInt("num_pcs");
                Config.pcs_por_fila = rs.getInt("pcs_por_fila");

            }
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
        
        return resp;
    }

}
