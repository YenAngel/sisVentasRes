
package ventas.presentacion.Plato_Local;

<<<<<<< HEAD
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
=======
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
>>>>>>> 328d9cc1427608874cf9d93deed503410298c10c
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
<<<<<<< HEAD
        ConfigTable(tblPlatoLocal);
    }
    private void ConfigTable(JTable jt){
        
        jt.setDefaultEditor(Object.class, null);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0; i < jt.getColumnCount(); i++){
            jt.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            
        }
        for(int i = 0; i < jt.getRowCount(); i++)
            jt.setRowHeight(i, 45);
        jt.setDefaultEditor(Object.class, null);
        jt.getTableHeader().setReorderingAllowed(false);
        jt.getColumnModel().getColumn(0).setMaxWidth(0);
        jt.getColumnModel().getColumn(0).setMinWidth(0);
        jt.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jt.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    
=======
        for(int i = 0; i < tblPlatoLocal.getRowCount(); i++)
            tblPlatoLocal.setRowHeight(i, 45);
        tblPlatoLocal.setDefaultEditor(Object.class, null);
        tblPlatoLocal.getTableHeader().setReorderingAllowed(false);        
>>>>>>> 328d9cc1427608874cf9d93deed503410298c10c
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
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();

<<<<<<< HEAD
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/new.png"))); // NOI18N
=======
        setMaximumSize(new java.awt.Dimension(1025, 661));
        setMinimumSize(new java.awt.Dimension(1025, 661));
        setPreferredSize(new java.awt.Dimension(1025, 661));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

>>>>>>> 328d9cc1427608874cf9d93deed503410298c10c
        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
<<<<<<< HEAD
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 48, 150, 100));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit_user.png"))); // NOI18N
=======
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, 150, 100));

>>>>>>> 328d9cc1427608874cf9d93deed503410298c10c
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
<<<<<<< HEAD
        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 166, 150, 100));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
=======
        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 300, 150, 100));
>>>>>>> 328d9cc1427608874cf9d93deed503410298c10c

        tblPlatoLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

<<<<<<< HEAD
        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 194, 812, 456));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search_2.png"))); // NOI18N
=======
        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 726, 447));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
>>>>>>> 328d9cc1427608874cf9d93deed503410298c10c
        btnSearch.setText("Buscar");
        btnSearch.setPreferredSize(new java.awt.Dimension(130, 57));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
<<<<<<< HEAD
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 284, 150, 100));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre de Plato:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 87, -1, -1));
=======
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 420, 150, 100));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre de Plato:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));
>>>>>>> 328d9cc1427608874cf9d93deed503410298c10c

        txtPlato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPlato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlatoKeyTyped(evt);
            }
        });
<<<<<<< HEAD
        add(txtPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 67, 260, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Local:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 87, -1, -1));

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 67, 260, 50));

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel5.setForeground(new java.awt.Color(204, 204, 204));

        jLabel21.setBackground(new java.awt.Color(153, 153, 153));
        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Registros:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 155, 130, -1));
=======
        add(txtPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 260, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Local:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cboLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 260, 50));
>>>>>>> 328d9cc1427608874cf9d93deed503410298c10c
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
            for(int i = 0; i < tblPlatoLocal.getRowCount(); i++)
            tblPlatoLocal.setRowHeight(i, 45);
            tblPlatoLocal.setDefaultEditor(Object.class, null);
            tblPlatoLocal.getTableHeader().setReorderingAllowed(false);        
        }else{
            platoLocal.setNo_plato(txtPlato.getText());
            platoLocal.setNo_local(cboLocal.getSelectedItem().toString());
            tblPlatoLocal.setModel(BDData.obtenerPlatoLocal(formatearTabla(), platoLocal));
            for(int i = 0; i < tblPlatoLocal.getRowCount(); i++)
            tblPlatoLocal.setRowHeight(i, 45);
            tblPlatoLocal.setDefaultEditor(Object.class, null);
            tblPlatoLocal.getTableHeader().setReorderingAllowed(false);        
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPlatoLocal;
    public static javax.swing.JTextField txtPlato;
    // End of variables declaration//GEN-END:variables
}
