
package ventas.presentacion.Mesa;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ventas.modelo.Login_User;
import ventas.modelo.Mesa;
import ventas.persistencia.util.BDData;
import ventas.presentacion.Local.jpListarLocal;
import ventas.presentacion.frmPrincipal;
import static ventas.presentacion.frmPrincipal.heightvar;
import static ventas.presentacion.frmPrincipal.nPanel;
import static ventas.presentacion.frmPrincipal.widthvar;

public class jpEditarMesa extends javax.swing.JPanel {
    
    Login_User login_User=new Login_User();
    Mesa mesa=new Mesa();
    public jpEditarMesa() {
        initComponents();        
        cboLocal.setModel(BDData.getLocal());
        cboLocal.setSelectedIndex(-1);        
        cboTipoMesa.setSelectedIndex(-1);
        txtCodigo.setEnabled(false);
    }
    private void cleanControls(){
        txtCantidad.setText("");
        txtCodigo.setText("");
        txtNroMesa.setText("");
        cboLocal.setSelectedIndex(-1);
        cboNroPiso.setSelectedIndex(-1);
        cboTipoMesa.setSelectedIndex(-1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboNroPiso = new javax.swing.JComboBox<>();
        txtNroMesa = new javax.swing.JTextField();
        btnHome = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cboLocal = new javax.swing.JComboBox<>();
        txtCodigo = new javax.swing.JTextField();
        cboTipoMesa = new javax.swing.JComboBox<>();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setPreferredSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 260, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nro Piso:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nro Mesa:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tipo de Mesa:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Cantidad de Sillas:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        cboNroPiso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboNroPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 260, 50));

        txtNroMesa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNroMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroMesaKeyTyped(evt);
            }
        });
        add(txtNroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 260, 50));

        btnHome.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Home-icon.png")); // NOI18N
        btnHome.setText("Retornar");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 200, 140, 60));

        btnSave.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Check-icon.png")); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 140, 60));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Local:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboLocal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLocalItemStateChanged(evt);
            }
        });
        add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 260, 50));

        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 260, 50));

        cboTipoMesa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTipoMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Familiar", "Normal" }));
        add(cboTipoMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 260, 50));
    }// </editor-fold>//GEN-END:initComponents
    
    public static void cargarMesa(Mesa m){
        txtCodigo.setText(m.getNid_mesa()+"");
        txtCantidad.setText(m.getQt_silla()+"");
        txtNroMesa.setText(m.getNu_mesa()+"");
        cboLocal.setSelectedItem(m.getNo_local());        
        cboTipoMesa.setSelectedItem(m.getCo_tipo_mesa());
        cboNroPiso.setSelectedItem(m.getNu_piso()+"");
    }

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        jpListarMesa listarMesa =new jpListarMesa();
        frmPrincipal.Comp(listarMesa);
    }//GEN-LAST:event_btnHomeActionPerformed
    private boolean validarControls(){
        boolean ok;
        if (!txtCantidad.getText().equals("") && !txtCodigo.getText().equals("") && !txtNroMesa.getText().equals("")) {
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
        if (validarControls()) {
            mesa.setNid_mesa(Integer.parseInt(txtCodigo.getText()));
            mesa.setNu_mesa(Integer.parseInt(txtNroMesa.getText()));
            mesa.setQt_silla(Integer.parseInt(txtCantidad.getText()));
            mesa.setCo_tipo_mesa(cboTipoMesa.getSelectedItem().toString());
            mesa.setNo_local(cboLocal.getSelectedItem().toString());
            mesa.setNu_piso(Integer.parseInt(cboNroPiso.getSelectedItem().toString()));            
            mesa.setNid_usuario_modi(login_User.getNdi_usuario());        

            if (BDData.editarMesa(mesa)) {
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                cleanControls();
                jpListarMesa listarMesa=new jpListarMesa();
                frmPrincipal.Comp(listarMesa);
            }
        }else
            JOptionPane.showMessageDialog(null, "Completar los campos");
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cboLocalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLocalItemStateChanged
        if (cboLocal.getSelectedIndex()!=-1) {            
            cboNroPiso.setModel(BDData.getPiso_Local(cboLocal.getSelectedItem().toString()));
        }
    }//GEN-LAST:event_cboLocalItemStateChanged

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        
    }//GEN-LAST:event_txtCodigoKeyTyped

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSave;
    public static javax.swing.JComboBox<String> cboLocal;
    public static javax.swing.JComboBox<String> cboNroPiso;
    public static javax.swing.JComboBox<String> cboTipoMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtNroMesa;
    // End of variables declaration//GEN-END:variables

}
