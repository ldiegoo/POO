import java.util.ArrayList;

public class Inventario {
    public ArrayList<Producto> listaProductos=new ArrayList<Producto>();
   /* public ArrayList<Producto> getListaProductos;
    Se puede colocar asi si la lista queda vacia*/

    public void registrarProducto(Producto producto){
        this.listaProductos.add(producto);
        System.out.println("Se registro un nuevo producto");
    }
    public void eliminarProducto(int idProductoEliminar){
      /*for (int i = 0; i < listaProductos.size(); i++) {
            Producto productoActual = listaProductos.get(i);
            if(idProductoEliminar == productoActual.id){
                listaProductos.remove(i);
                break;
            }
        }*/
        int longitudOriginal=this.listaProductos.size();//3

      this.listaProductos.removeIf((producto) -> producto.id == idProductoEliminar);
      //Con el producto landa

        if (longitudOriginal != this.listaProductos.size()){
            System.out.println("\n** Se elimino el producto con el ID: "+ idProductoEliminar+"**");
        }
        else{
            System.out.println("\n**No existe un producto con el ID: "+ idProductoEliminar+"**");
        }
    }


    public void mostrarProductos(){
        System.out.println("\n||| PRODUCTOS EN EL SISTEMA |||");

        int iterador =1;
        for (Producto producto: this.listaProductos) {
            System.out.println("\nId:" +producto.id);
            System.out.println("Nombre:" +producto.nombre);
            System.out.println("Descripcion:" +producto.descripcion);
            System.out.println("Costo:" +producto.costo);
            System.out.println("Categoria:" +producto.categoria);
            System.out.println("Stock:" +producto.stock);
        }
        /*
        for (int i = 0; i < this.listaProductos.size(); i++) {
            System.out.println("Id: "+ listaProductos.get(i).id);
            System.out.println("Nombre: "+ listaProductos.get(i).nombre);
            System.out.println("Descripcion: "+ listaProductos.get(i).descripcion);
            System.out.println("Costo: "+ listaProductos.get(i).costo);
            System.out.println("Categoria: "+ listaProductos.get(i).categoria);
            System.out.println("Stock: "+ listaProductos.get(i).stock);

            **Es lo mismo que el for initch**
            */
        }
    }
