
package ventas.presentacion.Comprobante;

import javax.swing.JOptionPane;
import ventas.modelo.Comprobante;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpEditarComprobante extends javax.swing.JPanel {

    Comprobante comprobante =new Comprobante();
    public jpEditarComprobante() {
        initComponents();
        addITems();
    }
    private void addITems(){
        cboLocal.setModel(BDData.getLocal());
    }
    public static void cargarComprobante(Comprobante c){
        cboLocal.setSelectedItem(c.getNo_local());
        cboComprobante.setSelectedItem(c.getCo_comprobante());
        txtSerie.setText(c.getNu_serie());        
        txtCorrelativo.setText(c.getNu_correlativo());
    }    
    private void cleanControls(){
        cboLocal.setSelectedIndex(-1);
        cboLocal.setSelectedIndex(-1);
        txtCorrelativo.setText("");
        txtSerie.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        txtCorrelativo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cboLocal = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        cboComprobante = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Serie:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 233, -1, -1));

        txtCorrelativo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCorrelativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorrelativoKeyTyped(evt);
            }
        });
        add(txtCorrelativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 285, 260, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Correlativo:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 301, -1, -1));

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 81, 260, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Comprobante:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 166, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Local:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 98, -1, -1));

        txtSerie.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });
        add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 217, 260, 50));

        cboComprobante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura", "Ticket" }));
        add(cboComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 149, 260, 50));

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

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setText("EDITAR COMPROBANTE");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, 38));
    }// </editor-fold>//GEN-END:initComponents

    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isLetter(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");        
        }
    }//GEN-LAST:event_txtSerieKeyTyped

    private void txtCorrelativoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorrelativoKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isLetter(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");        
        }
    }//GEN-LAST:event_txtCorrelativoKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Login_User login_User=new Login_User();

        if (!txtCorrelativo.getText().equals("") && !txtSerie.getText().equals("") && cboLocal.getSelectedIndex()!=-1 && cboComprobante.getSelectedIndex()!=-1) {
            comprobante.setNo_local(cboLocal.getSelectedItem().toString());
            comprobante.setNu_correlativo(txtCorrelativo.getText());
            comprobante.setNu_serie(txtSerie.getText());
            comprobante.setCo_comprobante(cboComprobante.getSelectedItem().toString());
            comprobante.setNid_usuario_modi(login_User.getNdi_usuario());
            if (BDData.editarComprobante(comprobante)) {
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                cleanControls();
                jpListarComprobante listarComprobante=new jpListarComprobante();
                frmPrincipal.Comp(listarComprobante);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        jpListarComprobante listarComprobante=new jpListarComprobante();
        frmPrincipal.Comp(listarComprobante);
    }//GEN-LAST:event_btnReturnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave;
    public static javax.swing.JComboBox<String> cboComprobante;
    public static javax.swing.JComboBox<String> cboLocal;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField txtCorrelativo;
    public static javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
