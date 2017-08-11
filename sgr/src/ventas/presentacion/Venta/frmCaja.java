
package ventas.presentacion.Venta;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Caja;
import ventas.modelo.CajaLocal;
import ventas.modelo.Cliente;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.persistencia.util.BDUtil;
import ventas.persistencia.util.Usuario;
import ventas.presentacion.Mesas_Selection;
import ventas.presentacion.Mesas_Selection1;
import ventas.presentacion.frmPrincipal;

public class frmCaja extends javax.swing.JFrame {
    
    Thread thr1;
    Login_User login_User=new Login_User();
    Date d=new Date();
    DefaultTableModel dtm;
    Caja caja=new Caja();
    Vector<String> vec=new Vector<String>();
    Cliente cliente= new Cliente();
    Usuario usuario=new Usuario();
    public static int nroPiso;
    public static int nroMesa;
    public static String documento;
    public static int idx=-1;
    int height=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int width=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;               
    public frmCaja(){
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        tblCaja.setModel(formatearTabla());
        cboComprobante.setSelectedIndex(-1);
        componentes();
        setLayout(null);
        txtCLocal.setText(login_User.surcursal);
        //lblLocal.setText(login_User.surcursal);   
        getNow();
        cboDocumento.setSelectedIndex(-1);     
        String local=txtCLocal.getText();
        getUsuario(documento, local);
        init();
    }
    public void init(){        
       /* DecimalFormat df= new DecimalFormat("0.##");
        ResultSet rs=BDData.initDataCaja(lblLocal.getText());
        double total=0,sustrayendo=0,apertura=0;
        try {
            if (rs.next()) {         
                total=rs.getDouble(1)==0.0?0:rs.getDouble(1);
                sustrayendo=rs.getDouble(2)==0.0?0:rs.getDouble(2);
                apertura=rs.getDouble(3)==0.0?0:rs.getDouble(3);
            }            
            total-=sustrayendo;            
            lblMontoActual.setText("S/. "+df.format(total));
            lblMontoRetirado.setText("S/. "+df.format(sustrayendo));
            lblMontoRetirado.setText("S/. "+df.format(apertura));
        } catch (Exception e) {
        }*/
    }
    public void getUsuario(String documento, String local){        
        ResultSet rs = BDData.getUserCajaValid(documento, local);
        try {
            if (rs.next()) {                
                usuario.setId(rs.getInt(1));
                usuario.setIdLocal(rs.getInt(2));
            }
        } catch (Exception e) {
        }       
    }
    public void getMesa(MouseEvent event){
        String mesaString=event.toString().substring(event.toString().indexOf("on #")+4, event.toString().indexOf("$"));        
        int mesa=Integer.parseInt(mesaString);        
        nroMesa=mesa;
        txtCMesa.setText(mesa+"");
    }    
    public void getpiso(int piso){        
        nroPiso=piso;
        txtCPiso.setText(piso+"");
    }
    private void componentes(){               
        //pnlCajaTitle.setVisible(true);
    }
    private DefaultTableModel formatearTabla(){
        String[] theader={"id pedido","Producto","Cantidad","Precio"};
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(theader);        
        return  dtm;
    }
    public void cargarListaPedido(int piso, int mesa){
        String local=txtCLocal.getText();
        caja.setNo_local(local);            
        caja.setNu_mesa(mesa);
        caja.setNu_piso(piso);
        txtCMesa.setText(mesa+"");
        txtCPiso.setText(piso+"");
        tblCaja.setModel(BDData.getListaCaja(formatearTabla(), caja));      
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
        if (dtm.getRowCount()==0) {
            btnSaveSale.setEnabled(false);
            btnPrint.setEnabled(false);
            btnValid.setEnabled(false);
            cboComprobante.setEnabled(false);
            cboDocumento.setEnabled(false);
        }else{
            btnSaveSale.setEnabled(true);
            btnPrint.setEnabled(true);
            btnValid.setEnabled(true);
            cboComprobante.setEnabled(true);
            cboDocumento.setEnabled(true);
        }       
        String nroPedido=model.getValueAt(0, 0).toString();
        if (nroPedido!=null) {                       
            StringBuffer sb=new StringBuffer();
            String[] nroPedidoArray= new String[10];
            for (int i = 0; i < 10; i++) {
                if (i<nroPedido.length()) {              
                   nroPedidoArray[i]=nroPedido.substring(i,i+1);
                }else
                    nroPedidoArray[i]="0";            
            }
            for (int j = 9; j >=0; j--) {                
                sb.append(nroPedidoArray[j]);
            }
            txtCNroPedido.setText(sb.toString());
        }
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
                txtCDate.setText("Fecha : "+ fecha);
                //lblHour.setText(fecha + "  -  " + hora);
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
    
    private void obtenerNumber(ActionEvent e){        
        StringBuffer sb=new  StringBuffer();
        DecimalFormat df=new DecimalFormat("0.##");
        String number=e.toString().substring(e.toString().indexOf("text=")+5,e.toString().length()-21);
        vec.add(number);        
        for (int i = 0; i < vec.size(); i++) {
            sb.append(vec.get(i));
        }
        txtMontoIngresado.setText(sb.toString());       
        double montoIngresado=Double.parseDouble(txtMontoIngresado.getText());
        double montoTotal=Double.parseDouble(txtTotalPagar.getText().replace("S/ ", ""));
        double vuelto=montoIngresado-montoTotal;
        System.out.println(vuelto);
        txtVuelto.setText("S/ "+df.format(vuelto).replace(",", "."));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgDocumento = new javax.swing.ButtonGroup();
        bgCliente = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtCDate = new javax.swing.JTextField();
        txtCLocal = new javax.swing.JTextField();
        txtCPiso = new javax.swing.JTextField();
        txtCMesa = new javax.swing.JTextField();
        txtCNroPedido = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCaja = new javax.swing.JTable();
        txtApeMaterno = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtApePaterno = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cboDocumento = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        txtDocumento = new javax.swing.JTextField();
        btnValid = new javax.swing.JButton();
        txtTDCorrelativos = new javax.swing.JTextField();
        Codigo = new javax.swing.JLabel();
        txtTDSerie = new javax.swing.JTextField();
        cboComprobante = new javax.swing.JComboBox<>();
        Codigo2 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        btn6 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        txtVuelto = new javax.swing.JTextField();
        txtTotalPagar = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMontoIngresado = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTotal = new javax.swing.JLabel();
        lblIGV = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnSaveSale = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setSize(new java.awt.Dimension(1025, 661));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 222, 222));

        txtCDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCDate.setEnabled(false);

        txtCLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCLocal.setEnabled(false);

        txtCPiso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCPiso.setEnabled(false);

        txtCMesa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCMesa.setEnabled(false);

        txtCNroPedido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCNroPedido.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCNroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCDate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCNroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 960, -1));

        jPanel2.setBackground(new java.awt.Color(204, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, 440, 320));

        txtApeMaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtApeMaterno.setAutoscrolls(false);
        jPanel2.add(txtApeMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 189, 137, 50));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Apellido Materno:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 159, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Apellido Paterno:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(617, 159, -1, -1));

        txtApePaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtApePaterno.setAutoscrolls(false);
        jPanel2.add(txtApePaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(617, 189, 160, 50));

        txtCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCliente.setAutoscrolls(false);
        jPanel2.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 189, 130, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Cliente:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 159, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Documento:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 119, -1, -1));

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
        jPanel2.add(cboDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(566, 102, 70, 50));

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField2.setText("Nro Doc.");
        jTextField2.setEnabled(false);
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 100, 100, 50));

        txtDocumento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });
        jPanel2.add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 99, 120, 50));

        btnValid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnValid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/view-task.png"))); // NOI18N
        btnValid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnValid.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnValid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidActionPerformed(evt);
            }
        });
        jPanel2.add(btnValid, new org.netbeans.lib.awtextra.AbsoluteConstraints(874, 99, 50, 50));

        txtTDCorrelativos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTDCorrelativos.setEnabled(false);
        jPanel2.add(txtTDCorrelativos, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 140, 50));

        Codigo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Codigo.setText("-");
        jPanel2.add(Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, -1, 20));

        txtTDSerie.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTDSerie.setEnabled(false);
        txtTDSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTDSerieActionPerformed(evt);
            }
        });
        jPanel2.add(txtTDSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(617, 41, 140, 50));

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
        jPanel2.add(cboComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 40, 140, 50));

        Codigo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Codigo2.setText("Tipo de Documento:");
        jPanel2.add(Codigo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 14, -1, 20));

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField7.setText("Tipo de Pago");
        jTextField7.setEnabled(false);
        jPanel2.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 250, 110, 54));

        btn6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn6.setText("6");
        btn6.setMaximumSize(new java.awt.Dimension(54, 54));
        btn6.setMinimumSize(new java.awt.Dimension(54, 54));
        btn6.setPreferredSize(new java.awt.Dimension(54, 54));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel2.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 310, -1, -1));

        btn3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn3.setText("3");
        btn3.setMaximumSize(new java.awt.Dimension(54, 54));
        btn3.setMinimumSize(new java.awt.Dimension(54, 54));
        btn3.setPreferredSize(new java.awt.Dimension(54, 54));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel2.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 250, -1, -1));

        btn2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn2.setText("2");
        btn2.setMaximumSize(new java.awt.Dimension(54, 54));
        btn2.setMinimumSize(new java.awt.Dimension(54, 54));
        btn2.setPreferredSize(new java.awt.Dimension(54, 54));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel2.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 250, -1, -1));

        btn5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn5.setText("5");
        btn5.setMaximumSize(new java.awt.Dimension(54, 54));
        btn5.setMinimumSize(new java.awt.Dimension(54, 54));
        btn5.setPreferredSize(new java.awt.Dimension(54, 54));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel2.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 310, -1, -1));

        btn4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn4.setText("4");
        btn4.setMaximumSize(new java.awt.Dimension(54, 54));
        btn4.setMinimumSize(new java.awt.Dimension(54, 54));
        btn4.setPreferredSize(new java.awt.Dimension(54, 54));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel2.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 310, -1, -1));

        btn1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn1.setText("1");
        btn1.setMaximumSize(new java.awt.Dimension(54, 54));
        btn1.setMinimumSize(new java.awt.Dimension(54, 54));
        btn1.setPreferredSize(new java.awt.Dimension(54, 54));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 250, -1, -1));

        btn7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn7.setText("7");
        btn7.setMaximumSize(new java.awt.Dimension(54, 54));
        btn7.setMinimumSize(new java.awt.Dimension(54, 54));
        btn7.setPreferredSize(new java.awt.Dimension(54, 54));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel2.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 376, -1, -1));

        btn8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn8.setText("8");
        btn8.setMaximumSize(new java.awt.Dimension(54, 54));
        btn8.setMinimumSize(new java.awt.Dimension(54, 54));
        btn8.setPreferredSize(new java.awt.Dimension(54, 54));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel2.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 376, -1, -1));

        btn9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn9.setText("9");
        btn9.setMaximumSize(new java.awt.Dimension(54, 54));
        btn9.setMinimumSize(new java.awt.Dimension(54, 54));
        btn9.setPreferredSize(new java.awt.Dimension(54, 54));
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel2.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 376, -1, -1));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit-clear-locationbar-rtl.png"))); // NOI18N
        jButton14.setMaximumSize(new java.awt.Dimension(54, 54));
        jButton14.setMinimumSize(new java.awt.Dimension(54, 54));
        jButton14.setPreferredSize(new java.awt.Dimension(54, 54));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 436, -1, -1));

        jButton16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton16.setText(".");
        jButton16.setMaximumSize(new java.awt.Dimension(54, 54));
        jButton16.setMinimumSize(new java.awt.Dimension(54, 54));
        jButton16.setPreferredSize(new java.awt.Dimension(54, 54));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 436, -1, -1));

        btn0.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn0.setText("0");
        btn0.setMaximumSize(new java.awt.Dimension(54, 54));
        btn0.setMinimumSize(new java.awt.Dimension(54, 54));
        btn0.setPreferredSize(new java.awt.Dimension(54, 54));
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        jPanel2.add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 436, -1, -1));

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField6.setText("Vuelto");
        jTextField6.setEnabled(false);
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 436, 110, 54));

        txtVuelto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtVuelto.setEnabled(false);
        jPanel2.add(txtVuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(777, 436, 110, 54));

        txtTotalPagar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotalPagar.setEnabled(false);
        jPanel2.add(txtTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(777, 376, 110, 54));

        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField9.setText("Total a Pagar");
        jTextField9.setEnabled(false);
        jPanel2.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 376, 110, 54));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/soles.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 310, 110, 54));

        txtMontoIngresado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMontoIngresado.setEnabled(false);
        txtMontoIngresado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoIngresadoActionPerformed(evt);
            }
        });
        txtMontoIngresado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMontoIngresadoKeyPressed(evt);
            }
        });
        jPanel2.add(txtMontoIngresado, new org.netbeans.lib.awtextra.AbsoluteConstraints(777, 310, 110, 54));

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField3.setText("Efectivo");
        jTextField3.setEnabled(false);
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(777, 250, 110, 54));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("SubTotal:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        lblSubTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(lblSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 170, 30));

        jSeparator4.setBackground(new java.awt.Color(51, 51, 255));
        jSeparator4.setForeground(new java.awt.Color(102, 102, 255));
        jSeparator4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 263, 10));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("IGV:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(51, 51, 255));
        jSeparator3.setForeground(new java.awt.Color(102, 102, 255));
        jSeparator3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 263, 10));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Total:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(51, 51, 255));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 255));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 263, 10));

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 170, 30));

        lblIGV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(lblIGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 170, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 960, 530));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Arrow-reload-2-icon.png"))); // NOI18N
        jButton1.setText("Retornar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(153, 153, 255));
        btnPrint.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrint.setText("Imprimir");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnSaveSale.setBackground(new java.awt.Color(153, 153, 255));
        btnSaveSale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveSale.setText("Guardar");
        btnSaveSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 515, Short.MAX_VALUE)
                .addComponent(btnSaveSale, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSaveSale, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 960, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        DecimalFormat df=new DecimalFormat("S/ 0.00");
        
        if (cboComprobante.getSelectedIndex()!=-1) {
            rs=BDData.getDatosDocumento(cboComprobante.getSelectedItem().toString());
            try {
                if (rs.next()) {
                    temp1=rs.getString(1);
                    temp2=rs.getString(2);                          
                    //txtSerie.setText(rs.getString(1));
                    //txtCorrelativo.setText(rs.getString(2));
                    String local=txtCLocal.getText();
                    if (!temp1.equals("")) {
                        ResultSet rs1= BDData.getCorrelativo(temp1, local,cboComprobante.getSelectedItem().toString());
                        if (rs1.next()) {
                            int tempSerie=Integer.parseInt(temp1);
                            int tempCorrelativo=Integer.parseInt(temp2);
                            int correlativo=Integer.parseInt(rs1.getString(1));
                            
                            correlativo+=1;
                            if (tempCorrelativo<=correlativo) {                                                                                               
                                int len=temp2.length();
                                int lenC=Integer.toString(tempCorrelativo).length();
                                
                                StringBuffer buffer= new StringBuffer();
                                String[] cad=new String[len];
                                String[] cad1=new String[lenC];
                                
                                int count=1;                                
                                if (count==lenC) {
                                   cad1[count-1]=Integer.toString(tempCorrelativo).substring(count-1, 1);
                                    count+=1;
                                }
                                
                                int counta=lenC;
                                for (int i = len-1; i >=0 ; i--) {                                    
                                    cad[i]=0+"";
                                    counta--;
                                    for (int j = lenC-1; j>=0; j--) {
                                        if (counta==j) {
                                            cad[i]=cad1[j];
                                        }                                        
                                    }
                                    buffer.append(cad[i]);                                    
                                }
                                int tempCount=len;                                
                                StringBuffer sb=new StringBuffer();
                                
                                for (int i = 0; i < cad.length; i++) {
                                    sb.append(cad[i]);
                                }
                                
                                txtTDCorrelativos.setText(sb.toString());
                                txtTDSerie.setText(temp1);
                                //lblDocumento.setText(temp1+"-"+sb.toString());
                                //txtCNroPedido.setText(+"-"+);
                            }else{
                                JOptionPane.showMessageDialog(rootPane, "El Correlativo se ha agotado");
                                txtTDCorrelativos.setText("");
                                txtTDSerie.setText("");
                                
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
                            txtTDCorrelativos.setText(buffer.toString());
                            txtTDSerie.setText(temp1);
                            //lblDocumento.setText(temp1+"-"+buffer.toString());
                        }
                    }                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmCaja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        if (cboComprobante.getSelectedIndex()==0) {                        
            subtotal=getTotal(dtm);
            igv=(subtotal*0.18);
            total=(igv+subtotal);
            lblSubTotal.setText(df.format(subtotal).replace(",", "."));
            lblIGV.setText(df.format(igv).replace(",", "."));
            lblTotal.setText(df.format(total).replace(",", "."));
            lblSubTotal.setVisible(true);
            lblIGV.setVisible(true);
            lblTotal.setVisible(true);
            jLabel13.setVisible(true);
            jLabel14.setVisible(true);
            jLabel12.setVisible(true);

            jSeparator1.setVisible(true);   
            jSeparator3.setVisible(true);
            jSeparator4.setVisible(true);            
        }
        if (cboComprobante.getSelectedIndex()==1 || cboComprobante.getSelectedIndex()==2) {
            subtotal=getTotal(dtm);
            lblTotal.setText(df.format(subtotal).replace(",", "."));
            lblSubTotal.setText(df.format(subtotal).replace(",", "."));
            lblIGV.setText(0+"");            
                        
            lblIGV.setVisible(false);
            lblSubTotal.setVisible(false);
            jLabel13.setVisible(false);
            jLabel12.setVisible(false);
            lblTotal.setVisible(true);
            
            jLabel14.setVisible(true);
            jSeparator4.setVisible(false);
            jSeparator3.setVisible(false);
        }
        txtTotalPagar.setText(lblTotal.getText());
    }//GEN-LAST:event_cboComprobanteItemStateChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //DateFormat hour= new SimpleDateFormat("HH:mm:ss");
        //DateFormat now= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //lblDate.setText(now.format(d));
             
    }//GEN-LAST:event_formWindowActivated

    private void cboDocumentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboDocumentoItemStateChanged
        if (cboDocumento.getSelectedIndex()==1) {
            
            jLabel16.setVisible(true);
            jLabel17.setVisible(true);
            txtApeMaterno.setVisible(true);
            txtApePaterno.setVisible(true);
        }else{
            
            jLabel16.setVisible(false);
            jLabel17.setVisible(false);
            txtApeMaterno.setVisible(false);
            txtApePaterno.setVisible(false);
        }
        txtApeMaterno.setText("");
        txtApePaterno.setText("");
        txtCliente.setText("");
        txtDocumento.setText("");
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
                ResultSet rs=BDData.getValid(cliente);                
                try {
                    if(rs.next()) {
                        txtCliente.setText(rs.getString(1));
                        txtApePaterno.setText(rs.getString(2));
                        txtApeMaterno.setText(rs.getString(3));
                    }
                } catch (Exception e) {
                }
            }
            if (cboDocumento.getSelectedIndex()!=-1 && !txtDocumento.equals("") && !txtCliente.equals("") || !txtApeMaterno.equals("") || !txtApePaterno.equals("")) {
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

    private void txtTDSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTDSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTDSerieActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        obtenerNumber(evt);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        obtenerNumber(evt);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        obtenerNumber(evt);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        obtenerNumber(evt);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        obtenerNumber(evt);
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        obtenerNumber(evt);
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        obtenerNumber(evt);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        obtenerNumber(evt);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        obtenerNumber(evt);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        obtenerNumber(evt);
    }//GEN-LAST:event_btn0ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        obtenerNumber(evt);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        txtMontoIngresado.setText("");
        txtVuelto.setText("");
        vec.removeAllElements();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void txtMontoIngresadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoIngresadoActionPerformed
        /*double montoIngresado=Double.parseDouble(txtTotalPagar.getText());
        double montoTotal=Double.parseDouble(txtTotalPagar.getText().substring(txtTotalPagar.getText().indexOf("S/. ")+4, txtTotalPagar.getText().length()));
        double vuelto=montoIngresado-montoTotal;
        txtVuelto.setText("S/. "+vuelto);*/
    }//GEN-LAST:event_txtMontoIngresadoActionPerformed

    private void txtMontoIngresadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoIngresadoKeyPressed
        if (txtMontoIngresado.getText().length()>0) {
            
        }
        
    }//GEN-LAST:event_txtMontoIngresadoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        Mesas_Selection1 mesas_Selection= new Mesas_Selection1();
        mesas_Selection.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSaveSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSaleActionPerformed
        String local=txtCLocal.getText();
        String document=txtTDSerie.getText()+"-"+txtTDCorrelativos.getText();
        Caja caja=new Caja();
        System.out.println(login_User.getNdi_usuario());
        Date fecha = new Date();
        CajaLocal cl=new CajaLocal();
        String tempComprobante="";
        if (cboComprobante.getSelectedIndex()==0) {
            tempComprobante=01+"";
        }else if(cboComprobante.getSelectedIndex()==1){
            tempComprobante=03+"";
        }else if(cboComprobante.getSelectedIndex()==2){
            tempComprobante=00+"";
        }
        caja.setCo_comprobante(tempComprobante);
        caja.setNu_serie(txtTDSerie.getText());
        caja.setNu_correlativo(txtTDCorrelativos.getText());
        caja.setMt_subtotal(Double.parseDouble(lblSubTotal.getText().replace("S/ ", "")));
        caja.setMt_igv(Double.parseDouble(lblIGV.getText().replace("S/ ", "")));
        caja.setMt_total(Double.parseDouble(lblTotal.getText().replace("S/ ", "")));
        caja.setDoc_cliente(txtDocumento.getText());
        caja.setNid_pedido(Integer.parseInt(dtm.getValueAt(0, 0).toString()));
        caja.setNo_local(local);        
        caja.setNid_usuario_crea(login_User.getNdi_usuario());
        if (BDData.registrarVenta(caja)) {
            cl.setVi_no_local(local);
            cl.setVi_co_comprobante(tempComprobante);
            cl.setVi_nu_comprobante(document);
            cl.setVi_mt_importe(Double.parseDouble(lblTotal.getText().replace("S/ ", "")));
            cl.setVi_nu_persona(txtDocumento.getText());
            cl.setVi_nid_usuario_crea(login_User.getNdi_usuario());
            if (BDData.agregarCaja(cl)) {
                JOptionPane.showMessageDialog(rootPane, "Venta guardada");
            }
        }
    }//GEN-LAST:event_btnSaveSaleActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            File f = new File("sgr.jar");
            
            File destino = new File("C:/ANGEL/Escritorio/album.txt");
            String url= f.getAbsolutePath();
            System.out.println(url);
            String text="Donde Alfredo" + "\n"+
                        "******************************" + "\n"+
                        "Fecha de Emisión" + "\n";
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir=new FileWriter(destino,true);

            //Escribimos en el archivo con el metodo write 
            escribir.write(text);

            //Cerramos la conexion
            escribir.close();
            
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_btnPrintActionPerformed

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
    public static javax.swing.JLabel Codigo2;
    private javax.swing.ButtonGroup bgCliente;
    private javax.swing.ButtonGroup bgDocumento;
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSaveSale;
    private javax.swing.JButton btnValid;
    public static javax.swing.JComboBox<String> cboComprobante;
    public static javax.swing.JComboBox<String> cboDocumento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    public static javax.swing.JLabel lblIGV;
    public static javax.swing.JLabel lblSubTotal;
    public static javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblCaja;
    private javax.swing.JTextField txtApeMaterno;
    private javax.swing.JTextField txtApePaterno;
    private javax.swing.JTextField txtCDate;
    private javax.swing.JTextField txtCLocal;
    private javax.swing.JTextField txtCMesa;
    private javax.swing.JTextField txtCNroPedido;
    private javax.swing.JTextField txtCPiso;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtMontoIngresado;
    private javax.swing.JTextField txtTDCorrelativos;
    private javax.swing.JTextField txtTDSerie;
    private javax.swing.JTextField txtTotalPagar;
    private javax.swing.JTextField txtVuelto;
    // End of variables declaration//GEN-END:variables
}
