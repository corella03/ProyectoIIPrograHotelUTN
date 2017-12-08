/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.gui;

import proyectoiiprograhotelutn.gui.tiposhabitacion.FrmCargarTiposHabitacion;
import proyectoiiprograhotelutn.gui.puesto.FrmCargarPuestos;
import proyectoiiprograhotelutn.gui.agenciadeviajes.FrmCargarAgencias;
import proyectoiiprograhotelutn.gui.usuario.FrmCargarUsuarios;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 29/11/2017
 **/
public class FrmEliminar extends javax.swing.JFrame {
    /**
     * Creates new form FrmEliminar
     */
    public FrmEliminar() {
        initComponents();
        setLocationRelativeTo(null);
    }
    private void irAModificarEliminarTipo(int opc){
        FrmCargarTiposHabitacion tipo = new FrmCargarTiposHabitacion(this, true, opc);
        tipo.setVisible(true);
    }
    public void irAModificarEliminarPuesto(int opc){
        FrmCargarPuestos puestos = new FrmCargarPuestos(this, true, opc);
        puestos.setVisible(true);  
    }
    public void irAModificarEliminarAgencia(int opc){
        FrmCargarAgencias agencias = new FrmCargarAgencias(this, true, opc);
        agencias.setVisible(true);  
    }
    public void irAModificarEliminarUsuario(int opc){
        FrmCargarUsuarios usuario = new FrmCargarUsuarios(this, true, opc);
        usuario.setVisible(true);  
    }
    private void irAMenuPrincipal(){
        FrmMenuPrincipal principal = new FrmMenuPrincipal();
        principal.setVisible(true);
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

        btnTipoHabitacion = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnPuesto = new javax.swing.JButton();
        btnAgencia = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        btnTipoHabitacion.setText("Tipo Habitación");
        btnTipoHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoHabitacionActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgAtras.png"))); // NOI18N
        btnRegresar.setOpaque(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setText("Elimniar");

        btnPuesto.setText("Puesto");
        btnPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuestoActionPerformed(evt);
            }
        });

        btnAgencia.setText("Agencia de Viajes");
        btnAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgenciaActionPerformed(evt);
            }
        });

        btnUsuario.setText("Usuarios");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(254, 254, 254)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUsuario)
                    .addComponent(btnTipoHabitacion))
                .addGap(61, 61, 61)
                .addComponent(btnPuesto)
                .addGap(101, 101, 101)
                .addComponent(btnAgencia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTipoHabitacion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPuesto)
                            .addComponent(btnAgencia))))
                .addGap(71, 71, 71)
                .addComponent(btnUsuario)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnTipoHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoHabitacionActionPerformed
        irAModificarEliminarTipo(2);
    }//GEN-LAST:event_btnTipoHabitacionActionPerformed
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        irAMenuPrincipal();
    }//GEN-LAST:event_btnRegresarActionPerformed
    private void btnPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuestoActionPerformed
        irAModificarEliminarPuesto(2);
    }//GEN-LAST:event_btnPuestoActionPerformed
    private void btnAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgenciaActionPerformed
        irAModificarEliminarAgencia(2);
    }//GEN-LAST:event_btnAgenciaActionPerformed
    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        irAModificarEliminarUsuario(2);
    }//GEN-LAST:event_btnUsuarioActionPerformed
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
            java.util.logging.Logger.getLogger(FrmEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEliminar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgencia;
    private javax.swing.JButton btnPuesto;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnTipoHabitacion;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}