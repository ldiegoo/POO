public class Producto {
    public int idProducto;
    public String nombre;
    public double precio;
    public int stock;


    public Producto(int idProducto,String nombre, double precio, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    public Producto(int idProducto,String nombre, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = 0;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null){
            System.out.println("El nommbre no puede ser nulo");
        }
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        if(precio < 0){
            System.out.println("El precio no puede ser negativo");
        }
        this.precio = precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        if(stock < 0){
            System.out.println("El stock no puede ser negativo");
        }
        this.stock = stock;
    }

    public int getIdProducto() {
            return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int aumentarStock(int stock) {
        if(stock < 0){
            System.out.println("La cantidad a aumentar tiene que ser mayor a cero ");
        }
        this.stock = this.stock + stock;
        return stock;
    }
    public int reduceStock(int stock) {
        if(stock < 0){
            System.out.println("La cantidad a reducir debe de ser mayor que cero");
        }
        this.stock = this.stock - stock;
        return stock;
    }
    public void mostrarInfoProducto(){
        System.out.println("idProducto = " + idProducto);
        System.out.println("nombre = " + nombre);
        System.out.println("precio = " + precio);
        System.out.println("stock = "+ stock);
    }
}
