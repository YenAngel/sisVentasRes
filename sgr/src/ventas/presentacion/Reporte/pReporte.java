
package ventas.presentacion.Reporte;

import java.awt.Component;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import ventas.persistencia.util.BDData;


public class pReporte extends javax.swing.JPanel {
    DefaultTableModel dtm;
    DefaultComboBoxModel dcbm=BDData.getLocal();
    DefaultComboBoxModel dcomb = new DefaultComboBoxModel();
    DefaultComboBoxModel concepto = new DefaultComboBoxModel();
    DefaultComboBoxModel medioP = new DefaultComboBoxModel();
    
    public pReporte() {
        initComponents();
        dcFechaInicio.setDate(Date.valueOf(LocalDate.now()));
        dcFechaFin.setDate(Date.valueOf(LocalDate.now()));
        dcomb.addElement("Todos");
        dcomb.addElement("Factura");
        dcomb.addElement("Boleta");
        dcomb.addElement("Ticket");
        dcomb.addElement("Otros");
        cboTipoDoc.setModel(dcomb);
        concepto.addElement("Todos");
        concepto.addElement("Caja");
        concepto.addElement("Venta");
        concepto.addElement("Gastos");
        cboConcepto.setModel(concepto);
        medioP.addElement("Todos");
        medioP.addElement("Efectivo");
        medioP.addElement("Debito");
        medioP.addElement("Credito");
        cboMedioPago.setModel(medioP);
        cboLocal.setModel(dcbm);
        dcbm.addElement("Todos");
        cboLocal.setSelectedIndex(cboLocal.getItemCount()-1);
        tblPlatoLocal.setModel(formatearTabla());        
        confTBL(tblPlatoLocal, dtm);
        
    }
    public void confTBL(JTable jTable, DefaultTableModel model){
	DefaultTableCellRenderer centerRdr= new DefaultTableCellRenderer();
        centerRdr.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0;i<model.getColumnCount();i++){
            jTable.getColumnModel().getColumn(i).setCellRenderer(centerRdr);	
        }
        for(int i=0;i<model.getRowCount();i++){
            jTable.setRowHeight(i,45);
            //jTable.setRo(i,45);
        }
        
        TableColumnModel columnModel = jTable.getColumnModel();
        jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
        for (int column = 0; column < jTable.getColumnCount(); column++) {
            /*int width = 50; // Min width
            for (int row = 0; row < jTable.getRowCount(); row++) {
                TableCellRenderer renderer = jTable.getCellRenderer(row, column);
                Component comp = jTable.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;*/
//            columnModel.getColumn(column).setPreferredWidth(600);
            if (column==0 || column==8 || column==7) {
                columnModel.getColumn(column).setMaxWidth(250);
                columnModel.getColumn(column).setMinWidth(250);
            }
            if (column==2 || column==3 || column==6) {
                columnModel.getColumn(column).setMaxWidth(180);
                columnModel.getColumn(column).setMinWidth(180);
            }
            
        }
        jTable.setDefaultEditor(Object.class,null);
        jTable.getTableHeader().setReorderingAllowed(false);        
        lblTotal.setText(model.getRowCount()+"");         
    }
    private DefaultTableModel formatearTabla(){
        String[] theader={"Local", "Operación", "Medio de Pago", "Comprobante", "Numeración", "Importe", "Fecha de Emisión", "Concepto","Cliente", "Usuario"};
        dtm = new DefaultTableModel();
        
        dtm.setColumnIdentifiers(theader);        
        return  dtm;
    }    
    private void init(){
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");   
        String temp =sdf.format(dcFechaInicio.getDate());
        String tempf =sdf.format(dcFechaFin.getDate());
        tblPlatoLocal.setModel(BDData.ReporteCaja(formatearTabla(), cboLocal.getSelectedItem().toString(), temp,tempf,cboConcepto.getSelectedItem().toString(),cboMedioPago.getSelectedItem().toString(),cboTipoDoc.getSelectedItem().toString()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboLocal = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        dcFechaInicio = new com.toedter.calendar.JDateChooser();
        btnSearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboConcepto = new javax.swing.JComboBox<>();
        cboTipoDoc = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cboMedioPago = new javax.swing.JComboBox<>();
        dcFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlatoLocal = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Local:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, -1, -1));

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 35, 171, 31));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fecha Inicio:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 79, -1, -1));

        dcFechaInicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(dcFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 106, 161, 34));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search_caja.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.setPreferredSize(new java.awt.Dimension(130, 57));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 130, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tipo Documento:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 79, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Concepto:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 12, -1, -1));
        jPanel1.add(cboConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 35, 161, 31));
        jPanel1.add(cboTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 106, 171, 34));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Medio Pago:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 12, -1, -1));
        jPanel1.add(cboMedioPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 35, 161, 33));

        dcFechaFin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(dcFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 106, 161, 34));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Fecha Fin:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 79, -1, -1));

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/settings_reset.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 130, 40));

        btnGenerar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/excel.png"))); // NOI18N
        btnGenerar.setText("Generar");
        jPanel1.add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 130, 40));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 960, 160));

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
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 120, -1));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel16.setText("Reporte Caja");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, -1, 38));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblPlatoLocal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPlatoLocal);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 960, 310));

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

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 130, -1));

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
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(709, 610, 181, 30));

        jPanel8.setBackground(new java.awt.Color(248, 248, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel8.setForeground(new java.awt.Color(204, 204, 204));

        lblTotal.setBackground(new java.awt.Color(153, 153, 153));
        lblTotal.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(51, 51, 51));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(889, 610, 101, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        init();
        confTBL(tblPlatoLocal, dtm);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cboLocal.setSelectedIndex(cboLocal.getItemCount()-1);
        cboConcepto.setSelectedIndex(0);
        cboMedioPago.setSelectedIndex(0);
        cboTipoDoc.setSelectedIndex(0);
        dcFechaInicio.setDate(Date.valueOf(LocalDate.now()));
        dcFechaFin.setDate(Date.valueOf(LocalDate.now()));
        tblPlatoLocal.setModel(formatearTabla());
        confTBL(tblPlatoLocal, dtm);
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboConcepto;
    public static javax.swing.JComboBox<String> cboLocal;
    private javax.swing.JComboBox<String> cboMedioPago;
    private javax.swing.JComboBox<String> cboTipoDoc;
    private com.toedter.calendar.JDateChooser dcFechaFin;
    private com.toedter.calendar.JDateChooser dcFechaInicio;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblPlatoLocal;
    // End of variables declaration//GEN-END:variables

}
