/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.gui;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import proyectoiiprograhotelutn.bo.TipoHabitacionBO;
import proyectoiiprograhotelutn.entities.TipoHabitacion;

/**
 *
 * @author luisalonso
 */
public class FrmCargarTiposHabitacion extends javax.swing.JFrame {
    /**
     * Creates new form FrmCargarTiposHabitacion
     */
    private DefaultTableModel modelo;
    private TipoHabitacionBO tipobo;
    private TipoHabitacion tipo;
    public FrmCargarTiposHabitacion() {
        initComponents();
        setLocationRelativeTo(null);
        btnRegresar.setContentAreaFilled(false);
        tipobo = new TipoHabitacionBO();
        tipo = new TipoHabitacion();
        modelo = (DefaultTableModel) tbTipoHabitacion.getModel();
        cargarTipoHabitacion();
    }
    private void cargarTipoHabitacion(){
        limpiarTabla();
        ArrayList<TipoHabitacion> tipo = tipobo.cargarTiposDeHabitacionesActivas();
        for (TipoHabitacion th : tipo) {
            Object[] row = {
                th.getId(),
                th.getCodigo(),
                th.getPrecio(),
                th.getDescripcion(),
            };
            modelo.addRow(row);
        }
    }
    private void cargarTiposHabitacionEliminados(){
        limpiarTabla();
        ArrayList<TipoHabitacion> tipo = tipobo.cargarTiposDeHabitaciones();
        for (TipoHabitacion th : tipo) {
            if(!th.isActivo()){
                Object[] row = {
                th.getId(),
                th.getCodigo(),
                th.getPrecio(),
                th.getDescripcion(),
            };
                modelo.addRow(row);
            }
        }
    }
    private void limpiarTabla() {
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    private void editarTipoHabitacion(){
        int row = tbTipoHabitacion.getSelectedRow();
        if (row > -1) {
            tipo = tipobo.getTipoHabitacion((int)modelo.getValueAt(row, 0));
            System.out.println(tipobo.toString());
            FrmTipoHabitacion modificar = new FrmTipoHabitacion(this,true,tipo);
            modificar.setVisible(true);
            cargarTipoHabitacion();
        }
    }
    public void eliminarTipoHabitacion(){
        int row = tbTipoHabitacion.getSelectedRow();
        if (row > -1) {
            tipo = tipobo.getTipoHabitacion((int)modelo.getValueAt(row, 0));
            tipobo.elmininarTiposHabitacion(tipo);
        }
        cargarTipoHabitacion();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbTipoHabitacion = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVerEliminados = new javax.swing.JButton();
        lblFondoTabla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbTipoHabitacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Código", "Precio", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbTipoHabitacion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, 217));

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgAtras.png"))); // NOI18N
        btnRegresar.setOpaque(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 44, 28));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, -1, -1));

        btnEliminar.setText("jButton2");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));

        btnVerEliminados.setText("Ver");
        btnVerEliminados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEliminadosActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerEliminados, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));
        getContentPane().add(lblFondoTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        irAMenuPrincipal();
    }//GEN-LAST:event_btnRegresarActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editarTipoHabitacion();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarTipoHabitacion();
    }//GEN-LAST:event_btnEliminarActionPerformed
    private void btnVerEliminadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEliminadosActionPerformed
        cargarTiposHabitacionEliminados();
    }//GEN-LAST:event_btnVerEliminadosActionPerformed
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
            java.util.logging.Logger.getLogger(FrmCargarTiposHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCargarTiposHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCargarTiposHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCargarTiposHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCargarTiposHabitacion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerEliminados;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFondoTabla;
    private javax.swing.JTable tbTipoHabitacion;
    // End of variables declaration//GEN-END:variables
}