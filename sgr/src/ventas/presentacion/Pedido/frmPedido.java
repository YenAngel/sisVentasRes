/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.presentacion.Pedido;

import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import ventas.persistencia.util.BDUtil;
import ventas.persistencia.util.BD_RS;
import ventas.presentacion.Mesas_Selection;

/**
 *
 * @author AnibalMA
 */
public class frmPedido extends javax.swing.JFrame {
    public int w;
    public DefaultListModel dlmFilter;
    public DefaultTableModel dtm;
    public DefaultListModel dlm;
    public DefaultListModel dlmsub;
    public DefaultListModel dlmultsub;
    public int r;
    public static int cat;
    public static int subcat;
    public DefaultTableModel FormatearTabla(){
        DefaultTableModel dtm = new DefaultTableModel();
        String [] cab = {"Descripción","Cantidad"};
        dtm.setColumnIdentifiers(cab);
        return dtm;
    }
    public frmPedido() {
        
        BDUtil.conectar();
        //jPanel2.setLayout(null);
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        w = jTabbedPane1.getSize().width;
        //LoadComp();
        dlmsub = new DefaultListModel();
        dlmultsub = new DefaultListModel();
        dlm = BD_RS.ListarCategoriasPed();
        dtm = FormatearTabla();
        tblPedidos.setModel(dtm);
        LoadTree();
    }
    private void LoadTree(){
        
        DefaultMutableTreeNode tnode  = new DefaultMutableTreeNode("Categorías");
        DefaultTreeModel dtreem = new DefaultTreeModel(tnode);
        jTree1.setModel(dtreem);
        DefaultMutableTreeNode Categorias;
        DefaultMutableTreeNode SubCategorias;
        DefaultMutableTreeNode UltSubCategorias;
        r = 5;
        int a = 1;
        for(int i =0; i<dlm.size(); i++){
         String cad = dlm.elementAt(i).toString();
         int pos = cad.indexOf('_')+1;
         int idDad = Integer.parseInt(cad.substring(0,pos-1));
        DefaultListModel sub = BD_RS.ListarSubCategoriasPed(idDad,2);
        Categorias = new DefaultMutableTreeNode(cad.substring(pos, cad.length()));
            
            while(a <= sub.size()){
                int ultcat = 1;
                dlmsub.addElement(sub.elementAt(a-1).toString());
                String cadsub = sub.elementAt(a-1).toString();
                int possub = cadsub.indexOf('_') + 1;
                SubCategorias = new DefaultMutableTreeNode(cadsub.substring(pos,cadsub.length()));
                Categorias.add(SubCategorias);
                int idDadsub = Integer.parseInt(cadsub.substring(0,possub-1));
                DefaultListModel ultsub = BD_RS.ListarSubCategoriasPed(idDadsub,3);
                System.out.println(ultsub.size());
                while(ultcat <= ultsub.size()){
                    dlmultsub.addElement(ultsub.elementAt(ultcat-1).toString());
                    String ultcadsub = ultsub.elementAt(ultcat-1).toString();
                    int ultpossub = ultcadsub.indexOf('_')+1;
                    UltSubCategorias = new DefaultMutableTreeNode(ultcadsub.substring(ultpossub,ultcadsub.length()));
                    SubCategorias.add(UltSubCategorias);
                    ultcat+=1;
                }
                a+=1;
            }
           tnode.add(Categorias);
           a = 1;
        
        }
        
        setTreeState(jTree1, new TreePath(jTree1.getModel().getRoot()), true);
    }
    public static void setTreeState(JTree tree, TreePath path, boolean expanded) {
    Object lastNode = path.getLastPathComponent();
    for (int i = 0; i < tree.getModel().getChildCount(lastNode); i++) {
      Object child = tree.getModel().getChild(lastNode,i);
      TreePath pathToChild = path.pathByAddingChild(child);
      setTreeState(tree,pathToChild,expanded);
    }
    if (expanded) 
      tree.expandPath(path);
    else
      tree.collapsePath(path);
      
    
  }        
    private void LoadComp(){
        int h = 80;
        int a = 30;
        System.out.println("SIZE: " + dlmFilter.size());
        for (int i = 0; i < dlmFilter.size(); i++){
            h = 80;
            int ls = i;
            while(h+150 <= w & ls < dlmFilter.size()){
                //try{
                JLabel jl = new JLabel();
                //JLabel jl2 = new JLabel();
                //jl2.setText("");
                jl.setText("");
                System.out.println("LOAD: " + dlmFilter.getElementAt(ls).toString());
                jl.setName(dlmFilter.getElementAt(ls).toString());
                String rec = dlmFilter.getElementAt(ls).toString().replaceFirst(" ", "_").replace(' ','_');
                System.out.println("REC: " + rec);
                jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/" + rec + ".jpg")));
                /*
                switch (i) {
                    case 1:
                        jl.setIcon(new ImageIcon(Object.class.getResource("/recursos/" + ".jpg")));
                        jl2.setIcon(new ImageIcon(Object.class.getResource("/recursos/Chicha_Morada.jpg")));
                        break;
                    case 2:
                        jl.setIcon(new ImageIcon(Object.class.getResource("/recursos/Arroz_con_Pollo.jpg")));
                        jl2.setIcon(new ImageIcon(Object.class.getResource("/recursos/Inca_Kola.jpg")));
                        break;
                    case 3:
                        jl.setIcon(new ImageIcon(Object.class.getResource("/recursos/Shambar.jpg")));
                        jl2.setIcon(new ImageIcon(Object.class.getResource("/recursos/Coca_Cola.jpg")));
                        break;
                    default:
                        jl.setIcon(new ImageIcon(Object.class.getResource("/recursos/Ceviche.jpg")));
                        jl2.setIcon(new ImageIcon(Object.class.getResource("/recursos/Chicha_Morada.jpg")));
                        break;
                }*/
                
                jl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               jl(evt);
            }
        });
                     /*jl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               jl(evt);
            }
        });*/
                jl.setBounds(h, a, 140, 82);
                //jPanel1.add(jl);
                //jl2.setBounds(h, a, 140, 82);
                jPanel2.add(jl);
                h+=200;
                ls+=1; //}
               // catch(Exception ex) {
                    
                
                //}
            }
            a+=108;
        }
    }
    public void jl(MouseEvent evt){
        int in, f, valcant;
        String platName;
        valcant = 1;
        
        in = evt.getSource().toString().indexOf("/recursos/") + 10;
        f = evt.getSource().toString().indexOf("disabledIcon=") - 5;
        Vector v = new Vector();
        
        platName = evt.getComponent().getName();
        if(tblPedidos.getModel().getRowCount() == 0){
                    v.add(platName);
                    v.add(valcant);
                    dtm.addRow(v);
        }else{
            for(int i=0; i < tblPedidos.getModel().getRowCount(); i++){
                if(tblPedidos.getValueAt(i, 0).equals(platName)){
                   valcant = Integer.parseInt(tblPedidos.getValueAt(i, 1).toString()) + 1;
                   tblPedidos.getModel().setValueAt(valcant, i, 1);
                   return;
                }
            }
                    v.add(platName);
                    v.add(valcant);
                    dtm.addRow(v);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setText("Lista de Pedidos:");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setExpandsSelectedPaths(false);
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jTree1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(519, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane1.addTab("        Platos  & Bebidas    ", jScrollPane1);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stove1.png"))); // NOI18N

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/wine-bottle.png"))); // NOI18N

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Descripción", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPedidos);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/payment.png"))); // NOI18N
        jButton4.setText("    PAGO");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/recibo.png"))); // NOI18N
        jButton5.setText("  CUENTA");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/min.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/clock.png"))); // NOI18N
        jButton7.setText("   En espera");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancel_food.png"))); // NOI18N
        jButton8.setText("    Cancelar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(104, 104, 104)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 801, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(563, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(tblPedidos.getSelectedRow() >=0){
           DefaultTableModel modelo = (DefaultTableModel)tblPedidos.getModel(); 
            modelo.removeRow(tblPedidos.getSelectedRow()); 
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       if(tblPedidos.getSelectedRow() >=0){
           int indx = tblPedidos.getSelectedRow();
           int val = Integer.parseInt(tblPedidos.getValueAt(indx, 1).toString());
           if (val != 1){
               val -= 1;
           }
           tblPedidos.setValueAt(val, indx, 1);
       }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.setVisible(false);
        Mesas_Selection Ms = new Mesas_Selection();
        Ms.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int x = JOptionPane.showOptionDialog(null,"¿Está seguro de cancelar el pedido?","Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,null,null);
        if(x == 0){
        this.setVisible(false);
        Mesas_Selection Ms = new Mesas_Selection();
        Ms.setVisible(true);}
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        
        String path = evt.getPath().toString();
        int pos = path.lastIndexOf(',') + 1;
        String select = "";
        int posicion = 0;
        int categoriafound = 0;
        select = path.substring(pos, path.length()).replace(']', ' ').replace('[', ' ').trim();
        boolean found = false;
        for (int i = 0; i < dlm.size(); i++){
            if(dlm.getElementAt(i).toString().substring(2,dlm.getElementAt(i).toString().length()).contains(select)){
                found = true;
                 posicion = dlm.elementAt(i).toString().indexOf('_');
                 categoriafound = Integer.parseInt(dlm.elementAt(i).toString().substring(0, posicion));
                System.out.println(dlm.elementAt(i).toString().substring(0, posicion));
            }
        }
        if(!found){
            for (int i = 0; i < dlmsub.size(); i++){
                if(dlmsub.getElementAt(i).toString().contains(select)){
                    found = true;
                    posicion = dlmsub.elementAt(i).toString().indexOf('_');
                    categoriafound = Integer.parseInt(dlmsub.elementAt(i).toString().substring(0, posicion));
                    System.out.println(dlmsub.elementAt(i).toString().substring(0, posicion));
                }
            }
        }
        if(!found){
            for (int i = 0; i < dlmultsub.size(); i++){
                if(dlmultsub.getElementAt(i).toString().contains(select)){
                    found = false;
                    posicion = dlmultsub.elementAt(i).toString().indexOf('_');
                    categoriafound = Integer.parseInt(dlmultsub.elementAt(i).toString().substring(0, posicion));
                    System.out.println(dlmultsub.elementAt(i).toString().substring(0, posicion));
                }
            }
        }
        if(FoundCount(path,',') != 0){
            
            if (BD_RS.ListarProds(FoundCount(path,','), categoriafound) != null){
                dlmFilter = BD_RS.ListarProds(FoundCount(path,','), categoriafound);
                LoadComp();
                
            }else{
                jPanel2.removeAll();
            }
            
        }
        System.out.println(path);
        System.out.println("Veces: " + FoundCount(path,','));
            
    }//GEN-LAST:event_jTree1ValueChanged
    private int FoundCount(String cad, char car){
        int count = 0;
        for (int i = 0; i < cad.length(); i++){
            if(car == cad.charAt(i))
                count+=1;
        }
        return count;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables
}
