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
import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class Ventas extends javax.swing.JFrame{
    
    List<DetalleVenta> detallesVenta;
    CCBConnection connection = null;
    ProductoController productoCtrl = null;
    VentaController ventaCtrl;
    String descripcion;
    int cantidad;
    float total, efectivo, cambio;
    
    public Ventas() {
        initComponents();
        init();
    }
    
    public void init(){
        connection = new CCBConnection();
        productoCtrl = new ProductoController();
        ventaCtrl = new VentaController();
        initForm();
    }
    
    public void initForm(){
        setLocationRelativeTo(null);
        setResizable(false);
        txtTotal.setEditable(false);
        txtCambio.setEditable(false);
        tbProductos.setModel(new BuscarProductoTableModel());
        tbDetallesVenta.setModel(new DetallesVentaTableModel());
        resetForm();
    }
    
    public void resetForm(){
        detallesVenta = new ArrayList<>();
        initDataTableDetallesVenta();
        txtBuscar.setText(null);
        txtBuscar.requestFocus();
        txtTotal.setText(null);
        txtEfectivo.setText(null);
        txtEfectivo.setEnabled(false);
        txtCambio.setText(null);
        btnCobrar.setEnabled(false);
    }
    
    public void initDataTableDetallesVenta(){
        ((DetallesVentaTableModel) tbDetallesVenta.getModel()).initData(detallesVenta);
        tbDetallesVenta.getTableHeader().setReorderingAllowed(false) ;
        tbDetallesVenta.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbDetallesVenta.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbDetallesVenta.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbDetallesVenta.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbDetallesVenta.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbDetallesVenta.getColumnModel().getColumn(4).setPreferredWidth(100);
    }
    
    private void initDataTableBuscarProducto() {
        ((BuscarProductoTableModel) tbProductos.getModel()).initData(connection.getConnection(), descripcion);
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
        fmCantidad = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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

        fmProductos.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                fmProductosWindowClosing(evt);
            }
        });

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
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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
        pmOpcionesProducto.add(mnBorrar);

        fmCantidad.setTitle("Cambiar cantidad");

        jLabel4.setText("Cantidad:");

        jButton1.setText("Cancelar");

        jButton2.setText("Aceptar");

        javax.swing.GroupLayout fmCantidadLayout = new javax.swing.GroupLayout(fmCantidad.getContentPane());
        fmCantidad.getContentPane().setLayout(fmCantidadLayout);
        fmCantidadLayout.setHorizontalGroup(
            fmCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fmCantidadLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(fmCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(fmCantidadLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1))
                    .addGroup(fmCantidadLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        fmCantidadLayout.setVerticalGroup(
            fmCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fmCantidadLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(fmCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(fmCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(19, Short.MAX_VALUE))
        );

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
        tbDetallesVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDetallesVentaMouseClicked(evt);
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

        btnReset.setText("Cancelar");

        btnCerrar.setText("Cerrar");

        txtEfectivo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#.##"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLabel1))
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
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(validarEntrada(txtBuscar.getText())){
                String[] data = txtBuscar.getText().split("-");
                descripcion = data.length > 1 ? data[1] : "";
                cantidad = Integer.parseInt(data[0]);
            }else{
                descripcion = txtBuscar.getText();
                cantidad = 1;
            }
            Producto producto = (productoCtrl.getById(connection.getConnection(), descripcion));
            if(producto != null){
                agregarDetalleVenta(producto);
            }else{
                initDataTableBuscarProducto();
                if(tbProductos.getRowCount() > 0){
                    if(tbProductos.getRowCount() == 1){
                        agregarDetalleVenta((Producto) ((BuscarProductoTableModel) tbProductos.getModel()).getObjectByRow(0));
                    }else{
                        fmProductos();
                    }
                }else{
                    warningMessage("", "NO SE ENCONTRO NINGUN PRODUCTO");
                }
            }
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void tbProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            fmProductos.setVisible(false);
            this.setEnabled(true);
        }
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            agregarDetalleVenta((Producto) ((BuscarProductoTableModel) tbProductos.getModel()).getObjectByRow(tbProductos.getSelectedRow()));
            fmProductos.setVisible(false);
            this.setEnabled(true);
        }
    }//GEN-LAST:event_tbProductosKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        agregarDetalleVenta((Producto) ((BuscarProductoTableModel) tbProductos.getModel()).getObjectByRow(tbProductos.getSelectedRow()));
        fmProductos.setVisible(false);
        this.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        fmProductos.setVisible(false);
        this.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void fmProductosWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fmProductosWindowClosing
        this.setEnabled(true);
    }//GEN-LAST:event_fmProductosWindowClosing

    private void tbDetallesVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetallesVentaMouseClicked
        if(evt.isMetaDown()){
            int point = tbDetallesVenta.rowAtPoint(evt.getPoint());
            tbDetallesVenta.setRowSelectionInterval(point, point);
            pmOpcionesProducto.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tbDetallesVentaMouseClicked

    private void mnCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCantidadActionPerformed
        int index = tbDetallesVenta.getSelectedRow();
        String entrada = JOptionPane.showInputDialog(null, "ESCRIBA LA CANTIDAD", 
                String.valueOf(detallesVenta.get(index).cantidad));
        do{
            Integer cant = validarEntero(entrada);
            if(cant != null){
                detallesVenta.get(index).cantidad = cant;
                entrada = null;
            }else{
               entrada = JOptionPane.showInputDialog(null, "ESCRIBA UNA CANTIDAD VALIDA", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }while(entrada != null);
        updateForm();
    }//GEN-LAST:event_mnCantidadActionPerformed

    private void mnPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPrecioActionPerformed
        int index = tbDetallesVenta.getSelectedRow();
        DetalleVenta detalleVenta = detallesVenta.get(index);
        String entrada = JOptionPane.showInputDialog(null, "ESCRIBA EL PRECIO", 
                String.valueOf(detalleVenta.producto_precio));
        do{
            Float precio = validarFlotante(entrada);
            if(precio != null){
                detalleVenta.producto_precio = precio;
                if(buscarDetalleVenta(detalleVenta)){
                    detallesVenta.remove(index);
                }
                entrada = null;
            }else{
               entrada = JOptionPane.showInputDialog(null, "ESCRIBA UNA PRECIO VALIDO", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } while(entrada != null);
        updateForm();
    }//GEN-LAST:event_mnPrecioActionPerformed

    public void agregarDetalleVenta(Producto producto){
        DetalleVenta detalleVenta = getDetalleVenta(producto);
        if(!buscarDetalleVenta(detalleVenta)){
            detallesVenta.add(detalleVenta);
        }
        updateForm();
    }
    
    private Boolean buscarDetalleVenta(DetalleVenta detalle){
        for(DetalleVenta detalleVenta : detallesVenta){
            if(detalleVenta.producto_cod_producto.equals(detalle.producto_cod_producto) &&
                    detalleVenta.producto_precio == detalle.producto_precio && 
                    detallesVenta.indexOf(detalleVenta) != detallesVenta.indexOf(detalle)){
                    detalleVenta.cantidad += detalle.cantidad;
                return true;
            }
        }
        return false;
    }
    
    private DetalleVenta getDetalleVenta(Producto producto){
        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.cantidad = cantidad;
        detalleVenta.producto_cod_producto = producto.cod_producto;
        detalleVenta.producto_tipo_producto = producto.tipo_producto;
        detalleVenta.producto_descripcion = producto.descripcion;
        detalleVenta.producto_existencia = producto.existencia;
        detalleVenta.producto_precio = producto.precio;
        return detalleVenta;
    }
    
    private void updateForm(){
        initDataTableDetallesVenta();
        txtBuscar.setText(null);
        txtBuscar.requestFocus();
        calcularTotal();
        txtEfectivo.setEnabled(true);
        txtEfectivo.setText(null);
        txtCambio.setText(null);
        btnCobrar.setEnabled(false);
    }
    
    
    public void calcularTotal(){
        total = 0;
        for(int i=0; i<tbDetallesVenta.getRowCount(); i++){
            total += Float.parseFloat(tbDetallesVenta.getValueAt(i, 5).toString());
        }
        
        txtTotal.setText(String.valueOf(total));
    }
    
    public void borrarProducto(){
        
        detallesVenta.remove(tbDetallesVenta.getSelectedRow());
        initDataTableDetallesVenta();
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
        Pattern pat = Pattern.compile("^[0-9]+-[A-Za-z0-9]*");
        return pat.matcher(entrada).matches();
    }
    
    public Integer validarEntero(String entrada){
        try{ 
            return Integer.parseInt(entrada);
        }catch(NumberFormatException e){
        }
        return null;
    }
    
    public Float validarFlotante(String entrada){
        try{ 
            return Float.parseFloat(entrada);
        }catch(NumberFormatException e){
        }
        return null;
    }
    
    public void informationMessage(String title, String message){
        JOptionPane.showMessageDialog(null, message, title, 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void warningMessage(String title, String message){
        JOptionPane.showMessageDialog(null, message, title, 
                JOptionPane.WARNING_MESSAGE);
    }
    
    public void errorMessage(String title, String message){
        JOptionPane.showMessageDialog(null, message, title, 
                JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JFrame fmCantidad;
    private javax.swing.JFrame fmProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JFormattedTextField txtCantidad;
    private javax.swing.JFormattedTextField txtEfectivo;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    
    public void fmProductos(){
        fmProductos.setSize(520, 250);
        fmProductos.setLocationRelativeTo(null);
        fmProductos.setResizable(false);
        tbProductos.requestFocus();
        this.setEnabled(false);
        
        fmProductos.setVisible(true);
        tbProductos.setRowSelectionInterval(0, 0);
    }
    
    public void fmCantidad(){
        fmCantidad.setSize(300, 200);
        fmCantidad.setLocationRelativeTo(null);
        fmCantidad.setResizable(false);
        txtCantidad.setText(String.valueOf(detallesVenta.get(tbDetallesVenta.getSelectedRow()).cantidad));
        this.setEnabled(false);
        fmCantidad.setVisible(true);
    }
}
