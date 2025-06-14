package src;

import java.io.*;
import java.util.*;

public class Meteorologia {

    public static Estacion[] listaEstaciones = new Estacion[5];

    public static void main(String[] args) {
        Meteorologia.menuPrincipal();
    }

    public static void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int respuesta = 1;
        boolean centinela = false;

        Meteorologia.rellenarDatosPrueba();

        while (respuesta != 0) {

            while (!centinela) {
                try {
                    System.out.println(
                            " 1. Ver lista de estaciones \n 2. Ver lista de mediciones \n 3. Añadir medición \n 4. Borrar medición \n 5. Modificar medición \n 6. Estadísticas \n 7.Escribir Estaciones en el fichero \n 8.Cargar Estaciones del fichero\n 9.Escribir Mediciones en el fichero\n 10.Cargar Mediciones del fichero\n 0. Salir \n ¿Qué desea hacer? (0-6) _");
                    respuesta = Integer.parseInt(sc.nextLine());

                    centinela = true;

                    if (respuesta < 0 || respuesta > 10) {
                        centinela = false;
                        System.out.println("El numero tiene que ser entre 0-10");
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
                    Meteorologia.agregarMedicion();
                    break;

                case 4:
                    Meteorologia.borrarMedicion();
                    break;
                case 5:
                    Meteorologia.modificarMedicion();
                    break;
                case 6:
                    Meteorologia.estadisticas();
                    break;
                case 7:

                    Meteorologia.escribirFichero();
                    break;
                case 8:

                    Meteorologia.cargarFichero();
                    break;
                case 9:
                    System.out.println("Indice de Estacion");
                    int r = Integer.parseInt(sc.nextLine());
                    listaEstaciones[r].escribirMediciones();
                    break;
                case 10:

                    System.out.println("Indice de Estacion");

                    r = Integer.parseInt(sc.nextLine());

                    listaEstaciones[r].cargarMediciones();
                    break;

                case 0:
                    System.out.println("Fin del programa");
                    break;
            }
            centinela = false;
        }

    }

    public static void rellenarDatosPrueba() {
        Estacion e = new Estacion(1, "Estación Prueba", "PruebaCiudad", "PruebaProvincia");

        e.agregarMedicion(1, 1, "21", "10:00", 20.5, 0.5, 1010, 60);
        e.agregarMedicion(2, 1, "22", "11:00", 22.0, 0.0, 1012, 65);
        e.agregarMedicion(3, 1, "23", "12:00", 24.0, 1.0, 1015, 70);
        e.agregarMedicion(4, 1, "24", "13:00", 25.5, 0.3, 1013, 72);
        e.agregarMedicion(5, 1, "25", "14:00", 23.5, 0.0, 1011, 68);
        e.agregarMedicion(6, 1, "26", "15:00", 21.0, 0.7, 1009, 66);
        e.agregarMedicion(7, 1, "27", "16:00", 26.0, 1.2, 1008, 75);
        e.agregarMedicion(8, 1, "28", "17:00", 27.5, 0.0, 1007, 80);
        e.agregarMedicion(9, 1, "29", "18:00", 28.0, 0.0, 1005, 78);
        e.agregarMedicion(10, 1, "30", "19:00", 24.5, 0.4, 1006, 70);

        listaEstaciones[0] = e;

        System.out.println("Estación de prueba y 10 mediciones añadidas correctamente.");
    }

    public static void modificarMedicion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el ID de la estación: ");
        int idEstacion = Integer.parseInt(sc.nextLine());

        Estacion e = Meteorologia.encontrarEstacion(idEstacion);

        e.verListaMediciones();

        System.out.println("Estas son las mediciones escribe el id de la que quieres modificar: ");

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

        e.modificarMedicion(id, idEstacion, fecha, hora, temperatura,
                precipitacion, presion, humedad);

    }

    public static void borrarMedicion() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe el ID de la estación: ");
        int idEstacion = Integer.parseInt(sc.nextLine());

        Estacion e = Meteorologia.encontrarEstacion(idEstacion);

        System.out.println("Estas son las mediciones escribe el id de la que quieres borrar: ");

        e.verListaMediciones();

        int id = Integer.parseInt(sc.nextLine());

        e.borrarMedicion(id);

    }

    public static void verListaEstaciones() {

        for (int i = 0; i < Meteorologia.listaEstaciones.length; i++) {

            if (Meteorologia.listaEstaciones[i] == null) {
                System.out.println("Vacio" + "\n");

            } else {
                System.out.println(Meteorologia.listaEstaciones[i].toString() + "\n");
            }

        }

    }

    public static void verListaMediciones() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe el ID de la estación: ");
        int idEstacion = Integer.parseInt(sc.nextLine());

        Estacion e = Meteorologia.encontrarEstacion(idEstacion);

        e.verListaMediciones();

    }

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
        Estacion e = Meteorologia.encontrarEstacion(idEstacion);
        e.agregarMedicion(id, idEstacion, fecha, hora, temperatura,
                precipitacion, presion, humedad);

    }

    public static Estacion encontrarEstacion(int idEstacion) {
        for (int i = 0; i < Meteorologia.listaEstaciones.length; i++) {

            if (Meteorologia.listaEstaciones[i] == null) {

            } else if (Meteorologia.listaEstaciones[i].getId() == idEstacion) {
                return Meteorologia.listaEstaciones[i];

            }

        }
        return null;
    }

    public static void estadisticas() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe el ID de la estación: ");
        int idEstacion = Integer.parseInt(sc.nextLine());

        System.out.print("Escribe la fecha de inicio: ");
        String fechaInicio = sc.nextLine();

        System.out.print("Escribe la fecha de fin: ");
        String fechaFin = sc.nextLine();

        Estacion e = Meteorologia.encontrarEstacion(idEstacion);

        e.estadisticas(fechaInicio, fechaFin);

    }

    public static void escribirFichero() {

        try {
            FileWriter fw = new FileWriter("estaciones.csv");

            for (int i = 0; i < listaEstaciones.length; i++) {

                if (listaEstaciones[i] == null) {
                    break;

                }

                fw.write(listaEstaciones[i].getNombre() + ";" + listaEstaciones[i].getPoblacion() + ";"
                        + listaEstaciones[i].getProvincia() + "\n");

            }
            fw.close();

        } catch (Exception e) {

            System.out.println("Error");
        }

    }

    public static void cargarFichero() {
        String linea;
        int contador = 0;
        String palabra = "";
        char letra;
        int contador1 = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("estaciones.csv"));

            while ((linea = br.readLine()) != null) {

                Estacion e = new Estacion();

                for (int i = 0; i < linea.length(); i++) {
                    letra = linea.charAt(i);

                    if (letra == ';') {

                        palabra = "";
                        contador++;

                    } else if (contador == 0) {
                        palabra = palabra + letra;

                        e.setNombre(palabra);
                        Meteorologia.listaEstaciones[contador1] = e;

                    } else if (contador == 1) {
                        palabra = palabra + letra;
                        e.setPoblacion(palabra);
                        Meteorologia.listaEstaciones[contador1] = e;

                    } else if (contador == 2) {
                        palabra = palabra + letra;
                        e.setProvincia(palabra);

                        Meteorologia.listaEstaciones[contador1] = e;

                    }

                }
                e.setId(contador1 + 1);
                palabra = "";
                contador = 0;
                contador1++;

            }

            br.close();

        } catch (Exception e) {

            System.out.println("Error");
        }

    }

}
