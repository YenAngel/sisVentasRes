
package ventas.presentacion.Empresa;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ventas.modelo.Empresa;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpEditarEmpresa extends javax.swing.JPanel {
    Login_User usuario= new Login_User();
    Empresa empresa=new Empresa();
    public jpEditarEmpresa() {
        initComponents();    
        txtCodigo.setEnabled(false);
    }
    
    public static void cargarEmpresa(Empresa empresa){
        txtCodigo.setText(empresa.getNid_empresa()+"");
        txtRazonSocial.setText(empresa.getNo_razon_social());
        txtNombreComercial.setText(empresa.getNo_comercial());
        txtRUC.setText(empresa.getNu_ruc());        
    }    
    private void cleanControls(){
        txtCodigo.setText("");
        txtNombreComercial.setText("");
        txtRUC.setText("");
        txtRazonSocial.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnHome = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtRazonSocial = new javax.swing.JTextField();
        txtNombreComercial = new javax.swing.JTextField();
        txtRUC = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setPreferredSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Id Empresa:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 108, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Razón Social:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 193, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre Comercial:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 273, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("RUC:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 342, -1, -1));

        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 93, 260, 50));

        btnHome.setText("Retornar");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 223, 140, 60));

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 93, 140, 60));

        txtRazonSocial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyTyped(evt);
            }
        });
        add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 178, 260, 50));

        txtNombreComercial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombreComercial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreComercialKeyTyped(evt);
            }
        });
        add(txtNombreComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 258, 260, 50));

        txtRUC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtRUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRUCKeyTyped(evt);
            }
        });
        add(txtRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 326, 260, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (!txtNombreComercial.getText().equals("") && !txtRazonSocial.getText().equals("") && !txtRUC.getText().equals("")) {
            empresa.setNid_empresa(Integer.parseInt(txtCodigo.getText()));
            empresa.setNo_razon_social(txtRazonSocial.getText());
            empresa.setNo_comercial(txtNombreComercial.getText());
            empresa.setNu_ruc(txtRUC.getText());
            empresa.setNid_usuario_modi(usuario.getNdi_usuario());
            if (BDData.editarEmpresa(empresa)) {
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                cleanControls();
                jpListarEmpresa listarEmpresa=new  jpListarEmpresa();
                frmPrincipal.Comp(listarEmpresa);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        jpListarEmpresa listarEmpresa=new jpListarEmpresa();        
        frmPrincipal.Comp(listarEmpresa);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void txtRazonSocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");        
        }
    }//GEN-LAST:event_txtRazonSocialKeyTyped

    private void txtNombreComercialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreComercialKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");        
        }
    }//GEN-LAST:event_txtNombreComercialKeyTyped

    private void txtRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUCKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isLetter(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");        
        }
    }//GEN-LAST:event_txtRUCKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtNombreComercial;
    public static javax.swing.JTextField txtRUC;
    public static javax.swing.JTextField txtRazonSocial;
    // End of variables declaration//GEN-END:variables
}
