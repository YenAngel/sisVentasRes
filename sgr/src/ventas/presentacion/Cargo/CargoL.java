/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.presentacion.Cargo;

import java.sql.Date;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Area;
import ventas.modelo.Cargo;
import ventas.persistencia.util.BDData;
import ventas.persistencia.util.BD_RS;
import ventas.presentacion.frmPrincipal;

/**
 *
 * @author AnibalMA
 */
public class CargoL extends javax.swing.JPanel {
    public boolean Ed = false;
    public int idSel;
    /**
     * Creates new form CargoL
     */
    public CargoL() {
        initComponents();
        
        
        
        
        LoadTable();
        
       // hidePanelsN(true);
    }
   /* public void hidePanelsN(boolean v){
        jPanel1.setVisible(!v);
        jPanel4.setVisible(!v);
        jPanel2.setVisible(v);
        jPanel3.setVisible(v);
    }*/
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCargos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txtFilter = new javax.swing.JTextField();
        cboOption = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblTReg = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();

        setLayout(null);

        btnSave.setBackground(new java.awt.Color(153, 153, 255));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/new.png"))); // NOI18N
        btnSave.setText("   Nuevo     ");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave);
        btnSave.setBounds(773, 80, 170, 68);

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel16.setText("MANTENIMIENTO CARGO");
        add(jLabel16);
        jLabel16.setBounds(400, 0, 280, 38);

        btnEditar.setBackground(new java.awt.Color(153, 153, 255));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit_user.png"))); // NOI18N
        btnEditar.setText("  Modificar ");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar);
        btnEditar.setBounds(773, 160, 170, 68);

        btnEliminar.setBackground(new java.awt.Color(153, 153, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N
        btnEliminar.setText("  Eliminar  ");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar);
        btnEliminar.setBounds(773, 240, 170, 68);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblCargos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblCargos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCargos);

        add(jScrollPane1);
        jScrollPane1.setBounds(82, 320, 861, 300);

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

        cboOption.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre" }));
        cboOption.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboOptionItemStateChanged(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel17.setText("Opción:");

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel18.setText("Palabra Clave:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(cboOption, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtFilter)
                    .addComponent(cboOption, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        add(jPanel2);
        jPanel2.setBounds(82, 80, 590, 130);

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

        add(jPanel3);
        jPanel3.setBounds(82, 41, 132, 39);

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel5.setForeground(new java.awt.Color(204, 204, 204));

        jLabel21.setBackground(new java.awt.Color(153, 153, 153));
        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Listado");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel5);
        jPanel5.setBounds(82, 280, 114, 39);

        jPanel6.setBackground(new java.awt.Color(248, 248, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        lblTReg.setBackground(new java.awt.Color(153, 153, 153));
        lblTReg.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblTReg.setForeground(new java.awt.Color(51, 51, 51));
        lblTReg.setText("#Num");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblTReg)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTReg, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        add(jPanel6);
        jPanel6.setBounds(842, 620, 101, 30);

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));

        jLabel22.setBackground(new java.awt.Color(153, 153, 153));
        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Total de registros:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel4);
        jPanel4.setBounds(662, 620, 180, 30);
    }// </editor-fold>//GEN-END:initComponents
    private void LoadTable(){
        tblCargos.setModel(BD_RS.ListarCargos());
        ConfigTbl();
    }
    private void ConfigTbl(){
        lblTReg.setText(tblCargos.getRowCount()+"");
        tblCargos.setDefaultEditor(Object.class, null);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0; i < tblCargos.getColumnCount(); i++){
            tblCargos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            
        }
        for(int i = 0; i < tblCargos.getRowCount(); i++)
            tblCargos.setRowHeight(i, 45);
        tblCargos.setDefaultEditor(Object.class, null);
        tblCargos.getTableHeader().setReorderingAllowed(false);
        tblCargos.getColumnModel().getColumn(0).setMaxWidth(0);
        tblCargos.getColumnModel().getColumn(0).setMinWidth(0);
        tblCargos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblCargos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       
        /*int t = 1;
       String msg = "";
        if(txtName_Cargo.getText().trim().length() != 0 && cboArea.getSelectedIndex() != -1){
            Cargo cargo = new Cargo();
            if(cargo.getNombre() == null || !Ed){
                 if (EC()) return;
           }else if(Ed){
                if(!cargo.getNombre().equals(txtName_Cargo.getText())){
                 if (EC()) return;
                }
           }
            
            if(!Ed){
             t = 1;   
             msg = "Cargo Guardado";
            cargo.setArea(BD_RS.GetIdArea(cboArea.getSelectedItem().toString()));
            cargo.setNombre(txtName_Cargo.getText());
            cargo.setEstado(1);
            cargo.setFe_creacion(Date.valueOf(LocalDate.now()));
            }else{
                t = 2;
                msg = "Cargo Actualizado";
            cargo.setId(idSel);
            cargo.setArea(BD_RS.GetIdArea(cboArea.getSelectedItem().toString()));
            cargo.setNombre(txtName_Cargo.getText());
            cargo.setEstado(1);
            cargo.setFe_mod(Date.valueOf(LocalDate.now())); 
            }
            if(BD_RS.CCargo(cargo, t)) {
                    JOptionPane.showMessageDialog(this, msg,"Mensaje",JOptionPane.INFORMATION_MESSAGE);
                    tblCargos.setModel(BD_RS.ListarCargos());
                    LoadTable();
                    
                    
                    txtName_Cargo.setText("");
                    txtName_Cargo.requestFocus();
                    Ed = false;
                    t = 1;
                    //hidePanelsN(true);
                    btnEditar.setVisible(true);
                    btnEliminar.setText("  Eliminar  ");
                    btnEliminar.setIcon(new ImageIcon(getClass().getResource("/recursos/delete.png")));
                    btnSave.setText("   Nuevo     ");
                    btnSave.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
                }
                else JOptionPane.showMessageDialog(this, "Se ha producido un error al guardar el Cargo","Mensaje",JOptionPane.WARNING_MESSAGE);
        }else
            JOptionPane.showMessageDialog(null, "Complete todos los campos para continuar","Mensaje",JOptionPane.WARNING_MESSAGE);
        */
        Cargo_new cn = new Cargo_new();
        frmPrincipal.Comp(cn);
       
        
    }//GEN-LAST:event_btnSaveActionPerformed
    private void Mod(){
         int i = tblCargos.getSelectedRow();
        if(i >= 0){
           
            //Ed = true;
            Cargo cargo = new Cargo();
            
            cargo.setId(Integer.parseInt(tblCargos.getValueAt(i, 0).toString()));
            cargo.setNombre(tblCargos.getValueAt(i, 1).toString());
            cargo.setNarea(tblCargos.getValueAt(i, 2).toString());
            CargoEdit ce = new CargoEdit();
            frmPrincipal.Comp(ce);
            
       }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void Del(){
        //if(btnEliminar.getText().trim().equals("Eliminar")){
        int i = tblCargos.getSelectedRow();
        if(i >= 0){
            
                 int r = JOptionPane.showOptionDialog(null,"¿Está seguro de deshabilitar el Cargo " + tblCargos.getValueAt(i, 1).toString() + " ?","Mensaje",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
                 if(r == 0){
                                //Ed = false;
                        if(BD_RS.RegUnionCargo(Integer.parseInt(tblCargos.getValueAt(i, 0).toString()))){
                            JOptionPane.showMessageDialog(this, "Primero debe eliminar el/los trabajador(es) con el cargo " + tblCargos.getValueAt(i, 1).toString(),"Mensaje",JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                                Cargo cargo = new Cargo();
                                cargo.setId(Integer.parseInt(tblCargos.getValueAt(i, 0).toString()));
                                cargo.setEstado(2);
                                DefaultTableModel dtm = (DefaultTableModel)tblCargos.getModel();
                                dtm.removeRow(i);
                       if(BD_RS.CCargo(cargo, 3)) {
                           JOptionPane.showMessageDialog(null, "Registro Eliminado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                           LoadTable();
                       }else{
                           JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el Cargo","Mensaje",JOptionPane.WARNING_MESSAGE);
                       }
                 }
            
            
       }else
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
       
    }
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        Mod();
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Del();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(txtFilter.getText().length() != 0){
            tblCargos.setModel(BD_RS.CCargoFiltro(txtFilter.getText()));
            ConfigTbl();
        }else{
            LoadTable();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtFilterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFilterFocusGained

    }//GEN-LAST:event_txtFilterFocusGained

    private void txtFilterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFilterFocusLost

    }//GEN-LAST:event_txtFilterFocusLost

    private void cboOptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboOptionItemStateChanged

    }//GEN-LAST:event_cboOptionItemStateChanged
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboOption;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTReg;
    private javax.swing.JTable tblCargos;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables
}
