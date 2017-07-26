/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.presentacion.Trabajador;

import java.sql.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import ventas.persistencia.util.BD_RS;
import ventas.persistencia.util.Trabajador;
import ventas.presentacion.frmPrincipal;

/**
 *
 * @author AnibalMA
 */
public class Mant_Trabajador extends javax.swing.JPanel {
     private String cond = "t.no_natural";
    /**
     * Creates new form Mant_Alumno
     */
    public Mant_Trabajador() {
        //initComponents();
        removeAll();
        updateUI();
        repaint();
        
        initComponents();
        LoadTBL();
        cboOption.removeAllItems();
        cboOption.addItem("Nombre");
        cboOption.addItem("Cargo");
        cboOption.addItem("Código");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cboOption = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrabajador = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblTReg = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1345, 841));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel15.setText("MANTENIMIENTO TRABAJADOR");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 360, 38));

        btnNew.setBackground(new java.awt.Color(153, 153, 255));
        btnNew.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/new.png"))); // NOI18N
        btnNew.setText("   Nuevo     ");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(773, 80, 170, 68));

        btnModificar.setBackground(new java.awt.Color(153, 153, 255));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit_user.png"))); // NOI18N
        btnModificar.setText("  Modificar ");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(773, 160, 170, 68));

        btnDelete.setBackground(new java.awt.Color(153, 153, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N
        btnDelete.setText("  Eliminar  ");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(773, 240, 170, 68));

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel17.setText("Opción:");

        cboOption.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboOption.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboOptionItemStateChanged(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel18.setText("Palabra Clave:");

        txtFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFilter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFilter.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFilterFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFilterFocusLost(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search_2.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(cboOption, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(cboOption, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 80, 590, 130));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Búsqueda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 41, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(204, 204, 204));

        jLabel19.setBackground(new java.awt.Color(153, 153, 153));
        jLabel19.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Listado");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 281, 120, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblTrabajador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblTrabajador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTrabajador);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 320, 861, 300));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));

        jLabel20.setBackground(new java.awt.Color(153, 153, 153));
        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Total de registros:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 620, 180, 30));

        jPanel5.setBackground(new java.awt.Color(248, 248, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        lblTReg.setBackground(new java.awt.Color(153, 153, 153));
        lblTReg.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblTReg.setForeground(new java.awt.Color(51, 51, 51));
        lblTReg.setText("#Num");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblTReg)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTReg, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(842, 620, 101, 30));
    }// </editor-fold>//GEN-END:initComponents
    private void LoadTBL(){
        tblTrabajador.setModel(BD_RS.ListarTrabajador());
        ConfigTbl();
    }
    private void ConfigTbl(){
        lblTReg.setText(tblTrabajador.getRowCount()+"");
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0; i < tblTrabajador.getColumnCount(); i++){
            tblTrabajador.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            
        }
        for(int i = 0; i < tblTrabajador.getRowCount(); i++)
           tblTrabajador.setRowHeight(i, 45);
        tblTrabajador.setDefaultEditor(Object.class, null);
        tblTrabajador.getTableHeader().setReorderingAllowed(false);
        tblTrabajador.getColumnModel().getColumn(0).setMaxWidth(0);
        tblTrabajador.getColumnModel().getColumn(0).setMinWidth(0);
        tblTrabajador.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblTrabajador.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0); 
    }
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        Trabajador_new n = new Trabajador_new();
        frmPrincipal.Comp(n);
        
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int indx = tblTrabajador.getSelectedRow();
        if(indx >= 0){
            Trabajador t = new Trabajador();
            t.setCodigo(tblTrabajador.getValueAt(indx, 0).toString());
            t.setDni(tblTrabajador.getValueAt(indx, 4).toString());
            t.setNombre(tblTrabajador.getValueAt(indx, 1).toString());
            t.setApePaterno(tblTrabajador.getValueAt(indx, 2).toString());
            t.setApeMaterno(tblTrabajador.getValueAt(indx, 3).toString());
            t.setFec_ingreso(Date.valueOf(tblTrabajador.getValueAt(indx, 5).toString()));
            t.setSCargo(tblTrabajador.getValueAt(indx, 6).toString());
            t.setEstado(1);
            Trabajador_Editar te = new Trabajador_Editar();
            frmPrincipal.Comp(te);        
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       int indx = tblTrabajador.getSelectedRow();
        if(indx >= 0){
             /*if(tblTrabajador.getValueAt(indx, 7).toString().contains("Inactivo")){
                 JOptionPane.showMessageDialog(null, "El trabajador ya se encuentra deshabilitado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
             }else{*/
                 int r = JOptionPane.showOptionDialog(null,"¿Está seguro de eliminar al trabajador " + tblTrabajador.getValueAt(indx, 1).toString() + " ?","Mensaje",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
                 if(r == 0){
                     if(BD_RS.RegUnionTrabajador(BD_RS.GetIdTrab(tblTrabajador.getValueAt(indx, 0).toString()))){
                         JOptionPane.showMessageDialog(this, "Primero debe eliminar el usuario que se creó al trabajador " + tblTrabajador.getValueAt(indx, 1).toString(),"Mensaje",JOptionPane.INFORMATION_MESSAGE);
                         return;
                     }
                     
                    Trabajador trabajador = new Trabajador();
                    trabajador.setEstado(2);
                    trabajador.setCodigo(tblTrabajador.getValueAt(indx, 0).toString());
                    if(BD_RS.CTrabajador(trabajador, 3)) {
                       JOptionPane.showMessageDialog(this, "Registro Eliminado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                       LoadTBL();
                     }else JOptionPane.showMessageDialog(this, "Ha ocurrido un error al eliminar el registro","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                 //}
                }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a eliminar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtFilterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFilterFocusGained
        
    }//GEN-LAST:event_txtFilterFocusGained

    private void txtFilterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFilterFocusLost
        

    }//GEN-LAST:event_txtFilterFocusLost

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
            if(txtFilter.getText().length() != 0){
                tblTrabajador.setModel(BD_RS.CTrabajadorFiltro(txtFilter.getText(), cboOption.getSelectedIndex()+1));
                ConfigTbl();
            }else{
                LoadTBL();
            }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cboOptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboOptionItemStateChanged
        switch(cboOption.getSelectedIndex()){
            case 0: cond = "t.no_natural"; break;
            case 1: cond = "c.no_cargo"; break;
            case 2: cond = "t.co_trabajador"; break;
            default: cond = "t.no_natural"; break;
        }
            
    }//GEN-LAST:event_cboOptionItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    public static javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboOption;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTReg;
    private javax.swing.JTable tblTrabajador;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables
}
