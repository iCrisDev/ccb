package com.ccb.controllers;

import com.ccb.models.ConfigModel;
import java.sql.Connection;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class ConfigController {
    
    public Boolean getTarifasInternet(Connection connection) {
        return new ConfigModel().getTarifasInternet(connection);
    }
    
    public boolean updateConfig(Connection connection){
        return new ConfigModel().updateConfig(connection);
    }

}
