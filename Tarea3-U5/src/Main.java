import excepciones.HabitacionNoDisponibleException;
import excepciones.NumeroDeNochesInvalidoException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Habitacion> habitaciones;

    public Main() {
        habitaciones = new ArrayList<>();

        habitaciones.add(new Habitacion("individual", 50));
        habitaciones.add(new Habitacion("doble", 80));
        habitaciones.add(new Habitacion("suite", 150));
    }

    public void mostrarHabitaciones() {
        for (int i = 0; i < habitaciones.size(); i++) {
            System.out.println("Habitación " + (i + 1) + ":");
            habitaciones.get(i).mostrarDetalles();
            System.out.println();
        }
    }

    public void reservarHabitacion(int indiceHabitacion, int noches) {
        try {
            Habitacion habitacion = habitaciones.get(indiceHabitacion);
            habitacion.reservar(noches);
            System.out.println("Reserva exitosa para " + noches + " noches.");
            System.out.println("Costo total: " + (habitacion.getPrecioPorNoche() * noches));
        } catch (HabitacionNoDisponibleException | NumeroDeNochesInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Sistema de Reservas de Hotel");
            System.out.println("1. Mostrar habitaciones");
            System.out.println("2. Reservar habitación");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    main.mostrarHabitaciones();
                    break;
                case 2:
                    main.mostrarHabitaciones();
                    System.out.print("Elige el número de la habitación que deseas reservar: ");
                    int indiceHabitacion = scanner.nextInt() - 1; // Restar 1 para índice
                    System.out.print("Ingresa el número de noches: ");
                    int noches = scanner.nextInt();
                    main.reservarHabitacion(indiceHabitacion, noches);
                    break;
                case 3:
                    System.out.println("Saliendo del sistema.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}