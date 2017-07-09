
package ventas.presentacion.Piso;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import ventas.modelo.Login_User;
import ventas.modelo.Piso;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpNuevoPiso extends javax.swing.JPanel {
    
    DefaultComboBoxModel dcbm;
    public jpNuevoPiso() {
        initComponents();
        dcbm=BDData.getLocal();
        cboLocal.setModel(dcbm);
        cboLocal.setSelectedIndex(-1);
    }
    private void cleanControls(){
        txtNroPiso.setText("");
        cboLocal.setSelectedIndex(-1);    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtNroPiso = new javax.swing.JTextField();
        cboLocal = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Numero de Piso:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 102, -1, -1));

        txtNroPiso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNroPiso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroPisoKeyTyped(evt);
            }
        });
        add(txtNroPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 86, 260, 50));

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 154, 260, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Local:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 171, -1, -1));

        btnHome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Home-icon.png")); // NOI18N
        btnHome.setText("Retornar");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, -1, 60));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Check-icon.png")); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 86, 147, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        jpListarPiso listarPiso=new jpListarPiso();
        frmPrincipal.Comp(listarPiso);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Piso piso=new Piso();
        Login_User login_User=new Login_User();
        if (!txtNroPiso.getText().equals("") && cboLocal.getSelectedIndex()!=-1) {
            piso.setNu_piso(Integer.parseInt(txtNroPiso.getText()));
            piso.setNo_local(cboLocal.getSelectedItem().toString());
            piso.setNid_usuario_crea(login_User.getNdi_usuario());
            if (BDData.nuevoPiso(piso)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                cleanControls();
            }
        }else
            JOptionPane.showMessageDialog(null, "Completar los campos");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtNroPisoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroPisoKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isLetter(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");        
        }
    }//GEN-LAST:event_txtNroPisoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSave;
    public javax.swing.JComboBox<String> cboLocal;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JTextField txtNroPiso;
    // End of variables declaration//GEN-END:variables
}
