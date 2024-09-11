public class Main {
    public static void main(String[] args) {

        Coche coche=new Coche("Audi", "A3",2017);
        System.out.println("Carro 1");
        System.out.println(coche.mostrarInformacion());
        System.out.println("La edad del coche 1 es: "+coche.calcularEdadDelCoche(2024)+" años");
        System.out.println("\n");

        Coche coche2=new Coche("Chevrolet", "Onix",2014);
        System.out.println("Carro 2");
        System.out.println(coche2.mostrarInformacion());
        System.out.println("La edad del coche 2 es: "+coche2.calcularEdadDelCoche(2024)+" años");
        System.out.println("\n");

        Coche coche3=new Coche("Ferrari", "Purosangue",2022);
        System.out.println("Carro 3");
        System.out.println(coche3.mostrarInformacion());
        System.out.println("La edad del coche 3 es: "+coche3.calcularEdadDelCoche(2024)+" años");



    }
}
