
package ventas.modelo;

public class Plato {
    int nid_plato;
    String no_categoria3_plato;
    String no_categoria2_plato;
    String no_categoria1_plato;
    String no_plato;
    String no_estado;
    String co_tipo;
    int nid_usuario_crea;
    int nid_usuario_modi;

    public String getNo_categoria3_plato() {
        return no_categoria3_plato;
    }

    public void setNo_categoria3_plato(String no_categoria3_plato) {
        this.no_categoria3_plato = no_categoria3_plato;
    }

    public String getNo_categoria2_plato() {
        return no_categoria2_plato;
    }

    public void setNo_categoria2_plato(String no_categoria2_plato) {
        this.no_categoria2_plato = no_categoria2_plato;
    }

    public String getNo_categoria1_plato() {
        return no_categoria1_plato;
    }

    public void setNo_categoria1_plato(String no_categoria1_plato) {
        this.no_categoria1_plato = no_categoria1_plato;
    }

    public int getNid_plato() {
        return nid_plato;
    }

    public void setNid_plato(int nid_plato) {
        this.nid_plato = nid_plato;
    }

    public String getNo_estado() {
        return no_estado;
    }

    public void setNo_estado(String no_estado) {
        this.no_estado = no_estado;
    }    

    public String getNo_plato() {
        return no_plato;
    }

    public void setNo_plato(String no_plato) {
        this.no_plato = no_plato;
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

    public String getCo_tipo() {
        return co_tipo;
    }

    public void setCo_tipo(String co_tipo) {
        this.co_tipo = co_tipo;
    }
    
}
