
package ventas.presentacion.Venta;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import ventas.modelo.CajaLocal;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;

public class frmCerrarCaja extends javax.swing.JFrame {

    public String local;
    public String documento;
    public frmCerrarCaja() {
        setLocationRelativeTo(null);
        initComponents();
        txtCaja.setEnabled(false);
    }
    
    public void init(String vl_local){
        setLocationRelativeTo(null);
        loadCaja();
        local=vl_local;
        DecimalFormat df= new DecimalFormat("0.##");
        double apertura = Double.parseDouble(txtApertura.getText().replace("S/. ", ""));
        double ingresos = Double.parseDouble(txtIngresos.getText().replace("S/. ", ""));
        double egresos = Double.parseDouble(txtEgresos.getText().replace("S/. ", ""));
        //ResultSet rs=BDData.initDataCaja(vl_local);
        double total= apertura + ingresos - egresos;
         txtCaja.setText("S/. "+df.format(total));//,sustrayendo=0;
        /*try {
            if (rs.next()) {         
                total=rs.getDouble(1);
                sustrayendo=rs.getDouble(2);
            }            
            total-=sustrayendo;            
            txtCaja.setText("S/. "+df.format(total));
        } catch (Exception e) {
        }*/
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApertura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIngresos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEgresos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setFocusableWindowState(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(85, 142, 213));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(142, 214, 155));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CAJA  -  Cierre de caja");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/caja.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 420, -1));

        txtCaja.setEditable(false);
        txtCaja.setBackground(new java.awt.Color(255, 255, 255));
        txtCaja.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCaja.setForeground(new java.awt.Color(255, 0, 51));
        txtCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCajaActionPerformed(evt);
            }
        });
        jPanel3.add(txtCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 140, 30));

        jLabel1.setBackground(new java.awt.Color(185, 205, 229));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Fecha:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jPanel2.setBackground(new java.awt.Color(185, 205, 229));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/grabar.png"))); // NOI18N
        jLabel8.setText("Grabar");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/anular.png"))); // NOI18N
        jLabel9.setText("Cancelar");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel9)
                .addGap(114, 114, 114))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 410, 80));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 140, 30));

        jLabel4.setBackground(new java.awt.Color(185, 205, 229));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Total cierre:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        txtApertura.setEditable(false);
        txtApertura.setBackground(new java.awt.Color(255, 255, 255));
        txtApertura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtApertura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 140, 30));

        jLabel5.setBackground(new java.awt.Color(185, 205, 229));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Apertura:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        txtIngresos.setEditable(false);
        txtIngresos.setBackground(new java.awt.Color(255, 255, 255));
        txtIngresos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtIngresos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 140, 30));

        jLabel6.setBackground(new java.awt.Color(185, 205, 229));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ingresos:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        txtEgresos.setEditable(false);
        txtEgresos.setBackground(new java.awt.Color(255, 255, 255));
        txtEgresos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtEgresos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtEgresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 140, 30));

        jLabel7.setBackground(new java.awt.Color(185, 205, 229));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Egresos:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 409, 424));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCajaActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        double totalCaja=Double.parseDouble((txtCaja.getText().replace("S/. ", "")).replace(",", "."));
        CajaLocal cl=new CajaLocal();
        cl.setVi_no_local(local);
        cl.setVi_mt_importe(totalCaja);
        cl.setVi_nu_persona(documento);
        int value = JOptionPane.showConfirmDialog(null, "Desea cerrar caja","Warning",JOptionPane.YES_NO_OPTION);            
        if(value == 0){
            if (BDData.closeCaja(cl)) {
                JOptionPane.showMessageDialog(null, "Caja ha sido cerrada");
            }else
                JOptionPane.showMessageDialog(null, "Error: No pudo realizar esta operación");
            init(local);
            this.setVisible(false);
        }    
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        setVisible(false);
    }//GEN-LAST:event_jLabel9MouseClicked
    public void loadCaja(){
        Login_User lu=new Login_User();
        DecimalFormat df= new DecimalFormat("0.##");
        ResultSet rs=BDData.initDataCaja(lu.getSurcursal());
        double total=0,sustrayendo=0,apertura=0;
        
        try {
            if (rs.next()) {         
                total=rs.getDouble(1);
                sustrayendo=rs.getDouble(2);
                apertura=rs.getDouble(3);                
            }
            total=total>0?total:0;
            sustrayendo=sustrayendo>0?sustrayendo:0;
            apertura=apertura>0?apertura:0;
            total-=sustrayendo;
            txtIngresos.setText("S/. "+df.format(total));
            txtEgresos.setText("S/. "+df.format(sustrayendo));
            txtApertura.setText("S/. "+df.format(apertura));
        } catch (Exception e) {
        }
    };
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCerrarCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCerrarCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCerrarCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCerrarCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCerrarCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtApertura;
    private javax.swing.JTextField txtCaja;
    private javax.swing.JTextField txtEgresos;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIngresos;
    // End of variables declaration//GEN-END:variables
}
