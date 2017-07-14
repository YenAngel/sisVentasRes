
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
        cboVip.setSelectedIndex(-1);
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

        cboPlato = new javax.swing.JComboBox<>();
        cboLocal = new javax.swing.JComboBox<>();
        cboVip = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSave1 = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboPlato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPlatoActionPerformed(evt);
            }
        });
        add(cboPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 155, 260, 50));

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 87, 260, 50));

        cboVip.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboVip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        add(cboVip, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 291, 260, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Vip:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 308, -1, -1));

        txtPrecio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 223, 260, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Local:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 104, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Plato:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 172, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Precio:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 239, -1, -1));

        btnSave1.setBackground(new java.awt.Color(153, 153, 255));
        btnSave1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        btnSave1.setText("Guardar");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });
        add(btnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 150, -1));

        btnReturn.setBackground(new java.awt.Color(153, 153, 255));
        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo.png"))); // NOI18N
        btnReturn.setText("Cancelar");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 150, -1));
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
                JOptionPane.showMessageDialog(null, "Registro Ingresado");
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
