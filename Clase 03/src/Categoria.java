import java.util.ArrayList;
import java.util.Random;

public class Categoria {
    public int id;
    public String nombre;
    public ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    public Random random=new Random();

    public Categoria(String nombre) {
       this.id = this.random.nextInt(10001);
        this.nombre = nombre;
    }
    public void registrarProductoEnCategoria(Producto producto) {
        listaProductos.add(producto);
    }

    public void mostrarCategoria() {
        String Informacion = String.format("Id: %d, nombre: %s", this.id, this.nombre);
        System.out.println(Informacion);
    }
    public void mostrarCategoriaConProductos() {
        System.out.println("Categoria:"+ this.nombre);
        System.out.println("Id: "+ this.id);
        if(listaProductos.size()==0) {
            System.out.println("No hay productos");
        }
        for (Producto producto : listaProductos) {
            System.out.println(producto);
        }
    }
    }


