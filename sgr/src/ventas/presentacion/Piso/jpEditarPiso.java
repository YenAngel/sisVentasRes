
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
    }         
    
    private void cleanControls(){
        txtCodigo.setText("");
        cboLocal.setSelectedIndex(-1);
        txtNroPiso.setText("");    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNroPiso = new javax.swing.JTextField();
        cboLocal = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSave1 = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNroPiso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNroPiso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroPisoKeyTyped(evt);
            }
        });
        add(txtNroPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 137, 260, 50));

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 205, 260, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Local:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 222, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Numero de Piso:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 153, -1, -1));

        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 69, 260, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Id Piso:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 85, -1, -1));

        btnSave1.setBackground(new java.awt.Color(153, 153, 255));
        btnSave1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        btnSave1.setText("Guardar");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });
        add(btnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 150, -1));

        btnReturn.setBackground(new java.awt.Color(153, 153, 255));
        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo.png"))); // NOI18N
        btnReturn.setText("Cancelar");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 150, -1));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setText("EDITAR PISO");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, 38));
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        piso=new Piso();
        Login_User login=new Login_User();
        if (!txtNroPiso.getText().equals("") && cboLocal.getSelectedIndex()!=-1) {
            piso.setNid_piso(Integer.parseInt(txtCodigo.getText()));
            piso.setNu_piso(Integer.parseInt(txtNroPiso.getText()));
            piso.setNo_local(cboLocal.getSelectedItem().toString());
            piso.setNid_usuario_modi(login.getNdi_usuario());   
            if (BDData.editarPiso(piso)) {
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                cleanControls();
                jpListarPiso listarPiso=new jpListarPiso();
                frmPrincipal.Comp(listarPiso);
            }
        }else
            JOptionPane.showMessageDialog(null, "Completar los campos");      
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        jpListarPiso listarPiso=new jpListarPiso();
        frmPrincipal.Comp(listarPiso);
    }//GEN-LAST:event_btnReturnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave1;
    public static javax.swing.JComboBox<String> cboLocal;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtNroPiso;
    // End of variables declaration//GEN-END:variables
}
