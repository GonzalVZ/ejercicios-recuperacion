import java.util.*;

public class Meteorologia {

    static Estacion[] listaEstaciones = new Estacion[100];

    public static void main(String[] args) {

        Meteorologia.menuPrincipal();
    }

    public static void menuPrincipal() {
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
                    Estacion.agregarMedicion();
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

}
