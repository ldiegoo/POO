public class ExceptionNullPointer {
    public void Ejecutar() {
        try {
            int[] a = new int[3];
            a[5] = a[5] / 2;
        } catch (NullPointerException e) {
            System.out.println("Valor sin valor" + e);
        }
    }

}
