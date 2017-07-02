
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
import ventas.modelo.Area;
import ventas.modelo.Cargo;

public class BD_RS {
    public static DefaultTableModel FormatearTablaTrabajador(){
        DefaultTableModel dtm = new DefaultTableModel();
        String [] cab = {"Código", "DNI", "Nombre", "Apellido Paterno", "Apellido Materno", "Ingreso Laboral", "Cargo", "Estado"};
        dtm.setColumnIdentifiers(cab);
        return dtm;
    }
    public static DefaultTableModel FormatearTablaUsuario(){
        DefaultTableModel dtm = new DefaultTableModel();
        String [] cab = {"Id","Usuario","Contraseña","Código de Trabajador","Rol","Estado"};
        dtm.setColumnIdentifiers(cab);
        return dtm;
    }
    public static DefaultTableModel FormatearTablaCargos(){
        DefaultTableModel dtm = new DefaultTableModel();
        String [] cab = {"Id","Detalle del Cargo","Área","Fecha de Creación","Estado"};
        dtm.setColumnIdentifiers(cab);
        return dtm;
    }
    public static DefaultTableModel FormatearTablaAreas(){
        DefaultTableModel dtm = new DefaultTableModel();
        String [] cab = {"Id","Área","Fecha de Creación","Estado"};
        dtm.setColumnIdentifiers(cab);
        return dtm;
    }
    public static DefaultComboBoxModel ListarCBOTrabajador(){
        DefaultComboBoxModel CBOT = new DefaultComboBoxModel();
        try {
            String sql = "SELECT co_trabajador, no_ape_paterno,no_ape_materno,no_natural from mae_trabajador";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CBOT.addElement(rs.getString(1) + "   " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
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
    public static DefaultComboBoxModel ListarCBOAreas(){
        DefaultComboBoxModel CBOT = new DefaultComboBoxModel();
        try {
            String sql = "SELECT no_area from mae_area";
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
    public static DefaultTableModel ListarAreas(){
        try {
            DefaultTableModel dtm = FormatearTablaAreas();
            String sql = "SELECT A.NID_AREA, A.NO_AREA,A.fe_creacion, E.NO_ESTADO  FROM MAE_AREA A INNER JOIN mae_estado E ON E.nid_estado = A.nid_estado";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getDate(3));
                v.add(rs.getString(4));
                dtm.addRow(v);
            }
            return dtm;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static DefaultTableModel ListarCargos(){
        try {
            DefaultTableModel dtm = FormatearTablaCargos();
            String sql = "SELECT C.NID_CARGO, C.NO_CARGO, A.NO_AREA,A.FE_CREACION, E.NO_ESTADO FROM MAE_CARGO C INNER JOIN MAE_AREA A ON A.nid_area = C.nid_area " +
            "INNER JOIN MAE_ESTADO E ON E.nid_estado = C.nid_estado";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getDate(4));
                v.add(rs.getString(5));
                dtm.addRow(v);
            }
            return dtm;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static DefaultTableModel ListarTrabajador(){
        try {
            DefaultTableModel dtm = FormatearTablaTrabajador();
            String sql = "SELECT t.co_trabajador as Código,t.nu_documento as DNI,t.no_natural as Nombre,no_ape_paterno as 'Apellido Paterno',no_ape_materno as 'Apellido Materno',t.fe_ingreso_laboral as 'Ingreso Laboral',c.no_cargo as Cargo,e.no_estado as Estado from mae_trabajador t \n" +
                    "inner join mae_cargo c on c.nid_cargo = t.nid_cargo inner join mae_estado e on e.nid_estado = t.nid_estado "; //Where t.nid_estado = 1
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
    public static DefaultTableModel ListarUsuarios(){
        try {
            DefaultTableModel dtm = FormatearTablaUsuario();
            String sql = "select u.nid_usuario, u.no_usuario,u.no_clave, t.co_trabajador,p.no_perfil, e.no_estado from mae_usuario u inner join " +
                         " mae_estado e on e.nid_estado = u.nid_estado inner join mae_trabajador t on t.nid_trabajador = u.nid_trabajador " +
                         " inner join mae_perfil p on p.nid_perfil = u.nid_perfil"; //Where u.nid_estado = 1
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                dtm.addRow(v);
            }
            return dtm;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static boolean CTrabajador(Trabajador trabajador, int tipo){
        //sp_trabajador(in codT varchar(5),in dni varchar(20),in nombre varchar(50),in ape_pat varchar(50),in ape_mat varchar(50),in fe_ingreso date,in cargo int,in estado int,in fec_crecion date,in fec_mod date,in tipo int) 
        String sp = "Call sp_trabajador(?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
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
    public static boolean CUsuario(Usuario usuario, int tipo){
        
        String sp = "Call sp_usuario(?,?,?,?,?,?,?)";
        try {
            CallableStatement cs = BDUtil.getCnn().prepareCall(sp);
            cs.setInt(1, usuario.getId());
            cs.setString(2,usuario.getUser());
            cs.setString(3,usuario.getPssEnc());
            cs.setInt(4,usuario.getEstado());
            cs.setInt(5,usuario.getCodT());
            cs.setInt(6, usuario.getRol());
            cs.setInt(7,tipo);
            cs.executeQuery();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        
    }
    public static boolean CArea(Area area, int tipo){
        
        String sp = "Call sp_Area(?,?,?,?,?,?)";
        try {
            CallableStatement cs = BDUtil.getCnn().prepareCall(sp);
            cs.setInt(1, area.getId());
            cs.setString(2, area.getNombre());
            cs.setInt(3, area.getEstado());
            cs.setObject(4, area.getFe_creacion());
            cs.setObject(5, area.getFe_mod());
            cs.setInt(6,tipo);
            
            cs.executeQuery();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        
    }
    public static boolean CCargo(Cargo cargo, int tipo){
        
        String sp = "Call sp_Cargo(?,?,?,?,?,?,?)";
        try {
            CallableStatement cs = BDUtil.getCnn().prepareCall(sp);
            cs.setInt(1, cargo.getId());
            cs.setString(2, cargo.getNombre());
            cs.setInt(3, cargo.getArea());
            cs.setInt(4, cargo.getEstado());
            cs.setObject(5, cargo.getFe_creacion());
            cs.setObject(6, cargo.getFe_mod());
            cs.setInt(7,tipo);
            
            cs.executeQuery();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        
    }
    public void FilterUser(String user){
        
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
    public static int CodArea(){
        try {
            String sql = "SELECT count(*) FROM mae_area";
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
    public static int GetIdRol(String c){
        try {
            String sql = "SELECT nid_perfil FROM mae_perfil where no_perfil = ?";
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
    public static int GetIdTrab(String c){
        try {
            String sql = "SELECT nid_trabajador FROM mae_trabajador where co_trabajador = ?";
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
    public static int GetIdArea(String a){
        try {
            String sql = "SELECT nid_area FROM mae_area where no_area = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setString(1, a);
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
    public static String GetCodTrab(int id){
        try {
            String sql = "SELECT co_trabajador FROM mae_trabajador where nid_trabajador = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static boolean ExistTrabAcc(int id){
        try {
            String sql = "SELECT 1 FROM mae_usuario where nid_trabajador = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     public static boolean ExistUser(String user){
        try {
            String sql = "SELECT 1 FROM mae_usuario where no_usuario = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     public static boolean ExistArea(String area){
        try {
            String sql = "SELECT 1 FROM mae_area where no_area = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setString(1, area);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }public static boolean ExistCargo(String cargo){
        try {
            String sql = "SELECT 1 FROM mae_cargo where no_cargo = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setString(1, cargo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static DefaultTableModel CUsuarioFiltro(String user){
       DefaultTableModel dtm = FormatearTablaUsuario();
       try {
           
            String sqlcmd = "CALL USP_USER_FILTRO(?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sqlcmd);
            cs.setString(1,user + "%" );
            ResultSet rs =  cs.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                dtm.addRow(v);
            }
            return dtm;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return dtm;
        }
    }
    /*
    while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getDate(4));
                v.add(rs.getString(5));
                dtm.addRow(v);
            }
            return dtm;
    */
    public static DefaultTableModel CTrabajadorFiltro(String tr, int tbl){
       DefaultTableModel dtm = FormatearTablaTrabajador();
       try {
            
            String sqlcmd = "CALL USP_TRABAJADOR_FILTRO(?,?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sqlcmd);
            cs.setString(1, tr + "%");
            cs.setInt(2, tbl);
            
            ResultSet rs =  cs.executeQuery();
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
            System.err.println(ex);
            return dtm;
        }
    }
    public static DefaultTableModel CCargoFiltro(String tr){
       DefaultTableModel dtm = FormatearTablaCargos();
       try {
            
            String sqlcmd = "CALL USP_CARGO_FILTRO(?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sqlcmd);
            cs.setString(1, tr + "%");
            
            ResultSet rs =  cs.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getDate(4));
                v.add(rs.getString(5));
                dtm.addRow(v);
            }
            return dtm;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
            return dtm;
        }
    }
    public static DefaultTableModel CAreasFiltro(String tr){
       DefaultTableModel dtm = FormatearTablaAreas();
       try {
            
            String sqlcmd = "CALL USP_AREA_FILTRO(?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sqlcmd);
            cs.setString(1, tr + "%");
            
            ResultSet rs =  cs.executeQuery();
             while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getDate(3));
                v.add(rs.getString(4));
                dtm.addRow(v);
            }
            return dtm;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
            return dtm;
        }
    }
    public static DefaultComboBoxModel ListarCBOPisos(){
        DefaultComboBoxModel CBOT = new DefaultComboBoxModel();
        try {
            String sql = "SELECT nu_piso from mae_piso";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CBOT.addElement(rs.getInt(1));
            }
            
            return CBOT;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
            return null;
        }
        
    }
}
