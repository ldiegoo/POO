public class Main {
    public static void main(String[] args) {
        SeguroAuto seguro1 = new SeguroAuto("Diego", 102000);
        seguro1.calcularPrima();
        SeguroAuto seguro2 = new SeguroAuto("Juan", 305000);
        seguro2.calcularPrima();
        SeguroHogar seguro3 = new SeguroHogar("Miguel", 503000);
        seguro3.calcularPrima();
        SeguroHogar seguro4 = new SeguroHogar("Tomas", 1050000);
        seguro4.calcularPrima();
        SeguroVida seguro5 = new SeguroVida("Isaac",200000);
        seguro5.calcularPrima();
        SeguroVida seguro6 = new SeguroVida("Antonio", 300000);
        seguro6.calcularPrima();

        System.out.println(seguro1.detallesSeguro("Diego",102000, seguro1.calcularPrima()));
        System.out.println(seguro2.detallesSeguro("Juan",305000, seguro2.calcularPrima()));
        System.out.println(seguro3.detallesSeguro("Miguel",503000, seguro3.calcularPrima()));
        System.out.println(seguro4.detallesSeguro("Tomas",1050000, seguro4.calcularPrima()));
        System.out.println(seguro5.detallesSeguro("Isaac",200000, seguro5.calcularPrima()));
        System.out.println(seguro6.detallesSeguro("Antonio",300000, seguro6.calcularPrima()));
    }
}