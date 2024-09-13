public class CalculadoraImpuestos {
    public int ingresos;
    public double porcentajeImpuestos;
    public double dividendos;
    public double exencion;
    public double calcularImpuestos(int ingresos) {
        return ingresos + 0.15;
    }
    public double calcularImpuestos(double ingresos, double porcentajeImpuestos) {
        return ingresos * (porcentajeImpuestos / 100);
    }
    public double calcularImpuestos( double dividendos, double porcentajeImpuestos, double exencion) {
        double impuestos= dividendos * (porcentajeImpuestos / 100);
        if(impuestos>exencion){
            return impuestos;
        }else {
            return 0.0;
        }
    }
}
