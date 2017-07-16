
package ventas.presentacion.Mesa;

import ventas.presentacion.Mesa.jpEditarMesa;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
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
        cboNroPiso.setModel(BDData.obtenerPiso());
        cboNroPiso.setSelectedIndex(-1);
        cboLocal.setModel(BDData.getLocal());
        cboLocal.setSelectedIndex(-1);
        confTBL(tblMesa, dtm);
    }
    private DefaultTableModel formatoTabla(){
        dtm= new DefaultTableModel();
        String[] theader={"Id Mesa","Mesa","Nro Sillas","Tipo Mesa","Piso","Local"};
        dtm.setColumnIdentifiers(theader);          
        return dtm;
    }
    private void listarMesa(){
        tblMesa.setModel(BDData.listarMesa(formatoTabla()));        
    }
    public void confTBL(JTable jTable, DefaultTableModel model){
	DefaultTableCellRenderer centerRdr= new DefaultTableCellRenderer();
        centerRdr.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0;i<model.getColumnCount();i++){
            jTable.getColumnModel().getColumn(i).setCellRenderer(centerRdr);	
        }             
        for(int i=0;i<model.getRowCount();i++)
            jTable.setRowHeight(i,45);        
        jTable.setDefaultEditor(Object.class,null);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable.getColumnModel().getColumn(0).setMinWidth(0);        
        jTable.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTable.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        lblTotal1.setText(model.getRowCount()+"");         
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMesa = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNroMesa = new javax.swing.JTextField();
        cboNroPiso = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboLocal = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblTotal1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 768));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 800, 350));

        btnNew.setBackground(new java.awt.Color(153, 153, 255));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/new.png"))); // NOI18N
        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 180, 70));

        btnEdit.setBackground(new java.awt.Color(153, 153, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit_user.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 180, 70));

        btnDelete.setBackground(new java.awt.Color(153, 153, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setPreferredSize(new java.awt.Dimension(130, 57));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 180, 70));

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel5.setForeground(new java.awt.Color(204, 204, 204));

        jLabel21.setBackground(new java.awt.Color(153, 153, 153));
        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Listado");

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

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nro Mesa:");

        txtNroMesa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNroMesa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNroMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroMesaKeyTyped(evt);
            }
        });

        cboNroPiso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nro Piso:");

        cboLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocalActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Local:");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search_2.png"))); // NOI18N
        btnSearch.setPreferredSize(new java.awt.Dimension(130, 57));
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
                    .addComponent(jLabel5)
                    .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtNroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboNroPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboNroPiso, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtNroMesa))
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 600, 110));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));

        jLabel22.setBackground(new java.awt.Color(153, 153, 153));
        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Busqueda");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel6.setForeground(new java.awt.Color(204, 204, 204));

        jLabel23.setBackground(new java.awt.Color(153, 153, 153));
        jLabel23.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Total de registros:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 640, -1, -1));

        jPanel8.setBackground(new java.awt.Color(248, 248, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel8.setForeground(new java.awt.Color(204, 204, 204));

        lblTotal1.setBackground(new java.awt.Color(153, 153, 153));
        lblTotal1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblTotal1.setForeground(new java.awt.Color(51, 51, 51));
        lblTotal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotal1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 640, 120, -1));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setText("MANTENIMIENTO MESA");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, 38));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int idx=tblMesa.getSelectedRow();    
        if (idx!=-1) {            
            jpEditarMesa editarMesa=new jpEditarMesa();
            mesa.setNid_mesa(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
            mesa.setNu_mesa(Integer.parseInt(dtm.getValueAt(idx, 1).toString()));
            mesa.setQt_silla(Integer.parseInt(dtm.getValueAt(idx, 2).toString()));
            mesa.setCo_tipo_mesa((String)dtm.getValueAt(idx, 3));        
            mesa.setNu_piso(Integer.parseInt((String)dtm.getValueAt(idx, 4).toString()));
            mesa.setNo_local((String)dtm.getValueAt(idx, 5));
            mesa.setNid_usuario_modi(login_User.getNdi_usuario());

            frmPrincipal.Comp(editarMesa);                 
            editarMesa.cargarMesa(mesa);
        }else{
            JOptionPane.showMessageDialog(null, "Seleccionar el registro a eliminar");
        }        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int idx=tblMesa.getSelectedRow();    
        if (idx!=-1) {            
            int value = JOptionPane.showConfirmDialog(null, "Desea eliminar registro","Warning",JOptionPane.YES_NO_OPTION);            
            if(value == 0){
                mesa.setNid_usuario_modi(login_User.getNdi_usuario());
                mesa.setNid_mesa(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
                if (BDData.eliminarMesa(mesa)) {
                    JOptionPane.showMessageDialog(null, "Registro eliminado");
                   listarMesa();
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccionar el registro a eliminar");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        jpNuevaMesa mesa =new jpNuevaMesa();
        frmPrincipal.Comp(mesa);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtNroMesa.getText().equals("") || cboNroPiso.getSelectedIndex()==-1) {            
            tblMesa.setModel(BDData.listarMesa(formatoTabla()));
        }else{            
            mesa.setNu_mesa(Integer.parseInt(txtNroMesa.getText()));
            mesa.setNu_piso(Integer.parseInt(cboNroPiso.getSelectedItem().toString()));
            mesa.setNo_local(cboLocal.getSelectedItem().toString());
            tblMesa.setModel(BDData.obtenerMesa(formatoTabla(), mesa));
        }
        confTBL(tblMesa, dtm);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtNroMesaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroMesaKeyTyped
        char c=evt.getKeyChar();

        if(Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");
        }
    }//GEN-LAST:event_txtNroMesaKeyTyped

    private void cboLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocalActionPerformed
        if (cboLocal.getSelectedIndex()!=-1) {
            cboNroPiso.setModel(BDData.getPiso_Local(cboLocal.getSelectedItem().toString()));
            cboNroPiso.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_cboLocalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    public static javax.swing.JComboBox<String> cboLocal;
    public static javax.swing.JComboBox<String> cboNroPiso;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal1;
    private javax.swing.JTable tblMesa;
    public static javax.swing.JTextField txtNroMesa;
    // End of variables declaration//GEN-END:variables

}
