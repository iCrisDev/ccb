package com.ccb.views;

import com.ccb.components.tableModels.BuscarProductoTableModel;
import com.ccb.components.tableModels.DetallesVentaTableModel;
import com.ccb.connection.CCBConnection;
import com.ccb.controllers.ProductoController;
import com.ccb.controllers.VentaController;
import com.ccb.pojos.DetalleVenta;
import com.ccb.pojos.Producto;
import com.ccb.pojos.User;
import com.ccb.pojos.Venta;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Ventas extends javax.swing.JFrame{
    
    List<DetalleVenta> detallesVenta;
    CCBConnection connection = null;
    ProductoController productoCtrl = null;
    VentaController ventaCtrl;
    String cod_producto;
    int cantidad;
    float total, efectivo, cambio;
    
    public Ventas() {
        initComponents();
        init();
        detallesVenta = new ArrayList<>();
        initForm();
        jButton1.setVisible(false);
    }
    
    public Ventas(List detallesVentaPC){
        initComponents();
        init();
        detallesVenta = detallesVentaPC;
        initForm();
        jButton1.setVisible(true);
        btnCerrar.setVisible(false);
        btnReset.setVisible(false);
        btnCobrar.setVisible(false);
        txtTotal.setVisible(false);
        txtEfectivo.setVisible(false);
        txtCambio.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
    }
    
    public void init(){
        connection = new CCBConnection();
        productoCtrl = new ProductoController();
        ventaCtrl = new VentaController();
    }
    
    public void initForm(){
        setLocationRelativeTo(null);
        setResizable(false);
        txtTotal.setEditable(false);
        txtCambio.setEditable(false);
        tbProductos.setModel(new BuscarProductoTableModel());
        tbDetallesVenta.setModel(new DetallesVentaTableModel());
        initTableDetallesVenta();
        btnCobrar.setEnabled(false);
        txtEfectivo.setEnabled(false);
    }
    
    public void resetForm(){
        detallesVenta = new ArrayList<>();
        initTableDetallesVenta();
        btnCobrar.setEnabled(false);
        txtTotal.setText(null);
        txtEfectivo.setText(null);
        txtCambio.setText(null);
        txtEfectivo.setEnabled(false);
        txtBuscar.requestFocus();
    }
    
    public void initTableDetallesVenta(){
        
        ((DetallesVentaTableModel) tbDetallesVenta.getModel()).initData(detallesVenta);
        tbDetallesVenta.getTableHeader().setReorderingAllowed(false) ;
        tbDetallesVenta.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbDetallesVenta.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbDetallesVenta.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbDetallesVenta.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbDetallesVenta.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbDetallesVenta.getColumnModel().getColumn(4).setPreferredWidth(100);
        
    }
    
    private void initDataTableBuscarProducto(String desc) {

        ((BuscarProductoTableModel) tbProductos.getModel()).initData(connection.getConnection(), desc);
        tbProductos.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbProductos.getColumnModel().getColumn(1).setPreferredWidth(300);
        tbProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fmProductos = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pmOpcionesProducto = new javax.swing.JPopupMenu();
        mnCantidad = new javax.swing.JMenuItem();
        mnPrecio = new javax.swing.JMenuItem();
        mnBorrar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetallesVenta = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCobrar = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        txtEfectivo = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbProductosKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbProductos);

        jButton3.setText("Agregar");

        jButton4.setText("Cancelar");

        javax.swing.GroupLayout fmProductosLayout = new javax.swing.GroupLayout(fmProductos.getContentPane());
        fmProductos.getContentPane().setLayout(fmProductosLayout);
        fmProductosLayout.setHorizontalGroup(
            fmProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fmProductosLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(fmProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fmProductosLayout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        fmProductosLayout.setVerticalGroup(
            fmProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fmProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(fmProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        mnCantidad.setText("Cambiar cantidad");
        mnCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCantidadActionPerformed(evt);
            }
        });
        pmOpcionesProducto.add(mnCantidad);

        mnPrecio.setText("Cambiar precio");
        mnPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPrecioActionPerformed(evt);
            }
        });
        pmOpcionesProducto.add(mnPrecio);

        mnBorrar.setText("Borrar producto");
        mnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnBorrarActionPerformed(evt);
            }
        });
        pmOpcionesProducto.add(mnBorrar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Punto de Venta");

        tbDetallesVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cantidad", "Codigo", "Descripción", "Precio", "Importe"
            }
        ));
        tbDetallesVenta.setComponentPopupMenu(pmOpcionesProducto);
        tbDetallesVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetallesVentaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetallesVenta);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        jLabel1.setText("Total");

        jLabel2.setText("Efectivo");

        jLabel3.setText("Cambio");

        btnCobrar.setText("Cobrar");
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });

        btnReset.setText("Cancelar");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        txtEfectivo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#.##"))));
        txtEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyReleased(evt);
            }
        });

        jButton1.setText("Aceptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCambio, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txtEfectivo)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                    .addComponent(txtBuscar))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnCobrar)
                    .addComponent(btnReset)
                    .addComponent(btnCerrar))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            fmProductos.setVisible(false);
        }
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            int row = tbProductos.getSelectedRow();
            agregarProducto((Producto) ((BuscarProductoTableModel) tbProductos.getModel()).getObjectByRow(row));
            fmProductos.setVisible(false);
        }
    }//GEN-LAST:event_tbProductosKeyPressed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(validarEntrada(txtBuscar.getText())){
                
                Producto producto = (productoCtrl.getById(connection.getConnection(), cod_producto));
                if(producto != null){
                    agregarProducto(producto);
                }else{
                    initDataTableBuscarProducto(cod_producto);
                    if(tbProductos.getRowCount()>0){
                        fmProductos();
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontro ningun producto");
                    }
                }
                
            }else{
                cantidad = 1;
                cod_producto = txtBuscar.getText();
                Producto producto = (productoCtrl.getById(connection.getConnection(), cod_producto));
                if(producto != null){
                    agregarProducto(producto);
                }else{
                    initDataTableBuscarProducto(cod_producto);
                    if(tbProductos.getRowCount()>0){
                        fmProductos();
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontro ningun producto");
                    }
                }
            }
        
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void mnCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCantidadActionPerformed
        cambiarCantidad();
    }//GEN-LAST:event_mnCantidadActionPerformed

    private void mnPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnPrecioActionPerformed

    private void mnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnBorrarActionPerformed
        borrarProducto();
    }//GEN-LAST:event_mnBorrarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        
        if(detallesVenta.isEmpty()){
            dispose();
        }else{
            int resp = JOptionPane.showConfirmDialog(null, "Hay una venta en curso, ¿Realmente desea salir?");
            if(resp==0){
                dispose();
            }
        }
        
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void tbDetallesVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetallesVentaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            borrarProducto();
        }
    }//GEN-LAST:event_tbDetallesVentaKeyPressed

    private void txtEfectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && caracter != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtEfectivoKeyTyped

    private void txtEfectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyReleased
        // TODO add your handling code here:
        try{
        
            efectivo = Float.parseFloat(txtEfectivo.getText());
            cambio = efectivo - total;
            txtCambio.setText(String.valueOf(cambio));
            
            
            btnCobrar.setEnabled(cambio >= 0);
            
            
        }catch(NumberFormatException e){}
    }//GEN-LAST:event_txtEfectivoKeyReleased

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        // TODO add your handling code here:
        Venta venta = new Venta();
        venta.importe = total;
        venta.tipo_venta = 0;
        venta.empleado_id_empleado = User.id_empleado;
        if(ventaCtrl.create(connection.getConnection(), venta, detallesVenta)){
            resetForm();
            JOptionPane.showMessageDialog(null, "Venta registrada con exito!");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo registrar la venta", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_btnResetActionPerformed
    
    public void calcularTotal(){
        total = 0;
        for(int i=0; i<tbDetallesVenta.getRowCount(); i++){
            total += Float.parseFloat(tbDetallesVenta.getValueAt(i, 5).toString());
        }
        
        txtTotal.setText(String.valueOf(total));
    }
    
    public void agregarProducto(Producto producto){
        String [] row = new String[6];
        
            if(!buscarProducto(producto)){
                if((cantidad <= producto.existencia) || (producto.tipo_producto==1)){
                    DetalleVenta detalleVenta = new DetalleVenta();
                    
                    detalleVenta.cantidad = cantidad;
                    detalleVenta.producto_cod_producto = producto.cod_producto;
                    detalleVenta.producto_tipo_producto = producto.tipo_producto;
                    detalleVenta.producto_descripcion = producto.descripcion;
                    detalleVenta.producto_existencia = producto.existencia;
                    detalleVenta.producto_precio = producto.precio;
                    detallesVenta.add(detalleVenta);
                    initTableDetallesVenta();
                    txtBuscar.setText(null);
                    txtBuscar.requestFocus();
                    calcularTotal();
                    txtEfectivo.setEnabled(true);
                    txtEfectivo.setText(null);
                    txtCambio.setText(null);
                    btnCobrar.setEnabled(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Existencia Insuficiente");
                }
                
            }
        
    }
    
    public Boolean buscarProducto(Producto producto){
       
        for(int i=0; i<detallesVenta.size(); i++){
            if(detallesVenta.get(i).producto_cod_producto.equals(producto.cod_producto)){
                cantidad += detallesVenta.get(i).cantidad;
                if((cantidad <= producto.existencia) || (producto.tipo_producto==1)){
                    DetalleVenta detalleVenta = new DetalleVenta();
                    
                    detalleVenta.cantidad = cantidad;
                    detalleVenta.producto_cod_producto = producto.cod_producto;
                    detalleVenta.producto_tipo_producto = producto.tipo_producto;
                    detalleVenta.producto_descripcion = producto.descripcion;
                    detalleVenta.producto_existencia = producto.existencia;
                    detalleVenta.producto_precio = producto.precio;
                    detallesVenta.set(i, detalleVenta);
                    
                    initTableDetallesVenta();
                    txtBuscar.setText(null);
                    txtBuscar.requestFocus();
                    calcularTotal();
                    txtEfectivo.setEnabled(true);
                    txtEfectivo.setText(null);
                    txtCambio.setText(null);
                    btnCobrar.setEnabled(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Existencia Insuficiente");
                }
                
                return true;
            }
        }
        return false;
    }
    
    public void cambiarCantidad(){
        String temp = JOptionPane.showInputDialog("Ingrese la nueva cantidad:");
        try{
            cantidad = Integer.parseInt(temp);
            int cantTemp = Integer.parseInt(tbDetallesVenta.getValueAt(tbDetallesVenta.getSelectedRow(), 0).toString());
            int stockTemp = Integer.parseInt(tbDetallesVenta.getValueAt(tbDetallesVenta.getSelectedRow(), 3).toString());
            System.out.println(cantidad);
            System.out.println(cantTemp);
            System.out.println(stockTemp);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "La cantidad debe ser numerica", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void borrarProducto(){
        
        detallesVenta.remove(tbDetallesVenta.getSelectedRow());
        initTableDetallesVenta();
        calcularTotal();
        
        if(detallesVenta.isEmpty()){
            txtEfectivo.setEnabled(false);
            txtTotal.setText(null);
        }
        txtEfectivo.setText(null);
        txtCambio.setText(null);
        btnCobrar.setEnabled(false);
    }
    
    public boolean validarEntrada(String entrada){
        Pattern pat = Pattern.compile("^[0-9]+-[A-Za-z0-9]+");
        Boolean response = pat.matcher(entrada).matches();
        
        if(response){
            String []values = entrada.split("-");
            cantidad        = Integer.parseInt(values[0]);
            cod_producto    = values[1];
        }
        
        return response;
    }
    
    public void fmProductos(){
        fmProductos.setSize(520, 250);
        fmProductos.setLocationRelativeTo(null);
        fmProductos.setResizable(false);
        tbProductos.requestFocus();
        
        fmProductos.setVisible(true);
        tbProductos.setRowSelectionInterval(0, 0);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnReset;
    private javax.swing.JFrame fmProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mnBorrar;
    private javax.swing.JMenuItem mnCantidad;
    private javax.swing.JMenuItem mnPrecio;
    private javax.swing.JPopupMenu pmOpcionesProducto;
    private javax.swing.JTable tbDetallesVenta;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JFormattedTextField txtEfectivo;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

  


    
}
