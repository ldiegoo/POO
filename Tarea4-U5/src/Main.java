import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String NOMBRE_ARCHIVO = "tarea4-U5.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    escribirTarea(scanner);
                    break;
                case 2:
                    leerTareas();
                    break;
                case 3:
                    System.out.println("** Programa terminado **");
                    break;
                default:
                    System.out.println("|| Opción no válida. Intente de nuevo ||");
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Escribir tarea");
        System.out.println("2. Leer tareas");
        System.out.println("3. Terminar");
        System.out.print("Elija una opción: ");
    }

    private static void escribirTarea(Scanner scanner) {
        System.out.print("Ingrese la tarea: ");
        String tarea = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            writer.write(tarea);
            writer.newLine();
            System.out.println("|| Tarea guardada con éxito ||");
        } catch (IOException e) {
            System.out.println("** Ocurrió un error al guardar la tarea: " + e.getMessage()+" **");
        }
    }

    private static void leerTareas() {
        File archivo = new File(NOMBRE_ARCHIVO);

        if (!archivo.exists()) {
            System.out.println("|| No hay tareas guardadas ||");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            System.out.println("Tareas guardadas:");
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("** Ocurrió un error al leer las tareas: " + e.getMessage()+" **");
        }
    }
}