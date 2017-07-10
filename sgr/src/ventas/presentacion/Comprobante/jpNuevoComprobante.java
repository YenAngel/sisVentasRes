
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
    private void cleanControls(){
        cboLocal.setSelectedIndex(-1);
        cboComprobante.setSelectedIndex(-1);
        txtCorrelativo.setText("");
        txtSerie.setText("");
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

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 73, 260, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Codigo de Comprobante:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 158, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Local:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 90, -1, -1));

        txtSerie.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });
        add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 209, 260, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Serie:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 225, -1, -1));

        txtCorrelativo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCorrelativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorrelativoKeyTyped(evt);
            }
        });
        add(txtCorrelativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 277, 260, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Correlativo:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 293, -1, -1));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Check-icon.png")); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 73, 147, 60));

        btnHome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Home-icon.png")); // NOI18N
        btnHome.setText("Retornar");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 160, -1, 60));

        cboComprobante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura", "Ticket" }));
        add(cboComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 141, 260, 50));
    }// </editor-fold>//GEN-END:initComponents
            
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Login_User login_User=new Login_User();
        if (!txtCorrelativo.getText().equals("") && !txtSerie.getText().equals("") && cboLocal.getSelectedIndex()!=-1 && cboComprobante.getSelectedIndex()!=-1) {
            comprobante.setNo_local(cboLocal.getSelectedItem().toString());
            comprobante.setNu_correlativo(txtCorrelativo.getText());
            comprobante.setNu_serie(txtSerie.getText());
            comprobante.setCo_comprobante(cboComprobante.getSelectedItem().toString());
            comprobante.setNid_usuario_crea(login_User.getNdi_usuario());
            if (BDData.nuevoComprobante(comprobante)) {
                JOptionPane.showMessageDialog(null, "Registro Ingresado");
                cleanControls();            
            }
        }else
            JOptionPane.showMessageDialog(null, "Completar los campos");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        jpListarComprobante listarComprobante=new jpListarComprobante();
        frmPrincipal.Comp(listarComprobante);
    }//GEN-LAST:event_btnHomeActionPerformed

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
        int cs=evt.getKeyCode();   
        
        if(Character.isLetter(c)) {             
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
