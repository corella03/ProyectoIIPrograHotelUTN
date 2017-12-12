/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.gui.cliente;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import proyectoiiprograhotelutn.bo.HabitacionBO;
import proyectoiiprograhotelutn.bo.TipoHabitacionBO;
import proyectoiiprograhotelutn.entities.Cliente;
import proyectoiiprograhotelutn.entities.DetalleReservacion;
import proyectoiiprograhotelutn.entities.Habitacion;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.TipoHabitacion;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 09/12/2017
 **/
public class FrmCliente extends javax.swing.JDialog {
    /**
     * Creates new form FrmTipoHabitacion
     */
    private Cliente cliente;
    private DetalleReservacion detalleReser;
    private DefaultComboBoxModel<Cliente> clientes;
    private DefaultComboBoxModel<Habitacion> habitaciones;
    public FrmCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        btnRegresar.setContentAreaFilled(false);
        btnRegistrarResevacion.setContentAreaFilled(false);
        btnBuscar.setContentAreaFilled(false);
        this.cliente = new Cliente();
        clientes = new DefaultComboBoxModel<>();
        cbxCliente.setModel(clientes);
        habitaciones = new DefaultComboBoxModel<>();
        cbxHabitacion.setModel(habitaciones);
        cargarTiposHabitaciones();
    }
    public FrmCliente(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        btnRegresar.setContentAreaFilled(false);
        btnRegistrarResevacion.setContentAreaFilled(false);
        btnRegistrarResevacion.setText("Editar");
        btnBuscar.setContentAreaFilled(false);
        this.cliente = cliente;
        clientes = new DefaultComboBoxModel<>();
        cbxCliente.setModel(clientes);
        habitaciones = new DefaultComboBoxModel<>();
        cbxHabitacion.setModel(habitaciones);
        cargarTiposHabitaciones();
        cargarHabitaciones();
    }
    private void irAFrmRegistro(){
        super.getParent().setVisible(true);
        dispose();
    } 
    public void cargarHabitaciones(){
        cbxTipoHabiacion.removeAllItems();
        TipoHabitacionBO habibo = new TipoHabitacionBO();
        ArrayList<TipoHabitacion> listaHabi = habibo.cargarTiposDeHabitaciones();
        for (TipoHabitacion h : listaHabi) {
            clientes.addElement(h);
        }
    }
    public void registrarHabitacion() throws IOException{
        lblErrorReservaCliente.setText("");
        try {
            Habitacion habi = new Habitacion();
            habi.setId(this.cliente.getId());
            habi.setCodigo(txtCodigo.getText().trim().toLowerCase());
            habi.setIdTipoHabitacion((TipoHabitacion) cbxTipoHabiacion.getSelectedItem());
            File pathToFile = new File(fcFoto.getSelectedFile().getAbsolutePath());
            Image image = ImageIO.read(pathToFile);
            habi.setImagen(image);
            habi.setDescripcion(txtDescripcionPuesto.getText().trim());
            if(cbxEstado.getSelectedIndex() == 0){
                habi.setEstado(true);
            }else if(cbxEstado.getSelectedIndex() == 1 || cbxEstado.getSelectedIndex() == 2){
                habi.setEstado(false);
            }
            habi.setCantPersonas((Integer)spnCantPersonas.getValue());
            HabitacionBO habibo = new HabitacionBO();
            if (habibo.registrarHabitacion(habi)) {
                lblErrorReservaCliente.setText("Puesto registrado con éxito.");
                super.getParent().setVisible(true);
                dispose();
            } else {
                lblErrorReservaCliente.setText("Intente nuevamente.");
            }
        } catch (MiError ex) {
            lblErrorReservaCliente.setText(ex.getMessage());
        } catch (Exception ex) {
            lblErrorReservaCliente.setText("Llamar a TI ...xD");
        }
    }
    private void cargarHabitaciones(){
        
        txtCodigo.setText(cliente.getCodigo());
        txtDescripcionPuesto.setText(cliente.getDescripcion());
        cbxTipoHabiacion.setSelectedItem(cliente.getIdTipoHabitacion());
        if(cliente.isEstado()){
            cbxEstado.setSelectedItem("Disponible");
        }else if(!cliente.isEstado()){
            cbxEstado.setSelectedItem("Ocupada");
        }
        spnCantPersonas.setValue(cliente.getCantPersonas());
        lblFoto.setText("");
        ImageIcon icon = new ImageIcon(cliente.getImagen());
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
        lblFoto.setIcon(icono);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fcFoto = new javax.swing.JFileChooser();
        lblEstadoHabitacion = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        btnRegistrarResevacion = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblErrorReservaCliente = new javax.swing.JLabel();
        lblNumeroTarjeta = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        cbxDesayuno = new javax.swing.JComboBox<>();
        lblDesayuno = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        rdActivo = new javax.swing.JRadioButton();
        lblTelfonoCliente = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtTelefono2 = new javax.swing.JTextField();
        txtTelefono3 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblIdCliente = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox<>();
        lblIdHabitacion = new javax.swing.JLabel();
        btnRegistrarCliente = new javax.swing.JButton();
        cbxHabitacion = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        txtDiaSa = new javax.swing.JTextField();
        lblFechaSalida = new javax.swing.JLabel();
        txtMesSa = new javax.swing.JTextField();
        txtAsa = new javax.swing.JTextField();
        txtDiaEn = new javax.swing.JTextField();
        lblFechaEntrada = new javax.swing.JLabel();
        txtMesEn = new javax.swing.JTextField();
        txtAEn = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnBuscar1 = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEstadoHabitacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEstadoHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        lblEstadoHabitacion.setText("Estado Habitación:");
        getContentPane().add(lblEstadoHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        cbxEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxEstado.setForeground(new java.awt.Color(255, 255, 255));
        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Ocupada", "Fuera de Servicio" }));
        getContentPane().add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 120, 30));

        btnRegistrarResevacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrarResevacion.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarResevacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/registrar.png"))); // NOI18N
        btnRegistrarResevacion.setText("Registar");
        btnRegistrarResevacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarResevacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarResevacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarResevacionActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarResevacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgAtras.png"))); // NOI18N
        btnRegresar.setOpaque(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 44, 28));

        lblErrorReservaCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblErrorReservaCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblErrorReservaCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorReservaCliente.setToolTipText("");
        getContentPane().add(lblErrorReservaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 580, 30));

        lblNumeroTarjeta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNumeroTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        lblNumeroTarjeta.setText("Número Tarjeta:");
        getContentPane().add(lblNumeroTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 160, -1));

        lblApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setText("Apellido:");
        getContentPane().add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 160, -1));

        cbxDesayuno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxDesayuno.setForeground(new java.awt.Color(255, 255, 255));
        cbxDesayuno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        getContentPane().add(cbxDesayuno, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 120, 30));

        lblDesayuno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDesayuno.setForeground(new java.awt.Color(255, 255, 255));
        lblDesayuno.setText("Desayuno:");
        getContentPane().add(lblDesayuno, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, -1, -1));

        txtTarjeta.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 160, -1));

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccion.setText("Dirección:");
        getContentPane().add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        txtCedula.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, -1));

        lblCedula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCedula.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula.setText("Cédula:");
        getContentPane().add(lblCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        rdActivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdActivo.setForeground(new java.awt.Color(255, 255, 255));
        rdActivo.setText("Activo");
        getContentPane().add(rdActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        lblTelfonoCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTelfonoCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblTelfonoCliente.setText("Telefono:");
        getContentPane().add(lblTelfonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 50, -1));

        txtTelefono2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtTelefono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 40, -1));

        txtTelefono3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtTelefono3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 40, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 10, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 10, 10));

        lblIdCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblIdCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblIdCliente.setText("Id Cliente:");
        getContentPane().add(lblIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        cbxCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxCliente.setForeground(new java.awt.Color(255, 255, 255));
        cbxCliente.setMaximumRowCount(100);
        getContentPane().add(cbxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 120, 30));

        lblIdHabitacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblIdHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        lblIdHabitacion.setText("Id Habitación: ");
        getContentPane().add(lblIdHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));

        btnRegistrarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/registrar.png"))); // NOI18N
        btnRegistrarCliente.setText("Registar Cliente");
        btnRegistrarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        cbxHabitacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(cbxHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 120, 30));

        txtDireccion.setColumns(20);
        txtDireccion.setRows(5);
        jScrollPane2.setViewportView(txtDireccion);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 260, 110));

        txtDiaSa.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtDiaSa, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, 40, -1));

        lblFechaSalida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFechaSalida.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaSalida.setText("Fecha Salida:");
        getContentPane().add(lblFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, -1, -1));

        txtMesSa.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtMesSa, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 40, -1));

        txtAsa.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtAsa, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, 40, -1));

        txtDiaEn.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtDiaEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 40, -1));

        lblFechaEntrada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFechaEntrada.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaEntrada.setText("Facha Entrada:");
        getContentPane().add(lblFechaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

        txtMesEn.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtMesEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 40, -1));

        txtAEn.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtAEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 40, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgBuscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 50, 30));

        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgBuscar.png"))); // NOI18N
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 50, 30));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgRegistros.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnRegistrarResevacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarResevacionActionPerformed
        
    }//GEN-LAST:event_btnRegistrarResevacionActionPerformed
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        irAFrmRegistro();
    }//GEN-LAST:event_btnRegresarActionPerformed
    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar1ActionPerformed
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
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmCliente dialog = new FrmCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnRegistrarResevacion;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<Cliente> cbxCliente;
    private javax.swing.JComboBox<String> cbxDesayuno;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<Habitacion> cbxHabitacion;
    private javax.swing.JFileChooser fcFoto;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDesayuno;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblErrorReservaCliente;
    private javax.swing.JLabel lblEstadoHabitacion;
    private javax.swing.JLabel lblFechaEntrada;
    private javax.swing.JLabel lblFechaSalida;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblIdHabitacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroTarjeta;
    private javax.swing.JLabel lblTelfonoCliente;
    private javax.swing.JRadioButton rdActivo;
    private javax.swing.JTextField txtAEn;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtAsa;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDiaEn;
    private javax.swing.JTextField txtDiaSa;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtMesEn;
    private javax.swing.JTextField txtMesSa;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTarjeta;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefono2;
    private javax.swing.JTextField txtTelefono3;
    // End of variables declaration//GEN-END:variables
}