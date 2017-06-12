
package ventas.persistencia.util;

import java.util.Date;

public class Trabajador {
    private String codigo;
    private String dni;
    private String nombre;
    private String ApePaterno;
    private String ApeMaterno;
    private Date fec_ingreso;
    private int Cargo;
    private Date fec_creacion;
    private Date fec_mod;
    private int estado;
    private int usuario_c;
    private int usuario_m;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return ApePaterno;
    }

    public void setApePaterno(String ApePaterno) {
        this.ApePaterno = ApePaterno;
    }

    public String getApeMaterno() {
        return ApeMaterno;
    }

    public void setApeMaterno(String ApeMaterno) {
        this.ApeMaterno = ApeMaterno;
    }

    public Date getFec_ingreso() {
        return fec_ingreso;
    }

    public void setFec_ingreso(Date fec_ingreso) {
        this.fec_ingreso = fec_ingreso;
    }

    public int getCargo() {
        return Cargo;
    }

    public void setCargo(int Cargo) {
        this.Cargo = Cargo;
    }

    public Date getFec_creacion() {
        return fec_creacion;
    }

    public void setFec_creacion(Date fec_creacion) {
        this.fec_creacion = fec_creacion;
    }

    public Date getFec_mod() {
        return fec_mod;
    }

    public void setFec_mod(Date fec_mod) {
        this.fec_mod = fec_mod;
    }

    public int getUsuario_c() {
        return usuario_c;
    }

    public void setUsuario_c(int usuario_c) {
        this.usuario_c = usuario_c;
    }

    public int getUsuario_m() {
        return usuario_m;
    }

    public void setUsuario_m(int usuario_m) {
        this.usuario_m = usuario_m;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
