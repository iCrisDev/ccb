package com.ccb.controllers;

import com.ccb.models.EmpleadoModel;
import com.ccb.models.UsuarioModel;
import com.ccb.pojos.Empleado;
import com.ccb.pojos.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */

public class EmpleadoController extends CCBController<Empleado>{
    
    EmpleadoModel empleadoModel;
    UsuarioModel usuarioModel;

    public EmpleadoController() {
        empleadoModel = new EmpleadoModel();
        usuarioModel = new UsuarioModel();
    }
    
    public boolean create(Connection connection, Empleado empleado, Usuario usuario) {        
        try {
            connection.setAutoCommit(false);
            empleado.usuario_id_usuario= usuarioModel.create(connection, usuario);
            empleadoModel.create(connection, empleado);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ex1) {
                System.out.println(ex1.getMessage());

            }
            return false;
        } 
        return true;
    }
    
    public boolean update(Connection connection, Empleado empleado, Object id_empleado, Usuario usuario, Object id_usuario) {
        
        try {
            connection.setAutoCommit(false);
            usuarioModel.update(connection, usuario, id_usuario);
            empleadoModel.update(connection, empleado, id_empleado);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ex1) {
                System.out.println(ex1.getMessage());

            }
            return false;
        } 
        return true;
    }
    
    @Override
    public boolean create(Connection connection, Empleado o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean update(Connection connection, Empleado o, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado getById(Connection connection, Object id) {
        return empleadoModel.getById(connection, id);
    }

    @Override
    public List<Empleado> getAll(Connection connection) {
        return empleadoModel.getAll(connection);
    }

}
