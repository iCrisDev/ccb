package com.ccb.controllers;

import com.ccb.models.UsuarioModel;
import com.ccb.pojos.Usuario;
import java.sql.Connection;
import java.util.List;

public class UsuarioController extends CCBController<Usuario>{
    
    UsuarioModel usuarioModel;

    public UsuarioController() {
        usuarioModel = new UsuarioModel();
    }

    @Override
    public boolean create(Connection connection, Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
