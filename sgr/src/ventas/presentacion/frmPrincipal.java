package ventas.presentacion;
import javax.swing.*;
import java.util.Timer;
import ventas.presentacion.Mesa.jpListarMesa;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimerTask;
import javax.swing.JPanel;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BD_RS;
import ventas.presentacion.Area.AreaL;
import ventas.presentacion.Cargo.CargoL;
import ventas.presentacion.Categoria.jpListarCategoria;
import ventas.presentacion.Cliente.jpListarCliente;
import ventas.presentacion.Comprobante.jpListarComprobante;
import ventas.presentacion.Empresa.jpListarEmpresa;
import ventas.presentacion.Local.jpListarLocal;
import ventas.presentacion.Mesa.jpNuevaMesa;
import ventas.presentacion.Piso.jpListarPiso;
import ventas.presentacion.Plato.jpListarPlato;
import ventas.presentacion.Plato_Local.jpListarPlatoLocal;
import ventas.presentacion.Reporte.pReporte;
import ventas.presentacion.Trabajador.Mant_Trabajador;
import ventas.presentacion.Usuario.Mant_Usuarios;

public class frmPrincipal extends javax.swing.JFrame {
    public static JPanel nPanel;
    public static int widthvar, heightvar;
    public static Container c ;
    public String namePanel;
    public int idx;
    public String lblFH = "";
    Login_User usuario =new Login_User();
    Mesas_Selection ms = new Mesas_Selection();
    Login frmL;
    public int pnelActive = 0;
    public frmPrincipal() {
        initComponents();
        
        HoraL();
        c = getContentPane();
        getContentPane().setLayout(null);
        frmL = new Login();
        setExtendedState(MAXIMIZED_BOTH);
        
        widthvar = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        heightvar = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        pTop.setLayout(null);
        pTop.setBounds(0,0,widthvar, 59);
        //btnHome.setBounds(widthvar-75, 0, 55, 57);
            pMesas.setVisible(false);
            pComprobante.setVisible(false);
            pUsuario.setVisible(false);
            pTrabajador.setVisible(false);
            pArea.setVisible(false);
            pCliente.setVisible(false);
            pCargo.setVisible(false);            
            pEmpresa.setVisible(false);
            pLocal.setVisible(false);
            pPlato.setVisible(false);
            pPlatoLocal.setVisible(false);
            pPiso.setVisible(false);            
            pCategoria.setVisible(false); 
            mpMante.setVisible(false);
            mpReporte.setVisible(false);
            mpPedido.setVisible(false);
            mpCarta.setVisible(false);
            mpCaja.setVisible(false);
            mpBackup.setVisible(false);
        //jpContenedor.setBounds(255, 59, widthvar - 255, heightvar-59);
        jpContenedor.setVisible(false);
        jLabel15.setLocation(15, 15);
        //jpContenedor.setBounds(255, 59, widthvar-255, heightvar-59);
       //Validar(usuario.getNid_perfil());
       Login_User lg = new Login_User();
       jLabel5.setLocation(widthvar-600,5);
       jPanel2.setLocation(widthvar-82, 2);
       jPanel1.setLocation(widthvar-167,2);
       jLabel46.setLocation(widthvar-478, 5);
       lblSuc.setBounds(widthvar-420,15,180,20);
       lblUser.setBounds(widthvar-540, 16, 100, 20);
       lblUser.setText(lg.getNo_usuario());
       lblSuc.setText(lg.getSurcursal());
       
       lblUser.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
       lblSuc.setFont(new java.awt.Font("Arial Black", 1, 16));
       IconFH.setLocation(335, 4);
       FHLbl.setBounds(390, 20, 300, 20);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pTop = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        lblSuc = new javax.swing.JLabel();
        FHLbl = new javax.swing.JLabel();
        IconFH = new javax.swing.JLabel();
        pTrabajador = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mpPedido = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mpMante = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pMesas = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        mpReporte = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pUsuario = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jpContenedor = new javax.swing.JPanel();
        pComprobante = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pArea = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pCargo = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        pPiso = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pEmpresa = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        pCliente = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        pLocal = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        pPlato = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        mpCaja = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        pPlatoLocal = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        mpBackup = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        pCategoria = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        mpCarta = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 252, 230));
        setUndecorated(true);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pTop.setBackground(new java.awt.Color(68, 134, 187));
        pTop.setPreferredSize(new java.awt.Dimension(1280, 59));
        pTop.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Sistema de Gestión");
        pTop.add(jLabel15);
        jLabel15.setBounds(298, 23, 210, 26);

        lblUser.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("#User");
        pTop.add(lblUser);
        lblUser.setBounds(981, 22, 63, 26);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/userlog.png"))); // NOI18N
        pTop.add(jLabel5);
        jLabel5.setBounds(915, 9, 48, 48);

        jPanel1.setBackground(new java.awt.Color(68, 134, 187));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logout.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Salir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel43)
                    .addComponent(jLabel6))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43))
        );

        pTop.add(jPanel1);
        jPanel1.setBounds(159, 9, 75, 57);

        jPanel2.setBackground(new java.awt.Color(68, 134, 187));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Home-icon.png"))); // NOI18N
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Inicio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel45)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45))
        );

        pTop.add(jPanel2);
        jPanel2.setBounds(71, 9, 82, 57);

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/suc1.png"))); // NOI18N
        jLabel46.setAutoscrolls(true);
        pTop.add(jLabel46);
        jLabel46.setBounds(1081, 9, 48, 48);

        lblSuc.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        lblSuc.setForeground(new java.awt.Color(255, 255, 255));
        lblSuc.setText("#Suc");
        pTop.add(lblSuc);
        lblSuc.setBounds(1139, 22, 53, 26);

        FHLbl.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        FHLbl.setForeground(new java.awt.Color(255, 255, 255));
        FHLbl.setText("#FH");
        pTop.add(FHLbl);
        FHLbl.setBounds(750, 30, 86, 23);

        IconFH.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        IconFH.setForeground(new java.awt.Color(255, 255, 255));
        IconFH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/DateTime.png"))); // NOI18N
        pTop.add(IconFH);
        IconFH.setBounds(640, 10, 60, 60);

        getContentPane().add(pTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        pTrabajador.setBackground(new java.awt.Color(24, 168, 255));
        pTrabajador.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pTrabajador.setPreferredSize(new java.awt.Dimension(255, 120));
        pTrabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pTrabajadorMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Trabajadores");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/worker.png"))); // NOI18N

        javax.swing.GroupLayout pTrabajadorLayout = new javax.swing.GroupLayout(pTrabajador);
        pTrabajador.setLayout(pTrabajadorLayout);
        pTrabajadorLayout.setHorizontalGroup(
            pTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTrabajadorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(88, 88, 88))
        );
        pTrabajadorLayout.setVerticalGroup(
            pTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTrabajadorLayout.createSequentialGroup()
                .addGroup(pTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pTrabajadorLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pTrabajadorLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(pTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 255, 120));

        mpPedido.setBackground(new java.awt.Color(24, 168, 255));
        mpPedido.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        mpPedido.setPreferredSize(new java.awt.Dimension(255, 120));
        mpPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mpPedidoMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pedido");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout mpPedidoLayout = new javax.swing.GroupLayout(mpPedido);
        mpPedido.setLayout(mpPedidoLayout);
        mpPedidoLayout.setHorizontalGroup(
            mpPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mpPedidoLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(63, 63, 63))
        );
        mpPedidoLayout.setVerticalGroup(
            mpPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mpPedidoLayout.createSequentialGroup()
                .addGroup(mpPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mpPedidoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(mpPedidoLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
        );

        jLabel4.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(mpPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        mpMante.setBackground(new java.awt.Color(24, 168, 255));
        mpMante.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        mpMante.setPreferredSize(new java.awt.Dimension(255, 120));
        mpMante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mpManteMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mantenimiento");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/protest.png"))); // NOI18N

        javax.swing.GroupLayout mpManteLayout = new javax.swing.GroupLayout(mpMante);
        mpMante.setLayout(mpManteLayout);
        mpManteLayout.setHorizontalGroup(
            mpManteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mpManteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );
        mpManteLayout.setVerticalGroup(
            mpManteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mpManteLayout.createSequentialGroup()
                .addGroup(mpManteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mpManteLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel13))
                    .addGroup(mpManteLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(mpMante, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 60, 260, -1));

        pMesas.setBackground(new java.awt.Color(24, 168, 255));
        pMesas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pMesas.setPreferredSize(new java.awt.Dimension(255, 120));
        pMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pMesasMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mesas");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/t2.png"))); // NOI18N

        javax.swing.GroupLayout pMesasLayout = new javax.swing.GroupLayout(pMesas);
        pMesas.setLayout(pMesasLayout);
        pMesasLayout.setHorizontalGroup(
            pMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMesasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel12)
                .addGap(38, 38, 38)
                .addComponent(jLabel11)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        pMesasLayout.setVerticalGroup(
            pMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMesasLayout.createSequentialGroup()
                .addGroup(pMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMesasLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel11))
                    .addGroup(pMesasLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel12)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        getContentPane().add(pMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        mpReporte.setBackground(new java.awt.Color(24, 168, 255));
        mpReporte.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        mpReporte.setPreferredSize(new java.awt.Dimension(255, 120));
        mpReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mpReporteMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Reporte");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/rpt.png"))); // NOI18N

        javax.swing.GroupLayout mpReporteLayout = new javax.swing.GroupLayout(mpReporte);
        mpReporte.setLayout(mpReporteLayout);
        mpReporteLayout.setHorizontalGroup(
            mpReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mpReporteLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        mpReporteLayout.setVerticalGroup(
            mpReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mpReporteLayout.createSequentialGroup()
                .addGroup(mpReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mpReporteLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel8))
                    .addGroup(mpReporteLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel7)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(mpReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, -1, -1));

        pUsuario.setBackground(new java.awt.Color(24, 168, 255));
        pUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pUsuario.setPreferredSize(new java.awt.Dimension(255, 120));
        pUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pUsuarioMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Usuarios");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/users.png"))); // NOI18N

        javax.swing.GroupLayout pUsuarioLayout = new javax.swing.GroupLayout(pUsuario);
        pUsuario.setLayout(pUsuarioLayout);
        pUsuarioLayout.setHorizontalGroup(
            pUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(41, 41, 41))
        );
        pUsuarioLayout.setVerticalGroup(
            pUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUsuarioLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(pUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(24, 24, 24))))
        );

        getContentPane().add(pUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        javax.swing.GroupLayout jpContenedorLayout = new javax.swing.GroupLayout(jpContenedor);
        jpContenedor.setLayout(jpContenedorLayout);
        jpContenedorLayout.setHorizontalGroup(
            jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jpContenedorLayout.setVerticalGroup(
            jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jpContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 10, 10));

        pComprobante.setBackground(new java.awt.Color(24, 168, 255));
        pComprobante.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pComprobante.setPreferredSize(new java.awt.Dimension(255, 120));
        pComprobante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pComprobanteMouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Comprobante");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/clipboard.png"))); // NOI18N

        javax.swing.GroupLayout pComprobanteLayout = new javax.swing.GroupLayout(pComprobante);
        pComprobante.setLayout(pComprobanteLayout);
        pComprobanteLayout.setHorizontalGroup(
            pComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pComprobanteLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        pComprobanteLayout.setVerticalGroup(
            pComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pComprobanteLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(45, 45, 45))
            .addGroup(pComprobanteLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, -1, -1));

        pArea.setBackground(new java.awt.Color(24, 168, 255));
        pArea.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pArea.setPreferredSize(new java.awt.Dimension(255, 120));
        pArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pAreaMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Área");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/area.png"))); // NOI18N

        javax.swing.GroupLayout pAreaLayout = new javax.swing.GroupLayout(pArea);
        pArea.setLayout(pAreaLayout);
        pAreaLayout.setHorizontalGroup(
            pAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAreaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel19)
                .addGap(28, 28, 28)
                .addComponent(jLabel18)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        pAreaLayout.setVerticalGroup(
            pAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAreaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel19)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAreaLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(46, 46, 46))
        );

        getContentPane().add(pArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, -1, -1));

        pCargo.setBackground(new java.awt.Color(24, 168, 255));
        pCargo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pCargo.setPreferredSize(new java.awt.Dimension(255, 120));
        pCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pCargoMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Cargo");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/collaboration.png"))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Cargo");

        javax.swing.GroupLayout pCargoLayout = new javax.swing.GroupLayout(pCargo);
        pCargo.setLayout(pCargoLayout);
        pCargoLayout.setHorizontalGroup(
            pCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCargoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel17)
                .addGap(40, 40, 40)
                .addComponent(jLabel36)
                .addGap(179, 179, 179)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pCargoLayout.setVerticalGroup(
            pCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCargoLayout.createSequentialGroup()
                .addGroup(pCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCargoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel17))
                    .addGroup(pCargoLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(pCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel36))))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(pCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

        pPiso.setBackground(new java.awt.Color(24, 168, 255));
        pPiso.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pPiso.setPreferredSize(new java.awt.Dimension(255, 120));
        pPiso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pPisoMouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Piso");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        javax.swing.GroupLayout pPisoLayout = new javax.swing.GroupLayout(pPiso);
        pPiso.setLayout(pPisoLayout);
        pPisoLayout.setHorizontalGroup(
            pPisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPisoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(61, 61, 61)
                .addComponent(jLabel22)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        pPisoLayout.setVerticalGroup(
            pPisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPisoLayout.createSequentialGroup()
                .addGroup(pPisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPisoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel22))
                    .addGroup(pPisoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel23)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(pPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        pEmpresa.setBackground(new java.awt.Color(24, 168, 255));
        pEmpresa.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pEmpresa.setPreferredSize(new java.awt.Dimension(255, 120));
        pEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pEmpresaMouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Empresa");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cityscape.png"))); // NOI18N

        javax.swing.GroupLayout pEmpresaLayout = new javax.swing.GroupLayout(pEmpresa);
        pEmpresa.setLayout(pEmpresaLayout);
        pEmpresaLayout.setHorizontalGroup(
            pEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(35, 35, 35)
                .addComponent(jLabel24)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        pEmpresaLayout.setVerticalGroup(
            pEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEmpresaLayout.createSequentialGroup()
                .addGroup(pEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pEmpresaLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel24))
                    .addGroup(pEmpresaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel25)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(pEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

        pCliente.setBackground(new java.awt.Color(24, 168, 255));
        pCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pCliente.setPreferredSize(new java.awt.Dimension(255, 120));
        pCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pClienteMouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Cliente");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/suit-and-bow-tie.png"))); // NOI18N

        javax.swing.GroupLayout pClienteLayout = new javax.swing.GroupLayout(pCliente);
        pCliente.setLayout(pClienteLayout);
        pClienteLayout.setHorizontalGroup(
            pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pClienteLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel27)
                .addGap(48, 48, 48)
                .addComponent(jLabel26)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        pClienteLayout.setVerticalGroup(
            pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pClienteLayout.createSequentialGroup()
                .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pClienteLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel26))
                    .addGroup(pClienteLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel27)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(pCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 300, -1, -1));

        pLocal.setBackground(new java.awt.Color(24, 168, 255));
        pLocal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pLocal.setPreferredSize(new java.awt.Dimension(255, 120));
        pLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pLocalMouseClicked(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Local");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/store.png"))); // NOI18N

        javax.swing.GroupLayout pLocalLayout = new javax.swing.GroupLayout(pLocal);
        pLocal.setLayout(pLocalLayout);
        pLocalLayout.setHorizontalGroup(
            pLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLocalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGap(61, 61, 61)
                .addComponent(jLabel28)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        pLocalLayout.setVerticalGroup(
            pLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLocalLayout.createSequentialGroup()
                .addGroup(pLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLocalLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel28))
                    .addGroup(pLocalLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel29)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(pLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        pPlato.setBackground(new java.awt.Color(24, 168, 255));
        pPlato.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pPlato.setPreferredSize(new java.awt.Dimension(255, 120));
        pPlato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pPlatoMouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Plato");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/salad.png"))); // NOI18N

        javax.swing.GroupLayout pPlatoLayout = new javax.swing.GroupLayout(pPlato);
        pPlato.setLayout(pPlatoLayout);
        pPlatoLayout.setHorizontalGroup(
            pPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPlatoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGap(61, 61, 61)
                .addComponent(jLabel30)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        pPlatoLayout.setVerticalGroup(
            pPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPlatoLayout.createSequentialGroup()
                .addGroup(pPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPlatoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel30))
                    .addGroup(pPlatoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel31)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(pPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, -1, -1));

        mpCaja.setBackground(new java.awt.Color(24, 168, 255));
        mpCaja.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        mpCaja.setPreferredSize(new java.awt.Dimension(255, 120));
        mpCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mpCajaMouseClicked(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Caja");

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cash-counter.png"))); // NOI18N

        javax.swing.GroupLayout mpCajaLayout = new javax.swing.GroupLayout(mpCaja);
        mpCaja.setLayout(mpCajaLayout);
        mpCajaLayout.setHorizontalGroup(
            mpCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mpCajaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        mpCajaLayout.setVerticalGroup(
            mpCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mpCajaLayout.createSequentialGroup()
                .addGroup(mpCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mpCajaLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel32))
                    .addGroup(mpCajaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel33)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(mpCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 540, -1, -1));

        pPlatoLocal.setBackground(new java.awt.Color(24, 168, 255));
        pPlatoLocal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pPlatoLocal.setPreferredSize(new java.awt.Dimension(255, 120));
        pPlatoLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pPlatoLocalMouseClicked(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Plato Local");

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cereals.png"))); // NOI18N

        javax.swing.GroupLayout pPlatoLocalLayout = new javax.swing.GroupLayout(pPlatoLocal);
        pPlatoLocal.setLayout(pPlatoLocalLayout);
        pPlatoLocalLayout.setHorizontalGroup(
            pPlatoLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPlatoLocalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addGap(30, 30, 30))
        );
        pPlatoLocalLayout.setVerticalGroup(
            pPlatoLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPlatoLocalLayout.createSequentialGroup()
                .addGroup(pPlatoLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPlatoLocalLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel34))
                    .addGroup(pPlatoLocalLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel35)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(pPlatoLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, -1, -1));

        mpBackup.setBackground(new java.awt.Color(24, 168, 255));
        mpBackup.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        mpBackup.setPreferredSize(new java.awt.Dimension(255, 120));
        mpBackup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mpBackupMouseClicked(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Backup");

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/bck.png"))); // NOI18N

        javax.swing.GroupLayout mpBackupLayout = new javax.swing.GroupLayout(mpBackup);
        mpBackup.setLayout(mpBackupLayout);
        mpBackupLayout.setHorizontalGroup(
            mpBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mpBackupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addGap(18, 18, 18)
                .addComponent(jLabel37)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        mpBackupLayout.setVerticalGroup(
            mpBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mpBackupLayout.createSequentialGroup()
                .addGroup(mpBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mpBackupLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel37))
                    .addGroup(mpBackupLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel38)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        getContentPane().add(mpBackup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, -1, -1));

        pCategoria.setBackground(new java.awt.Color(24, 168, 255));
        pCategoria.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pCategoria.setPreferredSize(new java.awt.Dimension(255, 120));
        pCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pCategoriaMouseClicked(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Categoria");

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/groceries.png"))); // NOI18N

        javax.swing.GroupLayout pCategoriaLayout = new javax.swing.GroupLayout(pCategoria);
        pCategoria.setLayout(pCategoriaLayout);
        pCategoriaLayout.setHorizontalGroup(
            pCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addGap(18, 18, 18)
                .addComponent(jLabel39)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        pCategoriaLayout.setVerticalGroup(
            pCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCategoriaLayout.createSequentialGroup()
                .addGroup(pCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCategoriaLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel39))
                    .addGroup(pCategoriaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel40)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(pCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, -1));

        mpCarta.setBackground(new java.awt.Color(24, 168, 255));
        mpCarta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        mpCarta.setPreferredSize(new java.awt.Dimension(255, 120));
        mpCarta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mpCartaMouseClicked(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Carta");

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/carta2.png"))); // NOI18N

        javax.swing.GroupLayout mpCartaLayout = new javax.swing.GroupLayout(mpCarta);
        mpCarta.setLayout(mpCartaLayout);
        mpCartaLayout.setHorizontalGroup(
            mpCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mpCartaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addComponent(jLabel41)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mpCartaLayout.setVerticalGroup(
            mpCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mpCartaLayout.createSequentialGroup()
                .addGroup(mpCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mpCartaLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel41))
                    .addGroup(mpCartaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel42)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(mpCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void pTrabajadorMouseClicked(java.awt.event.MouseEvent evt) {                                         
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pTrabajador.setBackground(new java.awt.Color(255,51,51));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pPlatoLocal.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        
        try {
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new Mant_Trabajador();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }

    private void mpPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mpPedidoMouseClicked
        mpPedido.setBackground(new java.awt.Color(255,51,51));          
        mpReporte.setBackground(new java.awt.Color(24,168,255));          
        mpMante.setBackground(new java.awt.Color(24,168,255));
        mpCaja.setBackground(new java.awt.Color(24,168,255));
        mpCarta.setBackground(new java.awt.Color(24,168,255));
        mpBackup.setBackground(new java.awt.Color(24,168,255));        
        Timer t= new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {
                pnelActive = 2;
                
                setVisible(false);
                ms.setVisible(true);
           }
        };
        t.schedule(task, 500);            
    }//GEN-LAST:event_mpPedidoMouseClicked
    public static void Comp(JPanel j){
        try {
            nPanel.setVisible(false);
        if(nPanel != null){
            
        c.remove(nPanel);
        
        c.repaint();
        }
        nPanel = j;
        nPanel.setBounds(255, 59, widthvar-255, heightvar-59);
        nPanel.setVisible(true);
        c.add(nPanel);
        c.validate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void mpReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mpReporteMouseClicked
        mpReporte.setBackground(new java.awt.Color(255,51,51));          
        mpMante.setBackground(new java.awt.Color(24,168,255));
        mpCaja.setBackground(new java.awt.Color(24,168,255));
        mpCarta.setBackground(new java.awt.Color(24,168,255));
        mpBackup.setBackground(new java.awt.Color(24,168,255));
        Timer t= new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {                
                try {
                    if(nPanel != null){
                        getContentPane().remove(nPanel);
                        getContentPane().repaint();
                    }
                    nPanel = new pReporte();
                    nPanel.setBounds(255,59, widthvar-255, heightvar-59);

                    getContentPane().add(nPanel);
                    validate();
                } catch (Exception e) {
                }
            }
        };
        t.schedule(task, 1000);        
    }//GEN-LAST:event_mpReporteMouseClicked

    private void pUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pUsuarioMouseClicked
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(255,51,51));
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pPlatoLocal.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
       try {
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new Mant_Usuarios();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pUsuarioMouseClicked

    private void pMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMesasMouseClicked
        pMesas.setBackground(new java.awt.Color(255,51,51));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pPlatoLocal.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        jpListarMesa lp=new jpListarMesa();
        namePanel=lp.toString().substring(lp.toString().indexOf("jp"), lp.toString().indexOf("["));        
        try {
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new jpListarMesa();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pMesasMouseClicked

    private void mpManteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mpManteMouseClicked
        mpPedido.setBackground(new java.awt.Color(24,168,255));        
        mpReporte.setBackground(new java.awt.Color(24,168,255));       
        mpMante.setBackground(new java.awt.Color(255,51,51));
        mpCaja.setBackground(new java.awt.Color(24,168,255));
        mpCarta.setBackground(new java.awt.Color(24,168,255));
        mpBackup.setBackground(new java.awt.Color(24,168,255));
        
        Timer t= new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {                
                mpMante.setVisible(false);
                mpPedido.setVisible(false);
                mpReporte.setVisible(false);
                mpCaja.setVisible(false);
                mpCarta.setVisible(false);
                mpBackup.setVisible(false);
                ValidarSub(usuario.getNid_perfil());
                pnelActive = 1;
            }
        };        
        t.schedule(task, 1000);        
        
    }//GEN-LAST:event_mpManteMouseClicked

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
       
    }//GEN-LAST:event_formWindowStateChanged

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        //jpContenedor.validate();// TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    private void pCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pCargoMouseClicked
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(255,51,51));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pPlatoLocal.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        try {
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new CargoL();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pCargoMouseClicked

    private void pAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pAreaMouseClicked
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(255,51,51));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pPlatoLocal.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        try {
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new AreaL();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pAreaMouseClicked

    private void pComprobanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pComprobanteMouseClicked
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(255,51,51));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pPlatoLocal.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));        
        jpListarComprobante lp=new jpListarComprobante();
        namePanel=lp.toString().substring(lp.toString().indexOf("jp"), lp.toString().indexOf("["));        
        try {
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new jpListarComprobante();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pComprobanteMouseClicked

    private void pPisoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pPisoMouseClicked
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pPlatoLocal.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(255,51,51));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        jpListarPiso lp=new jpListarPiso();
        namePanel=lp.toString().substring(lp.toString().indexOf("jp"), lp.toString().indexOf("["));        
        try {
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new jpListarPiso();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pPisoMouseClicked

    private void pEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pEmpresaMouseClicked
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(255,51,51));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pPlatoLocal.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        jpListarEmpresa lp=new jpListarEmpresa();
        namePanel=lp.toString().substring(lp.toString().indexOf("jp"), lp.toString().indexOf("["));        
       try {
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new jpListarEmpresa();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pEmpresaMouseClicked

    private void pClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pClienteMouseClicked
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(255,51,51));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pPlatoLocal.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));

       try {
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new jpListarCliente();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pClienteMouseClicked

    private void pLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pLocalMouseClicked
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(255,51,51));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pPlatoLocal.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        jpListarLocal lp=new jpListarLocal();
        namePanel=lp.toString().substring(lp.toString().indexOf("jp"), lp.toString().indexOf("["));        
        try {
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new jpListarLocal();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pLocalMouseClicked

    private void pPlatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pPlatoMouseClicked
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(255,51,51));
        pPlatoLocal.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        jpListarPlato lp=new jpListarPlato();
        namePanel=lp.toString().substring(lp.toString().indexOf("jp"), lp.toString().indexOf("["));        
        try {
            //options(4);
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new jpListarPlato();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pPlatoMouseClicked

    private void mpCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mpCajaMouseClicked
        mpPedido.setBackground(new java.awt.Color(24,168,255));
        mpReporte.setBackground(new java.awt.Color(24,168,255));       
        mpMante.setBackground(new java.awt.Color(24,168,255));
        mpCaja.setBackground(new java.awt.Color(255,51,51));
        mpCarta.setBackground(new java.awt.Color(24,168,255));
        mpBackup.setBackground(new java.awt.Color(24,168,255));               
                
        Timer t= new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {
                mpMante.setVisible(false);
                mpPedido.setVisible(false);
                mpReporte.setVisible(false);
                mpCaja.setVisible(false);
                mpCarta.setVisible(false);
                mpBackup.setVisible(false);
                //pnelActive = 1;
                setVisible(false);
                Mesas_Selection1 caja=new Mesas_Selection1();
                caja.setVisible(true);
            }
        };
        t.schedule(task, 1000);        
    }//GEN-LAST:event_mpCajaMouseClicked

    private void pPlatoLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pPlatoLocalMouseClicked
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        mpCaja.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pPlatoLocal.setBackground(new java.awt.Color(255,51,51));
        pPiso.setBackground(new java.awt.Color(24,168,255));        
        try {
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new jpListarPlatoLocal();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pPlatoLocalMouseClicked

    private void mpBackupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mpBackupMouseClicked
        mpPedido.setBackground(new java.awt.Color(24,168,255));
        mpReporte.setBackground(new java.awt.Color(24,168,255));       
        mpMante.setBackground(new java.awt.Color(24,168,255));
        mpCaja.setBackground(new java.awt.Color(24,168,255));
        mpCarta.setBackground(new java.awt.Color(24,168,255));
        mpBackup.setBackground(new java.awt.Color(255,51,51));
       
        mpMante.setVisible(true);
        mpPedido.setVisible(true);
        mpReporte.setVisible(true);
        mpCaja.setVisible(true);
        mpCarta.setVisible(true);
        mpBackup.setVisible(true);
        
        Timer t= new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {
                //Modal 'Generando Backup'
                GBackup();
            }
        };
        t.schedule(task, 1000);    
    }//GEN-LAST:event_mpBackupMouseClicked

    private void pCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pCategoriaMouseClicked
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(255,51,51));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pPlatoLocal.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        jpListarCategoria lp=new jpListarCategoria();
        namePanel=lp.toString().substring(lp.toString().indexOf("jp"), lp.toString().indexOf("["));        
        try {
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new jpListarCategoria();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pCategoriaMouseClicked

    private void mpCartaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mpCartaMouseClicked
        /*Timer t= new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {
                options(4);
            }
        };
        t.schedule(task, 1000); */       
    }//GEN-LAST:event_mpCartaMouseClicked
        
    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
            
            pMesas.setVisible(false);
            pUsuario.setVisible(false);
            pTrabajador.setVisible(false);
            pArea.setVisible(false);
            pCliente.setVisible(false);
            pComprobante.setVisible(false);
            pCargo.setVisible(false);
            pCategoria.setVisible(false);
            pEmpresa.setVisible(false);
            pLocal.setVisible(false);
            pPlato.setVisible(false);
            pPlatoLocal.setVisible(false);
            pPiso.setVisible(false);
            
            pMesas.setBackground(new java.awt.Color(24,168,255));
            pUsuario.setBackground(new java.awt.Color(24,168,255));
            pTrabajador.setBackground(new java.awt.Color(24,168,255));
            pArea.setBackground(new java.awt.Color(24,168,255));
            pCliente.setBackground(new java.awt.Color(24,168,255));
            pComprobante.setBackground(new java.awt.Color(24,168,255));
            pCargo.setBackground(new java.awt.Color(24,168,255));
            pCategoria.setBackground(new java.awt.Color(24,168,255));
            pEmpresa.setBackground(new java.awt.Color(24,168,255));
            pLocal.setBackground(new java.awt.Color(24,168,255));
            pPlato.setBackground(new java.awt.Color(24,168,255));
            pPlatoLocal.setBackground(new java.awt.Color(24,168,255));
            pPiso.setBackground(new java.awt.Color(24,168,255));
            if (usuario.getNid_perfil() == 1){
                    mpMante.setVisible(true);
                    mpPedido.setVisible(true);
                    mpReporte.setVisible(true);
                    mpCaja.setVisible(true);
                    mpReporte.setVisible(true);
                    mpBackup.setVisible(true);
            }
            else if(usuario.getNid_perfil() == 2){
                    mpMante.setVisible(false);
                    mpPedido.setVisible(true);
                    mpReporte.setVisible(true);
                    mpCaja.setVisible(false);
                    mpBackup.setVisible(true);
                   
            }else{
                if(BD_RS.idCargoLog == 5){
                    mpMante.setVisible(false);
                    mpPedido.setVisible(false);
                    mpReporte.setVisible(true);
                    mpCaja.setVisible(true);
                    mpBackup.setVisible(true);
                }
            }
            //mpCarta.setVisible(true);
            
            
            mpPedido.setBackground(new java.awt.Color(24,168,255));
            mpReporte.setBackground(new java.awt.Color(24,168,255));
            mpMante.setBackground(new java.awt.Color(24,168,255));
            mpCaja.setBackground(new java.awt.Color(24,168,255));
            mpCarta.setBackground(new java.awt.Color(24,168,255));
            mpBackup.setBackground(new java.awt.Color(24,168,255));
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
        
    }//GEN-LAST:event_jLabel44MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        int i = JOptionPane.showOptionDialog(null,"¿Desea salir del Sistema?", "Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
        if(i==0) System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked
    public void ValidarSub(int id){
        int vis = 13;
        double pScreen=heightvar - pTop.getHeight();
        int size = 0;
        double temp= Math.ceil(pScreen/13);
            size = (int)temp;    //Alto de cada panel            
            //s están FALSE, aquí se elige los que serán visibles (debe ser de acuerdo a la variable VIS)
            pMesas.setVisible(true);
            pComprobante.setVisible(true);
            pUsuario.setVisible(true);
            pTrabajador.setVisible(true);
            pArea.setVisible(true);
            pCliente.setVisible(true);
            pCargo.setVisible(true);
            pCategoria.setVisible(true);
            pEmpresa.setVisible(true);
            pLocal.setVisible(true);
            pPlato.setVisible(true);
            pPlatoLocal.setVisible(true);
            pPiso.setVisible(true);
            
//Los mismos paneles que se ha hecho VISIBLE, se setea LAYOUT = NULL (Para posicionar)
            pTrabajador.setLayout(null);
            pUsuario.setLayout(null);
            pMesas.setLayout(null);
            pComprobante.setLayout(null);
            pArea.setLayout(null);
            pCliente.setLayout(null);            
            pCargo.setLayout(null);
            pCategoria.setLayout(null);
            pEmpresa.setLayout(null);
            pLocal.setLayout(null);
            pPlato.setLayout(null);
            pPlatoLocal.setLayout(null);
            pPiso.setLayout(null);
            
//Primer panel .... Lo mismo en los demás paneles, lo que varía es la posicion Y ( 59 + size * numeropanel) (EASY by Anibal XD)
            pEmpresa.setBounds(0,59,255,size);
            jLabel24.setBounds(105, size/2 - 20,100 ,26);
            jLabel25.setBounds(17, size/2 - 30, 64, 64);
            
            pLocal.setBounds(0,59 + size,255,size);
            jLabel28.setBounds(105, size/2 - 20,68 ,26);
            jLabel29.setBounds(17, size/2 - 30, 64, 64);
            
            pPiso.setBounds(0,59 + (size*2),255,size);
            jLabel22.setBounds(105, size/2 - 20,68 ,26);
            jLabel23.setBounds(17, size/2 - 30, 64, 64);                        
            
            pMesas.setBounds(0, 59 + (size*3), 255, size);
            jLabel11.setBounds(105, size/2 - 20,68 ,26);
            jLabel12.setBounds(17, size/2 - 30,64 ,64);            
            
            pComprobante.setBounds(0, 59 + (size*4), 255, size);
            jLabel20.setBounds(105, size/2 - 20,150 ,26);
            jLabel21.setBounds(17, size/2 -30,64 ,64);
            
            pArea.setBounds(0,59 + (size*5),255,size);
            jLabel18.setBounds(105, size/2 - 20,68 ,26);
            jLabel19.setBounds(17, size/2 - 30, 64, 64);
            
            pCargo.setBounds(0,59 + (size*6),255,size);
            jLabel36.setBounds(105, size/2 - 20,68 ,26);
            jLabel17.setBounds(17, size/2 - 30, 64, 64);
            
            pTrabajador.setBounds(0, 59 + (size*7), 255,size);
            jLabel1.setBounds(105, size/2 - 20, 142, 26);
            jLabel2.setBounds(17, size/2 - 30, 64, 64);
            
            pUsuario.setBounds(0, 59 + (size*8) ,255,size);
            jLabel9.setBounds(105, size/2 - 15, 95, 26);
            jLabel10.setBounds(17, size/2 - 30, 64, 64);
            
            pCategoria.setBounds(0,59 + (size*9),255,size);
            jLabel39.setBounds(105, size/2 - 20,120 ,26);
            jLabel40.setBounds(17, size/2 - 30, 64, 64);
            
            pPlato.setBounds(0,59 + (size*10),255,size);
            jLabel30.setBounds(105, size/2 - 20,68 ,26);
            jLabel31.setBounds(17, size/2 - 30, 64, 64);
            
            pPlatoLocal.setBounds(0,59 + (size*11),255,size);
            jLabel34.setBounds(105, size/2 - 20,130 ,26);
            jLabel35.setBounds(17, size/2 - 30, 64, 64);
            
            pCliente.setBounds(0,59 + (size*12),255,size);
            jLabel26.setBounds(105, size/2 - 20,90 ,26);
            jLabel27.setBounds(17, size/2 - 30, 64, 64);
                                    
    }
    /*public void options(int option){
        int sizeOption = (heightvar - pTop.getHeight())/option;
        opGuardar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opBuscar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opEditar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opEliminar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opHome.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        opNuevo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        if (option==4) {
            //int sizeOption = (heightvar - pTop.getHeight())/option;
            opGuardar.setVisible(false);
            opHome.setVisible(false);
            
            opNuevo.setVisible(true);
            opNuevo.setLayout(null);
            opNuevo.setBounds(255, 59,80,sizeOption); 

            opEditar.setVisible(true);
            opEditar.setLayout(null);
            opEditar.setBounds(255, 59+sizeOption,80,sizeOption); 

            opEliminar.setVisible(true);
            opEliminar.setLayout(null);
            opEliminar.setBounds(255, 59+(sizeOption*2),80,sizeOption); 

            opBuscar.setVisible(true);
            opBuscar.setLayout(null);
            opBuscar.setBounds(255, 59+(sizeOption*3),80,sizeOption);             
        }else{                
            opNuevo.setVisible(false);
            opEliminar.setVisible(false);
            opEditar.setVisible(false);
            opBuscar.setVisible(false);            
            
            opGuardar.setVisible(true);
            opGuardar.setLayout(null);
            opGuardar.setBounds(255, 59,80,sizeOption); 
            
            opHome.setVisible(true);
            opHome.setLayout(null);
            opHome.setBounds(255, 59+sizeOption,80,sizeOption);             
        }
    }*/
    public void Validar(int id){
        int vis = 3;
        int size = 0;
        if(id == 1){
            
            vis = 5; //Cantidad de paneles se va a mostrar
            size = (heightvar - pTop.getHeight())/vis;    //Alto de cada panel
            
            //Al cargar el frame todos están FALSE, aquí se elige los que serán visibles (debe ser de acuerdo a la variable VIS)
            //pMesas.setVisible(true);
            mpMante.setVisible(true);
            mpReporte.setVisible(true);            
            mpPedido.setVisible(true);
            mpCaja.setVisible(true);
            //mpCarta.setVisible(true);
            mpBackup.setVisible(true);
            
            //Los mismos paneles que se ha hecho VISIBLE, se setea LAYOUT = NULL (Para posicionar)
            //pTrabajador.setLayout(null);
            mpMante.setLayout(null);
            mpPedido.setLayout(null);
            mpCaja.setLayout(null);
            //pUsuario.setLayout(null);
            mpReporte.setLayout(null);            
            
            
            //mpCarta.setLayout(null);
            mpBackup.setLayout(null);
            
            //Primer panel .... Lo mismo en los demás paneles, lo que varía es la posicion Y ( 59 + size * numeropanel) (EASY by Anibal XD)
            /*
            pUsuario.setBounds(0, 59 ,255,size);
            jLabel9.setBounds(105, size/2 - 15, 95, 26);
            jLabel10.setBounds(17, size/2 - 30, 64, 64);
            
            pTrabajador.setBounds(0, 59 + size, 255,size);
            jLabel1.setBounds(105, size/2 - 20, 142, 26);
            jLabel2.setBounds(17, size/2 - 52, 64, 64);
            
            pMesas.setBounds(0, 59 + size*2, 255, size);
            jLabel11.setBounds(105, size/2 - 20,68 ,26);
            jLabel12.setBounds(17, size/2 - 40,64 ,64);
            */
            mpMante.setBounds(0, 59, 255, size);
            jLabel13.setBounds(90, size/2 - 15,160 ,26);
            jLabel14.setBounds(17, size/2 -40,64 ,64);
            
            mpPedido.setBounds(0, 59 + size, 255, size);
            jLabel3.setBounds(105, size/2 - 15, 73, 26);
            jLabel4.setBounds(17, size/2 - 30, 64, 64);
            
            mpCaja.setBounds(0,59 + size*2,255,size);
            jLabel32.setBounds(105, size/2 - 15, 85, 26);
            jLabel33.setBounds(17, size/2 -40,64 ,64);
            
            mpReporte.setBounds(0,59 + size*3,255,size);
            jLabel7.setBounds(105, size/2 - 15, 85, 26);
            jLabel8.setBounds(17, size/2 - 40, 64, 64);
            
            
            mpBackup.setBounds(0,59 + size*4,255,size);
            jLabel37.setBounds(105, size/2 - 15,160 ,26);
            jLabel38.setBounds(17, size/2 - 40, 64, 64);
        }else if(id==2){
            vis = 3;
            size = (heightvar - pTop.getHeight())/vis;    
            //pMesas.setVisible(true);
            //mpMante.setVisible(true);
            //pUsuario.setVisible(true);
            //pTrabajador.setVisible(true);
            mpReporte.setVisible(true);
            mpPedido.setVisible(true);
            mpBackup.setVisible(true);
            //pCargo.setVisible(true);
            //pArea.setVisible(true);
            //pTrabajador.setLayout(null);
            mpPedido.setLayout(null);
            mpBackup.setLayout(null);
            mpReporte.setLayout(null);
            //pUsuario.setLayout(null);
            //pMesas.setLayout(null);
            //mpMante.setLayout(null);
            //pCargo.setLayout(null);
            //pArea.setLayout(null);
            
            /*pUsuario.setBounds(0, 59 ,255,size);
            jLabel9.setBounds(105, size/2 - 15, 95, 26);
            jLabel10.setBounds(17, size/2 - 30, 64, 64);
            
            pTrabajador.setBounds(0, 59 + size, 255,size);
            jLabel1.setBounds(105, size/2 - 20, 142, 26);
            jLabel2.setBounds(17, size/2 - 50, 64, 64);
            
            pMesas.setBounds(0, 59 + size*2, 255, size);
            jLabel11.setBounds(105, size/2 - 20,68 ,26);
            jLabel12.setBounds(17, size/2 - 40,64 ,64);*/
            /*
            mpMante.setBounds(0, 59, 255, size);
            jLabel13.setBounds(90, size/2 - 15,160 ,26);
            jLabel14.setBounds(17, size/2 -40,64 ,64);
            
            pCargo.setBounds(0, 59 + size*4, 255, size);
            jLabel16.setBounds(105, size/2 - 20,68 ,26);
            jLabel17.setBounds(17, size/2 - 40,64 ,64);
            
            pArea.setBounds(0, 59 + size*5, 255, size);
            jLabel18.setBounds(105, size/2 - 20,68 ,26);
            jLabel19.setBounds(17, size/2 - 40,64 ,64);
            */
            mpPedido.setBounds(0, 59, 255, size);
            jLabel3.setBounds(105, size/2 - 15, 73, 26);
            jLabel4.setBounds(17, size/2 - 30, 64, 64);
            
            mpReporte.setBounds(0,59 + size,255,size);
            jLabel7.setBounds(105, size/2 - 15, 85, 26);
            jLabel8.setBounds(17, size/2 - 40, 64, 64);
            
            
            mpBackup.setBounds(0,59 + size*2,255,size);
            jLabel37.setBounds(105, size/2 - 15,160 ,26);
            jLabel38.setBounds(17, size/2 - 40, 64, 64);
            
        }else{
            vis = 3;
            size = (heightvar - pTop.getHeight())/vis;
            mpCaja.setVisible(true);
            mpCaja.setLayout(null);
            mpBackup.setVisible(true);
            mpBackup.setLayout(null);
            mpReporte.setVisible(true);
            mpReporte.setLayout(null);
            mpCaja.setBounds(0,59,255,size);
            jLabel32.setBounds(105, size/2 - 15, 85, 26);
            jLabel33.setBounds(17, size/2 -40,64 ,64);
            mpReporte.setBounds(0,59 + size,255,size);
            jLabel7.setBounds(105, size/2 - 15, 85, 26);
            jLabel8.setBounds(17, size/2 - 40, 64, 64);
            mpBackup.setBounds(0,59 + size*2,255,size);
            jLabel37.setBounds(105, size/2 - 15,160 ,26);
            jLabel38.setBounds(17, size/2 - 40, 64, 64);
            //pMesas.setVisible(true);
            //mpPedido.setVisible(true);
            //mpPedido.setLayout(null);
            //pMesas.setLayout(null);
        
            //pMesas.setBounds(0, 59, 255, size);
            //jLabel11.setBounds(105, size/2 - 20,68 ,26);
            //jLabel12.setBounds(17, size/2 - 40,64 ,64);
            
            //mpPedido.setBounds(0, 59, 255, size);
            //jLabel3.setBounds(105, size/2 - 15, 73, 26);
            //jLabel4.setBounds(17, size/2 - 30, 64, 64);
        }
    }
    
    private void HoraL(){
        SimpleDateFormat hFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyy");
        javax.swing.Timer timer = new javax.swing.Timer (1000, new ActionListener () 
        { 
            public void actionPerformed(ActionEvent e) 
            {   
                String hora = hFormat.format(Time.valueOf(LocalTime.now())).toString();
                String fecha = dFormat.format(Date.valueOf(LocalDate.now())).toString();
                FHLbl.setText(fecha + " - " + hora);
             }
        }); 
        timer.start();
        
    }
    public void GBackup(){
        try{
                
                Runtime runtime = Runtime.getRuntime();
                File backupFile = new File("Backup_DondeAlfredo"
                        +"_"+ Date.valueOf(LocalDate.now()).toString() +".sql");
                System.out.println(backupFile.getAbsolutePath());
                FileWriter fw = new FileWriter(backupFile);
                Process child = runtime.exec(System.getProperty("user.dir") +"/UtilBD/mysqldump.exe " + "-h107.180.46.230 -P3306 -upruebabd -plasfijas123 "
                        + "-B sgr_ventas_da -R"
                        + ""); 
                InputStreamReader irs = new InputStreamReader(child.getInputStream());
                BufferedReader br = new BufferedReader(irs);

                String line;
                while( (line=br.readLine()) != null ) {
                    fw.write(line + "\n");
                }
                fw.close();
                irs.close();
                br.close();
                //C:\Users\AnibalMA\Documents\NetBeansProjects\PruebaShowDialog/UtilBD/mysqldump.exe -h107.180.46.230 -P3306 -upruebabd -plasfijas123 -B srg_ventas -R
                //Caja 123
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error no se genero el archivo por el siguiente motivo:"+e.getMessage(), "Verificar",JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "Backup Generado","Verificar",JOptionPane.INFORMATION_MESSAGE);
    }
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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FHLbl;
    private javax.swing.JLabel IconFH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jpContenedor;
    private javax.swing.JLabel lblSuc;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel mpBackup;
    private javax.swing.JPanel mpCaja;
    private javax.swing.JPanel mpCarta;
    private javax.swing.JPanel mpMante;
    private javax.swing.JPanel mpPedido;
    private javax.swing.JPanel mpReporte;
    private javax.swing.JPanel pArea;
    private javax.swing.JPanel pCargo;
    private javax.swing.JPanel pCategoria;
    private javax.swing.JPanel pCliente;
    private javax.swing.JPanel pComprobante;
    private javax.swing.JPanel pEmpresa;
    private javax.swing.JPanel pLocal;
    private javax.swing.JPanel pMesas;
    private javax.swing.JPanel pPiso;
    private javax.swing.JPanel pPlato;
    private javax.swing.JPanel pPlatoLocal;
    private javax.swing.JPanel pTop;
    private javax.swing.JPanel pTrabajador;
    private javax.swing.JPanel pUsuario;
    // End of variables declaration//GEN-END:variables
}
