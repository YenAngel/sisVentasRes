
package ventas.presentacion.Categoria;

import javax.swing.BorderFactory;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Categoria;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpListarCategoria extends javax.swing.JPanel {
    
    DefaultTableModel dtm;
    Categoria categoria =new Categoria();
    Login_User login_User=new Login_User();
    DefaultComboBoxModel dcbm;
    private boolean edit;
    private boolean newer;    
    public jpListarCategoria() {
        initComponents();
        addItems();
        cboNivel1.setEnabled(false);
        cboNivel2.setEnabled(false);
        cboNivel3.setEnabled(false);
        cboPadreCategoria2.setSelectedIndex(-1);
        cboPadreCategoria3.setSelectedIndex(-1);
        cboCategoria3.setSelectedIndex(-1);
        tblCategoria.setModel(BDData.listarCategoria(formatearTabla(), 1));        
        txtNombre1.setEnabled(false);               
        txtNombre2.setEnabled(false);
        cboPadreCategoria2.setEnabled(false);                
        txtNombre3.setEnabled(false);
        cboCategoria3.setEnabled(false);
        cboPadreCategoria3.setEnabled(false);
        confTBL(tblCategoria,dtm);
    }
    
    private void cleanControls(){
        if (edit) {
            txtNombre1.setText("");
        }else if (tplCategoria.getSelectedIndex()==1) {
            txtNombre2.setText("");
            cboPadreCategoria2.setSelectedIndex(-1);
        }else if (tplCategoria.getSelectedIndex()==2) {
            txtNombre3.setText("");
            cboCategoria3.setSelectedIndex(-1);
            cboPadreCategoria3.setSelectedIndex(-1);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tplCategoria = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtNombre1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboNivel1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        cboNivel2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboPadreCategoria2 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        txtNombre3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboPadreCategoria3 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cboNivel3 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cboCategoria3 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtCategoria = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblTotal1 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setPreferredSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tplCategoria.setMaximumSize(new java.awt.Dimension(341, 100));
        tplCategoria.setMinimumSize(new java.awt.Dimension(341, 100));
        tplCategoria.setPreferredSize(new java.awt.Dimension(500, 340));
        tplCategoria.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tplCategoriaStateChanged(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre1KeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 35, 260, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre de Categoria:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 51, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nivel:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 120, -1, -1));

        cboNivel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboNivel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Superior", "Intermedio", "Inferior" }));
        jPanel1.add(cboNivel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 103, 260, 50));

        tplCategoria.addTab("Categoría 1", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboNivel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboNivel2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Intermedio" }));
        jPanel2.add(cboNivel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 166, 260, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nivel:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 183, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nombre de Categoria:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 114, -1, -1));

        txtNombre2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre2ActionPerformed(evt);
            }
        });
        txtNombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre2KeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 98, 260, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Categoria 1:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 47, -1, -1));

        cboPadreCategoria2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(cboPadreCategoria2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 260, 50));

        tplCategoria.addTab("Categoría 2", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombre3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre3KeyTyped(evt);
            }
        });
        jPanel3.add(txtNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 260, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nombre de Categoria:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        cboPadreCategoria3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboPadreCategoria3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPadreCategoria3ItemStateChanged(evt);
            }
        });
        jPanel3.add(cboPadreCategoria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 260, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Categoria 1:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        cboNivel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboNivel3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inferior" }));
        jPanel3.add(cboNivel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 260, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Nivel:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        cboCategoria3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboCategoria3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCategoria3ItemStateChanged(evt);
            }
        });
        jPanel3.add(cboCategoria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 260, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Categoria 2:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        tplCategoria.addTab("Categoría 3", jPanel3);

        add(tplCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 500, 310));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCategoria.setAlignmentX(341.0F);
        tblCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategoria);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 500, 120));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));

        jLabel22.setBackground(new java.awt.Color(153, 153, 153));
        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Total de registros:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 630, 181, 30));

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel5.setForeground(new java.awt.Color(204, 204, 204));

        jLabel23.setBackground(new java.awt.Color(153, 153, 153));
        jLabel23.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Listado");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 100, 30));

        jPanel6.setBackground(new java.awt.Color(248, 248, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setForeground(new java.awt.Color(204, 204, 204));
        jPanel6.setEnabled(false);

        txtCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCategoriaKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Categoria:");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search_2.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 500, 80));

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel7.setForeground(new java.awt.Color(204, 204, 204));

        jLabel24.setBackground(new java.awt.Color(153, 153, 153));
        jLabel24.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Busqueda");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, -1, 30));

        jPanel8.setBackground(new java.awt.Color(248, 248, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel8.setForeground(new java.awt.Color(204, 204, 204));

        lblTotal1.setBackground(new java.awt.Color(153, 153, 153));
        lblTotal1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblTotal1.setForeground(new java.awt.Color(51, 51, 51));
        lblTotal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotal1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(lblTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 630, 101, 30));

        btnNew.setBackground(new java.awt.Color(153, 153, 255));
        btnNew.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/new.png"))); // NOI18N
        btnNew.setText("   Nuevo     ");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 170, 68));

        btnEditar.setBackground(new java.awt.Color(153, 153, 255));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit_user.png"))); // NOI18N
        btnEditar.setText("  Modificar ");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 170, 68));

        btnEliminar.setBackground(new java.awt.Color(153, 153, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N
        btnEliminar.setText("  Eliminar  ");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 170, 68));

        btnSave.setBackground(new java.awt.Color(153, 153, 255));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 170, 68));

        btnReturn.setBackground(new java.awt.Color(153, 153, 255));
        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo.png"))); // NOI18N
        btnReturn.setText("Cancelar");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 170, 68));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel16.setText("MANTENIMIENTO CATEGORÍA");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, 38));
    }// </editor-fold>//GEN-END:initComponents
    private void addItems(){
        cboPadreCategoria2.setModel(BDData.getCategoria1());
        cboPadreCategoria3.setModel(BDData.getCategoria1());        
    }
    private DefaultTableModel formatearTabla(){
        if (tplCategoria.getSelectedIndex()==2) {
            String[] theader={"Id Categoria","Categoria Superior","Categoria Intermedia","Categoria"};
            dtm = new DefaultTableModel();
            dtm.setColumnIdentifiers(theader);        
            return  dtm;
        }else{
            String[] theader={"Id Categoria","Categoria Superior","Categoria"};
            dtm = new DefaultTableModel();
            dtm.setColumnIdentifiers(theader);        
            return  dtm;
        }        
    }

    public void confTBL(JTable jTable, DefaultTableModel model){
	DefaultTableCellRenderer centerRdr= new DefaultTableCellRenderer();
        centerRdr.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0;i<model.getColumnCount();i++){
            jTable.getColumnModel().getColumn(i).setCellRenderer(centerRdr);	
        }        
        
        int idx=tplCategoria.getSelectedIndex();
        if (idx==0) {
            jTable.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable.getColumnModel().getColumn(0).setMinWidth(0);
            jTable.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            jTable.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            jTable.getColumnModel().getColumn(1).setMaxWidth(0);
            jTable.getColumnModel().getColumn(1).setMinWidth(0);
            jTable.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
            jTable.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        }else{         
            jTable.getColumnModel().getColumn(0).setMaxWidth(0);            
            jTable.getColumnModel().getColumn(0).setMinWidth(0);            
            jTable.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            jTable.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        }        
        for(int i=0;i<model.getRowCount();i++)
            jTable.setRowHeight(i,45);        
        jTable.setDefaultEditor(Object.class,null);
        jTable.getTableHeader().setReorderingAllowed(false);
        lblTotal1.setText(model.getRowCount()+"");
        //jTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        //jTable.getColumnModel().getColumn(0).setResizable(false);        
    }
    private void txtNombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyTyped
        char c=evt.getKeyChar();
        if(Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo debe ingresar Letras");
        }
    }//GEN-LAST:event_txtNombre1KeyTyped

    private void txtNombre2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre2KeyTyped
        char c=evt.getKeyChar();

        if(Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");
        }
    }//GEN-LAST:event_txtNombre2KeyTyped

    private void txtNombre3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre3KeyTyped
        char c=evt.getKeyChar();

        if(Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");
        }
    }//GEN-LAST:event_txtNombre3KeyTyped

    private void txtNombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre2ActionPerformed

    private void txtCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaKeyTyped
        char c=evt.getKeyChar();

        if(Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");
        }
    }//GEN-LAST:event_txtCategoriaKeyTyped

    private void cboCategoria3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCategoria3ItemStateChanged
        
    }//GEN-LAST:event_cboCategoria3ItemStateChanged

    private void cboPadreCategoria3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPadreCategoria3ItemStateChanged
        if (cboPadreCategoria3.getSelectedIndex()!=-1) {
            cboCategoria3.setModel(BDData.getCategoria2(cboPadreCategoria3.getSelectedItem().toString()));
            cboCategoria3.setSelectedIndex(-1);
        }        
    }//GEN-LAST:event_cboPadreCategoria3ItemStateChanged

    private void tplCategoriaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tplCategoriaStateChanged
        int idx= tplCategoria.getSelectedIndex();
        if (idx!=-1) {                     
            tblCategoria.setModel(BDData.listarCategoria(formatearTabla(), idx+1));
            confTBL(tblCategoria,dtm);
        }        
    }//GEN-LAST:event_tplCategoriaStateChanged

    
    private void tblCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriaMouseClicked
        int idx=tplCategoria.getSelectedIndex();
        int index=tblCategoria.getSelectedRow();
        if (idx==0 && index!=-1) {                             
            txtNombre1.setText(dtm.getValueAt(index, 2).toString());            
        }else if (idx==1 && index!=-1) {
            cboPadreCategoria2.setSelectedItem(dtm.getValueAt(index, 1).toString());
            txtNombre2.setText(dtm.getValueAt(index, 2).toString());           
            
        }else if (idx==2 && index!=-1) {
            cboPadreCategoria3.setEnabled(false);
            cboPadreCategoria3.setSelectedItem(dtm.getValueAt(index, 1).toString());
            cboCategoria3.setSelectedItem(dtm.getValueAt(index, 2).toString());
            txtNombre3.setText(dtm.getValueAt(index, 3).toString());
        }
    }//GEN-LAST:event_tblCategoriaMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        edit=false;        
        Timer t= new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {
                newer=true;                
                if (tplCategoria.getSelectedIndex()==0) {
                    txtNombre1.setEnabled(true);
                    txtNombre1.setText("");
                }else if (tplCategoria.getSelectedIndex()==1) {
                    txtNombre2.setEnabled(true);
                    txtNombre2.setText("");
                    cboPadreCategoria2.setEnabled(true);
                    cboPadreCategoria2.setSelectedIndex(-1);
                }else if (tplCategoria.getSelectedIndex()==2) {
                    txtNombre3.setEnabled(true);
                    txtNombre3.setText("");
                    cboCategoria3.setEnabled(true);
                    cboCategoria3.setSelectedIndex(-1);
                    cboPadreCategoria3.setEnabled(true);
                    cboPadreCategoria3.setSelectedIndex(-1);
                }
            }
        };
        t.schedule(task, 3000);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        newer=false;
        Timer t= new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {
                if (tplCategoria.getSelectedIndex()==0) {
                    txtNombre1.setEnabled(true);
                }else if (tplCategoria.getSelectedIndex()==1) {
                    cboPadreCategoria2.setEnabled(true);
                    txtNombre2.setEnabled(true);
                }else if (tplCategoria.getSelectedIndex()==2) {
                    cboCategoria3.setEnabled(true);
                    txtNombre3.setEnabled(true);
                }               
                edit=true;
            }
        };
        t.schedule(task, 1000);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int idx=tblCategoria.getSelectedRow();
        if (idx!=-1) {            
            int value = JOptionPane.showConfirmDialog(null, "Desea eliminar registro","Warning",JOptionPane.YES_NO_OPTION);            
            if(value == 0){
                categoria.setNid_categoria_plato(Integer.parseInt(dtm.getValueAt(tblCategoria.getSelectedRow(), 0).toString()));
                categoria.setNid_usuario_modi(login_User.getNdi_usuario());
                if (BDData.eliminarCategoria(categoria)) {            
                    tblCategoria.setModel(BDData.listarCategoria(formatearTabla(), tplCategoria.getSelectedIndex()+1));
                    confTBL(tblCategoria,dtm);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccionar el registro a eliminar");
        }        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Timer t= new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {
                int idx =tplCategoria.getSelectedIndex();
                int index=tblCategoria.getSelectedRow();
                if (newer) {
                    if (idx==0) {
                        categoria.setNo_categoria_plato(txtNombre1.getText());
                        categoria.setNu_nivel(1);
                        categoria.setNid_usuario_crea(login_User.getNdi_usuario());
                        categoria.setVi_tipo(2);
                        if (BDData.nuevoCategoria(categoria)) {                    
                            addItems();                        
                        }
                    }else if (idx==1) {
                        categoria.setNo_padre_categoria(cboPadreCategoria2.getSelectedItem().toString());
                        categoria.setNo_categoria_plato(txtNombre2.getText());
                        categoria.setNid_usuario_crea(login_User.getNdi_usuario());
                        categoria.setNu_nivel(2);
                        categoria.setVi_tipo(1);
                        if (BDData.nuevoCategoria(categoria)) {                        
                            addItems();                        
                        }
                    }else if (idx==2) {
                        categoria.setNo_padre_categoria(cboCategoria3.getSelectedItem().toString());
                        categoria.setNo_categoria_plato(txtNombre3.getText());
                        categoria.setNid_usuario_crea(login_User.getNdi_usuario());
                        categoria.setNu_nivel(3);
                        categoria.setVi_tipo(1);
                        if (BDData.nuevoCategoria(categoria)) {                        
                            addItems();
                        }
                    }
                }
                if (edit) {
                    if (idx==0) { 
                        if (index!=-1) {            
                            categoria.setNid_categoria_plato(Integer.parseInt(dtm.getValueAt(index, 0).toString()));
                            categoria.setNo_categoria_plato(txtNombre1.getText());
                            categoria.setNu_nivel(1);
                            categoria.setNid_usuario_modi(login_User.getNdi_usuario());
                            categoria.setVi_tipo(2);
                            if (BDData.editarCategoria(categoria)) {                    
                                addItems();                        
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Seleccionar el registro a eliminar");
                        }                        
                    }else if (idx==1) {
                        if (index!=-1) {            
                            categoria.setNid_categoria_plato(Integer.parseInt(dtm.getValueAt(index, 0).toString()));
                            categoria.setNo_padre_categoria(cboPadreCategoria2.getSelectedItem().toString());
                            categoria.setNo_categoria_plato(txtNombre2.getText());
                            categoria.setNid_usuario_modi(login_User.getNdi_usuario());
                            categoria.setNu_nivel(2);
                            categoria.setVi_tipo(1);
                            if (BDData.editarCategoria(categoria)) {                        
                                addItems();                        
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Seleccionar el registro a eliminar");
                        }                        
                    }else if (idx==2) {                                        
                        if (index!=-1) {            
                            categoria.setNid_categoria_plato(Integer.parseInt(dtm.getValueAt(index, 0).toString()));
                            categoria.setNo_padre_categoria(cboCategoria3.getSelectedItem().toString());
                            categoria.setNo_categoria_plato(txtNombre3.getText());
                            categoria.setNid_usuario_modi(login_User.getNdi_usuario());
                            categoria.setNu_nivel(3);
                            categoria.setVi_tipo(1);
                            if (BDData.editarCategoria(categoria)) {                        
                                addItems();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Seleccionar el registro a eliminar");
                        }                        
                    }
                }                
                tblCategoria.setModel(BDData.listarCategoria(formatearTabla(), idx+1));
                confTBL(tblCategoria,dtm);
                cleanControls();
                edit=false;
                newer=false;
            }            
        };
        t.schedule(task, 1000);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed

    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtCategoria.getText().equals("")) {
            int idx= tplCategoria.getSelectedIndex();
            if (idx!=-1) {                     
                tblCategoria.setModel(BDData.listarCategoria(formatearTabla(), idx+1));
            }
        }else{
            if (tplCategoria.getSelectedIndex()==0) {
                categoria.setNo_categoria_plato(txtCategoria.getText());
                categoria.setVi_tipo(1);
                txtCategoria.setText("");
            }else if (tplCategoria.getSelectedIndex()==1) {
                categoria.setNo_categoria_plato(txtCategoria.getText());
                categoria.setVi_tipo(2);
                txtCategoria.setText("");
            }else if (tplCategoria.getSelectedIndex()==2) {
                categoria.setNo_categoria_plato(txtCategoria.getText());
                categoria.setVi_tipo(3);
                txtCategoria.setText("");
            }
            tblCategoria.setModel(BDData.obtenerCategoria(formatearTabla(), categoria));
        }
        confTBL(tblCategoria,dtm);
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboCategoria3;
    private javax.swing.JComboBox<String> cboNivel1;
    private javax.swing.JComboBox<String> cboNivel2;
    private javax.swing.JComboBox<String> cboNivel3;
    private javax.swing.JComboBox<String> cboPadreCategoria2;
    private javax.swing.JComboBox<String> cboPadreCategoria3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal1;
    private javax.swing.JTable tblCategoria;
    private javax.swing.JTabbedPane tplCategoria;
    public static javax.swing.JTextField txtCategoria;
    public javax.swing.JTextField txtNombre1;
    public javax.swing.JTextField txtNombre2;
    public javax.swing.JTextField txtNombre3;
    // End of variables declaration//GEN-END:variables
}
