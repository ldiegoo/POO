public abstract class Seguro {
    public String nombreTitular;
    public double valorAsegurado;

    public Seguro(String nombreTitular, double valorAsegurado) {
        this.nombreTitular = nombreTitular;
        this.valorAsegurado = valorAsegurado;
    }


    public abstract double calcularPrima();

    public String detallesSeguro(String nombreTitular, double valorAsegurado,  double primaSeguro) {
        return String.format("Titular: %s, Valor Asegurado: %.2f, Prima del seguro: %2f", nombreTitular, valorAsegurado, primaSeguro);
    }
}
