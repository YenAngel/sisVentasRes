
package ventas.modelo;

import java.util.Date;

public class CajaLocal {
    public Date vi_fe_emision;
    public String vi_no_local;
    public String vi_co_comprobante;
    public String vi_nu_comprobante;
    public double vi_mt_importe;
    public String vi_nu_persona;
    public int vi_nid_usuario_crea;

    public Date getVi_fe_emision() {
        return vi_fe_emision;
    }

    public void setVi_fe_emision(Date vi_fe_emision) {
        this.vi_fe_emision = vi_fe_emision;
    }

    public String getVi_no_local() {
        return vi_no_local;
    }

    public void setVi_no_local(String vi_no_local) {
        this.vi_no_local = vi_no_local;
    }

    public String getVi_co_comprobante() {
        return vi_co_comprobante;
    }

    public void setVi_co_comprobante(String vi_co_comprobante) {
        this.vi_co_comprobante = vi_co_comprobante;
    }

    public String getVi_nu_comprobante() {
        return vi_nu_comprobante;
    }

    public void setVi_nu_comprobante(String vi_nu_comprobante) {
        this.vi_nu_comprobante = vi_nu_comprobante;
    }

    public double getVi_mt_importe() {
        return vi_mt_importe;
    }

    public void setVi_mt_importe(double vi_mt_importe) {
        this.vi_mt_importe = vi_mt_importe;
    }

    public String getVi_nu_persona() {
        return vi_nu_persona;
    }

    public void setVi_nu_persona(String vi_nu_persona) {
        this.vi_nu_persona = vi_nu_persona;
    }

    public int getVi_nid_usuario_crea() {
        return vi_nid_usuario_crea;
    }

    public void setVi_nid_usuario_crea(int vi_nid_usuario_crea) {
        this.vi_nid_usuario_crea = vi_nid_usuario_crea;
    }
}
