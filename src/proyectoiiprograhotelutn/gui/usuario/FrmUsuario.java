/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.gui.usuario;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import proyectoiiprograhotelutn.bo.CantonBO;
import proyectoiiprograhotelutn.bo.DistritoBO;
import proyectoiiprograhotelutn.bo.PaisBO;
import proyectoiiprograhotelutn.bo.ProvinciaBO;
import proyectoiiprograhotelutn.bo.PuestoBO;
import proyectoiiprograhotelutn.bo.UsuarioBO;
import proyectoiiprograhotelutn.entities.Canton;
import proyectoiiprograhotelutn.entities.Distrito;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Pais;
import proyectoiiprograhotelutn.entities.Provincia;
import proyectoiiprograhotelutn.entities.Puesto;
import proyectoiiprograhotelutn.entities.Usuario;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 01/11/2017
 **/
public class FrmUsuario extends javax.swing.JDialog {
    /**
     * Creates new form FrmTipoHabitacion
     */
    private Usuario usuario;
    private DefaultComboBoxModel<Pais> paises;
    private DefaultComboBoxModel<Provincia> provincias;
    private DefaultComboBoxModel<Canton> cantones;
    private DefaultComboBoxModel<Distrito> distritos;
    private DefaultComboBoxModel<Puesto> puestos;
    public FrmUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        btnRegresar.setContentAreaFilled(false);
        btnRegistrarUsuario.setContentAreaFilled(false);
        this.usuario = new Usuario();
        rdActivoTipoHabitacion.setVisible(false);
        DatosIniciales();
        cargarPaises();
        cargarPuestos();
    }
    public FrmUsuario(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        btnRegresar.setContentAreaFilled(false);
        btnRegistrarUsuario.setContentAreaFilled(false);
        btnRegistrarUsuario.setText("Editar");
        rdActivoTipoHabitacion.setContentAreaFilled(false);
        lblContrasena.setVisible(false);
        txtContrasena.setVisible(false);
        this.usuario = usuario;
        DatosIniciales();
        cargarPaises();
        cargarPuestos();
        cargarUsuarios();
    }
    private void DatosIniciales(){
        paises = new DefaultComboBoxModel<>();
        provincias = new DefaultComboBoxModel<>();
        cantones = new DefaultComboBoxModel<>();
        puestos = new DefaultComboBoxModel<>();
        distritos = new DefaultComboBoxModel<>();
        cbxPais.setModel(paises);
        cbxProvincia.setModel(provincias);
        cbxCanton.setModel(cantones);
        cbxPuestos.setModel(puestos);
        cbxDistrito.setModel(distritos);
    }
    private void irAFrmRegistro(){
        super.getParent().setVisible(true);
        dispose();
    } 
    /**
     * Se encarga de cragar paises en un combobox
     */
    public void cargarPaises(){
        cbxPais.removeAllItems();
        PaisBO paisbo = new PaisBO();
        ArrayList<Pais> listaPaises = paisbo.cargarPaises();
        for (Pais p : listaPaises) {
            paises.addElement(p);
        }
    }
    /**
     * Se encarga de cragar provincias en un combobox
     */
    public void cargarProvincias(){
        cbxProvincia.removeAllItems();
        ProvinciaBO provinciabo = new ProvinciaBO();
        ArrayList<Provincia> listaProvincias = provinciabo.cargarProvinciasDePais(1);
        for (Provincia p : listaProvincias) {
            provincias.addElement(p);
        }
    }
    /**
     * Se encarga de cargar  cantones en  un combobox
     * @param numDeProvincias cantidad de provincia en el combobox
     */
    public void cargarCantones(int numDeProvincias){
        cbxCanton.removeAllItems();
        if(numDeProvincias > 0) {
            CantonBO cantonbo = new CantonBO();
            ArrayList<Canton> listaCantones = cantonbo.cargarCantonesDeProvincia(((Provincia) cbxProvincia.getSelectedItem()).getId());
            for (Canton c : listaCantones) {
                cantones.addElement(c);
            }
        }
    }
    /**
     * Se encarga de cargar distritos en  un combobox
     * @param numDeCantones cantidad de cantones en el combobox
     */
    public void cargarDistritos(int numDeCantones){
        cbxDistrito.removeAllItems();
        if(numDeCantones > 0) {
            DistritoBO distritobo = new DistritoBO();
            ArrayList<Distrito> listaDeDistritos = distritobo.cargarDistritosDeCantones(((Canton) cbxCanton.getSelectedItem()).getId());
            for (Distrito d : listaDeDistritos) {
                distritos.addElement(d);
            }
        }
    }
    /**
     * Se encarga de cargar puestos en un combobox
     */
    public void cargarPuestos(){
        cbxPuestos.removeAllItems();
        PuestoBO puestobo = new PuestoBO();
        ArrayList<Puesto> listaPuestos = puestobo.cargarPuestos();
        for (Puesto p : listaPuestos) {
            puestos.addElement(p);
        }
    }
    public void registrarUsuario(){
        lblErrorUsuario.setText("");
        try {
            Usuario usuario = new Usuario();
            usuario.setId(this.usuario.getId());
            usuario.setNombre(txtNombre.getText().trim());
            usuario.setApellido(txtApellido.getText().trim());
            usuario.setCedula(txtCedula.getText().trim().toUpperCase());
            String telefono = txtTelefono.getText().trim() + txtTelefono2.getText().trim()
                + txtTelefono3.getText().trim();
            usuario.setTelefono(Integer.parseInt(telefono));
            usuario.setContrasena( new String (txtContrasena.getPassword()).trim().toLowerCase());
            usuario.setDireccion(txtDireccion.getText().trim());
            usuario.setIdDistrito((Distrito) cbxDistrito.getSelectedItem());
            usuario.setIdPuesto((Puesto) cbxPuestos.getSelectedItem());            
            if(rdActivoTipoHabitacion.isSelected()){
                usuario.setActivo(true);
            }else{
                usuario.setActivo(false);
            }    
            UsuarioBO usubo = new UsuarioBO();
            if (usubo.registrarUsuario(usuario)) {
                lblErrorUsuario.setText("Usuario registrado con éxito.");                
                super.getParent().setVisible(true);
                dispose();
            } else {
                lblErrorUsuario.setText("Intente nuevamente.");
            }
        } catch (MiError ex) {
            lblErrorUsuario.setText(ex.getMessage());
        } catch (Exception ex) {
            lblErrorUsuario.setText("Llamar a TI ...xD");
        }
    }
    private void cargarUsuarios(){
        txtNombre.setText(usuario.getNombre());
        txtApellido.setText(usuario.getApellido());
        txtCedula.setText(usuario.getCedula());
        String telefono = String.valueOf(usuario.getTelefono());
        for (int i = 0; i < 8; i++) {
            if(i <= 3){
                txtTelefono.setText(txtTelefono.getText() + String.valueOf(telefono.charAt(i)));
            }else if(i == 4 || i == 5){
                txtTelefono2.setText(txtTelefono2.getText() + String.valueOf(telefono.charAt(i)));
            }else if( i== 6 || i == 7){
                txtTelefono3.setText(txtTelefono3.getText() + String.valueOf(telefono.charAt(i)));
            }
        }
        txtDireccion.setText(usuario.getDireccion());
        cbxPais.setSelectedItem(usuario.getIdDistrito().getCanton().getProvincia().getPais());
        cbxProvincia.setSelectedItem(usuario.getIdDistrito().getCanton().getProvincia());
        cbxCanton.setSelectedItem(usuario.getIdDistrito().getCanton());
        cbxDistrito.setSelectedItem(usuario.getIdDistrito());
        cbxPuestos.setSelectedItem(usuario.getIdPuesto());
        if(usuario.isActivo()){
            rdActivoTipoHabitacion.setSelected(true);
        }else if(!usuario.isActivo()){
            rdActivoTipoHabitacion.setSelected(false);
        }
        txtContrasena.setText(usuario.getContrasena());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombrePais3 = new javax.swing.JLabel();
        cbxPuestos = new javax.swing.JComboBox<>();
        lblNombrePais2 = new javax.swing.JLabel();
        cbxDistrito = new javax.swing.JComboBox<>();
        rdActivoTipoHabitacion = new javax.swing.JRadioButton();
        lblNombrePais = new javax.swing.JLabel();
        cbxPais = new javax.swing.JComboBox<>();
        lblNombreProvincia = new javax.swing.JLabel();
        cbxProvincia = new javax.swing.JComboBox<>();
        lblNombrePais1 = new javax.swing.JLabel();
        cbxCanton = new javax.swing.JComboBox<>();
        txtContrasena = new javax.swing.JPasswordField();
        lblContrasena = new javax.swing.JLabel();
        lblTelfonoAgencia = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtTelefono2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtTelefono3 = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnRegistrarUsuario = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblDireccion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        lblErrorUsuario = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombrePais3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombrePais3.setForeground(new java.awt.Color(255, 255, 255));
        lblNombrePais3.setText("Puesto:");
        getContentPane().add(lblNombrePais3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, -1, -1));

        getContentPane().add(cbxPuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, 140, 28));

        lblNombrePais2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombrePais2.setForeground(new java.awt.Color(255, 255, 255));
        lblNombrePais2.setText("Distrito:");
        getContentPane().add(lblNombrePais2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, -1, -1));

        getContentPane().add(cbxDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 140, 28));

        rdActivoTipoHabitacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdActivoTipoHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        rdActivoTipoHabitacion.setText("Activo");
        getContentPane().add(rdActivoTipoHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        lblNombrePais.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombrePais.setForeground(new java.awt.Color(255, 255, 255));
        lblNombrePais.setText("Paises:");
        getContentPane().add(lblNombrePais, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, -1));

        cbxPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPaisActionPerformed(evt);
            }
        });
        getContentPane().add(cbxPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 142, 28));

        lblNombreProvincia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombreProvincia.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreProvincia.setText("Provincias:");
        getContentPane().add(lblNombreProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

        cbxProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProvinciaActionPerformed(evt);
            }
        });
        getContentPane().add(cbxProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 142, 28));

        lblNombrePais1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombrePais1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombrePais1.setText("Canton:");
        getContentPane().add(lblNombrePais1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, -1));

        cbxCanton.setMaximumRowCount(100);
        cbxCanton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCantonActionPerformed(evt);
            }
        });
        getContentPane().add(cbxCanton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 140, 28));
        getContentPane().add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 160, 30));

        lblContrasena.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblContrasena.setForeground(new java.awt.Color(255, 255, 255));
        lblContrasena.setText("Contraseña:");
        getContentPane().add(lblContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, 20));

        lblTelfonoAgencia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTelfonoAgencia.setForeground(new java.awt.Color(255, 255, 255));
        lblTelfonoAgencia.setText("Telefono:");
        getContentPane().add(lblTelfonoAgencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 50, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 10, 10));

        txtTelefono2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtTelefono2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono2KeyTyped(evt);
            }
        });
        getContentPane().add(txtTelefono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 40, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 10, 10));

        txtTelefono3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtTelefono3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono3KeyTyped(evt);
            }
        });
        getContentPane().add(txtTelefono3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 40, -1));

        lblCedula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCedula.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula.setText("Cédula:");
        getContentPane().add(lblCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        txtCedula.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 160, -1));

        lblApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setText("Apellido:");
        getContentPane().add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 160, -1));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 160, -1));

        btnRegistrarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/registrar.png"))); // NOI18N
        btnRegistrarUsuario.setText("Registar");
        btnRegistrarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgAtras.png"))); // NOI18N
        btnRegresar.setOpaque(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 44, 28));

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccion.setText("Dirección:");
        getContentPane().add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        txtDireccion.setColumns(20);
        txtDireccion.setRows(5);
        jScrollPane2.setViewportView(txtDireccion);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 260, 110));

        lblErrorUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblErrorUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblErrorUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorUsuario.setToolTipText("");
        getContentPane().add(lblErrorUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 580, 30));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgRegistros.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuarioActionPerformed
        registrarUsuario();
    }//GEN-LAST:event_btnRegistrarUsuarioActionPerformed
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        irAFrmRegistro();
    }//GEN-LAST:event_btnRegresarActionPerformed
    private void cbxPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPaisActionPerformed
        cargarProvincias();
    }//GEN-LAST:event_cbxPaisActionPerformed
    private void cbxCantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCantonActionPerformed
        cargarDistritos(cbxCanton.getItemCount());
    }//GEN-LAST:event_cbxCantonActionPerformed
    private void cbxProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvinciaActionPerformed
        cargarCantones(cbxProvincia.getItemCount());
    }//GEN-LAST:event_cbxProvinciaActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char numero = evt.getKeyChar();
        if (Character.isLetter(numero)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtTelefono2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono2KeyTyped
        char numero = evt.getKeyChar();
        if (Character.isLetter(numero)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtTelefono2KeyTyped

    private void txtTelefono3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono3KeyTyped
        char numero = evt.getKeyChar();
        if (Character.isLetter(numero)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtTelefono3KeyTyped
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
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmUsuario dialog = new FrmUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnRegistrarUsuario;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<Canton> cbxCanton;
    private javax.swing.JComboBox<Distrito> cbxDistrito;
    private javax.swing.JComboBox<Pais> cbxPais;
    private javax.swing.JComboBox<Provincia> cbxProvincia;
    private javax.swing.JComboBox<Puesto> cbxPuestos;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblErrorUsuario;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombrePais;
    private javax.swing.JLabel lblNombrePais1;
    private javax.swing.JLabel lblNombrePais2;
    private javax.swing.JLabel lblNombrePais3;
    private javax.swing.JLabel lblNombreProvincia;
    private javax.swing.JLabel lblTelfonoAgencia;
    private javax.swing.JRadioButton rdActivoTipoHabitacion;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefono2;
    private javax.swing.JTextField txtTelefono3;
    // End of variables declaration//GEN-END:variables
}