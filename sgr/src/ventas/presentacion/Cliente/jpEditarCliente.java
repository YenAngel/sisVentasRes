
package ventas.presentacion.Cliente;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ventas.modelo.Cliente;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpEditarCliente extends javax.swing.JPanel {

    Cliente cliente=new Cliente();
    public jpEditarCliente() {
        initComponents();        
        txtCodigo.setEnabled(false);
        txtCodigo.setEnabled(false);
    }
    public static void cargarCliente(Cliente c){
        txtCodigo.setText(c.getNid_cliente()+"");
        txtNombre.setText(c.getNo_cliente());
        txtPaterno.setText(c.getNo_ape_paterno());
        txtMaterno.setText(c.getNo_ape_materno());
        cboTipoDocumento.setSelectedItem(c.getCo_tipo_documento());
        txtDocumento.setText(c.getNu_documento());        
    }         
    
    private void cleanControls(){
        txtCodigo.setText("");
        txtNombre.setText("");
        cboTipoDocumento.setSelectedIndex(-1);
        txtDocumento.setText("");
        txtMaterno.setText("");
        txtPaterno.setText("");    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboTipoDocumento = new javax.swing.JComboBox<>();
        txtDocumento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setPreferredSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "RUC" }));
        add(cboTipoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 366, 260, 50));

        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });
        add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 444, 260, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Número de Documento:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 459, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre del Cliente:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 159, -1, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 144, 260, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Apellido Paterno:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 236, -1, -1));

        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaternoKeyTyped(evt);
            }
        });
        add(txtPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 221, 260, 50));

        txtMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaternoKeyTyped(evt);
            }
        });
        add(txtMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 298, 260, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Apellido Materno:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 313, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tipo de Documento:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 381, -1, -1));

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 76, 260, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Id del Cliente:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 91, -1, -1));

        btnReturn.setBackground(new java.awt.Color(153, 153, 255));
        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo.png"))); // NOI18N
        btnReturn.setText("Cancelar");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 150, -1));

        btnSave.setBackground(new java.awt.Color(153, 153, 255));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 150, -1));
    }// </editor-fold>//GEN-END:initComponents

    private boolean validarCotrols(){
        boolean ok;
        if (!txtDocumento.getText().equals("") && !txtMaterno.getText().equals("") && !txtNombre.getText().equals("") && !txtPaterno.getText().equals("")) {
            ok=true;
        }else
            ok=false;
        if (cboTipoDocumento.getSelectedIndex()!=-1 && !txtCodigo.getText().equals("")) {
            ok=true;
        }else
            ok=false;
        return ok;
    }
    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar Letras");        
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaternoKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar Letras");        
        }
    }//GEN-LAST:event_txtPaternoKeyTyped

    private void txtMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaternoKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar Letras");        
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

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        jpListarCliente listarCliente=new jpListarCliente();
        frmPrincipal.Comp(listarCliente);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Login_User login_User= new Login_User();
        if (validarCotrols()) {
            cliente.setNid_cliente(Integer.parseInt(txtCodigo.getText()));
            cliente.setNo_cliente(txtNombre.getText());
            cliente.setNo_ape_paterno(txtPaterno.getText());
            cliente.setNo_ape_materno(txtMaterno.getText());
            cliente.setCo_tipo_documento(cboTipoDocumento.getSelectedItem().toString());
            cliente.setNu_documento(txtDocumento.getText());
            cliente.setNid_usuario_modi(login_User.getNdi_usuario());
            if (BDData.editarCliente(cliente)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                cleanControls();
                jpListarCliente listarCliente =new jpListarCliente();
                frmPrincipal.Comp(listarCliente);
            }
        }else
            JOptionPane.showMessageDialog(null,"Completar todos los campos");
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave;
    public static javax.swing.JComboBox<String> cboTipoDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtDocumento;
    public static javax.swing.JTextField txtMaterno;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtPaterno;
    // End of variables declaration//GEN-END:variables
}
