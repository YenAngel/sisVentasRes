
package ventas.presentacion.Empresa;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ventas.modelo.Empresa;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import static ventas.presentacion.Empresa.jpEditarEmpresa.lblEstado;
import ventas.presentacion.frmPrincipal;

public class jpNuevaEmpresa extends javax.swing.JPanel {
    
    Login_User login_User=new Login_User();
    Empresa empresa= new Empresa();
    public jpNuevaEmpresa() {
        initComponents();
        icon("Inactivo");
        System.out.println();
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreC = new javax.swing.JTextField();
        txtruc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Add-icon.png")); // NOI18N
        jLabel8.setText("Nueva de Mesa");

        jLabel1.setText("Razón Social:");

        btnHome.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Home-icon.png")); // NOI18N
        btnHome.setText("Retornar");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnClean.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Arrow-reload-2-icon.png")); // NOI18N
        btnClean.setText("Limpiar");

        btnSave.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Check-icon.png")); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre Comercial:");

        jLabel5.setText("RUC:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(122, 122, 122))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(196, 196, 196))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(47, 47, 47)
                                .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        empresa.setNo_razon_social(txtRazonSocial.getText());
        empresa.setNo_comercial(txtNombreC.getText());
        empresa.setNu_ruc(txtruc.getText());
        empresa.setNo_estado(lblEstado.getText());

        empresa.setNid_usuario_crea(login_User.getNdi_usuario());
        if (BDData.nuevaEmpresa(empresa)) {
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        jpListarEmpresa listarEmpresa=new jpListarEmpresa();
        frmPrincipal.Comp(listarEmpresa);
    }//GEN-LAST:event_btnHomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JTextField txtNombreC;
    public javax.swing.JTextField txtRazonSocial;
    public javax.swing.JTextField txtruc;
    // End of variables declaration//GEN-END:variables
}
