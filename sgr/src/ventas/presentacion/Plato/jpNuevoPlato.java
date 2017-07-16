
package ventas.presentacion.Plato;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import ventas.modelo.Categoria;
import ventas.modelo.Login_User;
import ventas.modelo.Plato;
import ventas.persistencia.util.BDData;
import ventas.persistencia.util.BDUtil;
import ventas.presentacion.frmPrincipal;

public class jpNuevoPlato extends javax.swing.JPanel {
    
    Plato plato=new Plato();
    DefaultComboBoxModel dcbm;
    public jpNuevoPlato() {
        initComponents();
        addItems();
        cboCategoria1.setSelectedIndex(-1);
        cboCategoria2.setSelectedIndex(-1);
        cboCategoria3.setSelectedIndex(-1);
        
    }
    private void addItems(){
        cboCategoria1.setModel(BDData.getCategoria1());
    }
    private void cleanControls(){
        txtPlato.setText("");
        cboCategoria1.setSelectedIndex(-1);
        cboCategoria2.setSelectedIndex(-1);
        cboCategoria3.setSelectedIndex(-1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel5 = new javax.swing.JLabel();
        txtPlato = new javax.swing.JTextField();
        cboCategoria1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboCategoria2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboCategoria3 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnSave1 = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        lblPlatoImg = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setPreferredSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre del Plato:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 101, -1, -1));

        txtPlato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPlato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPlatoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlatoKeyTyped(evt);
            }
        });
        add(txtPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 85, 260, 50));

        cboCategoria1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboCategoria1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCategoria1ItemStateChanged(evt);
            }
        });
        add(cboCategoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 153, 260, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Categoria 1:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 170, -1, -1));

        cboCategoria2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboCategoria2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCategoria2ItemStateChanged(evt);
            }
        });
        add(cboCategoria2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 221, 260, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Categoria 2:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 238, -1, -1));

        cboCategoria3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboCategoria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 289, 260, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Categoria 3:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 306, -1, -1));

        btnCargar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCargar.setText("Cargar...");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 357, 260, 48));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Elegir imagen:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 373, -1, -1));

        btnSave1.setBackground(new java.awt.Color(153, 153, 255));
        btnSave1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        btnSave1.setText("Guardar");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });
        add(btnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 150, -1));

        btnReturn.setBackground(new java.awt.Color(153, 153, 255));
        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo.png"))); // NOI18N
        btnReturn.setText("Cancelar");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 150, -1));

        lblPlatoImg.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        add(lblPlatoImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 260, 150));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setText("NUEVO PLATO");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, -1, 38));
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlatoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlatoKeyPressed
        
    }//GEN-LAST:event_txtPlatoKeyPressed

    private void txtPlatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlatoKeyTyped
        char c=evt.getKeyChar();         
        
        if(Character.isDigit(c)) {             
            getToolkit().beep();             
            evt.consume();                         
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");        
        }
    }//GEN-LAST:event_txtPlatoKeyTyped
    public  void imgPlato(String plato){       
        //String path = "D:/sisVentasRes/sgr/src/recursos/"+status+".png";
        //URL url = this.getClass().getResource(path);
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/recursos/"+plato));
        Icon icon= new ImageIcon(imageIcon.getImage());
        lblPlatoImg.setIcon(icon);        
        this.repaint();
    }
    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        if (!txtPlato.getText().equals("")) {
            Archivo archivo=new Archivo();
            archivo.setVisible(true);
            archivo.name=txtPlato.getText();
            archivo.nroFrm=1;
        }        
    }//GEN-LAST:event_btnCargarActionPerformed

    private void cboCategoria1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCategoria1ItemStateChanged
        if (cboCategoria1.getSelectedIndex()!=-1) {
            cboCategoria2.setModel(BDData.getCategoria2(cboCategoria1.getSelectedItem().toString()));
        }
    }//GEN-LAST:event_cboCategoria1ItemStateChanged

    private void cboCategoria2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCategoria2ItemStateChanged
        if (cboCategoria2.getSelectedIndex()!=-1) {
            cboCategoria3.setModel(BDData.getCategoria3(cboCategoria2.getSelectedItem().toString()));
        }
    }//GEN-LAST:event_cboCategoria2ItemStateChanged

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
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

                    plato.setNo_plato(txtPlato.getText());        
                    plato.setNid_usuario_crea(login_User.getNdi_usuario());
                    if (BDData.nuevoPlato(plato)) {
                        cleanControls();
                    }
                }else
                    JOptionPane.showMessageDialog(null, "Completar los campos");
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        jpListarPlato listarPlato=new jpListarPlato();        
        frmPrincipal.Comp(listarPlato);
    }//GEN-LAST:event_btnReturnActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave1;
    private javax.swing.JComboBox<String> cboCategoria1;
    private javax.swing.JComboBox<String> cboCategoria2;
    private javax.swing.JComboBox<String> cboCategoria3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblPlatoImg;
    public javax.swing.JTextField txtPlato;
    // End of variables declaration//GEN-END:variables
}
