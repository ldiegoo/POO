public class ArrayIndexOutOfBounds {
    public void Ejecutar() {
        try {
            int[] a = new int[3];

            a[4] = 3;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Valor sin valor" + e);
        }
    }
}
