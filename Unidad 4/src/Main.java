import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PagoPaypal pagoPaypal = new PagoPaypal(200,"CB001", "juanjotitogmail.com");
        pagoPaypal.procesarPago();

        System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

        PagoTarjeta pagoTarjeta = new PagoTarjeta(10, LocalDate.of(2025,10,01), "CB001");
        pagoTarjeta.procesarPago();
    }
}