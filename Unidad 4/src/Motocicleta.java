public class Motocicleta implements MedioTransporte{
    @Override
    public void acelerar(double velocidad){
        if(velocidad>VELOCIDAD_MAXIMA/5){
            System.out.println("Alerta");
        }else{
            System.out.println("Aceleración");
        }
        System.out.println(VELOCIDAD_MAXIMA);
    }
    @Override
    public void arrancar(){

    }

}
