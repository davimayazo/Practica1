package facturas;

/**
 * Created by david on 3/03/17.
 */
public class Tarifa {

    private double precio;

    public Tarifa() {
    }

    public Tarifa(Tarifa tarifa) {
        this.precio = tarifa.precio;
    }

    public Tarifa(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        StringBuilder tarifa = new StringBuilder();
        tarifa.append("Precio: " + precio + "\n");

        return tarifa.toString();
    }

}
