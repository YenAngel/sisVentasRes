/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.presentacion.Pedido;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import ventas.modelo.DPedido;
import ventas.persistencia.util.BDUtil;
import ventas.persistencia.util.BD_RS;
import ventas.presentacion.Mesas_Selection;

/**
 *
 * @author AnibalMA
 */
public class frmPedido extends javax.swing.JFrame {
    public int w;
    public int nivel = 1;
    public int catL = 1;
    public int [] nCatSign;
    public DefaultListModel dlmFilter;
    public DefaultTableModel dtm;
    public DefaultListModel dlm;
    public DefaultListModel dlmsub;
    public DefaultListModel dlmultsub;
    public int r;
    public static int cat;
    public static int subcat;
   
    public frmPedido() {
        
        //BDUtil.conectar();
        //jPanel2.setLayout(null);
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        cboMozo.setModel(BD_RS.ListarCBOMozo());
        w = jTabbedPane1.getSize().width;
        //LoadComp();
        nCatSign = new int[3];
        dlmsub = new DefaultListModel();
        dlmultsub = new DefaultListModel();
        //dlm = BD_RS.ListarCategoriasPed();
        //dtm = FormatearTabla();
        dtm = BD_RS.DetallePedido(DPedido.nPedido);
        tblPedidos.setModel(dtm);
        ConfigTBL(tblPedidos);
        LoadCategorias();
        //LoadTree();
    }
    private void LoadCategorias(){
        dlm = BD_RS.ListarCategoriasPed();
        jPanel2.removeAll();
        jPanel2.updateUI();
        jPanel2.repaint();
        int cantCat = dlm.size();
        int a = 1;
        int x = 35;
        int y = 30;
        int cont = 0;
        int countitems = 0;
        int panelaum = 367;
        String div = String.valueOf(Double.parseDouble(cantCat/3+""));
        int cant3 = Integer.parseInt(div.substring(0,div.indexOf('.')));
        for(int i = 0; i<cant3; i++){
            x = 30;
            a = 1;
            while(a <= 3){
                JButton jb = new JButton();
                String cad = dlm.getElementAt(countitems).toString();
                jb.setText("<html>"+cad.substring(cad.indexOf('%')+1,cad.length())+ "</html>");
                jb.setFont(new Font("Tahoma", 1, 12));
                jb.setName("$" + cad.substring(0,cad.indexOf('%')));
                jb.setBounds(x, y, 165, 95);
                jb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb(evt);
            }
        });
                x+=249;
                a++;
                countitems++;
                jPanel2.add(jb);
            }
            y+=145;
            cont++;
            if(cont>2){
            panelaum+=70;
            jPanel2.setPreferredSize(new Dimension(721,panelaum));}
        }
        if ((cant3*3) != cantCat){
             x = 30;
            int res = cantCat - cant3*3 ;
            int vecesrun = 1;
            while(vecesrun <= res){
                JButton jb = new JButton();
                String cad = dlm.getElementAt(countitems).toString();
                jb.setText("<html>"+cad.substring(cad.indexOf('%')+1,cad.length())+ "</html>");
                jb.setFont(new Font("Tahoma", 1, 12));
                jb.setName("$"+cad.substring(0,cad.indexOf('%')));
                jb.setBounds(x, y, 165, 95);
                jb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb(evt);
            }
        });
                x+=249;
                a++;
                countitems++;
                jPanel2.add(jb);
                vecesrun++;
            }
            if(cont>2){
            panelaum+=70;
            jPanel2.setPreferredSize(new Dimension(721,panelaum));}
        }
    }
    private void jb(ActionEvent evt){
        
        String cad = evt.toString();
        catL = Integer.parseInt(cad.substring(cad.lastIndexOf('$')+1,cad.length()));
        nCatSign[nivel-1] = catL;
        nivel++;
        LoadSubCategorias(catL, nivel);
    }
    private void LoadSubCategorias(int idDad, int nivelc){
        dlm = BD_RS.ListarSubCategoriasPed(idDad, nivelc);
        
        jPanel2.removeAll();
        jPanel2.updateUI();
        jPanel2.repaint();
        if(dlm.size() == 0){
            dlmFilter = BD_RS.ListarProds(nivel-1, nCatSign[nivel-2], BD_RS.idlocal);
            if(dlmFilter.size() != 0)
            LoadComp();
        }else{
        int cantCat = dlm.size();
        //System.out.println(cantCat);
        int a = 1;
        int x = 35;
        int y = 30;
        int cont = 0;
        int countitems = 0;
        int panelaum = 367;
        String div = String.valueOf(Double.parseDouble(cantCat/3+""));
        int cant3 = Integer.parseInt(div.substring(0,div.indexOf('.')));
        for(int i = 0; i<cant3; i++){
            x = 30;
            a = 1;
            while(a <= 3){
                JButton jb = new JButton();
                String cad = dlm.getElementAt(countitems).toString();
                jb.setText("<html>"+cad.substring(cad.indexOf('%')+1,cad.length())+ "</html>");
                jb.setFont(new Font("Tahoma", 1, 12));
                jb.setName("$" + cad.substring(0,cad.indexOf('%')));
                jb.setBounds(x, y, 165, 95);
                jb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb(evt);
            }
        });
                x+=249;
                a++;
                countitems++;
                jPanel2.add(jb);
            }
            y+=145;
            cont++;
            if(cont>2){
            panelaum+=70;
            jPanel2.setPreferredSize(new Dimension(721,panelaum));}
        }
        if ((cant3*3) != cantCat){
             x = 30;
            int res = cantCat - cant3*3 ;
            int vecesrun = 1;
            while(vecesrun <= res){
                JButton jb = new JButton();
                String cad = dlm.getElementAt(countitems).toString();
                jb.setText("<html>"+cad.substring(cad.indexOf('%')+1,cad.length())+ "</html>");
                jb.setFont(new Font("Tahoma", 1, 12));
                jb.setName("$"+cad.substring(0,cad.indexOf('%')));
                jb.setBounds(x, y, 165, 95);
                jb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb(evt);
            }
        });
                x+=249;
                a++;
                countitems++;
                jPanel2.add(jb);
                vecesrun++;
            }
            if(cont>2){
            panelaum+=70;
            jPanel2.setPreferredSize(new Dimension(721,panelaum));}
        }}
    }
    private void LoadTree(){
        
        DefaultMutableTreeNode tnode  = new DefaultMutableTreeNode("Categorías");
        DefaultTreeModel dtreem = new DefaultTreeModel(tnode);
       // jTree1.setModel(dtreem);
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
        
        //setTreeState(jTree1, new TreePath(jTree1.getModel().getRoot()), true);
    }
    /*public static void setTreeState(JTree tree, TreePath path, boolean expanded) {
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
      
    
  }   */     
    private void LoadComp(){
        jPanel2.removeAll();
        jPanel2.updateUI();
        jPanel2.repaint();
        int h = 30;
        int a = 30;
        int c = 1;
        int cantPl = dlmFilter.size();
        int cont = 1;
        int countitems = 0;
        int panelaum = 367;
        String div = String.valueOf(Double.parseDouble(cantPl/4+""));
        int cant4 = Integer.parseInt(div.substring(0,div.indexOf('.')));
        //System.out.println("SIZE: " + dlmFilter.size());
        for (int i = 0; i < cant4; i++){
            h = 30;
            
            c = 1;
            while(c <= 4){
                //try{
                JLabel jl = new JLabel();
                //JLabel jl2 = new JLabel();
                //jl2.setText("");
                jl.setText("");
                //System.out.println("LOAD: " + dlmFilter.getElementAt(ls).toString());
                String cad = dlmFilter.getElementAt(cont-1).toString();
                jl.setName(cad);
               String rec = cad.substring(0,cad.indexOf('%')).replace(' ','_');
                //System.out.println("REC: " + rec);
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
                c++;
                h+=200;
                 //}
               // catch(Exception ex) {
                    
                cont++;
                //}
            }
            a+=108;
        }
        //Menos de 3 
        if ((cant4*4) != cantPl){
            h = 30;
            int res = cantPl - cant4*4 ;
            int vecesrun = 1;
            while(vecesrun <= res){
               JLabel jl = new JLabel();
               
                jl.setText("");
                //System.out.println("LOAD: " + dlmFilter.getElementAt(ls).toString());
                String cad = dlmFilter.getElementAt(cont-1).toString();
                jl.setName(cad);
               String rec = cad.substring(0,cad.indexOf('%')).replace(' ','_');
                System.out.println("REC: " + rec);
                jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/" + rec + ".jpg")));
               
                jl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               jl(evt);
            }
        });
                jl.setBounds(h, a, 140, 82);
               
                jPanel2.add(jl);
                
                h+=200;
                vecesrun ++;
                cont++;
             
            }
            a+=108; 
            }
        
    }
        
    
    public void jl(MouseEvent evt){
        int in, f, valcant;
        String platName;
        valcant = 1;
        String costo;
        in = evt.getSource().toString().indexOf("/recursos/") + 10;
        f = evt.getSource().toString().indexOf("disabledIcon=") - 5;
        Vector v = new Vector();
        
        platName = evt.getComponent().getName().substring(0,evt.getComponent().getName().indexOf('%'));
        costo = evt.getComponent().getName().substring(evt.getComponent().getName().indexOf('%')+1,evt.getComponent().getName().length());
        // Here, this site is for get price of dish
        if(tblPedidos.getModel().getRowCount() == 0){
                    v.add(platName);
                    v.add(valcant);
                    v.add(costo);
                    v.add(Double.parseDouble(costo)*(double)valcant);
                    dtm.addRow(v);
        }else{
            for(int i=0; i < tblPedidos.getModel().getRowCount(); i++){
                if(tblPedidos.getValueAt(i, 0).equals(platName)){
                   valcant = Integer.parseInt(tblPedidos.getValueAt(i, 1).toString()) + 1;
                   costo = tblPedidos.getValueAt(i, 2).toString();
                   tblPedidos.getModel().setValueAt(valcant, i, 1);
                   tblPedidos.getModel().setValueAt(Double.parseDouble(costo)*(double)valcant, i, 3);
                   return;
                }
            }
                    v.add(platName);
                    v.add(valcant);
                    v.add(costo);
                    v.add(Double.parseDouble(costo)*(double)valcant);
                    dtm.addRow(v);
        }
        ConfigTBL(tblPedidos);
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cboMozo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setText("Mozo:");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel16);
        jLabel16.setBounds(420, 480, 80, 38);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 435, 124, 47);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(200, 200));

        jPanel1.setPreferredSize(new java.awt.Dimension(825, 377));

        jPanel2.setPreferredSize(new java.awt.Dimension(721, 367));
        jPanel2.setLayout(null);
        jScrollPane3.setViewportView(jPanel2);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo_1.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane1.addTab("        Platos  & Bebidas    ", jScrollPane1);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(416, 26, 837, 434);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/stove1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 435, 65, 47);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/wine-bottle.png"))); // NOI18N
        getContentPane().add(jButton3);
        jButton3.setBounds(249, 435, 65, 47);

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

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 88, 304, 329);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/recibo.png"))); // NOI18N
        jButton5.setText("  CUENTA");
        getContentPane().add(jButton5);
        jButton5.setBounds(1030, 490, 221, 71);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/min.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(320, 112, 44, 44);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/clock.png"))); // NOI18N
        jButton7.setText("   En espera");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(10, 517, 221, 71);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancel_food.png"))); // NOI18N
        jButton8.setText("    Cancelar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(10, 619, 221, 71);

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel17.setText("Lista de Pedidos:");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel17);
        jLabel17.setBounds(10, 44, 258, 38);

        cboMozo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboMozo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMozoItemStateChanged(evt);
            }
        });
        cboMozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMozoActionPerformed(evt);
            }
        });
        getContentPane().add(cboMozo);
        cboMozo.setBounds(500, 480, 170, 40);

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
       ConfigTBL(tblPedidos);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       if(tblPedidos.getSelectedRow() >=0){
           int indx = tblPedidos.getSelectedRow();
           int val = Integer.parseInt(tblPedidos.getValueAt(indx, 1).toString());
           String costo = tblPedidos.getValueAt(indx, 2).toString();
           if (val != 1){
               
               val -= 1;
               
           }
           tblPedidos.getModel().setValueAt(val, indx, 1);
           tblPedidos.getModel().setValueAt(Double.parseDouble(costo)*(double)val, indx, 3);
       }
        ConfigTBL(tblPedidos);
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

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        //for(int i = 0; i < nCatSign.length; i++)
          // System.out.println(nCatSign[i]);
        if(nivel -1 == 1){
            nivel--;
            LoadCategorias();
            
        }else if(nivel - 1 > 1){
            nivel--;
        LoadSubCategorias(nCatSign[nivel-2], nivel);
        }
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for(int i = 0; i < tblPedidos.getColumnCount(); i++)
            System.out.println(tblPedidos.getTableHeader().getColumnModel().getColumn(i).getWidth());
            
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    private void cboMozoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMozoItemStateChanged
        /*
        if(cboPiso.getSelectedIndex() != -1){
            //System.out.println(Integer.parseInt(cboPiso.getSelectedItem().toString()));
            dlm = BD_RS.ListarMesasSelection(Integer.parseInt(cboPiso.getSelectedItem().toString()));
            dlmpedido = BD_RS.JoinPedido();
            LoadMesas();
        }
        */
    }//GEN-LAST:event_cboMozoItemStateChanged

    private void cboMozoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMozoActionPerformed
        if(cboMozo.getSelectedIndex() != -1){
            //System.out.println(Integer.parseInt(cboPiso.getSelectedItem().toString()));
          
        }
    }//GEN-LAST:event_cboMozoActionPerformed
    private int FoundCount(String cad, char car){
        int count = 0;
        for (int i = 0; i < cad.length(); i++){
            if(car == cad.charAt(i))
                count+=1;
        }
        return count;
    }
    private void ConfigTBL(JTable jt){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0; i < jt.getColumnCount(); i++){
            jt.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            
        }
        for(int i = 0; i < jt.getRowCount(); i++)
            jt.setRowHeight(i, 45);
        jt.setDefaultEditor(Object.class, null);
        jt.getTableHeader().setReorderingAllowed(false);
        jt.getTableHeader().getColumnModel().getColumn(0).setMinWidth(149);
        jt.getTableHeader().getColumnModel().getColumn(1).setMinWidth(57);
        jt.getTableHeader().getColumnModel().getColumn(2).setMinWidth(44);
        jt.getTableHeader().getColumnModel().getColumn(3).setMinWidth(51);
        jt.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(149);
        jt.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(57);
        jt.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(44);
        jt.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(51);
        /*jt.getColumnModel().getColumn(0).setMaxWidth(0);
        jt.getColumnModel().getColumn(0).setMinWidth(0);
        jt.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jt.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);*/
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
    private javax.swing.JComboBox<String> cboMozo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables
}
