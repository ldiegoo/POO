public class Main {
    public static void main(String[] args) {
        Rectangulo rectangulo = new Rectangulo();
        System.out.println("-- AREA DEL RECTANGULO --");
        System.out.println("El area de un rectangulo es: " + rectangulo.Area(22.5, 34.5));
        System.out.println("El area de un rectangulo es: " + rectangulo.Area(12, 32));

        Empleado empleado = new Empleado();
        System.out.println("\n--SALARIO DE EMPLEADO--");
        System.out.println("El salario del empleado es: " + empleado.calcularSalario(
                3800.0));
        System.out.println("El salario del empleado es: " + empleado.calcularSalario(
                3800.0,
                920.42));
        System.out.println("El salario del empleado es: " + empleado.calcularSalario(
                3800.0,
                730.3,
                3));

        CalculadoraImpuestos calculadora = new CalculadoraImpuestos();
        System.out.println("\n--CALCULADORA DE IMPUESTOS--");
        System.out.println("Los impuestos son:"+ calculadora.calcularImpuestos(20000));
        System.out.println("Los impuestos son:"+ calculadora.calcularImpuestos(20000,23));
        System.out.println("Los impuestos son:"+ calculadora.calcularImpuestos(9000,42,1500));
    }
}