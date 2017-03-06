package menu;

import gestion.*;
import misc.*;

/**
 * Created by david on 3/03/17.
 */
public class Main {

    public static void main(String[] args) {
        new GestionDatos();
        mostrarMenu();
    }

    private static void mostrarMenu() {
        PedirDatos pedir = new PedirDatos();
        MostrarDatos mostrar = new MostrarDatos();
        while(true) {
            mostrar.mostrarDatos(Menu.getMenu());
            byte opcion = Byte.parseByte(pedir.pedirDatos("opción"));
            Menu opcionMenu = Menu.getOpcion(opcion);
            switch(opcionMenu) {
                case AÑADIR_CLIENTE:
                    new GestionClientes().añadirCliente();
                    break;
                case BORRAR_CLIENTE:
                    new GestionClientes().borrarCliente();
                    break;
                case CAMBIAR_TARIFA:
                    new GestionClientes().modificarTarifa();
                    break;
                case MOSTRAR_DATOS_NIF:
                    new GestionClientes().recuperarDatosCliente();
                    break;
                case MOSTRAR_CLIENTES:
                    new GestionClientes().recuperarListaClientes();
                    break;
                case AÑADIR_LLAMADA:
                    new GestionLlamadas().añadirLlamada();
                    break;
                case MOSTRAR_LLAMADAS_CLIENTE:
                    new GestionLlamadas().recuperarListaLlamadas();
                    break;
                case EMITIR_FACTURA:
                    new GestionFacturas().emitirFactura();
                    break;
                case MOSTRAR_FACTURA_CODIGO:
                    new GestionFacturas().recuperarFacturaPorCodigo();
                    break;
                case MOSTRAR_FACTURAS_CLIENTE:
                    new GestionFacturas().recuperarFacturasDeCliente();
                    break;
                case SALIR:
                    System.out.print(Mensaje.SALIR.getMensaje());
                    System.exit(0);
            }
        }
    }
}
