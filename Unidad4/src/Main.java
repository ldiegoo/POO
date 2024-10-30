import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PagoPaypal pagoPaypal = new PagoPaypal(200,"CB001", "nfiaboryu");
        pagoPaypal.validarPago();
        PagoTarjeta pagoTarjeta = new PagoTarjeta(0, LocalDate.now(), "CB001");
        pagoPaypal.validarPago();
    }
}