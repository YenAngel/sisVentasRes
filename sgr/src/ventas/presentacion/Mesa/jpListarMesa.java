
package ventas.presentacion.Mesa;

import ventas.presentacion.Mesa.jpEditarMesa;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Login_User;
import ventas.modelo.Mesa;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;
import static ventas.presentacion.frmPrincipal.heightvar;
import static ventas.presentacion.frmPrincipal.nPanel;
import static ventas.presentacion.frmPrincipal.widthvar;

public class jpListarMesa extends javax.swing.JPanel{
    
    Login_User login_User=new Login_User();
    Mesa mesa =new Mesa();
    public DefaultTableModel dtm;
    public jpListarMesa() {
        initComponents();
        listarMesa();
        cboNroPiso.setModel(BDData.obtenerPiso());
        cboNroPiso.setSelectedIndex(-1);
    }
    private DefaultTableModel formatoTabla(){
        dtm= new DefaultTableModel();
        String[] theader={"Id Mesa","Mesa","Nro Sillas","Tipo Mesa","Piso","Local"};
        dtm.setColumnIdentifiers(theader);          
        return dtm;
    }
    private void listarMesa(){
        tblMesa.setModel(BDData.listarMesa(formatoTabla()));
        ConfigTable(tblMesa);
    }
    private void ConfigTable(JTable jt){
        
        jt.setDefaultEditor(Object.class, null);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0; i < jt.getColumnCount(); i++){
            jt.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            
        }
        for(int i = 0; i < jt.getRowCount(); i++)
            jt.setRowHeight(i, 45);
        jt.setDefaultEditor(Object.class, null);
        jt.getTableHeader().setReorderingAllowed(false);
        jt.getColumnModel().getColumn(0).setMaxWidth(0);
        jt.getColumnModel().getColumn(0).setMinWidth(0);
        jt.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jt.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMesa = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNroMesa = new javax.swing.JTextField();
        cboNroPiso = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setPreferredSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());


        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));


        tblMesa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tblMesa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMesa);


        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 800, 390));

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 700, 280));


        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/new.png"))); // NOI18N
        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, 150, 100));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit_user.png"))); // NOI18N

        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 150, 100));


        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 150, 100));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N

        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, 150, 100));


        btnDelete.setText("Eliminar");
        btnDelete.setPreferredSize(new java.awt.Dimension(130, 57));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 250, 150, 100));

        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, 150, 100));


        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search_2.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.setPreferredSize(new java.awt.Dimension(130, 57));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 360, 150, 100));

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel5.setForeground(new java.awt.Color(204, 204, 204));

        jLabel21.setBackground(new java.awt.Color(153, 153, 153));
        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Registros:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nro Mesa:");

        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 380, 150, 100));


        txtNroMesa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNroMesa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNroMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroMesaKeyTyped(evt);
            }
        });


        cboNroPiso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nro Piso:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addComponent(txtNroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(17, 17, 17)
                .addComponent(cboNroPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4))
                    .addComponent(txtNroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3))
                    .addComponent(cboNroPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 750, 110));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));

        jLabel22.setBackground(new java.awt.Color(153, 153, 153));
        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Datos de la Mesa:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 41, -1, -1));

        add(txtNroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 260, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nro Mesa:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nro Piso:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, -1, -1));

        cboNroPiso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboNroPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 260, 50));

    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int idx=tblMesa.getSelectedRow();    
        jpEditarMesa editarMesa=new jpEditarMesa();
        mesa.setNid_mesa(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        mesa.setNu_mesa(Integer.parseInt(dtm.getValueAt(idx, 1).toString()));
        mesa.setQt_silla(Integer.parseInt(dtm.getValueAt(idx, 2).toString()));
        mesa.setCo_tipo_mesa((String)dtm.getValueAt(idx, 3));        
        mesa.setNu_piso(Integer.parseInt((String)dtm.getValueAt(idx, 4).toString()));
        mesa.setNo_local((String)dtm.getValueAt(idx, 5));
        mesa.setNid_usuario_modi(login_User.getNdi_usuario());
        if (idx>=0) {            
            frmPrincipal.Comp(editarMesa);                 
            editarMesa.cargarMesa(mesa);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int idx=tblMesa.getSelectedRow();    
        mesa.setNid_usuario_modi(login_User.getNdi_usuario());
        mesa.setNid_mesa(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        if (idx>=0) {
            if (BDData.eliminarMesa(mesa)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                listarMesa();
            }else
                JOptionPane.showMessageDialog(null, "Registro no Eliminado");
        }else{
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Algún Registro");
        }       
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        jpNuevaMesa mesa =new jpNuevaMesa();
        frmPrincipal.Comp(mesa);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtNroMesa.getText().equals("") || cboNroPiso.getSelectedIndex()==-1) {            
            tblMesa.setModel(BDData.listarMesa(formatoTabla()));
        }else{            
            mesa.setNu_mesa(Integer.parseInt(txtNroMesa.getText()));
            mesa.setNu_piso(Integer.parseInt(cboNroPiso.getSelectedItem().toString()));
            tblMesa.setModel(BDData.obtenerMesa(formatoTabla(), mesa));
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtNroMesaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroMesaKeyTyped
        char c=evt.getKeyChar();

        if(Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");
        }
    }//GEN-LAST:event_txtNroMesaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    public static javax.swing.JComboBox<String> cboNroPiso;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMesa;
    public static javax.swing.JTextField txtNroMesa;
    // End of variables declaration//GEN-END:variables

}
