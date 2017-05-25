package com.ccb.views;

import com.ccb.components.tableModels.BuscarProductoCompraTableModel;
import com.ccb.components.tableModels.DetallesCompraTableModel;
import com.ccb.connection.CCBConnection;
import com.ccb.controllers.CompraController;
import com.ccb.controllers.ProductoController;
import com.ccb.pojos.Compra;
import com.ccb.pojos.DetalleCompra;
import com.ccb.pojos.Producto;
import com.ccb.pojos.User;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class Compras extends javax.swing.JFrame {

    private List<DetalleCompra> detallesCompra;
    private CCBConnection connection;
    private ProductoController productoController;
    private CompraController compraController;
    private Border borderGray;
    private Border borderRed;
    private String descripcion;
    private float total;
    private int index;
    private boolean update;
    
    public Compras() {
        initComponents();
        init();
    }
    
    private void init(){
        connection = new CCBConnection();
        productoController = new ProductoController();
        compraController = new CompraController();
        detallesCompra = new ArrayList<>();
        borderGray = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
        borderRed = BorderFactory.createLineBorder(Color.red, 1);
        initForm();
    }
    
    private void initForm(){
        setLocationRelativeTo(null);
        setResizable(false);
        txtDescripcion.setEditable(false);
        txtExistencia.setEditable(false);
        txtTotal.setEditable(false);
        tbProductos.setModel(new BuscarProductoCompraTableModel());
        tbDetallesCompra.setModel(new DetallesCompraTableModel());
        updateForm();
    }
    
    private void updateForm(){
        initDataTableDetallesCompra();
        txtCodigo.setText(null);
        txtCodigo.setEditable(true);
        txtCodigo.requestFocus();
        txtDescripcion.setText(null);
        txtExistencia.setText(null);
        txtCantidad.setText(null);
        txtCantidad.setBorder(borderGray);
        txtCosto.setBorder(borderGray);
        txtCosto.setText(null);
        calcularTotal();
        update = false;
        btnAgregar.setText("Agregar");
        btnAgregar.setEnabled(false);
        txtTotal.setText(String.valueOf(total));
        btnRegistrar.setEnabled(!detallesCompra.isEmpty());
        btnReset.setEnabled(!detallesCompra.isEmpty());
    }
    
    private void initDataTableDetallesCompra(){
        ((DetallesCompraTableModel) tbDetallesCompra.getModel()).initData(detallesCompra);
        tbDetallesCompra.getTableHeader().setReorderingAllowed(false) ;
        tbDetallesCompra.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbDetallesCompra.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbDetallesCompra.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbDetallesCompra.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbDetallesCompra.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbDetallesCompra.getColumnModel().getColumn(4).setPreferredWidth(100);
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
        pmOpcionesProducto = new javax.swing.JPopupMenu();
        mnModificar = new javax.swing.JMenuItem();
        mnBorrar = new javax.swing.JMenuItem();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JFormattedTextField();
        txtCosto = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetallesCompra = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtExistencia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

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

        mnModificar.setText("Modificar Compra");
        mnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnModificarActionPerformed(evt);
            }
        });
        pmOpcionesProducto.add(mnModificar);

        mnBorrar.setText("Borrar");
        mnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnBorrarActionPerformed(evt);
            }
        });
        pmOpcionesProducto.add(mnBorrar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Compras");
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

        jLabel1.setText("Código");

        jLabel2.setText("Descripción");

        jLabel3.setText("Cantidad");

        txtCantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#.##"))));
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });

        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCostoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCostoKeyReleased(evt);
            }
        });

        jLabel4.setText("Costo");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tbDetallesCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetallesCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDetallesCompraMouseClicked(evt);
            }
        });
        tbDetallesCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetallesCompraKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetallesCompra);

        jLabel5.setText("Total");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
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

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Existencia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDescripcion)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(192, 192, 192)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnRegistrar)
                    .addComponent(btnReset)
                    .addComponent(btnCerrar))
                .addContainerGap(22, Short.MAX_VALUE))
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(validarCampos()){
            if(!update){
                agregarDetalleCompra();
            }else{
                detallesCompra.set(index, getDetalleCompra());
                updateForm();
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        updateForm();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtCosto.requestFocus();
        }
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(validarCampos()){
                if(!update){
                    agregarDetalleCompra();
                }else{
                    detallesCompra.set(index, getDetalleCompra());
                    updateForm();
                }
            }
        }
    }//GEN-LAST:event_txtCostoKeyPressed

    private void tbDetallesCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetallesCompraMouseClicked
        if (evt.getClickCount() > 1){
            index = tbDetallesCompra.getSelectedRow();
            update = true;
            DetalleCompra detalleCompra = (DetalleCompra) ((DetallesCompraTableModel) tbDetallesCompra.getModel()).getObjectByRow(index);
            setDetalleCompra(detalleCompra);
            btnAgregar.setText("Aceptar");
            txtCodigo.setEditable(false);
        }
        if(evt.isMetaDown()){
            int point = tbDetallesCompra.rowAtPoint(evt.getPoint());
            tbDetallesCompra.setRowSelectionInterval(point, point);
            pmOpcionesProducto.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tbDetallesCompraMouseClicked

    private void mnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnModificarActionPerformed
        index = tbDetallesCompra.getSelectedRow();
        update = true;
        DetalleCompra detalleCompra = (DetalleCompra) ((DetallesCompraTableModel) tbDetallesCompra.getModel()).getObjectByRow(index);
        setDetalleCompra(detalleCompra);
        btnAgregar.setText("Aceptar");
        txtCodigo.setEditable(false);
    }//GEN-LAST:event_mnModificarActionPerformed

    private void mnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnBorrarActionPerformed
        detallesCompra.remove(tbDetallesCompra.getSelectedRow());
        updateForm();
    }//GEN-LAST:event_mnBorrarActionPerformed

    private void tbDetallesCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetallesCompraKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            detallesCompra.remove(tbDetallesCompra.getSelectedRow());
            updateForm();
        }
    }//GEN-LAST:event_tbDetallesCompraKeyPressed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Compra compra = new Compra();
        compra.importe = total;
        compra.empleado_id_empleado = User.id_empleado;
        if(compraController.create(connection.getConnection(), compra, detallesCompra)){
            detallesCompra.clear();
            updateForm();
            informationMessage("REGISTRO EXITOSO", "COMPRA REGISTRADA SATISFACTORIAMENTE");
        }else{
            errorMessage("ERROR AL REGISTRAR", "NO SE PUDO REGISTRAR LA COMPRA");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        if(JOptionPane.showConfirmDialog(null, "¿DESEA CANCELAR LA VENTA EN CURSO?") == 0 ){
            detallesCompra.clear();
            updateForm();
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        if(detallesCompra.isEmpty()){
            closeForm();
        }else{
            if(JOptionPane.showConfirmDialog(null, "HAY UNA COMPRA EN CURSO, ¿REALMENTE DESEA SALIR?") == 0 ){
                closeForm();
            }
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(detallesCompra.isEmpty()){
            closeForm();
        }else{
            if(JOptionPane.showConfirmDialog(null, "HAY UNA VENTA EN CURSO, ¿REALMENTE DESEA SALIR?") == 0 ){
                closeForm();
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped

    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtCostoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoKeyReleased

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtCodigoKeyTyped

    public void agregarDetalleCompra(){
        DetalleCompra detalleCompra = getDetalleCompra();
        if(!buscarDetalleCompra(detalleCompra)){
            detallesCompra.add(detalleCompra);
            updateForm();
        }else{
            warningMessage("", "EL PRODUCTO YA FUE CARGADO A LA COMPRA");
        }
        
    }
    
    public boolean buscarDetalleCompra(DetalleCompra detalle){
        for(DetalleCompra detalleCompra : detallesCompra){
            if(detalleCompra.producto_cod_producto.equals(detalle.producto_cod_producto)){
                    updateForm();
                    int row = detallesCompra.indexOf(detalleCompra);
                    tbDetallesCompra.setRowSelectionInterval(row, row);
                return true;
            }
        }
        return false;
    }
    
    public DetalleCompra getDetalleCompra(){
        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.cantidad = Integer.parseInt(txtCantidad.getText());
        detalleCompra.producto_cod_producto = txtCodigo.getText();
        detalleCompra.producto_descripcion = txtDescripcion.getText();
        detalleCompra.producto_existencia =Integer.parseInt(txtExistencia.getText());
        detalleCompra.producto_costo = Float.parseFloat(txtCosto.getText());
        return detalleCompra;
    }
    
     public void setDetalleCompra(DetalleCompra detalleCompra){
        txtCodigo.setText(detalleCompra.producto_cod_producto);
        txtDescripcion.setText(detalleCompra.producto_descripcion);
        txtExistencia.setText(String.valueOf(detalleCompra.producto_existencia));
        txtCantidad.setText(String.valueOf(detalleCompra.cantidad));
        txtCosto.setText(String.valueOf(detalleCompra.producto_costo));
        txtCodigo.setEditable(false);
        txtCantidad.requestFocus();
        btnAgregar.setEnabled(true);
    }
    
    public void setProducto(Producto producto){
        txtCodigo.setText(producto.cod_producto);
        txtDescripcion.setText(producto.descripcion);
        txtExistencia.setText(String.valueOf(producto.existencia));
        txtCosto.setText(String.valueOf(producto.costo));
        txtCodigo.setEditable(false);
        txtCantidad.requestFocus();
        btnAgregar.setEnabled(true);
    }
    
    private void calcularTotal(){
        total = 0;
        for(int i=0; i<tbDetallesCompra.getRowCount(); i++){
            total += Float.parseFloat(tbDetallesCompra.getValueAt(i, 5).toString());
        }
    }
    
    private boolean validarCampos(){
        if(txtCantidad.getText().isEmpty() || txtCosto.getText().isEmpty()){
            pintarCampos();
            warningMessage("CAMPOS VACIOS", "LOS CAMPOS MARCADOS SON REQUERIDOS");
        } else{
            pintarCampos();
            return true;
        }
        return false;
    }
    
    private void pintarCampos(){
        txtCantidad.setBorder(txtCantidad.getText().isEmpty() ? borderRed:borderGray);
        txtCosto.setBorder(txtCosto.getText().isEmpty() ? borderRed:borderGray);
    }
    
    private boolean validarFlotante(String entrada){
        try{ 
            Float.parseFloat(entrada);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    private boolean validarEntrada(String entrada){
        Pattern pat = Pattern.compile("^[0-9]+(\\.[0-9]{1,2})?$");
        return pat.matcher(entrada).matches();
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
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReset;
    private javax.swing.JFrame fmProductos;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mnBorrar;
    private javax.swing.JMenuItem mnModificar;
    private javax.swing.JPopupMenu pmOpcionesProducto;
    private javax.swing.JTable tbDetallesCompra;
    private javax.swing.JTable tbProductos;
    private javax.swing.JFormattedTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtCosto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtExistencia;
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
