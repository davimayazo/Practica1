package menu;

import clientes.*;
import facturas.Tarifa;
import gestion.GestionDatos;
import misc.*;

import java.util.*;

/**
 * Created by david on 6/03/17.
 */
public class GestionClientes {

    private PedirDatos pedir;
    private MostrarDatos mostrar;

    public GestionClientes() {
        pedir = new PedirDatos();
        mostrar = new MostrarDatos();
    }

//    public void añadirCliente() {
//        while(true) {
//            System.out.println(MenuClientes.getMenuClientes());
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Elige una opción: ");
//            byte opcion = scanner.nextByte();
//            MenuClientes opcionMenu = MenuClientes.getOpcion(opcion);
//            switch(opcionMenu) {
//                case AÑADIR_EMPRESA:
//                    añadirEmpresa();
//                    break;
//                case AÑADIR_PARTICULAR:
//                    añadirParticular();
//                    break;
//                case SALIR_MENU:
//                    System.out.println(Menu.getMenu());
//                    break;
//                default:
//                    System.out.print("Opción incorrecta.\n");
//                    break;
//            }
//        }
//    }

    public void añadirCliente() {
        mostrar.mostrarDatos(Mensaje.MENU_CLIENTES);
        mostrar.mostrarDatos("1.- " + Mensaje.TIPO_EMPRESA + "\n");
        mostrar.mostrarDatos("2.- " + Mensaje.TIPO_PARTICULAR + "\n");

        int opcion = Integer.parseInt(pedir.pedirDatos("opción"));
        switch(opcion) {
            case 1:
                añadirEmpresa();
                break;
            case 2:
                añadirParticular();
                break;
            default:
                break;
        }
    }

    public void añadirEmpresa() {
        Empresa empresa = new Empresa();
        Direccion direccion = new Direccion();
        Tarifa tarifa = new Tarifa();
        String dato;

        dato = pedir.pedirDatos("NIF");
        empresa.setNif(dato);

        if(!GestionDatos.getClientes().containsKey(dato)) {
            dato = pedir.pedirDatos("nombre");
            empresa.setNombre(dato);

            dato = pedir.pedirDatos("código postal");
            direccion.setCodigoPostal(Integer.parseInt(dato));

            dato = pedir.pedirDatos("población");
            direccion.setPoblacion(dato);

            dato = pedir.pedirDatos("provincia");
            direccion.setProvincia(dato);
            empresa.setDireccion(direccion);

            dato = pedir.pedirDatos("correo electrónico");
            empresa.setCorreo(dato);

            dato = pedir.pedirDatos("tarifa");
            tarifa.setPrecio(Double.parseDouble(dato));
            empresa.setTarifa(tarifa);

            GestionDatos.añadirCliente(empresa);
            mostrar.mostrarDatos(Mensaje.CLIENTE_CREADO);
        }
        else {
            mostrar.mostrarDatos(Mensaje.CLIENTE_EXISTE);
        }
    }

    public void añadirParticular() {
        Particular particular = new Particular();
        Direccion direccion = new Direccion();
        Tarifa tarifa = new Tarifa();
        String dato;

        dato = pedir.pedirDatos("NIF");
        particular.setNif(dato);

        if(!GestionDatos.getClientes().containsKey(dato)) {
            dato = pedir.pedirDatos("nombre");
            particular.setNombre(dato);

            dato = pedir.pedirDatos("apellidos");
            particular.setApellidos(dato);

            dato = pedir.pedirDatos("código postal");
            direccion.setCodigoPostal(Integer.parseInt(dato));

            dato = pedir.pedirDatos("población");
            direccion.setPoblacion(dato);

            dato = pedir.pedirDatos("provincia");
            direccion.setProvincia(dato);
            particular.setDireccion(direccion);

            dato = pedir.pedirDatos("correo electrónico");
            particular.setCorreo(dato);

            dato = pedir.pedirDatos("tarifa");
            tarifa.setPrecio(Double.parseDouble(dato));
            particular.setTarifa(tarifa);

            GestionDatos.añadirCliente(particular);
            mostrar.mostrarDatos(Mensaje.CLIENTE_CREADO);
        }
        else {
            mostrar.mostrarDatos(Mensaje.CLIENTE_EXISTE);
        }
    }

    public void borrarCliente() {
        if(!GestionDatos.getClientes().isEmpty()) {
            String nif = pedir.pedirDatos("NIF");

            if(GestionDatos.getClientes().containsKey(nif)) {
                GestionDatos.borrarCliente(nif);
                mostrar.mostrarDatos(Mensaje.CLIENTE_BORRADO);
            }
            else {
                mostrar.mostrarDatos(Mensaje.CLIENTE_NO_EXISTE);
            }
        }
        else {
            mostrar.mostrarDatos(Mensaje.CLIENTES_VACÍO);
        }
    }

    public void modificarTarifa() {
        if (!GestionDatos.getClientes().isEmpty()) {
            String nif = pedir.pedirDatos("NIF");

            if(GestionDatos.getClientes().containsKey(nif)) {
                Tarifa tarifa = new Tarifa();
                String precio = pedir.pedirDatos("tarifa");
                tarifa.setPrecio(Double.parseDouble(precio));

                GestionDatos.modificarTarifa(nif, tarifa);
                mostrar.mostrarDatos(Mensaje.CLIENTE_TARIFA.getMensaje());
            }
            else {
                mostrar.mostrarDatos(Mensaje.CLIENTE_NO_EXISTE);
            }
        }
        else {
            mostrar.mostrarDatos(Mensaje.CLIENTES_VACÍO);
        }

    }

    public void recuperarDatosCliente() {
        if(!GestionDatos.getClientes().isEmpty()) {
            String nif = pedir.pedirDatos("NIF");

            if (GestionDatos.getClientes().containsKey(nif)) {
                mostrar.mostrarDatos(GestionDatos.recuperarDatosCliente(nif));
            }
            else {
                mostrar.mostrarDatos(Mensaje.CLIENTE_NO_EXISTE);
            }
        }
        else {
            mostrar.mostrarDatos(Mensaje.CLIENTES_VACÍO);
        }
    }

    public void recuperarListaClientes() {
        if (!GestionDatos.getClientes().isEmpty()) {
            TreeMap<String, Cliente> listaClientes = GestionDatos.recuperarListaClientes();
            mostrar.mostrarDatos(Mensaje.LISTA_CLIENTES);
            for (Cliente cliente : listaClientes.values()) {
                mostrar.mostrarDatos(cliente);
            }
        }
        else {
            mostrar.mostrarDatos(Mensaje.CLIENTES_VACÍO);
        }
    }

}
