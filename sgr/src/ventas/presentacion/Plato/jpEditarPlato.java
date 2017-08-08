
package ventas.presentacion.Plato;

import java.awt.Image;
import java.nio.file.Paths;
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
    public  void imgPlato(String plato){       
        //String path = "D:/sisVentasRes/sgr/src/recursos/"+status+".png";
        //URL url = this.getClass().getResource(path);
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/recursos/"+plato));
        Icon icon= new ImageIcon(imageIcon.getImage().getScaledInstance(lblPlatoImg.getWidth(), lblPlatoImg.getHeight(), Image.SCALE_DEFAULT));
        lblPlatoImg.setIcon(icon);                
        this.repaint();
        
    }
    public static void cargarPlato(Plato p){
        txtCodigo.setText(p.getNid_plato()+"");
        txtPlato.setText(p.getNo_plato());
        cboCategoria1.setSelectedItem(p.getNo_categoria1_plato());        
        cboCategoria2.setSelectedItem(p.getNo_categoria2_plato());        
        cboCategoria3.setSelectedItem(p.getNo_categoria3_plato());   
        cboEnvio.setSelectedIndex(GetIndexEnvio(p.getCo_tipo()));
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

        btnSave1 = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cboCategoria3 = new javax.swing.JComboBox<>();
        cboCategoria2 = new javax.swing.JComboBox<>();
        cboCategoria1 = new javax.swing.JComboBox<>();
        txtPlato = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblPlatoImg = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboEnvio = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setPreferredSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSave1.setBackground(new java.awt.Color(153, 153, 255));
        btnSave1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        btnSave1.setText("Guardar");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });
        add(btnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 570, 180, 70));

        btnReturn.setBackground(new java.awt.Color(153, 153, 255));
        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo.png"))); // NOI18N
        btnReturn.setText("Cancelar");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 570, 180, 70));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel16.setText("EDITAR PLATO");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, 38));

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        cboCategoria3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(cboCategoria3);
        cboCategoria3.setBounds(136, 295, 262, 39);

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
        jPanel1.add(cboCategoria2);
        cboCategoria2.setBounds(136, 225, 262, 43);

        cboCategoria1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboCategoria1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCategoria1ItemStateChanged(evt);
            }
        });
        cboCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoria1ActionPerformed(evt);
            }
        });
        jPanel1.add(cboCategoria1);
        cboCategoria1.setBounds(136, 167, 262, 42);

        txtPlato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPlato.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPlato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPlato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlatoKeyTyped(evt);
            }
        });
        jPanel1.add(txtPlato);
        txtPlato.setBounds(136, 92, 262, 43);

        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtCodigo);
        txtCodigo.setBounds(136, 24, 262, 42);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Id Plato:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(31, 36, 60, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("<html>Nombre del Plato:</html>");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(31, 85, 105, 60);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Categoria 1:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(31, 179, 105, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Categoria 2:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(33, 238, 85, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Categoria 3:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(33, 306, 85, 17);

        btnCargar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCargar.setText("Cargar...");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargar);
        btnCargar.setBounds(515, 87, 260, 48);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Elegir imagen:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(591, 64, 97, 17);

        lblPlatoImg.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblPlatoImg);
        lblPlatoImg.setBounds(515, 207, 260, 150);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("<html>Tipo   de Envío:</html>");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(33, 360, 85, 40);

        cboEnvio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboEnvio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bar", "Cocina" }));
        jPanel1.add(cboEnvio);
        cboEnvio.setBounds(136, 360, 262, 37);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 120, 801, 420));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel21.setBackground(new java.awt.Color(153, 153, 153));
        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Registro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 81, 150, 39));
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
            archivo.nroFrm=2;
        }
    }//GEN-LAST:event_btnCargarActionPerformed

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

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
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
                    plato.setCo_tipo(GetTipoEnvioS(cboEnvio.getSelectedItem().toString(), false));
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
    }//GEN-LAST:event_btnSave1ActionPerformed
     private String GetTipoEnvioS(String srt, boolean ConvertCadena){
        if(ConvertCadena && srt.length() == 1){
            if(srt.equals("C")){
               return "Cocina";
            }else{
               return "Bar";
            }
        }else{
            if(srt.equals("Cocina")){
                return "C";
            }else{
                return "B";
            }
        }
            
    }
     private static int GetIndexEnvio(String srt){
         if(srt.equals("B")){
             return 0;
         }else{
             return 1;
         }
     }
    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        jpListarPlato listarPlato=new jpListarPlato();
        frmPrincipal.Comp(listarPlato);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void cboCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoria1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCategoria1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave1;
    public static javax.swing.JComboBox<String> cboCategoria1;
    public static javax.swing.JComboBox<String> cboCategoria2;
    public static javax.swing.JComboBox<String> cboCategoria3;
    public static javax.swing.JComboBox<String> cboEnvio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblPlatoImg;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtPlato;
    // End of variables declaration//GEN-END:variables
}
