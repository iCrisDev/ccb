package com.ccb.controllers;

import com.ccb.models.EmpleadoModel;
import com.ccb.models.UsuarioModel;
import com.ccb.pojos.Empleado;
import com.ccb.pojos.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpleadoController extends CCBController<Empleado>{
    
    EmpleadoModel empleadoModel;
    UsuarioModel usuarioModel;

    public EmpleadoController() {
        empleadoModel = new EmpleadoModel();
        usuarioModel = new UsuarioModel();
    }
    
    public boolean create(Connection connection, Empleado empleado, Usuario usuario) {
        boolean res = false;
        
        try {
            connection.setAutoCommit(false);
            empleado.usuario_id_usuario= usuarioModel.create(connection, usuario);
            res = empleadoModel.create(connection, empleado)==1;
            connection.commit();
        } catch (Exception e) {
            if(connection!=null){
                try {
                    System.out.println("ROLLBACK");
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
        return res;
    }

    @Override
    public boolean create(Connection connection, Empleado o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean update(Connection connection, Empleado empleado, Object id_empleado, Usuario usuario, Object id_usuario) {
        boolean res = false;
        
        try {
            connection.setAutoCommit(false);
            usuarioModel.update(connection, usuario, id_usuario);
            res = empleadoModel.update(connection, empleado, id_empleado) == 1;
            connection.commit();
        } catch (Exception e) {
            if(connection!=null){
                try {
                    System.out.println("ROLLBACK");
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
        return res;
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
