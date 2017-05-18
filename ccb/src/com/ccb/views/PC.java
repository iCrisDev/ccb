package com.ccb.views;

import com.ccb.pojos.Config;
import com.ccb.pojos.DetalleRentaPc;
import com.ccb.pojos.DetalleVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
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

public class PC extends javax.swing.JPanel {
    
    Date contador;
    List<DetalleVenta> detallesVentaPC;
    DetalleRentaPc detalleRentaPC;
    Calendar calendario;
    DecimalFormat dcFm = new DecimalFormat("####.00");
    DateFormat hora = new SimpleDateFormat("HH:mm:ss");
    ImageIcon pcLibre, pcIniciada, pcDetenida, timerOff, timerOn;
    Date date;
    URL url1, url2, url3, url4, url5; 
    private int hr, mn, sg, crHr, crMn, crSg, hrTmp, mnTmp, sgTmp;
    int opc, PcID;
    boolean activa, cronometro;
    float total, parcial;
    String duracion, horaInicio, horaFin;
    
    public PC(int pcID) {
        initComponents();
        PcID = pcID;
        init();
        initForm();
    }
    
    public void init(){
        
        url1 = this.getClass().getResource("/com/ccb/images/pc-libre.png");
        url2 = this.getClass().getResource("/com/ccb/images/pc-iniciada.png");  
        url3 = this.getClass().getResource("/com/ccb/images/pc-detenida.png"); 
        url4 = this.getClass().getResource("/com/ccb/images/timerOff.png");
        url5 = this.getClass().getResource("/com/ccb/images/timerOn.png"); 
        pcLibre = new ImageIcon(url1);
        pcIniciada = new ImageIcon(url2);
        pcDetenida = new ImageIcon(url3);
        timerOff = new ImageIcon(url4);
        timerOn = new ImageIcon(url5);
        
        hr = 0; mn = 0; sg = 0; 
        crHr = 0; crMn = 0; crSg = 0;
        opc = 1;
        cronometro = false;
    }
    
    public void initForm(){
        detallesVentaPC = new ArrayList<>();
        detalleRentaPC = new DetalleRentaPc();
        detalleRentaPC.id_pc = PcID;
        lbPcID.setText("PC-" + PcID);
        btnRun.setText("Comenzar");
        lbTiempo.setText("00:00:00");
        lbTotal.setText("$0.00");
    }
    
    public void iniciar(){
        
        btnRun.setText("Terminar");
        lbIcon.setIcon(pcIniciada);
        detalleRentaPC.hora_inicio = horaActual();
        //horaInicio = horaActual();
        tiempo.start();
        activa = true;
    }
    
    public void detener(){
        
        btnRun.setText("Cobrar");
        lbIcon.setIcon(pcDetenida);
        detalleRentaPC.hora_fin = horaActual();
        //horaFin= horaActual();
        //duracion = horaFormat(hr, mn, sg);
        detalleRentaPC.tiempo_total = horaFormat(hr, mn, sg);
        tiempo.stop();
    }
    
    public void reanudar(){
        btnRun.setText("Terminar");
        lbIcon.setIcon(pcIniciada);
        horaFin = null;
        tiempo.start();
        opc = 2;
    }
    
    public void reiniciar(){
        hr = 0; mn = 0; sg = 0; 
        crHr = 0; crMn = 0; crSg = 0;
        opc = 1;
        cronometro = false;
        detallesVentaPC = new ArrayList<>();
        detalleRentaPC = new DetalleRentaPc();
        detalleRentaPC.id_pc = PcID;
        spHoras.setValue(0);
        spMinutos.setValue(0);
        lbTiempo.setText("00:00:00");
        lbTotal.setText("$0.00");
        btnRun.setText("Comenzar");
        lbIcon.setIcon(pcLibre);
    }
    
    public void cronometroON(){
        if(!activa){
            lbTiempo.setText(horaFormat(crHr, crMn, crSg));
        }else{
            lbTiempo.setText(horaFormat(hrTmp, mnTmp, sgTmp));
        }
        lbIconTimer.setIcon(timerOn);
        cronometro = true;
        
    }
    
    public void cronometroOF(){
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
                detalleRentaPC.total = Config.min15 + parcial;
                lbTotal.setText("$"+dcFm.format(detalleRentaPC.total));
            }
            else if(mn==15 && sg==1){
                detalleRentaPC.total = Config.min30 + parcial;
                lbTotal.setText("$"+dcFm.format(detalleRentaPC.total));
            }
            else if(mn==30 && sg ==1){
                detalleRentaPC.total = Config.min45 + parcial;
                lbTotal.setText("$"+dcFm.format(detalleRentaPC.total));
            }
            else if(mn==45 && sg==1){
                parcial += Config.hora;
                detalleRentaPC.total = parcial;
                lbTotal.setText("$"+dcFm.format(detalleRentaPC.total));
            }
            
        }
    });
    
    public String horaFormat(int hr, int mn, int sg){
        try {
            contador = hora.parse(hr+":"+mn+":"+sg);
            return hora.format(contador);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fmTimer = new javax.swing.JFrame();
        spHoras = new javax.swing.JSpinner();
        spMinutos = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnRun = new javax.swing.JButton();
        lbTiempo = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        lbPcID = new javax.swing.JLabel();
        lbIconTimer = new javax.swing.JLabel();
        cartLabel = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();

        fmTimer.setTitle("Configurar Temporizador");

        spHoras.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spMinutos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 15));

        jLabel1.setText("horas");

        jLabel2.setText("minutos");

        jButton1.setText("Cancelar");

        jButton2.setText("Iniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
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
        lbIconTimer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbIconTimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIconTimerMouseClicked(evt);
            }
        });
        add(lbIconTimer);
        lbIconTimer.setBounds(200, 70, 30, 30);

        cartLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ccb/images/shopping-cart-with-product-inside.png"))); // NOI18N
        cartLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cartLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartLabelMouseClicked(evt);
            }
        });
        add(cartLabel);
        cartLabel.setBounds(200, 140, 30, 30);

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ccb/images/pc-libre.png"))); // NOI18N
        add(lbIcon);
        lbIcon.setBounds(40, 40, 200, 200);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        switch (opc) {
            case 1:
                iniciar();
                this.setCursorComponent(cartLabel, "hand");
                opc=2;
                break;
            case 2:
                detener();
                opc=3;
                break;
            default:
                new DetallesPC(this).setVisible(true);
        }
        
    }//GEN-LAST:event_btnRunActionPerformed
    
    private void setCursorComponent(javax.swing.JComponent component, String type) {
        switch(type) {
            case "hand":
                component.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                break;
            case "default":
            default:
                component.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }

    }
    
    private void lbIconTimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIconTimerMouseClicked
        if(!cronometro){
            showTimerOption();
        }else{
            cronometroOF();
        }
    }//GEN-LAST:event_lbIconTimerMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        crHr = (Integer)spHoras.getValue();
        crMn = (Integer)spMinutos.getValue();
        crSg = 0;
        if((crHr > hr) || (crHr>=hr && crMn > mn)){
            cronometroON();
            fmTimer.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "El tiempo del temporizador debe ser mayor al tiempo transcurrido");
        }

        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cartLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartLabelMouseClicked
        // TODO add your handling code here:
        if(activa){
            
            new Ventas(detallesVentaPC).setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Solo se pueden agregar extras a una computadora activas");
        }
    }//GEN-LAST:event_cartLabelMouseClicked
    
    public void showTimerOption(){
        fmTimer.setSize(450,220);
        fmTimer.setLocationRelativeTo(null);
        fmTimer.setResizable(false);
        fmTimer.setVisible(true);
        spMinutos.requestFocus();
    }
    
    
    public String horaActual(){
        calendario = new GregorianCalendar();
        
//        return calendario.get(Calendar.HOUR)+":"+calendario.get(Calendar.MINUTE)+":"+
//                calendario.get(Calendar.SECOND)+" "+(calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM":"PM");
            return calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE)+":"+
                calendario.get(Calendar.SECOND);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRun;
    private javax.swing.JLabel cartLabel;
    private javax.swing.JFrame fmTimer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbIconTimer;
    private javax.swing.JLabel lbPcID;
    private javax.swing.JLabel lbTiempo;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JSpinner spHoras;
    private javax.swing.JSpinner spMinutos;
    // End of variables declaration//GEN-END:variables
    
    
    
}
