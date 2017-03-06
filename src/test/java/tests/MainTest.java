package tests;

import clientes.*;
import facturas.*;
import gestion.*;
import menu.*;
import misc.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by david on 6/03/17.
 */
public class MainTest {
    GestionDatos datos = new GestionDatos();

    @Test
    public void añadirClienteEmpresaTest() {
        Empresa empresa = new Empresa();
        Direccion direccion = new Direccion();
        Tarifa tarifa = new Tarifa();
        empresa.setNif("123");
        empresa.setNombre("David");
        direccion.setCodigoPostal(12345);
        direccion.setPoblacion("A");
        direccion.setProvincia("B");
        empresa.setCorreo("al123456@uji.es");
        tarifa.setPrecio(1);
        empresa.setDireccion(direccion);
        empresa.setTarifa(tarifa);
        datos.añadirCliente(empresa);
        empresa.setNif("234");
        empresa.setNombre("Jaime");
        direccion.setCodigoPostal(23456);
        direccion.setPoblacion("B");
        direccion.setProvincia("C");
        empresa.setCorreo("al234567@uji.es");
        tarifa.setPrecio(2);
        empresa.setDireccion(direccion);
        empresa.setTarifa(tarifa);
        datos.añadirCliente(empresa);
        Map<String, Cliente> clientes = datos.getClientes();
        assertTrue(clientes.containsKey("123"));
        assertTrue(clientes.containsKey("234"));
        assertFalse(clientes.containsKey("345"));

    }

    @Test
    public void añadirClienteParticularTest() {
        Particular particular = new Particular();
        Direccion direccion = new Direccion();
        Tarifa tarifa = new Tarifa();
        particular.setNif("456");
        particular.setNombre("Alberto");
        direccion.setCodigoPostal(34567);
        direccion.setPoblacion("C");
        direccion.setProvincia("D");
        particular.setCorreo("al345678@uji.es");
        tarifa.setPrecio(3);
        particular.setDireccion(direccion);
        particular.setTarifa(tarifa);
        datos.añadirCliente(particular);
        particular.setNif("567");
        particular.setNombre("Carlos");
        direccion.setCodigoPostal(45678);
        direccion.setPoblacion("D");
        direccion.setProvincia("E");
        particular.setCorreo("al456789@uji.es");
        tarifa.setPrecio(4);
        particular.setDireccion(direccion);
        particular.setTarifa(tarifa);
        datos.añadirCliente(particular);
        Map<String, Cliente> clientes = datos.getClientes();
        assertTrue(clientes.containsKey("456"));
        assertTrue(clientes.containsKey("567"));
        assertFalse(clientes.containsKey("678"));
    }

    @Test
    public void borrarClienteTest() {
        datos.borrarCliente("234");
        datos.borrarCliente("567");
        Map<String, Cliente> clientes = datos.getClientes();
        assertFalse(clientes.containsKey("234"));
        assertFalse(clientes.containsKey("567"));
    }

    @Test
    public void cambiarTarifaTest() {
        Tarifa tarifa = new Tarifa();
        tarifa.setPrecio(5);
        datos.modificarTarifa("123", tarifa);
        Map<String, Cliente> clientes = datos.getClientes();
        Cliente cliente = clientes.get("123");
        assertEquals(tarifa.getPrecio(), cliente.getTarifa().getPrecio(),0);
        cliente = clientes.get("456");
        tarifa.setPrecio(3);
        assertEquals(tarifa.getPrecio(), cliente.getTarifa().getPrecio(),0);
    }

    @Test
    public void añadirLlamadaTest() {
        Llamada llamada = new Llamada();
        llamada.setNumero(123456789);
        llamada.setDuracion(1);
        datos.añadirLlamada("123", llamada);
        Map<String, HashSet<Llamada>> llamadas = datos.getLlamadas();
        assertTrue(llamadas.containsKey("123"));
    }

    @Test
    public void emitirFacturaTest() {
        Factura factura = new Factura();
        Tarifa tarifa = new Tarifa();
        tarifa.setPrecio(6);
        factura.setCodigoFactura(1);
        factura.setTarifaAplicada(tarifa);
        factura.setImporte(34);
        datos.emitirFactura("123");
        Map<String, HashSet<Factura>> facturasCliente = datos.getFacturasDeCliente();
        assertTrue(facturasCliente.containsKey("123"));
        Map<Integer, Factura> facturasCodigo = datos.getFacturasPorCodigo();
        assertTrue(facturasCodigo.containsKey(1));
    }

}
