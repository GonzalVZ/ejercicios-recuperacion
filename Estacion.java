public class Estacion {
    private int id;
    private String nombre;
    private String poblacion;
    private String provincia;

    public Estacion() {

    }

    public Estacion(int id, String nombre, String poblacion, String provincia) {
        this.id = id;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.provincia = provincia;

    }

    public Estacion(Estacion copia) {
        this.id = copia.id;
        this.nombre = copia.nombre;
        this.poblacion = copia.poblacion;
        this.provincia = copia.provincia;
    }

    @Override
    public String toString() {
        return "ID: " + id + " NOMBRE: " + nombre + " POBLACION: " + poblacion + " PROVINCIA: " + provincia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

}
