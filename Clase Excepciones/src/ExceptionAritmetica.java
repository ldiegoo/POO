public class ExceptionAritmetica {
    public void Ejecutar() {

        try {
            int a = 20;
            int b = 0;

            int div = a / b;

        } catch (ArithmeticException e) {
            System.out.println("Division entre 0" + e);
        }

    }
}
