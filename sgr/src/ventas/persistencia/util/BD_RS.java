
package ventas.persistencia.util;


import java.sql.CallableStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class BD_RS {
    public static DefaultTableModel FormatearTabla(){
        DefaultTableModel dtm = new DefaultTableModel();
        String [] cab = {"Código", "DNI", "Nombre", "Apellido Paterno", "Apellido Materno", "Ingreso Laboral", "Cargo", "Estado"};
        dtm.setColumnIdentifiers(cab);
        return dtm;
    }
    public static DefaultComboBoxModel ListarCBOTrabajador(){
        DefaultComboBoxModel CBOT = new DefaultComboBoxModel();
        try {
            String sql = "SELECT no_ape_paterno,no_ape_materno,no_natural from mae_trabajador";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CBOT.addElement(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            
            return CBOT;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
            return null;
        }
        
    }
    public static DefaultComboBoxModel ListarCBOCargo(){
        DefaultComboBoxModel CBOT = new DefaultComboBoxModel();
        try {
            String sql = "SELECT no_cargo from mae_cargo";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CBOT.addElement(rs.getString(1));
            }
            
            return CBOT;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
            return null;
        }
        
    }
    public static DefaultComboBoxModel ListarCBOEstado(){
        DefaultComboBoxModel CBOT = new DefaultComboBoxModel();
        try {
            String sql = "SELECT no_estado from mae_estado";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CBOT.addElement(rs.getString(1));
            }
            
            return CBOT;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
            return null;
        }
        
    }
    public static DefaultComboBoxModel ListarCBORoles(){
        DefaultComboBoxModel CBOT = new DefaultComboBoxModel();
        try {
            String sql = "SELECT no_perfil from mae_perfil";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CBOT.addElement(rs.getString(1));
            }
            
            return CBOT;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
            return null;
        }
        
    }
    public static DefaultTableModel ListarTrabajador(){
        try {
            DefaultTableModel dtm = FormatearTabla();
            String sql = "SELECT t.co_trabajador as Código,t.nu_documento as DNI,t.no_natural as Nombre,no_ape_paterno as 'Apellido Paterno',no_ape_materno as 'Apellido Materno',t.fe_ingreso_laboral as 'Ingreso Laboral',c.no_cargo as Cargo,e.no_estado as Estado from mae_trabajador t \n" +
                    "inner join mae_cargo c on c.nid_cargo = t.nid_cargo inner join mae_estado e on e.nid_estado = t.nid_estado Where t.nid_estado = 1";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getDate(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                dtm.addRow(v);
            }
            return dtm;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static boolean CTrabajador(Trabajador trabajador, int tipo){
        //sp_trabajador(in codT varchar(5),in dni varchar(20),in nombre varchar(50),in ape_pat varchar(50),in ape_mat varchar(50),in fe_ingreso date,in cargo int,in estado int,in fec_crecion date,in fec_mod date,in tipo int) 
        String sp = "Call sp_trabajador(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            /*System.out.println(trabajador.getCodigo());
            System.out.println(trabajador.getDni());
            System.out.println(trabajador.getNombre());
            System.out.println(trabajador.getApePaterno());
            System.out.println(trabajador.getApeMaterno());
            System.out.println(trabajador.getFec_ingreso());
            System.out.println(trabajador.getCargo());
            System.out.println(trabajador.getEstado());
            System.out.println(trabajador.getFec_creacion());
            System.out.println(trabajador.getFec_mod());*/
            CallableStatement cs = BDUtil.getCnn().prepareCall(sp);
            cs.setString(1,trabajador.getCodigo());
            cs.setString(2,trabajador.getDni());
            cs.setString(3,trabajador.getNombre());
            cs.setString(4,trabajador.getApePaterno());
            cs.setString(5,trabajador.getApeMaterno());
            cs.setObject(6,trabajador.getFec_ingreso());
            cs.setInt(7,trabajador.getCargo());
            cs.setInt(8, trabajador.getEstado());
            cs.setObject(9, trabajador.getFec_creacion());
            cs.setObject(10, trabajador.getFec_mod());
            cs.setInt(11, tipo);
            cs.executeQuery();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        
    }
    public static boolean CUsuario(Trabajador trabajador, int tipo){
        
        String sp = "Call sp_usuario(?,?,?,?,?,?)";
        try {
            CallableStatement cs = BDUtil.getCnn().prepareCall(sp);
            cs.setString(1,trabajador.getCodigo());
            cs.setString(2,trabajador.getDni());
            cs.setString(3,trabajador.getNombre());
            cs.setString(4,trabajador.getApePaterno());
            cs.setString(5,trabajador.getApeMaterno());
            cs.setObject(6, trabajador.getFec_ingreso());
            cs.setInt(7,trabajador.getCargo());
            cs.setInt(8, trabajador.getEstado());
            cs.setObject(9, trabajador.getFec_creacion());
            cs.setObject(10,  trabajador.getFec_mod());
            cs.setInt(11, tipo);
            cs.executeQuery();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        
    }
    public static int CodTrab(){
        try {
            String sql = "SELECT count(*) FROM mae_trabajador";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1) + 1;
            }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }
    public static int GetIdCargo(String c){
        try {
            String sql = "SELECT nid_cargo FROM mae_cargo where no_cargo = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setString(1, c);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    public static int GetIdEstado(String c){
        try {
            String sql = "SELECT nid_estado FROM mae_estado where no_estado = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setString(1, c);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
