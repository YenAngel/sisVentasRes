
package ventas.modelo;

public class Comprobante {
    String nu_serie;
    String nu_correlativo;
    String no_local;
    String co_comprobante;
    int nid_usuario_crea;
    int nid_usuario_modi;

    public String getNu_serie() {
        return nu_serie;
    }

    public void setNu_serie(String nu_serie) {
        this.nu_serie = nu_serie;
    }

    public String getNu_correlativo() {
        return nu_correlativo;
    }

    public void setNu_correlativo(String nu_correlativo) {
        this.nu_correlativo = nu_correlativo;
    }

    public String getNo_local() {
        return no_local;
    }

    public void setNo_local(String no_local) {
        this.no_local = no_local;
    }

    public String getCo_comprobante() {
        return co_comprobante;
    }

    public void setCo_comprobante(String co_comprobante) {
        this.co_comprobante = co_comprobante;
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
