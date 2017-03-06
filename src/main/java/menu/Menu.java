package menu;

import misc.Mensaje;

/**
 * Created by david on 3/03/17.
 */
public enum Menu {

    AÑADIR_CLIENTE("Dar de alta un nuevo cliente"),
    BORRAR_CLIENTE("Borrar un cliente"),
    CAMBIAR_TARIFA("Cambiar la tarifa de un cliente"),
    MOSTRAR_DATOS_NIF("Recuperar los datos de un cliente a partir de su NIF"),
    MOSTRAR_CLIENTES("Recuperar el listado de todos los clientes"),
    AÑADIR_LLAMADA("Dar de alta una llamada"),
    MOSTRAR_LLAMADAS_CLIENTE("Listar todas las llamadas de un cliente"),
    EMITIR_FACTURA("Emitir una factura para un cliente"),
    MOSTRAR_FACTURA_CODIGO("Recuperar los datos de una factura a partir de su código"),
    MOSTRAR_FACTURAS_CLIENTE("Recuperar todas las facturas de un cliente"),
    SALIR("Salir.");

    private String descripcion;

    private Menu(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static Menu getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(Mensaje.MENU_GESTION.getMensaje());
        for(Menu opcion: Menu.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }

        return sb.toString();
    }

}
