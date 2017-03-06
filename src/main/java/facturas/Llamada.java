package facturas;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by david on 3/03/17.
 */
public class Llamada {

    private int numero;
    private Calendar fecha;
    private double duracion;

    public Llamada() {
        this.fecha = new GregorianCalendar();
    }

    public Llamada(int numero, double duracion) {
        this.numero = numero;
        this.duracion = duracion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        StringBuilder llamada = new StringBuilder();
        llamada.append("Número: " + numero + "\n");
        llamada.append("Fecha de realización: " + fecha.get(Calendar.DAY_OF_MONTH) + "/" + fecha.get(Calendar.MONTH)  + "/" + fecha.get(Calendar.YEAR) + "\n");
        llamada.append("Hora de realización: " + fecha.get(Calendar.HOUR) + ":" + fecha.get(Calendar.MINUTE)  + ":" + fecha.get(Calendar.SECOND) + "\n");
        llamada.append("Duración de la llamada: " + duracion + "\n");

        return llamada.toString();
    }

}
