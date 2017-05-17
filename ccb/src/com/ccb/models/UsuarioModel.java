package com.ccb.models;

import com.ccb.pojos.Usuario;
import com.ccb.utils.Encriptation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UsuarioModel extends CCBModel<Usuario>{
    
    Encriptation encriptation = new Encriptation();

    @Override
    public Integer create(Connection connection, Usuario u) {
        Integer res = null;
        String query = "INSERT INTO usuario (nombre_usuario, contrasenia, tipo_usuario) VALUES"
                + "('" + u.nombre_usuario + "', '" + encriptation.encrypt(u.contrasenia) + "', " + u.tipo_usuario + ");";
        try{
            PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.executeUpdate();
            ResultSet insertID = pstm.getGeneratedKeys();
            insertID.next();
            res = insertID.getInt(1);

        } catch(SQLException e){
            System.err.println(query + "\n" + e.getMessage());
        }
        
        return res;
    }

    @Override
    public Integer update(Connection connection, Usuario u, Object id) {
        Integer res = null;
        String query = "UPDATE usuario SET "
                + "contrasenia='" + encriptation.encrypt(u.contrasenia) + "',"
                + "tipo_usuario=" + u.tipo_usuario + " WHERE id_usuario=" + (Integer) id + ";";
        try{
            Statement st = connection.createStatement();
            res = st.executeUpdate(query);

        } catch(SQLException e){
            System.err.println(query + "\n" + e.getMessage());
        }
        
        return res;
    }
    
    public Integer changeStatus(Connection connection, Object estado, Object id) {
        Integer res = null;
        String query = "UPDATE usuario set tipo_usuario=" + (Integer) estado + " where id=" + (Integer) id + ";";
        try{
            Statement st = connection.createStatement();
            res = st.executeUpdate(query);

        } catch(SQLException e){
            System.err.println(query + "\n" + e.getMessage());
        }
        
        return res;
    }
    
    public Integer updateContrasenia(Connection connection, Usuario u, Object id) {
        Integer res = null;
        String query = "UPDATE usuario set contrasenia=" + u.contrasenia + " where id=" + (Integer) id + ";";
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
        Integer res = null;
        String query = "DELETE FROM usuario where id=" + (Integer) id + ";";
        try{
            Statement st = connection.createStatement();
            res = st.executeUpdate(query);

        } catch(SQLException e){
            System.err.println(query + "\n" + e.getMessage());
        }
        
        return res;
    }

    @Override
    public Usuario getById(Connection connection, Object id) {
        Usuario usuario = new Usuario();
        String query = "SELECT * FROM usuario WHERE id_usuario = " + id+";";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
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

    public Boolean validarUsuario(Connection connection, String usuario){
        Boolean res = false;
        String query = "SELECT nombre_usuario FROM usuario WHERE cod_empleado = '" + usuario + "';";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                res = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return res;
    }

}
