import consultorios.Consultorio;
import hospital.Hospital;
import medicos.Medico;
import pacientes.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        Hospital hospital = new Hospital();
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();

        int a=hospital.listaMedicos.size();
        int b=hospital.listaPacientes.size();
        System.out.println("a: "+a+" b: "+b);

        while (opcion != 12) {
            System.out.println("*** SISTEMA HOSPITAL*");
            System.out.println("\n** Menu **");
            System.out.println("1.- Registrar Pacientes :D");
            System.out.println("2.- Registrar Medicos :D");
            System.out.println("3.- Registrar Consultorio :D");
            System.out.println("4.- Registrar Consulta");
            System.out.println("5.- Mostrar Pacientes :D");
            System.out.println("6.- Mostrar Medicos :D");
            System.out.println("7.- Mostrar Consultas");
            System.out.println("8.- Mostrar Consultorio :D");
            System.out.println("9.- Buscar Paciente por Id:D");
            System.out.println("10. Buscar Medico por Id :D");
            System.out.println("11. Buscar Consultorio por Id :D");
            System.out.println("12. Salir :D");

            System.out.println("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    String id = hospital.generarIdPaciente();
                    System.out.println("--Seleccionaste la opcion de registrar pacientes--");
                    System.out.println("Ingresa el nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresa el apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingresa la fecha de nacimiento: ");
                    String fechaNacimiento = scanner.nextLine();
                    System.out.println("Ingresa el tipo de sangre: ");
                    String tipoSangre = scanner.nextLine();
                    System.out.println("Ingresa el sexo: ");
                    String sexo2 = scanner.nextLine();
                    char sexo = sexo2.charAt(0);
                    System.out.println("Ingresa el num de telefono: ");
                    String tel = scanner.nextLine();
                    Paciente paciente = new Paciente(id, nombre, apellido, fechaNacimiento, tipoSangre, sexo, tel);
                    hospital.registrarPacientes(paciente);
                    System.out.println("Paciente registrado exitosamente :D");
                    scanner.nextLine();
                    break;
                case 2:

                    System.out.println("--Seleccionaste la opcion de registrar medicos--");
                    System.out.println("Ingresa el nombre del medico: ");
                    String nombreMedico = scanner.nextLine();
                    System.out.println("Ingresa el apellido: ");
                    String apellidoMedico = scanner.nextLine();
                    char letra1 = apellidoMedico.charAt(0);
                    letra1= Character.toUpperCase(letra1);
                    char letra2 = apellidoMedico.charAt(1);
                    letra2= Character.toUpperCase(letra2);
                    String letrasApellidos= String.format("%s%s", letra1, letra2);
                    System.out.println("Ingresa la fecha de nacimiento: ");
                    String fechaNaciMedico = scanner.nextLine();
                    char ultimoDigitoNaci= fechaNaciMedico.charAt(3);
                    System.out.println("Ingresa el telefono del medico: ");
                    String telMedico = scanner.nextLine();
                    System.out.println("Ingresa el rfc del medico: ");
                    String rfcMedico = scanner.nextLine();


                    String idMedico= hospital.generarIdMedico(letrasApellidos,ultimoDigitoNaci);

                    Medico medico=new Medico(idMedico,nombreMedico,apellidoMedico,fechaNaciMedico,telMedico,rfcMedico);
                    hospital.registrarMedico(medico);
                    System.out.println("Medico registrado exitosamente :D");


                    break;
                case 3:
                    String idConsultorio=hospital.generarIdConsultorio();
                    System.out.println("--Seleccionaste la opcion de registrar consultorio--");
                    System.out.println("Ingrese el piso del consultorio: ");
                    int pisoConsultorio =scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el numero de consultorio: ");
                    int numeroConsultorio = scanner.nextInt();
                    scanner.nextLine();
                    Consultorio consultorio=new Consultorio(idConsultorio,pisoConsultorio,numeroConsultorio);
                    hospital.registrarConsultorio(consultorio);
                    System.out.println("Consultorio registrado exitosamente :D");


                    break;
                case 4:
                    System.out.println("--Seleccionaste la opcion de registrar consulta--");
                    break;
                case 5:
                    System.out.println("--Seleccionaste la opcion de mostrar pacientes--");
                    hospital.mostrarPacientes();
                    break;
                case 6:
                    System.out.println("--Seleccionaste la opcion de mostrar medicos--");
                    hospital.mostrarMedicos();
                    break;
                case 7:
                    System.out.println("--Seleccionaste la opcion de mostrar consultas--");
                    return;
                case 8:
                    System.out.println("--Seleccionaste la opcion de mostrar consultorios--");
                    hospital.mostrarConsultorio();
                    break;
                case 9: System.out.println("--Seleccionaste la opcion de buscar Paciente mediante la ID--");

                    System.out.println("\nIngresa el Id del paciente que deseas buscar");
                    String idPaciente = scanner.nextLine();

                    hospital.mostrarPacienteID(idPaciente);
                    break;
                case 10: System.out.println("--Seleccionaste la opcion de buscar medicos mediante la ID--");
                    System.out.println("Ingresa el Id del medico que deseas buscar: ");
                    String idMedico2 = scanner.nextLine();
                    hospital.mostrarMedicoPorId(idMedico2);
                    break;

                case 11: System.out.println("--Seleccionaste la opcion de buscar consultorio mediante la ID--");
                    System.out.println("Ingresa el Id del consultorio que deseas buscar: ");
                    String idConsultorio2= scanner.nextLine();
                    hospital.mostrarConsultorioPorId(idConsultorio2);
                    break;
                case 12:
                    System.out.println("--Seleccionaste la opcion de salir--");
                    System.out.println("**HASTA LUEGO**");
                    return;
            }
        }
    }
}