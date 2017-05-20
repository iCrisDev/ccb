package com.ccb.models;

import com.ccb.pojos.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */

public class ProductoModel extends CCBModel<Producto>{

    @Override
    public Integer create(Connection connection, Producto producto) {
        Integer res = null;
        String query = "INSERT INTO producto(cod_producto, descripcion, costo, precio, tipo_producto, fecha_alta) "
                + "VALUES ('"
                + producto.cod_producto + "', '"
                + producto.descripcion + "',"
                + producto.costo + ","
                + producto.precio + ","
                + producto.tipo_producto + ","
                + "CURDATE());";
        try {
            Statement st = connection.createStatement();
            res = st.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }

    @Override
    public Integer update(Connection connection, Producto producto, Object cod_producto) {
        Integer res = null;
        String query = "UPDATE producto set "
                + "cod_producto='" + producto.cod_producto + "',"
                + "descripcion='" + producto.descripcion + "',"
                + "costo=" + producto.costo + ","
                + "precio=" + producto.precio + ","
                + "tipo_producto=" + producto.tipo_producto 
                + " WHERE cod_producto ='" + (String) cod_producto + "';";
        try{
            Statement st = connection.createStatement();
            res = st.executeUpdate(query);
        }catch(SQLException e){
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }
    
    public Integer reducirExistencia(Connection connection, Object cod_producto, Object cantidad) throws SQLException{
        String query = "UPDATE producto set existencia = (existencia - " + (Integer) cantidad 
                +") WHERE cod_producto = '" + (String) cod_producto + "';";
        Statement st = connection.createStatement();
        System.out.println(query);
        return st.executeUpdate(query);
    }
    
    public Integer aumentarExistencia(Connection connection, Object cod_producto, Object cantidad) throws SQLException{
        String query = "UPDATE producto set existencia = (existencia + " + (Integer) cantidad 
                +") WHERE cod_producto = '" + (String) cod_producto + "';";
        Statement st = connection.createStatement();
        System.out.println(query);
        return st.executeUpdate(query);
    }
    
    public Integer updateExistencia(Connection connection, Object cod_producto, Object cantidad){
        Integer res = null;
        String query = "UPDATE producto set existencia = " + (Integer) cantidad 
                +" WHERE cod_producto = '" + (String) cod_producto + "';";
        try{
            Statement st = connection.createStatement();
            res = st.executeUpdate(query);
        }catch(SQLException e){
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }
    
    public Integer cambiarEstado(Connection connection, Object estado, Object cod_producto) {
        Integer res = null;
        String query = "UPDATE producto SET estado=" + (Integer) estado + " WHERE cod_producto='" + (String) cod_producto + "';";
        try{
            Statement st = connection.createStatement();
            res = st.executeUpdate(query);

        } catch(SQLException e){
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }

    @Override
    public Integer delete(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto getById(Connection connection, Object cod_producto) {
        Producto producto = null;
        String query = "SELECT * FROM producto WHERE cod_producto='" + (String) cod_producto +"';";
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                producto = new Producto();
                producto.cod_producto = rs.getString("cod_producto");
                producto.descripcion = rs.getString("descripcion");
                producto.estado = rs.getInt("estado");
                producto.costo = rs.getFloat("costo");
                producto.precio = rs.getFloat("precio");
                producto.tipo_producto = rs.getInt("tipo_producto");
                producto.existencia = rs.getInt("existencia");
            }
        }catch(SQLException e){
            System.err.println(query + "\n" + e.getMessage());
        }
        return producto;
    }

    @Override
    public List<Producto> getAll(Connection connection) {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * from producto;";
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Producto producto = new Producto();
                producto.cod_producto = rs.getString("cod_producto");
                producto.descripcion = rs.getString("descripcion");
                producto.estado = rs.getInt("estado");
                producto.costo = rs.getFloat("costo");
                producto.precio = rs.getFloat("precio");
                producto.tipo_producto = rs.getInt("tipo_producto");
                producto.existencia = rs.getInt("existencia");
                productos.add(producto);
            }
        }catch(SQLException e){
            System.err.println(query + "\n" + e.getMessage());
        }
        return productos;
    }
    
    public List<Producto> getAllVenta(Connection connection, Object desc) {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * from producto WHERE descripcion like '%" + (String) desc + "%' AND "
                + "estado=1;";
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Producto producto = new Producto();
                producto.cod_producto = rs.getString("cod_producto");
                producto.descripcion = rs.getString("descripcion");
                producto.estado = rs.getInt("estado");
                producto.costo = rs.getFloat("costo");
                producto.precio = rs.getFloat("precio");
                producto.tipo_producto = rs.getInt("tipo_producto");
                producto.existencia = rs.getInt("existencia");
                productos.add(producto);
            }
        }catch(SQLException e){
            System.err.println(query + "\n" + e.getMessage());
        }
        return productos;
    }
    
    public Boolean validarCodProducto(Connection connection, Object cod_producto){
        Boolean res = false;
        String query = "SELECT cod_producto FROM producto WHERE cod_producto = '" + (String) cod_producto + "';";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            res = rs.next();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return res;
    }
}
