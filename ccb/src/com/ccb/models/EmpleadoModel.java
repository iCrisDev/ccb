package com.ccb.models;

import com.ccb.pojos.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class EmpleadoModel extends CCBModel<Empleado>{

    @Override
    public Integer create(Connection connection, Empleado empleado) throws SQLException{
        String query = "INSERT INTO empleado (nombre, ap_paterno, ap_materno, telefono, correo, sexo, direccion, "
                + "usuario_id_usuario,fecha_alta) VALUES "
                + "('" + empleado.nombre + "',"
                + "'" + empleado.ap_paterno + "',"
                + "'" + empleado.ap_materno + "',"
                + "'" + empleado.telefono + "',"
                + "'" + empleado.correo + "',"
                + "'" + empleado.sexo + "',"
                + "'" + empleado.direccion + "',"
                + "'" + empleado.usuario_id_usuario + "',"
                + "CURDATE());";
        Statement st = connection.createStatement();
        return st.executeUpdate(query);
    }

    @Override
    public Integer update(Connection connection, Empleado empleado, Object id) throws SQLException{
        String query = "UPDATE empleado SET "
                + "nombre = '" + empleado.nombre + "',"
                + "ap_paterno = '" + empleado.ap_paterno + "',"
                + "ap_materno = '" + empleado.ap_materno + "',"
                + "telefono = '" + empleado.telefono + "',"
                + "correo = '" + empleado.correo + "',"
                + "sexo = " + empleado.sexo + ","
                + "direccion = '" + empleado.direccion + "' "
                + "WHERE id_empleado = " + (Integer) id + ";";
        Statement st = connection.createStatement();
        return st.executeUpdate(query);
    }

    @Override
    public Integer delete(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado getById(Connection connection, Object id) {
        Empleado empleado = null;
        String query = "SELECT * FROM empleado WHERE id_empleado = " + id;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                empleado = new Empleado();
                empleado.id_empleado = rs.getInt("id_empleado");
                empleado.nombre = rs.getString("nombre");
                empleado.ap_paterno = rs.getString("ap_paterno");
                empleado.ap_materno = rs.getString("ap_materno");
                empleado.sexo = rs.getInt("sexo");
                empleado.telefono = rs.getString("telefono");
                empleado.correo = rs.getString("ap_paterno");
                empleado.direccion = rs.getString("direccion");
            }
        } catch (SQLException e) {
            System.err.println(query + "\n" + e.getMessage());
        }
        return empleado;
    }

    @Override
    public List<Empleado> getAll(Connection connection) {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT "
                + "e.id_empleado,"
                + "e.usuario_id_usuario,"
                + "CONCAT_WS(' ', e.nombre, e.ap_paterno, e.ap_materno) as nombre_completo,"
                + "u.tipo_usuario,"
                + "u.estado "
                + "FROM empleado e "
                + "INNER JOIN usuario u ON e.usuario_id_usuario = u.id_usuario;";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.id_empleado = rs.getInt("id_empleado");
                empleado.usuario_id_usuario = rs.getInt("usuario_id_usuario");
                empleado.nombre_completo = rs.getString("nombre_completo");
                empleado.usuario_tipo_usuario = rs.getInt("tipo_usuario");
                empleado.usuario_estado = rs.getInt("estado");
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.err.println(query + "\n" + e.getMessage());
        }
        return empleados;
    }

}
