import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int opcion = 0;

        while (opcion != 7) {
            System.out.println("\n*** BIENVENIDO ***");
            System.out.println("1. Registrar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Mostrar categorias");
            System.out.println("5. Mostrar categoria y productos");
            System.out.println("6. Registrar categoria");
            System.out.println("7. Salir");

            System.out.println("Selecciona una opción: ");
            opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (!inventario.validarExistenciaDeCategoria()) {
                        System.out.println("\n No existen categorias en el sistema");
                        break;
                    }
                    System.out.println("\nSeleccionaste la opción para registrar un producto");

                    System.out.println("\nIngresa el nombre del producto");
                    String nombre = scanner.nextLine();

                    scanner.nextLine();

                    System.out.println("\nIngresa el precio del producto");
                    double precio = scanner.nextDouble();

                    scanner.nextLine();

                    System.out.println("\nIngresa la descripcion del producto");
                    String descripcion = scanner.nextLine();

                    scanner.nextLine();
                    System.out.println("\nIngresa el stock del producto");
                    int stock = scanner.nextInt();

                    System.out.println("\nIngresa el id de la categoria en la cual registraras el producto");
                    int idCategoria = scanner.nextInt();
                    boolean validarCategoria = false;
                    scanner.nextLine();
                    for (Categoria categoria : inventario.listaCategoria) {
                        if (categoria.id == idCategoria) {
                            System.out.println("La categoria ya existe en el sistema");
                            validarCategoria = true;
                            break;
                        }

                    }
                    if (!validarCategoria) {
                        System.out.println("\n No existen categorias en el sistema");
                        Producto producto = new Producto(nombre, precio, descripcion, idCategoria, stock);
                        inventario.registrarProducto(producto);

                        System.out.println("\nProducto registrado correctamente");
                        break;
                    }


                    scanner.nextLine();


                case 2:
                    System.out.println("\nSeleccionaste la opción para eliminar un producto");

                    System.out.println("\nIngresa el ID del producto: ");
                    int id = scanner.nextInt();

                    inventario.eliminarProducto(id);
                    break;
                case 3:
                    inventario.mostrarProductos();
                    break;
                case 4:
                    System.out.println("\nSeleccionaste la opcion para listar todas las categorias del sistema");
                    for (Categoria categoria : inventario.listaCategoria) {
                        System.out.println("Nombre de la categoria: " + categoria.nombre);
                        System.out.println("Id de la categoria: " + categoria.id);
                    }


                    //Crear un metodo para listar todas las categorias del sistema junto con sus productos
                    //junto con sus productos
                    break;
                case 5:
                    System.out.println("\nSeleccionaste la opcion para listar todas las categorias del sistema");
                    for (Categoria categoria : inventario.listaCategoria) {
                        System.out.println("Nombre de la categoria: " + categoria.nombre);
                        System.out.println("Id de la categoria: " + categoria.id);
                        System.out.println("Productos: ");
                        for (Producto producto : inventario.listaProductos) {
                            System.out.println("Nombre: " + producto.nombre);
                            System.out.println("Id: " + producto.id);
                        }
                    }
                        break;
                case 6:

                    System.out.println("\nSeleccionaste la opción para registrar una categoria");

                    System.out.print("Ingresa el nombre de la categoría: ");
                    String nombreCategoria = scanner.next();

                    Categoria categoria = new Categoria(nombreCategoria);
                    inventario.registrarCategoria(categoria);
                    System.out.println("\nCategoria registrada correctamente");

                    break;

                case 7:
                    System.out.println("Hasta luego");
                    return;
            }
        }
        }
    }