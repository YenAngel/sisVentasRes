
package ventas.presentacion.Mesa;

import javax.swing.JOptionPane;
import ventas.modelo.Login_User;
import ventas.modelo.Mesa;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpNuevaMesa extends javax.swing.JPanel {
    
    Mesa mesa=new Mesa();
    public jpNuevaMesa() {
        initComponents();
        cboLocal.setModel(BDData.getLocal());
        cboLocal.setSelectedIndex(-1);
        cboNroPiso.setSelectedIndex(-1);
        cboTipoMesa.setSelectedIndex(-1);
    }
    
    private void cleanControls(){
        txtCantidad.setText("");
        txtNroMesa.setText("");
        cboLocal.setSelectedIndex(-1);
        cboNroPiso.setSelectedIndex(-1);
        cboTipoMesa.setSelectedIndex(-1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboNroPiso = new javax.swing.JComboBox<>();
        cboTipoMesa = new javax.swing.JComboBox<>();
        btnHome = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtNroMesa = new javax.swing.JTextField();
        cboLocal = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel3.setText("Nro Piso:");

        jLabel4.setText("Nro Mesa:");

        jLabel5.setText("Tipo de Mesa:");

        jLabel6.setText("Cantidad de Sillas:");

        cboTipoMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Familiar", "Normal" }));

        btnHome.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Home-icon.png")); // NOI18N
        btnHome.setText("Retornar");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Check-icon.png")); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtNroMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroMesaActionPerformed(evt);
            }
        });
        txtNroMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroMesaKeyTyped(evt);
            }
        });

        cboLocal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLocalItemStateChanged(evt);
            }
        });
        cboLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboLocalMouseClicked(evt);
            }
        });
        cboLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocalActionPerformed(evt);
            }
        });

        jLabel7.setText("Local:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(351, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(27, 27, 27)
                                .addComponent(cboNroPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(cboTipoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cboTipoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboNroPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        jpListarMesa listarMesa=new jpListarMesa();
        frmPrincipal.Comp(listarMesa);
    }//GEN-LAST:event_btnHomeActionPerformed
    private boolean validarControls(){
        boolean ok;
        if (!txtCantidad.getText().equals("") && !txtNroMesa.getText().equals("")) {
            ok=true;
        }else
            ok=false;
        
        if (cboLocal.getSelectedIndex()!=-1 && cboNroPiso.getSelectedIndex()!=-1 && cboTipoMesa.getSelectedIndex()!=-1) {
            ok=true;
        }else
            ok=false;
        return ok;
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Login_User login_User=new Login_User();
        if (validarControls()) {
            mesa.setNu_mesa(Integer.parseInt(txtNroMesa.getText()));
            mesa.setQt_silla(Integer.parseInt(txtCantidad.getText()));
            mesa.setCo_tipo_mesa(cboTipoMesa.getSelectedItem().toString());
            mesa.setNu_piso(Integer.parseInt(cboNroPiso.getSelectedItem().toString()));
            mesa.setNo_local(cboLocal.getSelectedItem().toString());
            mesa.setNid_usuario_crea(login_User.getNdi_usuario());
            if (BDData.nuevaMesa(mesa)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                cleanControls();
            }
        }else
            JOptionPane.showMessageDialog(null, "Completar los campos");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cboLocalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLocalItemStateChanged
        if (cboLocal.getSelectedIndex()!=-1) {            
            cboNroPiso.setModel(BDData.getPiso_Local(cboLocal.getSelectedItem().toString()));
            cboNroPiso.setSelectedIndex(-1);
        }        
    }//GEN-LAST:event_cboLocalItemStateChanged

    private void cboLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocalActionPerformed

    }//GEN-LAST:event_cboLocalActionPerformed

    private void cboLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboLocalMouseClicked
//        mesa.setNo_local(cboLocal.getSelectedItem().toString());
    }//GEN-LAST:event_cboLocalMouseClicked

    private void txtNroMesaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroMesaKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isLetter(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");        
        }
    }//GEN-LAST:event_txtNroMesaKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isLetter(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");        
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtNroMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroMesaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSave;
    public javax.swing.JComboBox<String> cboLocal;
    public javax.swing.JComboBox<String> cboNroPiso;
    public javax.swing.JComboBox<String> cboTipoMesa;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtNroMesa;
    // End of variables declaration//GEN-END:variables
}
