
package ventas.presentacion.Mesa;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ventas.modelo.Login_User;
import ventas.modelo.Mesa;
import ventas.persistencia.util.BDData;
import ventas.presentacion.Local.jpListaLocal;
import ventas.presentacion.frmPrincipal;
import static ventas.presentacion.frmPrincipal.heightvar;
import static ventas.presentacion.frmPrincipal.nPanel;
import static ventas.presentacion.frmPrincipal.widthvar;

public class jpEditarMesa extends javax.swing.JPanel {
    
    Login_User login_User=new Login_User();
    Mesa mesa=new Mesa();
    public jpEditarMesa() {
        initComponents();
        initIcon(lblEstado.getText());
        cboLocal.setModel(BDData.getLocal());
        cboLocal.setSelectedIndex(-1);        
        cboTipoMesa.setSelectedIndex(-1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboNroPiso = new javax.swing.JComboBox<>();
        txtNroMesa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cboLocal = new javax.swing.JComboBox<>();
        txtCodigo = new javax.swing.JTextField();
        cboTipoMesa = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 260, 50));

        jLabel1.setText("Codigo:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        lblEstado.setText("Estado:");
        lblEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEstadoMouseClicked(evt);
            }
        });
        add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 260, 50));

        jLabel3.setText("Nro Piso:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jLabel4.setText("Nro Mesa:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        jLabel5.setText("Tipo de Mesa:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        jLabel6.setText("Cantidad de Sillas:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        add(cboNroPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 260, 50));
        add(txtNroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 260, 50));

        jLabel7.setText("Estado:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Pen-icon.png")); // NOI18N
        jLabel8.setText("Editar de Mesa");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 260, 50));

        btnHome.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Home-icon.png")); // NOI18N
        btnHome.setText("Retornar");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 140, 60));

        btnSave.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Check-icon.png")); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 140, 60));

        jLabel9.setText("Local:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        cboLocal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLocalItemStateChanged(evt);
            }
        });
        add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 260, 50));
        add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 260, 50));

        cboTipoMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Familiar", "Normal" }));
        add(cboTipoMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 260, 50));
    }// </editor-fold>//GEN-END:initComponents
    
    public static void cargarMesa(Mesa m){
        txtCodigo.setText(m.getNid_mesa()+"");
        txtCantidad.setText(m.getQt_silla()+"");
        txtNroMesa.setText(m.getNu_mesa()+"");
        cboLocal.setSelectedItem(m.getNo_local());        
        cboTipoMesa.setSelectedItem(m.getCo_tipo_mesa());
        cboNroPiso.setSelectedItem(m.getNu_piso()+"");
        lblEstado.setText(m.getNo_estado());
    }
    private void initIcon(String iconic){
        if (iconic.equals("Inactivo")) {            
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
    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        jpListarMesa listarMesa =new jpListarMesa();
        frmPrincipal.Comp(listarMesa);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        mesa.setNid_mesa(Integer.parseInt(txtCodigo.getText()));
        mesa.setNu_mesa(Integer.parseInt(txtNroMesa.getText()));
        mesa.setQt_silla(Integer.parseInt(txtCantidad.getText()));
        mesa.setCo_tipo_mesa(cboTipoMesa.getSelectedItem().toString());
        mesa.setNo_local(cboLocal.getSelectedItem().toString());
        mesa.setNu_piso(Integer.parseInt(cboNroPiso.getSelectedItem().toString()));
        mesa.setNo_estado(lblEstado.getText());
        mesa.setNid_usuario_modi(login_User.getNdi_usuario());        

        if (BDData.editarMesa(mesa)) {
            JOptionPane.showMessageDialog(null, "Registro Actualizado");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cboLocalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLocalItemStateChanged
        if (cboLocal.getSelectedIndex()!=-1) {            
            cboNroPiso.setModel(BDData.getPiso_Local(cboLocal.getSelectedItem().toString()));
        }
    }//GEN-LAST:event_cboLocalItemStateChanged

    private void lblEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEstadoMouseClicked
        icon(lblEstado.getText());
    }//GEN-LAST:event_lblEstadoMouseClicked


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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel lblEstado;
    public static javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtNroMesa;
    // End of variables declaration//GEN-END:variables

}
