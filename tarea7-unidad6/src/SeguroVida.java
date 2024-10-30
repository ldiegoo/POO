import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class SeguroVida extends Seguro{
    public SeguroVida(String nombreTitular, double valorAsegurado) {
        super(nombreTitular, valorAsegurado);
    }
    @Override
    public double calcularPrima() {
        Scanner input = new Scanner(System.in);
        /*System.out.println("Ingresa el año de nacimiento del titular:");
        int anioTitular= input.nextInt();
        System.out.println("Ingresa el mes de nacimiento del titular:");
        int mesTitular= input.nextInt();
        System.out.println("Ingresa el dia de nacimiento del titular:");
        int diaTitular= input.nextInt();
        LocalDate añoTitular= LocalDate.of(anioTitular,mesTitular,diaTitular);
        long edadTitular = ChronoUnit.YEARS.between(añoTitular,LocalDate.now());*/
        System.out.println("Ingresa la edad del titular: ");
        int edadTitular = input.nextInt();
        double primaSeguro=400.00+valorAsegurado*0.015;
        if(edadTitular>=60){
            primaSeguro=primaSeguro+primaSeguro*0.25;
        }
        return primaSeguro;
    }
}
