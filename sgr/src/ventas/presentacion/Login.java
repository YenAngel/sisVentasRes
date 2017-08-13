
package ventas.presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;
import ventas.persistencia.util.BDUtil;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import jdk.nashorn.internal.parser.TokenType;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.persistencia.util.BD_RS;
import ventas.persistencia.util.EN_DES;

public class Login extends javax.swing.JFrame {
    
    Login_User usuario=new Login_User();
    private int count=0;
    public static JTextField j;
    public static JDialog jd = new JDialog();
    public  Teclado t = new Teclado(this);
    public static JDialog AC;
    public Login() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        Img p = new Img();
        p.setBorder(new EmptyBorder(5, 5, 5, 5));
        p.setLayout(new BorderLayout(0, 0));
        p.setBackground(this.getClass().getResource("/recursos/fondopersonalizado720_filtro.jpg").getPath());
        setContentPane(p);  
        initComponents();
        AC = new JDialog();
        frmAperturarCaja aperturarCaja = new frmAperturarCaja(AC);
        AC.add(aperturarCaja.getContentPane());
        AC.setModal(true);
        AC.setResizable(false);
        AC.setSize(aperturarCaja.getSize());
        AC.setLocationRelativeTo(null);
        AC.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //jPanel1.setOpaque(false);
        //jPanel1.setBackground(this.getClass().getResource("/recursos/fondopersonalizado720_filtro.jpg").getPath());
        setLocationRelativeTo(null);
        jd.add(t.getContentPane());
        jd.setSize(970, 275);
        jd.setLocation(new Point(30+getLocation().x, 453));
        jd.setResizable(false);
        jd.setAlwaysOnTop(true);
        Dimension d = super.getToolkit().getScreenSize();
        jPanel1.setSize(d.width,lblEstado.getHeight());
        jPanel1.setLocation(0, d.height-60);
        //jd.setModal(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        //setSize(super.getToolkit().getScreenSize());
        jLabel5.setLocation(d.width-290, 10);
        //setUndecorated(true);
        /*System.out.println(this.getSize().width + ";" + this.getSize().height);
        System.out.println(this.getPreferredSize().toString());
        System.out.println(getWidth() + ":::" + getHeight());
        try {
            System.out.println(EN_DES.Encrypt_S("123"));
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        jd.setLocationRelativeTo(null);
        cboSucursal.setModel(BD_RS.ListarCBOLocal());
        ((JLabel)cboSucursal.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        init();
       // jLabel8.setLocation(0,0);
        //jLabel8.setSize(new Dimension(d.width,d.height-60));
        
        
        //ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/recursos/fondopersonalizado720_filtro.jpg"));
        
        //Icon icon= new ImageIcon(imageIcon.getImage().getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), Image.SCALE_DEFAULT));
        
        //g.drawImage(imageIcon.getImage(),0,0,d.width, d.height, null);
        //jLabel8.setIcon(icon);
        //jLabel8.paint(g);
        //jPanel1.repaint();
        
        
        
        
        //System.out.println(getWidth() + "@" + getHeight());
        //System.out.println(this.getLocation().x + "@" + this.getLocation().y);
        
    }

    private void init(){
        txtPassword.setEchoChar((char)0);
        txtPassword.setText("Ingresar Password");                
        txtUsuario.setText("Ingresar Usuario");
        txtPassword.requestFocus(false);
        txtUsuario.requestFocus(false);
        btnAceptar.requestFocus(false);
        //Login frm = new Login();
        //frm.setExtendedState();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnAceptar = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboSucursal = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAceptar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logo_new_DA.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(500, 40, 660, 150);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sistema para Restaurante v1.0");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(890, 10, 290, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/sub.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(500, 20, 650, 410);

        jPanel2.setBackground(new java.awt.Color(137, 197, 255));
        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel2FocusGained(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 263, -1));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 263, -1));

        btnAceptar.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        btnAceptar.setFont(new java.awt.Font("DokChampa", 1, 18)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/login.png"))); // NOI18N
        btnAceptar.setText("Acceder");
        btnAceptar.setBorder(null);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 180, 90));

        txtPassword.setBackground(new java.awt.Color(68, 134, 187));
        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(null);
        txtPassword.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        txtPassword.setSelectionColor(new java.awt.Color(204, 204, 0));
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 263, 51));

        txtUsuario.setBackground(new java.awt.Color(68, 134, 187));
        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(null);
        txtUsuario.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        txtUsuario.setSelectionColor(new java.awt.Color(204, 204, 0));
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
        });
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseClicked(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 263, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/userlog.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/pass1.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        cboSucursal.setBackground(new java.awt.Color(204, 204, 255));
        cboSucursal.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cboSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "      Sucursal 1", "      Sucursal 2", "      Sucursal 3" }));
        jPanel2.add(cboSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 263, 51));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/suc1.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/is2.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 240, 90));

        btnAceptar1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        btnAceptar1.setFont(new java.awt.Font("DokChampa", 1, 18)); // NOI18N
        btnAceptar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logout.png"))); // NOI18N
        btnAceptar1.setText(" Salir");
        btnAceptar1.setBorder(null);
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 180, 90));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(60, 36, 430, 570);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout());

        lblEstado.setBackground(new java.awt.Color(255, 255, 255));
        lblEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEstado.setText("Recuerde: Solo tiene 3 intentos para acceder al sistema.");
        jPanel1.add(lblEstado);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 710, 1030, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
       
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
             
        if (txtPassword.getPassword().length<=0) {
            txtPassword.setEditable(false);
            txtPassword.setEchoChar((char)0);
            txtPassword.setText("Ingresar Password");
        }
        if (txtUsuario.getText().equals("Ingresar Usuario")) {
            txtUsuario.setText("");
        }
        
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void jPanel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusGained
        
    }//GEN-LAST:event_jPanel2FocusGained

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        //txtPassword.setEditable(false);
        if (txtUsuario.getText().length()<=0) {
            txtUsuario.setText("Ingresar Usuario");
        }
        if (txtPassword.getText().equals("Ingresar Password")) {
            txtPassword.setText("");
            txtPassword.setEditable(true);
            txtPassword.setEchoChar('\u25cf');
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
      
    }//GEN-LAST:event_txtPasswordActionPerformed
    private void getStatus(String status){
        //String path = "D:/sisVentasRes/sgr/src/recursos/"+status+".png";
        //URL url = this.getClass().getResource(path);
        if (!status.equals("")) {
            ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/recursos/"+status+".png"));
            Icon icon= new ImageIcon(imageIcon.getImage());
            lblEstado.setIcon(icon);
            if (status.startsWith("success")) {
                lblEstado.setText("Bienvenido al sistema...");
            }else if (status.startsWith("warning")) {
                lblEstado.setText("Advertencia: Intento fallido ingrese la contraseña y usuario correctamente.");
            }else if (status.startsWith("error"))
                lblEstado.setText("Usted ha superado el limite de intentos.");

            this.repaint();
        }        
    }
    private void validUser(Login_User login_User){                
        try {
            ResultSet rs = BDData.user(login_User);                
                while(rs.next()) {
                    usuario.setNdi_usuario(rs.getInt(1));                
                    usuario.setNid_perfil(rs.getInt(2));
                   BD_RS.idUserLog = rs.getInt(1);
                   BD_RS.dniUserLog = BD_RS.GetDniUserLOG(BD_RS.idUserLog);
                   BD_RS.idlocal = BD_RS.GetIdLocal(cboSucursal.getSelectedItem().toString());
                   BD_RS.idCargoLog = rs.getInt(3);
                }                                  
            if (usuario.getNid_perfil()==1) {
                getStatus("success");
                Timer t= new Timer();
                TimerTask task =new TimerTask() {
                    @Override
                    public void run() {
                        
                        
                        
                        setVisible(false);
                        frmPrincipal frmP = new frmPrincipal();
                        frmP.Validar(usuario.getNid_perfil());
                        frmP.setVisible(true);
                       
                    }
                };
                t.schedule(task, 2000);                                    
            }else if (usuario.getNid_perfil()==2) {
                setVisible(false);
                frmPrincipal frmP = new frmPrincipal();
                frmP.Validar(2);
                frmP.setVisible(true);            
            }else if (usuario.getNid_perfil()==3) {
                        if(BD_RS.idCargoLog == 5){
                            int estado = BD_RS.EstadoCaja();
                            if(estado == 0){
                                AC.setVisible(true);
                                setVisible(false);
                                frmPrincipal frmP = new frmPrincipal();
                                frmP.Validar(usuario.getNid_perfil());
                                frmP.setVisible(true);
                            }else if(estado == -1){
                                JOptionPane.showMessageDialog(null, "Ocurrio un error al obtener el estado de la Caja");
                            }else{
                                setVisible(false);
                                frmPrincipal frmP = new frmPrincipal();
                                frmP.Validar(usuario.getNid_perfil());
                                frmP.setVisible(true);
                            }
                        }else{
                                setVisible(false);
                                frmPrincipal frmP = new frmPrincipal();
                                frmP.Validar(usuario.getNid_perfil());
                                frmP.setVisible(true);
                        }
            }else{
                count++;
                txtPassword.setText("");
                txtUsuario.setText("");
                getStatus("warning");
                init();
            }
            if (count==3) {
                getStatus("error");
                Timer t= new Timer();
                TimerTask task =new TimerTask() {
                    @Override
                    public void run() {
                        txtPassword.setEnabled(false);
                        txtUsuario.setEnabled(false);
                        btnAceptar.setEnabled(false);
                        System.exit(0);
                    }
                };
                t.schedule(task, 2000);                        
            }else{
                Timer t= new Timer();
                TimerTask task =new TimerTask() {
                    @Override
                    public void run() {
                        lblEstado.setText("");
                        getStatus("");
                    }
                };
                t.schedule(task, 2000);        
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            jd.setVisible(false);
            usuario.setNo_usuario(txtUsuario.getText());
            usuario.setNo_clave(txtPassword.getText());
            usuario.setSurcursal(cboSucursal.getSelectedItem().toString());
            validUser(usuario);            
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed
        int i = JOptionPane.showOptionDialog(null, "¿Desea salir del Sistema?", "Sistema Restaurante", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
        if(i== 0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnAceptar1ActionPerformed

    private void txtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseClicked
        j = txtUsuario;
        jd.setVisible(true);
    }//GEN-LAST:event_txtUsuarioMouseClicked

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        j = txtPassword;
        jd.setVisible(true);
    }//GEN-LAST:event_txtPasswordMouseClicked
    // <editor-fold defaultstate="collapsed" desc="MethodosInputText-AnibalMA">                          
    public void Llenar(String text) {
        String nt = j.getText().concat(text);
        j.setText(nt);
    }

    public void ClearCaracter() {
        String nt = j.getText();
        int s = j.getText().length();
        if(s != 0){
            nt = nt.substring(0,nt.length()-1);
            j.setText(nt);
        
        }
        
    }

    public void Space() {
        Llenar(" ");
    }

    public void CloseTeclado() {
        jd.dispose();
    }
    //</editor-fold>
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JComboBox<String> cboSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
