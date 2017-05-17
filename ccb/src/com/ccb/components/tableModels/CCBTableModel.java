package com.ccb.components.tableModels;

import java.sql.Connection;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public abstract class CCBTableModel extends AbstractTableModel{

    protected List<Object> objects;
    protected String[] header;
    
    @Override
    public int getRowCount() {
        return objects.size();
    }
    
    @Override
    public int getColumnCount() {
        return header.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    public Object getObjectByRow (int row) {
        return objects.get(row);
    }
    
    public void editRowByObject(int row, Object o) {
        objects.set(row, o);
    }
    
    public void delRow(int row) {
        objects.remove(row);
    }
    
    public abstract void initData(Connection connection);
    
    public abstract void initData(Connection connection, Object id);
}
