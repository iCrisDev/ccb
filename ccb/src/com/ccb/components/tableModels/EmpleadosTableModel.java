package com.ccb.components.tableModels;

import com.ccb.controllers.EmpleadoController;
import com.ccb.pojos.Empleado;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class EmpleadosTableModel extends CCBTableModel{
   
    EmpleadoController empleadoController;

    public EmpleadosTableModel() {
        
        objects = new ArrayList<>();
        header = new String[]{"Nombre","Tipo","Estado"};
        empleadoController = new EmpleadoController();
    }
    
    @Override
    public void initData(Connection connection) {
        objects = (List<Object>)(Object)empleadoController.getAll(connection);
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int column) {
        String value = "";
        Empleado empleado = (Empleado)objects.get(row);
        switch (column) {
            case 0: value = empleado.nombre_completo.toUpperCase();break;
            case 1: value = (empleado.usuario_tipo_usuario == 1 ? "Administrador" : "Empleado").toUpperCase();break;
            case 2: value = (empleado.usuario_estado == 1 ? "Activo" : "Inactivo").toUpperCase();break;
        }
        return value;
    }

    @Override
    public void initData(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
