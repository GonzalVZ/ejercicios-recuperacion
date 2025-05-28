import java.util.*;

public class Meteorologia {

    public static void main(String[] args) {

        Meteorologia.menuPrincipal();
    }

    public static void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int respuesta = 0;
        boolean centinela = false;

        while (!centinela) {
            try {
                System.out.println(
                        " 1.. Ver lista de estaciones \n 2. Ver lista de mediciones \n 3. Añadir medición \n 4. Borrar medición \n 5. Modificar medición \n 6. Estadísticas \n 0. Salir \n ¿Qué desea hacer? (0-6) _");
                respuesta = sc.nextInt();

                centinela = true;

                if (respuesta < 0 || respuesta > 6) {
                    centinela = false;
                    System.out.println("El numero tiene que ser entre 0-6");
                }

            } catch (Exception e) {
                System.out.println("Incorrecto");
                sc.nextLine();
            }
        }

        switch (respuesta) {
            case 1:
                Meteorologia.verListaEstaciones();

                break;

            case 2:
                Meteorologia.verListaMediciones();

                break;

            case 0:
                System.out.println("Fin del programa");
                break;
        }

        sc.close();

    }

    public static void verListaEstaciones() {
        Estacion e1 = new Estacion(1, "Estación Norte", "Bilbao", "Bizkaia");
        Estacion e2 = new Estacion(e1);

        System.out.println(e1 + "\n" + e2);

    }

    public static void verListaMediciones() {

        System.out.println("En Desarrollo");

    }

}
