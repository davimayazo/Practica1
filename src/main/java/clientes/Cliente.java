package clientes;

import facturas.Factura;
import facturas.Llamada;
import facturas.Tarifa;
import gestion.GestionDatos;

import java.util.*;

/**
 * Created by david on 3/03/17.
 */
public abstract class Cliente {

    private String nif;
    private String nombre;
    private Direccion direccion;
    private String correo;
    private Calendar fechaDeAlta;
    private Tarifa tarifa;

    public Cliente() {
        this.fechaDeAlta = new GregorianCalendar();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Calendar getFecha() {
        return fechaDeAlta;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        StringBuilder cliente = new StringBuilder();
        cliente.append("NIF: " + nif + "\n");
        cliente.append("Nombre: " + nombre + "\n");
        cliente.append("Dirección: " + direccion + "\n");
        cliente.append("Correo: " + correo + "\n");
        cliente.append("Fecha de alta: " + fechaDeAlta.get(Calendar.DAY_OF_MONTH) + "/" + fechaDeAlta.get(Calendar.MONTH)  + "/" + fechaDeAlta.get(Calendar.YEAR) + "\n");
        cliente.append("Tarifa actual: " + tarifa + "\n");

        return cliente.toString();
    }

}
