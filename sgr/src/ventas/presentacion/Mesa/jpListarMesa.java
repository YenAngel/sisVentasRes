
package ventas.presentacion.Mesa;

import ventas.presentacion.Mesa.jpEditarMesa;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
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
        String[] theader={"Id Mesa","Mesa","Nro Sillas","Tipo Mesa","Piso","Local","Estado"};
        dtm.setColumnIdentifiers(theader);          
        return dtm;
    }
    private void listarMesa(){
        tblMesa.setModel(BDData.listarMesa(formatoTabla()));
        for(int i = 0; i < tblMesa.getRowCount(); i++)
            tblMesa.setRowHeight(i, 45);
        tblMesa.setDefaultEditor(Object.class, null);
        tblMesa.getTableHeader().setReorderingAllowed(false);
        tblMesa.getColumnModel().getColumn(0).setMaxWidth(0);
        tblMesa.getColumnModel().getColumn(0).setMinWidth(0);
        tblMesa.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblMesa.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
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
        txtNroMesa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboNroPiso = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1200, 768));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 700, 280));

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/adder.png"))); // NOI18N
        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 150, 100));

        btnEdit.setIcon(new javax.swing.ImageIcon("D:\\icons\\Pen-icon.png")); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, 150, 100));

        btnDelete.setIcon(new javax.swing.ImageIcon("D:\\icons\\Recyclebin-icon.png")); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setPreferredSize(new java.awt.Dimension(130, 57));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, 150, 100));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.setPreferredSize(new java.awt.Dimension(130, 57));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, 150, 100));

        txtNroMesa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNroMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroMesaKeyTyped(evt);
            }
        });
        add(txtNroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 260, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nro Mesa:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nro Piso:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        cboNroPiso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboNroPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 260, 50));
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
        mesa.setNo_estado((String)dtm.getValueAt(idx, 6));
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMesa;
    public static javax.swing.JTextField txtNroMesa;
    // End of variables declaration//GEN-END:variables

}
