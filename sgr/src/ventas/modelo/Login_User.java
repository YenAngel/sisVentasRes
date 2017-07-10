
package ventas.modelo;

public class Login_User {
    public      static      int         ndi_usuario;
    public      static      int         nid_perfil;
    public      static String      no_usuario;
    public      static String      no_clave;
    public      static String      surcursal;

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

    public String getSurcursal() {
        return surcursal;
    }

    public void setSurcursal(String surcursal) {
        Login_User.surcursal = surcursal;
    }
    
}
