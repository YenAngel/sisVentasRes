
package ventas.presentacion.Plato_Local;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ventas.modelo.Login_User;
import ventas.modelo.PlatoLocal;
import ventas.persistencia.util.BDData;
import static ventas.presentacion.Plato_Local.jpNuevoPlatoLocal.cboLocal;
import static ventas.presentacion.Plato_Local.jpNuevoPlatoLocal.cboPlato;
import ventas.presentacion.frmPrincipal;

public class jpEditarPlatoLocal extends javax.swing.JPanel {

    PlatoLocal platoLocal=new PlatoLocal();
    public jpEditarPlatoLocal() {
        initComponents();
        addITems();
    }    
    private void addITems(){
        cboLocal.setModel(BDData.getLocal());
        cboPlato.setModel(BDData.getPlato());
    }
    public static void cargarPlatoLocal(PlatoLocal pl){
        cboLocal.setSelectedItem(pl.getNo_local());
        cboPlato.setSelectedItem(pl.getNo_plato());
        txtPrecio.setText(pl.getMt_precio()+"");        
        cboVip.setSelectedItem(pl.getFl_vip());                
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

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboPlato = new javax.swing.JComboBox<>();
        cboLocal = new javax.swing.JComboBox<>();
        cboVip = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnSave1 = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Local:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 103, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Plato:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 171, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Precio:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 238, -1, -1));

        cboPlato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPlatoActionPerformed(evt);
            }
        });
        add(cboPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 154, 260, 50));

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 86, 260, 50));

        cboVip.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboVip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        add(cboVip, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 290, 260, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Vip:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 307, -1, -1));

        txtPrecio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 222, 260, 50));

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

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setText("EDITAR PLATO POR LOCAL");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, 38));
    }// </editor-fold>//GEN-END:initComponents

    private void cboPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPlatoActionPerformed

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
            platoLocal.setNid_usuario_modi(login_User.getNdi_usuario());
            if (BDData.editarPlatoLocal(platoLocal)) {
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                cleanControls();
                jpListarPlatoLocal listarPlatoLocal=new jpListarPlatoLocal();
                frmPrincipal.Comp(listarPlatoLocal);
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
    public static javax.swing.JComboBox<String> cboVip;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
