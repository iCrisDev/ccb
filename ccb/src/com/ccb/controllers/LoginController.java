package com.ccb.controllers;

import com.ccb.models.LoginModel;
import com.ccb.models.ConfigModel;
import java.sql.Connection;

public class LoginController {
    
    public Boolean accesoUsuario(Connection connection, String nombre_usuario, String contrasenia) {
        return new LoginModel().loginUsuario(connection, nombre_usuario, contrasenia);
    }
    
    public Boolean getTarifasInternet(Connection connection) {
        return new ConfigModel().getTarifasInternet(connection);
    }
}
