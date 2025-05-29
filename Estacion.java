import java.util.*;

public class Estacion {
    private int id;
    private String nombre;
    private String poblacion;
    private String provincia;

    static List<Medicion> listaMediciones = new ArrayList<>();

    public static void agregarMedicion() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe el ID de la estación: ");
        int idEstacion = Integer.parseInt(sc.nextLine());
        System.out.print("Escribe el ID de la medicion: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Escribe la fecha (YYYY-MM-DD): ");
        String fecha = sc.nextLine();

        System.out.print("Escribe la hora (HH:MM): ");
        String hora = sc.nextLine();

        System.out.print("Escribe la temperatura: ");
        double temperatura = Double.parseDouble(sc.nextLine());

        System.out.print("Escribe la precipitación: ");
        double precipitacion = Double.parseDouble(sc.nextLine());

        System.out.print("Escribe la presión: ");
        double presion = Double.parseDouble(sc.nextLine());

        System.out.print("Escribe la humedad: ");
        double humedad = Double.parseDouble(sc.nextLine());

        Medicion m = new Medicion(id, idEstacion, fecha, hora, temperatura, precipitacion, presion,
                humedad);

        Estacion.listaMediciones.add(m);

    }

    public static void modificarMedicion() {
        Scanner sc = new Scanner(System.in);
        int numero = 1;

        System.out.print("Escribe el ID de la estación: ");
        int idEstacion = Integer.parseInt(sc.nextLine());

        System.out.println("Estan son las Mediciones que tiene: \n");
        for (int i = 0; i < Estacion.listaMediciones.size(); i++) {

            if (Estacion.listaMediciones.get(i).getIdEstacion() == idEstacion) {
                System.out.println(Estacion.listaMediciones.get(i).toString() + "\n");

            }

        }
        while (numero != 0) {
            System.out.println("Escribe el id de la medicion que quieres modificar: ");

            int id = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < Estacion.listaMediciones.size(); i++) {

                if (Estacion.listaMediciones.get(i).getId() == id) {

                    System.out.print("Escribe el ID de la estación: ");
                    idEstacion = Integer.parseInt(sc.nextLine());

                    System.out.print("Escribe la fecha (YYYY-MM-DD): ");
                    String fecha = sc.nextLine();

                    System.out.print("Escribe la hora (HH:MM): ");
                    String hora = sc.nextLine();

                    System.out.print("Escribe la temperatura: ");
                    double temperatura = Double.parseDouble(sc.nextLine());

                    System.out.print("Escribe la precipitación: ");
                    double precipitacion = Double.parseDouble(sc.nextLine());

                    System.out.print("Escribe la presión: ");
                    double presion = Double.parseDouble(sc.nextLine());

                    System.out.print("Escribe la humedad: ");
                    double humedad = Double.parseDouble(sc.nextLine());

                    Medicion m = new Medicion(Estacion.listaMediciones.get(i).getId(), idEstacion, fecha, hora,
                            temperatura, precipitacion, presion, humedad);

                    Estacion.listaMediciones.set(i, m);

                }

            }

            System.out.println("Si no quieres modificar ninguno mas escribe 0, si quieres seguir escribe 1");

            numero = Integer.parseInt(sc.nextLine());

        }

    }

    public static void borrarMedicion() {
        Scanner sc = new Scanner(System.in);
        int numero = 1;
        System.out.print("Escribe el ID de la estación: ");
        int idEstacion = Integer.parseInt(sc.nextLine());

        System.out.println("Estan son las Mediciones que tiene: \n");
        for (int i = 0; i < Estacion.listaMediciones.size(); i++) {

            if (Estacion.listaMediciones.get(i).getIdEstacion() == idEstacion) {
                System.out.println(Estacion.listaMediciones.get(i).toString() + "\n");

            }

        }

        while (numero != 0) {
            System.out.println("Escribe el id de la medicion que quieres borrar: ");

            int id = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < Estacion.listaMediciones.size(); i++) {

                if (Estacion.listaMediciones.get(i).getId() == id) {

                    Estacion.listaMediciones.remove(i);
                }

            }

            System.out.println("Si no quieres borrar ninguno mas escribe 0, si quieres seguir escribe 1");

            numero = Integer.parseInt(sc.nextLine());

        }

    }

    /*
     * public static int lastId() {
     * int idMasAlto = 0;
     * int id;
     * 
     * for (int i = 0; i < Estacion.listaMediciones.size(); i++) {
     * 
     * id = Estacion.listaMediciones.get(i).getId();
     * if (id > idMasAlto) {
     * idMasAlto = id;
     * 
     * }
     * }
     * 
     * return idMasAlto;
     *
     * 
     * }
     */

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
