
package ventas.presentacion.Categoria;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import ventas.modelo.Categoria;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpNuevaCategoria extends javax.swing.JPanel {
    
    Categoria categoria =new Categoria();
    DefaultComboBoxModel dcbm;
    public jpNuevaCategoria() {
        initComponents();
        addItems();
        cboNivel.setSelectedIndex(-1);
        cboPadreCategoria.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboPadreCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboNivel = new javax.swing.JComboBox<>();

        cboPadreCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "RUC" }));

        jLabel5.setText("Nombre de Categoria:");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Add-icon.png")); // NOI18N
        jLabel8.setText("Nuevo Cliente");

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Home-icon.png")); // NOI18N
        jButton1.setText("Retornar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Check-icon.png")); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel2.setText("Nivel");

        jLabel4.setText("Categoria Superior:");

        cboNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Superior", "Intermedio", "Inferior" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPadreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 249, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(277, 277, 277))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPadreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jpListarCategoria listarCategoria=new jpListarCategoria();
        frmPrincipal.Comp(listarCategoria);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void addItems(){
        cboPadreCategoria.setModel(BDData.getCategoria());
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Login_User login_User= new Login_User();  
        int idx=cboPadreCategoria.getSelectedIndex();        
        categoria.setNo_categoria_plato(txtNombre.getText());        
        if ((idx +1)>0) {
            categoria.setNo_padre_categoria(cboPadreCategoria.getSelectedItem().toString());
        }               
        
        categoria.setNu_nivel(cboNivel.getSelectedIndex());
        categoria.setNo_categoria_plato(txtNombre.getText());
        categoria.setNid_usuario_crea(login_User.getNdi_usuario());
        if (BDData.nuevoCategoria(categoria)) {
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c=evt.getKeyChar(); 
        if(Character.isDigit(c)) { 
            getToolkit().beep(); 
            evt.consume();             
            JOptionPane.showMessageDialog(null, "Solo debe ingresar Letras");
        }
    }//GEN-LAST:event_txtNombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboNivel;
    private javax.swing.JComboBox<String> cboPadreCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
