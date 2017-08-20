
package ventas.persistencia.util;


import java.sql.CallableStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import ventas.modelo.Area;
import ventas.modelo.Cargo;
import ventas.modelo.DPedido;
import ventas.modelo.Local;

public class BD_RS {
    public static int idlocal;
    public static int idEmpresa;
    public static int numPiso;
    public static int idUserLog;
    public static int dniUserLog;
    public static int idCargoLog;
    public static DefaultTableModel FormatearTablaTrabajador(){
        DefaultTableModel dtm = new DefaultTableModel();
        String [] cab = {"Código", "Nombre", "Apellido Paterno", "Apellido Materno","DNI", "Ingreso Laboral", "Cargo"};
        dtm.setColumnIdentifiers(cab);
        return dtm;
    }
    public static DefaultTableModel FormatearTablaUsuario(){
        DefaultTableModel dtm = new DefaultTableModel();
        String [] cab = {"Id","Usuario","Contraseña","Código de Trabajador","Rol","Local"};
        dtm.setColumnIdentifiers(cab);
        return dtm;
    }
    public static DefaultTableModel FormatearTablaCargos(){
        DefaultTableModel dtm = new DefaultTableModel();
        String [] cab = {"Id","Detalle del Cargo","Área","Fecha de Creación"};
        dtm.setColumnIdentifiers(cab);
        return dtm;
    }
    public static DefaultTableModel FormatearTablaAreas(){
        DefaultTableModel dtm = new DefaultTableModel();
        String [] cab = {"Id","Área","Fecha de Creación"};
        dtm.setColumnIdentifiers(cab);
        return dtm;
    }
     public static DefaultTableModel FormatearTablaDetalleP(){
        DefaultTableModel dtm = new DefaultTableModel();
        String [] cab = {"Descripción","Cantidad","Precio","SubTotal","Obs","Estado","Envio"};
        dtm.setColumnIdentifiers(cab);
        return dtm;
    }
    public static DefaultComboBoxModel ListarCBOTrabajador(){
        DefaultComboBoxModel CBOT = new DefaultComboBoxModel();
        try {
            String sql = "SELECT co_trabajador, no_ape_paterno,no_ape_materno,no_natural from mae_trabajador where nid_estado = 1";
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
            String sql = "SELECT no_cargo from mae_cargo where nid_estado = 1";
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
            String sql = "SELECT no_area from mae_area where nid_estado = 1";
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
    public static DefaultComboBoxModel ListarCBOLocal(){
        DefaultComboBoxModel CBOT = new DefaultComboBoxModel();
        try {
            String sql = "SELECT no_local from mae_local where nid_estado = 1";
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
            String sql = "SELECT a.nid_area, a.no_area,a.fe_creacion FROM mae_area a INNER JOIN mae_estado e ON e.nid_estado = a.nid_estado where a.nid_estado = 1 order by 1 desc";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getDate(3));
                
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
            String sql = "SELECT c.nid_cargo, c.no_cargo, a.no_area,a.fe_creacion FROM mae_cargo c INNER JOIN mae_area a ON a.nid_area = c.nid_area " +
            " INNER JOIN mae_estado e ON e.nid_estado = c.nid_estado where c.nid_estado = 1 order by 1 desc";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getDate(4));
                
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
            String sql = "SELECT t.co_trabajador as Código,t.no_natural as Nombre,no_ape_paterno as 'Apellido Paterno',no_ape_materno as 'Apellido Materno',t.nu_documento as DNI,t.fe_ingreso_laboral as 'Ingreso Laboral',c.no_cargo as Cargo from mae_trabajador t " +
                    "inner join mae_cargo c on c.nid_cargo = t.nid_cargo inner join mae_estado e on e.nid_estado = t.nid_estado where t.nid_estado = 1 order by 1 desc";
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
                
                dtm.addRow(v);
            }
            return dtm;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static DefaultListModel ListarCategoriasPed(){
        try {
            DefaultListModel dlm = new DefaultListModel();
            String sql = "select nid_categoria_plato,no_categoria_plato from mae_categoria_plato where nu_nivel = 1 and nid_estado = 1"; //Where t.nid_estado = 1
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               dlm.addElement(rs.getInt(1) + "%" + rs.getString(2));
            }
            return dlm;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static DefaultListModel ListarSubCategoriasPed(int idDad, int catNivel){
        try {
            //System.out.println("Datos a enviar: Categoría Padre: " + idDad + " Nivel: " + catNivel);
            DefaultListModel dlm = new DefaultListModel();
            String sql = "select nid_categoria_plato,no_categoria_plato from mae_categoria_plato where mae_categoria_plato.nid_padre_categoria = ? and mae_categoria_plato.nu_nivel = ? and mae_categoria_plato.nid_estado = 1"; //Where t.nid_estado = 1
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, idDad);
            ps.setInt(2, catNivel);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               dlm.addElement(rs.getInt(1) + "%" + rs.getString(2));
               //System.out.println(rs.getInt(1) + "_" + rs.getString(2) + "DAD: "+ idDad + "nivel: " + catNivel);
            }
            return dlm;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static DefaultTableModel ListarUsuarios(){
        try {
            DefaultTableModel dtm = FormatearTablaUsuario();
            String sql = "select u.nid_usuario, u.no_usuario,u.no_clave, t.co_trabajador,p.no_perfil,l.no_local from mae_usuario u inner join " +
"                          mae_estado e on e.nid_estado = u.nid_estado inner join mae_trabajador t on t.nid_trabajador = u.nid_trabajador " +
"                          inner join mae_perfil p on p.nid_perfil = u.nid_perfil inner join mae_usuario_local ml on ml.nid_usuario = u.nid_usuario " +
"                          inner join mae_local l on l.nid_local = ml.nid_local where u.nid_estado = 1 order by 1 desc";
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
                //v.add(rs.getString(6));
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
    public static DefaultListModel ListarMesasSelection(int piso){
        try {
            DefaultListModel dlm = new DefaultListModel();
            String sql = "select mes.nu_mesa, mes.qt_silla from mae_mesa mes inner join mae_piso pis on pis.nid_piso = mes.nid_piso where mes.nid_estado = 1 and pis.nu_piso = ? and pis.nid_local = ? order by 1";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, piso);
            ps.setInt(2, idlocal);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dlm.addElement(rs.getString(1) + "#" + rs.getInt(2));
            }
            return dlm;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public static DefaultListModel ListarMesasSelection1(int piso){
        try {
            DefaultListModel dlm = new DefaultListModel();
            String sql = "select mes.nu_mesa, mes.qt_silla from mae_mesa mes inner join mae_piso pis on pis.nid_piso = mes.nid_piso inner join tbl_pedido_mesa tpm on tpm.nid_mesa = mes.nid_mesa inner join tbl_pedido ped on ped.nid_pedido = tpm.nid_pedido where mes.nid_estado = 1 and pis.nu_piso = ? and pis.nid_local = ? and ped.nid_estado = 4 order by 1";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, piso);
            ps.setInt(2, idlocal);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dlm.addElement(rs.getString(1) + "#" + rs.getInt(2));
            }
            return dlm;
        } catch (SQLException ex) {
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
        
        String sp = "Call sp_usuario(?,?,?,?,?,?,?,?)";
        try {
            CallableStatement cs = BDUtil.getCnn().prepareCall(sp);
            cs.setInt(1, usuario.getId());
            cs.setString(2,usuario.getUser());
            cs.setString(3,usuario.getPssEnc());
            cs.setInt(4,usuario.getEstado());
            cs.setInt(5,usuario.getCodT());
            cs.setInt(6, usuario.getRol());
            cs.setInt(7,usuario.getIdLocal());
            cs.setInt(8,tipo);
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
            
            cs.executeUpdate();
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
    public static int GetNewIDPlato(){
        try {
            String sql = "select nid_plato +1  from mae_plato order by 1 desc limit 1";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
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
    public static int GetIdLocal(String a){
        try {
            String sql = "SELECT nid_local FROM mae_local where no_local = ?";
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
            String sql = "SELECT co_trabajador FROM mae_trabajador where nid_trabajador = ? and nid_estado = 1";
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
            String sql = "SELECT 1 FROM mae_usuario where nid_trabajador = ? and nid_estado = 1";
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
            String sql = "SELECT 1 FROM mae_usuario where no_usuario = ? and nid_estado = 1";
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
            String sql = "SELECT 1 FROM mae_area where no_area = ? and nid_estado = 1";
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
            String sql = "SELECT 1 FROM mae_cargo where no_cargo = ? and nid_estado = 1";
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
            String sql = "SELECT nu_piso from mae_piso where nid_estado = 1 and nid_local = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, idlocal);
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
    public static DefaultListModel ListarProds(int nivel, int cat, int local){
        try {
            DefaultListModel dlm = new DefaultListModel();
            /*String col = "nid_categoria1_plato";
            switch(nivel){
                case 1: col = "nid_categoria1_plato"; break;
                case 2: col = "nid_categoria2_plato"; break;
                case 3: col = "nid_categoria3_plato"; break;
                default: col = "nid_categoria1_plato"; break;
            }*/
           //System.out.println("Nivel: " + nivel + " cat: " + cat);
            String sql = "CALL usp_listarprod(?,?,?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1, nivel);
            cs.setInt(2,cat);
            cs.setInt(3,local);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                
               // System.out.println("Resultado: ");
                //System.out.println(rs.getString(1));
                dlm.addElement(rs.getString(1) + "%" + rs.getDouble(2) + "#" + rs.getString(3) + "+" + rs.getInt(4));
                
            }
            return dlm;
        } catch (SQLException ex) {
            
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception e){
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        
            
    }
    public static DefaultListModel JoinPedido(int nPiso /*, nlocal*/){
        try {
            DefaultListModel dlm = new DefaultListModel();
            String sql = "select tpm.nid_pedido,mm.nu_mesa, concat(t.no_natural,' ', t.no_ape_paterno) from tbl_pedido_mesa tpm inner join mae_mesa mm on mm.nid_mesa = tpm.nid_mesa inner join tbl_pedido ped " +
                " on ped.nid_pedido = tpm.nid_pedido inner join mae_trabajador t on ped.nid_mozo = t.nid_trabajador inner join mae_piso mp on mm.nid_piso = mp.nid_piso inner join tbl_pedido tp on tp.nid_pedido = tpm.nid_pedido where mp.nu_piso = ? and mp.nid_local = ? and (tp.nid_estado = 3 or tp.nid_estado = 4) "; //and mp.nid_local = ?;";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, nPiso);
            ps.setInt(2, idlocal);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 dlm.addElement(rs.getInt(1) + "#" + rs.getInt(2) + "$" + rs.getString(3));
            }
            return dlm;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public static DefaultListModel JoinPedido1(int nPiso /*, nlocal*/){
        try {
            DefaultListModel dlm = new DefaultListModel();
            String sql = "select tpm.nid_pedido,mm.nu_mesa, concat(t.no_natural,' ', t.no_ape_paterno) from tbl_pedido_mesa tpm inner join mae_mesa mm on mm.nid_mesa = tpm.nid_mesa inner join tbl_pedido ped " +
                " on ped.nid_pedido = tpm.nid_pedido inner join mae_trabajador t on ped.nid_mozo = t.nid_trabajador inner join mae_piso mp on mm.nid_piso = mp.nid_piso inner join tbl_pedido tp on tp.nid_pedido = tpm.nid_pedido where mp.nu_piso = ? and mp.nid_local = ? and tp.nid_estado = 4 and mm.nid_estado=1"; //and mp.nid_local = ?;";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, nPiso);
            ps.setInt(2, idlocal);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 dlm.addElement(rs.getInt(1) + "#" + rs.getInt(2) + "$" + rs.getString(3));
            }
            return dlm;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public static DefaultTableModel DetallePedido(int nPedido){
        try {
            DPedido.DetalleAPedido.removeAllElements();
            DefaultTableModel dtm = FormatearTablaDetalleP();
            String sql = "select mpl.no_plato, tpd.qt_pedido,tpd.mt_precio, (tpd.qt_pedido * tpd.mt_precio),tpd.tx_observacion, tpd.co_estado, mpl.co_envio from tbl_pedido_detalle tpd inner join mae_plato mpl on mpl.nid_plato = tpd.nid_plato where tpd.nid_pedido = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, nPedido);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getInt(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                DPedido.DetalleAPedido.addElement(rs.getString(1) + "$" + rs.getString(2));
                dtm.addRow(v);
            }
            return dtm;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static DefaultComboBoxModel ListarCBOMozo(){
        DefaultComboBoxModel CBOT = new DefaultComboBoxModel();
        try {
            String sql = "select concat(left(mtr.no_natural,1),left(mtr.no_ape_paterno,1), lower(mid(mtr.no_ape_paterno,2,length(mtr.no_ape_paterno)))) as Mozo from mae_trabajador mtr inner join mae_usuario u on u.nid_trabajador = mtr.nid_trabajador inner join mae_usuario_local mul on mul.nid_usuario = u.nid_usuario where mtr.nid_cargo = 3 and mul.nid_local = ? and mtr.nid_estado = 1";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, idlocal);
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
    public static String GetDNIBycboMozo(String NameApe){
        
        try {
            String sql = "select nu_documento as DNI from mae_trabajador where concat(left(no_natural,1), no_ape_paterno) = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setString(1, NameApe);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, e);
            System.err.println(e);
            return null;
        }
    }
    public static String GetNCompletoBycboMozo(String NameApe){
        
        try {
            String sql = "select concat(no_natural,' ', no_ape_paterno,' ', no_ape_materno) as NameCompleto from mae_trabajador where concat(left(no_natural,1), no_ape_paterno) = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setString(1, NameApe);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, e);
            System.err.println(e);
            return null;
        }
    }
    
    public static boolean RegUnionCargo(int idCargo){
        try {
            String sql = "select * from mae_trabajador where nid_cargo = ? and nid_estado = 1";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, idCargo);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static boolean RegUnionArea(int idArea){
        try {
            String sql = "select * from mae_cargo where nid_area = ? and nid_estado = 1";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, idArea);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static boolean RegUnionTrabajador(int idT){
        try {
            String sql = "select * from mae_usuario where nid_trabajador = ? and nid_estado = 1";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, idT);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static int ConfirmarPedido(DefaultListModel DLM, String DNI, int userCrea){
        
        try {
            String sql = "CALL usp_spi_pedido(?,?,?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1,idlocal);
            cs.setString(2,DNI);
            cs.setInt(3, userCrea);
            ResultSet rs = cs.executeQuery();
            rs.next();
            int NewNPedido = rs.getInt(1);
            //System.out.println(NewNPedido);
            for(int i = 0; i < DPedido.dlmDP.size(); i++){
                int nmesa = Integer.parseInt(DPedido.dlmDP.getElementAt(i).toString());
                //System.out.println("NMESA: " + nmesa);
                String sqlI = "CALL usp_spi_pedido_mesa(?,?,?,?)";
                CallableStatement csI = BDUtil.getCnn().prepareCall(sqlI);
                System.out.println(NewNPedido + "," + nmesa + "," + numPiso+ "," +idlocal);
                csI.setInt(1,NewNPedido);
                csI.setInt(2,nmesa);
                csI.setInt(3, numPiso);
                csI.setInt(4, idlocal);
                csI.executeQuery();
            }
            return NewNPedido;
        } catch (SQLException ex) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    public static int GetDniUserLOG(int id){
        try {
            String sql = "SELECT t.nu_documento from mae_trabajador t   inner join mae_usuario u on u.nid_trabajador = t.nid_trabajador where u.nid_usuario = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            return -1;
        }
 
           
    }
    public static String GetMozoByPedido(int idPedido){
        try {
            String sql = "SELECT concat(left(t.no_natural,1),left(t.no_ape_paterno,1),lower(mid(t.no_ape_paterno,2,length(t.no_ape_paterno)))) as Mozo from mae_trabajador t   inner join tbl_pedido tp on tp.nid_mozo = t.nid_trabajador where tp.nid_pedido = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        
    }
    public static void IngresarDetallP(DefaultListModel DT, int idPedido){
        try {
            for(int i = 0; i < DT.size(); i++ ){
                String cad = DT.getElementAt(i).toString();
                String nPlato = cad.substring(0,cad.indexOf('%'));
                int cant = Integer.parseInt(cad.substring(cad.indexOf('%')+1,cad.indexOf('$')));
                String descr = cad.substring(cad.indexOf('$')+1,cad.indexOf('#'));
                double precio = Double.parseDouble(cad.substring(cad.indexOf('#')+1,cad.length()));
                String sql = "CALL usp_spi_detalle_pedido(?,?,?,?,?)";
                CallableStatement cs = BDUtil.getCnn().prepareCall(sql);
                cs.setInt(1, idPedido);
                cs.setString(2, nPlato);
                cs.setDouble(3, precio);
                cs.setInt(4, cant);
                cs.setString(5, descr);
                cs.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        }
    }
    public static void CerrarPedido(int idPedido){
        try {
            String sql = "UPDATE tbl_pedido set nid_estado = 4 where nid_pedido = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, idPedido);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, e);
            
        }
    }
    public static boolean AnularPedido(int idPedido){
        try {
            String sql = "Call usp_anularpedido_dp(?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1, idPedido);
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    public static int EstadoApeCaja(){
        try {
            String sql = "select nid_estado from tbl_caja where co_operacion = 'A' and nid_empresa = ? and nid_local = ? and fe_emision is null and Convert(fe_creacion,date) = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, idlocal);
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            return rs.getInt(1);
            else return 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return -1;
        }
    }
    public static int EstadoCierreCaja(){
        try {
            String sql = "select count(*) from tbl_caja where co_operacion = 'C' and nid_empresa = ? and nid_local = ? and fe_emision is null and Convert(fe_creacion,date) = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, idlocal);
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            return rs.getInt(1);
            else return 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return -1;
        }
    }
    public static int VeriPedidoPendientes(){
        try {
            String sql = "select count(tp.nid_pedido) from tbl_pedido tp inner join mae_local ml on ml.nid_local = tp.nid_local where (tp.nid_estado = 3 or tp.nid_estado = 4) and Convert(tp.fe_creacion,date) = ? and tp.nid_local = ? and ml.nid_empresa = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            ps.setInt(2, idlocal);
            ps.setInt(3, 1); //idEmpresa
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            return rs.getInt(1);
            else return 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return -1;
        }
    }
    //select count(*) from tbl_pedido where nid_estado = 3 and Convert(fe_creacion,date) = '2017-08-11';
    public static int EstadoPedidoinMS(int nPedido){
        try {
            String sql = "select nid_estado from tbl_pedido where nid_pedido = ?";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, nPedido);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            return rs.getInt(1);
            else return 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return -1;
        }
    }
    public static void AbrirCaja(double monto){
        try {
            String sql = "INSERT INTO tbl_caja(nid_empresa, nid_local, co_operacion, co_medio_pago, mt_importe, nu_persona,nid_estado, nid_usuario_crea, fe_creacion) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = BDUtil.getCnn().prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, idlocal);
            ps.setString(3, "A");
            ps.setString(4, "8");
            ps.setDouble(5, monto);
            ps.setInt(6, dniUserLog);
            ps.setInt(7, 1);
            ps.setInt(8, idUserLog);
            ps.setTimestamp(9, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public static boolean EliminarPlatoB(int idPedido, String NamePlatoB){
        try {
            String sql = "CALL usp_deleteplato_dpedido(?,?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1, idPedido);
            cs.setString(2, NamePlatoB);
            cs.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static boolean ModPlatoDPCaja(int idPedido, String Plato, int Cant, int Tipo){
        try {
            String sql = "CALL usp_ModDetPedido(?,?,?,?)";
            CallableStatement cs = BDUtil.getCnn().prepareCall(sql);
            cs.setInt(1, idPedido);
            cs.setString(2, Plato);
            cs.setInt(3, Cant);
            cs.setInt(4,Tipo);
            cs.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(BD_RS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
