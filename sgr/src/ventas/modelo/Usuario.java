
package ventas.modelo;

public class Usuario {
    int         ndi_usuario;
    int         nid_perfil;
    String      no_usuario;
    String      no_clave;

    public int getNdi_usuario() {
        return ndi_usuario;
    }

    public void setNdi_usuario(int ndi_usuario) {
        this.ndi_usuario = ndi_usuario;
    }

    public int getNid_perfil() {
        return nid_perfil;
    }

    public void setNid_perfil(int nid_perfil) {
        this.nid_perfil = nid_perfil;
    }

    public String getNo_usuario() {
        return no_usuario;
    }

    public void setNo_usuario(String no_usuario) {
        this.no_usuario = no_usuario;
    }

    public String getNo_clave() {
        return no_clave;
    }

    public void setNo_clave(String no_clave) {
        this.no_clave = no_clave;
    }
    
}
