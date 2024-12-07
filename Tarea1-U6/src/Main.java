import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            try{
                System.out.println("---    Bienvenido a Gestor e Tareas    ---");
                System.out.println("1.- Escribir");
                System.out.println("2.- Leer");
                System.out.println("3.- Salir");
                System.out.println("Selecciona una opcion: ");
                int opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        leer.nextLine();
                        escribirTarea();
                        break;
                    case 2:
                        leerTarea();
                        break;
                    case 3:
                        System.out.println("Gracias por usar el gestor de tareas, hasta luego");
                        return;
                    default:
                        System.out.println("Opcion no valida, intenta nuevamente");
                }
            }catch (InputMismatchException e){
                System.out.println("Error: " + e);
            }
        }while(true);

    }
    public static void escribirTarea() {
        System.out.println("\n♫♫   Seleccionaste Escribir Tareas   ♫♫");
        System.out.println("Escribe tu tarea: ");
        String tarea = leer.nextLine();
        try(FileWriter escribir = new FileWriter("Tareas.txt", true)){
            escribir.write(tarea+ "\n");
            System.out.println("Tarea guardada exitosamente █");
        } catch (IOException e) {
            System.out.println("Ocurrio un error en el metodo escribir tarea" + e);
        }
    }

    public static void leerTarea() {
        System.out.println("\n☻     Selecionaste la opcion leer tareas      ☻");
        System.out.println("Las tareas que tienes son: ");
        try(BufferedReader leer = new BufferedReader(new FileReader("Tareas.txt"))){
            String tareas;
            while((tareas = leer.readLine()) != null){
                System.out.println(tareas);
            }
        }catch(IOException e) {
            System.out.println("Error en el metodo leer tarea");
        }
        System.out.println("\n");
    }
}