package com.ccb.views;

import com.ccb.components.tableModels.DetallesVentaPcTableModel;
import com.ccb.connection.CCBConnection;
import com.ccb.controllers.VentaController;
import com.ccb.pojos.User;
import com.ccb.pojos.Venta;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DetallesPC extends javax.swing.JFrame {
   
    PC pc;
    VentaController ventaController = null;
    CCBConnection connection = null;
    
    float total, cambio, efectivo;
    boolean extras;
    
    private DetallesPC() {
        initComponents();
        initForm();
    }
    
    public DetallesPC(PC pcCtrl) {
        this.pc = pcCtrl;
        initComponents();
        init();
        initForm();
    }
    
    public void init(){
        ventaController = new VentaController();
        connection = new CCBConnection();
    }
    
    public void initForm(){
        setLocationRelativeTo(null);
        setResizable(false);
        tbDetallesVenta.setModel(new DetallesVentaPcTableModel());
        if(!pc.detallesVentaPC.isEmpty()){
            initTableDetallesVenta();
        }
        initTableDetalleRentaPc();
        btnCobrar.setEnabled(false);
        txtTotal.setEditable(false);
        txtCambio.setEditable(false);
        calcularTotal();
        txtTotal.setText(String.valueOf(total+pc.detalleRentaPC.total));
    }
    
    public void initTableDetallesVenta(){
        
        ((DetallesVentaPcTableModel) tbDetallesVenta.getModel()).initData(pc.detallesVentaPC);
        tbDetallesVenta.getTableHeader().setReorderingAllowed(false) ;
        tbDetallesVenta.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbDetallesVenta.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbDetallesVenta.getColumnModel().getColumn(2).setPreferredWidth(100);
        
    }
    
    public void initTableDetalleRentaPc(){
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        };
        
        String[] headers = {"Inicio","Fin","Tiempo","Total"};
        tableModel.setColumnIdentifiers(headers);
        String[] pcInfo = new String[4];
        pcInfo[0] = pc.detalleRentaPC.hora_inicio;
        pcInfo[1] = pc.detalleRentaPC.hora_fin;
        pcInfo[2] = pc.detalleRentaPC.tiempo_total;
        pcInfo[3] = String.valueOf(pc.detalleRentaPC.total);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(btnReanudar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReanudarActionPerformed
        // TODO add your handling code here:
        pc.reanudar();
        dispose();
    }//GEN-LAST:event_btnReanudarActionPerformed

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
            cambio = efectivo - (total + pc.detalleRentaPC.total);
            txtCambio.setText(String.valueOf(cambio));
            
            
            btnCobrar.setEnabled(cambio >= 0);
            
            
        }catch(NumberFormatException e){
            txtCambio.setText(null);
        }
    }//GEN-LAST:event_txtEfectivoKeyReleased

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        // TODO add your handling code here:
        Venta ventaPc = new Venta();
        ventaPc.importe = pc.detalleRentaPC.total;
        ventaPc.tipo_venta = 1;
        ventaPc.empleado_id_empleado = User.id_empleado;
        
       
        if(ventaController.create(connection.getConnection(), ventaPc, pc.detalleRentaPC)){
            if(!pc.detallesVentaPC.isEmpty()){
                Venta venta = new Venta();
                venta.importe = total;
                venta.tipo_venta = 0;
                venta.empleado_id_empleado = User.id_empleado;
                
                if(ventaController.create(connection.getConnection(), venta, pc.detallesVentaPC)){
                    JOptionPane.showMessageDialog(null, "Venta registrada con exito!");
                    pc.reiniciar();
                    dispose();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Venta registrada con exito!");
                pc.reiniciar();
                dispose();
            }
            
        }
        

    }//GEN-LAST:event_btnCobrarActionPerformed
    
    public void calcularTotal(){
        total = 0;
        for(int i=0; i<tbDetallesVenta.getRowCount(); i++){
            total += Float.parseFloat(tbDetallesVenta.getValueAt(i, 2).toString());
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
