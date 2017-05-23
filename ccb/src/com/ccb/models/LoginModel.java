package com.ccb.models;

import com.ccb.pojos.User;
import com.ccb.utils.Encriptation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class LoginModel {

    Encriptation encriptation = new Encriptation();
    
    public Boolean loginUsuario(Connection connection, String nombre_usuario, String contrasenia){
        Boolean resp = false;
        String query = "SELECT e.id_empleado, CONCAT_WS(' ',e.nombre,e.ap_paterno,e.ap_materno) as nombreCompleto, "
                + "u.tipo_usuario, u.estado from empleado e INNER JOIN usuario u on e.usuario_id_usuario = u.id_usuario AND "
                + "u.nombre_usuario = '"+nombre_usuario+"' AND u.contrasenia = '"+encriptation.encrypt(contrasenia)+"' "
                + "AND u.estado=1;";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                resp = true;
                User.id_empleado = rs.getInt("id_empleado");
                User.nombreCompleto = rs.getString("nombreCompleto");
                User.tipoUsuario = rs.getInt("tipo_usuario");
                User.estado = rs.getInt("estado");
            }
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
        return resp;
    }
}
