package com.ccb.views;

import com.ccb.components.tableModels.DetallesVentaPcTableModel;
import com.ccb.connection.CCBConnection;
import com.ccb.controllers.VentaController;
import com.ccb.pojos.User;
import com.ccb.pojos.Venta;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class DetallesPC extends javax.swing.JFrame {
   
    private PC pc;
    private VentaController ventaController;
    private CCBConnection connection;
    private SimpleDateFormat horaFormat;
    private Float total, cambio, efectivo;
    private boolean extras;
    
    private DetallesPC() {
        initComponents();
    }
    
    public DetallesPC(PC pc) {
        this.pc = pc;
        initComponents();
        init();
    }
    
    private void init(){
        ventaController = new VentaController();
        connection = new CCBConnection();
        horaFormat = new SimpleDateFormat("hh:mm:ss a");
        initForm();
    }
    
    private void initForm(){
        setLocationRelativeTo(null);
        setResizable(false);
        tbDetallesVenta.setModel(new DetallesVentaPcTableModel());
        initTableDetallesVenta();
        initTableDetalleRentaPc();
        btnCobrar.setEnabled(false);
        txtTotal.setEditable(false);
        txtCambio.setEditable(false);
        calcularTotal();
        txtTotal.setText(String.valueOf(total+pc.detalleRentaPc.total));
    }
    
    private void initTableDetallesVenta(){
        ((DetallesVentaPcTableModel) tbDetallesVenta.getModel()).initData(pc.detallesVentaPC);
        tbDetallesVenta.getTableHeader().setReorderingAllowed(false) ;
        tbDetallesVenta.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbDetallesVenta.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbDetallesVenta.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
    
    private void initTableDetalleRentaPc(){
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        };
        String[] headers = {"Inicio","Fin","Tiempo","Total"};
        tableModel.setColumnIdentifiers(headers);
        String[] pcInfo = new String[4];
                pcInfo[0] = horaFormat.format(new Date());

//        pcInfo[0] = horaFormat(pc.detalleRentaPc.hora_inicio);
        pcInfo[1] = horaFormat(pc.detalleRentaPc.hora_fin);
        pcInfo[2] = pc.detalleRentaPc.tiempo_total;
        pcInfo[3] = String.valueOf(pc.detalleRentaPc.total);
        tableModel.addRow(pcInfo);
        tbPcInfo.setModel(tableModel);
        tbPcInfo.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbPcInfo.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbPcInfo.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbPcInfo.getColumnModel().getColumn(3).setPreferredWidth(100);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCobrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPcInfo = new javax.swing.JTable();
        btnReanudar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetallesVenta = new javax.swing.JTable();
        txtEfectivo = new javax.swing.JFormattedTextField();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
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

        tbPcInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Inicio", "Fin", "Tiempo", "Total"
            }
        ));
        tbPcInfo.setSize(new java.awt.Dimension(480, 80));
        jScrollPane1.setViewportView(tbPcInfo);

        btnReanudar.setText("Reanudar");
        btnReanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReanudarActionPerformed(evt);
            }
        });

        tbDetallesVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cantidad", "Codigo", "Descripción", "Importe"
            }
        ));
        jScrollPane2.setViewportView(tbDetallesVenta);

        txtEfectivo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#.##"))));
        txtEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyReleased(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReanudar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCambio)
                            .addComponent(txtTotal)
                            .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnCobrar)
                    .addComponent(btnReanudar)
                    .addComponent(btnCerrar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReanudarActionPerformed
        pc.reanudar();
        closeForm();
    }//GEN-LAST:event_btnReanudarActionPerformed

    private void txtEfectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyReleased
        efectivo = validarFlotante(txtEfectivo.getText());
        if(efectivo != null){
            cambio = efectivo - total;
            txtCambio.setText(String.valueOf(cambio));
            btnCobrar.setEnabled(cambio >= 0 );
        }else{
            txtCambio.setText(null);
            btnCobrar.setEnabled(false);
        }
    }//GEN-LAST:event_txtEfectivoKeyReleased

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        Venta ventaPc = new Venta();
        if(pc.detallesVentaPC.isEmpty()){
            ventaPc.importe = pc.detalleRentaPc.total;
            ventaPc.tipo_venta = 1;
            ventaPc.empleado_id_empleado = User.id_empleado;
            if(ventaController.create(connection.getConnection(), ventaPc, pc.detalleRentaPc)){
                informationMessage("REGISTRO EXITOSO", "VENTA REGISTRADA SATISFACTORIAMENTE");
                pc.resetForm();
                closeForm();
            }else{
                errorMessage("ERROR AL REGISTRAR", "NO SE PUDO REGISTRAR LA VENTA");
            }
        }else{
            ventaPc.importe = total + pc.detalleRentaPc.total;
            ventaPc.tipo_venta = 2;
            ventaPc.empleado_id_empleado = User.id_empleado;
            if(ventaController.create(connection.getConnection(), ventaPc, pc.detalleRentaPc, pc.detallesVentaPC)){
                informationMessage("REGISTRO EXITOSO", "VENTA REGISTRADA SATISFACTORIAMENTE");
                pc.resetForm();
                closeForm();
            }else{
                errorMessage("ERROR AL REGISTRAR", "NO SE PUDO REGISTRAR LA VENTA");
            }
        }
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        closeForm();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeForm();
    }//GEN-LAST:event_formWindowClosing

    private void txtEfectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyTyped
        if((!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar()!='\b') && 
                (evt.getKeyChar()!='.' || (evt.getKeyChar()=='.' && txtEfectivo.getText().contains("."))) ||
                txtEfectivo.getText().length()==10){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtEfectivoKeyTyped
    
    private void calcularTotal(){
        total = 0f;
        for(int i=0; i<tbDetallesVenta.getRowCount(); i++){
            total += Float.parseFloat(tbDetallesVenta.getValueAt(i, 2).toString());
        }
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
    
    private String horaFormat(String hora){
//        try {
//            Date contador = horaFormat.parse(hora);
//            Date aux = new Date();
            //aux.setDate(contador.getDate());
            return horaFormat.format(new Date());
//        } catch (ParseException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return null;
    }
    
    private void closeForm(){
        try {
            pc.detallesPc = null;
            pc = null;
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
            java.util.logging.Logger.getLogger(DetallesPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallesPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallesPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetallesPC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnReanudar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbDetallesVenta;
    private javax.swing.JTable tbPcInfo;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JFormattedTextField txtEfectivo;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
