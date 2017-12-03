/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.gui.Lugar;
import proyectoiiprograhotelutn.bo.PaisBO;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Pais;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 01/11/2017
 **/
public class FrmPais extends javax.swing.JDialog {
    /**
     * Creates new form FrmTipoHabitacion
     */
    private Pais pais;
    public FrmPais(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        btnRegresar.setContentAreaFilled(false);
        btnRegistrarPais.setContentAreaFilled(false);   
        this.pais = new Pais();
    }
    public FrmPais(java.awt.Frame parent, boolean modal, Pais pais) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        btnRegresar.setContentAreaFilled(false);
        btnRegistrarPais.setContentAreaFilled(false);   
        this.pais = pais;
        cargarPais();
    }
    private void irAFrmRegistro(){
        super.getParent().setVisible(true);
        dispose();
    } 
    public void registrarPais(){
        lblErrorLugar.setText("");
        try {
            Pais nuevoPais = new Pais();
            pais.setId(this.pais.getId());
            nuevoPais.setNombre(txtNombrePais.getText().trim().toLowerCase());
            PaisBO paisbo = new PaisBO();
            if (paisbo.registrarPais(nuevoPais)) {
                lblErrorLugar.setText("País registrado con éxito.");
            } else {
                lblErrorLugar.setText("Intente nuevamente.");
            }
        } catch (MiError ex) {
            lblErrorLugar.setText(ex.getMessage());
        } catch (Exception ex) {
            lblErrorLugar.setText("Llamar a TI ...xD");
        }
    }
    private void cargarPais(){
        txtNombrePais.setText(pais.getNombre());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JButton();
        lblErrorLugar = new javax.swing.JLabel();
        lblNombrePais = new javax.swing.JLabel();
        txtNombrePais = new javax.swing.JTextField();
        btnRegistrarPais = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgAtras.png"))); // NOI18N
        btnRegresar.setOpaque(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 44, 28));

        lblErrorLugar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblErrorLugar.setForeground(new java.awt.Color(255, 255, 255));
        lblErrorLugar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorLugar.setToolTipText("");
        getContentPane().add(lblErrorLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 580, 30));

        lblNombrePais.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombrePais.setForeground(new java.awt.Color(255, 255, 255));
        lblNombrePais.setText("Nombre:");
        getContentPane().add(lblNombrePais, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        txtNombrePais.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(txtNombrePais, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 160, 29));

        btnRegistrarPais.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistrarPais.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/registrar.png"))); // NOI18N
        btnRegistrarPais.setText("Registar");
        btnRegistrarPais.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarPais.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPaisActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgRegistros.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        irAFrmRegistro();
    }//GEN-LAST:event_btnRegresarActionPerformed
    private void btnRegistrarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPaisActionPerformed
        registrarPais();
    }//GEN-LAST:event_btnRegistrarPaisActionPerformed
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
            java.util.logging.Logger.getLogger(FrmPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPais dialog = new FrmPais(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnRegistrarPais;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel lblErrorLugar;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblNombrePais;
    private javax.swing.JTextField txtNombrePais;
    // End of variables declaration//GEN-END:variables
}