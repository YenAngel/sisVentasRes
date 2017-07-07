
package ventas.presentacion.Plato_Local;

import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Login_User;
import ventas.modelo.PlatoLocal;
import ventas.persistencia.util.BDData;
import ventas.presentacion.frmPrincipal;

public class jpListarPlatoLocal extends javax.swing.JPanel {
    
    PlatoLocal platoLocal=new PlatoLocal();
    Login_User login_User=new Login_User();    
    DefaultTableModel dtm;
    public jpListarPlatoLocal() {
        initComponents();        
        listarPlatoLocal();
        cboLocal.setModel(BDData.getLocal());
        cboLocal.setSelectedIndex(-1);        
        btnEdit.setVisible(false);
        btnNew.setVisible(false);
        btnSearch.setVisible(false);
    }
    /*public void desingButton(JPanel lpl){        
        int pHeight =lpl.getHeight();
        int sizeOption = (int)pHeight/3;        
        
        btnEdit.setBounds(270, 59+sizeOption, 10, sizeOption);
        btnNew.setBounds(270, 59+sizeOption*2, 10, sizeOption);
        btnSearch.setBounds(270, 59+sizeOption*3, 10, sizeOption);
        /*opNuevo.setVisible(true);
        opNuevo.setLayout(null);
        opNuevo.setBounds(0, sizeOption,80,sizeOption); 

        opEditar.setVisible(true);
        
        opEditar.setLayout(null);
        opEditar.setBounds(0, sizeOption,80,sizeOption); 

        opEliminar.setVisible(true);
        opEliminar.setLayout(null);
        opEliminar.setBounds(0, sizeOption*3,80,sizeOption); 

        opBuscar.setVisible(true);
        opBuscar.setLayout(null);
        opBuscar.setBounds(0, sizeOption*4,80,sizeOption);
    }*/
    private DefaultTableModel formatearTabla(){
        String[] theader={"Local","Plato","Precio","VIP"};
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(theader);        
        return  dtm;
    }
    private void listarPlatoLocal(){
        tblPlatoLocal.setModel(BDData.listarLocalPlato(formatearTabla()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlatoLocal = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtPlato = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboLocal = new javax.swing.JComboBox<>();
        opNuevo = new javax.swing.JLabel();
        opEliminar = new javax.swing.JLabel();
        opBuscar = new javax.swing.JLabel();
        opEditar = new javax.swing.JLabel();

        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        tblPlatoLocal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPlatoLocal);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.setPreferredSize(new java.awt.Dimension(130, 57));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre de Plato:");

        txtPlato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPlato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlatoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Local:");

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        opNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Ceviche.jpg"))); // NOI18N
        opNuevo.setText("jLabel1");

        opEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Ceviche.jpg"))); // NOI18N
        opEliminar.setText("jLabel1");

        opBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Ceviche.jpg"))); // NOI18N
        opBuscar.setText("jLabel1");

        opEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Ceviche.jpg"))); // NOI18N
        opEditar.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(jLabel3)
                        .addGap(17, 17, 17)
                        .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opEliminar)
                    .addComponent(opBuscar)
                    .addComponent(opEditar)
                    .addComponent(opNuevo))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(opEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(opBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        jpNuevoPlatoLocal local=new jpNuevoPlatoLocal();
        frmPrincipal.Comp(local);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int idx=tblPlatoLocal.getSelectedRow();
        PlatoLocal platoLocal=new PlatoLocal();
        jpEditarPlatoLocal editarPlatoLocal=new jpEditarPlatoLocal();
        platoLocal.setNo_local(dtm.getValueAt(idx, 0).toString());
        platoLocal.setNo_plato((String)dtm.getValueAt(idx, 1));
        platoLocal.setMt_precio(Double.parseDouble(dtm.getValueAt(idx, 2).toString()));
        platoLocal.setFl_vip((String)dtm.getValueAt(idx, 3)); 
        platoLocal.setNid_usuario_modi(login_User.getNdi_usuario());
        if(idx >= 0){
            frmPrincipal.Comp(editarPlatoLocal);
            editarPlatoLocal.cargarPlatoLocal(platoLocal);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a modificar","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtPlato.getText().equals("") || cboLocal.getSelectedIndex()==-1) {
            tblPlatoLocal.setModel(BDData.listarLocalPlato(formatearTabla()));
        }else{
            platoLocal.setNo_plato(txtPlato.getText());
            platoLocal.setNo_local(cboLocal.getSelectedItem().toString());
            tblPlatoLocal.setModel(BDData.obtenerPlatoLocal(formatearTabla(), platoLocal));
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtPlatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlatoKeyTyped
        char c=evt.getKeyChar();

        if(Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo debe ingresar letras");
        }
    }//GEN-LAST:event_txtPlatoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEdit;
    public javax.swing.JButton btnNew;
    public javax.swing.JButton btnSearch;
    public static javax.swing.JComboBox<String> cboLocal;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel opBuscar;
    public javax.swing.JLabel opEditar;
    public javax.swing.JLabel opEliminar;
    public javax.swing.JLabel opNuevo;
    private javax.swing.JTable tblPlatoLocal;
    public static javax.swing.JTextField txtPlato;
    // End of variables declaration//GEN-END:variables
}
