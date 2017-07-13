
package ventas.presentacion.Piso;

import javax.swing.JOptionPane;
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
        for(int i = 0; i < tblPiso.getRowCount(); i++)
            tblPiso.setRowHeight(i, 45);
        tblPiso.setDefaultEditor(Object.class, null);
        tblPiso.getTableHeader().setReorderingAllowed(false);
        tblPiso.getColumnModel().getColumn(0).setMaxWidth(0);
        tblPiso.getColumnModel().getColumn(0).setMinWidth(0);
        tblPiso.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblPiso.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 211, 806, 345));

        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 11, 150, 100));

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 129, 150, 100));

        btnDelete.setText("Eliminar");
        btnDelete.setPreferredSize(new java.awt.Dimension(130, 57));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 247, 150, 101));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.setPreferredSize(new java.awt.Dimension(130, 57));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 366, 150, 100));

        txtPiso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPiso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPisoKeyTyped(evt);
            }
        });
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPiso;
    public static javax.swing.JTextField txtPiso;
    // End of variables declaration//GEN-END:variables
}
