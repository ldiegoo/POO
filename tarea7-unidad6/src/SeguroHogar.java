import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class SeguroHogar extends Seguro {
    public SeguroHogar(String nombreTitular, double valorAsegurado) {
        super(nombreTitular, valorAsegurado);
    }
    @Override
    public double calcularPrima() {
        double primaSeguro;
        Scanner input = new Scanner(System.in);
        System.out.println("La vivienda esta ubicada en alguna zona de riesgo(Colocar ´Si´ o ´No´");
        String zonaRiesgo= input.nextLine();
        if(zonaRiesgo.equals("Si")){
            primaSeguro=500.00+valorAsegurado*0.02+valorAsegurado*0.20;
        }else{
            primaSeguro=500.00+valorAsegurado*0.02;
        }


        return primaSeguro;
    }
}
