package com.ccb.controllers;

import java.sql.Connection;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public abstract class CCBController<T> {

    public abstract boolean create(Connection connection, T o);

    public abstract boolean update(Connection connection, T o, Object id);

    public abstract boolean delete(Connection connection, Object id);
    
    public abstract T getById(Connection connection, Object id);

    public abstract List<T> getAll(Connection connection);
}
