package clientes;

import facturas.Tarifa;

import java.util.Calendar;

/**
 * Created by david on 3/03/17.
 */
public class Particular extends Cliente {

    private String apellidos;

    public Particular() {
        super();
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        StringBuilder cliente = new StringBuilder();
        cliente.append("NIF: " + super.getNif() + "\n");
        cliente.append("Nombre: " + super.getNombre() + " " + apellidos + "\n");
        cliente.append("Dirección: " + super.getDireccion() + "\n");
        cliente.append("Correo electrónico: " + super.getCorreo() + "\n");
        cliente.append("Fecha de alta: " + super.getFecha().get(Calendar.DAY_OF_MONTH) + "/" + super.getFecha().get(Calendar.MONTH)  + "/" + super.getFecha().get(Calendar.YEAR) + "\n");
        cliente.append("Tarifa actual: " + super.getTarifa() + "\n");

        return cliente.toString();
    }
}
