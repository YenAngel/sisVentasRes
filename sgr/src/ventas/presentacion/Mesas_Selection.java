
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
        btnGroupM.setVisible(false);
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
        String div = String.valueOf(Double.parseDouble(mesas/3+""));
        int cant3 = Integer.parseInt(div.substring(0,div.indexOf('.')));
        //System.out.println(cant4);
        int panelaum = 20;
        int x = 40,y = 20;
        int cont = 1;
        for (int i =0; i<cant3; i++){
            x = 75;
            a = 1;
            while (a <= 3){
            JPanel jp = new JPanel();
            JLabel jl = new JLabel();
            JLabel jlIMGChair = new JLabel();
            JLabel jlTextNChair = new JLabel();
            JCheckBox jc = new JCheckBox();
            JLabel jlIMG = new JLabel();
            String cad = dlm.getElementAt(cont-1).toString();
            int nmesa  = Integer.parseInt(cad.substring(0,cad.indexOf('#')));
            jp.setLayout(null);
            jp.setBounds(x, y, 250 , 175);
            jl.setText(nmesa+"");
            jl.setFont(new Font("Arial Black", 1, 36));
            jl.setForeground(Color.WHITE);
            jl.setBounds(20, 10, 60, 52);
            jc.setBounds(223, 7, 21, 21);
            
            jc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jc(evt);
            }
        });
            jlIMGChair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/chair.png")));
            jlIMGChair.setBounds(20, 146, 24, 24);
            jlTextNChair.setText(cad.substring(cad.indexOf('#')+1,cad.length())+"");
            jlTextNChair.setFont(new Font("Arial Black", 1, 12));
            jlTextNChair.setForeground(Color.WHITE);
            jlTextNChair.setBounds(45, 146, 30, 24);
            jlIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logo4_min.png")));
            jlIMG.setBounds(60, 50, 140, 66);
            jp.add(jl);
            jp.add(jc);
            jp.add(jlIMG);
            jp.add(jlIMGChair);
            jp.add(jlTextNChair);
            jlIMG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               jlIMG(evt);     
                System.out.println("click1");
            }
        });
            a++;
            cont++;
            x+=300;
                if(JoinMesa(nmesa)){
                    //JOptionPane.showMessageDialog(rootPane,"JoinMesa: " + nmesa);
                    jlIMGChair.setBounds(20, 116, 24, 24);
                    jlTextNChair.setBounds(45, 116, 30, 24);
                    jp.setBackground(new Color(210, 42, 14));
                    JLabel jMozo = new JLabel();
                    JLabel jNPed = new JLabel();
                    JLabel imgMozo = new JLabel();
                    JLabel imgPed = new JLabel();
                    jMozo.setText(mozo);
                    jNPed.setText(numberPedido +"");
                    jMozo.setFont(new Font("Arial Black", 1, 11));
                    jMozo.setForeground(Color.WHITE);
                    jMozo.setBounds(50, 150, 175, 24);
                    jNPed.setFont(new Font("Arial Black", 1, 11));
                    jNPed.setForeground(Color.WHITE);
                    jNPed.setBounds(97, 116, 30, 24);
                    imgMozo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/waiter.png")));
                    imgMozo.setBounds(20, 146, 24, 24);
                    imgPed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/listped.png")));
                    imgPed.setBounds(70, 116, 24, 24);
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
            y+=215;
            panelaum+=225;
            jPanel2.setPreferredSize(new Dimension(980,panelaum));
        }
        if ((cant3*3) != mesas){
            x = 75;
            int res = mesas - cant3*3 ;
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
            jp.setBounds(x, y, 250 , 175);
            jl.setText(nmesa+"");
            jl.setFont(new Font("Arial Black", 1, 36));
            jl.setForeground(Color.WHITE);
            jl.setBounds(20, 10, 60, 52);
            jc.setBounds(223, 7, 21, 21);
            jlIMGChair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/chair.png")));
            jlIMGChair.setBounds(20, 146, 24, 24);
            jlTextNChair.setText(cad.substring(cad.indexOf('#')+1,cad.length())+"");
            jlTextNChair.setFont(new Font("Arial Black", 1, 12));
            jlTextNChair.setForeground(Color.WHITE);
            jlTextNChair.setBounds(45, 146, 30, 24);
            jlIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logo4_min.png")));
            jlIMG.setBounds(60, 50, 140, 66);
            jlIMG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               jlIMG(evt);
               System.out.println("click1");
            }
        });
            jp.add(jl);
            jp.add(jc);
            jp.add(jlIMG);
            jp.add(jlIMGChair);
            jp.add(jlTextNChair);
            
            vecesrun++;
            cont++;
            x+=300;
             if(JoinMesa(nmesa)){
                 //JOptionPane.showMessageDialog(rootPane,"JoinMesa: " + nmesa);
                    jlIMGChair.setBounds(20, 116, 24, 24);
                    jlTextNChair.setBounds(45, 116, 30, 24);
                    jp.setBackground(new Color(210, 42, 14)); //Color Red
                    JLabel jMozo = new JLabel();
                    JLabel jNPed = new JLabel();
                    JLabel imgMozo = new JLabel();
                    JLabel imgPed = new JLabel();
                    jMozo.setText(mozo);
                    jNPed.setText(numberPedido +"");
                    jMozo.setFont(new Font("Arial Black", 1, 11));
                    jMozo.setForeground(Color.WHITE);
                    jMozo.setBounds(50, 150, 175, 24);
                    jNPed.setFont(new Font("Arial Black", 1, 11));
                    jNPed.setForeground(Color.WHITE);
                    jNPed.setBounds(97, 116, 30, 24);
                    imgMozo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/waiter.png")));
                    imgMozo.setBounds(20, 146, 24, 24);
                    imgPed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/listped.png")));
                    imgPed.setBounds(70, 116, 24, 24);
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
            y+=215;
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
        }else{
            DPedido.nPedido = 0;
        }
        if(BD_RS.EstadoCaja()==1){
        DPedido.dlmDP.addElement(nMesa);
        // llamar al formulario pedido
        frmPedido frmPed = new frmPedido();
           this.setVisible(false);
           frmPed.setVisible(true);
        //frmCaja c=new frmCaja();
        //c.getMesa(evt);
        }else{
            JOptionPane.showMessageDialog(null, "La caja está cerrada o falta aperturar","Aviso",JOptionPane.INFORMATION_MESSAGE);
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

        jLabel16 = new javax.swing.JLabel();
        cboPiso = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        btnGroupM = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FH = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setText("Piso:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 47, -1, 38));

        cboPiso.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
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
        getContentPane().add(cboPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 46, 211, 46));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1328, 588));

        jPanel2.setBackground(new java.awt.Color(240, 242, 220));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel2.setPreferredSize(new java.awt.Dimension(980, 588));
        jPanel2.setLayout(null);
        jScrollPane1.setViewportView(jPanel2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1005, 530));

        btnGroupM.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGroupM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/clipboard.png"))); // NOI18N
        btnGroupM.setText("NUEVO PEDIDO");
        btnGroupM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGroupMActionPerformed(evt);
            }
        });
        getContentPane().add(btnGroupM, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 650, 170, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/leyenda2.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 370, 53));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/DateTime.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 50, 50));

        FH.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        FH.setForeground(new java.awt.Color(18, 133, 43));
        FH.setText("#FH");
        getContentPane().add(FH, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, -1, 38));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logout.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, 30, -1));

        jLabel43.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel43.setText("Salir");
        getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 70, 40, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void BtnGroupVis(){
        if(numberMesasGroup != 0){
            btnGroupM.setVisible(true);
        }else{
            btnGroupM.setVisible(false);
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
            frmCaja c=new frmCaja();
            c.getpiso(Integer.parseInt(cboPiso.getSelectedItem().toString()));
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

    private void btnGroupMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGroupMActionPerformed
           if(DPedido.dlmDP.size() != 0){
               if(BD_RS.EstadoCaja()==1){
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
    }//GEN-LAST:event_btnGroupMActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        int i = JOptionPane.showOptionDialog(null,"¿Desea salir del Sistema?", "Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
        if(i==0) System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked
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
                FH.setText(fecha + "  -  " + hora);
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
    private javax.swing.JButton btnGroupM;
    private javax.swing.JComboBox<String> cboPiso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
