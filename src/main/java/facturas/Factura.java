package facturas;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by david on 3/03/17.
 */
public class Factura {

    private Integer codigoFactura;
    private Tarifa tarifaAplicada;
    private Calendar fechaEmision;
    private Calendar periodoFacturacion;
    private double importe;

    public Factura() {
        this.fechaEmision = new GregorianCalendar();
        this.periodoFacturacion = Calendar.getInstance();
    }

    public Factura(Integer codigoFactura, Tarifa tarifaAplicada, double importe) {
        this.codigoFactura = codigoFactura;
        this.tarifaAplicada = tarifaAplicada;
        this.importe = importe;
    }

    public Integer getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(Integer codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Tarifa getTarifaAplicada() {
        return tarifaAplicada;
    }

    public void setTarifaAplicada(Tarifa tarifaAplicada) {
        this.tarifaAplicada = tarifaAplicada;
    }

    public Calendar getFecha() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Calendar getPeriodoFacturacion() {
        return periodoFacturacion;
    }

    public void setPeriodoFacturacion(Calendar periodoFacturacion) {
        this.periodoFacturacion = periodoFacturacion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        StringBuilder factura = new StringBuilder();
        factura.append("Código de factura: " + codigoFactura + "\n");
        factura.append("Tarifa aplicada: " + tarifaAplicada.getPrecio() + "\n");
        factura.append("Fecha de emisión: " + fechaEmision.get(Calendar.DAY_OF_MONTH) + "/" + fechaEmision.get(Calendar.MONTH)  + "/" + fechaEmision.get(Calendar.YEAR) + "\n");
        factura.append("Periodo de facturación: " + periodoFacturacion.get(Calendar.DAY_OF_MONTH) + "/" + periodoFacturacion.get(Calendar.MONTH)  + "/" + periodoFacturacion.get(Calendar.YEAR) + "\n");
        factura.append("Importe de la factura: " + importe + "\n");

        return factura.toString();
    }

}
