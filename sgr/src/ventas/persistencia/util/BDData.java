
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
import ventas.modelo.Piso;
import ventas.modelo.Login_User;
import ventas.persistencia.util.BDUtil;
import ventas.presentacion.frmPrincipal;
import ventas.presentacion.Mesa.jpListarMesa;

public class BDData {
    public static ResultSet user(Login_User usuario){        
        String sql="Call sgr_sps_usuario(?,?)";                
        try{
            CallableStatement cs= BDUtil.getCnn().prepareCall(sql);
            cs.setString(1, usuario.getNo_usuario());
            cs.setString(2, usuario.getNo_clave());              
            ResultSet rs=cs.executeQuery();            
            return rs;
        }catch (SQLException ex) {
            System.out.println(ex.toString());   
            return null;
        }        
    }            
    public static DefaultTableModel listarMesa( DefaultTableModel dtm){
        String sql="SELECT * FROM sgr_listarMesa";
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
            System.out.println(empresa.getNid_empresa());
            cs.setString(2,empresa.getNo_razon_social());
            cs.setString(3,empresa.getNo_comercial());
            cs.setString(4,empresa.getNu_ruc());
            cs.setInt(5, getNid_estado);
            cs.setInt(6,empresa.getNid_usuario_modi());
            System.out.println(empresa.getNid_usuario_modi());
            cs.executeUpdate();
            return true;   
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean eliminarEmpresa(Empresa empresa){        
        String sql="Call sgr_spd_empresa(?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,empresa.getNid_empresa());
            //cs.setInt(2,empresa.getNid_usuario_modi());
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
    public static boolean editarLocal(Local local){        
        String sql="Call sgr_spu_local(?,?,?,?,?,?)";
        int getNid_estado=local.getNo_estado().equals("Activo")?1:2;
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,local.getNid_local());
            cs.setString(2,local.getNo_local());
            cs.setString(3,local.getTx_direccion());
            cs.setString(4,local.getNo_empresa());
            cs.setInt(5, getNid_estado);
            cs.setInt(6,local.getNid_usuario_modi());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean eliminarLocal(Local local){        
        String sql="Call sgr_spd_local(?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,local.getNid_local());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static DefaultTableModel listarPiso(DefaultTableModel dtm){
        String sql="SELECT * FROM sgr_listarPiso";
        try {
            PreparedStatement ps =BDUtil.getCnn().prepareStatement(sql);            
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getInt(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));                
                dtm.addRow(v);
            }
            return dtm;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static boolean nuevoPiso(Piso piso){        
        String sql="Call sgr_spi_piso(?,?,?,?)";
        int getNid_estado=piso.getNo_estado().equals("Activo")?1:2;
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,piso.getNu_piso());
            cs.setString(2,piso.getNo_local());
            cs.setInt(3,getNid_estado);
            cs.setInt(4, piso.getNid_usuario_crea());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean editarPiso(Piso piso){        
        String sql="Call sgr_spu_piso(?,?,?,?,?)";
        int getNid_estado=piso.getNo_estado().equals("Activo")?1:2;
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,piso.getNid_piso());
            cs.setInt(2,piso.getNu_piso());
            cs.setString(3,piso.getNo_local());          
            cs.setInt(4, getNid_estado);
            cs.setInt(5,piso.getNid_usuario_modi());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean eliminarPiso(Piso piso){        
        String sql="Call sgr_spd_piso(?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,piso.getNid_piso());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
}
