public class EnvioInternacional extends Envio {
    String destino;

    public EnvioInternacional(double costoBase, double peso, String destino) {
        super(costoBase, peso);
        this.destino=destino;
    }

    @Override
    public String calcularTiempoYCostoEntrega() {
        int tiempo;
        double costo = 0;
        if (getPeso() > 10) {
            tiempo= 10+3;
        }else {
            tiempo= 10;
        }
            costo = getCostoBase() + getCostoBase() * 0.2;


        return String.format("Tiempo: %d,Costo: %2f",
                tiempo, costo);
    }
}
