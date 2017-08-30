
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

        btnSave1 = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cboLocal = new javax.swing.JComboBox<>();
        txtNroMesa = new javax.swing.JTextField();
        cboNroPiso = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboTipoMesa = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();

        setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setPreferredSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSave1.setBackground(new java.awt.Color(153, 153, 255));
        btnSave1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        btnSave1.setText("Guardar");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });
        add(btnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 180, 70));

        btnReturn.setBackground(new java.awt.Color(153, 153, 255));
        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo.png"))); // NOI18N
        btnReturn.setText("Cancelar");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 180, 70));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel16.setText("NUEVA MESA");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, 38));

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        txtNroMesa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNroMesa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        cboNroPiso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nro Salón:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nro Mesa:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Local:");

        cboTipoMesa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTipoMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Familiar", "Normal" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tipo de Mesa:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("<html>Cantidad de  Sillas:</html>");

        txtCantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cboNroPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(cboTipoMesa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(93, 93, 93)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtNroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNroPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4))
                    .addComponent(cboTipoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5)))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 100, 861, 390));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel21.setBackground(new java.awt.Color(153, 153, 153));
        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Registro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 61, 150, 39));
    }// </editor-fold>//GEN-END:initComponents
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

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        Login_User login_User=new Login_User();
        if (validarControls()) {
            mesa.setNu_mesa(Integer.parseInt(txtNroMesa.getText()));
            mesa.setQt_silla(Integer.parseInt(txtCantidad.getText()));
            mesa.setCo_tipo_mesa(cboTipoMesa.getSelectedItem().toString());
            mesa.setNu_piso(Integer.parseInt(cboNroPiso.getSelectedItem().toString()));
            mesa.setNo_local(cboLocal.getSelectedItem().toString());
            mesa.setNid_usuario_crea(login_User.getNdi_usuario());
            if (BDData.nuevaMesa(mesa)) {
                cleanControls();
            }
        }else
            JOptionPane.showMessageDialog(null, "Completar los campos");
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        jpListarMesa listarMesa=new jpListarMesa();
        frmPrincipal.Comp(listarMesa);
    }//GEN-LAST:event_btnReturnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave1;
    public javax.swing.JComboBox<String> cboLocal;
    public javax.swing.JComboBox<String> cboNroPiso;
    public javax.swing.JComboBox<String> cboTipoMesa;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtNroMesa;
    // End of variables declaration//GEN-END:variables
}
