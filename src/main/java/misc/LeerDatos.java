package misc;

import java.util.Scanner;

/**
 * Created by david on 6/03/17.
 */
public class LeerDatos {

    private Scanner scanner;

    public LeerDatos() {
        scanner = new Scanner(System.in);
    }

    public String leerDatos() {
        return scanner.nextLine();
    }

}
