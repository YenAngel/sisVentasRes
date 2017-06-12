
package ventas.presentacion.Mesa;

import ventas.presentacion.Mesa.jpEditarMesa;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;
import static ventas.presentacion.frmPrincipal.heightvar;
import static ventas.presentacion.frmPrincipal.nPanel;
import static ventas.presentacion.frmPrincipal.widthvar;

public class jpListarMesa extends javax.swing.JPanel{
    
    public DefaultTableModel dtm;
    public jpListarMesa() {
        initComponents();
        listarMesa();
    }
    private DefaultTableModel formatoTabla(){
        dtm= new DefaultTableModel();
        String[] theader={"Codigo Mesa","Mesa","Nro Sillas","Tipo Mesa","Piso","Estado"};
        dtm.setColumnIdentifiers(theader);          
        return dtm;
    }
    private void listarMesa(){
        try {                          
            tblMesa.setModel(BDData.listarMesa(formatoTabla()));
        } catch (Exception e) {
            System.err.println(e);
        }        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMesa = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\icons\\Add-icon.png")); // NOI18N
        jButton1.setText("Nuevo");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 140, 60));

        jButton2.setIcon(new javax.swing.ImageIcon("D:\\icons\\Pen-icon.png")); // NOI18N
        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 140, 60));

        jButton3.setIcon(new javax.swing.ImageIcon("D:\\icons\\Recyclebin-icon.png")); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.setPreferredSize(new java.awt.Dimension(130, 57));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 140, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        frmPrincipal frm=new frmPrincipal();
        try {
             if(frm.nPanel != null){
                 frm.getContentPane().remove(nPanel);
                 frm.getContentPane().repaint();
             }
             frm.nPanel = new jpEditarMesa();
             frm.nPanel.setBounds(255, 59, widthvar-255, heightvar-59);

             frm.getContentPane().add(nPanel);
             this.validate();
        } catch (Exception e) {
            System.out.println(e);
        }
        int idx=tblMesa.getSelectedRow();        
        
        /*txtCodigo.setText((String)dtm.getValueAt(idx,1));
        mesa.cboNroMesa.setSelectedItem(dtm.getValueAt(idx,2));
        mesa.txtCantidad.setText((String)dtm.getValueAt(idx,3));
        mesa.cboTipoMesa.setSelectedItem(dtm.getValueAt(idx,4));
        mesa.cboNroPiso.setSelectedItem(dtm.getValueAt(idx,5));
        mesa.lblEstado.setText((String)dtm.getValueAt(idx,6));*/
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMesa;
    // End of variables declaration//GEN-END:variables

}
