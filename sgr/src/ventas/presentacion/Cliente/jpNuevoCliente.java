
package ventas.presentacion.Cliente;

import javax.swing.JOptionPane;
import ventas.modelo.Cliente;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpNuevoCliente extends javax.swing.JPanel {
    
    Cliente cliente= new Cliente();
    public jpNuevoCliente() {
        initComponents();
        cboTipoDocumento.setSelectedIndex(-1);
    }
    private void cleanControls(){
        txtNombre.setText("");
        txtDocumento.setText("");
        txtMaterno.setText("");
        txtPaterno.setText("");
        cboTipoDocumento.setSelectedIndex(-1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboTipoDocumento = new javax.swing.JComboBox<>();
        txtDocumento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Home-icon.png")); // NOI18N
        jButton1.setText("Retornar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 203, 180, 80));

        btnSave.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Check-icon.png")); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 105, 180, 80));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tipo de Documento:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 334, -1, -1));

        cboTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "RUC" }));
        add(cboTipoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 319, 260, 50));

        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });
        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });
        add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 397, 260, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Número de Documento:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 412, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre del Cliente:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 120, -1, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 105, 260, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Apellido Paterno:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 198, -1, -1));

        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaternoKeyTyped(evt);
            }
        });
        add(txtPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 183, 260, 50));

        txtMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaternoKeyTyped(evt);
            }
        });
        add(txtMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 251, 260, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Apellido Materno:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 266, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jpListarCliente listarCliente=new jpListarCliente();
        frmPrincipal.Comp(listarCliente);
    }//GEN-LAST:event_jButton1ActionPerformed
    private boolean validarCotrols(){
        boolean ok;
        if (!txtDocumento.getText().equals("") && !txtMaterno.getText().equals("") && !txtNombre.getText().equals("") && !txtPaterno.getText().equals("")) {
            ok=true;
        }else
            ok=false;
        if (cboTipoDocumento.getSelectedIndex()!=-1) {
            ok=true;
        }else
            ok=false;
        return ok;
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Login_User login_User= new Login_User();
        if (validarCotrols()) {
            cliente.setNo_cliente(txtNombre.getText());
            cliente.setNo_ape_paterno(txtPaterno.getText());
            cliente.setNo_ape_materno(txtMaterno.getText());
            cliente.setCo_tipo_documento(cboTipoDocumento.getSelectedItem().toString());
            cliente.setNu_documento(txtDocumento.getText());
            cliente.setNid_usuario_crea(login_User.getNdi_usuario());        
            if (BDData.nuevoCliente(cliente)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                cleanControls();
            }
        }else
            JOptionPane.showMessageDialog(null,"Completar todos los campos");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");        
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaternoKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");        
        }
    }//GEN-LAST:event_txtPaternoKeyTyped

    private void txtMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaternoKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");        
        }
    }//GEN-LAST:event_txtMaternoKeyTyped

    private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isLetter(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");        
        }
    }//GEN-LAST:event_txtDocumentoKeyTyped

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboTipoDocumento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JTextField txtDocumento;
    public javax.swing.JTextField txtMaterno;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPaterno;
    // End of variables declaration//GEN-END:variables
}
