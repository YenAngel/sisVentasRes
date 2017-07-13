
package ventas.presentacion.Venta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventas.persistencia.util.BDData;
import ventas.presentacion.Mesas_Selection;
import ventas.presentacion.frmPrincipal;

public class frmCaja extends javax.swing.JFrame {

    Date d=new Date();
    public frmCaja() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        getLocal();
        dcActual.setDate(d);        
        cboEstado.setEnabled(false);
        cboLocal.setEnabled(false);
        dcActual.setEnabled(false);
        cboComprobante.setSelectedIndex(-1);
    }
    
    private void getLocal(){
        cboLocal.setModel(BDData.getLocal());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgDocumento = new javax.swing.ButtonGroup();
        lblHome = new javax.swing.JLabel();
        cboLocal = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboCliente = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboComprobante = new javax.swing.JComboBox<>();
        dcActual = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        txtCorrelativo = new javax.swing.JTextField();
        Codigo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        Codigo1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblHome1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setSize(new java.awt.Dimension(1025, 661));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/home.png"))); // NOI18N
        lblHome.setAlignmentX(20.0F);
        lblHome.setAlignmentY(20.0F);
        lblHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblHome.setIconTextGap(0);
        lblHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        getContentPane().add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(951, 5, -1, -1));

        cboLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocalActionPerformed(evt);
            }
        });
        getContentPane().add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 260, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Local:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, -1));

        cboCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUC", "DNI" }));
        cboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClienteActionPerformed(evt);
            }
        });
        getContentPane().add(cboCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 260, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nro Documento:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Estado:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 530, -1, -1));

        cboComprobante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Factura", "Boleta", "Ticket" }));
        cboComprobante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboComprobanteItemStateChanged(evt);
            }
        });
        cboComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboComprobanteActionPerformed(evt);
            }
        });
        getContentPane().add(cboComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 260, 50));

        dcActual.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(dcActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 650, 260, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Fecha de Emisión:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 620, -1, -1));

        txtSerie.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 260, 50));

        txtCorrelativo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtCorrelativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 260, 50));

        Codigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Codigo.setText("Tipo de Documento:");
        getContentPane().add(Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Serie:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Correlativo:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 360, 290));

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 260, 50));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 260, 50));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 260, 50));

        Codigo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Codigo1.setText("SubTotal:");
        getContentPane().add(Codigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("IGV:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Total:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        lblHome1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/notes.png"))); // NOI18N
        lblHome1.setText("Gestión de Ventas");
        lblHome1.setAlignmentX(30.0F);
        lblHome1.setAlignmentY(20.0F);
        lblHome1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblHome1.setIconTextGap(0);
        lblHome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHome1MouseClicked(evt);
            }
        });
        getContentPane().add(lblHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 11, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/get-money.png"))); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(100, 210));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, -1, 190));

        cboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(cboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 560, 260, 50));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 300, 310));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 300, 310));

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 260, 50));
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 260, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Cliente:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Documento:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        jButton1.setText("Validar Usuario");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 730, -1, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles de la Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 300, 310));

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles de Local", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 300, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        setVisible(false);
        Mesas_Selection mesas_Selection= new Mesas_Selection();
        mesas_Selection.setVisible(true);
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblHome1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHome1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblHome1MouseClicked

    private void cboLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLocalActionPerformed

    private void cboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboClienteActionPerformed

    private void cboComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboComprobanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboComprobanteActionPerformed

    private void cboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEstadoActionPerformed

    private void cboComprobanteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboComprobanteItemStateChanged
        ResultSet rs;
        String temp1,temp2;
        if (cboComprobante.getSelectedIndex()!=-1) {
            rs=BDData.getDatosDocumento(cboComprobante.getSelectedItem().toString());
            try {
                if (rs.next()) {
                    temp1=rs.getString(1);
                    temp2=rs.getString(2);                    
                    txtSerie.setText(rs.getString(1));
                    //txtCorrelativo.setText(rs.getString(2));
                    if (!txtSerie.equals("")) {
                        ResultSet rs1=BDData.getCorrelativo(temp1, temp2);
                        if (rs1.next()) {
                            int correlativo=Integer.parseInt(rs1.getString(1));
                            int tempSerie=Integer.parseInt(temp1);
                            int tempCorrelativo=Integer.parseInt(temp2);
                            if (tempCorrelativo<=correlativo) {
                                int value=correlativo+1;
                                int len=temp2.length();
                                int lenC=value+"".length();
                                StringBuffer buffer= new StringBuffer();
                                String[] cad=new String[len];
                                String[] cad1=new String[len];
                                for (int i = len-1; i >0 ; i--) {
                                    cad[i]=0+"";
                                    for (int j = 0; j < lenC; j++) {
                                        cad1[j]=value+"".substring(j, 1);
                                        cad[i]=cad1[j];
                                    }
                                }
                                txtCorrelativo.setText(buffer.toString());
                            }                            
                        }else{
                            int len=temp2.length();
                            StringBuffer buffer= new StringBuffer();
                            String[] cad=new String[len];
                            for (int i = 0; i < len; i++) {
                                if (len-1==i) {
                                    cad[len-1]=1+"";
                                    buffer.append(cad[i]);
                                }else{
                                    cad[i]=0+"";
                                    buffer.append(cad[i]);
                                }
                            }                                                        
                            txtCorrelativo.setText(buffer.toString());
                        }
                    }                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmCaja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }//GEN-LAST:event_cboComprobanteItemStateChanged

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Codigo;
    private javax.swing.JLabel Codigo1;
    private javax.swing.ButtonGroup bgDocumento;
    public static javax.swing.JComboBox<String> cboCliente;
    public static javax.swing.JComboBox<String> cboComprobante;
    public static javax.swing.JComboBox<String> cboEstado;
    public static javax.swing.JComboBox<String> cboLocal;
    private com.toedter.calendar.JDateChooser dcActual;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblHome1;
    public static javax.swing.JTextField txtCorrelativo;
    public static javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
