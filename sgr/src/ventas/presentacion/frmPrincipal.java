
package ventas.presentacion;
import java.awt.Container;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JPanel;
import ventas.modelo.Login_User;
import ventas.presentacion.Empresa.jpEditarEmpresa;
import ventas.presentacion.Local.jpListaLocal;
import ventas.presentacion.Mesa.jpListarMesa;
import ventas.presentacion.Piso.jpListarPiso;
import ventas.presentacion.Trabajador.Mant_Trabajador;
import ventas.presentacion.Usuario.Mant_Usuarios;

public class frmPrincipal extends javax.swing.JFrame {
    public static JPanel nPanel;
    public static int widthvar, heightvar;
    public static Container c ;
    Login_User login_User= new Login_User();
    public frmPrincipal() {
        initComponents();
        c = getContentPane();
        getContentPane().setLayout(null);
        ventas.presentacion.Login frmL = new ventas.presentacion.Login();
        getContentPane().setLayout(null);
        setExtendedState(MAXIMIZED_BOTH);
        widthvar = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        heightvar = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        pTop.setLayout(null);
        pTop.setBounds(0,0,widthvar, 59);
        
        jpContenedor.setBounds(255, 59, widthvar - 255, heightvar-59);
        jpContenedor.setVisible(false);
        jLabel15.setLocation(800, 15);
        //jpContenedor.setBounds(255, 59, widthvar-255, heightvar-59);
        //Validar(login_User.nid_perfil);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pTop = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        pTrabajador = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        pPedido = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pCliente = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pMesas = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        pReporte = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pUsuario = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jpContenedor = new javax.swing.JPanel();
        pPiso = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        pProducts1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pLocal = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pCargo = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        pArea = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        pPlato = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        pCategoria = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        pComprobante = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        pCarta = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        pMenusistema = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        pPaltoLocal = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        pVenta = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        pReservacion = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        pEmpresa = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();

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

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Mantenimiento");

        javax.swing.GroupLayout pTopLayout = new javax.swing.GroupLayout(pTop);
        pTop.setLayout(pTopLayout);
        pTopLayout.setHorizontalGroup(
            pTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTopLayout.createSequentialGroup()
                .addGap(550, 550, 550)
                .addComponent(jLabel15)
                .addContainerGap(569, Short.MAX_VALUE))
        );
        pTopLayout.setVerticalGroup(
            pTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(pTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pTrabajador.setBackground(new java.awt.Color(24, 168, 255));
        pTrabajador.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pTrabajador.setPreferredSize(new java.awt.Dimension(255, 120));
        pTrabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pTrabajadorMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Trabajadores");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/worker.png"))); // NOI18N

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/users.png"))); // NOI18N

        javax.swing.GroupLayout pTrabajadorLayout = new javax.swing.GroupLayout(pTrabajador);
        pTrabajador.setLayout(pTrabajadorLayout);
        pTrabajadorLayout.setHorizontalGroup(
            pTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTrabajadorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(24, 24, 24))
        );
        pTrabajadorLayout.setVerticalGroup(
            pTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTrabajadorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTrabajadorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel1))
                .addGap(41, 41, 41))
        );

        getContentPane().add(pTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 179, 255, 120));

        pPedido.setBackground(new java.awt.Color(24, 168, 255));
        pPedido.setPreferredSize(new java.awt.Dimension(255, 120));
        pPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pPedidoMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pedido");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout pPedidoLayout = new javax.swing.GroupLayout(pPedido);
        pPedido.setLayout(pPedidoLayout);
        pPedidoLayout.setHorizontalGroup(
            pPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPedidoLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(63, 63, 63))
        );
        pPedidoLayout.setVerticalGroup(
            pPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPedidoLayout.createSequentialGroup()
                .addGroup(pPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPedidoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(pPedidoLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
        );

        jLabel4.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(pPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, -1, -1));

        pCliente.setBackground(new java.awt.Color(24, 168, 255));
        pCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pCliente.setPreferredSize(new java.awt.Dimension(255, 120));
        pCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pClienteMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cliente");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout pClienteLayout = new javax.swing.GroupLayout(pCliente);
        pCliente.setLayout(pClienteLayout);
        pClienteLayout.setHorizontalGroup(
            pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pClienteLayout.createSequentialGroup()
                .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14))
                    .addGroup(pClienteLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        pClienteLayout.setVerticalGroup(
            pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pClienteLayout.createSequentialGroup()
                .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pClienteLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel13))
                    .addGroup(pClienteLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel14)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        getContentPane().add(pCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 780, -1, -1));

        pMesas.setBackground(new java.awt.Color(24, 168, 255));
        pMesas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pMesas.setPreferredSize(new java.awt.Dimension(255, 120));
        pMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pMesasMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mesas");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/t2.png"))); // NOI18N

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/users.png"))); // NOI18N

        javax.swing.GroupLayout pMesasLayout = new javax.swing.GroupLayout(pMesas);
        pMesas.setLayout(pMesasLayout);
        pMesasLayout.setHorizontalGroup(
            pMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMesasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel45))
                .addGap(12, 12, 12)
                .addComponent(jLabel11)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        pMesasLayout.setVerticalGroup(
            pMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMesasLayout.createSequentialGroup()
                .addGroup(pMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMesasLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45))
                    .addGroup(pMesasLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel11)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(pMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 299, -1, -1));

        pReporte.setBackground(new java.awt.Color(24, 168, 255));
        pReporte.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pReporte.setPreferredSize(new java.awt.Dimension(255, 120));
        pReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pReporteMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Reporte");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/rpt.png"))); // NOI18N

        javax.swing.GroupLayout pReporteLayout = new javax.swing.GroupLayout(pReporte);
        pReporte.setLayout(pReporteLayout);
        pReporteLayout.setHorizontalGroup(
            pReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pReporteLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        pReporteLayout.setVerticalGroup(
            pReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReporteLayout.createSequentialGroup()
                .addGroup(pReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pReporteLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel8))
                    .addGroup(pReporteLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel7)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(pReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 539, -1, -1));

        pUsuario.setBackground(new java.awt.Color(24, 168, 255));
        pUsuario.setPreferredSize(new java.awt.Dimension(255, 120));
        pUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pUsuarioMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(41, 41, 41))
        );
        pUsuarioLayout.setVerticalGroup(
            pUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(45, 45, 45))
            .addGroup(pUsuarioLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel10)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(pUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 59, -1, -1));

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

        pPiso.setBackground(new java.awt.Color(24, 168, 255));
        pPiso.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pPiso.setPreferredSize(new java.awt.Dimension(255, 120));
        pPiso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pPisoMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Piso");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/users.png"))); // NOI18N

        javax.swing.GroupLayout pPisoLayout = new javax.swing.GroupLayout(pPiso);
        pPiso.setLayout(pPisoLayout);
        pPisoLayout.setHorizontalGroup(
            pPisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPisoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel46))
                .addGap(13, 13, 13)
                .addComponent(jLabel18)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        pPisoLayout.setVerticalGroup(
            pPisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPisoLayout.createSequentialGroup()
                .addGroup(pPisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPisoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel18))
                    .addGroup(pPisoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel46)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(pPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 419, -1, -1));

        pProducts1.setBackground(new java.awt.Color(24, 168, 255));
        pProducts1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pProducts1.setPreferredSize(new java.awt.Dimension(255, 120));
        pProducts1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pProducts1MouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Empresa");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        javax.swing.GroupLayout pProducts1Layout = new javax.swing.GroupLayout(pProducts1);
        pProducts1.setLayout(pProducts1Layout);
        pProducts1Layout.setHorizontalGroup(
            pProducts1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pProducts1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(61, 61, 61)
                .addComponent(jLabel16)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pProducts1Layout.setVerticalGroup(
            pProducts1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProducts1Layout.createSequentialGroup()
                .addGroup(pProducts1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pProducts1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel16))
                    .addGroup(pProducts1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel17)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(pProducts1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 79, -1, -1));

        pLocal.setBackground(new java.awt.Color(24, 168, 255));
        pLocal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pLocal.setPreferredSize(new java.awt.Dimension(255, 120));
        pLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pLocalMouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Local");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout pLocalLayout = new javax.swing.GroupLayout(pLocal);
        pLocal.setLayout(pLocalLayout);
        pLocalLayout.setHorizontalGroup(
            pLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLocalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLocalLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLocalLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jLabel20)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        pLocalLayout.setVerticalGroup(
            pLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLocalLayout.createSequentialGroup()
                .addGroup(pLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLocalLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel20))
                    .addGroup(pLocalLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel21)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(pLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 900, -1, -1));

        pCargo.setBackground(new java.awt.Color(24, 168, 255));
        pCargo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pCargo.setPreferredSize(new java.awt.Dimension(255, 120));
        pCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pCargoMouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Cargo");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout pCargoLayout = new javax.swing.GroupLayout(pCargo);
        pCargo.setLayout(pCargoLayout);
        pCargoLayout.setHorizontalGroup(
            pCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCargoLayout.createSequentialGroup()
                .addGroup(pCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCargoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23))
                    .addGroup(pCargoLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel47)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        pCargoLayout.setVerticalGroup(
            pCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCargoLayout.createSequentialGroup()
                .addGroup(pCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCargoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel22))
                    .addGroup(pCargoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel23)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel47)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(pCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1020, -1, -1));

        pArea.setBackground(new java.awt.Color(24, 168, 255));
        pArea.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pArea.setPreferredSize(new java.awt.Dimension(255, 120));
        pArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pAreaMouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Area");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout pAreaLayout = new javax.swing.GroupLayout(pArea);
        pArea.setLayout(pAreaLayout);
        pAreaLayout.setHorizontalGroup(
            pAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAreaLayout.createSequentialGroup()
                .addGroup(pAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pAreaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25))
                    .addGroup(pAreaLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel48)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        pAreaLayout.setVerticalGroup(
            pAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAreaLayout.createSequentialGroup()
                .addGroup(pAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pAreaLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel24))
                    .addGroup(pAreaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel25)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel48)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        getContentPane().add(pArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1140, -1, -1));

        pPlato.setBackground(new java.awt.Color(24, 168, 255));
        pPlato.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pPlato.setPreferredSize(new java.awt.Dimension(255, 120));
        pPlato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pPlatoMouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Plato");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout pPlatoLayout = new javax.swing.GroupLayout(pPlato);
        pPlato.setLayout(pPlatoLayout);
        pPlatoLayout.setHorizontalGroup(
            pPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPlatoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPlatoLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addGap(97, 97, 97))
        );
        pPlatoLayout.setVerticalGroup(
            pPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPlatoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel27)
                .addGroup(pPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPlatoLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel26)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPlatoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel49)
                        .addGap(34, 34, 34))))
        );

        getContentPane().add(pPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1260, -1, -1));

        pCategoria.setBackground(new java.awt.Color(24, 168, 255));
        pCategoria.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pCategoria.setPreferredSize(new java.awt.Dimension(255, 120));
        pCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pCategoriaMouseClicked(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Categoria");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout pCategoriaLayout = new javax.swing.GroupLayout(pCategoria);
        pCategoria.setLayout(pCategoriaLayout);
        pCategoriaLayout.setHorizontalGroup(
            pCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCategoriaLayout.createSequentialGroup()
                .addGroup(pCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCategoriaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel29))
                    .addGroup(pCategoriaLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel50)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pCategoriaLayout.setVerticalGroup(
            pCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCategoriaLayout.createSequentialGroup()
                .addGroup(pCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCategoriaLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel28))
                    .addGroup(pCategoriaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel29)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel50)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(pCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1380, -1, -1));

        pComprobante.setBackground(new java.awt.Color(24, 168, 255));
        pComprobante.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pComprobante.setPreferredSize(new java.awt.Dimension(255, 120));
        pComprobante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pComprobanteMouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Comprobante");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout pComprobanteLayout = new javax.swing.GroupLayout(pComprobante);
        pComprobante.setLayout(pComprobanteLayout);
        pComprobanteLayout.setHorizontalGroup(
            pComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pComprobanteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pComprobanteLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30)
                .addContainerGap())
        );
        pComprobanteLayout.setVerticalGroup(
            pComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pComprobanteLayout.createSequentialGroup()
                .addGroup(pComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pComprobanteLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel31)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel51))
                    .addGroup(pComprobanteLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel30)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(pComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1500, -1, -1));

        pCarta.setBackground(new java.awt.Color(24, 168, 255));
        pCarta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pCarta.setPreferredSize(new java.awt.Dimension(255, 120));
        pCarta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pCartaMouseClicked(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Carta");

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout pCartaLayout = new javax.swing.GroupLayout(pCarta);
        pCarta.setLayout(pCartaLayout);
        pCartaLayout.setHorizontalGroup(
            pCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCartaLayout.createSequentialGroup()
                .addGroup(pCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCartaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33))
                    .addGroup(pCartaLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel54)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        pCartaLayout.setVerticalGroup(
            pCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCartaLayout.createSequentialGroup()
                .addGroup(pCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCartaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel33)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel54))
                    .addGroup(pCartaLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel32)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(pCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1860, -1, -1));

        pMenusistema.setBackground(new java.awt.Color(24, 168, 255));
        pMenusistema.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pMenusistema.setPreferredSize(new java.awt.Dimension(255, 120));
        pMenusistema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pMenusistemaMouseClicked(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("<html>Menu De<br> \nSistema</html>");

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout pMenusistemaLayout = new javax.swing.GroupLayout(pMenusistema);
        pMenusistema.setLayout(pMenusistemaLayout);
        pMenusistemaLayout.setHorizontalGroup(
            pMenusistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMenusistemaLayout.createSequentialGroup()
                .addGroup(pMenusistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMenusistemaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel35))
                    .addGroup(pMenusistemaLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel53)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        pMenusistemaLayout.setVerticalGroup(
            pMenusistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMenusistemaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pMenusistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addGroup(pMenusistemaLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel53)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel34.getAccessibleContext().setAccessibleName("Menu Del\nSistema");

        getContentPane().add(pMenusistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1740, -1, -1));

        pPaltoLocal.setBackground(new java.awt.Color(24, 168, 255));
        pPaltoLocal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pPaltoLocal.setPreferredSize(new java.awt.Dimension(255, 120));
        pPaltoLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pPaltoLocalMouseClicked(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Plato Por Local");

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout pPaltoLocalLayout = new javax.swing.GroupLayout(pPaltoLocal);
        pPaltoLocal.setLayout(pPaltoLocalLayout);
        pPaltoLocalLayout.setHorizontalGroup(
            pPaltoLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPaltoLocalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPaltoLocalLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addContainerGap())
        );
        pPaltoLocalLayout.setVerticalGroup(
            pPaltoLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPaltoLocalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel37)
                .addGroup(pPaltoLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPaltoLocalLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel36))
                    .addGroup(pPaltoLocalLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel52)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(pPaltoLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1620, -1, -1));

        pVenta.setBackground(new java.awt.Color(24, 168, 255));
        pVenta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pVenta.setPreferredSize(new java.awt.Dimension(255, 120));
        pVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pVentaMouseClicked(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Venta");

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout pVentaLayout = new javax.swing.GroupLayout(pVenta);
        pVenta.setLayout(pVentaLayout);
        pVentaLayout.setHorizontalGroup(
            pVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addGroup(pVentaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel56)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        pVentaLayout.setVerticalGroup(
            pVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVentaLayout.createSequentialGroup()
                .addGroup(pVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pVentaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel39)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel56))
                    .addGroup(pVentaLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel38)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(pVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2100, -1, -1));

        pReservacion.setBackground(new java.awt.Color(24, 168, 255));
        pReservacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pReservacion.setPreferredSize(new java.awt.Dimension(255, 120));
        pReservacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pReservacionMouseClicked(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Reservación");

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout pReservacionLayout = new javax.swing.GroupLayout(pReservacion);
        pReservacion.setLayout(pReservacionLayout);
        pReservacionLayout.setHorizontalGroup(
            pReservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pReservacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pReservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addGroup(pReservacionLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel55)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addGap(23, 23, 23))
        );
        pReservacionLayout.setVerticalGroup(
            pReservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReservacionLayout.createSequentialGroup()
                .addGroup(pReservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pReservacionLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel41)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel55))
                    .addGroup(pReservacionLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel40)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        getContentPane().add(pReservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1980, -1, -1));

        pEmpresa.setBackground(new java.awt.Color(24, 168, 255));
        pEmpresa.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(61, 217, 237)));
        pEmpresa.setPreferredSize(new java.awt.Dimension(255, 120));
        pEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pEmpresaMouseClicked(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Empresa");

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stairs.png"))); // NOI18N

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list.png"))); // NOI18N

        javax.swing.GroupLayout pEmpresaLayout = new javax.swing.GroupLayout(pEmpresa);
        pEmpresa.setLayout(pEmpresaLayout);
        pEmpresaLayout.setHorizontalGroup(
            pEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pEmpresaLayout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEmpresaLayout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel42)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        pEmpresaLayout.setVerticalGroup(
            pEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEmpresaLayout.createSequentialGroup()
                .addGroup(pEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pEmpresaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel43)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel57))
                    .addGroup(pEmpresaLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel42)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(pEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2220, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pTrabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pTrabajadorMouseClicked
        pTrabajador.setBackground(new java.awt.Color(255,51,51));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pReporte.setBackground(new java.awt.Color(24,168,255));
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pMenusistema.setBackground(new java.awt.Color(24,168,255));
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));
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
    }//GEN-LAST:event_pTrabajadorMouseClicked

    private void pPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pPedidoMouseClicked
        pPedido.setBackground(new java.awt.Color(24,168,255));
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pReporte.setBackground(new java.awt.Color(24,168,255));
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));        
    }//GEN-LAST:event_pPedidoMouseClicked
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
        }
    }
    private void pReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pReporteMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pReporte.setBackground(new java.awt.Color(255,51,51));
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pMenusistema.setBackground(new java.awt.Color(24,168,255));
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));
        try {
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new jpEditarEmpresa();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pReporteMouseClicked

    private void pUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pUsuarioMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(255,51,51));
        pReporte.setBackground(new java.awt.Color(24,168,255));
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pMenusistema.setBackground(new java.awt.Color(24,168,255));
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));
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
       pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pReporte.setBackground(new java.awt.Color(24,168,255));
        pMesas.setBackground(new java.awt.Color(255,51,51));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pMenusistema.setBackground(new java.awt.Color(24,168,255));
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));
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

    private void pClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pClienteMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pReporte.setBackground(new java.awt.Color(24,168,255));
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(255,51,51));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pMenusistema.setBackground(new java.awt.Color(24,168,255));
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));
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
    }//GEN-LAST:event_pClienteMouseClicked

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
       
    }//GEN-LAST:event_formWindowStateChanged

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized

    }//GEN-LAST:event_formComponentResized

    private void pProducts1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pProducts1MouseClicked

    }//GEN-LAST:event_pProducts1MouseClicked

    private void pLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pLocalMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pReporte.setBackground(new java.awt.Color(24,168,255));
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(255,51,51));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pMenusistema.setBackground(new java.awt.Color(24,168,255));
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));
        try {
            if(nPanel != null){
                getContentPane().remove(nPanel);
                getContentPane().repaint();
            }
            nPanel = new jpListaLocal();
            nPanel.setBounds(255,59, widthvar-255, heightvar-59);
        
            getContentPane().add(nPanel);
            this.validate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pLocalMouseClicked

    private void pPisoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pPisoMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pReporte.setBackground(new java.awt.Color(24,168,255));
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(255,51,51));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pMenusistema.setBackground(new java.awt.Color(24,168,255));
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));
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

    private void pCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pCargoMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pReporte.setBackground(new java.awt.Color(24,168,255));
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(255,51,51));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pMenusistema.setBackground(new java.awt.Color(24,168,255));
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));
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
    }//GEN-LAST:event_pCargoMouseClicked

    private void pAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pAreaMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));        
        pUsuario.setBackground(new java.awt.Color(24,168,255));        
        pReporte.setBackground(new java.awt.Color(24,168,255));        
        pMesas.setBackground(new java.awt.Color(24,168,255));        
        pCliente.setBackground(new java.awt.Color(24,168,255));        
        pPiso.setBackground(new java.awt.Color(24,168,255));        
        pLocal.setBackground(new java.awt.Color(24,168,255));        
        pEmpresa.setBackground(new java.awt.Color(24,168,255));        
        pCargo.setBackground(new java.awt.Color(24,168,255));        
        pArea.setBackground(new java.awt.Color(255,51,51));        
        pPlato.setBackground(new java.awt.Color(24,168,255));        
        pCategoria.setBackground(new java.awt.Color(24,168,255));        
        pComprobante.setBackground(new java.awt.Color(24,168,255));        
        pMenusistema.setBackground(new java.awt.Color(24,168,255));        
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));        
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
    }//GEN-LAST:event_pAreaMouseClicked

    private void pPlatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pPlatoMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));        
        pUsuario.setBackground(new java.awt.Color(24,168,255));        
        pReporte.setBackground(new java.awt.Color(24,168,255));        
        pMesas.setBackground(new java.awt.Color(24,168,255));        
        pCliente.setBackground(new java.awt.Color(24,168,255));        
        pPiso.setBackground(new java.awt.Color(24,168,255));        
        pLocal.setBackground(new java.awt.Color(24,168,255));        
        pEmpresa.setBackground(new java.awt.Color(24,168,255));        
        pCargo.setBackground(new java.awt.Color(24,168,255));        
        pArea.setBackground(new java.awt.Color(24,168,255));        
        pPlato.setBackground(new java.awt.Color(255,51,51));        
        pCategoria.setBackground(new java.awt.Color(24,168,255));        
        pComprobante.setBackground(new java.awt.Color(24,168,255));        
        pMenusistema.setBackground(new java.awt.Color(24,168,255));        
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));        
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
    }//GEN-LAST:event_pPlatoMouseClicked

    private void pCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pCategoriaMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pReporte.setBackground(new java.awt.Color(24,168,255));
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(255,51,51));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pMenusistema.setBackground(new java.awt.Color(24,168,255));
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));
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
    }//GEN-LAST:event_pCategoriaMouseClicked

    private void pComprobanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pComprobanteMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pReporte.setBackground(new java.awt.Color(24,168,255));
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(255,51,51));
        pMenusistema.setBackground(new java.awt.Color(24,168,255));
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));
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
    }//GEN-LAST:event_pComprobanteMouseClicked

    private void pCartaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pCartaMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pReporte.setBackground(new java.awt.Color(24,168,255));
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pMenusistema.setBackground(new java.awt.Color(24,168,255));
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));
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
    }//GEN-LAST:event_pCartaMouseClicked

    private void pMenusistemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMenusistemaMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pReporte.setBackground(new java.awt.Color(24,168,255));
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pMenusistema.setBackground(new java.awt.Color(255,51,51));
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));
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
    }//GEN-LAST:event_pMenusistemaMouseClicked

    private void pPaltoLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pPaltoLocalMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));
        pUsuario.setBackground(new java.awt.Color(24,168,255));
        pReporte.setBackground(new java.awt.Color(24,168,255));
        pMesas.setBackground(new java.awt.Color(24,168,255));
        pCliente.setBackground(new java.awt.Color(24,168,255));
        pPiso.setBackground(new java.awt.Color(24,168,255));
        pLocal.setBackground(new java.awt.Color(24,168,255));
        pEmpresa.setBackground(new java.awt.Color(24,168,255));
        pCargo.setBackground(new java.awt.Color(24,168,255));
        pArea.setBackground(new java.awt.Color(24,168,255));
        pPlato.setBackground(new java.awt.Color(24,168,255));
        pCategoria.setBackground(new java.awt.Color(24,168,255));
        pComprobante.setBackground(new java.awt.Color(24,168,255));
        pMenusistema.setBackground(new java.awt.Color(24,168,255));
        pPaltoLocal.setBackground(new java.awt.Color(255,51,51));
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
    }//GEN-LAST:event_pPaltoLocalMouseClicked

    private void pVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pVentaMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));        
        pUsuario.setBackground(new java.awt.Color(24,168,255));        
        pReporte.setBackground(new java.awt.Color(24,168,255));        
        pMesas.setBackground(new java.awt.Color(24,168,255));        
        pCliente.setBackground(new java.awt.Color(24,168,255));        
        pPiso.setBackground(new java.awt.Color(24,168,255));        
        pLocal.setBackground(new java.awt.Color(24,168,255));        
        pEmpresa.setBackground(new java.awt.Color(24,168,255));        
        pCargo.setBackground(new java.awt.Color(24,168,255));        
        pArea.setBackground(new java.awt.Color(24,168,255));        
        pPlato.setBackground(new java.awt.Color(24,168,255));        
        pCategoria.setBackground(new java.awt.Color(24,168,255));        
        pComprobante.setBackground(new java.awt.Color(24,168,255));        
        pMenusistema.setBackground(new java.awt.Color(24,168,255));        
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));        
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
    }//GEN-LAST:event_pVentaMouseClicked

    private void pReservacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pReservacionMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));        
        pUsuario.setBackground(new java.awt.Color(24,168,255));        
        pReporte.setBackground(new java.awt.Color(24,168,255));        
        pMesas.setBackground(new java.awt.Color(24,168,255));        
        pCliente.setBackground(new java.awt.Color(24,168,255));        
        pPiso.setBackground(new java.awt.Color(24,168,255));        
        pLocal.setBackground(new java.awt.Color(24,168,255));        
        pEmpresa.setBackground(new java.awt.Color(24,168,255));        
        pCargo.setBackground(new java.awt.Color(24,168,255));        
        pArea.setBackground(new java.awt.Color(24,168,255));        
        pPlato.setBackground(new java.awt.Color(24,168,255));        
        pCategoria.setBackground(new java.awt.Color(24,168,255));        
        pComprobante.setBackground(new java.awt.Color(24,168,255));        
        pMenusistema.setBackground(new java.awt.Color(24,168,255));        
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));        
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
    }//GEN-LAST:event_pReservacionMouseClicked

    private void pEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pEmpresaMouseClicked
        pTrabajador.setBackground(new java.awt.Color(24,168,255));        
        pUsuario.setBackground(new java.awt.Color(24,168,255));        
        pReporte.setBackground(new java.awt.Color(24,168,255));        
        pMesas.setBackground(new java.awt.Color(24,168,255));        
        pCliente.setBackground(new java.awt.Color(24,168,255));        
        pPiso.setBackground(new java.awt.Color(24,168,255));        
        pLocal.setBackground(new java.awt.Color(24,168,255));        
        pEmpresa.setBackground(new java.awt.Color(255,51,51));        
        pCargo.setBackground(new java.awt.Color(24,168,255));        
        pArea.setBackground(new java.awt.Color(24,168,255));        
        pPlato.setBackground(new java.awt.Color(24,168,255));        
        pCategoria.setBackground(new java.awt.Color(24,168,255));        
        pComprobante.setBackground(new java.awt.Color(24,168,255));        
        pMenusistema.setBackground(new java.awt.Color(24,168,255));        
        pPaltoLocal.setBackground(new java.awt.Color(24,168,255));        
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
    }//GEN-LAST:event_pEmpresaMouseClicked
    public void Validar(int id){
        int vis = 6;
        int size = 0;
        
        /*if(id == 1){
            System.out.println("no");
            vis = 5;
            size = (heightvar - pTop.getHeight())/vis;    
            pMesas.setVisible(true);
            pLocal.setVisible(true);
            pReporte.setVisible(true);
            pUsuario.setVisible(true);
            pPiso.setVisible(true);
            pPedido.setVisible(true);
            pPiso.setLayout(null);
            pPedido.setLayout(null);
            pUsuario.setLayout(null);
            pReporte.setLayout(null);
            pMesas.setLayout(null);
            pLocal.setLayout(null);

            pMesas.setBounds(0, 59, 250,size);
            jLabel1.setBounds(110, size/2 - 20, 57, 26);
            jLabel2.setBounds(36, size/2 - 50, 82, 77);
            //System.out.println(pMenu.getLocation().toString());

            pPedido.setBounds(0, 59 + size, 250, size);
            jLabel3.setBounds(110, size/2 - 20, 73, 26);
            jLabel4.setBounds(36, size/2 - 30, 48, 48);
            //System.out.println(pPedido.getLocation().toString());

            pUsuario.setBounds(0, 59 + size*2,250,size);
            jLabel9.setBounds(110, size/2 - 20, 95, 26);
            jLabel10.setBounds(36, size/2 - 30, 48, 48);
           // System.out.println(pUsuario.getLocation().toString());

            pReporte.setBounds(0,59 + size*3,250,size);
            jLabel7.setBounds(110, size/2 - 20, 85, 26);
            jLabel8.setBounds(36, size/2 - 40, 64, 64);
            //System.out.println(pReporte.getLocation().toString());

            pLocal.setBounds(0, 59 + size*4, 250, size);
            jLabel11.setBounds(110, size/2 - 20,68 ,26);
            jLabel12.setBounds(36, size/2 - 40,64 ,64);
           // System.out.println(pMesas.getLocation().toString());

            pPiso.setBounds(0, 59 + size*5, 250, size);
            jLabel13.setBounds(110, size/2 - 20,109 ,26);
            jLabel14.setBounds(36, size/2 -40,64 ,64);
            //System.out.println(pProducts.getLocation().toString());

        }else if(id==2){
            vis = 5;
            size = (heightvar - pTop.getHeight())/vis;    
            pMesas.setVisible(true);
            pProducts.setVisible(true);
            //pReporte.setVisible(true);
            pUsuario.setVisible(true);
            pMenu.setLayout(null);
            pPedido.setLayout(null);
            pUsuario.setLayout(null);
            //pReporte.setLayout(null);
            pMesas.setLayout(null);
            pProducts.setLayout(null);

            pMenu.setBounds(0, 59, 250,size);
            jLabel1.setBounds(110, size/2 - 20, 57, 26);
            jLabel2.setBounds(36, size/2 - 50, 82, 77);
            //System.out.println(pMenu.getLocation().toString());

            pPedido.setBounds(0, 59 + size, 250, size);
            jLabel3.setBounds(110, size/2 - 20, 73, 26);
            jLabel4.setBounds(36, size/2 - 30, 48, 48);
            //System.out.println(pPedido.getLocation().toString());

            pUsuario.setBounds(0, 59 + size*2,250,size);
            jLabel9.setBounds(110, size/2 - 20, 95, 26);
            jLabel10.setBounds(36, size/2 - 30, 48, 48);
           // System.out.println(pUsuario.getLocation().toString());

            pMesas.setBounds(0, 59 + size*3, 250, size);
            jLabel11.setBounds(110, size/2 - 20,68 ,26);
            jLabel12.setBounds(36, size/2 - 40,64 ,64);
           // System.out.println(pMesas.getLocation().toString());

            pProducts.setBounds(0, 59 + size*4, 250, size);
            jLabel13.setBounds(110, size/2 - 20,109 ,26);
            jLabel14.setBounds(36, size/2 -40,64 ,64);
            //System.out.println(pProducts.getLocation().toString());

        }else{
            vis = 2;
            size = (heightvar - pTop.getHeight())/vis;
        pMesas.setVisible(false);
        pProducts.setVisible(false);
        pReporte.setVisible(false);
        pUsuario.setVisible(false);
        pMenu.setLayout(null);
        pPedido.setLayout(null);
         pMenu.setBounds(0, 59, 250,size);
        jLabel1.setBounds(110, size/2 - 20, 57, 26);
        jLabel2.setBounds(36, size/2 - 50, 82, 77);
       // System.out.println(pMenu.getLocation().toString());
        
        pPedido.setBounds(0, 59 + size, 250, size);
        jLabel3.setBounds(110, size/2 - 20, 73, 26);
        jLabel4.setBounds(36, size/2 - 30, 48, 48);
        //System.out.println(pPedido.getLocation().toString());
        }*/
    }
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
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
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jpContenedor;
    private javax.swing.JPanel pArea;
    private javax.swing.JPanel pCargo;
    private javax.swing.JPanel pCarta;
    private javax.swing.JPanel pCategoria;
    private javax.swing.JPanel pCliente;
    private javax.swing.JPanel pComprobante;
    private javax.swing.JPanel pEmpresa;
    private javax.swing.JPanel pLocal;
    private javax.swing.JPanel pMenusistema;
    private javax.swing.JPanel pMesas;
    private javax.swing.JPanel pPaltoLocal;
    private javax.swing.JPanel pPedido;
    private javax.swing.JPanel pPiso;
    private javax.swing.JPanel pPlato;
    private javax.swing.JPanel pProducts1;
    private javax.swing.JPanel pReporte;
    private javax.swing.JPanel pReservacion;
    private javax.swing.JPanel pTop;
    private javax.swing.JPanel pTrabajador;
    private javax.swing.JPanel pUsuario;
    private javax.swing.JPanel pVenta;
    // End of variables declaration//GEN-END:variables
}
