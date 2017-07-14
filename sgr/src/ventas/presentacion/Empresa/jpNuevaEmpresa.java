
package ventas.presentacion.Empresa;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ventas.modelo.Empresa;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpNuevaEmpresa extends javax.swing.JPanel {
    
    Login_User login_User=new Login_User();
    Empresa empresa= new Empresa();
    public jpNuevaEmpresa() {
        initComponents();
    }
    private void cleanControls(){
        txtNombreC.setText("");
        txtRazonSocial.setText("");
        txtruc.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreC = new javax.swing.JTextField();
        txtruc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombreC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCKeyTyped(evt);
            }
        });
        add(txtNombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 260, 50));

        txtruc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrucKeyTyped(evt);
            }
        });
        add(txtruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 260, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Razón Social:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre Comercial:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        txtRazonSocial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyTyped(evt);
            }
        });
        add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 260, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("RUC:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));

        btnSave.setBackground(new java.awt.Color(153, 153, 255));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 150, -1));

        btnReturn.setBackground(new java.awt.Color(153, 153, 255));
        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo.png"))); // NOI18N
        btnReturn.setText("Cancelar");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 150, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtrucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrucKeyTyped
        char c=evt.getKeyChar();                         
        
        if(Character.isLetter(c)) {                         
            getToolkit().beep();                         
            evt.consume();                                     
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");                
        }
    }//GEN-LAST:event_txtrucKeyTyped

    private void txtRazonSocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialKeyTyped
        char c=evt.getKeyChar();                         
        
        if(Character.isDigit(c)) {                         
            getToolkit().beep();                         
            evt.consume();                                     
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");                
        }
    }//GEN-LAST:event_txtRazonSocialKeyTyped

    private void txtNombreCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCKeyTyped
        char c=evt.getKeyChar();                         
        
        if(Character.isDigit(c)) {                         
            getToolkit().beep();                         
            evt.consume();                                     
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");                
        }
    }//GEN-LAST:event_txtNombreCKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (!txtNombreC.getText().equals("") && !txtRazonSocial.getText().equals("") && !txtruc.getText().equals("")) {
            empresa.setNo_razon_social(txtRazonSocial.getText());
            empresa.setNo_comercial(txtNombreC.getText());
            empresa.setNu_ruc(txtruc.getText());
            empresa.setNid_usuario_crea(login_User.getNdi_usuario());
            if (BDData.nuevaEmpresa(empresa)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                cleanControls();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        jpListarEmpresa listarEmpresa=new jpListarEmpresa();
        frmPrincipal.Comp(listarEmpresa);
    }//GEN-LAST:event_btnReturnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JTextField txtNombreC;
    public javax.swing.JTextField txtRazonSocial;
    public javax.swing.JTextField txtruc;
    // End of variables declaration//GEN-END:variables
}
