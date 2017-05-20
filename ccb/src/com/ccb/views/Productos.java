package com.ccb.views;

import com.ccb.components.tableModels.ProductoTableModel;
import com.ccb.connection.CCBConnection;
import com.ccb.controllers.ProductoController;
import com.ccb.pojos.Producto;
import java.awt.Color;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */

public class Productos extends javax.swing.JFrame {

    CCBConnection connection = null;
    private ProductoController productoController = null;
    private final Border borderGray = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
    private final Border borderRed = BorderFactory.createLineBorder(Color.red, 1);
    
    int estado;
    private String cod_producto;
    private boolean update;
    
    public Productos() {
        initComponents();
        init();
    }
    
    private void init(){
        connection = new CCBConnection();
        productoController = new ProductoController();
        initForm();
    }
    
    private void initForm(){
        setLocationRelativeTo(null);
        setResizable(false);
        tbProductos.setModel(new ProductoTableModel());
        initDataTableProductos();
        restartForm();
    }
    
    private void restartForm(){
        txtCodigo.setText(null);
        txtCodigo.setBorder(borderGray);
        txtCodigo.setEditable(true);
        txtCodigo.requestFocus();
        txtDescripcion.setText(null);
        txtDescripcion.setBorder(borderGray);
        cbTipo.setSelectedIndex(0);
        txtCosto.setText(null);
        txtCosto.setBorder(borderGray);
        txtPrecio.setText(null);
        txtPrecio.setBorder(borderGray);
        update = false;
        btnEstado.setVisible(update);
        btnGuardar.setText("Crear");
    }
    
    private void initDataTableProductos() {
        ((ProductoTableModel) tbProductos.getModel()).initData(connection.getConnection());
        tbProductos.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbProductos.getColumnModel().getColumn(1).setPreferredWidth(300);
        tbProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JFormattedTextField();
        txtPrecio = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEstado = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Producto"));

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        jLabel1.setText("Código");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Producto", "Servicio" }));

        jLabel2.setText("Tipo");

        jLabel3.setText("Descripción");

        jLabel4.setText("Costo");

        jLabel5.setText("Precio");

        txtCosto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#.##"))));
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });

        txtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#.##"))));
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtDescripcion)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(131, 131, 131)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

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
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProductos);

        btnGuardar.setText("Crear");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEstado.setText("Descontinuar");
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEstado)
                    .addComponent(btnCancelar))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(validarCampos()){
            if(!update){
                if(!productoController.validarCodProducto(connection.getConnection(), txtCodigo.getText())){
                    if(productoController.create(connection.getConnection(), getDataProducto())){
                        restartForm();
                        initDataTableProductos();
                        informationMessage("REGISTRO EXITOSO","EL PRODUCTO HA SIDO REGISTRADO CON EXITO!");
                    }else{
                        errorMessage("ERROR AL REGISTRAR","POR FAVOR INTENTE MAS TARDE...");
                    }
                }else{
                    warningMessage("IMPOSIBLE REGISTRAR","CODIGO DE PRODUCTO NO DISPONIBLE");
                    txtCodigo.requestFocus();
                }
            }else{
                if(productoController.update(connection.getConnection(), getDataProducto(), cod_producto)){
                    restartForm();
                    initDataTableProductos();
                    informationMessage("REGISTRO EXITOSO","INFORMACIÓN ACTUALIZADA CON EXITO!");
                }else{
                    errorMessage("ERROR AL REGISTRAR","POR FAVOR INTENTE MAS TARDE...");
                }
           }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked
        if (evt.getClickCount() > 1){
            update = true;
            int row = tbProductos.getSelectedRow();
            Producto producto = (Producto) ((ProductoTableModel) tbProductos.getModel()).getObjectByRow(row);
            cod_producto = producto.cod_producto;
            estado = producto.estado;
            setDataProducto(producto);
            btnGuardar.setText("Actualizar");
            btnEstado.setVisible(update);
            txtCodigo.setEditable(false);
        }
    }//GEN-LAST:event_tbProductosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        restartForm();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        if(productoController.cambiarEstado(connection.getConnection(), estado == 1 ? 0 : 1, cod_producto)){
            restartForm();
            initDataTableProductos();
            informationMessage("REGISTRO EXITOSO",estado == 1 ? "EL PRODUCTO HA SIDO DADO DE BAJA" : 
                    "EL PRODUCTO HA SIDO DADO DE ALTA");
        } else {
            errorMessage("ERROR AL REGISTRAR","Por favor intente más tarde...");
        }
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        if(((Character.isLetterOrDigit(evt.getKeyChar()) && validarCodigo(txtCodigo.getText()+evt.getKeyChar())) || 
                Character.isWhitespace(evt.getKeyChar()) || evt.getKeyChar()=='\b') && txtCodigo.getText().length()<10){
            txtCodigo.setBorder((evt.getKeyChar()=='\b' && txtCodigo.getText().isEmpty()) ? borderRed:borderGray);
        }else{
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        if(txtDescripcion.getText().length()<30){
            txtDescripcion.setBorder((evt.getKeyChar()=='\b' && txtDescripcion.getText().isEmpty()) ? borderRed:borderGray);
        }else{
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        if((Character.isDigit(evt.getKeyChar()) || evt.getKeyChar()=='\b' ||
                (evt.getKeyChar()=='.') && !txtCosto.getText().contains(".")) && txtCosto.getText().length()<10){
            txtCosto.setBorder((evt.getKeyChar()=='\b' && txtCosto.getText().isEmpty()) ? borderRed:borderGray);
        }
        else{
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        if((Character.isDigit(evt.getKeyChar()) || evt.getKeyChar()=='\b' ||
                (evt.getKeyChar()=='.') && !txtPrecio.getText().contains(".")) && txtPrecio.getText().length()<10){
            txtPrecio.setBorder((evt.getKeyChar()=='\b' && txtPrecio.getText().isEmpty()) ? borderRed:borderGray);
        }
        else{
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        try {
            connection.getConnection().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            connection.getConnection().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        dispose();
    }//GEN-LAST:event_formWindowClosing
    
    private synchronized Producto getDataProducto(){
        Producto producto = new Producto();
        producto.cod_producto = txtCodigo.getText();
        producto.descripcion = txtDescripcion.getText();
        producto.tipo_producto = cbTipo.getSelectedIndex();
        producto.costo = Float.parseFloat(txtCosto.getText());
        producto.precio = Float.parseFloat(txtPrecio.getText());
        return producto;
    }
    
    private synchronized void setDataProducto(Producto producto){
        txtCodigo.setText(producto.cod_producto);
        txtDescripcion.setText(producto.descripcion);
        cbTipo.setSelectedIndex(producto.tipo_producto);
        txtCosto.setText(producto.costo+"");
        txtPrecio.setText(producto.precio+"");
        btnEstado.setText(producto.estado == 1 ? "Baja" : "Alta");
    }
    
    private boolean validarCampos(){
        if(txtCodigo.getText().isEmpty() || txtDescripcion.getText().isEmpty() || txtCosto.getText().isEmpty() || 
                txtPrecio.getText().isEmpty()){
            pintarCampos();
            warningMessage("CAMPOS VACIOS", "LOS CAMPOS MARCADOS SON REQUERIDOS");
        } else{
            pintarCampos();
            return true;
        }
        return false;
    }
    
    private void pintarCampos(){
        txtCodigo.setBorder(txtCodigo.getText().isEmpty() ? borderRed:borderGray);
        txtDescripcion.setBorder(txtDescripcion.getText().isEmpty() ? borderRed:borderGray);
        txtCosto.setBorder(txtCosto.getText().isEmpty() ? borderRed:borderGray);
        txtPrecio.setBorder(txtPrecio.getText().isEmpty() ? borderRed:borderGray);
    }
    
    public boolean validarCodigo(String entrada){
        Pattern pat = Pattern.compile("^[A-Za-z0-9]+");
        return pat.matcher(entrada).matches();
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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEstado;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtCosto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JFormattedTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
