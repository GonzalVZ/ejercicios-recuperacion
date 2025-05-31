package src;

import java.util.*;

public class Estacion {
    private int id;
    private String nombre;
    private String poblacion;
    private String provincia;

    public List<Medicion> listaMediciones = new ArrayList<>();

    public int fechaParse(String fecha) {

        int fechaParseada = Integer.parseInt(fecha.substring(8, 10));

        return fechaParseada;
    }

    public void estadisticas(String fechaInicio, String fechaFin) {
        double temperaturaMaxima = Double.NEGATIVE_INFINITY;
        double temperaturaMinima = Double.POSITIVE_INFINITY;
        double temperaturaMedia = 0;
        double precipitacionMaxima = Double.NEGATIVE_INFINITY;
        double precipitacionMinima = Double.POSITIVE_INFINITY;
        double precipitacionTotal = 0;
        double humedadMaxima = Double.NEGATIVE_INFINITY;
        double humedadMinima = Double.POSITIVE_INFINITY;
        double humedadMedia = 0;
        int contador = 0;
        for (int i = 0; i < listaMediciones.size(); i++) {

            if (fechaParse(listaMediciones.get(i).getFecha()) >= fechaParse(fechaInicio)
                    && fechaParse(listaMediciones.get(i).getFecha()) <= fechaParse(fechaFin)) {
                contador++;

                temperaturaMedia = temperaturaMedia + listaMediciones.get(i).getTemperatura();

                if (listaMediciones.get(i).getTemperatura() >= temperaturaMaxima) {

                    temperaturaMaxima = listaMediciones.get(i).getTemperatura();

                }
                if (listaMediciones.get(i).getTemperatura() <= temperaturaMinima) {

                    temperaturaMinima = listaMediciones.get(i).getTemperatura();

                }
                precipitacionTotal = precipitacionTotal + listaMediciones.get(i).getPrecipitacion();

                if (listaMediciones.get(i).getPrecipitacion() > precipitacionMaxima) {

                    precipitacionMaxima = listaMediciones.get(i).getPrecipitacion();

                }
                if (listaMediciones.get(i).getPrecipitacion() < precipitacionMinima) {

                    precipitacionMinima = listaMediciones.get(i).getPrecipitacion();

                }
                humedadMedia = humedadMedia + listaMediciones.get(i).getHumedad();

                if (listaMediciones.get(i).getHumedad() > humedadMaxima) {

                    humedadMaxima = listaMediciones.get(i).getHumedad();

                }
                if (listaMediciones.get(i).getHumedad() < humedadMinima) {

                    humedadMinima = listaMediciones.get(i).getHumedad();

                }

            }

        }
        temperaturaMedia = temperaturaMedia / contador;
        System.out.println("Temperatura Maxima: " + temperaturaMaxima + "Temperatura Minima: " + temperaturaMinima
                + "Temperatura Media: " + temperaturaMedia + "\n");

        System.out.println("Precipitacion Maxima: " + precipitacionMaxima + "Precipìtacion Minima: "
                + precipitacionMinima + "Precipitacion Total: "
                + precipitacionTotal + "\n");

        humedadMedia = humedadMedia / contador;
        System.out.println("Humedad Maxima: " + humedadMaxima + "Humedad Minima: " + humedadMinima + "Humedad Media: "
                + humedadMedia + "\n");

    }

    public void agregarMedicion(int id, int idEstacion, String fecha, String hora, double temperatura,
            double precipitacion, double presion, double humedad) {

        Medicion m = new Medicion(id, idEstacion, fecha, hora, temperatura, precipitacion, presion,
                humedad);

        listaMediciones.add(m);

    }

    public void verListaMediciones() {

        for (int i = 0; i < listaMediciones.size(); i++) {

            System.out.println(listaMediciones.get(i).toString());
        }

    }

    public void modificarMedicion(int id, int idEstacion, String fecha, String hora, double temperatura,
            double precipitacion, double presion, double humedad) {

        for (int i = 0; i < listaMediciones.size(); i++) {

            if (listaMediciones.get(i).getId() == id) {

                listaMediciones.set(i, new Medicion(id, idEstacion, fecha, hora, temperatura, precipitacion, presion,
                        humedad));
            }
        }

    }

    public void borrarMedicion(int id) {

        for (int i = 0; i < listaMediciones.size(); i++) {

            if (listaMediciones.get(i).getId() == id) {

                listaMediciones.remove(i);
            }

        }

    }

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

    public List<Medicion> getListaMediciones() {
        return listaMediciones;
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
