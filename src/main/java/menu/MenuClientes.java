package menu;

/**
 * Created by david on 5/03/17.
 */
public enum MenuClientes {

    AÑADIR_EMPRESA("Dar de alta una empresa"),
    AÑADIR_PARTICULAR("Dar de alta un particular"),
    SALIR_MENU("Salir al menú principal");

    private String descripcion;

    private MenuClientes(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static MenuClientes getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenuClientes() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nMENÚ DE CREACIÓN DE CLIENTES\n");
        for(MenuClientes opcion: MenuClientes.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }

        return sb.toString();
    }
}
