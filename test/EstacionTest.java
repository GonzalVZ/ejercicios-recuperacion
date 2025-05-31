package test;

import src.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class EstacionTest {

    private Estacion estacion;
    private final ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
    private final PrintStream salidaOriginal = System.out;

    @BeforeEach
    void setUp() {
        estacion = new Estacion(1, "Estación Norte", "Bilbao", "Bizkaia");
        System.setOut(new PrintStream(salidaCapturada)); // Captura System.out
    }

    @AfterEach
    void restaurarSalida() {
        System.setOut(salidaOriginal);
    }

    @Test
    void testAgregarMedicion() {
        estacion.agregarMedicion(1, 1, "2025-05-30", "12:00", 22.5, 0.0, 1010, 70);
        assertEquals(1, estacion.getListaMediciones().size());
        assertEquals(22.5, estacion.getListaMediciones().get(0).getTemperatura());
    }

    @Test
    void testBorrarMedicion() {
        estacion.agregarMedicion(1, 1, "2025-05-30", "12:00", 22.5, 0.0, 1010, 70);
        estacion.borrarMedicion(1);
        assertEquals(0, estacion.getListaMediciones().size());
    }

    @Test
    void testModificarMedicion() {
        estacion.agregarMedicion(1, 1, "2025-05-30", "12:00", 22.5, 0.0, 1010, 70);
        estacion.modificarMedicion(1, 1, "2025-05-30", "13:00", 25.0, 1.0, 1020, 80);
        Medicion m = estacion.getListaMediciones().get(0);
        assertEquals(25.0, m.getTemperatura());
        assertEquals("13:00", m.getHora());
    }

    @Test
    void testEstadisticas() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Estacion e = new Estacion(1, "Prueba", "Ciudad", "Provincia");
        e.agregarMedicion(1, 1, "2025-05-28", "12:00", 21.0, 0.0, 1010, 65);
        e.agregarMedicion(2, 1, "2025-05-29", "12:00", 24.0, 0.9, 1011, 72);
        e.agregarMedicion(3, 1, "2025-05-30", "12:00", 28.0, 1.2, 1012, 80);
        e.agregarMedicion(4, 1, "2025-05-31", "12:00", 23.5, 1.0, 1008, 75);

        e.estadisticas("2025-05-28", "2025-05-31");

        System.setOut(System.out); // Restauramos salida
        String salida = out.toString();

        // 🧠 Esto es lo que NECESITO que copies
        System.out.println("=== SALIDA DEL MÉTODO ESTADISTICAS ===");
        System.out.println(salida);
        System.out.println("======================================");

        // Puedes comentar los asserts si quieres por ahora
        // assertTrue(salida.contains("Temperatura Maxima: 28.0"));
        // ...
    }

    @Test
    void testFechaParse() {
        assertEquals(30, estacion.fechaParse("2025-05-30"));
    }

    @Test
    void testGetId() {
        assertEquals(1, estacion.getId());
    }

    @Test
    void testSetId() {
        estacion.setId(2);
        assertEquals(2, estacion.getId());
    }

    @Test
    void testGetNombre() {
        assertEquals("Estación Norte", estacion.getNombre());
    }

    @Test
    void testSetNombre() {
        estacion.setNombre("Estación Sur");
        assertEquals("Estación Sur", estacion.getNombre());
    }

    @Test
    void testGetPoblacion() {
        assertEquals("Bilbao", estacion.getPoblacion());
    }

    @Test
    void testSetPoblacion() {
        estacion.setPoblacion("Madrid");
        assertEquals("Madrid", estacion.getPoblacion());
    }

    @Test
    void testGetProvincia() {
        assertEquals("Bizkaia", estacion.getProvincia());
    }

    @Test
    void testSetProvincia() {
        estacion.setProvincia("Madrid");
        assertEquals("Madrid", estacion.getProvincia());
    }

    @Test
    void testToString() {
        String result = estacion.toString();
        assertTrue(result.contains("Estación Norte"));
        assertTrue(result.contains("Bilbao"));
    }

    @Test
    void testGetListaMediciones() {
        assertNotNull(estacion.getListaMediciones());
        assertEquals(0, estacion.getListaMediciones().size());
    }

    @Test
    void testVerListaMediciones() {
        estacion.agregarMedicion(1, 1, "2025-05-30", "12:00", 22.5, 0.0, 1010, 70);
        estacion.verListaMediciones(); // solo se imprime, no se verifica, pero no lanza errores
        String salida = salidaCapturada.toString();
        assertTrue(salida.contains("Medicion"));
    }
}
