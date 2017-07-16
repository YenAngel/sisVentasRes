
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
        btnSave1 = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

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

        btnSave1.setBackground(new java.awt.Color(153, 153, 255));
        btnSave1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        btnSave1.setText("Guardar");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });
        add(btnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 150, -1));

        btnReturn.setBackground(new java.awt.Color(153, 153, 255));
        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo.png"))); // NOI18N
        btnReturn.setText("Cancelar");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 150, -1));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setText("NUEVO PLATO");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, 38));
    }// </editor-fold>//GEN-END:initComponents

    private void txtNroPisoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroPisoKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isLetter(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");        
        }
    }//GEN-LAST:event_txtNroPisoKeyTyped

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        Piso piso=new Piso();
        Login_User login_User=new Login_User();
        if (!txtNroPiso.getText().equals("") && cboLocal.getSelectedIndex()!=-1) {
            piso.setNu_piso(Integer.parseInt(txtNroPiso.getText()));
            piso.setNo_local(cboLocal.getSelectedItem().toString());
            piso.setNid_usuario_crea(login_User.getNdi_usuario());
            if (BDData.nuevoPiso(piso)) {
                cleanControls();
            }
        }else
            JOptionPane.showMessageDialog(null, "Completar los campos");
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        jpListarPiso listarPiso=new jpListarPiso();
        frmPrincipal.Comp(listarPiso);
    }//GEN-LAST:event_btnReturnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave1;
    public javax.swing.JComboBox<String> cboLocal;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JTextField txtNroPiso;
    // End of variables declaration//GEN-END:variables
}
