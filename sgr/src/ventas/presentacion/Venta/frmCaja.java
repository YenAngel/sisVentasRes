
package ventas.presentacion.Venta;

import ventas.presentacion.Mesas_Selection;
import ventas.presentacion.frmPrincipal;

public class frmCaja extends javax.swing.JFrame {

    public frmCaja() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHome = new javax.swing.JLabel();
        cboLocal = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboCliente = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 768));
        setMinimumSize(new java.awt.Dimension(1200, 768));
        setPreferredSize(new java.awt.Dimension(1200, 768));
        setSize(new java.awt.Dimension(1200, 768));
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
        getContentPane().add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1098, 11, -1, -1));

        getContentPane().add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 93, 260, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Local:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 108, -1, -1));

        getContentPane().add(cboCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 161, 260, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Cliente:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 176, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Estado:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 244, -1, -1));

        getContentPane().add(cboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 229, 260, 50));

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 297, 260, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Fecha de Emisión:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 310, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 365, 260, 50));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 433, 260, 50));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 501, 260, 50));

        Codigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Codigo.setText("Codigo:");
        getContentPane().add(Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 380, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Serie:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 448, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Correlativo:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 516, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 93, -1, 254));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 365, 260, 50));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 433, 260, 50));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 501, 260, 50));

        Codigo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Codigo1.setText("SubTotal:");
        getContentPane().add(Codigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 380, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("IGV:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 448, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Total:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 516, -1, -1));

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
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 360, -1, 190));

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
    private javax.swing.JLabel Codigo;
    private javax.swing.JLabel Codigo1;
    public static javax.swing.JComboBox<String> cboCliente;
    public static javax.swing.JComboBox<String> cboEstado;
    public static javax.swing.JComboBox<String> cboLocal;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblHome1;
    // End of variables declaration//GEN-END:variables
}
