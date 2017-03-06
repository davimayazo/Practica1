package gestion;

import clientes.Cliente;
import facturas.Factura;
import facturas.Llamada;
import facturas.Tarifa;
import misc.Mensaje;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by david on 5/03/17.
 */
public class GestionDatos {

    private static TreeMap<String, Cliente> clientes;
    private static TreeMap<String, HashSet<Llamada>> llamadas;
    private static TreeMap<String, HashSet<Factura>> facturasDeCliente;
    private static TreeMap<Integer, Factura> facturasPorCodigo;
    private static int codigoFactura = 0;

    public GestionDatos() {
        clientes = new TreeMap<String, Cliente>();
        llamadas = new TreeMap<String, HashSet<Llamada>>();
        facturasDeCliente = new TreeMap<String, HashSet<Factura>>();
        facturasPorCodigo = new TreeMap<Integer, Factura>();
    }

    /**
     * GESTIÓN DE CLIENTES
     */

    public static TreeMap<String, Cliente> getClientes() {
        return new TreeMap<>(clientes);
    }

    public static void añadirCliente(Cliente cliente) {
        clientes.put(cliente.getNif(), cliente);
    }

    public static void borrarCliente(String nif) {
        clientes.remove(nif);
        llamadas.remove(nif);
    }

    public static void modificarTarifa(String nif, Tarifa tarifa) {
        clientes.get(nif).setTarifa(tarifa);
    }

    public static Cliente recuperarDatosCliente(String nif) {
        return clientes.get(nif);
    }

    public static TreeMap<String, Cliente> recuperarListaClientes() {
        return new TreeMap<>(clientes);
    }

    /**
     * GESTIÓN DE LLAMADAS
     */

    public static TreeMap<String, HashSet<Llamada>> getLlamadas() {
        return new TreeMap<>(llamadas);
    }

    public static void añadirLlamada(String nif, Llamada llamada) {
        if (llamadas.containsKey(nif)) {
            llamadas.get(nif).add(llamada);
        } else {
            HashSet<Llamada> nuevaLlamada = new HashSet<Llamada>();
            nuevaLlamada.add(llamada);
            llamadas.put(nif, nuevaLlamada);
        }
    }

    public static HashSet<Llamada> recuperarListaLlamadas(String nif) {
        return new HashSet<Llamada>(llamadas.get(nif));
    }

    /**
     * GESTIÓN DE FACTURAS
     */

    public static TreeMap<String, HashSet<Factura>> getFacturasDeCliente() {
        return new TreeMap<String, HashSet<Factura>>(facturasDeCliente);
    }

    public static TreeMap<Integer, Factura> getFacturasPorCodigo() {
        return new TreeMap<Integer, Factura>(facturasPorCodigo);
    }

    public static void emitirFactura(String nif) {
        double duracionTotal = 0;
        Calendar fechaActual = new GregorianCalendar();
        Factura factura = new Factura();

        for (Llamada llamada : llamadas.get(nif)) {
            if (llamada.getFecha().get(Calendar.YEAR) == fechaActual.get(Calendar.YEAR) &&
                    llamada.getFecha().get(Calendar.MONTH) == fechaActual.get(Calendar.MONTH)) {
                duracionTotal += llamada.getDuracion();
            }
        }
        codigoFactura++;
        Tarifa tarifa = clientes.get(nif).getTarifa();
        double importe = duracionTotal * tarifa.getPrecio();
        factura.setCodigoFactura(codigoFactura);
        factura.setTarifaAplicada(tarifa);
        factura.setImporte(importe);

        if (facturasDeCliente.containsKey(nif)) {
            facturasDeCliente.get(nif).add(factura);
        } else {
            HashSet<Factura> nuevaFactura = new HashSet<Factura>();
            nuevaFactura.add(factura);
            facturasDeCliente.put(nif, nuevaFactura);
        }
        facturasPorCodigo.put(codigoFactura, factura);
    }

    public static Factura recuperarFacturaPorCodigo(int codigo) {
        return facturasPorCodigo.get(codigo);
    }

    public static HashSet<Factura> recuperarFacturasDeCliente(String nif) {
        return new HashSet<>(facturasDeCliente.get(nif));
    }

}
