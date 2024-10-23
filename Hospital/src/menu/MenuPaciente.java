package menu;

import hospital.Hospital;
import usuarios.medicos.pacientes.Paciente;

import java.util.Scanner;

public class MenuPaciente {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu () {
        System.out.println("\n** SISTEMA hOSPITAL **");
        System.out.println("1. Ver mis consultas");
        System.out.println("2. Ver mis datos");
        System.out.println("3. Ver mi expediente");
        System.out.println("4. Salir");
        int opcion = scanner.nextInt();
        return opcion;
    }

    public void procesarDatosMenu (int opcion, Hospital hospital, Paciente paciente) {
        switch (opcion) {
            case 1:
                hospital.verCOnsultasPaciente(paciente.id);
                break;
            case 2:
                hospital.verInformacionPaciente(paciente);
                break;
            case 3:
                Paciente Paciente = null;
                while (Paciente == null) {
                    scanner.nextLine();
                    System.out.println("Ingresa el ID del paciente: ");
                    String buscarPaciente = scanner.nextLine();
                    Paciente = hospital.mostrarIdPaciente(buscarPaciente);

                    if (Paciente == null) {
                        System.out.println("Error: No se encontró el paciente con el ID proporcionado. Inténtalo de nuevo.");
                    }else {
                        Paciente = hospital.mostrarIdPaciente(buscarPaciente);
                    }
                }
        }
    }
}
