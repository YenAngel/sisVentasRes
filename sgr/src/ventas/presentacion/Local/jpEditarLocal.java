
package ventas.presentacion.Local;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ventas.modelo.Local;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.Piso.jpListarPiso;
import ventas.presentacion.frmPrincipal;

public class jpEditarLocal extends javax.swing.JPanel {
    
    DefaultComboBoxModel dcbm=new  DefaultComboBoxModel();
    Login_User usuario= new Login_User();
    Local local =new Local();
    public jpEditarLocal() {
        initComponents();
        addItems();
        cboEmpresa.setSelectedIndex(-1);
        txtCodigo.setEnabled(false);
    }
    private void addItems(){
        dcbm=BDData.getEmpresa();        
        cboEmpresa.setModel(dcbm);
    }
    public static void cargarLocal(Local local){
        txtCodigo.setText(local.getNid_local()+"");
        txtNombreLocal.setText(local.getNo_local());
        txtDireccion.setText(local.getTx_direccion());
        cboEmpresa.setSelectedItem(local.getNo_empresa());        
    }         
    
    private void cleanControls(){
        txtCodigo.setText("");
        txtDireccion.setText("");
        txtNombreLocal.setText("");
        cboEmpresa.setSelectedIndex(-1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNombreLocal = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        cboEmpresa = new javax.swing.JComboBox<>();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setPreferredSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Home-icon.png")); // NOI18N
        btnHome.setText("Retornar");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 178, 140, 60));

        btnSave.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Check-icon.png")); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 91, 140, 60));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Id Local:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 111, -1, -1));

        txtNombreLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombreLocal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreLocalKeyTyped(evt);
            }
        });
        add(txtNombreLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 169, 260, 50));

        txtDireccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 237, 260, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Dirección:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 253, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre de Local:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 185, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Empresa:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 322, -1, -1));

        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 95, 260, 50));

        cboEmpresa.setBackground(new java.awt.Color(204, 204, 255));
        cboEmpresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 305, 260, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        jpListarLocal listarLocal=new jpListarLocal();
        frmPrincipal.Comp(listarLocal);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (!txtDireccion.getText().equals("") && !txtNombreLocal.getText().equals("") && cboEmpresa.getSelectedIndex()!=-1) {
            local.setNid_local(Integer.parseInt(txtCodigo.getText()));
            local.setNo_local(txtNombreLocal.getText());
            local.setTx_direccion(txtDireccion.getText());
            local.setNo_empresa(cboEmpresa.getSelectedItem().toString());
            local.setNid_usuario_modi(usuario.getNdi_usuario());
            if (BDData.editarLocal(local)) {
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                cleanControls();
                jpListarLocal listarLocal=new jpListarLocal();
                frmPrincipal.Comp(listarLocal);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtNombreLocalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreLocalKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");        
        }
    }//GEN-LAST:event_txtNombreLocalKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSave;
    public static javax.swing.JComboBox<String> cboEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtNombreLocal;
    // End of variables declaration//GEN-END:variables

}
