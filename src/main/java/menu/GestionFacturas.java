package menu;

import facturas.Factura;
import gestion.GestionDatos;
import misc.Mensaje;
import misc.MostrarDatos;
import misc.PedirDatos;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by david on 6/03/17.
 */
public class GestionFacturas {
    private PedirDatos pedir;
    private MostrarDatos mostrar;

    public GestionFacturas() {
        pedir = new PedirDatos();
        mostrar = new MostrarDatos();
    }

    public void emitirFactura() {
        if(!GestionDatos.getClientes().isEmpty()) {
            if(!GestionDatos.getLlamadas().isEmpty()) {
                String nif = pedir.pedirDatos("NIF");

                if(GestionDatos.getLlamadas().containsKey(nif)) {
                    GestionDatos.emitirFactura(nif);
                    mostrar.mostrarDatos(Mensaje.FACTURA_CREADO);
                }
                else {
                    mostrar.mostrarDatos(Mensaje.CLIENTE_NO_LLAMADAS);
                }
            }
            else {
                mostrar.mostrarDatos(Mensaje.LLAMADAS_VACÍO);
            }
        }
        else {
            mostrar.mostrarDatos(Mensaje.CLIENTES_VACÍO);
        }
    }

    public void recuperarFacturaPorCodigo() {
        if(!GestionDatos.getClientes().isEmpty()) {
            if (!GestionDatos.getFacturasPorCodigo().isEmpty()) {
                String codigo = pedir.pedirDatos("código de factura");

                if (GestionDatos.getFacturasPorCodigo().containsKey(Integer.parseInt(codigo))) {
                    mostrar.mostrarDatos(GestionDatos.getFacturasPorCodigo().get(Integer.parseInt(codigo)));
                }
                else {
                    System.out.print(Mensaje.CLIENTE_NO_FACTURAS);
                }
            }
            else {
                mostrar.mostrarDatos(Mensaje.FACTURAS_VACÍO);
            }
        }
        else {
            mostrar.mostrarDatos(Mensaje.CLIENTES_VACÍO);
        }
    }

    public void recuperarFacturasDeCliente() {
        if(!GestionDatos.getClientes().isEmpty()) {
            if(!GestionDatos.getFacturasDeCliente().isEmpty()) {
                String nif = pedir.pedirDatos("NIF");

                if(GestionDatos.getFacturasDeCliente().containsKey(nif)) {
                    mostrar.mostrarDatos(GestionDatos.getFacturasDeCliente().get(nif));
                }
                else {
                    mostrar.mostrarDatos(Mensaje.CLIENTE_NO_FACTURAS);
                }
            }
            else {
                mostrar.mostrarDatos(Mensaje.FACTURAS_VACÍO);
            }
        }
        else {
            mostrar.mostrarDatos(Mensaje.CLIENTES_VACÍO);
        }
    }

}
