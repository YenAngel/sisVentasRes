
package ventas.persistencia.util;

/**
 *
 * @author AnibalMA
 */
public class Usuario {
    private static int id;
    private static String user;
    private static int rol;
    private static int estado;
    private static int codT;
    private static String pssEnc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Usuario.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        Usuario.user = user;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        Usuario.rol = rol;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        Usuario.estado = estado;
    }

    public int getCodT() {
        return codT;
    }

    public void setCodT(int codT) {
        Usuario.codT = codT;
    }

    public String getPssEnc() {
        return pssEnc;
    }

    public void setPssEnc(String pssEnc) {
        Usuario.pssEnc = pssEnc;
    }
    
}
