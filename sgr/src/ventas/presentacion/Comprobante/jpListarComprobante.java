
package ventas.presentacion.Comprobante;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Comprobante;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpListarComprobante extends javax.swing.JPanel {
    
    Comprobante comprobante=new Comprobante();
    DefaultTableModel dtm;
    public jpListarComprobante() {
        initComponents();
        listarComprobante();
        cboComprobante.setSelectedIndex(-1);
    }
    private DefaultTableModel formatearTabla(){
        String[] theader={"Local","Codigo","Serie","Correlativo"};
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(theader);        
        return  dtm;
    }
    private void listarComprobante(){
        tblComprobante.setModel(BDData.listarComprobante(formatearTabla()));
        for(int i = 0; i < tblComprobante.getRowCount(); i++)
            tblComprobante.setRowHeight(i, 45);
        tblComprobante.setDefaultEditor(Object.class, null);
        tblComprobante.getTableHeader().setReorderingAllowed(false);        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComprobante = new javax.swing.JTable();
        cboComprobante = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setPreferredSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNew.setText("Nuevo");
        btnNew.setPreferredSize(new java.awt.Dimension(150, 100));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(828, 141, -1, -1));

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(828, 259, 150, 100));

        tblComprobante.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblComprobante);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 210, 707, 267));

        cboComprobante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura", "Ticket" }));
        add(cboComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 142, 260, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Comprobante:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 162, -1, -1));

        txtSerie.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });
        add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 142, 260, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Serie:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 162, -1, -1));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.setPreferredSize(new java.awt.Dimension(130, 57));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(828, 377, 150, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        jpNuevoComprobante comprobante=new jpNuevoComprobante();
        frmPrincipal.Comp(comprobante);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int idx=tblComprobante.getSelectedRow();
        Comprobante comprobante=new Comprobante();
        Login_User login_User=new Login_User();
        jpEditarComprobante editarComprobante=new jpEditarComprobante();
        comprobante.setNo_local(dtm.getValueAt(idx, 0).toString());
        comprobante.setCo_comprobante(dtm.getValueAt(idx, 1).toString());
        comprobante.setNu_serie(dtm.getValueAt(idx, 2).toString());
        comprobante.setNu_correlativo(dtm.getValueAt(idx, 3).toString());
        comprobante.setNid_usuario_modi(login_User.getNdi_usuario());
        if(idx >= 0){
            frmPrincipal.Comp(editarComprobante);
            editarComprobante.cargarComprobante(comprobante);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        char c=evt.getKeyChar();

        if(Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");
        }
    }//GEN-LAST:event_txtSerieKeyTyped

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtSerie.getText().equals("") || cboComprobante.getSelectedIndex()==-1) {
            tblComprobante.setModel(BDData.listarComprobante(formatearTabla()));
            for(int i = 0; i < tblComprobante.getRowCount(); i++)
            tblComprobante.setRowHeight(i, 45);
            tblComprobante.setDefaultEditor(Object.class, null);
            tblComprobante.getTableHeader().setReorderingAllowed(false);        
        }else{
            comprobante.setNu_serie(txtSerie.getText());
            comprobante.setCo_comprobante(cboComprobante.getSelectedItem().toString());
            tblComprobante.setModel(BDData.obtenerComprobante(formatearTabla(), comprobante));
            for(int i = 0; i < tblComprobante.getRowCount(); i++)
            tblComprobante.setRowHeight(i, 45);
            tblComprobante.setDefaultEditor(Object.class, null);
            tblComprobante.getTableHeader().setReorderingAllowed(false);        
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    public static javax.swing.JComboBox<String> cboComprobante;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblComprobante;
    public static javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
