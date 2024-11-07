public class Avion implements MedioTransporte{
    @Override
    public void acelerar(double velocidad){
        if(velocidad>VELOCIDAD_MAXIMA){
            System.out.println("Alerta");
        }else if(velocidad>VELOCIDAD_MAXIMA/3 && velocidad<VELOCIDAD_MAXIMA){
            System.out.println("Encender motor extra");
        }else{
            System.out.println("Flujo normal");
        }

    }
    @Override
    public void arrancar(){

    }

}
