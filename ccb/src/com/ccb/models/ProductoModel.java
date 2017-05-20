package com.ccb.models;

import com.ccb.pojos.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public Integer update(Connection connection, Producto producto, Object id) {
        Integer res = null;
        String query = "UPDATE producto set "
                + "cod_producto='" + producto.cod_producto + "',"
                + "descripcion='" + producto.descripcion + "',"
                + "costo=" + producto.costo + ","
                + "precio=" + producto.precio + ","
                + "tipo_producto=" + producto.tipo_producto 
                + " WHERE cod_producto ='" + (String) id + "';";
        try{
            Statement st = connection.createStatement();
            res = st.executeUpdate(query);
        }catch(SQLException e){
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }
    
    public Boolean updateStock(Connection connection, Object cod_producto, Object cantidad) throws SQLException{
        String query = "UPDATE producto set existencia = (existencia - " + cantidad 
                +" ) WHERE cod_producto = '" + cod_producto + "';";
        
        Statement st = connection.createStatement();
        System.out.println(query);
        return st.executeUpdate(query) == 1;
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
        Producto wea = new Producto();
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
                //wea = producto;
                productos.add(producto);
            }
        }catch(SQLException e){
            System.err.println(query + "\n" + e.getMessage());
        }
        
                
        System.out.println(productos.contains(wea));
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
}
