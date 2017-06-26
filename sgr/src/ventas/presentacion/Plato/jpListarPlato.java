
package ventas.presentacion.Plato;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Login_User;
import ventas.modelo.Plato;
import ventas.persistencia.util.BDData;
import static ventas.persistencia.util.BDData.editarLocal;
import ventas.presentacion.frmPrincipal;

public class jpListarPlato extends javax.swing.JPanel {
    
    Plato plato=new Plato();
    Login_User login_User=new Login_User();
    DefaultTableModel dtm;
    public jpListarPlato() {
        initComponents();
        listarPlato();
    }
    private DefaultTableModel formatearTabla(){
        String[] theader={"Id Plato","Plato","Categoria 1","Categoria 2","Categoria 3","Estado"};
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(theader);        
        return  dtm;
    }
    private void listarPlato(){
        tblPlato.setModel(BDData.listarPlato(formatearTabla()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlato = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\icons\\Files-2-icon.png")); // NOI18N
        jLabel1.setText("Gestión de Plato");

        tblPlato.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPlato);

        btnNew.setIcon(new javax.swing.ImageIcon("D:\\icons\\Add-icon.png")); // NOI18N
        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon("D:\\icons\\Pen-icon.png")); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon("D:\\icons\\Recyclebin-icon.png")); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setPreferredSize(new java.awt.Dimension(130, 57));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 65, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(170, 170, 170)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 65, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 85, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(22, 22, 22)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 11, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        jpNuevoPlato nuevoPlato=new jpNuevoPlato();
        frmPrincipal.Comp(nuevoPlato);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int idx=tblPlato.getSelectedRow();
        
        jpEditarPlato editarPlato=new jpEditarPlato();
        plato.setNid_plato(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        plato.setNo_plato((String)dtm.getValueAt(idx, 1));
        plato.setNo_categoria1_plato((String)dtm.getValueAt(idx, 2));
        plato.setNo_categoria2_plato((String)dtm.getValueAt(idx, 3));
        plato.setNo_categoria3_plato((String)dtm.getValueAt(idx, 4));
        plato.setNo_estado((String)dtm.getValueAt(idx, 5));
        plato.setNid_usuario_modi(login_User.getNdi_usuario());
        if(idx >= 0){
            frmPrincipal.Comp(editarPlato);
            editarPlato.cargarPlato(plato);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int idx=tblPlato.getSelectedRow();
        plato.setNid_plato(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        plato.setNid_usuario_modi(login_User.getNdi_usuario());
        if (BDData.eliminarPlato(plato)) {
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            listarPlato();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPlato;
    // End of variables declaration//GEN-END:variables
}
