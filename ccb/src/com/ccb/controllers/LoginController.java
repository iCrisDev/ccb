package com.ccb.controllers;

import com.ccb.models.LoginModel;
import java.sql.Connection;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class LoginController {
    
    public boolean accesoUsuario(Connection connection, String nombre_usuario, String contrasenia) {
        return new LoginModel().loginUsuario(connection, nombre_usuario, contrasenia);
    }
}
