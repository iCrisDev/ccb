package com.ccb.models;

import com.ccb.pojos.Usuario;
import com.ccb.utils.Encriptation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */

public class UsuarioModel extends CCBModel<Usuario>{
    
    Encriptation encriptation = new Encriptation();

    @Override
    public Integer create(Connection connection, Usuario usuario) throws SQLException{
        String query = "INSERT INTO usuario (nombre_usuario, contrasenia, tipo_usuario) VALUES('" 
                + usuario.nombre_usuario + "', '" 
                + encriptation.encrypt(usuario.contrasenia) + "', " 
                + usuario.tipo_usuario + ");";
            PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            rs.next();
        return rs.getInt(1);
    }

    @Override
    public Integer update(Connection connection, Usuario usuario, Object id_usuario)  throws SQLException{
        String query = "UPDATE usuario SET "
                + "contrasenia='" + encriptation.encrypt(usuario.contrasenia) + "',"
                + "tipo_usuario=" + usuario.tipo_usuario + " WHERE id_usuario=" + (Integer) id_usuario + ";";
        Statement st = connection.createStatement();
        return st.executeUpdate(query);
    }
    
    public Integer changeStatus(Connection connection, Object estado, Object id_usuario) {
        Integer res = null;
        String query = "UPDATE usuario SET estado=" + (Integer) estado + " WHERE id_usuario=" + (Integer) id_usuario + ";";
        try{
            Statement st = connection.createStatement();
            res = st.executeUpdate(query);

        } catch(SQLException e){
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }

    @Override
    public Integer delete(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getById(Connection connection, Object id) {
        Usuario usuario = null;
        String query = "SELECT * FROM usuario WHERE id_usuario = " + (Integer) id + ";";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                usuario = new Usuario();
                usuario.id_usuario = rs.getInt("id_usuario");
                usuario.nombre_usuario = rs.getString("nombre_usuario");
                usuario.contrasenia = rs.getString("contrasenia");
                usuario.tipo_usuario = rs.getInt("tipo_usuario");
                usuario.estado = rs.getInt("estado");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return usuario;
    }

    @Override
    public List<Usuario> getAll(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean validarNombreUsuario(Connection connection, Object nombre_usuario){
        Boolean res = false;
        String query = "SELECT nombre_usuario FROM usuario WHERE nombre_usuario = '" + (String) nombre_usuario + "';";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            res = rs.next();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return res;
    }

}
