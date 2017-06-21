
package ventas.modelo;

public class Mesa {
    public int nid_mesa;
    public int nu_mesa;
    public int qt_silla;
    public String co_tipo_mesa;
    public String no_estado;
    public String no_local;
    public int nid_usuario_crea;
    public int nid_usuario_modi;
    
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
    
    public String getNo_local() {
        return no_local;
    }

    public void setNo_local(String no_local) {
        this.no_local = no_local;
    }
    public int nu_piso;

    public int getNid_mesa() {
        return nid_mesa;
    }

    public void setNid_mesa(int nid_mesa) {
        this.nid_mesa = nid_mesa;
    }

    public int getNu_mesa() {
        return nu_mesa;
    }

    public void setNu_mesa(int nu_mesa) {
        this.nu_mesa = nu_mesa;
    }

    public int getQt_silla() {
        return qt_silla;
    }

    public void setQt_silla(int qt_silla) {
        this.qt_silla = qt_silla;
    }

    public String getCo_tipo_mesa() {
        return co_tipo_mesa;
    }

    public void setCo_tipo_mesa(String co_tipo_mesa) {
        this.co_tipo_mesa = co_tipo_mesa;
    }

    public String getNo_estado() {
        return no_estado;
    }

    public void setNo_estado(String no_estado) {
        this.no_estado = no_estado;
    }

    public int getNu_piso() {
        return nu_piso;
    }

    public void setNu_piso(int nu_piso) {
        this.nu_piso = nu_piso;
    }
    
}
