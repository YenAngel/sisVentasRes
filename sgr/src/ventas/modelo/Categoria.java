
package ventas.modelo;

public class Categoria {
    int nid_categoria_plato;
    String no_padre_categoria;
    int nu_nivel;
    String no_categoria_plato;
    String no_estado;
    int nid_usuario_crea;
    int nid_usuario_modi;

    public int getNid_categoria_plato() {
        return nid_categoria_plato;
    }

    public void setNid_categoria_plato(int nid_categoria_plato) {
        this.nid_categoria_plato = nid_categoria_plato;
    }

    public String getNo_padre_categoria() {
        return no_padre_categoria;
    }

    public void setNo_padre_categoria(String no_padre_categoria) {
        this.no_padre_categoria = no_padre_categoria;
    }

    public int getNu_nivel() {
        return nu_nivel;
    }

    public void setNu_nivel(int nu_nivel) {
        this.nu_nivel = nu_nivel;
    }

    public String getNo_categoria_plato() {
        return no_categoria_plato;
    }

    public void setNo_categoria_plato(String no_categoria_plato) {
        this.no_categoria_plato = no_categoria_plato;
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
