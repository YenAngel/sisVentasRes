
package ventas.modelo;

import java.util.Date;

public class Caja {
    public String co_comprobante;
    public String nu_serie;
    public String nu_correlativo;
    public Date fe_emision;
    public double mt_subtotal;
    public double mt_igv;
    public double mt_total;
    public String doc_cliente;
    public int nid_pedido;
    public int nu_piso;
    public int nu_mesa;
    public String no_local;
    public String no_estado;
    public int tipo_pago;
    public int nid_usuario_crea;
    public int nid_usuario_modi;

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
    
    public String getDoc_cliente() {
        return doc_cliente;
    }

    public void setDoc_cliente(String doc_cliente) {
        this.doc_cliente = doc_cliente;
    }
    
    public String getCo_comprobante() {
        return co_comprobante;
    }

    public void setCo_comprobante(String co_comprobante) {
        this.co_comprobante = co_comprobante;
    }

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

    public Date getFe_emision() {
        return fe_emision;
    }

    public void setFe_emision(Date fe_emision) {
        this.fe_emision = fe_emision;
    }

    public double getMt_subtotal() {
        return mt_subtotal;
    }

    public void setMt_subtotal(double mt_subtotal) {
        this.mt_subtotal = mt_subtotal;
    }

    public double getMt_igv() {
        return mt_igv;
    }

    public void setMt_igv(double mt_igv) {
        this.mt_igv = mt_igv;
    }

    public double getMt_total() {
        return mt_total;
    }

    public void setMt_total(double mt_total) {
        this.mt_total = mt_total;
    }

    public int getNid_pedido() {
        return nid_pedido;
    }

    public void setNid_pedido(int nid_pedido) {
        this.nid_pedido = nid_pedido;
    }

    public int getNu_piso() {
        return nu_piso;
    }

    public void setNu_piso(int nu_piso) {
        this.nu_piso = nu_piso;
    }

    public int getNu_mesa() {
        return nu_mesa;
    }

    public void setNu_mesa(int nu_mesa) {
        this.nu_mesa = nu_mesa;
    }

    public String getNo_local() {
        return no_local;
    }

    public void setNo_local(String no_local) {
        this.no_local = no_local;
    }

    public String getNo_estado() {
        return no_estado;
    }

    public void setNo_estado(String no_estado) {
        this.no_estado = no_estado;
    }

    public int getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(int tipo_pago) {
        this.tipo_pago = tipo_pago;
    }
    
}
