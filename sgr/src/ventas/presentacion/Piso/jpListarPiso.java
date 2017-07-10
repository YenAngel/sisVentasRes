
package ventas.presentacion.Piso;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Login_User;
import ventas.modelo.Piso;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpListarPiso extends javax.swing.JPanel {
    
    Login_User login_User=new Login_User();
    Piso piso=new Piso();
    DefaultTableModel dtm;
    public jpListarPiso() {
        initComponents();
        listarPiso();
        cboLocal.setModel(BDData.getLocal());
        cboLocal.setSelectedIndex(-1);
    }
    private void listarPiso(){
        tblPiso.setModel(BDData.listarPiso(formatearTabla()));
        ConfigTable(tblPiso);
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
    private DefaultTableModel formatearTabla(){
        String[] theader={"Id Piso","Numero de Piso","Local"};
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(theader);        
        return  dtm;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPiso = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtPiso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboLocal = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setPreferredSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPiso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblPiso.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPiso);


        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 205, 814, 435));

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/new.png"))); // NOI18N

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 211, 806, 345));


        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(873, 11, 150, 100));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit_user.png"))); // NOI18N

        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 11, 150, 100));


        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(873, 129, 150, 100));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N

        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 129, 150, 100));


        btnDelete.setText("Eliminar");
        btnDelete.setPreferredSize(new java.awt.Dimension(130, 57));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(873, 247, 150, 101));

        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 247, 150, 101));


        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search_2.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.setPreferredSize(new java.awt.Dimension(130, 57));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(873, 366, 150, 100));

        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 366, 150, 100));


        txtPiso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPiso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPisoKeyTyped(evt);
            }
        });

        add(txtPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 72, 260, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Local:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 92, -1, -1));

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 72, 260, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre de Plato:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 92, -1, -1));

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

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 166, -1, -1));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));

        jLabel22.setBackground(new java.awt.Color(153, 153, 153));
        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Datos de la Piso:");

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

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 20, 200, -1));

        add(txtPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 117, 260, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Local:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 137, -1, -1));

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 117, 260, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre de Plato:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 137, -1, -1));

    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        jpNuevoPiso piso=new jpNuevoPiso();
        frmPrincipal.Comp(piso);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int idx=tblPiso.getSelectedRow();
        piso.setNid_piso(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        piso.setNu_piso(Integer.parseInt(dtm.getValueAt(idx, 1).toString()));
        piso.setNo_local((String)dtm.getValueAt(idx, 2));        
        piso.setNid_usuario_modi(login_User.getNdi_usuario());
        if(idx >=0){            
            jpEditarPiso editarPiso=new jpEditarPiso();
            frmPrincipal.Comp(editarPiso);
            editarPiso.cargarPiso(piso);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int idx=tblPiso.getSelectedRow();
        piso.setNid_piso(Integer.parseInt(dtm.getValueAt(idx,0).toString()));
        piso.setNid_usuario_modi(login_User.ndi_usuario);
        if (BDData.eliminarPiso(piso)) {
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            listarPiso();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtPiso.getText().equals("") || cboLocal.getSelectedIndex()==-1) {
            tblPiso.setModel(BDData.listarPiso(formatearTabla()));
        }else{
            piso.setNo_local(cboLocal.getSelectedItem().toString());
            piso.setNu_piso(Integer.parseInt(txtPiso.getText()));
            tblPiso.setModel(BDData.obtenerPisoFiltro(formatearTabla(), piso));
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtPisoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPisoKeyTyped
        char c=evt.getKeyChar();

        if(Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");
        }
    }//GEN-LAST:event_txtPisoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    public static javax.swing.JComboBox<String> cboLocal;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPiso;
    public static javax.swing.JTextField txtPiso;
    // End of variables declaration//GEN-END:variables
}
