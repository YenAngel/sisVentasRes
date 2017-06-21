
package ventas.presentacion.Mesa;

import ventas.presentacion.Mesa.jpEditarMesa;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Login_User;
import ventas.modelo.Mesa;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;
import static ventas.presentacion.frmPrincipal.heightvar;
import static ventas.presentacion.frmPrincipal.nPanel;
import static ventas.presentacion.frmPrincipal.widthvar;

public class jpListarMesa extends javax.swing.JPanel{
    
    Login_User login_User=new Login_User();
    Mesa mesa =new Mesa();
    public DefaultTableModel dtm;
    public jpListarMesa() {
        initComponents();
        listarMesa();
    }
    private DefaultTableModel formatoTabla(){
        dtm= new DefaultTableModel();
        String[] theader={"Id Mesa","Mesa","Nro Sillas","Tipo Mesa","Piso","Local","Estado"};
        dtm.setColumnIdentifiers(theader);          
        return dtm;
    }
    private void listarMesa(){
        tblMesa.setModel(BDData.listarMesa(formatoTabla()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMesa = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\icons\\Files-2-icon.png")); // NOI18N
        jLabel1.setText("Gestión de Mesa");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        tblMesa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMesa);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 460, 127));

        btnNew.setIcon(new javax.swing.ImageIcon("D:\\icons\\Add-icon.png")); // NOI18N
        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 140, 60));

        btnEdit.setIcon(new javax.swing.ImageIcon("D:\\icons\\Pen-icon.png")); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 140, 60));

        btnDelete.setIcon(new javax.swing.ImageIcon("D:\\icons\\Recyclebin-icon.png")); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setPreferredSize(new java.awt.Dimension(130, 57));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 140, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int idx=tblMesa.getSelectedRow();    
        jpEditarMesa editarMesa=new jpEditarMesa();
        mesa.setNid_mesa(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        mesa.setNu_mesa(Integer.parseInt(dtm.getValueAt(idx, 1).toString()));
        mesa.setQt_silla(Integer.parseInt(dtm.getValueAt(idx, 2).toString()));
        mesa.setCo_tipo_mesa((String)dtm.getValueAt(idx, 3));        
        mesa.setNu_piso(Integer.parseInt((String)dtm.getValueAt(idx, 4).toString()));
        mesa.setNo_local((String)dtm.getValueAt(idx, 5));
        mesa.setNo_estado((String)dtm.getValueAt(idx, 6));
        mesa.setNid_usuario_modi(login_User.getNdi_usuario());
        if (idx>=0) {            
            frmPrincipal.Comp(editarMesa);                 
            editarMesa.cargarMesa(mesa);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int idx=tblMesa.getSelectedRow();    
        mesa.setNid_usuario_modi(login_User.getNdi_usuario());
        mesa.setNid_mesa(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        if (idx>=0) {
            if (BDData.eliminarMesa(mesa)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                listarMesa();
            }else
                JOptionPane.showMessageDialog(null, "Registro no Eliminado");
        }else{
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Algún Registro");
        }       
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        jpNuevaMesa nuevaMesa=new jpNuevaMesa();
        frmPrincipal.Comp(nuevaMesa);
    }//GEN-LAST:event_btnNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMesa;
    // End of variables declaration//GEN-END:variables

}
