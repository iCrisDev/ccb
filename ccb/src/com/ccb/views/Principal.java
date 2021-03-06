package com.ccb.views;

import com.ccb.pojos.Config;
import com.ccb.pojos.User;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class Principal extends javax.swing.JFrame {
    
    public Ventas ventas;
    public Compras compras;
    public AjustesInventario ajustesInventario;
    public Empleados empleados;
    public Productos productos;
    public Opciones opciones;
    private SimpleDateFormat horaFormat;
    private SimpleDateFormat fechaFormat;
    private PC[] pcs;
    private GridLayout gd;
    
    public Principal() {
        initComponents();
        init();
    }
    
    public void init(){
        horaFormat = new SimpleDateFormat("hh:mm:ss a");
        fechaFormat = new SimpleDateFormat("dd/MM/YYYY");

        gd = new GridLayout(0, Config.pcs_por_fila);
        initForm();
    }
    
    public void initForm(){
        pnPc.removeAll();
        
        
        switch(Config.pcs_por_fila){
            case 1: setSize(350, 715); break;
            case 2: setSize(650, 715); break;
            case 3: setSize(950, 715); break;
            default: setSize(1250, 715);
        }
        
        if(Config.pcs_por_fila < 4){
            setSize(950,715);
        }else{
            setSize(1250,715);
        }
        
        
        setLocationRelativeTo(null);
        //setResizable(false);
        gd = new GridLayout(0, Config.pcs_por_fila);
        
        pnPc.setLayout(gd);
        
        pcs = new PC[Config.num_pcs];
        
        for(int i=0; i<Config.num_pcs; i++){
            PC pc = new PC(i+1);
            pcs[i] = pc;
            pnPc.add(pc);
        }
        
        lbUsuario.setText(User.nombreCompleto + " (" + (User.tipoUsuario == 1 ? "Administrador" : "Empleado") + ")");
        lbHora.setText(horaFormat.format(new Date()));
        lbFecha.setText(fechaFormat.format(new Date()));
        reloj.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        spPc = new javax.swing.JScrollPane();
        pnPc = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniVentas = new javax.swing.JMenuItem();
        mniCompras = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mniEmpleados = new javax.swing.JMenuItem();
        mniProductos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        pn1.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout pn1Layout = new javax.swing.GroupLayout(pn1);
        pn1.setLayout(pn1Layout);
        pn1Layout.setHorizontalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pn1Layout.setVerticalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Usuario:");

        lbUsuario.setText("jLabel2");

        jLabel3.setText("Hora:");

        lbHora.setText("00:00:00");

        jLabel5.setText("Fecha:");

        lbFecha.setText("00/00/0000");

        pnPc.setBackground(new java.awt.Color(102, 102, 102));
        pnPc.setLayout(new java.awt.GridLayout(1, 0));
        spPc.setViewportView(pnPc);

        jMenu1.setText("Operaciones");

        mniVentas.setText("Ventas");
        mniVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniVentasActionPerformed(evt);
            }
        });
        jMenu1.add(mniVentas);

        mniCompras.setText("Compras");
        mniCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniComprasActionPerformed(evt);
            }
        });
        jMenu1.add(mniCompras);

        jMenuItem2.setText("Ajuste de Inventario");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Gestión");

        mniEmpleados.setText("Empleados");
        mniEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEmpleadosActionPerformed(evt);
            }
        });
        jMenu2.add(mniEmpleados);

        mniProductos.setText("Productos");
        mniProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniProductosActionPerformed(evt);
            }
        });
        jMenu2.add(mniProductos);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Configuración");

        jMenuItem1.setText("Opciones");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 810, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lbHora)
                .addGap(81, 81, 81)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(lbFecha)
                .addContainerGap())
            .addComponent(spPc)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(spPc, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbUsuario)
                    .addComponent(jLabel3)
                    .addComponent(lbHora)
                    .addComponent(jLabel5)
                    .addComponent(lbFecha))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEmpleadosActionPerformed
        if(empleados == null){
            empleados = new Empleados(this);
        }
        empleados.setVisible(true);
    }//GEN-LAST:event_mniEmpleadosActionPerformed

    private void mniProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniProductosActionPerformed
        if(productos == null){
            productos = new Productos(this);
        }
        productos.setVisible(true);
    }//GEN-LAST:event_mniProductosActionPerformed

    private void mniVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniVentasActionPerformed
        if(ventas == null){
            ventas = new Ventas(this);
        }
        ventas.setVisible(true);
    }//GEN-LAST:event_mniVentasActionPerformed

    private void mniComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniComprasActionPerformed
        if(compras == null){
            compras = new Compras(this);
        }
        compras.setVisible(true);
    }//GEN-LAST:event_mniComprasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(pcsInactivas()){
            System.exit(0);
        }else{
            if(JOptionPane.showConfirmDialog(null, "AUN HAY COMPUTADORAS ACTIVAS, SI CIERRA LA APLICACIÓN PERDERA TODA LA "
                    + "INFORMACIÓN QUE NO SE HALLA GUARDADO,  ¿REALMENTE DESEA SALIR?") == 0 ){
                System.exit(0);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(ajustesInventario == null){
            ajustesInventario = new AjustesInventario(this);
        }
        ajustesInventario.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(opciones == null){
            opciones = new Opciones(this);
        }
        opciones.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public boolean pcsInactivas(){
        for (PC pc : pcs) {
            if (pc.activa) {
                return false;
            }
        }
        return true;
    }
    
    Timer reloj = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String hora = horaFormat.format(new Date());
            lbHora.setText(hora);
            if(hora.equals("12:00:00 AM")){
                lbFecha.setText(fechaFormat.format(new Date()));
            }
        }
    });
    
    
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JMenuItem mniCompras;
    private javax.swing.JMenuItem mniEmpleados;
    private javax.swing.JMenuItem mniProductos;
    private javax.swing.JMenuItem mniVentas;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pnPc;
    private javax.swing.JScrollPane spPc;
    // End of variables declaration//GEN-END:variables
}
