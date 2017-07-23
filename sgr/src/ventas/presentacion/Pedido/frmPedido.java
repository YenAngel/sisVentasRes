/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.presentacion.Pedido;

import java.awt.Color;
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
        if(DPedido.nPedido != 0){
            cboMozo.setSelectedItem(BD_RS.GetDNIMozo(DPedido.nPedido));
            btnSavePedido.setVisible(false);
            btnCocina.setVisible(true);
            btnBar.setVisible(true);
            cboMozo.setEnabled(false);
        }else{
            btnSavePedido.setVisible(true);
            btnCocina.setVisible(false);
            btnBar.setVisible(false);
            cboMozo.setEnabled(true);
        }
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
                JLabel jlname = new JLabel();
                JLabel jlprice = new JLabel();
                //JLabel jl2 = new JLabel();
                //jl2.setText("");
                jl.setText("");
                //System.out.println("LOAD: " + dlmFilter.getElementAt(ls).toString());
                String cad = dlmFilter.getElementAt(cont-1).toString();
                jl.setName(cad);
               String rec = cad.substring(0,cad.indexOf('%')).replace(' ','_');
                //System.out.println("REC: " + rec);
                jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/" + rec + ".jpg")));
                jlname.setText("<html>" + rec.replace('_', ' ').trim() + "</html>");
                jlprice.setText(cad.substring(cad.indexOf('%')+1, cad.length()));
                jlname.setBounds(h+5,a+87,120,30);
                jlprice.setBounds(h+5,a+120,120,10);
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
                jPanel2.add(jlname);
                jPanel2.add(jlprice);
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
               JLabel jlname = new JLabel();
                JLabel jlprice = new JLabel();
                jl.setText("");
                //System.out.println("LOAD: " + dlmFilter.getElementAt(ls).toString());
                String cad = dlmFilter.getElementAt(cont-1).toString();
                jl.setName(cad);
               String rec = cad.substring(0,cad.indexOf('%')).replace(' ','_');
                System.out.println("REC:" + rec);
                jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/" + rec + ".jpg")));
                jlname.setText("<html><center>" + rec.replace('_', ' ').trim() + "</center></html>");
                jlprice.setText("S/. " +cad.substring(cad.indexOf('%')+1, cad.length()));
                jlprice.setForeground(new Color(18, 133, 43));
                System.out.println(rec.replace('_', ' ').trim().length());
                int posx = 21 - rec.replace('_', ' ').trim().length();
                if(posx!= 0)
                    posx+=2;
                jlname.setBounds(h+posx * 3,a+87,140,30);
                jlprice.setBounds(h+52,a+120,120,10);
                jl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               jl(evt);
            }
        });                jl.setBounds(h, a, 140, 82);
               
                jPanel2.add(jl);
                jPanel2.add(jlname);
                jPanel2.add(jlprice);
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
                    v.add("");
                    v.add("No");
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
                    v.add("");
                    v.add("No");
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

        btnDel = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        btnRetornarCat = new javax.swing.JButton();
        btnInicioCat = new javax.swing.JButton();
        btnCocina = new javax.swing.JButton();
        btnBar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        btnCuenta = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRetornar = new javax.swing.JButton();
        cboMozo = new javax.swing.JComboBox<>();
        btnMin = new javax.swing.JButton();
        btnSavePedido = new javax.swing.JButton();
        btnDescr = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtComents = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        btnDel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/del.png"))); // NOI18N
        btnDel.setToolTipText("Eliminar el Plato/Bebida seleccionado");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        getContentPane().add(btnDel);
        btnDel.setBounds(320, 180, 44, 44);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(200, 200));

        jScrollPane1.setBackground(new java.awt.Color(153, 204, 255));
        jScrollPane1.setForeground(new java.awt.Color(153, 204, 255));

        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(825, 377));

        jPanel2.setPreferredSize(new java.awt.Dimension(721, 367));
        jPanel2.setLayout(null);
        jScrollPane3.setViewportView(jPanel2);

        btnRetornarCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo_1.png"))); // NOI18N
        btnRetornarCat.setToolTipText("Categoría anterior");
        btnRetornarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetornarCatActionPerformed(evt);
            }
        });

        btnInicioCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/home_cat.png"))); // NOI18N
        btnInicioCat.setToolTipText("Inicio Categorías");
        btnInicioCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioCatActionPerformed(evt);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRetornarCat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInicioCat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInicioCat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRetornarCat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane1.addTab("        Platos  & Bebidas    ", new javax.swing.ImageIcon(getClass().getResource("/recursos/cereals.png")), jScrollPane1); // NOI18N

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(416, 20, 837, 470);

        btnCocina.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCocina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/TCocina_v.png"))); // NOI18N
        btnCocina.setToolTipText("Enviar Platos a Cocina");
        btnCocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCocinaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCocina);
        btnCocina.setBounds(10, 473, 110, 60);

        btnBar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/TBar.png"))); // NOI18N
        btnBar.setToolTipText("Enviar bebidas a bar");
        btnBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBar);
        btnBar.setBounds(205, 473, 110, 60);

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
        tblPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPedidos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 60, 304, 280);

        btnCuenta.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/recibo.png"))); // NOI18N
        btnCuenta.setText("    Cuenta");
        btnCuenta.setToolTipText("Cerrar Pedido");
        btnCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCuenta);
        btnCuenta.setBounds(1040, 630, 221, 71);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/plus.png"))); // NOI18N
        btnAdd.setToolTipText("Aumentar la cantidad");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(320, 130, 44, 44);

        btnRetornar.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnRetornar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Arrow-reload-2-icon.png"))); // NOI18N
        btnRetornar.setText("  Retornar");
        btnRetornar.setToolTipText("Regresar a la selección de Mesas");
        btnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetornarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRetornar);
        btnRetornar.setBounds(1040, 550, 221, 71);

        cboMozo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboMozo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
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
        cboMozo.setBounds(636, 490, 170, 40);

        btnMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/min.png"))); // NOI18N
        btnMin.setToolTipText("Disminuir la cantidad");
        btnMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinActionPerformed(evt);
            }
        });
        getContentPane().add(btnMin);
        btnMin.setBounds(320, 80, 44, 44);

        btnSavePedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/view-task.png"))); // NOI18N
        btnSavePedido.setToolTipText("Iniciar Pedido");
        btnSavePedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSavePedido);
        btnSavePedido.setBounds(122, 473, 81, 60);

        btnDescr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDescr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/obs3.png"))); // NOI18N
        btnDescr.setToolTipText("Guardar Comentarios");
        btnDescr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescrActionPerformed(evt);
            }
        });
        getContentPane().add(btnDescr);
        btnDescr.setBounds(320, 230, 44, 44);

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel17.setText("Lista de Pedidos:");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 20, 304, 40);

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel18.setText("Atención - Mozo:");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel18)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(416, 490, 220, 40);

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));

        jLabel19.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel19.setText("Comentarios:");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(10, 340, 304, 40);

        txtComents.setColumns(10);
        txtComents.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 12)); // NOI18N
        txtComents.setLineWrap(true);
        txtComents.setRows(5);
        txtComents.setWrapStyleWord(true);
        txtComents.setMaximumSize(new java.awt.Dimension(200, 200));
        jScrollPane4.setViewportView(txtComents);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 380, 304, 80);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
       if(tblPedidos.getSelectedRow() >=0){
           DefaultTableModel modelo = (DefaultTableModel)tblPedidos.getModel(); 
            modelo.removeRow(tblPedidos.getSelectedRow()); 
       }
       ConfigTBL(tblPedidos);
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       if(tblPedidos.getSelectedRow() >=0){
           int indx = tblPedidos.getSelectedRow();
           int val = Integer.parseInt(tblPedidos.getValueAt(indx, 1).toString());
           String costo = tblPedidos.getValueAt(indx, 2).toString();
           
               
               val += 1;
               
           
           tblPedidos.getModel().setValueAt(val, indx, 1);
           tblPedidos.getModel().setValueAt(Double.parseDouble(costo)*(double)val, indx, 3);
       }
        ConfigTBL(tblPedidos);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetornarActionPerformed
        this.setVisible(false);
        Mesas_Selection Ms = new Mesas_Selection();
        Ms.setVisible(true);
    }//GEN-LAST:event_btnRetornarActionPerformed

    private void btnRetornarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetornarCatActionPerformed
        //for(int i = 0; i < nCatSign.length; i++)
          // System.out.println(nCatSign[i]);
        if(nivel -1 == 1){
            nivel--;
            LoadCategorias();
            
        }else if(nivel - 1 > 1){
            nivel--;
        LoadSubCategorias(nCatSign[nivel-2], nivel);
        }
        
    }//GEN-LAST:event_btnRetornarCatActionPerformed

    private void btnCocinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCocinaActionPerformed
        DefaultListModel PedidoEnviar = new DefaultListModel();
        for(int i = 0; i < tblPedidos.getRowCount(); i++){
            if(tblPedidos.getValueAt(i, 5).toString().contains("No")){
                PedidoEnviar.addElement(tblPedidos.getValueAt(i, 0).toString() + "%" + tblPedidos.getValueAt(i, 1).toString() + "$" + tblPedidos.getValueAt(i, 4).toString() + "#" + tblPedidos.getValueAt(i, 2).toString());
            }
        }
        if(PedidoEnviar.size() != 0){
            BD_RS.IngresarDetallP(PedidoEnviar, DPedido.nPedido);
        }
        dtm = BD_RS.DetallePedido(DPedido.nPedido);    
        tblPedidos.setModel(dtm);
        ConfigTBL(tblPedidos);
    }//GEN-LAST:event_btnCocinaActionPerformed

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

    private void btnMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinActionPerformed
       if(tblPedidos.getSelectedRow() >=0){
           int indx = tblPedidos.getSelectedRow();
           int val = Integer.parseInt(tblPedidos.getValueAt(indx, 1).toString());
           String costo = tblPedidos.getValueAt(indx, 2).toString();
           
            if (val-1 != 0)   
               val -= 1;
               
           
           tblPedidos.getModel().setValueAt(val, indx, 1);
           tblPedidos.getModel().setValueAt(Double.parseDouble(costo)*(double)val, indx, 3);
       }
        ConfigTBL(tblPedidos);
    }//GEN-LAST:event_btnMinActionPerformed

    private void btnSavePedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePedidoActionPerformed
            btnSavePedido.setVisible(false);
            btnCocina.setVisible(true);
            btnBar.setVisible(true);
            DPedido.nPedido = BD_RS.ConfirmarPedido(DPedido.dlmDP, cboMozo.getSelectedItem().toString(), 1);
            if (DPedido.nPedido != -1){
                btnSavePedido.setVisible(false);
                btnCocina.setVisible(true);
                btnBar.setVisible(true);
                cboMozo.setEnabled(false);
            }else{
                btnSavePedido.setVisible(true);
                btnCocina.setVisible(false);
                btnBar.setVisible(false);
                cboMozo.setEnabled(true);
            }
    }//GEN-LAST:event_btnSavePedidoActionPerformed

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentaActionPerformed
                BD_RS.CerrarPedido(DPedido.nPedido);
                Mesas_Selection ms = new Mesas_Selection();
                this.setVisible(false);
                ms.setVisible(true);
    }//GEN-LAST:event_btnCuentaActionPerformed

    private void btnDescrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescrActionPerformed
                int ind = tblPedidos.getSelectedRow();
                if(ind != -1){
                    String com = txtComents.getText();
                    if(com.length() > 50)
                        com = com.substring(0, 50);
                    tblPedidos.setValueAt(com, ind, 4);
                }
    }//GEN-LAST:event_btnDescrActionPerformed

    private void btnInicioCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioCatActionPerformed
        LoadCategorias();
        nivel = 1;
    }//GEN-LAST:event_btnInicioCatActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    private void tblPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidosMouseClicked
       int ind = tblPedidos.getSelectedRow();
       if(ind != -1){
           txtComents.setText(tblPedidos.getValueAt(ind, 4).toString());
       }
    }//GEN-LAST:event_tblPedidosMouseClicked

    private void btnBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarActionPerformed
        DefaultListModel PedidoEnviar = new DefaultListModel();
        for(int i = 0; i < tblPedidos.getRowCount(); i++){
            if(tblPedidos.getValueAt(i, 5).toString().contains("No")){
                PedidoEnviar.addElement(tblPedidos.getValueAt(i, 0).toString() + "%" + tblPedidos.getValueAt(i, 1).toString() + "$" + tblPedidos.getValueAt(i, 4).toString() + "#" + tblPedidos.getValueAt(i, 2).toString());
            }
        }
        if(PedidoEnviar.size() != 0){
            BD_RS.IngresarDetallP(PedidoEnviar, DPedido.nPedido);
        }
        dtm = BD_RS.DetallePedido(DPedido.nPedido);    
        tblPedidos.setModel(dtm);
        ConfigTBL(tblPedidos);
    }//GEN-LAST:event_btnBarActionPerformed
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBar;
    private javax.swing.JButton btnCocina;
    private javax.swing.JButton btnCuenta;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnDescr;
    private javax.swing.JButton btnInicioCat;
    private javax.swing.JButton btnMin;
    private javax.swing.JButton btnRetornar;
    private javax.swing.JButton btnRetornarCat;
    private javax.swing.JButton btnSavePedido;
    private javax.swing.JComboBox<String> cboMozo;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextArea txtComents;
    // End of variables declaration//GEN-END:variables
}
