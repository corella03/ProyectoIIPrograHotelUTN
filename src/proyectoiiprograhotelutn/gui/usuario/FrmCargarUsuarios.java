/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.gui.usuario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import proyectoiiprograhotelutn.bo.UsuarioBO;
import proyectoiiprograhotelutn.entities.Usuario;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 29/11/2017
 **/
public class FrmCargarUsuarios extends javax.swing.JDialog {
    /**
     * Creates new form FrmCargarTiposHabitacion
     */
    private DefaultTableModel modelo;
    private UsuarioBO usuariobo;
    private Usuario usuario;
    private int opc;
    public FrmCargarUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        btnRegresar.setContentAreaFilled(false);
        usuariobo = new UsuarioBO();
        usuario = new Usuario();
        modelo = (DefaultTableModel) tbUsuario.getModel();
        cargarUsuarios();
    }
    public FrmCargarUsuarios(java.awt.Frame parent, boolean modal,int opc) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.opc = opc;
        vistaInicial();
        btnRegresar.setContentAreaFilled(false);
        usuariobo = new UsuarioBO();
        usuario = new Usuario();
        modelo = (DefaultTableModel) tbUsuario.getModel();
        cargarUsuarios();
    }
    /**
     * 1 Modifica
     * 2 elimina
     */
    public void vistaInicial(){
        if(opc == 1){
            btnEliminar.setVisible(false);
        }else if(opc == 2){
            btnVerActivos.setVisible(false);
            btnVerEliminados.setVisible(false);
            btnEditar.setVisible(false);
            btnEliminar.setVisible(true);
        }
    }
    private void cargarUsuarios(){
        limpiarTabla();
        ArrayList<Usuario> usu = usuariobo.cargarUsuarioActivos();
        for (Usuario u : usu) {
            Object[] row = {
                u.getId(),
                u.getNombre(),
                u.getApellido(),
                u.getCedula(),
                u.getIdPuesto(),
            };
            modelo.addRow(row);
        }
    }
    private void cargarUsuariosEliminados(){
        limpiarTabla();
        ArrayList<Usuario> usu = usuariobo.cargarUsuario();
        for (Usuario u : usu) {
            if(!u.isActivo()){
                Object[] row = {
                u.getId(),
                u.getNombre(),
                u.getApellido(),
                u.getCedula(),
                u.getIdPuesto(),
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
    private void editarUsuario(){
        int row = tbUsuario.getSelectedRow();
        if (row > -1) {
            usuario = usuariobo.getUsuario((int)modelo.getValueAt(row, 0));
            FrmUsuario modificar = new FrmUsuario(null,true,usuario);
            modificar.setVisible(true);
            cargarUsuarios();
        }
    }
    public void eliminarUsuario(){
        int row = tbUsuario.getSelectedRow();
        if (row > -1) {
            usuario = usuariobo.getUsuario((int)modelo.getValueAt(row, 0));
            usuariobo.elmininarUsuario(usuario);
        }
        cargarUsuarios();
    }
    private void irAMenuPrincipal(){
        super.getParent().setVisible(true);
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
        tbUsuario = new javax.swing.JTable();
        btnVerActivos = new javax.swing.JButton();
        btnVerEliminados = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Cédula", "Puesto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbUsuario);

        btnVerActivos.setText("Usuarios Activos");
        btnVerActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActivosActionPerformed(evt);
            }
        });

        btnVerEliminados.setText("Ver Eliminados");
        btnVerEliminados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEliminadosActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setText("Modificar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVerActivos)
                        .addGap(63, 63, 63)
                        .addComponent(btnVerEliminados)
                        .addGap(56, 56, 56)
                        .addComponent(btnEliminar)
                        .addGap(44, 44, 44)
                        .addComponent(btnEditar)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnVerActivos)
                                    .addComponent(btnVerEliminados)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnVerActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActivosActionPerformed
        cargarUsuarios();
    }//GEN-LAST:event_btnVerActivosActionPerformed
    private void btnVerEliminadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEliminadosActionPerformed
        cargarUsuariosEliminados();
    }//GEN-LAST:event_btnVerEliminadosActionPerformed
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarUsuario();
    }//GEN-LAST:event_btnEliminarActionPerformed
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editarUsuario();
    }//GEN-LAST:event_btnEditarActionPerformed
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        irAMenuPrincipal();
    }//GEN-LAST:event_btnRegresarActionPerformed
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
            java.util.logging.Logger.getLogger(FrmCargarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCargarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCargarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCargarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmCargarUsuarios dialog = new FrmCargarUsuarios(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerActivos;
    private javax.swing.JButton btnVerEliminados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuario;
    // End of variables declaration//GEN-END:variables
}