
package ventas.presentacion.Local;

import javax.swing.JOptionPane;
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
        for(int i = 0; i < tblLocal.getRowCount(); i++)
            tblLocal.setRowHeight(i, 45);
        tblLocal.setDefaultEditor(Object.class, null);
        tblLocal.getTableHeader().setReorderingAllowed(false);
        tblLocal.getColumnModel().getColumn(0).setMaxWidth(0);
        tblLocal.getColumnModel().getColumn(0).setMinWidth(0);
        tblLocal.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblLocal.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
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
        txtLocal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 141, 720, 430));

        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 49, 150, 100));

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 167, 150, 100));

        btnDelete.setText("Eliminar");
        btnDelete.setPreferredSize(new java.awt.Dimension(130, 57));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 285, 150, 100));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.setPreferredSize(new java.awt.Dimension(130, 57));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 403, 150, 100));

        txtLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtLocal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLocalKeyTyped(evt);
            }
        });
        add(txtLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 260, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Local:");
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLocal;
    public static javax.swing.JTextField txtLocal;
    // End of variables declaration//GEN-END:variables

}
