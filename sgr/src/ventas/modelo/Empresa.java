
package ventas.modelo;

import java.util.Date;

public class Empresa {
    int     nid_empresa;
    String  no_razon_social;
    String  no_comercial;
    String  nu_ruc;
    String  no_estado;
    Date    fe_creacion;
    Date    fe_modificacion;
    int     nid_usuario_crea;
    int     nid_usuario_modi;

    public int getNid_empresa() {
        return nid_empresa;
    }

    public void setNid_empresa(int nid_empresa) {
        this.nid_empresa = nid_empresa;
    }

    public String getNo_razon_social() {
        return no_razon_social;
    }

    public void setNo_razon_social(String no_razon_social) {
        this.no_razon_social = no_razon_social;
    }

    public String getNo_comercial() {
        return no_comercial;
    }

    public void setNo_comercial(String no_comercial) {
        this.no_comercial = no_comercial;
    }

    public String getNu_ruc() {
        return nu_ruc;
    }

    public void setNu_ruc(String nu_ruc) {
        this.nu_ruc = nu_ruc;
    }

    public String getNo_estado() {
        return no_estado;
    }

    public void setNo_estado(String no_estado) {
        this.no_estado = no_estado;
    }

    public Date getFe_creacion() {
        return fe_creacion;
    }

    public void setFe_creacion(Date fe_creacion) {
        this.fe_creacion = fe_creacion;
    }

    public Date getFe_modificacion() {
        return fe_modificacion;
    }

    public void setFe_modificacion(Date fe_modificacion) {
        this.fe_modificacion = fe_modificacion;
    }

    public int getNid_usuario_crea() {
        return nid_usuario_crea;
    }

    public void setNid_usuario_crea(int nid_usuario_crea) {
        this.nid_usuario_crea = nid_usuario_crea;
    }

    public int getNid_usuario_modi() {
        return nid_usuario_modi;
    }

    public void setNid_usuario_modi(int nid_usuario_modi) {
        this.nid_usuario_modi = nid_usuario_modi;
    }
}
