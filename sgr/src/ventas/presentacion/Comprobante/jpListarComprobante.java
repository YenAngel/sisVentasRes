
package ventas.presentacion.Comprobante;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Comprobante;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpListarComprobante extends javax.swing.JPanel {
    
    Comprobante comprobante=new Comprobante();
    DefaultTableModel dtm;
    public jpListarComprobante() {
        initComponents();
        listarComprobante();
        cboComprobante.setSelectedIndex(-1);
        cboLocal.setModel(BDData.getLocal());
        cboLocal.setSelectedIndex(-1);
        confTBL(tblComprobante, dtm);
    }
    private DefaultTableModel formatearTabla(){
        String[] theader={"Local","Codigo","Serie","Correlativo"};
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(theader);        
        return  dtm;
    }
    public void confTBL(JTable jTable, DefaultTableModel model){
	DefaultTableCellRenderer centerRdr= new DefaultTableCellRenderer();
        centerRdr.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0;i<model.getColumnCount();i++){
            jTable.getColumnModel().getColumn(i).setCellRenderer(centerRdr);	
        }             
        for(int i=0;i<model.getRowCount();i++)
            jTable.setRowHeight(i,45);        
        jTable.setDefaultEditor(Object.class,null);
        jTable.getTableHeader().setReorderingAllowed(false);
        lblTotal1.setText(model.getRowCount()+"");         
    }
    private void listarComprobante(){
        tblComprobante.setModel(BDData.listarComprobante(formatearTabla()));
        for(int i = 0; i < tblComprobante.getRowCount(); i++)
            tblComprobante.setRowHeight(i, 45);
        tblComprobante.setDefaultEditor(Object.class, null);
        tblComprobante.getTableHeader().setReorderingAllowed(false);        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComprobante = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtSerie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboComprobante = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        txtCorrelativo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboLocal = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblTotal1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNew.setBackground(new java.awt.Color(153, 153, 255));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/new.png"))); // NOI18N
        btnNew.setText("Nuevo");
        btnNew.setPreferredSize(new java.awt.Dimension(150, 100));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 180, 70));

        btnEdit.setBackground(new java.awt.Color(153, 153, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit_user.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 180, 70));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblComprobante.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblComprobante);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 829, 310));

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSerie.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSerie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });
        jPanel1.add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 35, 79, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Serie:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 12, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Comprobante:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 12, -1, -1));

        cboComprobante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura", "Ticket" }));
        jPanel1.add(cboComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 35, 101, 50));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search_2.png"))); // NOI18N
        btnSearch.setPreferredSize(new java.awt.Dimension(130, 57));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 35, 60, 50));

        txtCorrelativo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCorrelativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCorrelativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorrelativoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCorrelativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 35, 90, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Correlativo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 12, -1, -1));

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 35, 144, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Local:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 15, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 640, 120));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));

        jLabel22.setBackground(new java.awt.Color(153, 153, 153));
        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Busqueda");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel5.setForeground(new java.awt.Color(204, 204, 204));

        jLabel21.setBackground(new java.awt.Color(153, 153, 153));
        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Listado");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel6.setForeground(new java.awt.Color(204, 204, 204));

        jLabel23.setBackground(new java.awt.Color(153, 153, 153));
        jLabel23.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Total de registros:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 540, -1, -1));

        jPanel8.setBackground(new java.awt.Color(248, 248, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel8.setForeground(new java.awt.Color(204, 204, 204));

        lblTotal1.setBackground(new java.awt.Color(153, 153, 153));
        lblTotal1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblTotal1.setForeground(new java.awt.Color(51, 51, 51));
        lblTotal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotal1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 540, 120, -1));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setText("MANTENIMIENTO COMPROBANTE");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, 38));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        jpNuevoComprobante comprobante=new jpNuevoComprobante();
        frmPrincipal.Comp(comprobante);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int idx=tblComprobante.getSelectedRow();
        if (idx!=-1) {            
            Comprobante comprobante=new Comprobante();
            Login_User login_User=new Login_User();
            jpEditarComprobante editarComprobante=new jpEditarComprobante();
            comprobante.setNo_local(dtm.getValueAt(idx, 0).toString());
            comprobante.setCo_comprobante(dtm.getValueAt(idx, 1).toString());
            comprobante.setNu_serie(dtm.getValueAt(idx, 2).toString());
            comprobante.setNu_correlativo(dtm.getValueAt(idx, 3).toString());
            comprobante.setNid_usuario_modi(login_User.getNdi_usuario());

            frmPrincipal.Comp(editarComprobante);
            editarComprobante.cargarComprobante(comprobante);        
        }else{
            JOptionPane.showMessageDialog(null, "Seleccionar el registro a eliminar");
        }        
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        char c=evt.getKeyChar();

        if(Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");
        }
    }//GEN-LAST:event_txtSerieKeyTyped

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtCorrelativo.getText().equals("") || txtSerie.getText().equals("") || cboComprobante.getSelectedIndex()==-1) {
            tblComprobante.setModel(BDData.listarComprobante(formatearTabla()));
            for(int i = 0; i < tblComprobante.getRowCount(); i++)
            tblComprobante.setRowHeight(i, 45);
            tblComprobante.setDefaultEditor(Object.class, null);
            tblComprobante.getTableHeader().setReorderingAllowed(false);        
        }else{
            comprobante.setNu_serie(txtSerie.getText());
            comprobante.setCo_comprobante(cboComprobante.getSelectedItem().toString());
            comprobante.setNu_correlativo(txtCorrelativo.getText());
            comprobante.setNo_local(cboLocal.getSelectedItem().toString());
            tblComprobante.setModel(BDData.obtenerComprobante(formatearTabla(), comprobante));            
        }
        confTBL(tblComprobante, dtm);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtCorrelativoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorrelativoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorrelativoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    public static javax.swing.JComboBox<String> cboComprobante;
    public static javax.swing.JComboBox<String> cboLocal;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal1;
    private javax.swing.JTable tblComprobante;
    public static javax.swing.JTextField txtCorrelativo;
    public static javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
