/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.gui.Lugar;
import javax.swing.DefaultComboBoxModel;
import proyectoiiprograhotelutn.bo.PaisBO;
import proyectoiiprograhotelutn.bo.ProvinciaBO;
import proyectoiiprograhotelutn.entities.Canton;
import proyectoiiprograhotelutn.entities.Distrito;
import proyectoiiprograhotelutn.entities.Lugar;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Pais;
import proyectoiiprograhotelutn.entities.Provincia;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 01/11/2017
 **/
public class FrmDistrito extends javax.swing.JDialog {
    /**
     * Creates new form FrmTipoHabitacion
     */
    private Pais pais;
    private Provincia provincia;
    private Canton canton;
    private Distrito distrito;
    private DefaultComboBoxModel<Pais> paises;
    public FrmDistrito(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        btnRegresar.setContentAreaFilled(false);
        datosIniciales();
        this.pais = new Pais();
        this.provincia = new Provincia();
        this.canton = new Canton();
        this.distrito = new Distrito();
        
    }
    
    public FrmDistrito(java.awt.Frame parent, boolean modal, Distrito distrito) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        datosIniciales();
        this.distrito = distrito;
    }
    public void datosIniciales(){
        cargarPaises();
        paises = new DefaultComboBoxModel<>();
        rdPais.setSelected(true);
        vistaLugar();
        btnRegresar.setContentAreaFilled(false);
        btnRegistrarPais.setContentAreaFilled(false);
        btnRegistrarProvincia.setContentAreaFilled(false);
        btnRegistrarCanton.setContentAreaFilled(false);
        btnRegistrarDistrito.setContentAreaFilled(false);        
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
    public void cargarPaises(){
        cbxPaisProvincia.removeAllItems();
        PaisBO paisbo = new PaisBO();
        for (int i = 0; i < paisbo.cargarPaises().size(); i++) {
            cbxPaisProvincia.addItem((Pais) paisbo.cargarPaises().get(i));
        }
    }
    public void registrarProvincia(){
        lblErrorLugar.setText("");
        try {
            PaisBO paisbo = new PaisBO();
            ProvinciaBO provinciabo = new ProvinciaBO();
            Provincia nuevaProvincia = new Provincia();
            provincia.setId(this.provincia.getId());
            nuevaProvincia.setNombre(txtNombreProvincia.getText().trim().toLowerCase());
//            nuevaProvincia.setIdPais(paisbo.cargarPaises().get(indexPais).getId());
            if (provinciabo.registrarProvincia(nuevaProvincia)) {
                lblErrorLugar.setText("Provincia registrada con éxito.");
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
    public void vistaLugar(){
        if(rdPais.isSelected()){
            txtNombrePais.setEnabled(true);
            btnRegistrarPais.setEnabled(true);
            txtNombreProvincia.setEnabled(false);
            cbxPaisProvincia.setEnabled(false);
            btnRegistrarProvincia.setEnabled(false);
            txtNombreCanton.setEnabled(false);
            cbxProvinciaCanton.setEnabled(false);
            btnRegistrarCanton.setEnabled(false);
            txtNombreDistrito.setEnabled(false);
            cbxCantonDistrito.setEnabled(false);
            btnRegistrarDistrito.setEnabled(false);
        }else if(rdProvincia.isSelected()){
            txtNombrePais.setEnabled(false);
            btnRegistrarPais.setEnabled(false);
            txtNombreProvincia.setEnabled(true);
            cbxPaisProvincia.setEnabled(true);
            btnRegistrarProvincia.setEnabled(true);
            txtNombreCanton.setEnabled(false);
            cbxProvinciaCanton.setEnabled(false);
            btnRegistrarCanton.setEnabled(false);
            txtNombreDistrito.setEnabled(false);
            cbxCantonDistrito.setEnabled(false);
            btnRegistrarDistrito.setEnabled(false);
        }else if(rdCanton.isSelected()){
            txtNombrePais.setEnabled(false);
            btnRegistrarPais.setEnabled(false);
            txtNombreProvincia.setEnabled(false);
            cbxPaisProvincia.setEnabled(false);
            btnRegistrarProvincia.setEnabled(false);
            txtNombreCanton.setEnabled(true);
            cbxProvinciaCanton.setEnabled(true);
            btnRegistrarCanton.setEnabled(true);
            txtNombreDistrito.setEnabled(false);
            cbxCantonDistrito.setEnabled(false);
            btnRegistrarDistrito.setEnabled(false);
        }else if(rdDistrito.isSelected()){
            txtNombrePais.setEnabled(false);
            btnRegistrarPais.setEnabled(false);
            txtNombreProvincia.setEnabled(false);
            cbxPaisProvincia.setEnabled(false);
            btnRegistrarProvincia.setEnabled(false);
            txtNombreCanton.setEnabled(false);
            cbxProvinciaCanton.setEnabled(false);
            btnRegistrarCanton.setEnabled(false);
            txtNombreDistrito.setEnabled(true);
            cbxCantonDistrito.setEnabled(true);
            btnRegistrarDistrito.setEnabled(true);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        btnRegresar = new javax.swing.JButton();
        lblErrorLugar = new javax.swing.JLabel();
        pnlPais = new javax.swing.JPanel();
        lblNombrePais = new javax.swing.JLabel();
        txtNombrePais = new javax.swing.JTextField();
        btnRegistrarPais = new javax.swing.JButton();
        pnlProvincia = new javax.swing.JPanel();
        lblNombreCanton = new javax.swing.JLabel();
        txtNombreCanton = new javax.swing.JTextField();
        cbxProvinciaCanton = new javax.swing.JComboBox<>();
        btnRegistrarCanton = new javax.swing.JButton();
        pnlDistrito = new javax.swing.JPanel();
        lblNombreDistrito = new javax.swing.JLabel();
        txtNombreDistrito = new javax.swing.JTextField();
        cbxCantonDistrito = new javax.swing.JComboBox<>();
        btnRegistrarDistrito = new javax.swing.JButton();
        rdDistrito = new javax.swing.JRadioButton();
        rdCanton = new javax.swing.JRadioButton();
        rdProvincia = new javax.swing.JRadioButton();
        rdPais = new javax.swing.JRadioButton();
        pnlCanton = new javax.swing.JPanel();
        lblNombreProvincia = new javax.swing.JLabel();
        txtNombreProvincia = new javax.swing.JTextField();
        btnRegistrarProvincia = new javax.swing.JButton();
        cbxPaisProvincia = new javax.swing.JComboBox<>();
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

        pnlPais.setBackground(new java.awt.Color(255, 255, 255));
        pnlPais.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlPais.setOpaque(false);

        lblNombrePais.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombrePais.setForeground(new java.awt.Color(255, 255, 255));
        lblNombrePais.setText("Nombre:");

        txtNombrePais.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

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

        javax.swing.GroupLayout pnlPaisLayout = new javax.swing.GroupLayout(pnlPais);
        pnlPais.setLayout(pnlPaisLayout);
        pnlPaisLayout.setHorizontalGroup(
            pnlPaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaisLayout.createSequentialGroup()
                .addGroup(pnlPaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPaisLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlPaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombrePais, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombrePais)))
                    .addGroup(pnlPaisLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnRegistrarPais)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPaisLayout.setVerticalGroup(
            pnlPaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombrePais)
                .addGap(18, 18, 18)
                .addComponent(txtNombrePais, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnRegistrarPais)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        getContentPane().add(pnlPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 270));

        pnlProvincia.setBackground(new java.awt.Color(255, 255, 255));
        pnlProvincia.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlProvincia.setOpaque(false);

        lblNombreCanton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombreCanton.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreCanton.setText("Nombre:");

        txtNombreCanton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        cbxProvinciaCanton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProvinciaCantonActionPerformed(evt);
            }
        });

        btnRegistrarCanton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistrarCanton.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarCanton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/registrar.png"))); // NOI18N
        btnRegistrarCanton.setText("Registar");
        btnRegistrarCanton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarCanton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarCanton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCantonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProvinciaLayout = new javax.swing.GroupLayout(pnlProvincia);
        pnlProvincia.setLayout(pnlProvinciaLayout);
        pnlProvinciaLayout.setHorizontalGroup(
            pnlProvinciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProvinciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProvinciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxProvinciaCanton, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlProvinciaLayout.createSequentialGroup()
                        .addGroup(pnlProvinciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistrarCanton)
                            .addGroup(pnlProvinciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombreCanton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNombreCanton)))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlProvinciaLayout.setVerticalGroup(
            pnlProvinciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProvinciaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(cbxProvinciaCanton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreCanton)
                .addGap(13, 13, 13)
                .addComponent(txtNombreCanton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarCanton)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(pnlProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, 270));

        pnlDistrito.setBackground(new java.awt.Color(255, 255, 255));
        pnlDistrito.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlDistrito.setOpaque(false);

        lblNombreDistrito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombreDistrito.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreDistrito.setText("Nombre:");

        txtNombreDistrito.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnRegistrarDistrito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistrarDistrito.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarDistrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/registrar.png"))); // NOI18N
        btnRegistrarDistrito.setText("Registar");
        btnRegistrarDistrito.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarDistrito.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDistritoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDistritoLayout = new javax.swing.GroupLayout(pnlDistrito);
        pnlDistrito.setLayout(pnlDistritoLayout);
        pnlDistritoLayout.setHorizontalGroup(
            pnlDistritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDistritoLayout.createSequentialGroup()
                .addGroup(pnlDistritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDistritoLayout.createSequentialGroup()
                        .addGroup(pnlDistritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDistritoLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(pnlDistritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreDistrito)
                                    .addComponent(btnRegistrarDistrito)))
                            .addGroup(pnlDistritoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cbxCantonDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDistritoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtNombreDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlDistritoLayout.setVerticalGroup(
            pnlDistritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDistritoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(cbxCantonDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreDistrito)
                .addGap(18, 18, 18)
                .addComponent(txtNombreDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnRegistrarDistrito)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(pnlDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 150, 270));

        btnGroup.add(rdDistrito);
        rdDistrito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdDistrito.setForeground(new java.awt.Color(255, 255, 255));
        rdDistrito.setText("Distrito");
        rdDistrito.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdDistritoItemStateChanged(evt);
            }
        });
        getContentPane().add(rdDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));

        btnGroup.add(rdCanton);
        rdCanton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdCanton.setForeground(new java.awt.Color(255, 255, 255));
        rdCanton.setText("Cantón");
        rdCanton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdCantonItemStateChanged(evt);
            }
        });
        getContentPane().add(rdCanton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        btnGroup.add(rdProvincia);
        rdProvincia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdProvincia.setForeground(new java.awt.Color(255, 255, 255));
        rdProvincia.setText("Provincia");
        rdProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdProvinciaItemStateChanged(evt);
            }
        });
        getContentPane().add(rdProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        btnGroup.add(rdPais);
        rdPais.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdPais.setForeground(new java.awt.Color(255, 255, 255));
        rdPais.setText("Pais");
        rdPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdPaisItemStateChanged(evt);
            }
        });
        getContentPane().add(rdPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        pnlCanton.setBackground(new java.awt.Color(255, 255, 255));
        pnlCanton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlCanton.setOpaque(false);

        lblNombreProvincia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombreProvincia.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreProvincia.setText("Nombre:");

        txtNombreProvincia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnRegistrarProvincia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistrarProvincia.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarProvincia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/registrar.png"))); // NOI18N
        btnRegistrarProvincia.setText("Registar");
        btnRegistrarProvincia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarProvincia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProvinciaActionPerformed(evt);
            }
        });

        cbxPaisProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPaisProvinciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCantonLayout = new javax.swing.GroupLayout(pnlCanton);
        pnlCanton.setLayout(pnlCantonLayout);
        pnlCantonLayout.setHorizontalGroup(
            pnlCantonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCantonLayout.createSequentialGroup()
                .addGroup(pnlCantonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCantonLayout.createSequentialGroup()
                        .addGroup(pnlCantonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCantonLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnRegistrarProvincia))
                            .addGroup(pnlCantonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtNombreProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(pnlCantonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCantonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCantonLayout.createSequentialGroup()
                                .addComponent(lblNombreProvincia)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbxPaisProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlCantonLayout.setVerticalGroup(
            pnlCantonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCantonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cbxPaisProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombreProvincia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnRegistrarProvincia)
                .addGap(31, 31, 31))
        );

        getContentPane().add(pnlCanton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgRegistros.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        irAFrmRegistro();
    }//GEN-LAST:event_btnRegresarActionPerformed
    private void btnRegistrarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPaisActionPerformed
        registrarPais();
        cargarPaises();
    }//GEN-LAST:event_btnRegistrarPaisActionPerformed
    private void cbxProvinciaCantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvinciaCantonActionPerformed
        //cargarPaises();
//        indexPais = cbxProvinciaCanton.getSelectedIndex();
    }//GEN-LAST:event_cbxProvinciaCantonActionPerformed
    private void btnRegistrarProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarProvinciaActionPerformed
    private void cbxPaisProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPaisProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPaisProvinciaActionPerformed

    private void rdDistritoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdDistritoItemStateChanged
        vistaLugar();
    }//GEN-LAST:event_rdDistritoItemStateChanged
    private void rdCantonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdCantonItemStateChanged
        vistaLugar();
    }//GEN-LAST:event_rdCantonItemStateChanged
    private void rdProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdProvinciaItemStateChanged
        vistaLugar();
    }//GEN-LAST:event_rdProvinciaItemStateChanged
    private void rdPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdPaisItemStateChanged
        vistaLugar();
    }//GEN-LAST:event_rdPaisItemStateChanged

    private void btnRegistrarCantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCantonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarCantonActionPerformed

    private void btnRegistrarDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDistritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarDistritoActionPerformed
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
            java.util.logging.Logger.getLogger(FrmDistrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDistrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDistrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDistrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmDistrito dialog = new FrmDistrito(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnRegistrarCanton;
    private javax.swing.JButton btnRegistrarDistrito;
    private javax.swing.JButton btnRegistrarPais;
    private javax.swing.JButton btnRegistrarProvincia;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxCantonDistrito;
    private javax.swing.JComboBox<Pais> cbxPaisProvincia;
    private javax.swing.JComboBox<String> cbxProvinciaCanton;
    private javax.swing.JLabel lblErrorLugar;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblNombreCanton;
    private javax.swing.JLabel lblNombreDistrito;
    private javax.swing.JLabel lblNombrePais;
    private javax.swing.JLabel lblNombreProvincia;
    private javax.swing.JPanel pnlCanton;
    private javax.swing.JPanel pnlDistrito;
    private javax.swing.JPanel pnlPais;
    private javax.swing.JPanel pnlProvincia;
    private javax.swing.JRadioButton rdCanton;
    private javax.swing.JRadioButton rdDistrito;
    private javax.swing.JRadioButton rdPais;
    private javax.swing.JRadioButton rdProvincia;
    private javax.swing.JTextField txtNombreCanton;
    private javax.swing.JTextField txtNombreDistrito;
    private javax.swing.JTextField txtNombrePais;
    private javax.swing.JTextField txtNombreProvincia;
    // End of variables declaration//GEN-END:variables
}