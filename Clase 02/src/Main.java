public class Main {
    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo(5.2, 3.4, 4.6, 5.4, 4.3);
/*
        PRIMERA PARTE DEL CODIGO
double areatriangulo= triangulo.calcularArea();
        System.out.println("El area del triangulo es: "+areatriangulo);
        System.out.println("El perimentro del triangulo es: "+triangulo.calcularPerimetro());


Triangulo triangulo2 = new Triangulo(10.4,4.5,8.7,9.2,7.9);
        System.out.println("El area del triangulo es: "+triangulo.areatriangulo);
        System.out.println("El perimentro del triangulo es: "+triangulo.calcularPerimetro());
        */
        //SEGUNDA PARTe DEL CODIGO
        System.out.println("El area del triangulo es: "+ triangulo.calcularArea());
        System.out.println("El area del triangulo es: "+ triangulo.calcularArea(20.2));
        System.out.println("El area del triangulo es: "+ triangulo.calcularArea(42.3,35));
    }
}