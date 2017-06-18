package com.ccb.controllers;

import com.ccb.models.AjusteModel;
import com.ccb.models.ProductoModel;
import com.ccb.pojos.Ajuste;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class AjusteController extends CCBController <Ajuste>{
    
    private ProductoModel productoModel;
    private AjusteModel ajusteModel;
    
    public AjusteController(){
        productoModel = new ProductoModel();
        ajusteModel = new AjusteModel();
    }

    @Override
    public boolean create(Connection connection, Ajuste ajuste) {
        try{
            connection.setAutoCommit(false);
            productoModel.updateExistencia(connection, ajuste.producto_cod_producto, ajuste.existencia_post_ajuste);
            ajusteModel.create(connection, ajuste);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ex1) {
                System.out.println(ex1.getMessage());

            }
            return false;
        } 
        return true;
    }

    @Override
    public boolean update(Connection connection, Ajuste o, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ajuste getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ajuste> getAll(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
