
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
    }
    public static void cargarCliente(Cliente c){
        txtCodigo.setText(c.getNid_cliente()+"");
        txtNombre.setText(c.getNo_cliente());
        txtPaterno.setText(c.getNo_ape_paterno());
        txtMaterno.setText(c.getNo_ape_materno());
        cboTipoDocumento.setSelectedItem(c.getCo_tipo_documento());
        txtDocumento.setText(c.getNu_documento());
        lblEstado.setText(c.getNo_estado());
        initIcon(lblEstado.getText().toLowerCase());
    }         
    private static  void initIcon(String iconic){
        String path = "D:/sisVentasRes/sgr/src/recursos/"+iconic+".png";
            
        ImageIcon imageIcon = new ImageIcon(path);
        Icon icon= new ImageIcon(imageIcon.getImage());
        lblEstado.setIcon(icon);
        lblEstado.setText(iconic.substring(0,1).toUpperCase()+iconic.substring(0+1,iconic.length()));
        lblEstado.repaint();        
    }
    private void icon(String iconic){
        if (iconic.equals("Activo")) {            
            String path = "D:/sisVentasRes/sgr/src/recursos/security-low.png";
            //URL url = this.getClass().getResource(path);
            ImageIcon imageIcon = new ImageIcon(path);
            Icon icon= new ImageIcon(imageIcon.getImage());
            lblEstado.setIcon(icon);
            lblEstado.setText("Inactivo");
            this.repaint();
        }else{            
            String path = "D:/sisVentasRes/sgr/src/recursos/security-high.png";
            //URL url = this.getClass().getResource(path);
            ImageIcon imageIcon = new ImageIcon(path);
            Icon icon= new ImageIcon(imageIcon.getImage());
            lblEstado.setIcon(icon);
            lblEstado.setText("Activo");
            this.repaint();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboTipoDocumento = new javax.swing.JComboBox<>();
        txtDocumento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtMaterno = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        cboTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "RUC" }));

        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Número de Documento:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre del Cliente:");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Add-icon.png")); // NOI18N
        jLabel8.setText("Nuevo Cliente");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Apellido Paterno:");

        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaternoKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Home-icon.png")); // NOI18N
        jButton1.setText("Retornar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaternoKeyTyped(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Check-icon.png")); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Apellido Materno:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tipo de Documento:");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Id del Cliente:");

        lblEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/security-medium.png"))); // NOI18N
        lblEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEstadoMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Estado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(265, 265, 265))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jpListarCliente listarCliente=new jpListarCliente();
        frmPrincipal.Comp(listarCliente);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Login_User login_User= new Login_User();
        cliente.setNid_cliente(Integer.parseInt(txtCodigo.getText()));
        cliente.setNo_cliente(txtNombre.getText());
        cliente.setNo_ape_paterno(txtPaterno.getText());
        cliente.setNo_ape_materno(txtMaterno.getText());
        cliente.setCo_tipo_documento(cboTipoDocumento.getSelectedItem().toString());
        cliente.setNu_documento(txtDocumento.getText());
        cliente.setNo_estado(lblEstado.getText());
        cliente.setNid_usuario_modi(login_User.getNdi_usuario());
        if (BDData.editarCliente(cliente)) {
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void lblEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEstadoMouseClicked
        icon(lblEstado.getText());
    }//GEN-LAST:event_lblEstadoMouseClicked

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
        
        if(!Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");        
        }         
    }//GEN-LAST:event_txtDocumentoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    public static javax.swing.JComboBox<String> cboTipoDocumento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel lblEstado;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtDocumento;
    public static javax.swing.JTextField txtMaterno;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtPaterno;
    // End of variables declaration//GEN-END:variables
}
