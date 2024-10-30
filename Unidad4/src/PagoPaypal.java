public class PagoPaypal extends Pago {
    private String numeroDeCuenta;
    private String email;

    public PagoPaypal(int monto, String numeroDeCuenta, String email) {
        super(monto);
        this.numeroDeCuenta = numeroDeCuenta;
        this.email=email;
    }
    @Override
    public void procesarPago(){
        if(!email.contains("@")){
            System.out.println("Correo invalido");
        }else{
            System.out.println("Pago completado");
            System.out.println("Monto: "+super.getMonto());
            System.out.println("Correo usuario: "+ email);
            System.out.println("Numero de cuenta: "+);

        }
    }
}
