
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
    DefaultComboBoxModel dcbm;
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
        confTBL(tblCategoria);        
    }
    
    private void cleanControls(){
        txtNombre1.setText("");
        cboNivel1.setSelectedIndex(-1);
        cboPadreCategoria2.setSelectedIndex(-1);
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
        txtCategoria = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        opNuevo = new javax.swing.JLabel();
        opEditar = new javax.swing.JLabel();
        opEliminar = new javax.swing.JLabel();
        opBuscar = new javax.swing.JLabel();
        opGuardar = new javax.swing.JLabel();

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
        jPanel3.add(txtNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 162, 260, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nombre de Categoria:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 178, -1, -1));

        cboPadreCategoria3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboPadreCategoria3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPadreCategoria3ItemStateChanged(evt);
            }
        });
        jPanel3.add(cboPadreCategoria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 26, 260, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Categoria 1:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 43, -1, -1));

        cboNivel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboNivel3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inferior" }));
        jPanel3.add(cboNivel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 230, 260, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Nivel:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 247, -1, -1));

        cboCategoria3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboCategoria3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCategoria3ItemStateChanged(evt);
            }
        });
        jPanel3.add(cboCategoria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 94, 260, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Categoria 2:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 111, -1, -1));

        tplCategoria.addTab("Categoría 3", jPanel3);

        add(tplCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

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
        jScrollPane1.setViewportView(tblCategoria);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 463, 500, 170));

        txtCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCategoriaKeyTyped(evt);
            }
        });
        add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 260, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Categoria:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));

        opNuevo.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        opNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/adder.png"))); // NOI18N
        opNuevo.setText("Nuevo");
        opNuevo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 10, new java.awt.Color(24, 168, 255)));
        opNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        opNuevo.setMaximumSize(new java.awt.Dimension(80, 132));
        opNuevo.setMinimumSize(new java.awt.Dimension(80, 132));
        opNuevo.setPreferredSize(new java.awt.Dimension(80, 132));
        opNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        opNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opNuevoMouseClicked(evt);
            }
        });
        add(opNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 80, 132));

        opEditar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        opEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit.png"))); // NOI18N
        opEditar.setText("Editar");
        opEditar.setAlignmentY(0.0F);
        opEditar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 10, new java.awt.Color(24, 168, 255)));
        opEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        opEditar.setMaximumSize(new java.awt.Dimension(80, 132));
        opEditar.setMinimumSize(new java.awt.Dimension(80, 132));
        opEditar.setPreferredSize(new java.awt.Dimension(80, 132));
        opEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        opEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opEditarMouseClicked(evt);
            }
        });
        add(opEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 132));

        opEliminar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        opEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N
        opEliminar.setText("Quitar");
        opEliminar.setAlignmentY(0.0F);
        opEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 10, new java.awt.Color(24, 168, 255)));
        opEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        opEliminar.setMaximumSize(new java.awt.Dimension(80, 132));
        opEliminar.setMinimumSize(new java.awt.Dimension(80, 132));
        opEliminar.setPreferredSize(new java.awt.Dimension(80, 132));
        opEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        opEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opEliminarMouseClicked(evt);
            }
        });
        add(opEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 80, 132));

        opBuscar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        opBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        opBuscar.setText("Buscar");
        opBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 10, new java.awt.Color(24, 168, 255)));
        opBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        opBuscar.setMaximumSize(new java.awt.Dimension(80, 89));
        opBuscar.setPreferredSize(new java.awt.Dimension(80, 177));
        opBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        opBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opBuscarMouseClicked(evt);
            }
        });
        add(opBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 80, 132));

        opGuardar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        opGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        opGuardar.setText("Guardar");
        opGuardar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 10, new java.awt.Color(24, 168, 255)));
        opGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        opGuardar.setMaximumSize(new java.awt.Dimension(80, 132));
        opGuardar.setMinimumSize(new java.awt.Dimension(80, 132));
        opGuardar.setPreferredSize(new java.awt.Dimension(80, 132));
        opGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        opGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opGuardarMouseClicked(evt);
            }
        });
        add(opGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 80, 150));
    }// </editor-fold>//GEN-END:initComponents
    private void addItems(){
        cboPadreCategoria2.setModel(BDData.getCategoria1());
        cboPadreCategoria3.setModel(BDData.getCategoria1());        
    }
    private DefaultTableModel formatearTabla(){
        String[] theader={"Id Categoria","Categoria Superior","Categoria"};
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(theader);        
        return  dtm;
    }

    public void confTBL(JTable jTable){
	DefaultTableCellRenderer centerRdr= new DefaultTableCellRenderer();
        centerRdr.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0;i<3;i++){
            jTable.getColumnModel().getColumn(i).setCellRenderer(centerRdr);	
        }        
        for (int i = 0; i < 3; i++) {
            int idx=tplCategoria.getSelectedIndex();
            if (idx==0) {
                jTable.getColumnModel().getColumn(0).setWidth(0);
                jTable.getColumnModel().getColumn(0).setMaxWidth(0);
                jTable.getColumnModel().getColumn(0).setMinWidth(0);
                jTable.getColumnModel().getColumn(1).setWidth(0);
                jTable.getColumnModel().getColumn(1).setMaxWidth(0);
                jTable.getColumnModel().getColumn(1).setMinWidth(0);
            }else{
                jTable.getColumnModel().getColumn(0).setWidth(0);            
                jTable.getColumnModel().getColumn(0).setMaxWidth(0);            
                jTable.getColumnModel().getColumn(0).setMinWidth(0);            
            }
        }
        for(int i=0;i<3;i++)
            jTable.setRowHeight(i,45);        
        jTable.setDefaultEditor(Object.class,null);
        jTable.getTableHeader().setReorderingAllowed(false);
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
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre2KeyTyped

    private void txtNombre3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre3KeyTyped

    private void txtNombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre2ActionPerformed

    private void txtCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaKeyTyped
        char c=evt.getKeyChar();

        if(Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");
        }
    }//GEN-LAST:event_txtCategoriaKeyTyped

    private void cboCategoria3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCategoria3ItemStateChanged
        
    }//GEN-LAST:event_cboCategoria3ItemStateChanged

    private void cboPadreCategoria3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPadreCategoria3ItemStateChanged
        if (cboPadreCategoria3.getSelectedIndex()!=-1) {
            cboCategoria3.setModel(BDData.getCategoria2(cboPadreCategoria3.getSelectedItem().toString()));
        }        
    }//GEN-LAST:event_cboPadreCategoria3ItemStateChanged

    private void tplCategoriaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tplCategoriaStateChanged
        int idx= tplCategoria.getSelectedIndex();
        if (idx!=-1) {                     
            tblCategoria.setModel(BDData.listarCategoria(formatearTabla(), idx+1));
            confTBL(tblCategoria);
        }        
    }//GEN-LAST:event_tplCategoriaStateChanged

    private void opNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opNuevoMouseClicked
        opBuscar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opEditar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opEliminar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opNuevo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(255,51,51))));
        Timer t= new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {

            }
        };
        t.schedule(task, 3000);
    }//GEN-LAST:event_opNuevoMouseClicked

    private void opEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opEditarMouseClicked
        opBuscar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opEditar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(255,51,51))));
        opEliminar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opNuevo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        Timer t= new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {
          
            }
        };
        t.schedule(task, 1000);
    }//GEN-LAST:event_opEditarMouseClicked

    private void opEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opEliminarMouseClicked
        opBuscar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opEditar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opEliminar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(255,51,51))));
        opNuevo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));        
    }//GEN-LAST:event_opEliminarMouseClicked

    private void opBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opBuscarMouseClicked
        opBuscar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(255,51,51))));
        opEditar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opEliminar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opNuevo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
    }//GEN-LAST:event_opBuscarMouseClicked

    private void opGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opGuardarMouseClicked
//        opHome.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opGuardar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(255,51,51))));
        Timer t= new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {
                //options(4);
            }
        };
        t.schedule(task, 1000);
    }//GEN-LAST:event_opGuardarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboCategoria3;
    private javax.swing.JComboBox<String> cboNivel1;
    private javax.swing.JComboBox<String> cboNivel2;
    private javax.swing.JComboBox<String> cboNivel3;
    private javax.swing.JComboBox<String> cboPadreCategoria2;
    private javax.swing.JComboBox<String> cboPadreCategoria3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel opBuscar;
    public javax.swing.JLabel opEditar;
    public javax.swing.JLabel opEliminar;
    public javax.swing.JLabel opGuardar;
    public javax.swing.JLabel opNuevo;
    private javax.swing.JTable tblCategoria;
    private javax.swing.JTabbedPane tplCategoria;
    public static javax.swing.JTextField txtCategoria;
    public javax.swing.JTextField txtNombre1;
    public javax.swing.JTextField txtNombre2;
    public javax.swing.JTextField txtNombre3;
    // End of variables declaration//GEN-END:variables
}
