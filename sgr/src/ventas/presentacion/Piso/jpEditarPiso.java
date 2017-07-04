
package ventas.presentacion.Piso;

import java.io.File;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.codec.binary.StringUtils;
import ventas.modelo.Login_User;
import ventas.modelo.Piso;
import ventas.persistencia.util.BDData;
import static ventas.presentacion.Local.jpEditarLocal.cboEmpresa;
import ventas.presentacion.Login;
import ventas.presentacion.frmPrincipal;

public class jpEditarPiso extends javax.swing.JPanel {
    
    DefaultComboBoxModel dcbm=new DefaultComboBoxModel();
    Piso piso=new Piso();
    public jpEditarPiso() {
        initComponents();
        addItems();                
        //cboPiso.setModel(dcbm);
        txtCodigo.setEnabled(false);                
    }

    private void addItems(){
        dcbm=BDData.getLocal();        
        cboLocal.setModel(dcbm);
    }
    public static void cargarPiso(Piso p){
        txtCodigo.setText(p.getNid_piso()+"");
        txtNroPiso.setText(p.getNu_piso()+"");
        cboLocal.setSelectedItem(p.getNo_local());        
        lblEstado.setText(p.getNo_estado());        
        initIcon(lblEstado.getText().toLowerCase());
    }         
    
    public static void initIcon(String iconic){                
            String path = "D:/sisVentasRes/sgr/src/recursos/"+iconic+".png";
            
            ImageIcon imageIcon = new ImageIcon(path);
            Icon icon= new ImageIcon(imageIcon.getImage());
            lblEstado.setIcon(icon);
            lblEstado.setText(iconic.substring(0,1).toUpperCase()+iconic.substring(0+1,iconic.length()));
            lblEstado.repaint();        
    }
    private void icon(String iconic){
        if (iconic.startsWith("Activo")) {            
            String path = "D:/sisVentasRes/sgr/src/recursos/inactivo.png";
            //URL url = this.getClass().getResource(path);
            ImageIcon imageIcon = new ImageIcon(path);
            Icon icon= new ImageIcon(imageIcon.getImage());
            lblEstado.setIcon(icon);
            lblEstado.setText("Inactivo");
            this.repaint();
        }else{            
            String path = "D:/sisVentasRes/sgr/src/recursos/activo.png";
            //URL url = this.getClass().getResource(path);
            ImageIcon imageIcon = new ImageIcon(path);
            Icon icon= new ImageIcon(imageIcon.getImage());
            lblEstado.setIcon(icon);
            lblEstado.setText("Activo");
            this.repaint();
        }
    }
    private void cleanControls(){
        txtCodigo.setText("");
        cboLocal.setSelectedIndex(-1);
        txtNroPiso.setText("");
        lblEstado.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNroPiso = new javax.swing.JTextField();
        cboLocal = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        txtNroPiso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroPisoKeyTyped(evt);
            }
        });

        cboLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Local:");

        lblEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEstadoMouseClicked(evt);
            }
        });

        jLabel7.setText("Estado:");

        jLabel4.setText("Numero de Piso:");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        jLabel5.setText("Id Piso:");

        btnSave.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Check-icon.png")); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnHome.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Home-icon.png")); // NOI18N
        btnHome.setText("Retornar");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNroPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNroPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7))
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        piso=new Piso();
        Login_User login=new Login_User();
        if (!txtNroPiso.getText().equals("") && cboLocal.getSelectedIndex()!=-1) {
            piso.setNid_piso(Integer.parseInt(txtCodigo.getText()));
            piso.setNu_piso(Integer.parseInt(txtNroPiso.getText()));
            piso.setNo_local(cboLocal.getSelectedItem().toString());
            piso.setNo_estado(lblEstado.getText());        
            piso.setNid_usuario_modi(login.getNdi_usuario());   
            if (BDData.editarPiso(piso)) {
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                cleanControls();
                jpListarPiso listarPiso=new jpListarPiso();
                frmPrincipal.Comp(listarPiso);
            }
        }else
            JOptionPane.showMessageDialog(null, "Completar los campos");      
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        jpListarPiso listarPiso=new jpListarPiso();
        frmPrincipal.Comp(listarPiso);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void lblEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEstadoMouseClicked
        icon(lblEstado.getText());
    }//GEN-LAST:event_lblEstadoMouseClicked

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char c=evt.getKeyChar();         
        
        if(!Character.isLetter(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");        
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtNroPisoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroPisoKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isLetter(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");        
        }
    }//GEN-LAST:event_txtNroPisoKeyTyped

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
                
    }//GEN-LAST:event_formFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSave;
    public static javax.swing.JComboBox<String> cboLocal;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel lblEstado;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtNroPiso;
    // End of variables declaration//GEN-END:variables
}
