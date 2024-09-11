public class Coche {


    public String marca;
    public String modelo;
    public int año;

    public Coche(String marca, String modelo, int año) {
    this.marca = marca;
    this.modelo = modelo;
    this.año= año;
    }
    public String mostrarInformacion(){
        return "Marca: " + marca+ " ||" +" Modelo: "+ modelo+ " ||" + " Año: "+año;

    }
    public int calcularEdadDelCoche(int añoActual){
        int edadCoche=añoActual-año;
        return edadCoche;
    }
}
