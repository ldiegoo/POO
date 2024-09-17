 import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Producto producto1 = new Producto(01, "Galletas oreo", 18.0, 6);
        Producto producto2 = new Producto(02, "Ruffles Queso", 17.0);
        Producto producto3 = new Producto(03, "Chettos", 14.0);
        int opcion = 0;
        int codigo;

        while (opcion != 4) {
            System.out.println("--BIENVENIDO USUARIO--");
            System.out.println("1. Agregar Stock al Producto");
            System.out.println("2. Eliminar Stock al Producto");
            System.out.println("3. Mostrar Productos: ");
            System.out.println("4. Salir");
            System.out.println("Seleccione alguna de las opciones anteriores para continuar: ");
            opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el codigo de producto: ");
                    codigo = leer.nextInt();
                    System.out.println("Cuanto producto desea aumentar al stock: ");
                    int aumento = leer.nextInt();
                    switch (codigo) {
                        case 01:
                            producto1.aumentarStock(aumento);
                            break;
                        case 02:
                            producto2.aumentarStock(aumento);
                            break;
                        case 03:
                            producto3.aumentarStock(aumento);
                            break;
                        default:
                            System.out.println("El codigo del producto no existe");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el codigo de producto: ");
                    codigo = leer.nextInt();
                    System.out.println("Cuanto producto desea eliminar al stock: ");
                    int eliminar = leer.nextInt();
                    switch (codigo) {
                        case 01:
                            producto1.reduceStock(eliminar);
                            break;
                        case 02:
                            producto2.reduceStock(eliminar);
                            break;
                        case 03:
                            producto3.reduceStock(eliminar);
                            break;
                        default:
                            System.out.println("El codigo del producto no existe");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("--PRODUCTOS--");
                    System.out.println("** Producto 1 **");
                    producto1.mostrarInfoProducto();
                    System.out.println("** Producto 2 **");
                    producto2.mostrarInfoProducto();
                    System.out.println("** Producto 3 **");
                    producto3.mostrarInfoProducto();
                    break;

                case 4:
                    System.out.println("--NOS VEMOS LUEGO USUARIO--");
return;
            }
        }
    }
}