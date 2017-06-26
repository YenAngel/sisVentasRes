
package ventas.modelo;

public class PlatoLocal {
    double mt_precio;
    String fl_vip;
    String no_plato;
    String no_local;
    int nid_usuario_crea;
    int nid_usuario_modi;

    public double getMt_precio() {
        return mt_precio;
    }

    public void setMt_precio(double mt_precio) {
        this.mt_precio = mt_precio;
    }

    public String getFl_vip() {
        return fl_vip;
    }

    public void setFl_vip(String fl_vip) {
        this.fl_vip = fl_vip;
    }

    public String getNo_plato() {
        return no_plato;
    }

    public void setNo_plato(String no_plato) {
        this.no_plato = no_plato;
    }

    public String getNo_local() {
        return no_local;
    }

    public void setNo_local(String no_local) {
        this.no_local = no_local;
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
