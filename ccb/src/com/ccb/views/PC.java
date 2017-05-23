package com.ccb.views;

import com.ccb.pojos.Config;
import com.ccb.pojos.DetalleRentaPc;
import com.ccb.pojos.DetalleVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class PC extends javax.swing.JPanel {
    
    public List<DetalleVenta> detallesVentaPC;
    public DetalleRentaPc detalleRentaPc;
    private Calendar calendario;
    private DecimalFormat dcFm;
    private DateFormat hora;
    private ImageIcon pcLibre, pcIniciada, pcDetenida, timerOff, timerOn;
    private int hr, mn, sg, crHr, crMn, crSg, hrTmp, mnTmp, sgTmp, opc;
    private final int PcID;
    private boolean cronometro, activa;
    private float totalTmp;
//    private String duracion, horaInicio, horaFin;
    
    public PC(int pcID) {
        initComponents();
        PcID = pcID;
        init();
    }
    
    private void init(){
        dcFm = new DecimalFormat("####0.00");
        hora = new SimpleDateFormat("HH:mm:ss");
        pcLibre = new ImageIcon(this.getClass().getResource("/com/ccb/images/pc-libre.png"));
        pcIniciada = new ImageIcon(this.getClass().getResource("/com/ccb/images/pc-iniciada.png"));
        pcDetenida = new ImageIcon(this.getClass().getResource("/com/ccb/images/pc-detenida.png"));
        timerOff = new ImageIcon(this.getClass().getResource("/com/ccb/images/timerOff.png"));
        timerOn = new ImageIcon(this.getClass().getResource("/com/ccb/images/timerOn.png"));
        lbPcID.setText("PC-" + PcID);
        resetForm();
    }
    
    public void resetForm(){
        detallesVentaPC = new ArrayList<>();
        detalleRentaPc = new DetalleRentaPc();
        detalleRentaPc.id_pc = PcID;
        cronometro = false;
        hr = 0; mn = 0; sg = 0;
        detalleRentaPc.total = 0;
        opc = 1;
        spHoras.setValue(0);
        spMinutos.setValue(0);
        lbTiempo.setText(horaFormat(hr, mn, sg));
        lbTotal.setText("$"+dcFm.format(detalleRentaPc.total));
        btnRun.setText("Comenzar");
        lbEstado.setIcon(pcLibre);
        lbVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fmTimer = new javax.swing.JFrame();
        spHoras = new javax.swing.JSpinner();
        spMinutos = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnIniciarCronometro = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnRun = new javax.swing.JButton();
        lbTiempo = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        lbPcID = new javax.swing.JLabel();
        lbIconTimer = new javax.swing.JLabel();
        lbVenta = new javax.swing.JLabel();
        lbEstado = new javax.swing.JLabel();

        fmTimer.setTitle("Configurar Temporizador");

        spHoras.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spMinutos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 15));

        jLabel1.setText("horas");

        jLabel2.setText("minutos");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnIniciarCronometro.setText("Iniciar");
        btnIniciarCronometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarCronometroActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ccb/images/stopwatch.png"))); // NOI18N

        javax.swing.GroupLayout fmTimerLayout = new javax.swing.GroupLayout(fmTimer.getContentPane());
        fmTimer.getContentPane().setLayout(fmTimerLayout);
        fmTimerLayout.setHorizontalGroup(
            fmTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fmTimerLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(fmTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(fmTimerLayout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIniciarCronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fmTimerLayout.createSequentialGroup()
                        .addComponent(spHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addComponent(spMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGap(26, 26, 26))
        );
        fmTimerLayout.setVerticalGroup(
            fmTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fmTimerLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(fmTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(fmTimerLayout.createSequentialGroup()
                        .addGroup(fmTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(spHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(40, 40, 40)
                        .addGroup(fmTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIniciarCronometro)
                            .addComponent(btnCancelar)))
                    .addComponent(jLabel3))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(300, 300));
        setSize(new java.awt.Dimension(300, 300));
        setLayout(null);

        btnRun.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnRun.setText("Comenzar");
        btnRun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });
        add(btnRun);
        btnRun.setBounds(80, 70, 110, 33);

        lbTiempo.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lbTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTiempo.setText("00:00:00");
        add(lbTiempo);
        lbTiempo.setBounds(90, 110, 100, 17);

        lbTotal.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotal.setText("$0.00");
        lbTotal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        add(lbTotal);
        lbTotal.setBounds(90, 140, 90, 30);

        lbPcID.setBackground(new java.awt.Color(255, 255, 255));
        lbPcID.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lbPcID.setForeground(new java.awt.Color(0, 0, 0));
        lbPcID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPcID.setText("PC-01");
        lbPcID.setOpaque(true);
        add(lbPcID);
        lbPcID.setBounds(30, 40, 50, 20);

        lbIconTimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ccb/images/timerOff.png"))); // NOI18N
        lbIconTimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbIconTimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIconTimerMouseClicked(evt);
            }
        });
        add(lbIconTimer);
        lbIconTimer.setBounds(200, 70, 30, 30);

        lbVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ccb/images/shopping-cart-with-product-inside.png"))); // NOI18N
        lbVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVentaMouseClicked(evt);
            }
        });
        add(lbVenta);
        lbVenta.setBounds(200, 140, 30, 30);

        lbEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ccb/images/pc-libre.png"))); // NOI18N
        add(lbEstado);
        lbEstado.setBounds(40, 40, 200, 200);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        switch (opc) {
            case 1: iniciar(); break;
            case 2: detener(); break;
            case 3: new DetallesPC(this).setVisible(true); break;
        }
    }//GEN-LAST:event_btnRunActionPerformed
    
    private void lbIconTimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIconTimerMouseClicked
        if(!cronometro){
            showTimerOption();
        }else{
            cronometroOF();
        }
    }//GEN-LAST:event_lbIconTimerMouseClicked

    private void btnIniciarCronometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarCronometroActionPerformed
        crHr = (int)spHoras.getValue();
        crMn = (int)spMinutos.getValue();
        crSg = 0;
        if((crHr > hr) || (crHr>=hr && crMn > mn)){
            cronometroON();
            fmTimer.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "EL TIEMPO DEL TEMPORIZADOR DEBE SER MAYOR AL TIEMPO TRANSCURRIDO", "", 
                JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnIniciarCronometroActionPerformed

    private void lbVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVentaMouseClicked
        if(activa){
            new VentasPc(detallesVentaPC).setVisible(true);
        }
    }//GEN-LAST:event_lbVentaMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        fmTimer.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    private void iniciar(){
        activa = true;
        opc = 2;
        btnRun.setText("Terminar");
        lbEstado.setIcon(pcIniciada);
        detalleRentaPc.hora_inicio = horaActual();
        lbVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tiempo.start();
    }
    
    private void detener(){
        opc=3; 
        btnRun.setText("Cobrar");
        lbEstado.setIcon(pcDetenida);
        detalleRentaPc.hora_fin = horaActual();
        detalleRentaPc.tiempo_total = horaFormat(hr, mn, sg);
        tiempo.stop();
    }
    
    public void reanudar(){
        opc = 2;
        btnRun.setText("Terminar");
        lbEstado.setIcon(pcIniciada);
        detalleRentaPc.hora_fin = null;
        tiempo.start();
    }
    
    private void cronometroON(){
        if(!activa){
            lbTiempo.setText(horaFormat(crHr, crMn, crSg));
        }
        lbIconTimer.setIcon(timerOn);
        cronometro = true;
    }
    
    private void cronometroOF(){
        lbIconTimer.setIcon(timerOff);
        cronometro = false;
    }
    
    Timer tiempo = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            sg++;
            if(sg==60){
                mn++;
                sg=0;
            }
            if(mn==60){
                hr++;
                mn=0;
            }
            if(!cronometro){
                lbTiempo.setText(horaFormat(hr, mn, sg));
            }else{
                hrTmp = crHr - hr;
                if(crMn < mn){
                    mnTmp = (crMn - mn) + 60;
                    hrTmp--;
                }else{
                    mnTmp = crMn - mn;
                }
                if(crSg < sg){
                    sgTmp = (crSg - sg) + 60;
                    mnTmp --;
                }else{
                    sgTmp = crSg -  sg;
                }
                lbTiempo.setText(horaFormat(hrTmp, mnTmp, sgTmp));
                if(hr==crHr && mn==crMn && sg==crSg){
                    cronometroOF();
                    detener();
                }
            }
            if(mn==0 && sg==1){
                lbTotal.setText("$"+dcFm.format(detalleRentaPc.total = Config.min15 + totalTmp));
            }
            else if(mn==15 && sg==1){
                lbTotal.setText("$"+dcFm.format(detalleRentaPc.total = Config.min30 + totalTmp));
            }
            else if(mn==30 && sg ==1){
                lbTotal.setText("$"+dcFm.format(detalleRentaPc.total = Config.min45 + totalTmp));
            }
            else if(mn==45 && sg==1){
                lbTotal.setText("$"+dcFm.format(detalleRentaPc.total = totalTmp += Config.hora));
            }
        }
    });
    
    private String horaFormat(int hr, int mn, int sg){
        try {
            Date contador = hora.parse(hr+":"+mn+":"+sg);
            return hora.format(contador);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    private String horaActual(){
        calendario = new GregorianCalendar();
            return calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE)+":"+
                calendario.get(Calendar.SECOND);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIniciarCronometro;
    private javax.swing.JButton btnRun;
    private javax.swing.JFrame fmTimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbIconTimer;
    private javax.swing.JLabel lbPcID;
    private javax.swing.JLabel lbTiempo;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbVenta;
    private javax.swing.JSpinner spHoras;
    private javax.swing.JSpinner spMinutos;
    // End of variables declaration//GEN-END:variables
    
    private void showTimerOption(){
        fmTimer.setSize(450,220);
        fmTimer.setLocationRelativeTo(null);
        fmTimer.setResizable(false);
        fmTimer.setVisible(true);
    }
}
