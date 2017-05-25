package com.ccb.controllers;

import com.ccb.models.ConfigModel;
import com.ccb.pojos.Configuracion;
import java.sql.Connection;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class ConfigController {
    
    public Boolean getConfig(Connection connection) {
        return new ConfigModel().getConfig(connection);
    }
    
    public boolean updateConfig(Connection connection, Configuracion config){
        return new ConfigModel().updateConfig(connection, config);
    }

}
