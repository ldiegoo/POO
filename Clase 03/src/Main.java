public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        System.out.println(inventario.listaProductos);
        Producto producto1 = new Producto(
        1,
        "Iphone 16",
        31000.0,
        "Nuevo Iphone",
        "Iphone",
        15);
        Producto producto2 = new Producto(
                2,
                "Iphone 15",
                25000.0,
                "Iphone 15 antiguo",
                "Iphone",
                20);
        Producto producto3 = new Producto(
                3,
                "Iphone 14",
                22000.0,
                "Iphone 14 antiguo",
                "Iphone",
                13);
        System.out.println("--Productos--");

        inventario.registrarProducto(producto1);
        inventario.registrarProducto(producto2);
        inventario.registrarProducto(producto3);

        inventario.mostrarProductos();

        inventario.eliminarProducto(3);

        inventario.mostrarProductos();

       /* System.out.println(inventario.listaProductos.get(0).id);
        System.out.println(inventario.listaProductos.get(0).nombre);
        System.out.println(inventario.listaProductos.get(0).costo);
        System.out.println(inventario.listaProductos.get(0).descripcion);
        System.out.println(inventario.listaProductos.get(0).categoria);
        System.out.println(inventario.listaProductos.get(0).stock);
        **Se movio al metodo Main**
        */

        /*System.out.println("Producto 2");
        System.out.println(inventario.listaProductos.get(1).id);
        System.out.println(inventario.listaProductos.get(1).nombre);
        System.out.println(inventario.listaProductos.get(1).costo);
        System.out.println(inventario.listaProductos.get(1).descripcion);
        System.out.println(inventario.listaProductos.get(1).categoria);
        System.out.println(inventario.listaProductos.get(1).stock);
        **Se movio al metodo Main**
    */

    }
}