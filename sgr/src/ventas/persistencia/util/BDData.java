
package ventas.persistencia.util;

import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Categoria;
import ventas.modelo.Cliente;
import ventas.modelo.Comprobante;
import ventas.modelo.Empresa;
import ventas.modelo.Local;
import ventas.modelo.Login_User;
import ventas.modelo.Mesa;
import ventas.modelo.Piso;
import ventas.modelo.Plato;
import ventas.modelo.PlatoLocal;
import ventas.persistencia.util.BDUtil;
import ventas.presentacion.frmPrincipal;
import ventas.presentacion.Mesa.jpListarMesa;

public class BDData {    
    public static ResultSet user(Login_User usuario) throws Exception{
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
                v.add(rs.getString(6));
                v.add(rs.getString(7));
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
    public static DefaultComboBoxModel getPiso_Local(String value){
        DefaultComboBoxModel dcbm =new DefaultComboBoxModel();
        String sql="call sgr_sps_getPiso(?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);                        
            cs.setString(1,value);            
            ResultSet rs =cs.executeQuery();
            while(rs.next()) {
                dcbm.addElement(rs.getString(1));                
            }
            return dcbm;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }            
    }
    public static boolean nuevaMesa(Mesa mesa){
        String sql="Call sgr_spi_mesa(?,?,?,?,?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);            
            cs.setInt(1,mesa.getNu_mesa());
            cs.setInt(2,mesa.getQt_silla());
            cs.setString(3,mesa.getCo_tipo_mesa());
            cs.setInt(4,mesa.getNu_piso());
            cs.setString(5, mesa.getNo_local());
            cs.setInt(6, mesa.getNid_usuario_crea());
            int rs=cs.executeUpdate();
            if (rs==0) {               
                JOptionPane.showMessageDialog(null, "Registro ya existe");
            } else
                JOptionPane.showMessageDialog(null, "Registro guardado");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean editarMesa(Mesa mesa){
        String sql="Call sgr_spu_mesa(?,?,?,?,?,?,?)";        
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);            
            cs.setInt(1,mesa.getNid_mesa());
            cs.setInt(2,mesa.getNu_mesa());
            cs.setInt(3,mesa.getQt_silla());
            cs.setString(4,mesa.getCo_tipo_mesa());
            cs.setInt(5,mesa.getNu_piso());
            cs.setString(6, mesa.getNo_local());
            cs.setInt(7, mesa.getNid_usuario_modi());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean eliminarMesa(Mesa mesa){
        String sql="Call sgr_spd_mesa(?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql); 
            cs.setInt(1, mesa.getNid_mesa());
            cs.setInt(2, mesa.getNid_usuario_modi());
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
                dtm.addRow(v);
            }
            return dtm;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static boolean nuevaEmpresa(Empresa empresa){        
        String sql="Call sgr_spi_empresa(?,?,?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setString(1,empresa.getNo_razon_social());
            cs.setString(2,empresa.getNo_comercial());
            cs.setString(3,empresa.getNu_ruc());
            cs.setInt(4,empresa.getNid_usuario_crea());
            int rs=cs.executeUpdate();
            if (rs==0) {               
                JOptionPane.showMessageDialog(null, "Registro ya existe");
            } else
                JOptionPane.showMessageDialog(null, "Registro guardado");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean editarEmpresa(Empresa empresa){        
        String sql="Call sgr_spu_empresa(?,?,?,?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,empresa.getNid_empresa());
            cs.setString(2,empresa.getNo_razon_social());
            cs.setString(3,empresa.getNo_comercial());
            cs.setString(4,empresa.getNu_ruc());
            cs.setInt(5,empresa.getNid_usuario_modi());
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
        String sql="Call sgr_spi_local(?,?,?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setString(1,local.getNo_local());
            cs.setString(2,local.getTx_direccion());
            cs.setString(3,local.getNo_empresa());
            cs.setInt(4,local.getNid_usuario_crea());
            int rs= cs.executeUpdate();
            if (rs==0) {               
                JOptionPane.showMessageDialog(null, "Registro ya existe");
            } else
                JOptionPane.showMessageDialog(null, "Registro guardado");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean editarLocal(Local local){        
        String sql="Call sgr_spu_local(?,?,?,?,?)";      
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,local.getNid_local());
            cs.setString(2,local.getNo_local());
            cs.setString(3,local.getTx_direccion());
            cs.setString(4,local.getNo_empresa());
            cs.setInt(5,local.getNid_usuario_modi());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean eliminarLocal(Local local){        
        String sql="Call sgr_spd_local(?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,local.getNid_local());
            cs.setInt(2, local.getNid_usuario_modi());
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
                v.add(rs.getString(2));
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
    public static DefaultComboBoxModel getLocal(){
       DefaultComboBoxModel dcbm = new  DefaultComboBoxModel();
        String sql="select * from sgr_getLocal";
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
    public static boolean nuevoPiso(Piso piso){        
        String sql="Call sgr_spi_piso(?,?,?)";
        //int getNid_estado=piso.getNo_estado().equals("Activo")?1:2;
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,piso.getNu_piso());
            cs.setString(2,piso.getNo_local());
            cs.setInt(3, piso.getNid_usuario_crea());
            int rs=cs.executeUpdate();
            if (rs==0) {               
                JOptionPane.showMessageDialog(null, "Registro ya existe");
            } else
                JOptionPane.showMessageDialog(null, "Registro guardado");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean editarPiso(Piso piso){        
        String sql="Call sgr_spu_piso(?,?,?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,piso.getNid_piso());
            cs.setInt(2,piso.getNu_piso());
            cs.setString(3,piso.getNo_local());          
            cs.setInt(4,piso.getNid_usuario_modi());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean eliminarPiso(Piso piso){        
        String sql="Call sgr_spd_piso(?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,piso.getNid_piso());
            cs.setInt(2,piso.getNid_usuario_modi());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }   
    public static DefaultTableModel listarCliente(DefaultTableModel dtm){
        String sql="SELECT * FROM sgr_listarCliente";
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
                v.add(rs.getString(6));  
                v.add(rs.getString(7));  
                dtm.addRow(v);
            }
            return dtm;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }    
    public static boolean nuevoCliente(Cliente cliente){        
        String sql="Call sgr_spi_cliente(?,?,?,?,?,?)";
        //int getNid_estado=piso.getNo_estado().equals("Activo")?1:2;
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setString(1,cliente.getNo_cliente());
            cs.setString(2, cliente.getNo_ape_paterno());
            cs.setString(3, cliente.getNo_ape_materno());
            cs.setString(4,cliente.getCo_tipo_documento());
            cs.setString(5,cliente.getNu_documento());            
            cs.setInt(6, cliente.getNid_usuario_crea());
            int rs=cs.executeUpdate();
            if (rs==0) {               
                JOptionPane.showMessageDialog(null, "Registro ya existe");
            } else
                JOptionPane.showMessageDialog(null, "Registro guardado");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean editarCliente(Cliente cliente){        
        String sql="Call sgr_spu_cliente(?,?,?,?,?,?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,cliente.getNid_cliente());
            cs.setString(2,cliente.getNo_cliente());
            cs.setString(3,cliente.getNo_ape_paterno());          
            cs.setString(4,cliente.getNo_ape_materno());
            cs.setString(5,cliente.getCo_tipo_documento());          
            cs.setString(6,cliente.getNu_documento());          
            cs.setInt(7,cliente.getNid_usuario_modi());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean eliminarCliente(Cliente cliente){        
        String sql="Call sgr_spd_cliente(?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,cliente.getNid_cliente());
            cs.setInt(2, cliente.getNid_usuario_modi());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }    
    public static DefaultTableModel listarCategoria(DefaultTableModel dtm, int idx){
        String sql="call sgr_sps_categoria(?)";
        try {
            CallableStatement cs =BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,idx);
            ResultSet rs =cs.executeQuery();
            while (rs.next()) {
                if (idx==3) {
                    Vector v = new Vector();
                    v.add(rs.getInt(1));
                    v.add(rs.getString(2));
                    v.add(rs.getString(3)); 
                    v.add(rs.getString(4));
                    dtm.addRow(v);
                }else if (idx==2) {                    
                    Vector v = new Vector();
                    v.add(rs.getInt(1));
                    v.add(rs.getString(2));
                    v.add(rs.getString(3));                 
                    dtm.addRow(v);
                }else if (idx==1) {                    
                    Vector v = new Vector();
                    v.add(rs.getInt(1));
                    v.add(rs.getString(2));
                    v.add(rs.getString(3));                 
                    dtm.addRow(v);
                }                
            }
            return dtm;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }   
    public static DefaultComboBoxModel getCliente(){
       DefaultComboBoxModel dcbm = new  DefaultComboBoxModel();
        String sql="select * from sgr_getCliente";
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
    public static DefaultComboBoxModel getCategoria1(){
       DefaultComboBoxModel dcbm = new  DefaultComboBoxModel();
        String sql="select * from sgr_getCategoria1";
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
    public static DefaultComboBoxModel getCategoria2(String categoria){
       DefaultComboBoxModel dcbm = new  DefaultComboBoxModel();
        String sql="call sgr_sps_categoria2(?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setString(1,categoria);
            ResultSet rs=cs.executeQuery();
            while (rs.next()) {                
                dcbm.addElement(rs.getString(1));
            }
            return dcbm;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }        
    }
    public static DefaultComboBoxModel getCategoria3(String categoria){
       DefaultComboBoxModel dcbm = new  DefaultComboBoxModel();
        String sql="call sgr_sps_categoria3(?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setString(1,categoria);
            ResultSet rs=cs.executeQuery();
            while (rs.next()) {                
                dcbm.addElement(rs.getString(1));
            }
            return dcbm;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }        
    }
    /*Por Eliminar*/
    public static DefaultComboBoxModel getCategoria(){
       DefaultComboBoxModel dcbm = new  DefaultComboBoxModel();
        String sql="select * from sgr_getCategoria";
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
    public static boolean nuevoCategoria(Categoria categoria){                        
        String sql;        
            sql="Call sgr_spi_categoria(?,?,?,?,?)"; 
        try {
                CallableStatement cs=BDUtil.getCnn().prepareCall(sql);                
                cs.setString(1, categoria.getNo_padre_categoria());                   
                cs.setInt(2, (categoria.getNu_nivel()));            
                cs.setString(3, categoria.getNo_categoria_plato());   
                cs.setInt(4, categoria.getNid_usuario_crea());   
                cs.setInt(5, categoria.getVi_tipo());
                int rs=cs.executeUpdate();                
                if (rs==0) {               
                JOptionPane.showMessageDialog(null, "Registro ya existe");
                } else
                JOptionPane.showMessageDialog(null, "Registro guardado");
                return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean editarCategoria(Categoria categoria){                          
        try {            
                String sql="Call sgr_spu_categoria(?,?,?,?,?,?)";
                CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
                cs.setInt(1,categoria.getNid_categoria_plato());
                cs.setString(2,categoria.getNo_padre_categoria());
                cs.setInt(3,(categoria.getNu_nivel()));          
                cs.setString(4,categoria.getNo_categoria_plato());                    
                cs.setInt(5,categoria.getNid_usuario_modi());
                cs.setInt(6, categoria.getVi_tipo());
                int rs=cs.executeUpdate();
                if (rs==1) {
                   JOptionPane.showMessageDialog(null, "Registro actualizado");
                }                
                return true;            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }          
    }
    public static boolean eliminarCategoria(Categoria categoria){        
        String sql="Call sgr_spd_categoria(?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,categoria.getNid_categoria_plato());
            cs.setInt(2, categoria.getNid_usuario_modi());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }     
    public static DefaultTableModel listarPlato(DefaultTableModel dtm){
        String sql="SELECT * FROM sgr_listarPlato";
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
                v.add(rs.getString(6));  
                dtm.addRow(v);
            }
            return dtm;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static DefaultComboBoxModel getCategories(){
       DefaultComboBoxModel dcbm = new  DefaultComboBoxModel();
        String sql="select * from sgr_getCategorias";
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
    public static boolean nuevoPlato(Plato plato){                        
        try {                        
            String sql="Call sgr_spi_plato(?,?,?,?,?)"; 
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setString(1, plato.getNo_plato());            
            cs.setString(2, plato.getNo_categoria1_plato());   
            cs.setString(3, plato.getNo_categoria2_plato());   
            cs.setString(4, plato.getNo_categoria3_plato());   
            cs.setInt(5, plato.getNid_usuario_crea());            
            int rs=cs.executeUpdate();
            if (rs==0) {               
                JOptionPane.showMessageDialog(null, "Registro ya existe");
            } else
                JOptionPane.showMessageDialog(null, "Registro guardado");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean editarPlato(Plato plato){                
        try {            
            String sql="Call sgr_spu_plato(?,?,?,?,?,?)";
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,plato.getNid_plato());
            cs.setString(2,plato.getNo_plato());
            cs.setString(3,plato.getNo_categoria1_plato());                      
            cs.setString(4,plato.getNo_categoria2_plato());                      
            cs.setString(5,plato.getNo_categoria3_plato());                                  
            cs.setInt(6,plato.getNid_usuario_modi());
            cs.executeUpdate();
            return true;            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }         
    }
    public static boolean eliminarPlato(Plato plato){        
        String sql="Call sgr_spd_plato(?,?)";
        try {
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,plato.getNid_plato());
            cs.setInt(2, plato.getNid_usuario_modi());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }       
    }        
    public static DefaultTableModel listarLocalPlato(DefaultTableModel dtm){
        String sql="SELECT * FROM sgr_listarPlatoLocal";
        try {
            PreparedStatement ps =BDUtil.getCnn().prepareStatement(sql);            
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getDouble(3));                
                v.add(rs.getString(4));                
                dtm.addRow(v);
            }
            return dtm;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }    
    public static DefaultComboBoxModel getPlato(){
       DefaultComboBoxModel dcbm = new  DefaultComboBoxModel();
        String sql="select * from sgr_getPlato";
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
    public static boolean nuevoPlatoLocal(PlatoLocal platoLocal){    
        int getVip=platoLocal.getFl_vip().equals("SI")?1:0;
        try {                        
            String sql="Call sgr_spi_precio(?,?,?,?,?)"; 
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setString(1, platoLocal.getNo_plato());            
            cs.setString(2, platoLocal.getNo_local());   
            cs.setDouble(3, platoLocal.getMt_precio());   
            cs.setInt(4, getVip);   
            cs.setInt(5, platoLocal.getNid_usuario_crea());            
            int rs=cs.executeUpdate();
            if (rs==0) {               
                JOptionPane.showMessageDialog(null, "Registro ya existe");
            } else
                JOptionPane.showMessageDialog(null, "Registro guardado");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean editarPlatoLocal(PlatoLocal platoLocal){                
        int getVip=platoLocal.getFl_vip().equals("SI")?1:0;
        try {            
            String sql="Call sgr_spu_precio(?,?,?,?,?)";
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setString(1,platoLocal.getNo_local());
            cs.setString(2,platoLocal.getNo_plato());
            cs.setDouble(3,platoLocal.getMt_precio());                      
            cs.setInt(4,getVip);                                      
            cs.setInt(5,platoLocal.getNid_usuario_modi());
            cs.executeUpdate();
            return true;            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }         
    }    
    public static DefaultTableModel listarComprobante(DefaultTableModel dtm){
        String sql="SELECT * FROM sgr_listarComprobante";
        try {
            PreparedStatement ps =BDUtil.getCnn().prepareStatement(sql);            
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
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
    public static boolean nuevoComprobante(Comprobante comprobante){    
        try {                        
            String sql="Call sgr_spi_comprobante(?,?,?,?,?)"; 
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setString(1, comprobante.getNo_local());   
            cs.setString(2, comprobante.getCo_comprobante());            
            cs.setString(3, comprobante.getNu_serie());   
            cs.setString(4, comprobante.getNu_correlativo());               
            cs.setInt(5, comprobante.getNid_usuario_crea());            
            int rs=cs.executeUpdate();
            if (rs==0) {               
                JOptionPane.showMessageDialog(null, "Registro ya existe");
            } else
                JOptionPane.showMessageDialog(null, "Registro guardado");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    public static boolean editarComprobante(Comprobante comprobante){                
        try {            
            String sql="Call sgr_spu_comprobante(?,?,?,?,?)";
            CallableStatement cs=BDUtil.getCnn().prepareCall(sql);
            cs.setString(1, comprobante.getNo_local());   
            cs.setString(2, comprobante.getCo_comprobante());            
            cs.setString(3, comprobante.getNu_serie());   
            cs.setString(4, comprobante.getNu_correlativo());               
            cs.setInt(5, comprobante.getNid_usuario_modi());       
            cs.executeUpdate();
            return true;            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }         
    }
    public static DefaultComboBoxModel obtenerPiso(){
        DefaultComboBoxModel dcbm=new DefaultComboBoxModel();
        try {
            String sql="select * from sgr_getPiso";
            PreparedStatement ps=BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                dcbm.addElement(rs.getInt(1));
            }
            return dcbm;
        } catch (Exception e) {
            System.out.println(e);
            return  null;
        }
    }
    public static DefaultTableModel obtenerMesa(DefaultTableModel dtm, Mesa mesa){
        try {
            String sql="call sgr_sps_getMesa(?,?,?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sql);
            cs.setString(1, mesa.getNo_local());   
            cs.setInt(2, mesa.getNu_mesa());   
            cs.setInt(3, mesa.getNu_piso());            
            ResultSet rs=cs.executeQuery();
            while (rs.next()) {                
             Vector v=new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getInt(2));
                v.add(rs.getInt(3));                
                v.add(rs.getString(4));
                v.add(rs.getInt(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                dtm.addRow(v);
            }
            return dtm;
        } catch (Exception e) {
            return null;
        }
    }
    public static DefaultTableModel obtenerComprobante(DefaultTableModel dtm, Comprobante comprobante){
        try {
            String sql="call sgr_sps_getComprobante(?,?,?,?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sql);            
            cs.setString(1, comprobante.getCo_comprobante());   
            cs.setString(2, comprobante.getNu_serie()); 
            cs.setString(3, comprobante.getNu_correlativo());
            cs.setString(4, comprobante.getNo_local());
            ResultSet rs=cs.executeQuery();
            while (rs.next()) {                
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));                
                v.add(rs.getString(4));                 
                dtm.addRow(v);
            }
            return dtm;
        } catch (Exception e) {
            return null;
        }
    }
    public static DefaultTableModel obtenerCategoria(DefaultTableModel dtm, Categoria categoria){
        try {
            String sql="call sgr_sps_getCategoria(?,?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sql); 
            cs.setString(1, categoria.getNo_categoria_plato());   
            cs.setInt(2, categoria.getVi_tipo());            
            int idx=categoria.getVi_tipo();
            ResultSet rs=cs.executeQuery();
            while (rs.next()) {
                if (idx==3) {
                    Vector v = new Vector();
                    v.add(rs.getInt(1));
                    v.add(rs.getString(2));
                    v.add(rs.getString(3)); 
                    v.add(rs.getString(4));
                    dtm.addRow(v);
                }else if (idx==2) {                    
                    Vector v = new Vector();
                    v.add(rs.getInt(1));
                    v.add(rs.getString(2));
                    v.add(rs.getString(3));                 
                    dtm.addRow(v);
                }else if (idx==1) {                    
                    Vector v = new Vector();
                    v.add(rs.getInt(1));
                    v.add(rs.getString(2));
                    v.add(rs.getString(3));                 
                    dtm.addRow(v);
                }                
            }
            return dtm;
        } catch (Exception e) {
            return null;
        }
    }
    public static DefaultTableModel obtenerCliente(DefaultTableModel dtm, Cliente cliente){
        try {
            String sql="call sgr_sps_getCliente(?,?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sql);
            cs.setString(1, cliente.getNo_cliente());   
            cs.setString(2, cliente.getNu_documento());            
            ResultSet rs=cs.executeQuery();
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));                
                v.add(rs.getString(5));  
                v.add(rs.getString(6));  
                v.add(rs.getString(7));  
                dtm.addRow(v);
            }
            return dtm;
        } catch (Exception e) {
            return null;
        }
    }
    public static DefaultTableModel obtenerEmpresa(DefaultTableModel dtm, Empresa empresa){
        try {
            String sql="call sgr_sps_getEmpresa(?,?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sql);
            cs.setString(1, empresa.getNo_comercial());   
            cs.setString(2, empresa.getNu_ruc());            
            ResultSet rs=cs.executeQuery();
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
            return null;
        }
    }
    public static DefaultTableModel obtenerLocal(DefaultTableModel dtm, Local local){
        try {
            String sql="call sgr_sps_getLocal(?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sql);
            cs.setString(1, local.getNo_local());   
            ResultSet rs=cs.executeQuery();
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
            return null;
        }
    }    
    public static DefaultTableModel obtenerPlato(DefaultTableModel dtm, Plato plato){
        try {
            String sql="call sgr_sps_getPlato(?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sql);
            cs.setString(1, plato.getNo_plato());   
            ResultSet rs=cs.executeQuery();
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));                
                v.add(rs.getString(5));                
                v.add(rs.getString(6));    
                dtm.addRow(v);
            }
            return dtm;
        } catch (Exception e) {
            return null;
        }
    }    
    public static DefaultTableModel obtenerPlatoLocal(DefaultTableModel dtm, PlatoLocal platoLocal){
        try {
            String sql="call sgr_sps_getPlatoLocal(?,?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sql);
            cs.setString(1, platoLocal.getNo_local());   
            cs.setString(2, platoLocal.getNo_plato());   
            ResultSet rs=cs.executeQuery();
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getDouble(3));                
                v.add(rs.getString(4));      
                dtm.addRow(v);
            }
            return dtm;
        } catch (Exception e) {
            return null;
        }
    }
    public static DefaultTableModel obtenerPisoFiltro(DefaultTableModel dtm, Piso piso){
        try {
            String sql="call sgr_sps_getPisoG(?,?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sql);
            cs.setString(1, piso.getNo_local());   
            cs.setInt(2, piso.getNu_piso());   
            ResultSet rs=cs.executeQuery();
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));  
                dtm.addRow(v);
            }
            return dtm;
        } catch (Exception e) {
            return null;
        }
    }       
}
