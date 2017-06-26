
package ventas.presentacion.Categoria;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Categoria;
import ventas.modelo.Cliente;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpListarCategoria extends javax.swing.JPanel {

    DefaultTableModel dtm;
    Categoria categoria=new Categoria();
    Login_User login_User=new Login_User();
    public jpListarCategoria() {
        initComponents();
        listarCategoria();
        
    }
    
    private DefaultTableModel formatearTabla(){
        String[] theader={"Id Categoria","Categoria Superior","Categoria","Nivel","Estado"};
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(theader);        
        return  dtm;
    }
    
    private void listarCategoria(){
        tbCategoria.setModel(BDData.listarCategoria(formatearTabla()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCategoria = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\icons\\Files-2-icon.png")); // NOI18N
        jLabel1.setText("Gestión de Categoria");

        tbCategoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbCategoria);

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addComponent(jLabel1))
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        jpNuevaCategoria nuevoCategoria=new jpNuevaCategoria();
        frmPrincipal.Comp(nuevoCategoria);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int idx=tbCategoria.getSelectedRow();        
        int valore=0;
        String tempNo_nivel=(String)dtm.getValueAt(idx, 3);
        if (tempNo_nivel.equals("Superior")) 
            valore=0;
        else if(tempNo_nivel.equals("Intermedio"))
            valore=1;
        else if(tempNo_nivel.equals("Inferior"))
            valore=2;
        jpEditarCategoria editarCategoria=new jpEditarCategoria();
        categoria.setNid_categoria_plato(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        categoria.setNo_padre_categoria((String)dtm.getValueAt(idx, 1));
        categoria.setNo_categoria_plato((String)dtm.getValueAt(idx, 2)); 
        categoria.setNu_nivel(valore);               
        categoria.setNo_estado((String)dtm.getValueAt(idx, 4));
        categoria.setNid_usuario_modi(login_User.getNdi_usuario());
        if(idx >= 0){
            frmPrincipal.Comp(editarCategoria);
            editarCategoria.cargarCategoria(categoria);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int idx=tbCategoria.getSelectedRow();
        categoria.setNid_categoria_plato(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        categoria.setNid_usuario_modi(login_User.getNdi_usuario());
        if (BDData.eliminarCategoria(categoria)) {
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            listarCategoria();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCategoria;
    // End of variables declaration//GEN-END:variables
}
