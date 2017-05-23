package com.ccb.controllers;

import com.ccb.models.UsuarioModel;
import com.ccb.pojos.Usuario;
import java.sql.Connection;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class UsuarioController extends CCBController<Usuario>{
    
    UsuarioModel usuarioModel;

    public UsuarioController() {
        usuarioModel = new UsuarioModel();
    }

    @Override
    public boolean create(Connection connection, Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean validarNombreUsuario(Connection connection, Object nombre_usuario){
        return usuarioModel.validarNombreUsuario(connection, nombre_usuario);
    }
    
    public boolean changeStatus(Connection connection, Object estado, Object id_usuario){
        return usuarioModel.changeStatus(connection, estado, id_usuario)==1;
    }

    @Override
    public boolean update(Connection connection, Usuario usuario, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getById(Connection connection, Object id) {
        return usuarioModel.getById(connection, id);
    }

    @Override
    public List<Usuario> getAll(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
