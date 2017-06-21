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

    /**
     * Creates new form Mant_Alumno
     */
    public Mant_Trabajador() {
        initComponents();
        LoadTBL();
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
        tblTrabajador = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1345, 841));

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

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel15.setText("Gestión de Trabajadores");

        btnNew.setBackground(new java.awt.Color(153, 153, 255));
        btnNew.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/new.png"))); // NOI18N
        btnNew.setText("NUEVO");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(153, 153, 255));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit_user.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(153, 153, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N
        btnDelete.setText("ELIMINAR");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(349, 349, 349)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(510, 510, 510)
                        .addComponent(jLabel15)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void LoadTBL(){
        tblTrabajador.setModel(BD_RS.ListarTrabajador());
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0; i < 8; i++){
            tblTrabajador.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            
        }
        for(int i = 0; i < tblTrabajador.getRowCount(); i++)
            tblTrabajador.setRowHeight(i, 45);
        tblTrabajador.setDefaultEditor(Object.class, null);
        tblTrabajador.getTableHeader().setReorderingAllowed(false); 
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
            t.setDni(tblTrabajador.getValueAt(indx, 1).toString());
            t.setNombre(tblTrabajador.getValueAt(indx, 2).toString());
            t.setApePaterno(tblTrabajador.getValueAt(indx, 3).toString());
            t.setApeMaterno(tblTrabajador.getValueAt(indx, 4).toString());
            t.setFec_ingreso(Date.valueOf(tblTrabajador.getValueAt(indx, 5).toString()));
            t.setCargo(BD_RS.GetIdCargo(tblTrabajador.getValueAt(indx, 6).toString()));
            t.setEstado(BD_RS.GetIdEstado(tblTrabajador.getValueAt(indx, 7).toString()));
            Trabajador_Editar te = new Trabajador_Editar();
            frmPrincipal.Comp(te);        
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       int indx = tblTrabajador.getSelectedRow();
        if(indx >= 0){
             if(tblTrabajador.getValueAt(indx, 7).toString().contains("Inactivo")){
                 JOptionPane.showMessageDialog(null, "El trabajador ya se encuentra deshabilitado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
             }else{
                 int r = JOptionPane.showOptionDialog(null,"¿Está seguro de deshabilitar al trabajador " + tblTrabajador.getValueAt(indx, 0).toString() + " ?","Mensaje",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
                 if(r == 0){
                    Trabajador trabajador = new Trabajador();
                    trabajador.setEstado(2);
                    trabajador.setCodigo(tblTrabajador.getValueAt(indx, 0).toString());
                    if(BD_RS.CTrabajador(trabajador, 3)) {
                       JOptionPane.showMessageDialog(this, "Registro Eliminado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                       LoadTBL();
                     }else JOptionPane.showMessageDialog(this, "RHa ocurrido un error al eliminar el registro","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                 }
             }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a eliminar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    public static javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTrabajador;
    // End of variables declaration//GEN-END:variables
}
