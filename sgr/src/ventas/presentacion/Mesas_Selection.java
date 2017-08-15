
package ventas.presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import javax.swing.DefaultListModel;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.DPedido;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BD_RS;
import ventas.presentacion.Pedido.frmPedido;
import ventas.presentacion.Venta.frmCaja;

public class Mesas_Selection extends javax.swing.JFrame {
   /*public static frmPedido frmPe = new frmPedido();
   public static frmPedido frmPe2 = new frmPedido();
   public static frmPedido frmPe3 = new frmPedido();
   public static frmPedido frmPe4 = new frmPedido();
   public static frmPedido frmPe5 = new frmPedido();
   public static frmPedido frmPe6 = new frmPedido();
   public static frmPedido frmPe7 = new frmPedido();
   public static frmPedido frmPe8 = new frmPedido();*/
   public static int es[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
   public static DefaultListModel dlm;
   public static DefaultListModel dlmpedido;
   public static String mozo;
   public static int numberPedido;
   public static int numberMesasGroup = 0;
   
    /**
     * Creates new form Mesas_Selection
     */
    public Mesas_Selection() {
        
        int s = 0;
        initComponents();
        HoraL();
        lblSuc.setText(Login_User.surcursal);
        jLabel19.setVisible(false);
        jLabel45.setVisible(false);
        //System.out.println(jPanel11.getBackground().getRGB());
        setExtendedState(MAXIMIZED_BOTH);
        cboPiso.setModel(BD_RS.ListarCBOPisos());
        
        ((JLabel)cboPiso.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        if(cboPiso.getSelectedIndex() != -1){
            //frmCaja c=new frmCaja();
            //c.getpiso(Integer.parseInt(cboPiso.getSelectedItem().toString()));
            DPedido.dlmDP.removeAllElements();
            DPedido.nPisoPedido = Integer.parseInt(cboPiso.getSelectedItem().toString());
            BD_RS.numPiso = Integer.parseInt(cboPiso.getSelectedItem().toString());
            //System.out.println(Integer.parseInt(cboPiso.getSelectedItem().toString()));
            dlm = BD_RS.ListarMesasSelection(Integer.parseInt(cboPiso.getSelectedItem().toString()));
            dlmpedido = BD_RS.JoinPedido(Integer.parseInt(cboPiso.getSelectedItem().toString()));
            LoadMesas();}
        //dlm = BD_RS.ListarMesasSelection(Integer.parseInt(cboPiso.getSelectedItem().toString()));
        //LoadMesas();
        /*for(Component c : getContentPane().getComponents()){
            if (c instanceof JPanel) {
                System.out.println(((JPanel)c).getName());
                if(es[s] == 1){
                    ((JPanel)c).setBackground(new Color(0,126,41));
                }else{
                    //[0,126,41]
                    ((JPanel)c).setBackground(new Color(204,0,0));
                }
                s+=1;
            }
        }*/
            
            
        /*jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel7.setVisible(false);
        jPanel8.setVisible(false);
        jPanel9.setVisible(false);
        jPanel10.setVisible(false);
        jPanel11.setVisible(false);
        jPanel12.setVisible(false);
        jPanel13.setVisible(false);
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(true);
                jPanel4.setVisible(true);
                jPanel5.setVisible(true);
                jPanel7.setVisible(true);
                jPanel8.setVisible(true);
                jPanel9.setVisible(true);*/
    }
    public void LoadMesas(){
        jPanel2.removeAll();
        jPanel2.updateUI();
        jPanel2.repaint();
        int a = 1;
        int mesas = dlm.size();
        Random rnd = new Random();
        String div = String.valueOf(Double.parseDouble(mesas/4+""));
        int cant4 = Integer.parseInt(div.substring(0,div.indexOf('.')));
        //System.out.println(cant4);
        int panelaum = 20;
        int x = 40,y = 20;
        int cont = 1;
        for (int i =0; i<cant4; i++){
            x = 20;
            a = 1;
            while (a <= 4){
            JPanel jp = new JPanel();
            JLabel jl = new JLabel();
            JLabel jlIMGChair = new JLabel();
            JLabel jlTextNChair = new JLabel();
            JCheckBox jc = new JCheckBox();
            JLabel jlIMG = new JLabel();
            String cad = dlm.getElementAt(cont-1).toString();
            int nmesa  = Integer.parseInt(cad.substring(0,cad.indexOf('#')));
            jp.setLayout(null);
            jp.setBounds(x, y, 200 , 150);
            jl.setText(nmesa+"");
            jl.setFont(new Font("Arial Black", 1, 24));
            jl.setForeground(Color.WHITE);
            jl.setBounds(10, 3, 80, 52);
            jc.setBounds(170, 7, 21, 21);
            
            jc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jc(evt);
            }
        });
            jlIMGChair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/chair.png")));
            jlIMGChair.setBounds(10, 116, 24, 24);
            jlTextNChair.setText(cad.substring(cad.indexOf('#')+1,cad.length())+"");
            jlTextNChair.setFont(new Font("Arial Black", 1, 9));
            jlTextNChair.setForeground(Color.WHITE);
            jlTextNChair.setBounds(35, 116, 30, 24);
            jlIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logo4_min.png")));
            jlIMG.setBounds(30, 25, 140, 66);
            jp.add(jl);
            jp.add(jc);
            jp.add(jlIMG);
            jp.add(jlIMGChair);
            jp.add(jlTextNChair);
            jlIMG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               jlIMG(evt);     
                //System.out.println("click1");
            }
        });
            a++;
            cont++;
            x+=250;
                if(JoinMesa(nmesa)){
                    //JOptionPane.showMessageDialog(rootPane,"JoinMesa: " + nmesa);
                    jlIMGChair.setBounds(10, 86, 24, 24);
                    jlTextNChair.setBounds(35, 86, 30, 24);
                    jp.setBackground(new Color(210, 42, 14));
                    JLabel jMozo = new JLabel();
                    JLabel jNPed = new JLabel();
                    JLabel imgMozo = new JLabel();
                    JLabel imgPed = new JLabel();
                    jMozo.setText(mozo);
                    jNPed.setText(numberPedido +"");
                    jMozo.setFont(new Font("Arial Black", 1, 8));
                    jMozo.setForeground(Color.WHITE);
                    jMozo.setBounds(40, 120, 175, 24);
                    jNPed.setFont(new Font("Arial Black", 1, 9));
                    jNPed.setForeground(Color.WHITE);
                    jNPed.setBounds(87, 86, 30, 24);
                    imgMozo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/waiter.png")));
                    imgMozo.setBounds(10, 116, 24, 24);
                    imgPed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/listped.png")));
                    imgPed.setBounds(60, 86, 24, 24);
                    jlIMG.setName("#" + nmesa + "$" + numberPedido);
                    
                    jc.setName("#" + nmesa + "$" + numberPedido);
                    jc.setVisible(false);
                    jp.add(jMozo);
                    jp.add(imgMozo);
                    jp.add(imgPed);
                    jp.add(jNPed);
                }else{
                    jp.setBackground(new Color(18, 133, 43));
                    jc.setBackground(new Color(18, 133, 43));
                    jlIMG.setName("#" + nmesa + "$");
                    jc.setName("#" + nmesa + "$");
                    jc.setVisible(true);
                }
                jPanel2.add(jp);
            }
            y+=190;
            panelaum+=225;
            jPanel2.setPreferredSize(new Dimension(980,panelaum));
        }
        if ((cant4*4) != mesas){
            x = 20;
            int res = mesas - cant4*4 ;
            int vecesrun = 1;
            while(vecesrun <= res){
                JPanel jp = new JPanel();
                JLabel jl = new JLabel();
                JLabel jlIMGChair = new JLabel();
                JLabel jlTextNChair = new JLabel();
                JCheckBox jc = new JCheckBox();
                jc.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    jc(evt);
                }
                });
                
            JLabel jlIMG = new JLabel();
            String cad = dlm.getElementAt(cont-1).toString();
            int nmesa  = Integer.parseInt(cad.substring(0,cad.indexOf('#')));
            
            jp.setLayout(null);
            jp.setBounds(x, y, 200 , 150);
            jl.setText(nmesa+"");
            jl.setFont(new Font("Arial Black", 1, 24));
            jl.setForeground(Color.WHITE);
            jl.setBounds(10, 3, 80, 52);
            jc.setBounds(170, 7, 21, 21);
            jlIMGChair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/chair.png")));
            jlIMGChair.setBounds(10, 86, 24, 24);
            jlTextNChair.setText(cad.substring(cad.indexOf('#')+1,cad.length())+"");
            jlTextNChair.setFont(new Font("Arial Black", 1, 9));
            jlTextNChair.setForeground(Color.WHITE);
            jlTextNChair.setBounds(35, 86, 30, 24);
            jlIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logo4_min.png")));
            jlIMG.setBounds(30, 25, 140, 66);
            jlIMG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               jlIMG(evt);
               //System.out.println("click1");
            }
        });
            jp.add(jl);
            jp.add(jc);
            jp.add(jlIMG);
            jp.add(jlIMGChair);
            jp.add(jlTextNChair);
            
            vecesrun++;
            cont++;
            x+=250;
             if(JoinMesa(nmesa)){
                 //JOptionPane.showMessageDialog(rootPane,"JoinMesa: " + nmesa);
                    jlIMGChair.setBounds(10, 86, 24, 24);
                    jlTextNChair.setBounds(35, 86, 30, 24);
                    jp.setBackground(new Color(210, 42, 14)); //Color Red
                    JLabel jMozo = new JLabel();
                    JLabel jNPed = new JLabel();
                    JLabel imgMozo = new JLabel();
                    JLabel imgPed = new JLabel();
                    jMozo.setText(mozo);
                    jNPed.setText(numberPedido +"");
                    jMozo.setFont(new Font("Arial Black", 1, 8));
                    jMozo.setForeground(Color.WHITE);
                    jMozo.setBounds(40, 120, 175, 24);
                    jNPed.setFont(new Font("Arial Black", 1, 9));
                    jNPed.setForeground(Color.WHITE);
                    jNPed.setBounds(87, 86, 30, 24);
                    imgMozo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/waiter.png")));
                    imgMozo.setBounds(10, 116, 24, 24);
                    imgPed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/listped.png")));
                    imgPed.setBounds(60, 86, 24, 24);
                    jlIMG.setName("#" +nmesa + "$" + numberPedido);
                    jc.setName("#" +nmesa + "$" + numberPedido);
                    jp.add(jMozo);
                    jp.add(imgMozo);
                    jp.add(imgPed);
                    jp.add(jNPed);
                    jc.setVisible(false);
                }else{
                    jp.setBackground(new Color(18, 133, 43)); //Color Green
                    jc.setBackground(new Color(18, 133, 43));
                    jlIMG.setName("#" + nmesa+"$");
                    jc.setName("#" +nmesa + "$");
                    jc.setVisible(true);
                }
             jPanel2.add(jp);
            }
            y+=190;
            panelaum+=225;
            jPanel2.setPreferredSize(new Dimension(980,panelaum));
        }
    }
    public void jlIMG(MouseEvent evt){
        DPedido.dlmDP.removeAllElements();
        String cadena = evt.toString().substring(evt.toString().indexOf('#')+1, evt.toString().length());
        String nMesa = cadena.substring(0,cadena.indexOf('$'));
        //JOptionPane.showMessageDialog(null, nMesa);
        String nPedido = cadena.substring(cadena.indexOf('$')+1,cadena.length());
        if(nPedido.length() != 0){
            DPedido.nPedido = Integer.parseInt(nPedido);
            if(BD_RS.EstadoPedidoinMS(DPedido.nPedido) == 4){
                JOptionPane.showMessageDialog(null, "El pedido se encuentra con Estado: Atendido","Aviso",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            // Ver Estado
        }else{
            DPedido.nPedido = 0;
        }
        if(BD_RS.EstadoApeCaja() == 0){
            JOptionPane.showMessageDialog(null, "La caja aún no ha sido aperturada ","Aviso",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(BD_RS.EstadoCierreCaja()==0){
        DPedido.dlmDP.addElement(nMesa);
        // llamar al formulario pedido
        frmPedido frmPed = new frmPedido();
           this.setVisible(false);
           frmPed.setVisible(true);
        //frmCaja c=new frmCaja();
        //c.getMesa(evt);
        }else{
            JOptionPane.showMessageDialog(null, "La caja se encuentra cerrada ","Aviso",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void jc(ItemEvent evt){
        String nmesa = evt.toString().substring(evt.toString().lastIndexOf('#')+1, evt.toString().length()).replace("$", "");
        if (evt.getStateChange() == 1){
            numberMesasGroup+=1;
            DPedido.dlmDP.addElement(nmesa);
        }else if(evt.getStateChange()==2){
            numberMesasGroup-=1;
            DPedido.dlmDP.removeElement(nmesa);
        }
        BtnGroupVis();
        
        
    }
    public static boolean JoinMesa(int mesa){
        int valinit = 0;
        String cad = "";
        for(int i = 0; i < dlmpedido.size(); i++){
            cad = dlmpedido.getElementAt(i).toString();
            valinit = Integer.parseInt(cad.substring(cad.indexOf('#')+1,cad.indexOf('$')));
            
            if(valinit == mesa){
                numberPedido = Integer.parseInt(cad.substring(0, cad.indexOf('#')));
                mozo = cad.substring(cad.indexOf('$')+1, cad.length());
                return true;
            }
        }
        return false;
    }
    public static DefaultTableModel FormatearTabla(){
        DefaultTableModel dtm = new DefaultTableModel();
        String [] cab = {"Descripción","Cantidad"};
        dtm.setColumnIdentifiers(cab);
        return dtm;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        cboPiso = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        FH = new javax.swing.JLabel();
        lblSuc = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(17, 180, 63));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(183, 222, 232));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Local.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 38));

        cboPiso.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cboPiso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPisoItemStateChanged(evt);
            }
        });
        cboPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPisoActionPerformed(evt);
            }
        });
        jPanel1.add(cboPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 30, 120, 35));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 86, 135), 2));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1328, 588));

        jPanel2.setBackground(new java.awt.Color(222, 252, 187));
        jPanel2.setPreferredSize(new java.awt.Dimension(980, 588));
        jPanel2.setLayout(null);
        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1005, 530));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Calendario.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 40, 40));

        FH.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        FH.setText("#FH");
        jPanel1.add(FH, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 30, -1, 40));

        lblSuc.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblSuc.setText("#Suc");
        jPanel1.add(lblSuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 38));

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Salon.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, 38));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/leyenda2.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 14, 340, 53));

        jLabel19.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/group_pedido.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 70, 38));

        jLabel45.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Pedido");
        jPanel3.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 70, 30));

        jLabel43.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Refrescar");
        jPanel3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 70, 30));

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Refrescar.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 70, 38));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Salir.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, -1));

        jLabel44.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Salir");
        jPanel3.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 40, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 675, 1000, 80));

        jPanel4.setBackground(new java.awt.Color(0, 153, 51));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1004, 4));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logo_da_pedido.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 10, 360, 60));

        jPanel5.setBackground(new java.awt.Color(0, 153, 51));
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 655, 1004, 4));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 768));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void BtnGroupVis(){
        if(numberMesasGroup != 0){
            jLabel19.setVisible(true);
            jLabel45.setVisible(true);
        }else{
            jLabel19.setVisible(false);
            jLabel45.setVisible(false);
        }
    }
    private void cboPisoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPisoItemStateChanged
        if(cboPiso.getSelectedIndex() != -1){
            BD_RS.numPiso = Integer.parseInt(cboPiso.getSelectedItem().toString());
            //System.out.println(Integer.parseInt(cboPiso.getSelectedItem().toString()));
           /* dlm = BD_RS.ListarMesasSelection(Integer.parseInt(cboPiso.getSelectedItem().toString()));
            dlmpedido = BD_RS.JoinPedido();
            LoadMesas();*/
        }
           
    }//GEN-LAST:event_cboPisoItemStateChanged
    
    private void cboPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPisoActionPerformed
        if(cboPiso.getSelectedIndex() != -1){
            //frmCaja c=new frmCaja();
           // c.getpiso(Integer.parseInt(cboPiso.getSelectedItem().toString()));
            //System.out.println(Integer.parseInt(cboPiso.getSelectedItem().toString()));
            numberMesasGroup = 0;
            BtnGroupVis();
            DPedido.dlmDP.removeAllElements();
            DPedido.nPisoPedido = Integer.parseInt(cboPiso.getSelectedItem().toString());
            BD_RS.numPiso = Integer.parseInt(cboPiso.getSelectedItem().toString());
            dlm = BD_RS.ListarMesasSelection(Integer.parseInt(cboPiso.getSelectedItem().toString()));
            dlmpedido = BD_RS.JoinPedido(Integer.parseInt(cboPiso.getSelectedItem().toString()));
            LoadMesas();            
        }        
    }//GEN-LAST:event_cboPisoActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        int i = JOptionPane.showOptionDialog(null,"¿Desea salir del Sistema?", "Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
        if(i==0) System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
            numberMesasGroup = 0;
            BtnGroupVis();
            DPedido.dlmDP.removeAllElements();
            DPedido.nPisoPedido = Integer.parseInt(cboPiso.getSelectedItem().toString());
            BD_RS.numPiso = Integer.parseInt(cboPiso.getSelectedItem().toString());
            dlm = BD_RS.ListarMesasSelection(Integer.parseInt(cboPiso.getSelectedItem().toString()));
            dlmpedido = BD_RS.JoinPedido(Integer.parseInt(cboPiso.getSelectedItem().toString()));
            LoadMesas();            
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        if(DPedido.dlmDP.size() != 0){
                if(BD_RS.EstadoApeCaja() == 0){
                    JOptionPane.showMessageDialog(null, "La caja aún no ha sido aperturada ","Aviso",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
               if(BD_RS.EstadoCierreCaja()==0){
                DPedido.nPedido = 0;
             //llamar al formulario
                /*for(int i = 0; i < DPedido.dlmDP.size(); i++){
                    
                }*/
                frmPedido frmPed = new frmPedido();
                this.setVisible(false);
                frmPed.setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null, "La caja está cerrada o falta aperturar","Aviso",JOptionPane.INFORMATION_MESSAGE);
               }
           }
    }//GEN-LAST:event_jLabel19MouseClicked
    /*
     jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
    */
    //System.out.println(evt.getStateChange() + " == " + ItemEvent.SELECTED);
    /**
     * @param args the command line arguments
     */
    private void HoraL(){
        SimpleDateFormat hFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyy");
        javax.swing.Timer timer = new javax.swing.Timer (1000, new ActionListener () 
        { 
            public void actionPerformed(ActionEvent e) 
            {   
                String hora = hFormat.format(Time.valueOf(LocalTime.now())).toString();
                String fecha = dFormat.format(Date.valueOf(LocalDate.now())).toString();
                FH.setText(fecha + " - " + hora);
             }
        }); 
        timer.start();
        
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mesas_Selection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mesas_Selection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mesas_Selection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mesas_Selection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mesas_Selection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FH;
    private javax.swing.JComboBox<String> cboPiso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSuc;
    // End of variables declaration//GEN-END:variables
}
