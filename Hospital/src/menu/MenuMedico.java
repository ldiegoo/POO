package menu;

import hospital.Hospital;
import usuarios.medicos.medicos.Medico;

import java.util.Scanner;

public class MenuMedico {

    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu () {
        System.out.println("\n** SISTEMA HOSPITAL **");
        System.out.println("1. Ver mis consultas");
        System.out.println("2. Ver mis pacientes");
        System.out.println("3. Ver mis datos");
        System.out.println("4. Consultar paciente");
        System.out.println("5. Salir");

        System.out.println("\nSelecciona una opcion:");
        int opcion = scanner.nextInt();
        return opcion;

    }

    public void procesarDatosMenu (int opcion, Medico medico, Hospital hospital) {
        switch (opcion) {
            case 1:
                System.out.println("** CONSULTAS **");
                hospital.verConsultasProgramadas();
                break;
            case 2:

                break;
            case 3:
               hospital.verInformacionMedico(medico);
                /* Medico medico1 = null;
                while (medico1 == null) {
                    System.out.println("Ingresa el ID del médico: ");
                    String idMed = scanner.nextLine();
                    medico1 = hospital.mostrarIdMedico(idMed);

                    if (medico1 == null) {
                        System.out.println("Error: No se encontró el médico con el ID proporcionado. Inténtalo de nuevo.");
                    }else {
                        medico1 = hospital.mostrarIdMedico(idMed);
                    }
                }*/
            case 4:

                break;
            case 5:
                scanner.nextLine();
                System.out.println("Hasta luego");
                return;
        }
    }
}
