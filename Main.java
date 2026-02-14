import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AcademiaSistema sistema = new AcademiaSistema();
        sistema.iniciar();
    }
}


class AcademiaSistema {
    private final ArrayList<Alumno> alumnos = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {
        while (true) {
            mostrarMenu();
            int opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1 -> inscribir();
                case 2 -> listar();
                case 3 -> buscarPorCarnet();
                case 4 -> {
                    System.out.println("Saliendo... ✅");
                    return;
                }
                default -> System.out.println("Opción inválida. Intenta de nuevo.");
            }
            System.out.println();
        }
    }

    private void mostrarMenu() {
        System.out.println("===== ACADEMIA (Consola) =====");
        System.out.println("1) Inscribir alumno");
        System.out.println("2) Listar alumnos");
        System.out.println("3) Buscar alumno por carnet");
        System.out.println("4) Salir");
    }

    private void inscribir() {
        System.out.println("=== Inscribir Alumno ===");

        String nombre = leerTexto("Nombre: ");
        int edad = leerEntero("Edad: ");
        String carnet = leerTexto("Carnet: ");
        double promedio = leerDouble("Promedio: ");

        
        if (existeCarnet(carnet)) {
            System.out.println("❌ Ya existe un alumno con ese carnet. No se inscribió.");
            return;
        }

        Alumno nuevo = new Alumno(nombre, edad, carnet, promedio);
        alumnos.add(nuevo);
        System.out.println("✅ Alumno inscrito correctamente.");
    }

    private void listar() {
        System.out.println("=== Listado de Alumnos ===");

        if (alumnos.isEmpty()) {
            System.out.println("(No hay alumnos inscritos)");
            return;
        }

        for (Alumno a : alumnos) {
            System.out.println(a);
        }
    }

    private void buscarPorCarnet() {
        System.out.println("=== Buscar por Carnet ===");
        String carnet = leerTexto("Carnet a buscar: ");

        Alumno encontrado = obtenerPorCarnet(carnet);
        if (encontrado == null) {
            System.out.println("❌ No se encontró ningún alumno con ese carnet.");
        } else {
            System.out.println("✅ Encontrado: " + encontrado);
        }
    }

    private boolean existeCarnet(String carnet) {
        return obtenerPorCarnet(carnet) != null;
    }

    private Alumno obtenerPorCarnet(String carnet) {
        for (Alumno a : alumnos) {
            if (a.getCarnet().equalsIgnoreCase(carnet)) {
                return a;
            }
        }
        return null;
    }

   
    private String leerTexto(String msg) {
        System.out.print(msg);
        String s = sc.nextLine().trim();
        while (s.isEmpty()) {
            System.out.print("No puede ir vacío. " + msg);
            s = sc.nextLine().trim();
        }
        return s;
    }

    private int leerEntero(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número entero válido.");
            }
        }
    }

    private double leerDouble(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número válido (ej: 85.5).");
            }
        }
    }
}
