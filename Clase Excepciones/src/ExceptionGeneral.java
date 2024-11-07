public class ExceptionGeneral {
    public void Ejecutar() {
        try{String palabra = "hola";
            int numero;
            numero = Integer.parseInt(palabra);
        }catch(Exception e){
            System.out.println("String sin valor numerico");
        }
    }
}
