/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.presentacion.Trabajador;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import ventas.persistencia.util.BD_RS;
import ventas.persistencia.util.Trabajador;
import static ventas.presentacion.Usuario.Usuarios_new.cboTipo;
import ventas.presentacion.frmPrincipal;

/**
 *
 * @author AnibalMA
 */
public class Trabajador_new extends javax.swing.JPanel {

    /**
     * Creates new form Trabajador_new
     */
    public Trabajador_new() {
        initComponents();
        cboCargo.setModel(BD_RS.ListarCBOCargo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cboCargo = new javax.swing.JComboBox<>();
        txtApeMat = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtApePat = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnLimpiar = new javax.swing.JButton();

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setText("Nuevo Trabajador");

        btnSave.setBackground(new java.awt.Color(153, 153, 255));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        btnSave.setText("GUARDAR");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReturn.setBackground(new java.awt.Color(153, 153, 255));
        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo.png"))); // NOI18N
        btnReturn.setText("RETORNAR");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtApeMat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtApeMat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApeMat.setBorder(null);
        txtApeMat.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        txtApeMat.setSelectionColor(new java.awt.Color(204, 204, 0));

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel20.setText("Nombres:");

        txtNombres.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtNombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombres.setBorder(null);
        txtNombres.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        txtNombres.setSelectionColor(new java.awt.Color(204, 204, 0));

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel17.setText("Apellido Materno:");

        jLabel19.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel19.setText("Cargo:");

        txtApePat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtApePat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApePat.setBorder(null);
        txtApePat.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        txtApePat.setSelectionColor(new java.awt.Color(204, 204, 0));

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel15.setText("Apellido Paterno:");

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel18.setText("DNI:");

        txtDNI.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDNI.setBorder(null);
        txtDNI.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        txtDNI.setSelectionColor(new java.awt.Color(204, 204, 0));

        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel21.setText("Ingreso Laboral:");

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(426, 426, 426)
                .addComponent(jLabel17)
                .addContainerGap(720, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(35, 35, 35)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel15)
                        .addComponent(jLabel18))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                    .addComponent(jLabel19)
                    .addGap(35, 35, 35)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                    .addComponent(jLabel20)
                    .addGap(28, 28, 28)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
                .addGap(53, 53, 53))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(60, 60, 60)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(47, Short.MAX_VALUE)))
        );

        btnLimpiar.setBackground(new java.awt.Color(153, 153, 255));
        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/clear_new.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(546, 546, 546))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(277, 277, 277))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(419, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String cod;
        if(jDateChooser1.getDate() != null && cboCargo.getSelectedIndex() != -1 && txtApeMat.getText().trim().length()> 0 && txtApePat.getText().trim().length() > 0 && txtNombres.getText().trim().length() > 0 && txtDNI.getText().trim().length() > 0){
            if(txtDNI.getText().trim().length() != 8 || !Digits(txtDNI.getText())){
                JOptionPane.showMessageDialog(this, "Ingrese un número de DNI correcto (8 dígitos)","Mensaje",JOptionPane.WARNING_MESSAGE);
                txtDNI.setText("");
                txtDNI.requestFocus();
                return;
            }
           SimpleDateFormat FormatoFecha = new SimpleDateFormat("yyyy-MM-dd");
          cod =  String.format("T%04d%n", BD_RS.CodTrab());
        Trabajador trabajador = new Trabajador();
        trabajador.setCodigo(cod);
        trabajador.setNombre(txtNombres.getText());
        trabajador.setApePaterno(txtApePat.getText());
        trabajador.setApeMaterno(txtApeMat.getText());
        trabajador.setDni(txtDNI.getText());
        trabajador.setCargo(cboCargo.getSelectedIndex()+1);
        trabajador.setEstado(1);
        trabajador.setFec_ingreso(Date.valueOf(FormatoFecha.format(jDateChooser1.getDate())));
        trabajador.setFec_creacion(Date.valueOf(LocalDate.now()));
        if(BD_RS.CTrabajador(trabajador, 1)) {
            JOptionPane.showMessageDialog(this, "Registro Guardado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            Mant_Trabajador n = new Mant_Trabajador();
            frmPrincipal.Comp(n);
        }
        else JOptionPane.showMessageDialog(this, "Se ha producido un error al guardar el registro","Mensaje",JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Complete todos los campos para continuar","Mensaje",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed
    private boolean Digits(String cad){
        for(int i = 0; i < cad.length(); i++){
            if(!Character.isDigit(cad.charAt(i))){
                return false;
            }
        }
        return true;
    }
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       txtApeMat.setText("");
       txtApePat.setText("");
       cboCargo.setSelectedIndex(-1);
       txtDNI.setText("");
       txtNombres.setText("");
       txtApePat.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        Mant_Trabajador n = new Mant_Trabajador();
        frmPrincipal.Comp(n);
    }//GEN-LAST:event_btnReturnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave;
    private static javax.swing.JComboBox<String> cboCargo;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApeMat;
    private javax.swing.JTextField txtApePat;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
