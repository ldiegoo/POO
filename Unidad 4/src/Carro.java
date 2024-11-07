public class Carro implements MedioTransporte{
    @Override
    public void acelerar(double velocidad){
       if(velocidad<VELOCIDAD_MAXIMA/2){
        System.out.println("Velocidad maxima alcanzada");
       }else{
        System.out.println("Flujo normal");
       }
    }
    @Override
    public void arrancar(){

    }

}
