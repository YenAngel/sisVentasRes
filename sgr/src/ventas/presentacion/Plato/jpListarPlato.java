
package ventas.presentacion.Plato;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Login_User;
import ventas.modelo.Plato;
import ventas.persistencia.util.BDData;
import static ventas.persistencia.util.BDData.editarLocal;
import ventas.presentacion.frmPrincipal;

public class jpListarPlato extends javax.swing.JPanel {
    
    Plato plato=new Plato();
    Login_User login_User=new Login_User();
    public DefaultTableModel dtm;
    public jpListarPlato() {
        initComponents();
        listarPlato();
    }
    private DefaultTableModel formatearTabla(){
        String[] theader={"Id Plato","Plato","Categoria 1","Categoria 2","Categoria 3"};
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(theader);        
        return  dtm;
    }
    private void listarPlato(){
        tblPlato.setModel(BDData.listarPlato(formatearTabla()));
        ConfigTable(tblPlato);
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
        tblPlato = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtPlato = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPlato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblPlato.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPlato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlatoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPlato);


        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 235, 790, 410));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit_user.png"))); // NOI18N

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 159, 646, 320));


        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 150, 100));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N

        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 193, 150, 100));


        btnDelete.setText("Eliminar");
        btnDelete.setPreferredSize(new java.awt.Dimension(130, 57));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 270, 150, 100));

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/new.png"))); // NOI18N

        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 311, 150, 100));


        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 150, 100));

        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 75, 150, 100));


        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search_2.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.setPreferredSize(new java.awt.Dimension(130, 57));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 390, 150, 100));

        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 429, 150, 100));


        txtPlato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPlato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlatoKeyTyped(evt);
            }
        });

        add(txtPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 75, 260, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre de Plato:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 95, -1, -1));

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

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 196, -1, -1));

        add(txtPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 75, 260, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre de Plato:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 95, -1, -1));

    }// </editor-fold>//GEN-END:initComponents
    public void editarPlato(int idx){        
        jpEditarPlato editarPlato=new jpEditarPlato();        
        plato.setNid_plato(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        plato.setNo_plato((String)dtm.getValueAt(idx, 1));
        plato.setNo_categoria1_plato((String)dtm.getValueAt(idx, 2));
        plato.setNo_categoria2_plato((String)dtm.getValueAt(idx, 3));
        plato.setNo_categoria3_plato((String)dtm.getValueAt(idx, 4));
        plato.setNo_estado((String)dtm.getValueAt(idx, 5));
        plato.setNid_usuario_modi(login_User.getNdi_usuario());
        if(idx >= 0){
            frmPrincipal.Comp(editarPlato);
            editarPlato.cargarPlato(plato);
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int idx=tblPlato.getSelectedRow();
        
        jpEditarPlato editarPlato=new jpEditarPlato();        
        plato.setNid_plato(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        plato.setNo_plato((String)dtm.getValueAt(idx, 1));
        plato.setNo_categoria1_plato((String)dtm.getValueAt(idx, 2));
        plato.setNo_categoria2_plato((String)dtm.getValueAt(idx, 3));
        plato.setNo_categoria3_plato((String)dtm.getValueAt(idx, 4));
        plato.setNid_usuario_modi(login_User.getNdi_usuario());
        if(idx >= 0){
            frmPrincipal.Comp(editarPlato);
            editarPlato.cargarPlato(plato);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int idx=tblPlato.getSelectedRow();
        plato.setNid_plato(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        plato.setNid_usuario_modi(login_User.getNdi_usuario());
        if (BDData.eliminarPlato(plato)) {
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            listarPlato();
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblPlatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlatoMouseClicked
        
    }//GEN-LAST:event_tblPlatoMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        jpNuevoPlato plato=new jpNuevoPlato();
        frmPrincipal.Comp(plato);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtPlato.getText().equals("")) {
            tblPlato.setModel(BDData.listarPlato(formatearTabla()));
        }else{
            plato.setNo_plato(txtPlato.getText());
            tblPlato.setModel(BDData.obtenerPlato(formatearTabla(), plato));
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtPlatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlatoKeyTyped
        char c=evt.getKeyChar();

        if(Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");
        }
    }//GEN-LAST:event_txtPlatoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblPlato;
    public static javax.swing.JTextField txtPlato;
    // End of variables declaration//GEN-END:variables
}
