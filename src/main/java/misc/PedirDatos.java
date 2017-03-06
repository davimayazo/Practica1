package misc;

import java.util.Scanner;

/**
 * Created by david on 6/03/17.
 */
public class PedirDatos {

    private MostrarDatos mostrar;
    private LeerDatos leer;

    public PedirDatos() {
        mostrar = new MostrarDatos();
        leer = new LeerDatos();
    }

    public String pedirDatos(String dato) {
        Scanner scanner = new Scanner(System.in);
        mostrar.mostrarDatos("Introduce " + dato + ": ");

        return leer.leerDatos();
    }

}
