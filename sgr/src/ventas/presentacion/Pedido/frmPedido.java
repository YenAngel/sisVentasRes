/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.presentacion.Pedido;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import ventas.modelo.DPedido;
import ventas.modelo.Local;
import ventas.modelo.Login_User;
import ventas.modelo.PrintFormat;
import ventas.persistencia.util.BD_RS;
import ventas.presentacion.Mesas_Selection;
import ventas.presentacion.Teclado_Letters;

/**
 *
 * @author AnibalMA
 */
public class frmPedido extends javax.swing.JFrame {
    public int w;
    public int nivel = 1;
    public int catL = 1;
    public int [] nCatSign;
    public int lNumMesa, lNumPiso, lNPedido;
    public String lSucursal, lEstado;
    public DefaultListModel dlmFilter;
    public DefaultTableModel dtm;
    public DefaultListModel dlm;
    public DefaultListModel dlmsub;
    public DefaultListModel dlmultsub;
    public int r;
    public static int cat;
    public static int subcat;
    public static String NameMozo;
    public static JTextArea ta;
    public static JDialog jd = new JDialog();
    public  Teclado_Letters t = new Teclado_Letters(this);
    public frmPedido() {
        lSucursal = Login_User.surcursal;
        lNPedido = DPedido.nPedido;
        if(DPedido.dlmDP.size() > 1)
            lNumMesa = -1;
        else lNumMesa = Integer.parseInt(DPedido.dlmDP.getElementAt(0).toString());
        lNumPiso = BD_RS.numPiso;
        lEstado = "Atención";
        
        //BDUtil.conectar();
        //jPanel2.setLayout(null);
        initComponents();
        jd.add(t.getContentPane());
        jd.setSize(t.getSize());
        
        jd.setModal(true);
        jd.setResizable(false);
        //jd.setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        jd.setLocation(new Point(298+getLocation().x,491));
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
        lblEstadoPedido.setText(lEstado);
        lblFecha.setText(Date.valueOf(LocalDate.now()).toString());
        if(lNumMesa != -1)
        lblMesa.setText(lNumMesa+"");
        else lblMesa.setText("~");
        lblNPedido.setText(lNPedido+"");
        lblPiso.setText(lNumPiso+"");
        lblSucursal.setText(lSucursal);
        if(DPedido.nPedido != 0){
            cboMozo.setSelectedItem(BD_RS.GetDNIMozo(DPedido.nPedido));
            NameMozo = BD_RS.GetMozoByDNI(cboMozo.getSelectedItem().toString());
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
        String div = String.valueOf(Double.parseDouble(cantCat/2+""));
        int cant2 = Integer.parseInt(div.substring(0,div.indexOf('.')));
        for(int i = 0; i<cant2; i++){
            x = 60;
            a = 1;
            while(a <= 2){
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
                if(a != 2)
                x+=229;
                a++;
                countitems++;
                jPanel2.add(jb);
            }
            y+=145;
            cont++;
            if(cont>2){
            panelaum+=70;
            jPanel2.setPreferredSize(new Dimension(510,panelaum));}
        }
        if ((cant2*2) != cantCat){
             x = 60;
            int res = cantCat - cant2*2 ;
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
                
                x+=229;
                a++;
                countitems++;
                jPanel2.add(jb);
                vecesrun++;
            }
            if(cont>2){
            panelaum+=70;
            jPanel2.setPreferredSize(new Dimension(510,panelaum));}
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
        String div = String.valueOf(Double.parseDouble(cantCat/2+""));
        int cant2 = Integer.parseInt(div.substring(0,div.indexOf('.')));
        for(int i = 0; i<cant2; i++){
            x = 60;
            a = 1;
            while(a <= 2){
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
                if(a!=2)
                x+=249;
                a++;
                countitems++;
                jPanel2.add(jb);
            }
            y+=145;
            cont++;
            if(cont>2){
            panelaum+=70;
            jPanel2.setPreferredSize(new Dimension(510,panelaum));}
        }
        if ((cant2*2) != cantCat){
             x = 60;
            int res = cantCat - cant2*2 ;
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
            jPanel2.setPreferredSize(new Dimension(510,panelaum));}
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
        String div = String.valueOf(Double.parseDouble(cantPl/3+""));
        int cant3 = Integer.parseInt(div.substring(0,div.indexOf('.')));
        //System.out.println("SIZE: " + dlmFilter.size());
        for (int i = 0; i < cant3; i++){
            h = 30;
            
            c = 1;
            while(c <= 3){
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
                jlprice.setText(cad.substring(cad.indexOf('%')+1, cad.indexOf('#')));
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
        if ((cant3*3) != cantPl){
            h = 30;
            int res = cantPl - cant3*3 ;
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
                jlprice.setText("S/. " +cad.substring(cad.indexOf('%')+1, cad.indexOf('#')));
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
        String envio;
        in = evt.getSource().toString().indexOf("/recursos/") + 10;
        f = evt.getSource().toString().indexOf("disabledIcon=") - 5;
        Vector v = new Vector();
        
        platName = evt.getComponent().getName().substring(0,evt.getComponent().getName().indexOf('%'));
        costo = evt.getComponent().getName().substring(evt.getComponent().getName().indexOf('%')+1,evt.getComponent().getName().indexOf('#'));
        envio = evt.getComponent().getName().substring(evt.getComponent().getName().indexOf('#')+1,evt.getComponent().getName().length());
        // Here, this site is for get price of dish
        if(tblPedidos.getModel().getRowCount() == 0){
                    v.add(platName);
                    v.add(valcant);
                    v.add(costo);
                    v.add(Double.parseDouble(costo)*(double)valcant);
                    v.add("");
                    v.add("No");
                    v.add(envio);
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
                    v.add(envio);
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
        btnListardish = new javax.swing.JButton();
        btnCocina = new javax.swing.JButton();
        btnBar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnMin = new javax.swing.JButton();
        btnDescr = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtComents = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        btnRetornar = new javax.swing.JButton();
        btnCuenta = new javax.swing.JButton();
        btnSavePedido = new javax.swing.JButton();
        cboMozo = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        lblImgLogo = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblSucursal = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        lblPiso = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        lblMesa = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        lblNPedido = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        lblEstadoPedido = new javax.swing.JLabel();

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
        btnDel.setBounds(320, 240, 44, 44);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(200, 200));

        jScrollPane1.setBackground(new java.awt.Color(153, 204, 255));
        jScrollPane1.setForeground(new java.awt.Color(153, 204, 255));

        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(618, 377));

        jPanel2.setMaximumSize(new java.awt.Dimension(521, 9999));
        jPanel2.setPreferredSize(new java.awt.Dimension(521, 367));
        jPanel2.setRequestFocusEnabled(false);
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

        btnListardish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/listdish.png"))); // NOI18N
        btnListardish.setToolTipText("Inicio Categorías");
        btnListardish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListardishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRetornarCat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInicioCat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListardish, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnListardish)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        jTabbedPane1.setBounds(380, 80, 630, 470);

        btnCocina.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCocina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/TCocina_v.png"))); // NOI18N
        btnCocina.setToolTipText("Enviar Platos a Cocina");
        btnCocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCocinaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCocina);
        btnCocina.setBounds(10, 530, 110, 60);

        btnBar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/TBar.png"))); // NOI18N
        btnBar.setToolTipText("Enviar bebidas a bar");
        btnBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBar);
        btnBar.setBounds(200, 530, 110, 60);

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
        jScrollPane2.setBounds(10, 120, 304, 280);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/plus.png"))); // NOI18N
        btnAdd.setToolTipText("Aumentar la cantidad");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(320, 190, 44, 44);

        btnMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/min.png"))); // NOI18N
        btnMin.setToolTipText("Disminuir la cantidad");
        btnMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinActionPerformed(evt);
            }
        });
        getContentPane().add(btnMin);
        btnMin.setBounds(320, 140, 44, 44);

        btnDescr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDescr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/obs3.png"))); // NOI18N
        btnDescr.setToolTipText("Guardar Comentarios");
        btnDescr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescrActionPerformed(evt);
            }
        });
        getContentPane().add(btnDescr);
        btnDescr.setBounds(320, 290, 44, 44);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 80, 304, 40);

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
        jPanel5.setBounds(10, 400, 304, 40);

        txtComents.setColumns(10);
        txtComents.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 12)); // NOI18N
        txtComents.setLineWrap(true);
        txtComents.setRows(5);
        txtComents.setWrapStyleWord(true);
        txtComents.setMaximumSize(new java.awt.Dimension(200, 200));
        txtComents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtComentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtComentsMouseEntered(evt);
            }
        });
        txtComents.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtComentsKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(txtComents);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 440, 304, 80);

        jPanel6.setBackground(new java.awt.Color(248, 248, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 153, 255)));

        btnRetornar.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnRetornar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Arrow-reload-2-icon.png"))); // NOI18N
        btnRetornar.setText("  Retornar");
        btnRetornar.setToolTipText("Regresar a la selección de Mesas");
        btnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetornarActionPerformed(evt);
            }
        });

        btnCuenta.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/recibo.png"))); // NOI18N
        btnCuenta.setText("    Cuenta");
        btnCuenta.setToolTipText("Cerrar Pedido");
        btnCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaActionPerformed(evt);
            }
        });

        btnSavePedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/view-task.png"))); // NOI18N
        btnSavePedido.setToolTipText("Iniciar Pedido");
        btnSavePedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePedidoActionPerformed(evt);
            }
        });

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

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
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
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 10, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(cboMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(btnSavePedido)
                    .addGap(89, 89, 89)
                    .addComponent(btnCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(btnRetornar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 9, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnRetornar, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                        .addComponent(btnCuenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnSavePedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(0, 9, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel6);
        jPanel6.setBounds(0, 680, 1020, 90);

        lblImgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logo_da_pedido.jpg"))); // NOI18N
        getContentPane().add(lblImgLogo);
        lblImgLogo.setBounds(660, 80, 350, 50);

        jPanel13.setBackground(new java.awt.Color(248, 248, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 255)));

        jPanel8.setBackground(new java.awt.Color(153, 204, 255));
        jPanel8.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel8.setForeground(new java.awt.Color(204, 204, 204));
        jPanel8.setPreferredSize(new java.awt.Dimension(150, 39));

        jLabel23.setBackground(new java.awt.Color(153, 153, 153));
        jLabel23.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Sucursal:");

        lblSucursal.setBackground(new java.awt.Color(153, 153, 153));
        lblSucursal.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblSucursal.setForeground(new java.awt.Color(51, 51, 51));
        lblSucursal.setText("#");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel9.setBackground(new java.awt.Color(153, 204, 255));
        jPanel9.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel9.setForeground(new java.awt.Color(204, 204, 204));
        jPanel9.setPreferredSize(new java.awt.Dimension(150, 39));

        jLabel24.setBackground(new java.awt.Color(153, 153, 153));
        jLabel24.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("N°Piso:");

        lblPiso.setBackground(new java.awt.Color(153, 153, 153));
        lblPiso.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblPiso.setForeground(new java.awt.Color(51, 51, 51));
        lblPiso.setText("#");
        lblPiso.setToolTipText("");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPiso, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel11.setBackground(new java.awt.Color(153, 204, 255));
        jPanel11.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel11.setForeground(new java.awt.Color(204, 204, 204));
        jPanel11.setPreferredSize(new java.awt.Dimension(150, 39));

        jLabel26.setBackground(new java.awt.Color(153, 153, 153));
        jLabel26.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("N°Mesa:");

        lblMesa.setBackground(new java.awt.Color(153, 153, 153));
        lblMesa.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblMesa.setForeground(new java.awt.Color(51, 51, 51));
        lblMesa.setText("#");
        lblMesa.setToolTipText("");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel12.setBackground(new java.awt.Color(153, 204, 255));
        jPanel12.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel12.setForeground(new java.awt.Color(204, 204, 204));
        jPanel12.setPreferredSize(new java.awt.Dimension(150, 39));

        jLabel27.setBackground(new java.awt.Color(153, 153, 153));
        jLabel27.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("N°Pedido:");

        lblNPedido.setBackground(new java.awt.Color(153, 153, 153));
        lblNPedido.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblNPedido.setForeground(new java.awt.Color(51, 51, 51));
        lblNPedido.setText("#");
        lblNPedido.setToolTipText("");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel10.setBackground(new java.awt.Color(153, 204, 255));
        jPanel10.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel10.setForeground(new java.awt.Color(204, 204, 204));
        jPanel10.setPreferredSize(new java.awt.Dimension(150, 39));

        jLabel25.setBackground(new java.awt.Color(153, 153, 153));
        jLabel25.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Fecha:");

        lblFecha.setBackground(new java.awt.Color(153, 153, 153));
        lblFecha.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(51, 51, 51));
        lblFecha.setText("#");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                    .addContainerGap(75, Short.MAX_VALUE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFecha)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));
        jPanel7.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel7.setForeground(new java.awt.Color(204, 204, 204));
        jPanel7.setPreferredSize(new java.awt.Dimension(150, 39));

        jLabel22.setBackground(new java.awt.Color(153, 153, 153));
        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Estado:");

        lblEstadoPedido.setBackground(new java.awt.Color(153, 153, 153));
        lblEstadoPedido.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblEstadoPedido.setForeground(new java.awt.Color(51, 51, 51));
        lblEstadoPedido.setText("#");
        lblEstadoPedido.setToolTipText("");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(79, Short.MAX_VALUE)
                    .addComponent(lblEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblEstadoPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel13);
        jPanel13.setBounds(0, 0, 1030, 70);

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
            if(tblPedidos.getValueAt(i, 5).toString().contains("No") && tblPedidos.getValueAt(i, 6).toString().contains("C")){
                PedidoEnviar.addElement(tblPedidos.getValueAt(i, 0).toString() + "%" + tblPedidos.getValueAt(i, 1).toString() + "$" + tblPedidos.getValueAt(i, 4).toString() + "#" + tblPedidos.getValueAt(i, 2).toString());
            }
        }
        if(PedidoEnviar.size() != 0){
            PrintFormat.ListPlatosDescr = new String[PedidoEnviar.size()];
                PrintFormat.ListPlatosName = new String[PedidoEnviar.size()];
                PrintFormat.DishCantidad = new int[PedidoEnviar.size()];
            BD_RS.IngresarDetallP(PedidoEnviar, DPedido.nPedido);
            //codigo para enviar a ticketera /COCINA/
            for(int i = 0; i<PedidoEnviar.size(); i++){
                
                String cad = PedidoEnviar.getElementAt(i).toString();
                System.out.println("INFO: " + cad);
                String nPlato = cad.substring(0,cad.indexOf('%'));
                int cant = Integer.parseInt(cad.substring(cad.indexOf('%')+1,cad.indexOf('$')));
                String descr = cad.substring(cad.indexOf('$')+1,cad.indexOf('#'));
                PrintFormat.DishCantidad[i] = cant;
                PrintFormat.ListPlatosName[i] = nPlato;
                System.out.println("DescripciónP: " + descr);
                if(descr.length()==0){
                PrintFormat.ListPlatosDescr[i] = "-1";}
                else {PrintFormat.ListPlatosDescr[i] = descr;}
            }
            PrintFormat.NMesa = Integer.parseInt(DPedido.dlmDP.getElementAt(0).toString());
            PrintFormat.Mesero = NameMozo;
            PrintFormat.NPedido = DPedido.nPedido;
            PrintFormat.TipoEnvio = "COCINA";
            PrintFormat.ImprimirToCocina();
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
            
            btnCocina.setVisible(true);
            btnBar.setVisible(true);
            if(BD_RS.EstadoCaja() != 1){
                JOptionPane.showMessageDialog(null, "La caja está cerrada o falta aperturar","Aviso",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            btnSavePedido.setVisible(false);
            DPedido.nPedido = BD_RS.ConfirmarPedido(DPedido.dlmDP, cboMozo.getSelectedItem().toString(), 1);
            if (DPedido.nPedido != -1){
                btnSavePedido.setVisible(false);
                btnCocina.setVisible(true);
                btnBar.setVisible(true);
                cboMozo.setEnabled(false);
                NameMozo = BD_RS.GetMozoByDNI(cboMozo.getSelectedItem().toString());
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
            if(tblPedidos.getValueAt(i, 5).toString().contains("No") && tblPedidos.getValueAt(i, 6).toString().contains("B")){
                PedidoEnviar.addElement(tblPedidos.getValueAt(i, 0).toString() + "%" + tblPedidos.getValueAt(i, 1).toString() + "$" + tblPedidos.getValueAt(i, 4).toString() + "#" + tblPedidos.getValueAt(i, 2).toString());
            }
        }
        if(PedidoEnviar.size() != 0){
                PrintFormat.ListPlatosDescr = new String[PedidoEnviar.size()];
                PrintFormat.ListPlatosName = new String[PedidoEnviar.size()];
                PrintFormat.DishCantidad = new int[PedidoEnviar.size()];
            BD_RS.IngresarDetallP(PedidoEnviar, DPedido.nPedido);
            for(int i = 0; i<PedidoEnviar.size(); i++){
                
                String cad = PedidoEnviar.getElementAt(i).toString();
                System.out.println("INFO: " + cad);
                String nPlato = cad.substring(0,cad.indexOf('%'));
                int cant = Integer.parseInt(cad.substring(cad.indexOf('%')+1,cad.indexOf('$')));
                String descr = cad.substring(cad.indexOf('$')+1,cad.indexOf('#'));
                PrintFormat.DishCantidad[i] = cant;
                PrintFormat.ListPlatosName[i] = nPlato;
                System.out.println("DescripciónP: " + descr);
                if(descr.length()==0){
                PrintFormat.ListPlatosDescr[i] = "-1";}
                else {PrintFormat.ListPlatosDescr[i] = descr;}
            }
            PrintFormat.NMesa = Integer.parseInt(DPedido.dlmDP.getElementAt(0).toString());
            PrintFormat.Mesero = NameMozo;
            PrintFormat.NPedido = DPedido.nPedido;
            PrintFormat.TipoEnvio = "BAR";
            PrintFormat.ImprimirToCocina();
        }
        dtm = BD_RS.DetallePedido(DPedido.nPedido);    
        tblPedidos.setModel(dtm);
        ConfigTBL(tblPedidos);
    }//GEN-LAST:event_btnBarActionPerformed

    private void txtComentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtComentsMouseClicked
        ta = txtComents;
        jd.setVisible(true);
    }//GEN-LAST:event_txtComentsMouseClicked

    private void txtComentsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComentsKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComentsKeyPressed

    private void txtComentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtComentsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComentsMouseEntered

    private void btnListardishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListardishActionPerformed
            dlmFilter = BD_RS.ListarProds(nivel-1, nCatSign[nivel-2], BD_RS.idlocal);
            if(dlmFilter.size() != 0)
            LoadComp();
    }//GEN-LAST:event_btnListardishActionPerformed
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
    // <editor-fold defaultstate="collapsed" desc="MethodosInputText-AnibalMA">                          
    public void Llenar(String text) {
        String nt = ta.getText().concat(text);
        ta.setText(nt);
    }

    public void ClearCaracter() {
        String nt = ta.getText();
        int s = ta.getText().length();
        if(s != 0){
            nt = nt.substring(0,nt.length()-1);
            ta.setText(nt);
        
        }
        
    }

    public void Space() {
        Llenar(" ");
    }

    public void CloseTeclado() {
        jd.dispose();
    }
    //</editor-fold>
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
    private javax.swing.JButton btnListardish;
    private javax.swing.JButton btnMin;
    private javax.swing.JButton btnRetornar;
    private javax.swing.JButton btnRetornarCat;
    private javax.swing.JButton btnSavePedido;
    private javax.swing.JComboBox<String> cboMozo;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblEstadoPedido;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblImgLogo;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblNPedido;
    private javax.swing.JLabel lblPiso;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextArea txtComents;
    // End of variables declaration//GEN-END:variables
}
