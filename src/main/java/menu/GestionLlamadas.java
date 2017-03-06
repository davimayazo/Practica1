package menu;

import facturas.Llamada;
import gestion.GestionDatos;
import misc.Mensaje;
import misc.MostrarDatos;
import misc.PedirDatos;

import java.util.*;

/**
 * Created by david on 6/03/17.
 */
public class GestionLlamadas {

    private PedirDatos pedir;
    private MostrarDatos mostrar;

    public GestionLlamadas() {
        pedir = new PedirDatos();
        mostrar = new MostrarDatos();
    }

    public void añadirLlamada() {
        String nif = pedir.pedirDatos("NIF");

        if(GestionDatos.getClientes().containsKey(nif)) {
            Llamada llamada = new Llamada();
            String dato;

            dato = pedir.pedirDatos("número de teléfono");
            llamada.setNumero(Integer.parseInt(dato));

            dato = pedir.pedirDatos("duración de la llamada");
            llamada.setDuracion(Double.parseDouble(dato));

            GestionDatos.añadirLlamada(nif, llamada);
            mostrar.mostrarDatos(Mensaje.LLAMADA_CREADO);
        }
        else {
            mostrar.mostrarDatos(Mensaje.CLIENTE_NO_LLAMADAS);
        }
    }

    public void recuperarListaLlamadas() {
        if(!GestionDatos.getLlamadas().isEmpty()) {
            String nif = pedir.pedirDatos("NIF");

            if(GestionDatos.getLlamadas().containsKey(nif)) {
                HashSet<Llamada> listaLlamadas = GestionDatos.recuperarListaLlamadas(nif);
                mostrar.mostrarDatos(Mensaje.LISTA_LLAMADAS);
                for(Llamada llamada: listaLlamadas) {
                    mostrar.mostrarDatos(llamada);
                }
            }
            else {
                System.out.print(Mensaje.CLIENTE_NO_LLAMADAS);
            }
        }
        else {
            mostrar.mostrarDatos(Mensaje.LLAMADAS_VACÍO);
        }
    }

}
