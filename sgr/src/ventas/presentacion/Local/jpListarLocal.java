
package ventas.presentacion.Local;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Local;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.Empresa.jpEditarEmpresa;
import ventas.presentacion.frmPrincipal;

public class jpListarLocal extends javax.swing.JPanel {
    
    DefaultTableModel dtm;
    Local local =new Local();
    Login_User usuario=new Login_User();
    public jpListarLocal() {
        initComponents();
        listarLocal();
    }
    
    private DefaultTableModel formatearTabla(){
        String[] theader={"Id Local","Nombre del Local","Dirección","Empresa"};
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(theader);        
        return  dtm;
    }
    
    private void listarLocal(){
        tblLocal.setModel(BDData.listarLocal(formatearTabla()));
        ConfigTable(tblLocal);
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
        tblLocal = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtLocal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblLocal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblLocal);


        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 275, 808, 375));

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/new.png"))); // NOI18N

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 141, 720, 430));


        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 11, 150, 100));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit_user.png"))); // NOI18N

        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 49, 150, 100));


        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 129, 150, 100));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N

        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 167, 150, 100));


        btnDelete.setText("Eliminar");
        btnDelete.setPreferredSize(new java.awt.Dimension(130, 57));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 247, 150, 100));

        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 285, 150, 100));


        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search_2.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.setPreferredSize(new java.awt.Dimension(130, 57));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 365, 150, 100));

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

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 236, -1, -1));

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 403, 150, 100));


        txtLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtLocal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtLocal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLocalKeyTyped(evt);
            }
        });
        add(txtLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 260, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Local:");


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addGap(51, 51, 51)
                .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 97, -1, -1));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));

        jLabel22.setBackground(new java.awt.Color(153, 153, 153));
        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Datos de la Empresa:");

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

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 60, -1, -1));

        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        jpNuevoLocal nuevoLocal=new jpNuevoLocal();
        frmPrincipal.Comp(nuevoLocal);        
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int idx=tblLocal.getSelectedRow();
        jpEditarLocal editarLocal=new jpEditarLocal();
        local.setNid_local(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        local.setNo_local((String)dtm.getValueAt(idx, 1));
        local.setTx_direccion((String)dtm.getValueAt(idx, 2));
        local.setNo_empresa((String)dtm.getValueAt(idx, 3));
        local.setNid_usuario_modi(usuario.getNdi_usuario());        
        if(idx != -1){            
            frmPrincipal.Comp(editarLocal);                                   
            editarLocal.cargarLocal(local);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int idx=tblLocal.getSelectedRow();
        local.setNid_local(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));        
        local.setNid_usuario_modi(usuario.getNdi_usuario());
        if (BDData.eliminarLocal(local)) {
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            listarLocal();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtLocal.getText().equals("")) {
            tblLocal.setModel(BDData.listarLocal(formatearTabla()));
        }else{
            local.setNo_local(txtLocal.getText());
            tblLocal.setModel(BDData.obtenerLocal(formatearTabla(), local));
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtLocalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalKeyTyped
        char c=evt.getKeyChar();

        if(Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");
        }
    }//GEN-LAST:event_txtLocalKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLocal;
    public static javax.swing.JTextField txtLocal;
    // End of variables declaration//GEN-END:variables

}
