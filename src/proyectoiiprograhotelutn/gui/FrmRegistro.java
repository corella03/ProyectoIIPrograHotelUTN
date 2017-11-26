/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.gui;
import proyectoiiprograhotelutn.bo.AgenciaDeViajesBO;
import proyectoiiprograhotelutn.bo.PaisBO;
import proyectoiiprograhotelutn.bo.PuestoBO;
import proyectoiiprograhotelutn.bo.TipoHabitacionBO;
import proyectoiiprograhotelutn.entities.AgenciaDeViajes;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Pais;
import proyectoiiprograhotelutn.entities.Puesto;
import proyectoiiprograhotelutn.entities.TipoHabitacion;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 20/11/2017
 **/
public class FrmRegistro extends javax.swing.JFrame {
    /**
     * Creates new form FrmMenuPrincipal
     */
    private Puesto puesto;
    private AgenciaDeViajes agencia;
    private Pais pais;
    public FrmRegistro() {
        initComponents();
        setLocationRelativeTo(null);
        puesto = new Puesto();
        agencia = new AgenciaDeViajes();
        pais = new Pais();
        cargarPaises();
        rdPais.setSelected(true);
        btnSalir.setContentAreaFilled(false);
        btnRegistrarPuesto.setContentAreaFilled(false);
        btnRegistrarAgencia.setContentAreaFilled(false);
        btnRegistrarPais.setContentAreaFilled(false);
        btnRegistrarTipoHabitacion.setContentAreaFilled(false);
        lblPorcentajeComision.setText(sldPorcentajeComisionAgencia.getValue() + "%");
    }
    public void irALogin(){
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
        dispose();
    }
    public void registrarPuesto(){
        lblErrorPuesto.setText("");
        try {
            Puesto nuevoPuesto = new Puesto();
            nuevoPuesto.setId(this.puesto.getId());
            nuevoPuesto.setNombre(txtNombrePuesto.getText().trim().toLowerCase());
            nuevoPuesto.setDescripcion(txtDescripcionPuesto.getText().trim());
            PuestoBO pbo = new PuestoBO();
            if (pbo.registrarPuesto(nuevoPuesto)) {
                lblErrorPuesto.setText("Puesto registrado con éxito.");
            } else {
                lblErrorPuesto.setText("Intente nuevamente.");
            }
        } catch (MiError ex) {
            lblErrorPuesto.setText(ex.getMessage());
        } catch (Exception ex) {
            lblErrorPuesto.setText("Llamar a TI ...xD");
        }
    }
    public void registrarAgencia(){
        lblErrorAgencia.setText("");
        try {
            AgenciaDeViajes nuevaAgencia = new AgenciaDeViajes();
            nuevaAgencia.setId(txtIdAgencia.getText().trim().toLowerCase());
            nuevaAgencia.setNombre(txtNombreAgencia.getText().trim().toLowerCase());
            nuevaAgencia.setComision(sldPorcentajeComisionAgencia.getValue());
            AgenciaDeViajesBO abo = new AgenciaDeViajesBO();
            if (abo.registrarAgencia(nuevaAgencia)) {
                lblErrorAgencia.setText("Agencia registrada con éxito.");
            } else {
                lblErrorAgencia.setText("Intente nuevamente.");
            }
        } catch (MiError ex) {
            lblErrorAgencia.setText(ex.getMessage());
        } catch (Exception ex) {
            lblErrorAgencia.setText("Llamar a TI ...xD");
        }
    }
    public void registrarTipoHabitacio(){
        lblErrorTipoHabitacion.setText("");
        try {
            TipoHabitacion tipoHabitacion = new TipoHabitacion();
            tipoHabitacion.setId(txtIdTipoHabitacion.getText().trim());
            tipoHabitacion.setPrecio(Integer.parseInt(txtPrecioTipoHabitacion.getText().trim().toLowerCase()));
            tipoHabitacion.setDescripcion(txtDescripcionTipoHabitacion.getText().trim());
            TipoHabitacionBO tipobo = new TipoHabitacionBO();
            if (tipobo.registrarTipoHabitacion(tipoHabitacion)) {
                lblErrorTipoHabitacion.setText("Tipo de habitación registrada con éxito.");
            } else {
                lblErrorTipoHabitacion.setText("Intente nuevamente.");
            }
        } catch (MiError ex) {
            lblErrorTipoHabitacion.setText(ex.getMessage());
        } catch (Exception ex) {
            lblErrorTipoHabitacion.setText("Llamar a TI ...xD");
        }
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
        PaisBO paisbo = new PaisBO();
        for (int i = 0; i < paisbo.cargarPaises().size(); i++) {
            cbxProvinca.addItem(paisbo.cargarPaises().get(i).getNombre());
        }
    }
    public void vistaLugar(){
        
        if(rdPais.isSelected()){
            txtNombrePais.setEnabled(true);
            btnRegistrarPais.setEnabled(true);
            txtNombreProvincia.setEnabled(false);
            cbxProvinca.setEnabled(false);
            btnRegistrarProvincia.setEnabled(false);
            txtNombreCanton.setEnabled(false);
            cbxCanton.setEnabled(false);
            btnRegistrarCanton.setEnabled(false);
            txtNombreDistrito.setEnabled(false);
            cbxDistrito.setEnabled(false);
            btnRegistrarDistrito.setVisible(false);
        }else if(rdProvincia.isSelected()){
            txtNombrePais.setEnabled(false);
            btnRegistrarPais.setEnabled(false);
            txtNombreProvincia.setEnabled(true);
            cbxProvinca.setEnabled(true);
            btnRegistrarProvincia.setEnabled(true);
            txtNombreCanton.setEnabled(false);
            cbxCanton.setEnabled(false);
            btnRegistrarCanton.setEnabled(false);
            txtNombreDistrito.setEnabled(false);
            cbxDistrito.setEnabled(false);
            btnRegistrarDistrito.setVisible(false);
        }else if(rdCanton.isSelected()){
            txtNombrePais.setEnabled(false);
            btnRegistrarPais.setEnabled(false);
            txtNombreProvincia.setEnabled(false);
            cbxProvinca.setEnabled(false);
            btnRegistrarProvincia.setEnabled(false);
            txtNombreCanton.setEnabled(true);
            cbxCanton.setEnabled(true);
            btnRegistrarCanton.setEnabled(true);
            txtNombreDistrito.setEnabled(false);
            cbxDistrito.setEnabled(false);
            btnRegistrarDistrito.setVisible(false);
        }else if(rdDistrito.isSelected()){
            txtNombrePais.setEnabled(false);
            btnRegistrarPais.setEnabled(false);
            txtNombreProvincia.setEnabled(false);
            cbxProvinca.setEnabled(false);
            btnRegistrarProvincia.setEnabled(false);
            txtNombreCanton.setEnabled(false);
            cbxCanton.setEnabled(false);
            btnRegistrarCanton.setEnabled(false);
            txtNombreDistrito.setEnabled(true);
            cbxDistrito.setEnabled(true);
            btnRegistrarDistrito.setVisible(true);
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

        btnGroupLugares = new javax.swing.ButtonGroup();
        btnSalir = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlCliente = new javax.swing.JPanel();
        txtNombreCliente = new javax.swing.JTextField();
        txtApellidoCliente = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        lblNombreCliente = new javax.swing.JLabel();
        pnlUsuario = new javax.swing.JPanel();
        pnlHabitaciones = new javax.swing.JPanel();
        pnlPuestos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombrePuesto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcionPuesto = new javax.swing.JTextArea();
        lblErrorPuesto = new javax.swing.JLabel();
        btnRegistrarPuesto = new javax.swing.JButton();
        pnlAgencia = new javax.swing.JPanel();
        lblErrorAgencia = new javax.swing.JLabel();
        lblNombreAgencia = new javax.swing.JLabel();
        txtNombreAgencia = new javax.swing.JTextField();
        lblDescripcionAgencia = new javax.swing.JLabel();
        btnRegistrarAgencia = new javax.swing.JButton();
        sldPorcentajeComisionAgencia = new javax.swing.JSlider();
        lblPorcentajeComision = new javax.swing.JLabel();
        lblIdAgencia = new javax.swing.JLabel();
        txtIdAgencia = new javax.swing.JTextField();
        pnlTipoHabitacion = new javax.swing.JPanel();
        lblIdTipoHabitacion = new javax.swing.JLabel();
        txtIdTipoHabitacion = new javax.swing.JTextField();
        lblErrorTipoHabitacion = new javax.swing.JLabel();
        lblDescripcionTipoHabitacion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionTipoHabitacion = new javax.swing.JTextArea();
        txtPrecioTipoHabitacion = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        btnRegistrarTipoHabitacion = new javax.swing.JButton();
        pnlLugar = new javax.swing.JPanel();
        pnlPais = new javax.swing.JPanel();
        lblNombrePais = new javax.swing.JLabel();
        txtNombrePais = new javax.swing.JTextField();
        btnRegistrarPais = new javax.swing.JButton();
        lblErrorLugar = new javax.swing.JLabel();
        rdPais = new javax.swing.JRadioButton();
        rdProvincia = new javax.swing.JRadioButton();
        rdCanton = new javax.swing.JRadioButton();
        rdDistrito = new javax.swing.JRadioButton();
        pnlDistrito = new javax.swing.JPanel();
        lblNombrePais2 = new javax.swing.JLabel();
        txtNombreDistrito = new javax.swing.JTextField();
        btnRegistrarDistrito = new javax.swing.JButton();
        cbxDistrito = new javax.swing.JComboBox<>();
        pnlProvincia = new javax.swing.JPanel();
        lblNombrePais1 = new javax.swing.JLabel();
        txtNombreProvincia = new javax.swing.JTextField();
        btnRegistrarProvincia = new javax.swing.JButton();
        cbxProvinca = new javax.swing.JComboBox<>();
        pnlCanton = new javax.swing.JPanel();
        lblNombrePais3 = new javax.swing.JLabel();
        txtNombreCanton = new javax.swing.JTextField();
        btnRegistrarCanton = new javax.swing.JButton();
        cbxCanton = new javax.swing.JComboBox<>();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/salir.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 50, 30));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pnlCliente.setBackground(new java.awt.Color(0, 102, 51));
        pnlCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnlCliente.setOpaque(false);

        txtNombreCliente.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        lblNombreCliente.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblNombreCliente.setForeground(new java.awt.Color(0, 153, 153));
        lblNombreCliente.setText("Nombre:");

        javax.swing.GroupLayout pnlClienteLayout = new javax.swing.GroupLayout(pnlCliente);
        pnlCliente.setLayout(pnlClienteLayout);
        pnlClienteLayout.setHorizontalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addComponent(lblNombreCliente)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        pnlClienteLayout.setVerticalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreCliente)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cliente", pnlCliente);

        pnlUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlUsuario.setOpaque(false);

        javax.swing.GroupLayout pnlUsuarioLayout = new javax.swing.GroupLayout(pnlUsuario);
        pnlUsuario.setLayout(pnlUsuarioLayout);
        pnlUsuarioLayout.setHorizontalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );
        pnlUsuarioLayout.setVerticalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Usuario", pnlUsuario);

        pnlHabitaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlHabitaciones.setOpaque(false);

        javax.swing.GroupLayout pnlHabitacionesLayout = new javax.swing.GroupLayout(pnlHabitaciones);
        pnlHabitaciones.setLayout(pnlHabitacionesLayout);
        pnlHabitacionesLayout.setHorizontalGroup(
            pnlHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );
        pnlHabitacionesLayout.setVerticalGroup(
            pnlHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Habitación", pnlHabitaciones);

        pnlPuestos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlPuestos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        pnlPuestos.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Descripción.");

        txtNombrePuesto.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txtDescripcionPuesto.setColumns(20);
        txtDescripcionPuesto.setRows(5);
        jScrollPane1.setViewportView(txtDescripcionPuesto);

        lblErrorPuesto.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblErrorPuesto.setForeground(new java.awt.Color(0, 153, 153));
        lblErrorPuesto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorPuesto.setToolTipText("");

        btnRegistrarPuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/registrar.png"))); // NOI18N
        btnRegistrarPuesto.setText("Registar");
        btnRegistrarPuesto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarPuesto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPuestoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPuestosLayout = new javax.swing.GroupLayout(pnlPuestos);
        pnlPuestos.setLayout(pnlPuestosLayout);
        pnlPuestosLayout.setHorizontalGroup(
            pnlPuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPuestosLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlPuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblErrorPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addGroup(pnlPuestosLayout.createSequentialGroup()
                            .addGroup(pnlPuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(txtNombrePuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrarPuesto))))
                .addGap(130, 130, Short.MAX_VALUE))
        );
        pnlPuestosLayout.setVerticalGroup(
            pnlPuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPuestosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblErrorPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(pnlPuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPuestosLayout.createSequentialGroup()
                        .addComponent(txtNombrePuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRegistrarPuesto))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Puestos", pnlPuestos);

        pnlAgencia.setBackground(new java.awt.Color(255, 255, 255));
        pnlAgencia.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlAgencia.setOpaque(false);

        lblErrorAgencia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblErrorAgencia.setForeground(new java.awt.Color(0, 153, 153));
        lblErrorAgencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorAgencia.setToolTipText("");

        lblNombreAgencia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblNombreAgencia.setForeground(new java.awt.Color(0, 102, 102));
        lblNombreAgencia.setText("Nombre:");

        txtNombreAgencia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        lblDescripcionAgencia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblDescripcionAgencia.setForeground(new java.awt.Color(0, 102, 102));
        lblDescripcionAgencia.setText("Comisión:");

        btnRegistrarAgencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/registrar.png"))); // NOI18N
        btnRegistrarAgencia.setText("Registar");
        btnRegistrarAgencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarAgencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAgenciaActionPerformed(evt);
            }
        });

        sldPorcentajeComisionAgencia.setBackground(new java.awt.Color(0, 102, 102));
        sldPorcentajeComisionAgencia.setForeground(new java.awt.Color(0, 102, 102));
        sldPorcentajeComisionAgencia.setMaximum(25);
        sldPorcentajeComisionAgencia.setPaintLabels(true);
        sldPorcentajeComisionAgencia.setValue(1);
        sldPorcentajeComisionAgencia.setValueIsAdjusting(true);
        sldPorcentajeComisionAgencia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldPorcentajeComisionAgenciaStateChanged(evt);
            }
        });

        lblPorcentajeComision.setBackground(new java.awt.Color(0, 102, 102));
        lblPorcentajeComision.setForeground(new java.awt.Color(0, 102, 102));
        lblPorcentajeComision.setText("%");

        lblIdAgencia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblIdAgencia.setForeground(new java.awt.Color(0, 102, 102));
        lblIdAgencia.setText("Id:");

        txtIdAgencia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout pnlAgenciaLayout = new javax.swing.GroupLayout(pnlAgencia);
        pnlAgencia.setLayout(pnlAgenciaLayout);
        pnlAgenciaLayout.setHorizontalGroup(
            pnlAgenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgenciaLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlAgenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAgenciaLayout.createSequentialGroup()
                        .addGroup(pnlAgenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreAgencia)
                            .addGroup(pnlAgenciaLayout.createSequentialGroup()
                                .addComponent(sldPorcentajeComisionAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPorcentajeComision, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAgenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pnlAgenciaLayout.createSequentialGroup()
                                    .addGroup(pnlAgenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDescripcionAgencia)
                                        .addComponent(txtNombreAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtIdAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(42, 42, 42))
                                .addGroup(pnlAgenciaLayout.createSequentialGroup()
                                    .addComponent(lblIdAgencia)
                                    .addGap(243, 243, 243))))
                        .addGap(167, 167, 167)
                        .addComponent(btnRegistrarAgencia)))
                .addGap(58, 105, Short.MAX_VALUE))
        );
        pnlAgenciaLayout.setVerticalGroup(
            pnlAgenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblErrorAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlAgenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgenciaLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btnRegistrarAgencia))
                    .addGroup(pnlAgenciaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIdAgencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreAgencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDescripcionAgencia)
                        .addGap(23, 23, 23)
                        .addGroup(pnlAgenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPorcentajeComision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sldPorcentajeComisionAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agencia de Viajes", pnlAgencia);

        pnlTipoHabitacion.setBackground(new java.awt.Color(255, 255, 255));
        pnlTipoHabitacion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlTipoHabitacion.setOpaque(false);

        lblIdTipoHabitacion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblIdTipoHabitacion.setForeground(new java.awt.Color(0, 102, 102));
        lblIdTipoHabitacion.setText("Id:");

        txtIdTipoHabitacion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        lblErrorTipoHabitacion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblErrorTipoHabitacion.setForeground(new java.awt.Color(0, 153, 153));
        lblErrorTipoHabitacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorTipoHabitacion.setToolTipText("");

        lblDescripcionTipoHabitacion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblDescripcionTipoHabitacion.setForeground(new java.awt.Color(0, 153, 153));
        lblDescripcionTipoHabitacion.setText("Descripción.");

        txtDescripcionTipoHabitacion.setColumns(20);
        txtDescripcionTipoHabitacion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcionTipoHabitacion);

        txtPrecioTipoHabitacion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        lblPrecio.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(0, 102, 102));
        lblPrecio.setText("Precio:");

        btnRegistrarTipoHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/registrar.png"))); // NOI18N
        btnRegistrarTipoHabitacion.setText("Registar");
        btnRegistrarTipoHabitacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarTipoHabitacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarTipoHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarTipoHabitacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTipoHabitacionLayout = new javax.swing.GroupLayout(pnlTipoHabitacion);
        pnlTipoHabitacion.setLayout(pnlTipoHabitacionLayout);
        pnlTipoHabitacionLayout.setHorizontalGroup(
            pnlTipoHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTipoHabitacionLayout.createSequentialGroup()
                .addGroup(pnlTipoHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlTipoHabitacionLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(lblErrorTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTipoHabitacionLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(pnlTipoHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcionTipoHabitacion)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlTipoHabitacionLayout.createSequentialGroup()
                                .addGroup(pnlTipoHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtIdTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlTipoHabitacionLayout.createSequentialGroup()
                                        .addComponent(lblIdTipoHabitacion)
                                        .addGap(201, 201, 201)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrarTipoHabitacion)
                                .addGap(31, 31, 31))))
                    .addGroup(pnlTipoHabitacionLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(pnlTipoHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecio)
                            .addComponent(txtPrecioTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        pnlTipoHabitacionLayout.setVerticalGroup(
            pnlTipoHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTipoHabitacionLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblErrorTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIdTipoHabitacion)
                .addGroup(pnlTipoHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTipoHabitacionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lblPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecioTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTipoHabitacionLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnRegistrarTipoHabitacion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescripcionTipoHabitacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tipo Habitación", pnlTipoHabitacion);

        pnlLugar.setBackground(new java.awt.Color(255, 255, 255));
        pnlLugar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlLugar.setOpaque(false);

        pnlPais.setBackground(new java.awt.Color(255, 255, 255));
        pnlPais.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlPais.setOpaque(false);

        lblNombrePais.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblNombrePais.setForeground(new java.awt.Color(0, 102, 102));
        lblNombrePais.setText("Nombre:");

        txtNombrePais.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

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
                        .addGap(22, 22, 22)
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
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarPais)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblErrorLugar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblErrorLugar.setForeground(new java.awt.Color(0, 153, 153));
        lblErrorLugar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorLugar.setToolTipText("");

        btnGroupLugares.add(rdPais);
        rdPais.setForeground(new java.awt.Color(255, 255, 255));
        rdPais.setText("Pais");
        rdPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdPaisItemStateChanged(evt);
            }
        });

        btnGroupLugares.add(rdProvincia);
        rdProvincia.setText("Provincia");
        rdProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdProvinciaItemStateChanged(evt);
            }
        });

        btnGroupLugares.add(rdCanton);
        rdCanton.setText("Cantón");
        rdCanton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdCantonItemStateChanged(evt);
            }
        });

        btnGroupLugares.add(rdDistrito);
        rdDistrito.setText("Distrito");
        rdDistrito.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdDistritoItemStateChanged(evt);
            }
        });

        pnlDistrito.setBackground(new java.awt.Color(255, 255, 255));
        pnlDistrito.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlDistrito.setOpaque(false);

        lblNombrePais2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblNombrePais2.setForeground(new java.awt.Color(0, 102, 102));
        lblNombrePais2.setText("Nombre:");

        txtNombreDistrito.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnRegistrarDistrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/registrar.png"))); // NOI18N
        btnRegistrarDistrito.setText("Registar");
        btnRegistrarDistrito.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarDistrito.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDistritoActionPerformed(evt);
            }
        });

        cbxDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlDistritoLayout = new javax.swing.GroupLayout(pnlDistrito);
        pnlDistrito.setLayout(pnlDistritoLayout);
        pnlDistritoLayout.setHorizontalGroup(
            pnlDistritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDistritoLayout.createSequentialGroup()
                .addGroup(pnlDistritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDistritoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNombreDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNombrePais2)
                    .addGroup(pnlDistritoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDistritoLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnRegistrarDistrito)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlDistritoLayout.setVerticalGroup(
            pnlDistritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDistritoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombrePais2)
                .addGap(18, 18, 18)
                .addComponent(txtNombreDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarDistrito)
                .addGap(31, 31, 31))
        );

        pnlProvincia.setBackground(new java.awt.Color(255, 255, 255));
        pnlProvincia.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlProvincia.setOpaque(false);

        lblNombrePais1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblNombrePais1.setForeground(new java.awt.Color(0, 102, 102));
        lblNombrePais1.setText("Nombre:");

        txtNombreProvincia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnRegistrarProvincia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/registrar.png"))); // NOI18N
        btnRegistrarProvincia.setText("Registar");
        btnRegistrarProvincia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarProvincia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProvinciaActionPerformed(evt);
            }
        });

        cbxProvinca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProvincaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProvinciaLayout = new javax.swing.GroupLayout(pnlProvincia);
        pnlProvincia.setLayout(pnlProvinciaLayout);
        pnlProvinciaLayout.setHorizontalGroup(
            pnlProvinciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProvinciaLayout.createSequentialGroup()
                .addGroup(pnlProvinciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProvinciaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlProvinciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombrePais1)))
                    .addGroup(pnlProvinciaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnRegistrarProvincia))
                    .addGroup(pnlProvinciaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxProvinca, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnlProvinciaLayout.setVerticalGroup(
            pnlProvinciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProvinciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombrePais1)
                .addGap(18, 18, 18)
                .addComponent(txtNombreProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxProvinca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnRegistrarProvincia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCanton.setBackground(new java.awt.Color(255, 255, 255));
        pnlCanton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlCanton.setOpaque(false);

        lblNombrePais3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblNombrePais3.setForeground(new java.awt.Color(0, 102, 102));
        lblNombrePais3.setText("Nombre:");

        txtNombreCanton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnRegistrarCanton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/registrar.png"))); // NOI18N
        btnRegistrarCanton.setText("Registar");
        btnRegistrarCanton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarCanton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarCanton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCantonActionPerformed(evt);
            }
        });

        cbxCanton.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlCantonLayout = new javax.swing.GroupLayout(pnlCanton);
        pnlCanton.setLayout(pnlCantonLayout);
        pnlCantonLayout.setHorizontalGroup(
            pnlCantonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCantonLayout.createSequentialGroup()
                .addGroup(pnlCantonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCantonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCantonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreCanton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombrePais3)))
                    .addGroup(pnlCantonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxCanton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCantonLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnRegistrarCanton)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlCantonLayout.setVerticalGroup(
            pnlCantonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCantonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombrePais3)
                .addGap(18, 18, 18)
                .addComponent(txtNombreCanton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(cbxCanton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarCanton)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout pnlLugarLayout = new javax.swing.GroupLayout(pnlLugar);
        pnlLugar.setLayout(pnlLugarLayout);
        pnlLugarLayout.setHorizontalGroup(
            pnlLugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLugarLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(lblErrorLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlLugarLayout.createSequentialGroup()
                .addGroup(pnlLugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLugarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLugarLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(rdPais)))
                .addGroup(pnlLugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlLugarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlCanton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLugarLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(rdProvincia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdCanton)
                        .addGap(42, 42, 42)))
                .addGroup(pnlLugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLugarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLugarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdDistrito)
                        .addGap(86, 86, 86))))
        );
        pnlLugarLayout.setVerticalGroup(
            pnlLugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLugarLayout.createSequentialGroup()
                .addComponent(lblErrorLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(pnlLugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdPais)
                    .addComponent(rdProvincia)
                    .addComponent(rdCanton)
                    .addComponent(rdDistrito))
                .addGap(18, 18, 18)
                .addGroup(pnlLugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCanton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDistrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lugar", pnlLugar);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 670, 370));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoiiprograhotelutn/img/imgRegistro.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 790, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        irALogin();
    }//GEN-LAST:event_btnSalirActionPerformed
    private void btnRegistrarPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPuestoActionPerformed
        registrarPuesto();
    }//GEN-LAST:event_btnRegistrarPuestoActionPerformed
    private void btnRegistrarAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAgenciaActionPerformed
        registrarAgencia();
    }//GEN-LAST:event_btnRegistrarAgenciaActionPerformed
    private void sldPorcentajeComisionAgenciaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldPorcentajeComisionAgenciaStateChanged
       lblPorcentajeComision.setText(sldPorcentajeComisionAgencia.getValue() + "%");
    }//GEN-LAST:event_sldPorcentajeComisionAgenciaStateChanged
    private void btnRegistrarTipoHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarTipoHabitacionActionPerformed
        registrarTipoHabitacio();
    }//GEN-LAST:event_btnRegistrarTipoHabitacionActionPerformed
    private void btnRegistrarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPaisActionPerformed
        registrarPais();
    }//GEN-LAST:event_btnRegistrarPaisActionPerformed
    private void btnRegistrarProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarProvinciaActionPerformed
    private void btnRegistrarDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDistritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarDistritoActionPerformed
    private void btnRegistrarCantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCantonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarCantonActionPerformed
    private void rdPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdPaisItemStateChanged
        vistaLugar();
    }//GEN-LAST:event_rdPaisItemStateChanged
    private void rdDistritoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdDistritoItemStateChanged
        vistaLugar();
    }//GEN-LAST:event_rdDistritoItemStateChanged
    private void rdProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdProvinciaItemStateChanged
        vistaLugar();
    }//GEN-LAST:event_rdProvinciaItemStateChanged
    private void rdCantonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdCantonItemStateChanged
        vistaLugar();
    }//GEN-LAST:event_rdCantonItemStateChanged

    private void cbxProvincaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvincaActionPerformed
        int x;
        x = cbxProvinca.getSelectedIndex();
            System.out.println(x);
    }//GEN-LAST:event_cbxProvincaActionPerformed
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
    private javax.swing.ButtonGroup btnGroupLugares;
    private javax.swing.JButton btnRegistrarAgencia;
    private javax.swing.JButton btnRegistrarCanton;
    private javax.swing.JButton btnRegistrarDistrito;
    private javax.swing.JButton btnRegistrarPais;
    private javax.swing.JButton btnRegistrarProvincia;
    private javax.swing.JButton btnRegistrarPuesto;
    private javax.swing.JButton btnRegistrarTipoHabitacion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxCanton;
    private javax.swing.JComboBox<String> cbxDistrito;
    private javax.swing.JComboBox<String> cbxProvinca;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDescripcionAgencia;
    private javax.swing.JLabel lblDescripcionTipoHabitacion;
    private javax.swing.JLabel lblErrorAgencia;
    private javax.swing.JLabel lblErrorLugar;
    private javax.swing.JLabel lblErrorPuesto;
    private javax.swing.JLabel lblErrorTipoHabitacion;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIdAgencia;
    private javax.swing.JLabel lblIdTipoHabitacion;
    private javax.swing.JLabel lblNombreAgencia;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNombrePais;
    private javax.swing.JLabel lblNombrePais1;
    private javax.swing.JLabel lblNombrePais2;
    private javax.swing.JLabel lblNombrePais3;
    private javax.swing.JLabel lblPorcentajeComision;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JPanel pnlAgencia;
    private javax.swing.JPanel pnlCanton;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JPanel pnlDistrito;
    private javax.swing.JPanel pnlHabitaciones;
    private javax.swing.JPanel pnlLugar;
    private javax.swing.JPanel pnlPais;
    private javax.swing.JPanel pnlProvincia;
    private javax.swing.JPanel pnlPuestos;
    private javax.swing.JPanel pnlTipoHabitacion;
    private javax.swing.JPanel pnlUsuario;
    private javax.swing.JRadioButton rdCanton;
    private javax.swing.JRadioButton rdDistrito;
    private javax.swing.JRadioButton rdPais;
    private javax.swing.JRadioButton rdProvincia;
    private javax.swing.JSlider sldPorcentajeComisionAgencia;
    private javax.swing.JTextField txtApellidoCliente;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextArea txtDescripcionPuesto;
    private javax.swing.JTextArea txtDescripcionTipoHabitacion;
    private javax.swing.JTextField txtIdAgencia;
    private javax.swing.JTextField txtIdTipoHabitacion;
    private javax.swing.JTextField txtNombreAgencia;
    private javax.swing.JTextField txtNombreCanton;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreDistrito;
    private javax.swing.JTextField txtNombrePais;
    private javax.swing.JTextField txtNombreProvincia;
    private javax.swing.JTextField txtNombrePuesto;
    private javax.swing.JTextField txtPrecioTipoHabitacion;
    // End of variables declaration//GEN-END:variables
}