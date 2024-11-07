public class Producto {
    public String nombre;
    public double precio;
    public int cantidad;

    public Producto(String nombre, double precio, int cantidad) throws ProductoInvalidoException, PrecioInvalidoException, CantidadInvalidaException {
        if (nombre == null || nombre.isEmpty()) {
            throw new ProductoInvalidoException("El nombre del producto no puede estar vacío o ser nulo.");
        }
        if (precio <= 0) {
            throw new PrecioInvalidoException("El precio del producto debe ser mayor que cero.");
        }
        if (cantidad < 0) {
            throw new CantidadInvalidaException("La cantidad del producto no puede ser negativa.");
        }
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }


    public void mostrarDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Valor del inventario: " + calcularValorTotal());
    }

    public double calcularValorTotal() {
        return precio * cantidad;
    }

    public class ProductoInvalidoException extends Exception {
        public ProductoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    // Excepción para precio inválido
    public class PrecioInvalidoException extends Exception {
        public PrecioInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    // Excepción para cantidad inválida
    public class CantidadInvalidaException extends Exception {
        public CantidadInvalidaException(String mensaje) {
            super(mensaje);
        }
    }
}