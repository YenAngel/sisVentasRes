
package ventas.persistencia.util;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ventas.persistencia.util.BDUtil;
import ventas.presentacion.frmPrincipal;
import ventas.presentacion.jpMesa;

public class BDData {
    public static int user(String sucursal, String user, String password){
        int idCredential=0;        
        String sql="SELECT us.nid_perfil "+
                "FROM mae_usuario us " +
                "INNER JOIN mae_perfil rol " +
                "ON rol.nid_perfil=us.nid_perfil " +
                "WHERE us.no_usuario=? AND us.no_clave=?";
        try{
            PreparedStatement ps;
            ps= BDUtil.getCnn().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                idCredential=rs.getInt(1);
                System.out.println(idCredential);
                return idCredential;
            }else   
                return idCredential;
        }catch (SQLException ex) {
            System.out.println(ex.toString());
            return idCredential;
        }        
    }        
    
    public static DefaultTableModel listarMesa( DefaultTableModel dtm){
        String sql="SELECT m.nid_mesa,m.nu_mesa, m.qt_silla, m.co_tipo_mesa, p.nu_piso, m.nid_estado " +
                "FROM mae_mesa m INNER JOIN mae_piso p ON p.nid_piso=m.nid_piso WHERE m.nid_estado=1";
        try {
            PreparedStatement ps=BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();            
            while (rs.next()) {                
                Vector v=new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getInt(2));
                v.add(rs.getInt(3));                
                v.add(rs.getString(4));
                v.add(rs.getInt(5));
                if (rs.getInt(6)==1) {
                    v.add("Activo");
                }else
                    v.add("Inactivado");
                dtm.addRow(v);
            }
            return dtm;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
