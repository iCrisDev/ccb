package com.ccb.views;

import com.ccb.components.tableModels.BuscarProductoCompraTableModel;
import com.ccb.connection.CCBConnection;
import com.ccb.controllers.AjusteController;
import com.ccb.controllers.ProductoController;
import com.ccb.pojos.Ajuste;
import com.ccb.pojos.Producto;
import com.ccb.pojos.User;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class AjustesInventario extends javax.swing.JFrame {
    
    private Principal principal;
    private CCBConnection connection;
    private ProductoController productoController;
    private AjusteController ajusteController;
    private Border borderGray;
    private Border borderRed;
    private String descripcion;
    private int existencia_pre_ajuste;
    
    private AjustesInventario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public AjustesInventario(Principal principal) {
        initComponents();
        this.principal = principal;
        init();
    }
    
    private void init(){
        connection = new CCBConnection();
        productoController = new ProductoController();
        ajusteController = new AjusteController();
        borderGray = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
        borderRed = BorderFactory.createLineBorder(Color.red, 1);
        initForm();
    }
    
    private void initForm(){
        setLocationRelativeTo(null);
        setResizable(false);
        txtDescripcion.setEditable(false);
        tbProductos.setModel(new BuscarProductoCompraTableModel());
        updateForm();
    }
    
    private void updateForm(){
        txtCodigo.setText(null);
        txtCodigo.setEditable(true);
        txtCodigo.requestFocus();
        txtDescripcion.setText(null);
        txtExistencia.setText(null);
        txtObservaciones.setText(null);
        btnAceptar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }

    private void initDataTableBuscarProducto() {
        ((BuscarProductoCompraTableModel) tbProductos.getModel()).initData(connection.getConnection(), descripcion);
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
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtExistencia = new javax.swing.JTextField();
        txtObservaciones = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ajuste de Inventario");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        txtExistencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExistenciaKeyTyped(evt);
            }
        });

        txtObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObservacionesKeyTyped(evt);
            }
        });

        jLabel1.setText("Código");

        jLabel2.setText("Descripción");

        jLabel3.setText("Existencia");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel4.setText("Observaciones");

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtObservaciones, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar)
                    .addComponent(jButton1))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            descripcion = txtCodigo.getText();
            Producto producto = (productoController.getByIdCompra(connection.getConnection(), descripcion));
            if(producto != null){
                setProducto(producto);
            }else{
                initDataTableBuscarProducto();
                if(tbProductos.getRowCount() > 0){
                    if(tbProductos.getRowCount() == 1){
                        setProducto((Producto) ((BuscarProductoCompraTableModel) tbProductos.getModel()).getObjectByRow(0));
                    }else{
                        fmProductos();
                    }
                }else{
                    warningMessage("", "NO SE ENCONTRO NINGUN PRODUCTO");
                }
            }
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void tbProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            fmProductos.setVisible(false);
            this.setEnabled(true);
        }
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            setProducto((Producto) ((BuscarProductoCompraTableModel) tbProductos.getModel()).getObjectByRow(tbProductos.getSelectedRow()));
            fmProductos.setVisible(false);
            this.setEnabled(true);
        }
    }//GEN-LAST:event_tbProductosKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setProducto((Producto) ((BuscarProductoCompraTableModel) tbProductos.getModel()).getObjectByRow(tbProductos.getSelectedRow()));
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

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
        if(validarCampos()){
            Ajuste ajuste = getAjuste();
            if(ajuste.existencia_post_ajuste != ajuste.existencia_pre_ajuste){
                if(ajusteController.create(connection.getConnection(), ajuste)){
                    updateForm();
                    informationMessage("REGISTRO EXITOSO", "AJUSTE REGISTRADO SATISFACTORIAMENTE");
                }else{
                    errorMessage("ERROR AL REGISTRAR", "NO SE PUDO REGISTRAR EL AJUSTE");
                }
            }else{
                warningMessage("", "NO SE PUEDE REALIZAR EL AJUSTE SI NO MODIFICA LA EXISTENCIA ACTUAL");
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        updateForm();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        closeForm();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeForm();
    }//GEN-LAST:event_formWindowClosing

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtExistenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExistenciaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExistenciaKeyTyped

    private void txtObservacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacionesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObservacionesKeyTyped
    
    public Ajuste getAjuste(){
        Ajuste ajuste = new Ajuste();
        ajuste.producto_cod_producto = txtCodigo.getText();
        ajuste.existencia_pre_ajuste = existencia_pre_ajuste;
        ajuste.existencia_post_ajuste = Integer.parseInt(txtExistencia.getText());
        ajuste.observacion = txtObservaciones.getText();
        ajuste.tipo_ajuste = existencia_pre_ajuste > ajuste.existencia_post_ajuste ? 0 : 1;
        ajuste.empleado_id_empleado = User.id_empleado;
        return ajuste;
    }
    
    public void setProducto(Producto producto){
        txtCodigo.setText(producto.cod_producto);
        txtDescripcion.setText(producto.descripcion);
        txtExistencia.setText(String.valueOf(producto.existencia));
        existencia_pre_ajuste = producto.existencia;
        txtCodigo.setEditable(false);
        txtExistencia.requestFocus();
        btnAceptar.setEnabled(true);
        btnCancelar.setEnabled(true);
        
    }
    
    private boolean validarCampos(){
        if(txtExistencia.getText().isEmpty() || txtObservaciones.getText().isEmpty()){
            pintarCampos();
            warningMessage("CAMPOS VACIOS", "LOS CAMPOS MARCADOS SON REQUERIDOS");
        } else{
            pintarCampos();
            return true;
        }
        return false;
    }
    
    private void pintarCampos(){
        txtExistencia.setBorder(txtExistencia.getText().isEmpty() ? borderRed:borderGray);
        txtObservaciones.setBorder(txtObservaciones.getText().isEmpty() ? borderRed:borderGray);
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
            principal.ajustesInventario = null;
            principal = null;
            connection.getConnection().close();
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(AjustesInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjustesInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjustesInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjustesInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjustesInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JFrame fmProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtObservaciones;
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
