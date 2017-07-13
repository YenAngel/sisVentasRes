/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.presentacion.Area;

import java.sql.Date;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import ventas.modelo.Area;
import ventas.persistencia.util.BD_RS;

/**
 *
 * @author AnibalMA
 */
public class AreaL extends javax.swing.JPanel {
        public boolean Ed = false;
        public int idTbl;
    /**
     * Creates new form CargoL
     */
    public AreaL() {
        initComponents();
       // cboEstado.setModel(BD_RS.ListarCBOEstado());
        
        //cboEstado.setSelectedIndex(0);
        //cboEstado.setVisible(false);
        //lblEstado.setVisible(false);
        
        jPanel1.setVisible(false);
        jPanel4.setVisible(false);
        jPanel2.setVisible(true);
        jPanel3.setVisible(true);
        LoadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSave = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtName_Area = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAreas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txtFilter = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSave.setBackground(new java.awt.Color(153, 153, 255));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/new.png"))); // NOI18N
        btnSave.setText("   Nuevo     ");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 180, 80));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setText("Mantenimiento Área");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, 38));

        btnEditar.setBackground(new java.awt.Color(153, 153, 255));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit_user.png"))); // NOI18N
        btnEditar.setText("  Modificar ");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, 180, 80));

        btnEliminar.setBackground(new java.awt.Color(153, 153, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N
        btnEliminar.setText("  Eliminar  ");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 240, 180, 80));

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtName_Area.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtName_Area.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName_Area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel17.setText("NOMBRE:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel17)
                .addGap(50, 50, 50)
                .addComponent(txtName_Area, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtName_Area, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 670, 160));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblAreas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblAreas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblAreas);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 970, 300));

        jPanel2.setBackground(new java.awt.Color(248, 248, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search_2.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFilter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFilter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFilter.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFilterFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFilterFocusLost(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel18.setText("NOMBRE:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 610, -1));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(204, 204, 204));

        jLabel19.setBackground(new java.awt.Color(153, 153, 153));
        jLabel19.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Búsqueda:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 81, -1, -1));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));

        jLabel22.setBackground(new java.awt.Color(153, 153, 153));
        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Datos del Área:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 81, -1, -1));

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel5.setForeground(new java.awt.Color(204, 204, 204));

        jLabel20.setBackground(new java.awt.Color(153, 153, 153));
        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Registros:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 301, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    private void LoadTable(){
        tblAreas.setModel(BD_RS.ListarAreas());
        ConfigTbl();
    
    }
    private void ConfigTbl(){
        tblAreas.setDefaultEditor(Object.class, null);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0; i < tblAreas.getColumnCount(); i++){
            tblAreas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            
        }
        for(int i = 0; i < tblAreas.getRowCount(); i++)
            tblAreas.setRowHeight(i, 45);
        tblAreas.setDefaultEditor(Object.class, null);
        tblAreas.getTableHeader().setReorderingAllowed(false);
        tblAreas.getColumnModel().getColumn(0).setMaxWidth(0);
        tblAreas.getColumnModel().getColumn(0).setMinWidth(0);
        tblAreas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblAreas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }
    private boolean EC(){
        if(BD_RS.ExistArea(txtName_Area.getText())){
               JOptionPane.showMessageDialog(this, "Ya existe el Área " + txtName_Area.getText() ,"Mensaje",JOptionPane.INFORMATION_MESSAGE);
               txtName_Area.setText("");
               txtName_Area.requestFocus();
               return true; 
            }
         return false;
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       if(btnSave.getText().trim().equals("Nuevo")){
           
           jPanel1.setVisible(true);
           jPanel4.setVisible(true);
           jPanel2.setVisible(false);
           jPanel3.setVisible(false);
           btnEditar.setVisible(false);
           btnEliminar.setText("Cancelar");
           btnEliminar.setIcon(new ImageIcon(getClass().getResource("/recursos/Undo.png")));
           btnSave.setText("Guardar");
           btnSave.setIcon(new ImageIcon(getClass().getResource("/recursos/save.png")));
       }else{
            int t = 1;
           String msg = "";
            if(txtName_Area.getText().trim().length() != 0){
                Area area = new Area();
                if(area.getNombre() == null || !Ed){
                     if (EC()) return;
               }else if(Ed){
                    if(!area.getNombre().equals(txtName_Area.getText())){
                     if (EC()) return;
                    }
               }

                if(!Ed){
                 t = 1;   
                 msg = "Área Guardada";
                area.setId(BD_RS.CodArea());
                area.setEstado(1);
                area.setFe_creacion(Date.valueOf(LocalDate.now()));
                area.setNombre(txtName_Area.getText());
                }else{
                    t = 2;
                    msg = "Área Actualizada";
                   area.setId(idTbl);
                   area.setEstado(1);
                   area.setFe_mod(Date.valueOf(LocalDate.now()));
                   area.setNombre(txtName_Area.getText());
                }

                if(BD_RS.CArea(area, t)) {
                        JOptionPane.showMessageDialog(this, msg,"Mensaje",JOptionPane.INFORMATION_MESSAGE);
                        tblAreas.setModel(BD_RS.ListarAreas());
                        LoadTable();
                        //lblEstado.setVisible(false);
                        //cboEstado.setVisible(false);
                        t = 1;
                        Ed = false;
                        txtName_Area.setText("");
                        txtName_Area.requestFocus();
                        btnEditar.setVisible(true);
                        btnEliminar.setText("  Eliminar  ");
                        btnEliminar.setIcon(new ImageIcon(getClass().getResource("/recursos/delete.png")));
                        btnSave.setText("   Nuevo     ");
                        btnSave.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
                        jPanel1.setVisible(false);
                        jPanel4.setVisible(false);
                        jPanel2.setVisible(true);
                        jPanel3.setVisible(true);
                    }
                    else JOptionPane.showMessageDialog(this, "Se ha producido un error al guardar el Área","Mensaje",JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Complete todos los campos para continuar","Mensaje",JOptionPane.WARNING_MESSAGE);
            }
       }
    }//GEN-LAST:event_btnSaveActionPerformed
    private void Mod(){
        int i = tblAreas.getSelectedRow();
        if(i >= 0){
            if(btnSave.getText().trim().equals("Nuevo")){
                jPanel1.setVisible(true);
                jPanel4.setVisible(true);
                jPanel2.setVisible(false);
                jPanel3.setVisible(false);
                btnEditar.setVisible(false);
                btnEliminar.setText("Cancelar");
                btnEliminar.setIcon(new ImageIcon(getClass().getResource("/recursos/Undo.png")));
                btnSave.setText("Guardar");
                btnSave.setIcon(new ImageIcon(getClass().getResource("/recursos/save.png")));  }
                Ed = true;
                Area area = new Area();
                area.setNombre(tblAreas.getValueAt(i, 1).toString());
                //cboEstado.setVisible(true);
                //lblEstado.setVisible(true);
                idTbl = Integer.parseInt(tblAreas.getValueAt(i, 0).toString());
                txtName_Area.setText(tblAreas.getValueAt(i, 1).toString());
                //cboEstado.setSelectedIndex(BD_RS.GetIdEstado(tblAreas.getValueAt(i, 3).toString())-1);
       }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void Del(){
        if(btnEliminar.getText().trim().equals("Eliminar")){
                int i = tblAreas.getSelectedRow();
               if(i >= 0){
                   if(tblAreas.getValueAt(i, 3).toString().contains("Inactivo")){
                        JOptionPane.showMessageDialog(null, "El Área ya se encuentra deshabilitado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        int r = JOptionPane.showOptionDialog(null,"¿Está seguro de deshabilitar el Área " + tblAreas.getValueAt(i, 1).toString() + " ?","Mensaje",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
                        if(r == 0){
                                       Ed = false;
                                       //cboEstado.setVisible(false);
                                       //lblEstado.setVisible(false);
                                       txtName_Area.setText("");

                                       Area area = new Area();
                                       area.setId(Integer.parseInt(tblAreas.getValueAt(i, 0).toString()));
                                       area.setEstado(2);
                              if(BD_RS.CArea(area, 3)) {
                                  JOptionPane.showMessageDialog(null, "Registro Deshabilitado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                                  LoadTable();
                              }else{
                                  JOptionPane.showMessageDialog(null, "Ocurrio un error al deshabilitar el Área","Mensaje",JOptionPane.WARNING_MESSAGE);
                              }
                        }
                   }

              }else{
                   JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
              }
        }else{
                        Ed = false;
                        txtName_Area.setText("");
                        txtName_Area.requestFocus();
                        btnEditar.setVisible(true);
                        btnEliminar.setText("  Eliminar  ");
                        btnEliminar.setIcon(new ImageIcon(getClass().getResource("/recursos/delete.png")));
                        btnSave.setText("   Nuevo     ");
                        btnSave.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
                        jPanel1.setVisible(false);
                        jPanel4.setVisible(false);
                        jPanel2.setVisible(true);
                        jPanel3.setVisible(true);
        } 
    }
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        Mod();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
            Del();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtFilterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFilterFocusGained

    }//GEN-LAST:event_txtFilterFocusGained

    private void txtFilterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFilterFocusLost

    }//GEN-LAST:event_txtFilterFocusLost

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(txtFilter.getText().length() != 0){
             tblAreas.setModel(BD_RS.CAreasFiltro(txtFilter.getText()));
             ConfigTbl();
        }else{
            LoadTable();
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAreas;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JTextField txtName_Area;
    // End of variables declaration//GEN-END:variables
}
