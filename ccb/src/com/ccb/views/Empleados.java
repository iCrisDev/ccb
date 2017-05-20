package com.ccb.views;

import com.ccb.components.tableModels.EmpleadosTableModel;
import com.ccb.connection.CCBConnection;
import com.ccb.controllers.EmpleadoController;
import com.ccb.controllers.UsuarioController;
import com.ccb.pojos.Empleado;
import com.ccb.pojos.Usuario;
import com.ccb.utils.Encriptation;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */

public class Empleados extends javax.swing.JFrame {
    
    private CCBConnection connection = null;
    private EmpleadoController empleadoController = null;
    private UsuarioController usuarioController = null;
    private Encriptation encriptation = new Encriptation();
    private final Border borderGray = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
    private final Border borderRed = BorderFactory.createLineBorder(Color.red, 1);
    
    private Integer id_empleado = null;
    private Integer usuario_id_usuario = null;
    private Integer usuario_estado = null;
    private boolean update;
    
    
    public Empleados() {
        initComponents();
        init();
    }
    
    private void init(){
        connection = new CCBConnection();
        empleadoController = new EmpleadoController();
        usuarioController = new UsuarioController();
        encriptation = new Encriptation();
        initForm();
    }

    private void initForm(){
        setLocationRelativeTo(null);
        setResizable(false);
        tbEmpleados.setModel(new EmpleadosTableModel());
        initDataTableEmpleados();
        restartForm();
    }
    
    private void restartForm(){
        txtNombre.setText(null);
        txtNombre.setBorder(borderGray);
        txtNombre.requestFocus();
        txtApPaterno.setText(null);
        txtApPaterno.setBorder(borderGray);
        txtApMaterno.setText(null);
        txtApMaterno.setBorder(borderGray);
        cbSexo.setSelectedIndex(0);
        txtTelefono.setText(null);
        txtTelefono.setBorder(borderGray);
        txtCorreo.setText(null);
        txtCorreo.setBorder(borderGray);
        txtDireccion.setText(null);
        txtDireccion.setBorder(borderGray);
        txtUsuario.setText(null);
        txtUsuario.setBorder(borderGray);
        txtUsuario.setEditable(true);
        txtContrasenia.setText(null);
        txtContrasenia.setBorder(borderGray);
        cbTipoUsuario.setSelectedIndex(0);
        update = false;
        btnEstado.setVisible(update);
        btnGuardar.setText("Crear");
    }
    
    private void initDataTableEmpleados() {
        ((EmpleadosTableModel) tbEmpleados.getModel()).initData(connection.getConnection());
        tbEmpleados.getColumnModel().getColumn(0).setPreferredWidth(300);
        tbEmpleados.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbEmpleados.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpleados = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtApPaterno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApMaterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JPasswordField();
        cbTipoUsuario = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEstado = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Empleados");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Tipo", "Estado"
            }
        ));
        tbEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmpleados);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Empleado"));

        txtApPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApPaternoKeyTyped(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido Paterno");

        jLabel3.setText("Apellido Materno");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer" }));

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel4.setText("Telefono");

        jLabel5.setText("Correo");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApMaternoKeyTyped(evt);
            }
        });

        jLabel6.setText("Sexo");

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel9.setText("Dirección");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(12, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Usuario"));

        jLabel7.setText("Usuario:");

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        jLabel8.setText("Contraseña");

        txtContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseniaKeyTyped(evt);
            }
        });

        cbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empleado", "Administrador" }));

        jLabel10.setText("Tipo de Usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setText("Crear");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEstado.setText("Inhabiliar");
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEstado)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCerrar)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(validarCampos()){
                if(!update){
                    if(!usuarioController.validarNombreUsuario(connection.getConnection(), txtUsuario.getText())){
                        if(empleadoController.create(connection.getConnection(), getDataEmpleado(), getDataUsuario())){
                            restartForm();
                            initDataTableEmpleados();
                            informationMessage("REGISTRO EXITOSO","EL EMPLEADO HA SIDO REGISTRADO CON EXITO!");
                        }else{
                            errorMessage("ERROR AL REGISTRAR","POR FAVOR INTENTE MAS TARDE...");
                        }
                    }else{
                        warningMessage("IMPOSIBLE REGISTRAR","NOMBRE DE USUARIO NO DISPONIBLE");
                        txtUsuario.requestFocus();
                    }
                }else{
                    if(empleadoController.update(connection.getConnection(), getDataEmpleado(), id_empleado, getDataUsuario(), usuario_id_usuario)){
                        restartForm();
                        initDataTableEmpleados();
                        informationMessage("REGISTRO EXITOSO","INFORMACIÓN ACTUALIZADA CON EXITO!");
                    }else{
                        errorMessage("ERROR AL REGISTRAR","POR FAVOR INTENTE MAS TARDE...");
                    }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tbEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpleadosMouseClicked
        if (evt.getClickCount() > 1){
            int row = tbEmpleados.getSelectedRow();
            id_empleado = ((Empleado)(((EmpleadosTableModel)tbEmpleados.getModel()).getObjectByRow(row))).id_empleado;
            usuario_id_usuario = ((Empleado)(((EmpleadosTableModel)tbEmpleados.getModel()).getObjectByRow(row))).usuario_id_usuario;
            usuario_estado = ((Empleado)(((EmpleadosTableModel)tbEmpleados.getModel()).getObjectByRow(row))).usuario_estado;
            setDataEmpleado(empleadoController.getById(connection.getConnection(), id_empleado));
            setDataUsuario(usuarioController.getById(connection.getConnection(), usuario_id_usuario));
            update = true;
            btnGuardar.setText("Actualizar");
            btnEstado.setVisible(update);
            txtUsuario.setEditable(false);
        }
    }//GEN-LAST:event_tbEmpleadosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        restartForm();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        if(usuarioController.changeStatus(connection.getConnection(), usuario_estado == 1 ? 0 : 1, usuario_id_usuario)){
            restartForm();
            initDataTableEmpleados();
            informationMessage("REGISTRO EXITOSO",usuario_estado == 1 ? "EL EMPLEADO HA SIDO DADO DE BAJA" : 
                    "EL EMPLEADO HA SIDO DADO DE ALTA");
        } else {
            errorMessage("ERROR AL REGISTRAR","Por favor intente más tarde...");
        }
    }//GEN-LAST:event_btnEstadoActionPerformed
    
    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if((Character.isAlphabetic(evt.getKeyChar()) || Character.isWhitespace(evt.getKeyChar()) || evt.getKeyChar()=='\b') 
                && txtNombre.getText().length()<20){
            txtNombre.setBorder((evt.getKeyChar()=='\b' && txtNombre.getText().isEmpty()) ? borderRed:borderGray);
        }
        else{
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApPaternoKeyTyped
        if((Character.isAlphabetic(evt.getKeyChar()) || Character.isWhitespace(evt.getKeyChar()) || evt.getKeyChar()=='\b') 
                && txtApPaterno.getText().length()<20){
            txtApPaterno.setBorder((evt.getKeyChar()=='\b' && txtApPaterno.getText().isEmpty()) ? borderRed:borderGray);
        }
        else{
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtApPaternoKeyTyped

    private void txtApMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApMaternoKeyTyped
        if((Character.isAlphabetic(evt.getKeyChar()) || Character.isWhitespace(evt.getKeyChar()) || evt.getKeyChar()=='\b') 
                && txtApMaterno.getText().length()<20){
            txtApMaterno.setBorder((evt.getKeyChar()=='\b' && txtApMaterno.getText().isEmpty()) ? borderRed:borderGray);
        }
        else{
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtApMaternoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        if((Character.isDigit(evt.getKeyChar()) || Character.isWhitespace(evt.getKeyChar()) || evt.getKeyChar()=='\b') 
                && txtTelefono.getText().length()<10){
            txtTelefono.setBorder((evt.getKeyChar()=='\b' && txtTelefono.getText().isEmpty()) ? borderRed:borderGray);
        }
        else{
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        if(txtCorreo.getText().length()<30){
            txtCorreo.setBorder((evt.getKeyChar()=='\b' && txtCorreo.getText().isEmpty()) ? borderRed:borderGray);
        }
        else{
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        if(txtDireccion.getText().length()<50){
            txtDireccion.setBorder((evt.getKeyChar()=='\b' && txtDireccion.getText().isEmpty()) ? borderRed:borderGray);
        }
        else{
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        if(txtUsuario.getText().length()<20){
            txtUsuario.setBorder((evt.getKeyChar()=='\b' && txtUsuario.getText().isEmpty()) ? borderRed:borderGray);
        }
        else{
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraseniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseniaKeyTyped
        if(txtContrasenia.getText().length()<20){
            txtContrasenia.setBorder((evt.getKeyChar()=='\b' && txtContrasenia.getText().isEmpty()) ? borderRed:borderGray);
        }
        else{
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtContraseniaKeyTyped

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
    
    private synchronized Usuario getDataUsuario(){
        Usuario usuario = new Usuario();
        usuario.nombre_usuario = txtUsuario.getText();
        usuario.contrasenia = txtContrasenia.getText();
        usuario.tipo_usuario = cbTipoUsuario.getSelectedIndex();
        return usuario;
    }
    
    private synchronized void setDataUsuario(Usuario usuario){
        txtUsuario.setText(usuario.nombre_usuario);
        txtContrasenia.setText(encriptation.decrypt(usuario.contrasenia));
        cbTipoUsuario.setSelectedIndex(usuario.tipo_usuario);
        btnEstado.setText(usuario.estado==1 ? "Baja" : "Alta");
    }
    
    private synchronized Empleado getDataEmpleado(){
        Empleado empleado = new Empleado();
        empleado.nombre = txtNombre.getText();
        empleado.ap_paterno = txtApPaterno.getText();
        empleado.ap_materno = txtApMaterno.getText();
        empleado.sexo = cbSexo.getSelectedIndex();
        empleado.telefono = txtTelefono.getText();
        empleado.correo = txtCorreo.getText();
        empleado.direccion = txtDireccion.getText();
        return empleado;
    }
    
    private synchronized void setDataEmpleado(Empleado empleado){
        txtNombre.setText(empleado.nombre);
        txtApPaterno.setText(empleado.ap_paterno);
        txtApMaterno.setText(empleado.ap_materno);
        cbSexo.setSelectedIndex(empleado.sexo);
        txtTelefono.setText(empleado.telefono);
        txtCorreo.setText(empleado.correo);
        txtDireccion.setText(empleado.direccion);
    }
    
    
    private boolean validarCampos(){
        if(txtNombre.getText().isEmpty() || txtApPaterno.getText().isEmpty() || txtApMaterno.getText().isEmpty() || 
                txtTelefono.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtDireccion.getText().isEmpty() || 
                txtUsuario.getText().isEmpty() || txtContrasenia.getText().isEmpty()){
            pintarCampos();
            warningMessage("CAMPOS VACIOS", "LOS CAMPOS MARCADOS SON REQUERIDOS");
        } else{
            pintarCampos();
            return true;
        }
        return false;
    }
    
    private void pintarCampos(){
        txtNombre.setBorder(txtNombre.getText().isEmpty() ? borderRed:borderGray);
        txtApPaterno.setBorder(txtApPaterno.getText().isEmpty() ? borderRed:borderGray);
        txtApMaterno.setBorder(txtApMaterno.getText().isEmpty() ? borderRed:borderGray);
        txtTelefono.setBorder(txtTelefono.getText().isEmpty() ? borderRed:borderGray);
        txtCorreo.setBorder(txtCorreo.getText().isEmpty() ? borderRed:borderGray);
        txtDireccion.setBorder(txtDireccion.getText().isEmpty() ? borderRed:borderGray);
        txtUsuario.setBorder(txtUsuario.getText().isEmpty() ? borderRed:borderGray);
        txtContrasenia.setBorder(txtContrasenia.getText().isEmpty() ? borderRed:borderGray);
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
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEstado;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JComboBox<String> cbTipoUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEmpleados;
    private javax.swing.JTextField txtApMaterno;
    private javax.swing.JTextField txtApPaterno;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
