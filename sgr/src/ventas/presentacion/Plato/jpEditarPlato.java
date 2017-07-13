
package ventas.presentacion.Plato;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ventas.modelo.Categoria;
import ventas.modelo.Login_User;
import ventas.modelo.Plato;
import ventas.persistencia.util.BDData;
import ventas.presentacion.Piso.jpEditarPiso;
import ventas.presentacion.frmPrincipal;

public class jpEditarPlato extends javax.swing.JPanel {
    
    Categoria categoria =new Categoria();
    Plato plato=new Plato();
    public jpEditarPlato() {
        initComponents();
        addItems();     
        txtCodigo.setEnabled(false);
    }
    private void addItems(){
        cboCategoria1.setModel(BDData.getCategoria1());        
    }
    public static void cargarPlato(Plato p){
        txtCodigo.setText(p.getNid_plato()+"");
        txtPlato.setText(p.getNo_plato());
        cboCategoria1.setSelectedItem(p.getNo_categoria1_plato());        
        cboCategoria2.setSelectedItem(p.getNo_categoria2_plato());        
        cboCategoria3.setSelectedItem(p.getNo_categoria3_plato());                
    }             
    private void cleanControls(){
        txtCodigo.setText("");
        txtPlato.setText("");
        cboCategoria1.setSelectedIndex(-1);
        cboCategoria2.setSelectedIndex(-1);
        cboCategoria3.setSelectedIndex(-1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPlato = new javax.swing.JTextField();
        cboCategoria1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboCategoria2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboCategoria3 = new javax.swing.JComboBox<>();
        txtCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        opGuardar = new javax.swing.JLabel();
        opHome = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setPreferredSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Categoria 3:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 357, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre del Plato:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 152, -1, -1));

        txtPlato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPlato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlatoKeyTyped(evt);
            }
        });
        add(txtPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 136, 260, 50));

        cboCategoria1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboCategoria1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCategoria1ItemStateChanged(evt);
            }
        });
        add(cboCategoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 204, 260, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Categoria 1:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 221, -1, -1));

        cboCategoria2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboCategoria2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCategoria2ItemStateChanged(evt);
            }
        });
        cboCategoria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoria2ActionPerformed(evt);
            }
        });
        add(cboCategoria2, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 272, 260, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Categoria 2:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 289, -1, -1));

        cboCategoria3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboCategoria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 340, 260, 50));

        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 68, 260, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Id Plato");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 84, -1, -1));

        btnCargar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCargar.setText("Cargar...");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 408, 260, 48));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Elegir imagen:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 424, -1, -1));

        opGuardar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        opGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        opGuardar.setText("Guardar");
        opGuardar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 10, new java.awt.Color(24, 168, 255)));
        opGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        opGuardar.setMaximumSize(new java.awt.Dimension(80, 331));
        opGuardar.setMinimumSize(new java.awt.Dimension(80, 331));
        opGuardar.setPreferredSize(new java.awt.Dimension(80, 331));
        opGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        opGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opGuardarMouseClicked(evt);
            }
        });
        add(opGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, -1));

        opHome.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        opHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/home.png"))); // NOI18N
        opHome.setText("Home");
        opHome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 10, new java.awt.Color(24, 168, 255)));
        opHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        opHome.setMaximumSize(new java.awt.Dimension(80, 331));
        opHome.setMinimumSize(new java.awt.Dimension(80, 331));
        opHome.setName(""); // NOI18N
        opHome.setPreferredSize(new java.awt.Dimension(80, 331));
        opHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        opHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opHomeMouseClicked(evt);
            }
        });
        add(opHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlatoKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");        
        }
    }//GEN-LAST:event_txtPlatoKeyTyped

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        if (!txtPlato.getText().equals("")) {
            Archivo archivo=new Archivo();
            archivo.setVisible(true);
            archivo.name=txtPlato.getText();
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void opGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opGuardarMouseClicked
        //        buttonsColor();
        opGuardar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(255,51,51))));
        Timer t= new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {
                Login_User login_User=new Login_User();

                if (!txtPlato.getText().equals("") && cboCategoria1.getSelectedIndex()!=-1 || cboCategoria2.getSelectedIndex()!=-1 || cboCategoria3.getSelectedIndex()!=-1) {
                    if (cboCategoria1.getSelectedIndex()==-1)
                    plato.setNo_categoria1_plato("N/B");
                    else
                    plato.setNo_categoria1_plato(cboCategoria1.getSelectedItem().toString());

                    if (cboCategoria2.getSelectedIndex()==-1)
                    plato.setNo_categoria2_plato("N/B");
                    else
                    plato.setNo_categoria2_plato(cboCategoria2.getSelectedItem().toString());

                    if (cboCategoria3.getSelectedIndex()==-1)
                    plato.setNo_categoria3_plato("N/B");
                    else
                    plato.setNo_categoria3_plato(cboCategoria3.getSelectedItem().toString());

                    plato.setNid_plato(Integer.parseInt(txtCodigo.getText()));
                    plato.setNo_plato(txtPlato.getText());
                    plato.setNid_usuario_modi(login_User.getNdi_usuario());
                    if (BDData.editarPlato(plato)) {
                        JOptionPane.showMessageDialog(null, "Registro Actualizado");
                        cleanControls();
                        jpListarPlato listarPlato=new jpListarPlato();
                        frmPrincipal.Comp(listarPlato);
                    }
                }else
                    JOptionPane.showMessageDialog(null, "Completar los campos");
            }
        };
        t.schedule(task, 1000);
    }//GEN-LAST:event_opGuardarMouseClicked

    private void opHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opHomeMouseClicked
        opHome.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(255,51,51))));
        opGuardar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, (new java.awt.Color(24,168,255))));
        Timer t= new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {
                jpListarPlato listarPlato=new jpListarPlato();
                frmPrincipal.Comp(listarPlato);
            }
        };
        t.schedule(task, 1000);
    }//GEN-LAST:event_opHomeMouseClicked

    private void cboCategoria2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCategoria2ItemStateChanged
        if (cboCategoria2.getSelectedIndex()!=-1) {
            cboCategoria3.setModel(BDData.getCategoria3(cboCategoria2.getSelectedItem().toString()));
        }
    }//GEN-LAST:event_cboCategoria2ItemStateChanged

    private void cboCategoria1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCategoria1ItemStateChanged
        if (cboCategoria1.getSelectedIndex()!=-1) {
            cboCategoria2.setModel(BDData.getCategoria2(cboCategoria1.getSelectedItem().toString()));
        }
    }//GEN-LAST:event_cboCategoria1ItemStateChanged

    private void cboCategoria2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoria2ActionPerformed
        
    }//GEN-LAST:event_cboCategoria2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    public static javax.swing.JComboBox<String> cboCategoria1;
    public static javax.swing.JComboBox<String> cboCategoria2;
    public static javax.swing.JComboBox<String> cboCategoria3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JLabel opGuardar;
    public javax.swing.JLabel opHome;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtPlato;
    // End of variables declaration//GEN-END:variables
}
