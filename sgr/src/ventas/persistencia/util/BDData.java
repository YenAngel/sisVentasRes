
package ventas.persistencia.util;

import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Empresa;
import ventas.modelo.Local;
import ventas.modelo.Usuario;
import ventas.persistencia.util.BDUtil;
import ventas.presentacion.frmPrincipal;
import ventas.presentacion.Mesa.jpListarMesa;

public class BDData {

    public static int user(String sucursal, String user, String password) throws Exception{
        int idCredential=0;        
        String sql="SELECT us.nid_perfil "+
                "FROM mae_usuario us " +
                "INNER JOIN mae_perfil rol " +
                "ON rol.nid_perfil=us.nid_perfil " +
                "WHERE us.no_usuario=? AND us.no_clave=?";
        
            PreparedStatement ps;
            ps= BDUtil.getCnn().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, EN_DES.Encrypt_S(password));
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                idCredential=rs.getInt(1);
                System.out.println(idCredential);
                return idCredential;
            }else   
                return idCredential;}

    public static ResultSet user(Usuario usuario) throws Exception{
        String sql="Call sgr_sps_usuario(?,?)";                
        try{
            CallableStatement cs= BDUtil.getCnn().prepareCall(sql);
            cs.setString(1, usuario.getNo_usuario());
            cs.setString(2, EN_DES.Encrypt_S(usuario.getNo_clave()));            
            ResultSet rs=cs.executeQuery();            
            return rs;

        }catch (SQLException ex) {
            System.out.println(ex.toString());   
            return null;
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
    public static DefaultComboBoxModel getEmpresa(){
       DefaultComboBoxModel dcbm = new  DefaultComboBoxModel();
        String sql="select * from sgr_getEmpresa";
        try {
            PreparedStatement ps=BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                dcbm.addElement(rs.getString(1));
            }
            return dcbm;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }        
    }
    public static boolean nuevaMesa(int mesa, int silla, String tipo, int piso, int user){
        String sql="Call sgr_spi_addmesa(?,?,?,?,?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,mesa);
            cs.setInt(2,silla);
            cs.setString(3,tipo);
            cs.setInt(4,piso);
            cs.setInt(5,user);
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static DefaultTableModel listarEmpresa(DefaultTableModel dtm){
        String sql="SELECT * FROM sgr_listarEmpresa";
        try {
            PreparedStatement ps =BDUtil.getCnn().prepareStatement(sql);            
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                dtm.addRow(v);
            }
            return dtm;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static boolean nuevaEmpresa(Empresa empresa){        
        String sql="Call sgr_spi_empresa(?,?,?,?,?)";
        int getNid_estado=empresa.getNo_estado().equals("Activo")?1:2;
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setString(1,empresa.getNo_razon_social());
            cs.setString(2,empresa.getNo_comercial());
            cs.setString(3,empresa.getNu_ruc());
            cs.setInt(4, getNid_estado);
            cs.setInt(5,empresa.getNid_usuario_crea());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean editarEmpresa(Empresa empresa){        
        String sql="Call sgr_spu_empresa(?,?,?,?,?,?)";
        int getNid_estado=empresa.getNo_estado().equals("Activo")?1:2;
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,empresa.getNid_empresa());
            cs.setString(2,empresa.getNo_razon_social());
            cs.setString(3,empresa.getNo_comercial());
            cs.setString(4,empresa.getNu_ruc());
            cs.setInt(5, getNid_estado);
            cs.setInt(6,empresa.getNid_usuario_modi());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean eliminarEmpresa(Empresa empresa){        
        String sql="Call sgr_spd_empresa(?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,empresa.getNid_empresa());
            cs.setInt(2,empresa.getNid_usuario_modi());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static DefaultTableModel listarLocal(DefaultTableModel dtm){
        String sql="SELECT * FROM sgr_listarLocal";
        try {
            PreparedStatement ps =BDUtil.getCnn().prepareStatement(sql);            
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                dtm.addRow(v);
            }
            return dtm;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static boolean nuevoLocal(Local local){        
        String sql="Call sgr_spi_local(?,?,?,?,?)";
        int getNid_estado=local.getNo_estado().equals("Activo")?1:2;
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setString(1,local.getNo_local());
            cs.setString(2,local.getTx_direccion());
            cs.setString(3,local.getNo_empresa());
            cs.setInt(4, getNid_estado);
            cs.setInt(5,local.getNid_usuario_crea());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    /*public static boolean editarLocal(Local empresa){        
        String sql="Call sgr_spu_empresa(?,?,?,?,?,?)";
        int getNid_estado=empresa.getNo_estado().equals("Activo")?1:2;
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,empresa.getNid_empresa());
            cs.setString(2,empresa.getNo_razon_social());
            cs.setString(3,empresa.getNo_comercial());
            cs.setString(4,empresa.getNu_ruc());
            cs.setInt(5, getNid_estado);
            cs.setInt(6,empresa.getNid_usuario_modi());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean eliminarLocal(Local empresa){        
        String sql="Call sgr_spd_empresa(?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,empresa.getNid_empresa());
            cs.setInt(2,empresa.getNid_usuario_modi());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }*/
}
