
package ventas.presentacion.Plato;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import ventas.modelo.Plato;

public class Archivo extends javax.swing.JFrame {
    public jpEditarPlato jpE;
    public jpNuevoPlato jp;
    public String name;
    public int nroFrm;
    public static String rutaIMG;
    public Archivo() {
        initComponents();
    }
    public Archivo(jpEditarPlato f1) {
        jpE = f1;
        initComponents();
    }
    public Archivo(jpNuevoPlato f2) {
        jp = f2;
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgChooser = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();

        javax.swing.GroupLayout dlgChooserLayout = new javax.swing.GroupLayout(dlgChooser.getContentPane());
        dlgChooser.getContentPane().setLayout(dlgChooserLayout);
        dlgChooserLayout.setHorizontalGroup(
            dlgChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        dlgChooserLayout.setVerticalGroup(
            dlgChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   /* private String cadena(String temp){
        return temp.replaceAll("\, "\\");
    }*/
    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        JFileChooser selector = (JFileChooser)evt.getSource();        
        String command = evt.getActionCommand();              
        File tempfile=new File(Plato.nid_plato+".jpg");
             
            try {
                if (tempfile.exists()) {   
                    tempfile.delete();
                    setVisible(false);
                }                
                if(command.equals(JFileChooser.APPROVE_SELECTION)){ 
                    File archivoseleccionado=selector.getSelectedFile();
                    String tempRoad="C:\\sisVentasRes\\sgr\\src\\recursos";                                
                    Path finalRoad=Paths.get(tempRoad);
                    Path finalOrgin=Paths.get(archivoseleccionado.getAbsolutePath());
                    Files.move(finalOrgin, finalRoad.resolve(Plato.nid_plato+".jpg"), StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(rootPane, "Imagen ha sido subida con éxito.");
                    if (nroFrm==2) {
                        rutaIMG = Plato.nid_plato+".jpg";
                        
                       jpE.imgPlato(Plato.nid_plato+".jpg");
                    }else{
                        rutaIMG = Plato.nid_plato+".jpg";
                        jp.imgPlato(Plato.nid_plato+".jpg");
                    }                        
                    setVisible(false);
                }else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
                    setVisible(false);
                }                
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }        
    }//GEN-LAST:event_jFileChooser1ActionPerformed

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
            java.util.logging.Logger.getLogger(Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Archivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog dlgChooser;
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
}
