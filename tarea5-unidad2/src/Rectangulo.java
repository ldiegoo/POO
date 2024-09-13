public class Rectangulo {
    public int ladoEntero;
    public int alturaEntera;
    public double altura;
    public double lado;

    public int Area(int ladoEntero, int alturaEntera) {
       return ladoEntero * alturaEntera;
    }
    public double Area(double lado, double altura) {
        return lado * altura;
    }
}