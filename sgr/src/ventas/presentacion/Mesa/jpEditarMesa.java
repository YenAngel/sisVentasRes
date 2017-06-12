
package ventas.presentacion.Mesa;

import ventas.presentacion.frmPrincipal;
import static ventas.presentacion.frmPrincipal.heightvar;
import static ventas.presentacion.frmPrincipal.nPanel;
import static ventas.presentacion.frmPrincipal.widthvar;

public class jpEditarMesa extends javax.swing.JPanel {
        
    public jpEditarMesa() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboNroPiso = new javax.swing.JComboBox<>();
        cboNroMesa = new javax.swing.JComboBox<>();
        cboTipoMesa = new javax.swing.JComboBox<>();
        txtCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 260, 50));

        jLabel1.setText("Codigo:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        lblEstado.setText("Estado:");
        add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 260, 50));

        jLabel3.setText("Nro Piso:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jLabel4.setText("Nro Mesa:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        jLabel5.setText("Tipo de Mesa:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        jLabel6.setText("Cantidad de Sillas:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        cboNroPiso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cboNroPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 260, 50));

        cboNroMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cboNroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 260, 50));

        cboTipoMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cboTipoMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 260, 50));
        add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 260, 50));

        jLabel7.setText("Estado:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Pen-icon.png")); // NOI18N
        jLabel8.setText("Editar de Mesa");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 260, 50));

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Home-icon.png")); // NOI18N
        jButton1.setText("Retornar");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 140, 60));

        jButton2.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Arrow-reload-2-icon.png")); // NOI18N
        jButton2.setText("Limpiar");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 140, 60));

        jButton3.setIcon(new javax.swing.ImageIcon("D:\\sisVentasRes\\sgr\\src\\recursos\\Check-icon.png")); // NOI18N
        jButton3.setText("Guardar");
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 140, 60));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> cboNroMesa;
    public javax.swing.JComboBox<String> cboNroPiso;
    public javax.swing.JComboBox<String> cboTipoMesa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JLabel lblEstado;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables

}
