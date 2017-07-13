/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.presentacion.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import ventas.persistencia.util.BD_RS;
import ventas.persistencia.util.Usuario;
import ventas.presentacion.frmPrincipal;

/**
 *
 * @author AnibalMA
 */
public class Mant_Usuarios extends javax.swing.JPanel {
        public String placeH = "Ingrese Nombre de Usuario";
    /**
     * Creates new form Mant_Alumno
     */
    public Mant_Usuarios() {
        initComponents();
        LoadTBL();
        txtFilter.setText(placeH);
    }
    private void LoadTBL(){
        tblUsuarios.setModel(BD_RS.ListarUsuarios());
        ConfigTBL();
    }
    private void ConfigTBL(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0; i < 6; i++){
            tblUsuarios.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            
        }
        for(int i = 0; i < tblUsuarios.getRowCount(); i++)
            tblUsuarios.setRowHeight(i, 45);
        tblUsuarios.setDefaultEditor(Object.class, null);
        tblUsuarios.getTableHeader().setReorderingAllowed(false);
        tblUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
        tblUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
        tblUsuarios.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblUsuarios.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnMod = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txtFilter = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1345, 841));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblUsuarios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUsuarios);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 327, 964, 323));

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel15.setText("Mantenimiento Usuario");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 0, -1, 38));

        btnNew.setBackground(new java.awt.Color(153, 153, 255));
        btnNew.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/new.png"))); // NOI18N
        btnNew.setText("   Nuevo     ");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(821, 45, 180, 80));

        btnMod.setBackground(new java.awt.Color(153, 153, 255));
        btnMod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit_user.png"))); // NOI18N
        btnMod.setText("  Modificar ");
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });
        add(btnMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(821, 136, 180, 80));

        btnEliminar.setBackground(new java.awt.Color(153, 153, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N
        btnEliminar.setText("  Eliminar  ");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(821, 227, 180, 80));

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search_2.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

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

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel17.setText("Usuario:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17))
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 114, -1, -1));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Búsqueda:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 75, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(204, 204, 204));

        jLabel19.setBackground(new java.awt.Color(153, 153, 153));
        jLabel19.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Registros:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 288, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        
        Usuarios_new nu = new Usuarios_new();
        frmPrincipal.Comp(nu);
        /*try {
        frmPrincipal s = new frmPrincipal();
        
        //nu.setBounds(255, 59, frmPrincipal.widthvar-255, frmPrincipal.heightvar-59);
        
       
       s.setVisible(true);
       s.validate();
        } catch (Exception e) {
            System.err.println(e);
        }*/
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
       int indx = tblUsuarios.getSelectedRow();
        if(indx >= 0){
            Usuario u = new Usuario();
            u.setId(Integer.parseInt(tblUsuarios.getValueAt(indx, 0).toString()));
            u.setUser(tblUsuarios.getValueAt(indx, 1).toString());
            u.setPssEnc(tblUsuarios.getValueAt(indx, 2).toString());
            u.setCodT(BD_RS.GetIdTrab(tblUsuarios.getValueAt(indx, 3).toString()));
            u.setRol(BD_RS.GetIdRol(tblUsuarios.getValueAt(indx, 4).toString()));
            u.setEstado(BD_RS.GetIdEstado(tblUsuarios.getValueAt(indx, 5).toString()));
            
            Usuarios_Editar ue = new Usuarios_Editar();
            frmPrincipal.Comp(ue);        
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnModActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       int indx = tblUsuarios.getSelectedRow();
        if(indx >= 0){
             if(tblUsuarios.getValueAt(indx, 5).toString().contains("Inactivo")){
                 JOptionPane.showMessageDialog(null, "El trabajador ya se encuentra deshabilitado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
             }else{
                 int r = JOptionPane.showOptionDialog(null,"¿Está seguro de deshabilitar al trabajador " + tblUsuarios.getValueAt(indx, 1).toString() + " ?","Mensaje",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
                 if(r == 0){
                    Usuario user = new Usuario();
                    user.setEstado(2);
                    user.setId(Integer.parseInt(tblUsuarios.getValueAt(indx, 0).toString()));
                    if(BD_RS.CUsuario(user, 3)) {
                       JOptionPane.showMessageDialog(this, "Registro Eliminado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                       LoadTBL();
                     }else JOptionPane.showMessageDialog(this, "Ha ocurrido un error al eliminar el registro","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                 }
             }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a eliminar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtFilterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFilterFocusGained
        if(txtFilter.getText().equals(placeH))
        txtFilter.setText("");
    }//GEN-LAST:event_txtFilterFocusGained

    private void txtFilterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFilterFocusLost
        if(txtFilter.getText().length() == 0)
            txtFilter.setText(placeH);
        
    }//GEN-LAST:event_txtFilterFocusLost

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(!txtFilter.getText().equals(placeH)){
            tblUsuarios.setModel(BD_RS.CUsuarioFiltro(txtFilter.getText()));
            ConfigTBL();
        }else{
            tblUsuarios.setModel(BD_RS.ListarUsuarios());
            ConfigTBL();
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnMod;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables
}
