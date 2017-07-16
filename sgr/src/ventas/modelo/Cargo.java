/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;

import java.util.Date;

/**
 *
 * @author AnibalMA
 */
public class Cargo {
    public static int id;
    public static String nombre;
    public static String narea;
    public static int area;
    public static Date fe_creacion;
    public static Date fe_mod;
    public static int estado;

    public String getNarea() {
        return narea;
    }

    public void setNarea(String narea) {
        Cargo.narea = narea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Date getFe_creacion() {
        return fe_creacion;
    }

    public void setFe_creacion(Date fe_creacion) {
        this.fe_creacion = fe_creacion;
    }

    public Date getFe_mod() {
        return fe_mod;
    }

    public void setFe_mod(Date fe_mod) {
        this.fe_mod = fe_mod;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
