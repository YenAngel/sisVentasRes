
package ventas.presentacion.Plato_Local;

import javax.swing.JOptionPane;
import ventas.modelo.Login_User;
import ventas.modelo.PlatoLocal;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpNuevoPlatoLocal extends javax.swing.JPanel {
    
    PlatoLocal platoLocal=new PlatoLocal();
    public jpNuevoPlatoLocal() {
        initComponents();
        addITems();
        cboLocal.setSelectedIndex(-1);
        cboPlato.setSelectedIndex(-1);
        cboVip.setSelectedIndex(1);
    }
    private void cleanControls(){        
        txtPrecio.setText("");
        cboLocal.setSelectedIndex(-1);
        cboPlato.setSelectedIndex(-1);
        cboVip.setSelectedIndex(-1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSave1 = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cboPlato = new javax.swing.JComboBox<>();
        cboLocal = new javax.swing.JComboBox<>();
        cboVip = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
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
        add(btnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 180, 70));

        btnReturn.setBackground(new java.awt.Color(153, 153, 255));
        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo.png"))); // NOI18N
        btnReturn.setText("Cancelar");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, 180, 70));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel16.setText("NUEVO PLATO POR LOCAL");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, 38));

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cboPlato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPlatoActionPerformed(evt);
            }
        });

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        cboVip.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboVip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Vip:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Local:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Plato:");

        txtPrecio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Precio:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(13, 13, 13)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(13, 13, 13)
                        .addComponent(cboVip, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(cboPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboVip, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 140, 781, 240));

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

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 101, 150, 39));
    }// </editor-fold>//GEN-END:initComponents
    private void addITems(){
        cboLocal.setModel(BDData.getLocal());
        cboPlato.setModel(BDData.getPlato());
    }
    private void cboPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPlatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPlatoActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isLetter(c)) {             
            getToolkit().beep();             
            evt.consume();          
            
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");        
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        Login_User login_User=new Login_User();
        if (!txtPrecio.getText().equals("") && cboLocal.getSelectedIndex()!=-1 && cboPlato.getSelectedIndex()!=-1  && cboVip.getSelectedIndex()!=-1) {
            platoLocal.setNo_local(cboLocal.getSelectedItem().toString());
            platoLocal.setNo_plato(cboPlato.getSelectedItem().toString());
            platoLocal.setMt_precio(Double.parseDouble(txtPrecio.getText()));
            platoLocal.setFl_vip(cboVip.getSelectedItem().toString());
            platoLocal.setNid_usuario_crea(login_User.getNdi_usuario());
            if (BDData.nuevoPlatoLocal(platoLocal)) {
                cleanControls();
            }
        }else
            JOptionPane.showMessageDialog(null, "Completar los campos");
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        jpListarPlatoLocal listarPlatoLocal=new jpListarPlatoLocal();
        frmPrincipal.Comp(listarPlatoLocal);
    }//GEN-LAST:event_btnReturnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave1;
    public static javax.swing.JComboBox<String> cboLocal;
    public static javax.swing.JComboBox<String> cboPlato;
    private javax.swing.JComboBox<String> cboVip;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
