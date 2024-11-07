import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Captura de datos del producto
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el precio del producto: ");
            double precio = scanner.nextDouble();

            System.out.print("Ingrese la cantidad del producto: ");
            int cantidad = scanner.nextInt();

            // Creación del producto
            Producto producto = new Producto(nombre, precio, cantidad);

            // Mostrar detalles del producto
            System.out.println("\nDetalles del producto:");
            producto.mostrarDetalles();

        } catch (Producto.ProductoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Producto.PrecioInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Producto.CantidadInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Hasta luego usuario");
            scanner.close();
        }


    }
}