
package ventas.modelo;

import java.util.Date;

public class Local {
    public     int             nid_local;
    public     String          no_local;
    public     String          tx_direccion;
    public     String          no_empresa;
    public     String          no_estado;
    public     Date            fe_creacion;
    public     Date            fe_modificacion;
    public     int             nid_usuario_crea;
    public     int             nid_usuario_modi;

    public int getNid_local() {
        return nid_local;
    }

    public void setNid_local(int nid_local) {
        this.nid_local = nid_local;
    }

    public String getNo_local() {
        return no_local;
    }

    public void setNo_local(String no_local) {
        this.no_local = no_local;
    }

    public String getTx_direccion() {
        return tx_direccion;
    }

    public void setTx_direccion(String tx_direccion) {
        this.tx_direccion = tx_direccion;
    }

    public String getNo_empresa() {
        return no_empresa;
    }

    public void setNo_empresa(String no_empresa) {
        this.no_empresa = no_empresa;
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
