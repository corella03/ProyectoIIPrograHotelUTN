/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.gui;

import proyectoiiprograhotelutn.entities.Usuario;
import proyectoiiprograhotelutn.gui.tiposhabitacion.FrmTipoHabitacion;
import proyectoiiprograhotelutn.gui.puesto.FrmPuesto;
import proyectoiiprograhotelutn.gui.agenciadeviajes.FrmAgenciaDeViajes;
import proyectoiiprograhotelutn.gui.cliente.FrmCliente;
import proyectoiiprograhotelutn.gui.habitacion.FrmHabitacion;
import proyectoiiprograhotelutn.gui.lugar.FrmCanton;
import proyectoiiprograhotelutn.gui.lugar.FrmDistrito;
import proyectoiiprograhotelutn.gui.lugar.FrmPais;
import proyectoiiprograhotelutn.gui.lugar.FrmProvincia;
import proyectoiiprograhotelutn.gui.usuario.FrmUsuario;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 28/11/2017
 **/
public class FrmRegistro extends javax.swing.JFrame {
    /**
     * Creates new form FrmRegistro
     */
    private Usuario usu;
    public FrmRegistro() {
        initComponents();
        setLocationRelativeTo(null);
        usu = new Usuario();
        btnRegresar.setContentAreaFilled(false);
    }
    public FrmRegistro(Usuario usu) {
        initComponents();
        setLocationRelativeTo(null);
        this.usu = usu;
        btnRegresar.setContentAreaFilled(false);
    }
    private void irAMenuPrincipal(){
        FrmMenuPrincipal principal = new FrmMenuPrincipal();
        principal.setVisible(true);
        dispose();
    }
    private void irAFrmTipoHabitacion(){
        FrmTipoHabitacion tipo = new FrmTipoHabitacion(this, true);
        tipo.setVisible(true);
        //dispose();
    }
    private void irAFrmPuesto(){
        FrmPuesto puesto = new FrmPuesto(this, true);
        puesto.setVisible(true);
    }
    private void irAFrmAgencia(){
        FrmAgenciaDeViajes agencia = new FrmAgenciaDeViajes(this, true);
        agencia.setVisible(true);
    }
    private void irAFrmPais(){
        FrmPais pais = new FrmPais(this, true);
        pais.setVisible(true);
    }
    public void irAFrmProvincia(){
        FrmProvincia provincia = new FrmProvincia(this, true);
        provincia.setVisible(true);
    }
    public void irAFrmCanton(){
        FrmCanton canton = new FrmCanton(this, true);
        canton.setVisible(true);
    }
    public void irAFrmDistrito(){
        FrmDistrito distrito = new FrmDistrito(this, true);
        distrito.setVisible(true);
    }
    public void irAFrmHabitacion(){
        FrmHabitacion habi = new FrmHabitacion(this, true);
        habi.setVisible(true);
    }
    public void irAFrmCliente(Usuario usu){
        FrmCliente cli = new FrmCliente(this, true,usu);
        cli.setVisible(true);
    }
    public void irAFrmUsuario(){
        FrmUsuario usuario = new FrmUsuario(this, true);
        usuario.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCliente = new javax.swing.JButton();
        btnTipoHabitacion = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnPuesto = new javax.swing.JButton();
        btnAgencia = new javax.swing.JButton();
        btnLugar = new javax.swing.JButton();
        btnProvincia = new javax.swing.JButton();
        btnCanton = new javax.swing.JButton();
        btnDistrito = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnHabitacion = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCliente.setBackground(new java.awt.Color(0, 153, 51));
        btnCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCliente.setText("Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 90, 30));

        btnTipoHabitacion.setBackground(new java.awt.Color(0, 153, 51));
        btnTipoHabitacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTipoHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        btnTipoHabitacion.setText("Tipo Habitación");
        btnTipoHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoHabitacionActionPerformed(evt);
            }
        });
        getContentPane().add(btnTipoHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 140, 30));

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgAtras.png"))); // NOI18N
        btnRegresar.setOpaque(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 44, 28));

        btnPuesto.setBackground(new java.awt.Color(0, 153, 51));
        btnPuesto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPuesto.setForeground(new java.awt.Color(255, 255, 255));
        btnPuesto.setText("Puesto");
        btnPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuestoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 90, 30));

        btnAgencia.setBackground(new java.awt.Color(0, 153, 51));
        btnAgencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgencia.setForeground(new java.awt.Color(255, 255, 255));
        btnAgencia.setText("Agencia de Viajes");
        btnAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgenciaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 140, 30));

        btnLugar.setBackground(new java.awt.Color(0, 153, 51));
        btnLugar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLugar.setForeground(new java.awt.Color(255, 255, 255));
        btnLugar.setText("Pais");
        btnLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLugarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 90, 30));

        btnProvincia.setBackground(new java.awt.Color(0, 153, 51));
        btnProvincia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnProvincia.setForeground(new java.awt.Color(255, 255, 255));
        btnProvincia.setText("Provincia");
        btnProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProvinciaActionPerformed(evt);
            }
        });
        getContentPane().add(btnProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 90, 30));

        btnCanton.setBackground(new java.awt.Color(0, 153, 51));
        btnCanton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCanton.setForeground(new java.awt.Color(255, 255, 255));
        btnCanton.setText("Canton");
        btnCanton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantonActionPerformed(evt);
            }
        });
        getContentPane().add(btnCanton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 90, 30));

        btnDistrito.setBackground(new java.awt.Color(0, 153, 51));
        btnDistrito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDistrito.setForeground(new java.awt.Color(255, 255, 255));
        btnDistrito.setText("Distrito");
        btnDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistritoActionPerformed(evt);
            }
        });
        getContentPane().add(btnDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 90, 30));

        btnUsuario.setBackground(new java.awt.Color(0, 153, 51));
        btnUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuario.setText("Usuario");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 90, 30));

        btnHabitacion.setBackground(new java.awt.Color(0, 153, 51));
        btnHabitacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        btnHabitacion.setText("Habitación");
        btnHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabitacionActionPerformed(evt);
            }
        });
        getContentPane().add(btnHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 140, 30));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 153, 51));
        lblTitulo.setText(" Ventana de Registros");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 390, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgFondoRegistro.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        irAMenuPrincipal();
    }//GEN-LAST:event_btnRegresarActionPerformed
    private void btnTipoHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoHabitacionActionPerformed
        irAFrmTipoHabitacion();
    }//GEN-LAST:event_btnTipoHabitacionActionPerformed
    private void btnPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuestoActionPerformed
        irAFrmPuesto();
    }//GEN-LAST:event_btnPuestoActionPerformed
    private void btnAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgenciaActionPerformed
        irAFrmAgencia();
    }//GEN-LAST:event_btnAgenciaActionPerformed
    private void btnLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLugarActionPerformed
        irAFrmPais();
    }//GEN-LAST:event_btnLugarActionPerformed
    private void btnProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProvinciaActionPerformed
        irAFrmProvincia();
    }//GEN-LAST:event_btnProvinciaActionPerformed
    private void btnCantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantonActionPerformed
        irAFrmCanton();
    }//GEN-LAST:event_btnCantonActionPerformed
    private void btnDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistritoActionPerformed
        irAFrmDistrito();
    }//GEN-LAST:event_btnDistritoActionPerformed
    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        irAFrmUsuario();
    }//GEN-LAST:event_btnUsuarioActionPerformed
    private void btnHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabitacionActionPerformed
        irAFrmHabitacion();
    }//GEN-LAST:event_btnHabitacionActionPerformed
    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        irAFrmCliente(usu);
    }//GEN-LAST:event_btnClienteActionPerformed
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
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistro().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgencia;
    private javax.swing.JButton btnCanton;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnDistrito;
    private javax.swing.JButton btnHabitacion;
    private javax.swing.JButton btnLugar;
    private javax.swing.JButton btnProvincia;
    private javax.swing.JButton btnPuesto;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnTipoHabitacion;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}