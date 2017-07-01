
package ventas.presentacion.Comprobante;

import javax.swing.JOptionPane;
import ventas.modelo.Comprobante;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpNuevoComprobante extends javax.swing.JPanel {

    Comprobante comprobante=new Comprobante();
    public jpNuevoComprobante() {
        initComponents();
        addItems();
        cboComprobante.setSelectedIndex(-1);
        cboLocal.setSelectedIndex(-1);
    }
    private void addItems(){
        cboLocal.setModel(BDData.getLocal());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboLocal = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCorrelativo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        cboComprobante = new javax.swing.JComboBox<>();

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Codigo de Comprobante:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Local:");

        txtSerie.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Serie:");

        txtCorrelativo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCorrelativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorrelativoKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Correlativo:");

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Check-icon.png")); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnHome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Home-icon.png")); // NOI18N
        btnHome.setText("Retornar");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        cboComprobante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Login_User login_User=new Login_User();

        comprobante.setNo_local(cboLocal.getSelectedItem().toString());
        comprobante.setNu_correlativo(txtCorrelativo.getText());
        comprobante.setNu_serie(txtSerie.getText());
        comprobante.setCo_comprobante(cboComprobante.getSelectedItem().toString());
        comprobante.setNid_usuario_crea(login_User.getNdi_usuario());
        if (BDData.nuevoComprobante(comprobante)) {
            JOptionPane.showMessageDialog(null, "Registro Ingresado");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        jpListarComprobante listarComprobante=new jpListarComprobante();
        frmPrincipal.Comp(listarComprobante);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        char c=evt.getKeyChar();  
        
        if(!Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");        
        }
    }//GEN-LAST:event_txtSerieKeyTyped

    private void txtCorrelativoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorrelativoKeyTyped
        char c=evt.getKeyChar();   
        int cs=evt.getKeyCode();   
        
        if(!Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");        
        }
    }//GEN-LAST:event_txtCorrelativoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    public javax.swing.JButton btnSave;
    public static javax.swing.JComboBox<String> cboComprobante;
    public static javax.swing.JComboBox<String> cboLocal;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField txtCorrelativo;
    public javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
