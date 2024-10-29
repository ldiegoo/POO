import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class EnvioNacional extends Envio {
    public double distancia;

    public EnvioNacional(double costoBase, double peso, double distancia) {
        super(costoBase, peso);
        this.distancia= distancia;
    }

    @Override
    public String calcularTiempoYCostoEntrega() {
        int tiempo = (int) (distancia / 200);
        double costo = 0;
        if (getPeso() > 5) {
            costo = getCostoBase() + getCostoBase() * 0.05;
        }

        return String.format("Tiempo: %d,Costo: %2f",
                tiempo, costo);
    }
    }

