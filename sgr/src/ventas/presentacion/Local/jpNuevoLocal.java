
package ventas.presentacion.Local;

import java.net.URL;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ventas.modelo.Local;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpNuevoLocal extends javax.swing.JPanel {
    
    Login_User login_User=new Login_User();
    Local local=new Local();
    DefaultComboBoxModel dcbm;
    public jpNuevoLocal() {
        initComponents();
        addItems();
        cboEmpresa.setSelectedIndex(-1);    
    }
    
    private void cleanControls(){        
        txtDireccion.setText("");
        txtNombreLocal.setText("");
        cboEmpresa.setSelectedIndex(-1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombreLocal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cboEmpresa = new javax.swing.JComboBox<>();
        btnSave1 = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setPreferredSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Empresa:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 233, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 142, 260, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre del Local:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 80, -1, -1));

        txtNombreLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombreLocal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreLocalKeyTyped(evt);
            }
        });
        add(txtNombreLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 64, 260, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Dirección:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 158, -1, -1));

        cboEmpresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 216, 260, 50));

        btnSave1.setBackground(new java.awt.Color(153, 153, 255));
        btnSave1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        btnSave1.setText("Guardar");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });
        add(btnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 150, -1));

        btnReturn.setBackground(new java.awt.Color(153, 153, 255));
        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo.png"))); // NOI18N
        btnReturn.setText("Cancelar");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 150, -1));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setText("NUEVO LOCAL");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, 38));
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreLocalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreLocalKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");        
        }
    }//GEN-LAST:event_txtNombreLocalKeyTyped

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        if (!txtDireccion.getText().equals("") && !txtNombreLocal.getText().equals("") && cboEmpresa.getSelectedIndex()!=-1) {
            local.setNo_local(txtNombreLocal.getText());
            local.setTx_direccion(txtDireccion.getText());
            local.setNo_empresa(cboEmpresa.getSelectedItem().toString());
            local.setNid_usuario_crea(login_User.getNdi_usuario());
            if (BDData.nuevoLocal(local)) {
                cleanControls();
            }
        }        
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        jpListarLocal listaLocal=new jpListarLocal();
        frmPrincipal.Comp(listaLocal);
    }//GEN-LAST:event_btnReturnActionPerformed
    
    private void addItems(){
        dcbm=BDData.getEmpresa();        
        cboEmpresa.setModel(dcbm);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave1;
    private javax.swing.JComboBox<String> cboEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtNombreLocal;
    // End of variables declaration//GEN-END:variables
}
