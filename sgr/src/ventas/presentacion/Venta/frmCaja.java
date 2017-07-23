
package ventas.presentacion.Venta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Caja;
import ventas.modelo.Cliente;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.Mesas_Selection;
import ventas.presentacion.Mesas_Selection1;
import ventas.presentacion.frmPrincipal;

public class frmCaja extends javax.swing.JFrame {
    
    Thread thr1;
    Login_User login_User=new Login_User();
    Date d=new Date();
    DefaultTableModel dtm;
    Caja caja=new Caja();
    Cliente cliente= new Cliente();
    public static int nroPiso;
    public static int nroMesa;
    int height=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int width=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;               
    public frmCaja() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        tblCaja.setModel(formatearTabla());
        cboComprobante.setSelectedIndex(-1);
        componentes();
        setLayout(null);
        lblUser.setText(login_User.surcursal);   
        getNow();
        cboDocumento.setSelectedIndex(-1);
        jLabel16.setVisible(false);
        jLabel17.setVisible(false);
        txtApeMaterno.setVisible(false);
        txtApePaterno.setVisible(false);
    }
    public void getMesa(MouseEvent event){
        String mesaString=event.toString().substring(event.toString().indexOf("on #")+4, event.toString().indexOf("$"));        
        int mesa=Integer.parseInt(mesaString);        
        nroMesa=mesa;
    }    
    public void getpiso(int piso){        
        nroPiso=piso;
    }
    private void componentes(){       
        pnlCajaTitle.setLayout(null);
        pnlCajaTitle.setBounds(0, 0, width, 60);
        //pnlCajaTitle.setVisible(true);
    }
    private DefaultTableModel formatearTabla(){
        String[] theader={"id pedido","Producto","Cantidad","Precio"};
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(theader);        
        return  dtm;
    }
    public void cargarListaPedido(int piso, int mesa){
        caja.setNo_local(lblUser.getText());                
        caja.setNu_mesa(mesa);
        caja.setNu_piso(piso);
        tblCaja.setModel(BDData.getListaCaja(dtm, caja));      
        confTBL(tblCaja, dtm);
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
        jTable.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable.getColumnModel().getColumn(0).setMinWidth(0);        
        jTable.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTable.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);  
    }
    private double getTotal(DefaultTableModel model){
        double count=0;
        double value=0;
        for (int i = 0; i < model.getRowCount(); i++) {
            value=Double.parseDouble(model.getValueAt(i, 3).toString());
            count+=value;
        }
        return count;
    }
    private void getNow(){
        SimpleDateFormat hFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyy");
        javax.swing.Timer timer = new javax.swing.Timer (1000, new ActionListener () 
        { 
            public void actionPerformed(ActionEvent e) 
            {   
                String hora = hFormat.format(Time.valueOf(LocalTime.now())).toString();
                String fecha = dFormat.format(java.sql.Date.valueOf(LocalDate.now())).toString();
                lblHour.setText(fecha + "  -  " + hora);
             }
        }); 
        timer.start();
        
    }
    private boolean documentoValid(){
        if (txtDocumento.getText().length()==8 || txtDocumento.getText().length()==11) {
            return true;
        }else
            return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgDocumento = new javax.swing.ButtonGroup();
        bgCliente = new javax.swing.ButtonGroup();
        cboDocumento = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cboComprobante = new javax.swing.JComboBox<>();
        txtSerie = new javax.swing.JTextField();
        txtCorrelativo = new javax.swing.JTextField();
        Codigo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCaja = new javax.swing.JTable();
        txtCliente = new javax.swing.JTextField();
        txtIGV = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        Codigo1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblGroupCliente = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnValid = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pnlCajaTitle = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        lblHome2 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblHour = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtApePaterno = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtApeMaterno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setSize(new java.awt.Dimension(1025, 661));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboDocumento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUC", "DNI" }));
        cboDocumento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboDocumentoItemStateChanged(evt);
            }
        });
        cboDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDocumentoActionPerformed(evt);
            }
        });
        getContentPane().add(cboDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 170, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nro Documento:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 197, -1, -1));

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

        jScrollPane1.setBorder(new javax.swing.border.MatteBorder(null));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 500, 290));

        txtCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCliente.setAutoscrolls(false);
        getContentPane().add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 315, 260, 50));

        txtIGV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtIGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 260, 50));

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 260, 50));

        Codigo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Codigo1.setText("SubTotal:");
        getContentPane().add(Codigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("IGV:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Total:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/get-money.png"))); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(100, 210));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, 290));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 300, 310));

        lblGroupCliente.setBackground(new java.awt.Color(255, 255, 255));
        lblGroupCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGroupCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        getContentPane().add(lblGroupCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 300, 490));

        txtDocumento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });
        getContentPane().add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 227, 260, 50));

        txtSubTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 260, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Cliente:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 288, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Documento:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, -1, -1));

        btnValid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnValid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/view-task.png"))); // NOI18N
        btnValid.setText("<html>Validar Cliente</html>");
        btnValid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnValid.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnValid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidActionPerformed(evt);
            }
        });
        getContentPane().add(btnValid, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 80, 100));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles de la Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 300, 310));

        pnlCajaTitle.setBackground(new java.awt.Color(102, 153, 255));

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblUser.setText(" Gestión de Ventas");
        lblUser.setAlignmentX(30.0F);
        lblUser.setAlignmentY(20.0F);
        lblUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblUser.setIconTextGap(0);
        lblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserMouseClicked(evt);
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

        lblHome2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHome2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/notes.png"))); // NOI18N
        lblHome2.setText("Caja");
        lblHome2.setAlignmentX(30.0F);
        lblHome2.setAlignmentY(20.0F);
        lblHome2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblHome2.setIconTextGap(0);
        lblHome2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHome2MouseClicked(evt);
            }
        });

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/DateTime.png"))); // NOI18N
        lblDate.setAlignmentX(30.0F);
        lblDate.setAlignmentY(20.0F);
        lblDate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblDate.setIconTextGap(0);
        lblDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDateMouseClicked(evt);
            }
        });

        lblHour.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHour.setAlignmentX(30.0F);
        lblHour.setAlignmentY(20.0F);
        lblHour.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblHour.setIconTextGap(0);
        lblHour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHourMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlCajaTitleLayout = new javax.swing.GroupLayout(pnlCajaTitle);
        pnlCajaTitle.setLayout(pnlCajaTitleLayout);
        pnlCajaTitleLayout.setHorizontalGroup(
            pnlCajaTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCajaTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser)
                .addGap(47, 47, 47)
                .addComponent(lblDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHour, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(lblHome2)
                .addGap(74, 74, 74)
                .addComponent(lblHome)
                .addContainerGap())
        );
        pnlCajaTitleLayout.setVerticalGroup(
            pnlCajaTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCajaTitleLayout.createSequentialGroup()
                .addComponent(lblHome2)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(pnlCajaTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCajaTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCajaTitleLayout.createSequentialGroup()
                .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlCajaTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/view-income-categories.png"))); // NOI18N
        jButton3.setMaximumSize(new java.awt.Dimension(64, 64));
        jButton3.setMinimumSize(new java.awt.Dimension(64, 64));
        jButton3.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 610, -1, 63));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Apellido Paterno:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, -1, -1));

        txtApePaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtApePaterno.setAutoscrolls(false);
        getContentPane().add(txtApePaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 260, 50));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Apellido Materno:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, -1, -1));

        txtApeMaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtApeMaterno.setAutoscrolls(false);
        getContentPane().add(txtApeMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, 260, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Herramientas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, 300, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        setVisible(false);
        Mesas_Selection1 mesas_Selection= new Mesas_Selection1();
        mesas_Selection.setVisible(true);
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUserMouseClicked

    private void cboDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDocumentoActionPerformed

    private void cboComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboComprobanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboComprobanteActionPerformed

    private void cboComprobanteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboComprobanteItemStateChanged
        ResultSet rs;
        String temp1,temp2;
        double subtotal=0;
        double igv=0;
        double total=0;
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
        }   
        if (cboComprobante.getSelectedIndex()==0) {
            subtotal=getTotal(dtm);
            igv=subtotal*0.18;
            total=igv+subtotal;            
            txtSubTotal.setText(subtotal+"");
            txtIGV.setText(igv+"");
            txtTotal.setText(total+"");
            txtIGV.setVisible(true);
            txtTotal.setVisible(true);
            txtSubTotal.setVisible(true);
            jLabel13.setVisible(true);
            jLabel14.setVisible(true);
            Codigo1.setVisible(true);
            jLabel3.setVisible(true);
            
            jLabel14.setBounds(350, 290, 60, 30);
            txtTotal.setBounds(350, 320, 260, 50);
        }
        if (cboComprobante.getSelectedIndex()==1 || cboComprobante.getSelectedIndex()==2) {
            subtotal=getTotal(dtm);
            txtTotal.setText(subtotal+"");
            
            jLabel14.setBounds(350, 190, 60, 30);
            txtTotal.setBounds(350, 230, 260, 50);
                        
            txtIGV.setVisible(false);
            txtSubTotal.setVisible(false);
            jLabel13.setVisible(false);
            Codigo1.setVisible(false);
            txtTotal.setVisible(true);
            jLabel3.setVisible(true);
            jLabel14.setVisible(true);
        }
                
    }//GEN-LAST:event_cboComprobanteItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        frmCalculadora calculadora=new frmCalculadora();
        calculadora.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void lblHome2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHome2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblHome2MouseClicked

    private void lblDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblDateMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //DateFormat hour= new SimpleDateFormat("HH:mm:ss");
        //DateFormat now= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //lblDate.setText(now.format(d));
             
    }//GEN-LAST:event_formWindowActivated

    private void lblHourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHourMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblHourMouseClicked

    private void cboDocumentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboDocumentoItemStateChanged
        if (cboDocumento.getSelectedIndex()==1) {
            lblGroupCliente.setBounds(640, 80, 300, 490);
            jLabel16.setVisible(true);
            jLabel17.setVisible(true);
            txtApeMaterno.setVisible(true);
            txtApePaterno.setVisible(true);
        }else{
            lblGroupCliente.setBounds(640, 80, 300, 310);
            jLabel16.setVisible(false);
            jLabel17.setVisible(false);
            txtApeMaterno.setVisible(false);
            txtApePaterno.setVisible(false);
        }
    }//GEN-LAST:event_cboDocumentoItemStateChanged

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed

    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void btnValidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidActionPerformed
        String temp=txtDocumento.getText();
        if (!documentoValid()) {
            if (temp.length()==9) {
                txtDocumento.setText(temp.substring(0, 8));
            }
            if (temp.length()==10) {
                txtDocumento.setText(temp.substring(0, 8));
            }
            if (temp.length()>11) {
                txtDocumento.setText(temp.substring(0, 10));
            }
            JOptionPane.showMessageDialog(rootPane, "Recuerde que el ruc contiene 11 digitos y dni tiene 8.");   
        }else{          
            if (cboDocumento.getSelectedIndex()!=-1 && !txtDocumento.equals("")) {
                cliente.setCo_tipo_documento(cboDocumento.getSelectedItem().toString());
                cliente.setNu_documento(txtDocumento.getText());            
                cliente.setNo_cliente(txtCliente.getText());
                cliente.setNo_ape_paterno(txtApePaterno.getText());
                cliente.setNo_ape_materno(txtApeMaterno.getText());
                ResultSet rs=BDData.obtenerClienteFact(cliente);                
                try {
                    if(rs.next()) {
                        txtCliente.setText(rs.getString(1));
                        txtApePaterno.setText(rs.getString(2));
                        txtApeMaterno.setText(rs.getString(3));
                    }
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_btnValidActionPerformed

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
    private javax.swing.ButtonGroup bgCliente;
    private javax.swing.ButtonGroup bgDocumento;
    private javax.swing.JButton btnValid;
    public static javax.swing.JComboBox<String> cboComprobante;
    public static javax.swing.JComboBox<String> cboDocumento;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblGroupCliente;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblHome2;
    private javax.swing.JLabel lblHour;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlCajaTitle;
    private javax.swing.JTable tblCaja;
    private javax.swing.JTextField txtApeMaterno;
    private javax.swing.JTextField txtApePaterno;
    private javax.swing.JTextField txtCliente;
    public static javax.swing.JTextField txtCorrelativo;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtIGV;
    public static javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
