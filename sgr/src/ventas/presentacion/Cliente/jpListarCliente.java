package ventas.presentacion.Cliente;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Cliente;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDData;
import static ventas.persistencia.util.BDData.editarLocal;
import ventas.persistencia.util.Usuario;
import ventas.presentacion.frmPrincipal;

public class jpListarCliente extends javax.swing.JPanel {
    
    DefaultTableModel dtm;
    Cliente cliente=new Cliente();
    Login_User usuario=new Login_User();
    public jpListarCliente() {
        initComponents();
        listarCliente();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCliente);

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\icons\\Files-2-icon.png")); // NOI18N
        jLabel1.setText("Gestión de Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel1)
                .addContainerGap(275, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 98, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 98, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addContainerGap(354, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 172, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 11, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private DefaultTableModel formatearTabla(){
        String[] theader={"Id Cliente","Nombre","Apellido Paterno","Apellido Materno","Tipo Documento","Numero de Documento","Estado"};
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(theader);        
        return  dtm;
    }
    
    private void listarCliente(){
        tblCliente.setModel(BDData.listarCliente(formatearTabla()));
    }

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        jpNuevoCliente nuevoCliente=new jpNuevoCliente();
        frmPrincipal.Comp(nuevoCliente);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int idx=tblCliente.getSelectedRow();
        jpEditarCliente editarCliente=new jpEditarCliente();
        cliente.setNid_cliente(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        cliente.setNo_cliente((String)dtm.getValueAt(idx, 1));
        cliente.setNo_ape_paterno((String)dtm.getValueAt(idx, 2));
        cliente.setNo_ape_materno((String)dtm.getValueAt(idx, 3));
        cliente.setCo_tipo_documento((String)dtm.getValueAt(idx, 4));
        cliente.setNu_documento((String)dtm.getValueAt(idx, 5));        
        cliente.setNo_estado((String)dtm.getValueAt(idx, 6));
        cliente.setNid_usuario_modi(usuario.getNdi_usuario());
        if(idx >= 0){
            frmPrincipal.Comp(editarCliente);
            editarCliente.cargarCliente(cliente);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int idx=tblCliente.getSelectedRow();
        cliente.setNid_cliente(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        if (BDData.eliminarCliente(cliente)) {
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            listarCliente();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCliente;
    // End of variables declaration//GEN-END:variables
}
