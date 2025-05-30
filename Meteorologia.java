import java.util.*;

public class Meteorologia {

    Estacion[] listaEstaciones = new Estacion[100];

    public void main(String[] args) {

        menuPrincipal();
    }

    public static void estadisticas() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe el ID de la estación: ");
        int idEstacion = Integer.parseInt(sc.nextLine());

        System.out.print("Escribe el ID de la estación: ");
        String fechaInicio = sc.nextLine();

        System.out.print("Escribe el ID de la estación: ");
        String fechaFin = sc.nextLine();

        for (int i = 0; i < Meteorologia.listaEstaciones.length; i++) {

            if (Meteorologia.listaEstaciones[i] == null) {

            } else if (Meteorologia.listaEstaciones[i].getId() == idEstacion) {
                System.out
                        .println(Meteorologia.listaEstaciones[i].toString() + "\n");

            }

        }
        double temperaturaMaxima = 0;
        double temperaturaMinima = 0;
        double temperaturaMedia;
        double precipitacionMaxima;
        double precipitacionMinima;
        double precipitacionTotal;
        double humedadMaxima;
        double humedadMinima;
        double humedadMedia;

        for (int i = 0; i < Estacion.listaMediciones.size(); i++) {

            if (Estacion.listaMediciones.get(i).getIdEstacion() == idEstacion) {
                if (temperaturaMaxima < Estacion.listaMediciones.get(i).getTemperatura()) {

                    temperaturaMaxima = Estacion.listaMediciones.get(i).getTemperatura();

                }
                if (temperaturaMinima > Estacion.listaMediciones.get(i).get) {

                    temperaturaMinima = Estacion.listaMediciones.get(i).getTemperatura();

                }
            }
        }

    }

    public void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int respuesta = 1;
        boolean centinela = false;

        Meteorologia.listaEstaciones[0] = new Estacion(1, "Estación Norte", "Bilbao", "Bizkaia");

        while (respuesta != 0) {

            while (!centinela) {
                try {
                    System.out.println(
                            " 1. Ver lista de estaciones \n 2. Ver lista de mediciones \n 3. Añadir medición \n 4. Borrar medición \n 5. Modificar medición \n 6. Estadísticas \n 0. Salir \n ¿Qué desea hacer? (0-6) _");
                    respuesta = Integer.parseInt(sc.nextLine());

                    centinela = true;

                    if (respuesta < 0 || respuesta > 6) {
                        centinela = false;
                        System.out.println("El numero tiene que ser entre 0-6");
                    }

                } catch (Exception e) {
                    System.out.println("Incorrecto");

                }
            }

            switch (respuesta) {
                case 1:
                    Meteorologia.verListaEstaciones();

                    break;

                case 2:
                    Meteorologia.verListaMediciones();

                    break;

                case 3:
                    agregarMedicion();
                    break;

                case 4:
                    Estacion.borrarMedicion();
                    break;
                case 5:
                    Estacion.modificarMedicion();
                    break;
                case 0:
                    System.out.println("Fin del programa");
                    break;
            }
            centinela = false;
        }
        sc.close();

    }

    public static void verListaEstaciones() {

        for (int i = 0; i < Meteorologia.listaEstaciones.length; i++) {

            if (Meteorologia.listaEstaciones[i] == null) {
                System.out.println("Vacio" + "\n");

            } else {
                System.out
                        .println(Meteorologia.listaEstaciones[i].toString() + "\n");
            }

        }

    }

    public static void verListaMediciones() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el ID de la estación de las mediciones que quieres consultar:");
        int id = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < Meteorologia.listaEstaciones.length; i++) {

            if (Meteorologia.listaEstaciones[i] == null) {

            } else if (Meteorologia.listaEstaciones[i].getId() == id) {
                System.out.println(Meteorologia.listaEstaciones[i].toString());
            }
        }
        for (int i = 0; i < Estacion.listaMediciones.size(); i++) {

            if (Estacion.listaMediciones.get(i).getIdEstacion() == id) {
                System.out.println(Estacion.listaMediciones.get(i).toString());

            }
        }
        sc.close();

    }

    public void agregarMedicion() {
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
        Estacion e = encontrarEstacion(idEstacion);
        e.agregarMedicion(id, idEstacion, fecha, hora, temperatura,
                precipitacion, presion, humedad);

        sc.close();

    }

    public Estacion encontrarEstacion(int idEstacion) {
        for (int i = 0; i < listaEstaciones.length; i++) {

            if (listaEstaciones[i] == null) {

            } else if (listaEstaciones[i].getId() == idEstacion) {
                return listaEstaciones[i];

            }

        }
        return null;
    }

}
