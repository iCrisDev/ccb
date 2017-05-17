package com.ccb.models;

import java.sql.Connection;
import java.util.List;

public abstract class CCBModel<T> {

    public abstract Integer create(Connection connection, T o);

    public abstract Integer update(Connection connection, T o, Object id);

    public abstract Integer delete(Connection connection, Object id);

    public abstract T getById(Connection connection, Object id);

    public abstract List<T> getAll(Connection connection);
    
}
