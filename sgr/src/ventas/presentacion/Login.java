
package ventas.presentacion;

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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import jdk.nashorn.internal.parser.TokenType;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.persistencia.util.BD_RS;

public class Login extends javax.swing.JFrame {
    
    Login_User usuario=new Login_User();
    private int count=0;
    public Login() {
        initComponents();        
        cboSucursal.setModel(BD_RS.ListarCBOLocal());
        ((JLabel)cboSucursal.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        init();
        setLocationRelativeTo(null);
        
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
        jPanel1 = new javax.swing.JPanel();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(java.awt.Color.white);
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(null);

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
        jPanel2.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 181, 110));

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

        jPanel1.add(jPanel2);
        jPanel2.setBounds(60, 60, 430, 546);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logo2.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(710, 100, 290, 130);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Ceviche.jpg"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(720, 220, 140, 90);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ceviche 3.jpg"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(860, 220, 130, 90);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sistema para Restaurante v1.0");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(1050, 10, 220, 20);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondopersonalizado720_filtro.jpg"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 0, 1280, 660);

        lblEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEstado.setText("Recuerde: Solo tiene 3 intentos para acceder al sistema.");
        jPanel1.add(lblEstado);
        lblEstado.setBounds(0, 660, 1280, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

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
    private void validUser(Login_User login_User){                
        try {
            ResultSet rs = BDData.user(login_User);                
                while(rs.next()) {
                    usuario.setNdi_usuario(rs.getInt(1));                
                    usuario.setNid_perfil(rs.getInt(2));
                    usuario.setSurcursal(cboSucursal.getSelectedItem().toString());
                   BD_RS.idlocal = BD_RS.GetIdLocal(cboSucursal.getSelectedItem().toString());
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
                setVisible(false);
                frmPrincipal frmP = new frmPrincipal();
                frmP.Validar(3);
                frmP.setVisible(true);            
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
            usuario.setNo_usuario(txtUsuario.getText());
            usuario.setNo_clave(txtPassword.getText());
            validUser(usuario);            
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

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
    private javax.swing.JComboBox<String> cboSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
