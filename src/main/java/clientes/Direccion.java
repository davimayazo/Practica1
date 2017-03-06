package clientes;

/**
 * Created by david on 3/03/17.
 */
public class Direccion {

    private int codigoPostal;
    private String poblacion;
    private String provincia;

    public Direccion() {

    }

    public Direccion(int codigoPostal, String poblacion, String provincia) {
        this.codigoPostal = codigoPostal;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        StringBuilder direccion = new StringBuilder();
        direccion.append(codigoPostal);
        direccion.append(" ");
        direccion.append(poblacion);
        direccion.append(", ");
        direccion.append(provincia);

        return direccion.toString();
    }
}
