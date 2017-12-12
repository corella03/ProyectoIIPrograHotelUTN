/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.gui.habitacion;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import proyectoiiprograhotelutn.bo.HabitacionBO;
import proyectoiiprograhotelutn.bo.TipoHabitacionBO;
import proyectoiiprograhotelutn.entities.Habitacion;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.TipoHabitacion;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 09/12/2017
 **/
public class FrmHabitacion extends javax.swing.JDialog {
    /**
     * Creates new form FrmTipoHabitacion
     */
    private Habitacion habitacion;
    private DefaultComboBoxModel<TipoHabitacion> tipoHabi;
    private Image foto;
    
    public FrmHabitacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        btnRegresar.setContentAreaFilled(false);
        btnRegistrarHabitacion.setContentAreaFilled(false);
        this.habitacion = new Habitacion();
        tipoHabi = new DefaultComboBoxModel<>();
        cbxTipoHabiacion.setModel(tipoHabi);
        cargarTiposHabitaciones();
    }
    public FrmHabitacion(java.awt.Frame parent, boolean modal, Habitacion habitacion) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        btnRegresar.setContentAreaFilled(false);
        btnRegistrarHabitacion.setContentAreaFilled(false);
        btnRegistrarHabitacion.setText("Editar");
        this.habitacion = habitacion;
        tipoHabi = new DefaultComboBoxModel<>();
        cbxTipoHabiacion.setModel(tipoHabi);
        cargarTiposHabitaciones();
        cargarHabitaciones();
    }
    private void irAFrmRegistro(){
        super.getParent().setVisible(true);
        dispose();
    } 
    public void cargarFoto(){
        try {
            lblErrorHabitacion.setText("");
            if (fcFoto.showDialog(this, "Seleccionar Foto") == JFileChooser.APPROVE_OPTION) {
                lblFoto.setText("");
                ImageIcon icon = new ImageIcon(fcFoto.getSelectedFile().getAbsolutePath());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                lblFoto.setIcon(icono);
                foto = icon.getImage();
            }
        } catch (Exception ex) {
            lblFoto.setIcon(null);
            lblFoto.setText("FOTO");
            lblErrorHabitacion.setText("Favor seleccione una imagen válida");
        }
    }
    public void cargarTiposHabitaciones(){
        cbxTipoHabiacion.removeAllItems();
        TipoHabitacionBO habibo = new TipoHabitacionBO();
        ArrayList<TipoHabitacion> listaHabi = habibo.cargarTiposDeHabitaciones();
        for (TipoHabitacion h : listaHabi) {
            tipoHabi.addElement(h);
        }
    }
    public void registrarHabitacion() throws IOException{
        lblErrorHabitacion.setText("");
        try {
            Habitacion habi = new Habitacion();
            habi.setId(this.habitacion.getId());
            habi.setCodigo(txtCodigo.getText().trim().toLowerCase());
            habi.setIdTipoHabitacion((TipoHabitacion) cbxTipoHabiacion.getSelectedItem());
            habi.setImagen(foto == null ? habitacion.getImagen() : foto);
            habi.setDescripcion(txtDescripcionPuesto.getText().trim());
            if(cbxEstado.getSelectedIndex() == 0){
                habi.setEstado(true);
            }else if(cbxEstado.getSelectedIndex() == 1 || cbxEstado.getSelectedIndex() == 2){
                habi.setEstado(false);
            }
            habi.setCantPersonas((Integer)spnCantPersonas.getValue());
            HabitacionBO habibo = new HabitacionBO();
            if (habibo.registrarHabitacion(habi)) {
                lblErrorHabitacion.setText("Puesto registrado con éxito.");
                super.getParent().setVisible(true);
                dispose();
            } else {
                lblErrorHabitacion.setText("Intente nuevamente.");
            }
        } catch (MiError ex) {
            lblErrorHabitacion.setText(ex.getMessage());
        } catch (Exception ex) {
            lblErrorHabitacion.setText("Llamar a TI ...xD");
        }
    }
    private void cargarHabitaciones(){
        
        txtCodigo.setText(habitacion.getCodigo());
        txtDescripcionPuesto.setText(habitacion.getDescripcion());
        cbxTipoHabiacion.setSelectedItem(habitacion.getIdTipoHabitacion());
        if(habitacion.isEstado()){
            cbxEstado.setSelectedItem("Disponible");
        }else if(!habitacion.isEstado()){
            cbxEstado.setSelectedItem("Ocupada");
        }
        spnCantPersonas.setValue(habitacion.getCantPersonas());
        lblFoto.setText("");
        ImageIcon icon = new ImageIcon(habitacion.getImagen());
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
        lblEstadoHabitacion1 = new javax.swing.JLabel();
        lblEstadoHabitacion = new javax.swing.JLabel();
        lblTipoHabitacion = new javax.swing.JLabel();
        cbxTipoHabiacion = new javax.swing.JComboBox<>();
        cbxEstado = new javax.swing.JComboBox<>();
        lblFoto = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblDescripcionPuesto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionPuesto = new javax.swing.JTextArea();
        btnRegistrarHabitacion = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblErrorHabitacion = new javax.swing.JLabel();
        spnCantPersonas = new javax.swing.JSpinner();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEstadoHabitacion1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEstadoHabitacion1.setForeground(new java.awt.Color(255, 255, 255));
        lblEstadoHabitacion1.setText("Cantida de Personas:");
        getContentPane().add(lblEstadoHabitacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        lblEstadoHabitacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEstadoHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        lblEstadoHabitacion.setText("Estado Habitación:");
        getContentPane().add(lblEstadoHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, -1));

        lblTipoHabitacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTipoHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoHabitacion.setText("Tipo Habitación:");
        getContentPane().add(lblTipoHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));

        cbxTipoHabiacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxTipoHabiacion.setForeground(new java.awt.Color(255, 255, 255));
        cbxTipoHabiacion.setMaximumRowCount(100);
        getContentPane().add(cbxTipoHabiacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 120, 30));

        cbxEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxEstado.setForeground(new java.awt.Color(255, 255, 255));
        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Ocupada", "Fuera de Servicio" }));
        getContentPane().add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 120, 30));

        lblFoto.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("FOTO");
        lblFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });
        getContentPane().add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 260, 230));

        lblCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigo.setText("Código:");
        getContentPane().add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 160, -1));

        lblDescripcionPuesto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDescripcionPuesto.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcionPuesto.setText("Descripción.");
        getContentPane().add(lblDescripcionPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        txtDescripcionPuesto.setColumns(20);
        txtDescripcionPuesto.setRows(5);
        jScrollPane2.setViewportView(txtDescripcionPuesto);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 260, 110));

        btnRegistrarHabitacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrarHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/registrar.png"))); // NOI18N
        btnRegistrarHabitacion.setText("Registar");
        btnRegistrarHabitacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarHabitacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarHabitacionActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgAtras.png"))); // NOI18N
        btnRegresar.setOpaque(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 44, 28));

        lblErrorHabitacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblErrorHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        lblErrorHabitacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorHabitacion.setToolTipText("");
        getContentPane().add(lblErrorHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 580, 30));

        spnCantPersonas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(spnCantPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 80, 30));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgRegistros.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnRegistrarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarHabitacionActionPerformed
        try {
            registrarHabitacion();
        } catch (IOException ex) {
            lblErrorHabitacion.setText("No se pudo registrar");
        }
    }//GEN-LAST:event_btnRegistrarHabitacionActionPerformed
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        irAFrmRegistro();
    }//GEN-LAST:event_btnRegresarActionPerformed
    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked
        cargarFoto();
    }//GEN-LAST:event_lblFotoMouseClicked
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
            java.util.logging.Logger.getLogger(FrmHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmHabitacion dialog = new FrmHabitacion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnRegistrarHabitacion;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<TipoHabitacion> cbxTipoHabiacion;
    private javax.swing.JFileChooser fcFoto;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescripcionPuesto;
    private javax.swing.JLabel lblErrorHabitacion;
    private javax.swing.JLabel lblEstadoHabitacion;
    private javax.swing.JLabel lblEstadoHabitacion1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblTipoHabitacion;
    private javax.swing.JSpinner spnCantPersonas;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcionPuesto;
    // End of variables declaration//GEN-END:variables
}