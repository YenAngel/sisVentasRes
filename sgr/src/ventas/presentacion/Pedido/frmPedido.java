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
import java.io.File;
import java.nio.file.FileAlreadyExistsException;
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
    public DefaultListModel RecienEnviado = new DefaultListModel();
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
        CalcTotal();
        LoadCategorias();
        lblEstadoPedido.setText(lEstado);
        lblFecha.setText(Date.valueOf(LocalDate.now()).toString());
        if(lNumMesa != -1)
        lblMesa.setText(lNumMesa+"");
        else lblMesa.setText(DPedido.dlmDP.getElementAt(0) + "," + DPedido.dlmDP.getElementAt(1));
        
        lblPiso.setText(lNumPiso+"");
        lblSucursal.setText(lSucursal);
        if(DPedido.nPedido != 0){
            cboMozo.setSelectedItem(BD_RS.GetMozoByPedido(DPedido.nPedido));
            NameMozo = BD_RS.GetNCompletoBycboMozo(cboMozo.getSelectedItem().toString());
            lblConfirmar.setVisible(false);
            lblSubConfirmar.setVisible(false);
            btnCocina.setVisible(true);
            btnBar.setVisible(true);
            lblCuenta.setVisible(true);
            jLabel46.setVisible(true);
            lblAnular.setVisible(true);
            jLabel47.setVisible(true);
            cboMozo.setEnabled(false);
            lblNPedido.setText(lNPedido+"");
        }else{
            lblConfirmar.setVisible(true);
            lblSubConfirmar.setVisible(true);
            btnCocina.setVisible(false);
            btnBar.setVisible(false);
            lblCuenta.setVisible(false);
            jLabel46.setVisible(false);
            lblAnular.setVisible(false);
            jLabel47.setVisible(false);
            cboMozo.setEnabled(true);
            lblNPedido.setText("-");
        }
        //LoadTree();
    }
    private void LoadCategorias(){
        int ContRows = 0;
        Color st = new Color(0,176,240);
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
            ContRows++;
            x = 105;
            a = 1;
            while(a <= 2){
                System.out.println(st.toString());
                System.out.println(ContRows+"");
                JButton jb = new JButton();
                String cad = dlm.getElementAt(countitems).toString();
                jb.setText("<html>"+cad.substring(cad.indexOf('%')+1,cad.length())+ "</html>");
                jb.setFont(new Font("Tahoma", 1, 12));
                jb.setName("$" + cad.substring(0,cad.indexOf('%')));
                jb.setBounds(x, y, 165, 95);
                jb.setBackground(st);
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
            y+=115;
            cont++;
            System.out.println("Contador Cat: " + cont);
            /*if(cont>2){
            panelaum+=205;
            jPanel2.setPreferredSize(new Dimension(510,panelaum));}*/
            if(ContRows == 2){
                st = new Color(146,208,80);
            }else if(ContRows == 4){
                st = new Color(247,150,70);
            }else if(ContRows == 6){
                st = new Color(0,176,240);
                ContRows =0;
            }
        }
        
        if ((cant2*2) != cantCat){
            
             x = 105;
            int res = cantCat - cant2*2 ;
            int vecesrun = 1;
            while(vecesrun <= res){
                JButton jb = new JButton();
                String cad = dlm.getElementAt(countitems).toString();
                jb.setText("<html>"+cad.substring(cad.indexOf('%')+1,cad.length())+ "</html>");
                jb.setFont(new Font("Tahoma", 1, 12));
                jb.setName("$"+cad.substring(0,cad.indexOf('%')));
                jb.setBounds(x, y, 165, 95);
                jb.setBackground(st);
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
            /*if(cont>2){
            panelaum+=205;
            jPanel2.setPreferredSize(new Dimension(510,panelaum));}*/
        }
        String c = String.valueOf(Double.parseDouble(cantCat/3+""));
        int cant3 = Integer.parseInt(c.substring(0,c.indexOf('.'))) - 2;
        jPanel2.setPreferredSize(new Dimension(521,cant3*437));
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
        int ContRows = 0;
        Color st = new Color(0,176,240);
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
            ContRows++;
            x = 105;
            a = 1;
            while(a <= 2){
                JButton jb = new JButton();
                String cad = dlm.getElementAt(countitems).toString();
                jb.setText("<html>"+cad.substring(cad.indexOf('%')+1,cad.length())+ "</html>");
                jb.setFont(new Font("Tahoma", 1, 12));
                jb.setName("$" + cad.substring(0,cad.indexOf('%')));
                jb.setBounds(x, y, 165, 95);
                jb.setBackground(st);
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
            if(ContRows == 2){
                st = new Color(146,208,80);
            }else if(ContRows == 4){
                st = new Color(247,150,70);
            }else if(ContRows == 6){
                st = new Color(0,176,240);
                ContRows =0;
            }
            /*if(cont>2){
            panelaum+=70;
            jPanel2.setPreferredSize(new Dimension(510,panelaum));}*/
        }
        if ((cant2*2) != cantCat){
             x = 105;
            int res = cantCat - cant2*2 ;
            int vecesrun = 1;
            while(vecesrun <= res){
                JButton jb = new JButton();
                String cad = dlm.getElementAt(countitems).toString();
                jb.setText("<html>"+cad.substring(cad.indexOf('%')+1,cad.length())+ "</html>");
                jb.setFont(new Font("Tahoma", 1, 12));
                jb.setName("$"+cad.substring(0,cad.indexOf('%')));
                jb.setBounds(x, y, 165, 95);
                jb.setBackground(st);
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
            /*if(cont>2){
            panelaum+=70;
            jPanel2.setPreferredSize(new Dimension(510,panelaum));}*/
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
               String rec = cad.substring(0,cad.indexOf('%'));
                //System.out.println("REC: " + rec);
                String nIMG = cad.substring(cad.indexOf('+')+1, cad.length());
                
                File tempfile=new File("src/recursos/" + nIMG + ".jpg");
                if(tempfile.exists()){
                    jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/" + nIMG + ".jpg")));
                }else{
                    jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/default_dish.jpg")));
                }
                
                jlname.setText("<html>" + rec + "</html>");
                jlprice.setText("S/. " +cad.substring(cad.indexOf('%')+1, cad.indexOf('#')));
                jlprice.setForeground(new Color(18, 133, 43));
                int posx = 21 - rec.length();
                if(posx!= 0)
                    posx+=2;
                jlname.setBounds(h,a+87,140,30);
                jlname.setVerticalAlignment(JLabel.TOP);
                jlprice.setBounds(h+52,a+120,120,10);
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
            a+=158;
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
               String rec = cad.substring(0,cad.indexOf('%'));
                //System.out.println("REC: " + rec);
                String nIMG = cad.substring(cad.indexOf('+')+1, cad.length());
                
                File tempfile=new File("src/recursos/" + nIMG + ".jpg");
                if(tempfile.exists()){
                    jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/" + nIMG + ".jpg")));
                }else{
                    jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/default_dish.jpg")));
                }
                
                jlname.setText("<html>" + rec + "</html>");
                jlprice.setText("S/. " +cad.substring(cad.indexOf('%')+1, cad.indexOf('#')));
                jlprice.setForeground(new Color(18, 133, 43));
                //System.out.println(rec.replace('_', ' ').trim().length());
                int posx = 21 - rec.length();
                if(posx!= 0)
                    posx+=2;
                jlname.setBounds(h,a+87,140,30);
                jlname.setVerticalAlignment(JLabel.TOP);
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
            a+=158; 
            }
        
    }
        
    
    public void jl(MouseEvent evt){
        //System.out.println(evt.getComponent().getName());
        //System.out.println(evt.getSource().toString());
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
                    v.add(Return2Dec(Double.parseDouble(costo)*(double)valcant));
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
                   tblPedidos.getModel().setValueAt(Return2Dec(Double.parseDouble(costo)*(double)valcant), i, 3);
                    ConfigTBL(tblPedidos);
                   return;
                }
            }
                    v.add(platName);
                    v.add(valcant);
                    v.add(costo);
                    v.add(Return2Dec(Double.parseDouble(costo)*(double)valcant));
                    v.add("");
                    v.add("No");
                    v.add(envio);
                    dtm.addRow(v);
        }
        ConfigTBL(tblPedidos);
        CalcTotal();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContenedo = new javax.swing.JPanel();
        btnDel = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        btnRetornarCat = new javax.swing.JButton();
        btnInicioCat = new javax.swing.JButton();
        btnListardish = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnCocina = new javax.swing.JButton();
        btnBar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnMin = new javax.swing.JButton();
        btnDescr = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lblImgDetalleP = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtComents = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        cboMozo = new javax.swing.JComboBox<>();
        lblPiso1 = new javax.swing.JLabel();
        lblConfirmar = new javax.swing.JLabel();
        lblSubConfirmar = new javax.swing.JLabel();
        lblCuenta = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        lblAnular = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        lblAtras = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        lblEstadoPedido = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblEstadoPed = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblNPedido = new javax.swing.JLabel();
        lblMesa = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblPiso = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblSucursal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jpContenedo.setBackground(new java.awt.Color(183, 222, 232));
        jpContenedo.setLayout(null);

        btnDel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/del.png"))); // NOI18N
        btnDel.setToolTipText("Eliminar el Plato/Bebida seleccionado");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        jpContenedo.add(btnDel);
        btnDel.setBounds(320, 240, 44, 44);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 18, 153), 2));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(200, 200));

        jScrollPane1.setBackground(new java.awt.Color(153, 204, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(153, 204, 255));

        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(618, 377));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(244, 239, 202));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 18, 153), 2));
        jPanel2.setMaximumSize(new java.awt.Dimension(521, 9999));
        jPanel2.setPreferredSize(new java.awt.Dimension(521, 367));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(null);
        jScrollPane3.setViewportView(jPanel2);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 14, 600, 490);

        btnRetornarCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Undo_1.png"))); // NOI18N
        btnRetornarCat.setToolTipText("Categoría anterior");
        btnRetornarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetornarCatActionPerformed(evt);
            }
        });
        jPanel1.add(btnRetornarCat);
        btnRetornarCat.setBounds(480, 520, 60, 60);

        btnInicioCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/home_cat.png"))); // NOI18N
        btnInicioCat.setToolTipText("Inicio Categorías");
        btnInicioCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioCatActionPerformed(evt);
            }
        });
        jPanel1.add(btnInicioCat);
        btnInicioCat.setBounds(550, 520, 60, 60);

        btnListardish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/listdish.png"))); // NOI18N
        btnListardish.setToolTipText("Inicio Categorías");
        btnListardish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListardishActionPerformed(evt);
            }
        });
        jPanel1.add(btnListardish);
        btnListardish.setBounds(410, 520, 60, 59);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("S/.");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 0, 0));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("S/.");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTotal))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(10, 520, 160, 60);

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane1.addTab("        Platos  & Bebidas    ", new javax.swing.ImageIcon(getClass().getResource("/recursos/cereals.png")), jScrollPane1); // NOI18N

        jpContenedo.add(jTabbedPane1);
        jTabbedPane1.setBounds(380, 80, 630, 650);

        btnCocina.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCocina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/TCocina_v.png"))); // NOI18N
        btnCocina.setToolTipText("Enviar Platos a Cocina");
        btnCocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCocinaActionPerformed(evt);
            }
        });
        jpContenedo.add(btnCocina);
        btnCocina.setBounds(10, 530, 110, 60);

        btnBar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/TBar.png"))); // NOI18N
        btnBar.setToolTipText("Enviar bebidas a bar");
        btnBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarActionPerformed(evt);
            }
        });
        jpContenedo.add(btnBar);
        btnBar.setBounds(200, 530, 110, 60);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 18, 153)));

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

        jpContenedo.add(jScrollPane2);
        jScrollPane2.setBounds(10, 120, 304, 280);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/plus.png"))); // NOI18N
        btnAdd.setToolTipText("Aumentar la cantidad");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jpContenedo.add(btnAdd);
        btnAdd.setBounds(320, 190, 44, 44);

        btnMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/min.png"))); // NOI18N
        btnMin.setToolTipText("Disminuir la cantidad");
        btnMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinActionPerformed(evt);
            }
        });
        jpContenedo.add(btnMin);
        btnMin.setBounds(320, 140, 44, 44);

        btnDescr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDescr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/obs3.png"))); // NOI18N
        btnDescr.setToolTipText("Guardar Comentarios");
        btnDescr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescrActionPerformed(evt);
            }
        });
        jpContenedo.add(btnDescr);
        btnDescr.setBounds(320, 290, 44, 44);

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 18, 153)));

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel17.setText("Detalle Pedido");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        lblImgDetalleP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/detalle.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(lblImgDetalleP)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblImgDetalleP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpContenedo.add(jPanel3);
        jPanel3.setBounds(10, 80, 304, 40);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 18, 153)));

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

        jpContenedo.add(jScrollPane4);
        jScrollPane4.setBounds(10, 440, 304, 80);

        jPanel6.setBackground(new java.awt.Color(248, 248, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 153, 255)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboMozo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboMozo.setBorder(null);
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
        jPanel6.add(cboMozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 20, 100, 30));

        lblPiso1.setBackground(new java.awt.Color(153, 153, 153));
        lblPiso1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblPiso1.setForeground(new java.awt.Color(51, 51, 51));
        lblPiso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/mozo.png"))); // NOI18N
        lblPiso1.setToolTipText("");
        jPanel6.add(lblPiso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, -1, 40));

        lblConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/verificar.png"))); // NOI18N
        lblConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConfirmarMouseClicked(evt);
            }
        });
        jPanel6.add(lblConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        lblSubConfirmar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblSubConfirmar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubConfirmar.setText("OK");
        jPanel6.add(lblSubConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 30, 20));

        lblCuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cuenta.png"))); // NOI18N
        lblCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCuentaMouseClicked(evt);
            }
        });
        jPanel6.add(lblCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 30, -1));

        jLabel46.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Cuenta");
        jPanel6.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 50, 20));

        lblAnular.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/anular.png"))); // NOI18N
        lblAnular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnularMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblAnularMouseReleased(evt);
            }
        });
        jPanel6.add(lblAnular, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 30, -1));

        jLabel47.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Anular");
        jPanel6.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 50, 20));

        lblAtras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Retornar.png"))); // NOI18N
        lblAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtrasMouseClicked(evt);
            }
        });
        jPanel6.add(lblAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 50, -1));

        jLabel48.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Atrás");
        jPanel6.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 50, 20));

        jpContenedo.add(jPanel6);
        jPanel6.setBounds(0, 650, 380, 78);

        lblEstadoPedido.setBackground(new java.awt.Color(153, 153, 153));
        lblEstadoPedido.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblEstadoPedido.setForeground(new java.awt.Color(51, 51, 51));
        lblEstadoPedido.setText("#");
        lblEstadoPedido.setToolTipText("");
        jpContenedo.add(lblEstadoPedido);
        lblEstadoPedido.setBounds(830, 80, 160, 50);

        jPanel4.setBackground(new java.awt.Color(0, 153, 51));
        jpContenedo.add(jPanel4);
        jPanel4.setBounds(10, 70, 1000, 4);

        lblEstadoPed.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblEstadoPed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Estado.png"))); // NOI18N
        lblEstadoPed.setText("  Estado:");
        jpContenedo.add(lblEstadoPed);
        lblEstadoPed.setBounds(712, 80, 110, 50);

        jPanel8.setBackground(new java.awt.Color(0, 153, 51));
        jpContenedo.add(jPanel8);
        jPanel8.setBounds(0, 610, 371, 4);

        jPanel9.setBackground(new java.awt.Color(248, 248, 255));
        jPanel9.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Calendario.png"))); // NOI18N
        jPanel9.add(jLabel2);
        jLabel2.setBounds(450, 23, 32, 30);

        lblFecha.setBackground(new java.awt.Color(153, 153, 153));
        lblFecha.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(51, 51, 51));
        lblFecha.setText("#");
        jPanel9.add(lblFecha);
        lblFecha.setBounds(500, 20, 130, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logo_da_pedido.jpg"))); // NOI18N
        jPanel9.add(jLabel3);
        jLabel3.setBounds(640, 0, 360, 65);

        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/pedido_frmpedido.png"))); // NOI18N
        jPanel9.add(jLabel21);
        jLabel21.setBounds(340, 20, 32, 32);

        lblNPedido.setBackground(new java.awt.Color(153, 153, 153));
        lblNPedido.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblNPedido.setForeground(new java.awt.Color(51, 51, 51));
        lblNPedido.setText("#");
        lblNPedido.setToolTipText("");
        jPanel9.add(lblNPedido);
        lblNPedido.setBounds(390, 20, 40, 40);

        lblMesa.setBackground(new java.awt.Color(153, 153, 153));
        lblMesa.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblMesa.setForeground(new java.awt.Color(51, 51, 51));
        lblMesa.setText("#");
        lblMesa.setToolTipText("");
        jPanel9.add(lblMesa);
        lblMesa.setBounds(290, 20, 40, 40);

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/mesa.png"))); // NOI18N
        jPanel9.add(jLabel20);
        jLabel20.setBounds(240, 20, 32, 32);

        lblPiso.setBackground(new java.awt.Color(153, 153, 153));
        lblPiso.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblPiso.setForeground(new java.awt.Color(51, 51, 51));
        lblPiso.setText("#");
        lblPiso.setToolTipText("");
        jPanel9.add(lblPiso);
        lblPiso.setBounds(180, 20, 30, 38);

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Salon.png"))); // NOI18N
        jPanel9.add(jLabel18);
        jLabel18.setBounds(130, 20, 32, 32);

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Local.png"))); // NOI18N
        jPanel9.add(jLabel16);
        jLabel16.setBounds(0, 20, 32, 32);

        lblSucursal.setBackground(new java.awt.Color(153, 153, 153));
        lblSucursal.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblSucursal.setForeground(new java.awt.Color(51, 51, 51));
        lblSucursal.setText("#");
        jPanel9.add(lblSucursal);
        lblSucursal.setBounds(40, 20, 90, 38);

        jpContenedo.add(jPanel9);
        jPanel9.setBounds(10, 0, 1000, 65);

        getContentPane().add(jpContenedo);
        jpContenedo.setBounds(0, 0, 1024, 768);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
       if(tblPedidos.getSelectedRow() >=0){
           boolean del = false;
           System.out.println(tblPedidos.getModel().toString());
           int ind = tblPedidos.getSelectedRow();
           if(tblPedidos.getValueAt(ind, 5).equals("Si")){
                    System.out.println("NColumnas:" + tblPedidos.getColumnCount());
                 RecienEnviado.removeAllElements();
                 DefaultListModel PedidoEnviar = new DefaultListModel();
                        System.out.println(tblPedidos.getModel().getValueAt(ind, 6));
                     if(tblPedidos.getValueAt(ind, 6).toString().contains("C")){
                         PedidoEnviar.addElement(tblPedidos.getValueAt(ind, 0).toString() + "%" + tblPedidos.getValueAt(ind, 1).toString() + "$" + tblPedidos.getValueAt(ind, 4).toString() + "#" + tblPedidos.getValueAt(ind, 2).toString());
                         RecienEnviado.addElement(ind);
                                if(PedidoEnviar.size() != 0){
                                    PrintFormat.ListPlatosDescr = new String[PedidoEnviar.size()];
                                        PrintFormat.ListPlatosName = new String[PedidoEnviar.size()];
                                        PrintFormat.DishCantidad = new int[PedidoEnviar.size()];
                                        
                                    for(int i = 0; i<PedidoEnviar.size(); i++){

                                        String cad = PedidoEnviar.getElementAt(i).toString();
                                        System.out.println("INFO: " + cad);
                                        String nPlato = cad.substring(0,cad.indexOf('%'));
                                        del = BD_RS.EliminarPlatoB(DPedido.nPedido, nPlato);
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
                                    PrintFormat.NumSalon = lblPiso.getText();
                                    PrintFormat.ImpCancelToCocinaBar();
                                }
                 
                     }else if (tblPedidos.getValueAt(ind, 6).toString().contains("B")){
                                PedidoEnviar.addElement(tblPedidos.getValueAt(ind, 0).toString() + "%" + tblPedidos.getValueAt(ind, 1).toString() + "$" + tblPedidos.getValueAt(ind, 4).toString() + "#" + tblPedidos.getValueAt(ind, 2).toString());
                                RecienEnviado.addElement(ind);
                                if(PedidoEnviar.size() != 0){
                                    PrintFormat.ListPlatosDescr = new String[PedidoEnviar.size()];
                                        PrintFormat.ListPlatosName = new String[PedidoEnviar.size()];
                                        PrintFormat.DishCantidad = new int[PedidoEnviar.size()];
                                    //codigo para enviar a ticketera /COCINA/
                                    for(int i = 0; i<PedidoEnviar.size(); i++){

                                        String cad = PedidoEnviar.getElementAt(i).toString();
                                        System.out.println("INFO: " + cad);
                                        String nPlato = cad.substring(0,cad.indexOf('%'));
                                        int cant = Integer.parseInt(cad.substring(cad.indexOf('%')+1,cad.indexOf('$')));
                                        String descr = cad.substring(cad.indexOf('$')+1,cad.indexOf('#'));
                                        PrintFormat.DishCantidad[i] = cant;
                                        PrintFormat.ListPlatosName[i] = nPlato;
                                        del = BD_RS.EliminarPlatoB(DPedido.nPedido, nPlato);
                                        System.out.println("DescripciónP: " + descr);
                                        if(descr.length()==0){
                                        PrintFormat.ListPlatosDescr[i] = "-1";}
                                        else {PrintFormat.ListPlatosDescr[i] = descr;}
                                    }
                                    // BD
                                    PrintFormat.NMesa = Integer.parseInt(DPedido.dlmDP.getElementAt(0).toString());
                                    PrintFormat.Mesero = NameMozo;
                                    PrintFormat.NPedido = DPedido.nPedido;
                                    PrintFormat.TipoEnvio = "BAR";
                                    PrintFormat.NumSalon = lblPiso.getText();
                                    PrintFormat.ImpCancelToCocinaBar();
                                }
                     }
                 
                     if(del){
                    DefaultTableModel modelo = (DefaultTableModel)tblPedidos.getModel(); 
                     modelo.removeRow(tblPedidos.getSelectedRow());}
        
           }else{
               
                    DefaultTableModel modelo = (DefaultTableModel)tblPedidos.getModel(); 
                     modelo.removeRow(tblPedidos.getSelectedRow());
           }
                    
       }
       ConfigTBL(tblPedidos);
       CalcTotal();
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       if(tblPedidos.getSelectedRow() >=0){
            int indx = tblPedidos.getSelectedRow();
            
           if(tblPedidos.getValueAt(indx, 5) == "No"){
           
                int val = Integer.parseInt(tblPedidos.getValueAt(indx, 1).toString());
                String costo = tblPedidos.getValueAt(indx, 2).toString();


                    val += 1;


                tblPedidos.getModel().setValueAt(val, indx, 1);
                tblPedidos.getModel().setValueAt(Return2Dec(Double.parseDouble(costo)*(double)val), indx, 3);
            }
       }
       
        ConfigTBL(tblPedidos);
        CalcTotal();
    }//GEN-LAST:event_btnAddActionPerformed
    private String Return2Dec(double value){
        double parteEntera, resultado;
        resultado = value;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, 2);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, 2))+parteEntera;
        System.out.println("Resultado: " + resultado);
        String rs = resultado+"";
        if(rs.substring(rs.indexOf('.')+1, rs.length()).length()!=2){
            rs = rs + "0";
            System.out.println("RS: " + rs);
            System.out.println("ReturnRS: " + Double.parseDouble(rs));
            return rs;
        }
        return resultado + "";
    }
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
    private void CalcTotal(){
        try {
            double total = 0.0;
            for(int i = 0; i < tblPedidos.getRowCount(); i++){
                total += Double.parseDouble(tblPedidos.getModel().getValueAt(i, 3).toString());
            }
            lblTotal.setText(Return2Dec(total)+"");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    private void btnCocinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCocinaActionPerformed
        RecienEnviado.removeAllElements();
        DefaultListModel PedidoEnviar = new DefaultListModel();
        for(int i = 0; i < tblPedidos.getRowCount(); i++){
            if(tblPedidos.getValueAt(i, 5).toString().contains("No") && tblPedidos.getValueAt(i, 6).toString().contains("C")){
                PedidoEnviar.addElement(tblPedidos.getValueAt(i, 0).toString() + "%" + tblPedidos.getValueAt(i, 1).toString() + "$" + tblPedidos.getValueAt(i, 4).toString() + "#" + tblPedidos.getValueAt(i, 2).toString());
                RecienEnviado.addElement(i);
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
            PrintFormat.NumSalon = lblPiso.getText();
            PrintFormat.ImprimirToCocinaBar();
        }
        if(RecienEnviado.size() > 0){
            for(int i = 0; i < RecienEnviado.size(); i++){
                tblPedidos.setValueAt("Si", Integer.parseInt(RecienEnviado.getElementAt(i).toString()),5);
            }
        }
        //dtm = BD_RS.DetallePedido(DPedido.nPedido);    
        //tblPedidos.setModel(dtm);
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
           if(tblPedidos.getValueAt(indx, 5) == "No"){
           int val = Integer.parseInt(tblPedidos.getValueAt(indx, 1).toString());
           String costo = tblPedidos.getValueAt(indx, 2).toString();
           
            if (val-1 != 0)   
               val -= 1;
               
           
           tblPedidos.getModel().setValueAt(val, indx, 1);
           tblPedidos.getModel().setValueAt(Return2Dec(Double.parseDouble(costo)*(double)val), indx, 3);
            }
       }
        ConfigTBL(tblPedidos);
        CalcTotal();
    }//GEN-LAST:event_btnMinActionPerformed

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

    private void tblPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidosMouseClicked
       int ind = tblPedidos.getSelectedRow();
       if(ind != -1){
           txtComents.setText(tblPedidos.getValueAt(ind, 4).toString());
       }
    }//GEN-LAST:event_tblPedidosMouseClicked

    private void btnBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarActionPerformed
        RecienEnviado.removeAllElements();
        DefaultListModel PedidoEnviar = new DefaultListModel();
        for(int i = 0; i < tblPedidos.getRowCount(); i++){
            if(tblPedidos.getValueAt(i, 5).toString().contains("No") && tblPedidos.getValueAt(i, 6).toString().contains("B")){
                PedidoEnviar.addElement(tblPedidos.getValueAt(i, 0).toString() + "%" + tblPedidos.getValueAt(i, 1).toString() + "$" + tblPedidos.getValueAt(i, 4).toString() + "#" + tblPedidos.getValueAt(i, 2).toString());
                RecienEnviado.addElement(i);
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
            PrintFormat.NumSalon = lblPiso.getText();
            PrintFormat.ImprimirToCocinaBar();
        }
        if(RecienEnviado.size() > 0){
            for(int i = 0; i < RecienEnviado.size(); i++){
                tblPedidos.setValueAt("Si", Integer.parseInt(RecienEnviado.getElementAt(i).toString()),5);
            }
        }
        //dtm = BD_RS.DetallePedido(DPedido.nPedido);    
        //tblPedidos.setModel(dtm);
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
        try {
            dlmFilter = BD_RS.ListarProds(nivel-1, nCatSign[nivel-2], BD_RS.idlocal);
            if(dlmFilter.size() != 0)
            LoadComp();
        } catch (Exception e) {
        }
            
    }//GEN-LAST:event_btnListardishActionPerformed

    private void lblConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConfirmarMouseClicked
        btnCocina.setVisible(true);
            btnBar.setVisible(true);
            if(BD_RS.EstadoCaja() != 1){
                JOptionPane.showMessageDialog(null, "La caja está cerrada o falta aperturar","Aviso",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            lblConfirmar.setVisible(false);
            lblSubConfirmar.setVisible(false);
            DPedido.nPedido = BD_RS.ConfirmarPedido(DPedido.dlmDP, cboMozo.getSelectedItem().toString(), 1);
            if (DPedido.nPedido != -1){
                lblConfirmar.setVisible(false);
                lblSubConfirmar.setVisible(false);
                btnCocina.setVisible(true);
                btnBar.setVisible(true);
                lblCuenta.setVisible(true);
                jLabel46.setVisible(true);
                lblAnular.setVisible(true);
                jLabel47.setVisible(true);
                cboMozo.setEnabled(false);
                lblNPedido.setText(DPedido.nPedido+"");
                NameMozo = BD_RS.GetNCompletoBycboMozo(cboMozo.getSelectedItem().toString());
            }else{
                
                lblConfirmar.setVisible(true);
                lblSubConfirmar.setVisible(true);
                btnCocina.setVisible(false);
                btnBar.setVisible(false);
                lblCuenta.setVisible(false);
                jLabel46.setVisible(false);
                lblAnular.setVisible(false);
                jLabel47.setVisible(false);
                cboMozo.setEnabled(true);
            }
    }//GEN-LAST:event_lblConfirmarMouseClicked

    private void lblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMouseClicked
        this.setVisible(false);
        Mesas_Selection Ms = new Mesas_Selection();
        Ms.setVisible(true);
    }//GEN-LAST:event_lblAtrasMouseClicked

    private void lblCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCuentaMouseClicked
           int i = JOptionPane.showOptionDialog(null,"¿Confirmar: Solicitud CUENTA?", "Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
                if(i==0) {    
                    BD_RS.CerrarPedido(DPedido.nPedido);
                    Mesas_Selection ms = new Mesas_Selection();
                    this.setVisible(false);
                    ms.setVisible(true);
                }
    }//GEN-LAST:event_lblCuentaMouseClicked

    private void lblAnularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnularMouseClicked
        int i = JOptionPane.showOptionDialog(null,"¿Confirmar: Anular Pedido?", "Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
                if(i==0) {    
                    if(BD_RS.AnularPedido(DPedido.nPedido)){
                        AnularPedidoMethodo();
                        JOptionPane.showMessageDialog(null, "Pedido Anulado","Aviso",JOptionPane.INFORMATION_MESSAGE);
                        Mesas_Selection ms = new Mesas_Selection();
                        this.setVisible(false);
                        ms.setVisible(true);
                    }
                }
    }//GEN-LAST:event_lblAnularMouseClicked
    private void AnularPedidoMethodo(){
        RecienEnviado.removeAllElements();
        DefaultListModel PedidoEnviar = new DefaultListModel();
        for(int i = 0; i < tblPedidos.getRowCount(); i++){
            if(tblPedidos.getValueAt(i, 5).toString().contains("Si") && tblPedidos.getValueAt(i, 6).toString().contains("C")){
                PedidoEnviar.addElement(tblPedidos.getValueAt(i, 0).toString() + "%" + tblPedidos.getValueAt(i, 1).toString() + "$" + tblPedidos.getValueAt(i, 4).toString() + "#" + tblPedidos.getValueAt(i, 2).toString());
                RecienEnviado.addElement(i);
            }
        }
        if(PedidoEnviar.size() != 0){
                PrintFormat.ListPlatosDescr = new String[PedidoEnviar.size()];
                PrintFormat.ListPlatosName = new String[PedidoEnviar.size()];
                PrintFormat.DishCantidad = new int[PedidoEnviar.size()];
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
            PrintFormat.TipoEnvio = "Cocina";
            PrintFormat.NumSalon = lblPiso.getText();
            PrintFormat.ImpAnuladoToCocinaBar();
        }
        RecienEnviado.removeAllElements();
        PedidoEnviar = new DefaultListModel();
        for(int i = 0; i < tblPedidos.getRowCount(); i++){
            if(tblPedidos.getValueAt(i, 5).toString().contains("Si") && tblPedidos.getValueAt(i, 6).toString().contains("B")){
                PedidoEnviar.addElement(tblPedidos.getValueAt(i, 0).toString() + "%" + tblPedidos.getValueAt(i, 1).toString() + "$" + tblPedidos.getValueAt(i, 4).toString() + "#" + tblPedidos.getValueAt(i, 2).toString());
                RecienEnviado.addElement(i);
            }
        }
        if(PedidoEnviar.size() != 0){
                PrintFormat.ListPlatosDescr = new String[PedidoEnviar.size()];
                PrintFormat.ListPlatosName = new String[PedidoEnviar.size()];
                PrintFormat.DishCantidad = new int[PedidoEnviar.size()];
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
            PrintFormat.NumSalon = lblPiso.getText();
            PrintFormat.ImpAnuladoToCocinaBar();
        }
    }
    private void lblAnularMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnularMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAnularMouseReleased
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
        CalcTotal();
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
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnDescr;
    private javax.swing.JButton btnInicioCat;
    private javax.swing.JButton btnListardish;
    private javax.swing.JButton btnMin;
    private javax.swing.JButton btnRetornarCat;
    private javax.swing.JComboBox<String> cboMozo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpContenedo;
    private javax.swing.JLabel lblAnular;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblConfirmar;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblEstadoPed;
    private javax.swing.JLabel lblEstadoPedido;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblImgDetalleP;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblNPedido;
    private javax.swing.JLabel lblPiso;
    private javax.swing.JLabel lblPiso1;
    private javax.swing.JLabel lblSubConfirmar;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextArea txtComents;
    // End of variables declaration//GEN-END:variables
}
