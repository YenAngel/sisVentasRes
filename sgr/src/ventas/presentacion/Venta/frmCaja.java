
package ventas.presentacion.Venta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import ventas.persistencia.util.BDData;
import ventas.presentacion.Mesas_Selection;
import ventas.presentacion.frmPrincipal;

public class frmCaja extends javax.swing.JFrame {

    Date d=new Date();
    DefaultTableModel dtm;
    int height=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int width=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    public frmCaja() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        tblCaja.setModel(formatearTabla());
        cboComprobante.setSelectedIndex(-1);
        componentes();
        setLayout(null);
    }
   
    private void componentes(){       
        pnlCajaTitle.setLayout(null);
        pnlCajaTitle.setBounds(0, 0, width, 60);
        //pnlCajaTitle.setVisible(true);
    }
    private DefaultTableModel formatearTabla(){
        String[] theader={"Producto","Cantidad","Precio"};
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(theader);        
        return  dtm;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgDocumento = new javax.swing.ButtonGroup();
        cboCliente = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cboComprobante = new javax.swing.JComboBox<>();
        txtSerie = new javax.swing.JTextField();
        txtCorrelativo = new javax.swing.JTextField();
        Codigo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCaja = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        Codigo1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pnlCajaTitle = new javax.swing.JPanel();
        lblHome1 = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setSize(new java.awt.Dimension(1025, 661));

        cboCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUC", "DNI" }));
        cboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClienteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nro Documento:");

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

        txtSerie.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtCorrelativo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        Codigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Codigo.setText("Tipo de Documento:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Serie:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Correlativo:");

        tblCaja.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCaja);

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        Codigo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Codigo1.setText("SubTotal:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("IGV:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Total:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/get-money.png"))); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(100, 210));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Cliente:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Documento:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/view-task.png"))); // NOI18N
        jButton1.setText("<html>Validar Cliente</html>");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles de la Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        pnlCajaTitle.setBackground(new java.awt.Color(102, 153, 255));

        lblHome1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/notes.png"))); // NOI18N
        lblHome1.setText(" Gestión de Ventas");
        lblHome1.setAlignmentX(30.0F);
        lblHome1.setAlignmentY(20.0F);
        lblHome1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblHome1.setIconTextGap(0);
        lblHome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHome1MouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout pnlCajaTitleLayout = new javax.swing.GroupLayout(pnlCajaTitle);
        pnlCajaTitle.setLayout(pnlCajaTitleLayout);
        pnlCajaTitleLayout.setHorizontalGroup(
            pnlCajaTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCajaTitleLayout.createSequentialGroup()
                .addContainerGap(603, Short.MAX_VALUE)
                .addComponent(lblHome1)
                .addGap(187, 187, 187)
                .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlCajaTitleLayout.setVerticalGroup(
            pnlCajaTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCajaTitleLayout.createSequentialGroup()
                .addGroup(pnlCajaTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHome1)
                    .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/view-income-categories.png"))); // NOI18N
        jButton3.setMaximumSize(new java.awt.Dimension(64, 64));
        jButton3.setMinimumSize(new java.awt.Dimension(64, 64));
        jButton3.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCajaTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Codigo)
                                .addComponent(cboComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11)
                                .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(Codigo1)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10)))))
                    .addComponent(jScrollPane1))
                .addGap(98, 98, 98)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCajaTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(Codigo)
                                .addGap(13, 13, 13)
                                .addComponent(cboComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(txtCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel14)
                                .addGap(13, 13, 13)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(Codigo1))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel10))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(13, 13, 13)
                                        .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );

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

    private void cboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboClienteActionPerformed

    private void cboComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboComprobanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboComprobanteActionPerformed

    private void cboComprobanteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboComprobanteItemStateChanged
        /*ResultSet rs;
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
                        ResultSet rs1= BDData.getCorrelativo(temp1, temp2);
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
        }*/   
    }//GEN-LAST:event_cboComprobanteItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        frmCalculadora calculadora=new frmCalculadora();
        calculadora.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblHome1;
    private javax.swing.JPanel pnlCajaTitle;
    private javax.swing.JTable tblCaja;
    public static javax.swing.JTextField txtCorrelativo;
    public static javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
