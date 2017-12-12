/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.gui;

import proyectoiiprograhotelutn.entities.Usuario;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 17/11/2017
 **/
public class FrmMenuPrincipal extends javax.swing.JFrame {
    /**
     * Creates new form FrmRegistro
     */
    private Usuario usuario;
    public FrmMenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        btnSalir.setContentAreaFilled(false);
        usuario = new Usuario();
    }
    public FrmMenuPrincipal(Usuario usu) {
        initComponents();
        setLocationRelativeTo(null);
        btnSalir.setContentAreaFilled(false);
        usuario = usu;
        System.out.println(usuario.getNombre() + " " + usuario.getCedula() );
    }
    private void irAFrmLogin(){
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
        dispose();
    }
    private void irARegistro(Usuario usu){
        FrmRegistro registro = new FrmRegistro(usu);
        registro.setVisible(true);
        dispose();
    }
    public void irAFrmEliminar(){
        FrmEliminar eliminar = new FrmEliminar();
        eliminar.setVisible(true);
        dispose();
    }
    public void irAModificar(){
        FrmModificar modificar = new FrmModificar();
        modificar.setVisible(true);
        dispose();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnElimniar = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistar.setBackground(new java.awt.Color(0, 153, 51));
        btnRegistar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRegistar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistar.setText("Ir a Registro");
        btnRegistar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, 90));

        btnModificar.setBackground(new java.awt.Color(153, 153, 0));
        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 100, 90));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/salir.png"))); // NOI18N
        btnSalir.setOpaque(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 44, 28));

        btnElimniar.setBackground(new java.awt.Color(204, 0, 0));
        btnElimniar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnElimniar.setForeground(new java.awt.Color(255, 255, 255));
        btnElimniar.setText("Eliminar");
        btnElimniar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnElimniar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnElimniar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimniarActionPerformed(evt);
            }
        });
        getContentPane().add(btnElimniar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 100, 90));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgFondoRegistro.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        irAFrmLogin();
    }//GEN-LAST:event_btnSalirActionPerformed
    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        irARegistro(usuario);
    }//GEN-LAST:event_btnRegistarActionPerformed
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        irAModificar();
    }//GEN-LAST:event_btnModificarActionPerformed
    private void btnElimniarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimniarActionPerformed
        irAFrmEliminar();
    }//GEN-LAST:event_btnElimniarActionPerformed
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
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElimniar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblFondo;
    // End of variables declaration//GEN-END:variables
}