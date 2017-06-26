
package ventas.modelo;

public class Cliente {
    int nid_cliente;
    String co_tipo_documento;
    String nu_documento;
    String no_cliente;
    String no_ape_paterno;
    String no_ape_materno;
    String no_estado;
    int nid_usuario_crea;
    int nid_usuario_modi;

    public int getNid_cliente() {
        return nid_cliente;
    }

    public void setNid_cliente(int nid_cliente) {
        this.nid_cliente = nid_cliente;
    }

    public String getCo_tipo_documento() {
        return co_tipo_documento;
    }

    public void setCo_tipo_documento(String co_tipo_documento) {
        this.co_tipo_documento = co_tipo_documento;
    }

    public String getNu_documento() {
        return nu_documento;
    }

    public void setNu_documento(String nu_documento) {
        this.nu_documento = nu_documento;
    }

    public String getNo_cliente() {
        return no_cliente;
    }

    public void setNo_cliente(String no_cliente) {
        this.no_cliente = no_cliente;
    }

    public String getNo_ape_paterno() {
        return no_ape_paterno;
    }

    public void setNo_ape_paterno(String no_ape_paterno) {
        this.no_ape_paterno = no_ape_paterno;
    }

    public String getNo_ape_materno() {
        return no_ape_materno;
    }

    public void setNo_ape_materno(String no_ape_materno) {
        this.no_ape_materno = no_ape_materno;
    }

    public String getNo_estado() {
        return no_estado;
    }

    public void setNo_estado(String no_estado) {
        this.no_estado = no_estado;
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
