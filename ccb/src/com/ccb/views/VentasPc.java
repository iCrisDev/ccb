package com.ccb.views;

import com.ccb.components.tableModels.BuscarProductoVentaTableModel;
import com.ccb.components.tableModels.DetallesVentaTableModel;
import com.ccb.connection.CCBConnection;
import com.ccb.controllers.ProductoController;
import com.ccb.pojos.DetalleVenta;
import com.ccb.pojos.Producto;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class VentasPc extends javax.swing.JFrame{
    
    private List<DetalleVenta> detallesVenta;
    private CCBConnection connection;
    private ProductoController productoCtrl;
    private String descripcion;
    private Integer cantidad;
    private Float total, efectivo, cambio;
    
    public VentasPc(List detallesVenta) {
        initComponents();
        this.detallesVenta = detallesVenta;
        init();
    }

    private VentasPc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void init(){
        connection = new CCBConnection();
        productoCtrl = new ProductoController();
        initForm();
    }
    
    private void initForm(){
        setLocationRelativeTo(null);
        setResizable(false);
        txtTotal.setEditable(false);
        tbProductos.setModel(new BuscarProductoVentaTableModel());
        tbDetallesVenta.setModel(new DetallesVentaTableModel());
        updateForm();
    }
    
    private void updateForm(){
        initDataTableDetallesVenta();
        txtBuscar.setText(null);
        txtBuscar.requestFocus();
        calcularTotal();
        txtTotal.setText(String.valueOf(total));
        btnReset.setEnabled(!detallesVenta.isEmpty());
    }
    
    private void initDataTableDetallesVenta(){
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
        ((BuscarProductoVentaTableModel) tbProductos.getModel()).initData(connection.getConnection(), descripcion);
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
        btnAceptar = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

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
        mnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnBorrarActionPerformed(evt);
            }
        });
        pmOpcionesProducto.add(mnBorrar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Punto de Venta");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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
        tbDetallesVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetallesVentaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetallesVenta);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        jLabel1.setText("Total");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
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
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAceptar)
                        .addComponent(btnReset)
                        .addComponent(btnCerrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap(18, Short.MAX_VALUE))
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
                        agregarDetalleVenta((Producto) ((BuscarProductoVentaTableModel) tbProductos.getModel()).getObjectByRow(0));
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
            agregarDetalleVenta((Producto) ((BuscarProductoVentaTableModel) tbProductos.getModel()).getObjectByRow(tbProductos.getSelectedRow()));
            fmProductos.setVisible(false);
            this.setEnabled(true);
        }
    }//GEN-LAST:event_tbProductosKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        agregarDetalleVenta((Producto) ((BuscarProductoVentaTableModel) tbProductos.getModel()).getObjectByRow(tbProductos.getSelectedRow()));
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
            mnPrecio.setEnabled(detallesVenta.get(tbDetallesVenta.getSelectedRow()).producto_tipo_producto == 1);
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

    private void mnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnBorrarActionPerformed
        detallesVenta.remove(tbDetallesVenta.getSelectedRow());
        updateForm();
    }//GEN-LAST:event_mnBorrarActionPerformed

    private void tbDetallesVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetallesVentaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            detallesVenta.remove(tbDetallesVenta.getSelectedRow());
            updateForm();
        }
    }//GEN-LAST:event_tbDetallesVentaKeyPressed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        if(JOptionPane.showConfirmDialog(null, "¿DESEA CANCELAR LA VENTA EN CURSO?") == 0 ){
            detallesVenta.clear();
            updateForm();
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        closeForm();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeForm();
    }//GEN-LAST:event_formWindowClosing

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if(txtBuscar.getText().length()==50){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

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
    
    private void calcularTotal(){
        total = 0f;
        for(int i=0; i<tbDetallesVenta.getRowCount(); i++){
            total += Float.parseFloat(tbDetallesVenta.getValueAt(i, 5).toString());
        }
    }
    
    private boolean validarEntrada(String entrada){
        Pattern pat = Pattern.compile("^[0-9]+-[A-Za-z0-9]*");
        return pat.matcher(entrada).matches();
    }
    
    private Integer validarEntero(String entrada){
        try{ 
            return Integer.parseInt(entrada);
        }catch(NumberFormatException e){
        }
        return null;
    }
    
    private Float validarFlotante(String entrada){
        try{ 
            return Float.parseFloat(entrada);
        }catch(NumberFormatException e){
        }
        return null;
    }
    
    private void informationMessage(String title, String message){
        JOptionPane.showMessageDialog(null, message, title, 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void warningMessage(String title, String message){
        JOptionPane.showMessageDialog(null, message, title, 
                JOptionPane.WARNING_MESSAGE);
    }
    
    private void errorMessage(String title, String message){
        JOptionPane.showMessageDialog(null, message, title, 
                JOptionPane.ERROR_MESSAGE);
    }
    
    private void closeForm(){
        try {
            connection.getConnection().close();
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(VentasPc.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(VentasPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentasPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentasPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentasPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentasPc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnReset;
    private javax.swing.JFrame fmProductos;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mnBorrar;
    private javax.swing.JMenuItem mnCantidad;
    private javax.swing.JMenuItem mnPrecio;
    private javax.swing.JPopupMenu pmOpcionesProducto;
    private javax.swing.JTable tbDetallesVenta;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    
    private void fmProductos(){
        fmProductos.setSize(520, 250);
        fmProductos.setLocationRelativeTo(null);
        fmProductos.setResizable(false);
        tbProductos.requestFocus();
        this.setEnabled(false);
        
        fmProductos.setVisible(true);
        tbProductos.setRowSelectionInterval(0, 0);
    }
}
