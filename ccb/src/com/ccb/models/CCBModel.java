package com.ccb.models;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public abstract class CCBModel<T> {

    public abstract Integer create(Connection connection, T o) throws SQLException;

    public abstract Integer update(Connection connection, T o, Object id) throws SQLException;

    public abstract Integer delete(Connection connection, Object id);

    public abstract T getById(Connection connection, Object id);

    public abstract List<T> getAll(Connection connection);
    
}
