package menu;

import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import usuarios.medicos.Rol;
import usuarios.medicos.administradores.Administrador;
import usuarios.medicos.medicos.Medico;
import usuarios.medicos.pacientes.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdmin {

    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu () {

                System.out.println("\n*** BIEVENIDO ***");
                System.out.println("1. Registrar paciente");
                System.out.println("2. Registrar medico");
                System.out.println("3. Registrar consultorio");
                System.out.println("4. Registrar consulta");
                System.out.println("5. Mostrar pacientes");
                System.out.println("6. Mostrar medicos");
                System.out.println("7. Mostrar consultorios");
                System.out.println("8. Mostrar consultas");
                System.out.println("9. Mostrar paciente por ID");
                System.out.println("10. Mostrar medicos por ID");
                System.out.println("11. Mostrar consultorios por ID");
                System.out.println("12. Mostrar consultas por ID");
                System.out.println("13. Ver mis datos");
                System.out.println("14. Salir");

                System.out.print("\nSelecciona una opción: ");
                int opcion = scanner.nextInt();
                return opcion;

    }

    public void procesarDatosMenu (int opcion, Administrador administrador, Hospital hospital) {

        switch (opcion) {

            case 1:
                scanner.nextLine();
                String id = hospital.generarIdPaciente();
                ArrayList<String> datosPacientes = this.obtenerDatosComun(Rol.PACIENTE);
                String nombrePaciente = datosPacientes.get(0);
                String apellidoPaciente = datosPacientes.get(1);
                LocalDate fechaNacimientoPaciente = LocalDate.parse(datosPacientes.get(2));
                String numeroTelefonoPaciente = datosPacientes.get(3);
                String contraseniaPaciente = datosPacientes.get(4);

                System.out.println("--Seleccionaste la opcion de registrar pacientes--");

                scanner.nextLine();

                System.out.println("Ingresa el tipo de sangre: ");
                String tipoSangre = scanner.nextLine();

                System.out.println("Ingresa el sexo: ");
                String sexo1 = scanner.nextLine();
                char sexo = sexo1.charAt(0);

                Paciente paciente = new Paciente(id, nombrePaciente, apellidoPaciente, fechaNacimientoPaciente, tipoSangre, sexo, numeroTelefonoPaciente, contraseniaPaciente,  Rol.PACIENTE);
                hospital.registrarPaciente(paciente);
                System.out.println("Paciente registrado exitosamente");
                break;
            case 2:
                scanner.nextLine();
                String idMedico = hospital.generarIdMedico();
                System.out.println("--Seleccionaste la opcion de registrar medico--");
                ArrayList<String> datosMedicos = this.obtenerDatosComun(Rol.PACIENTE);
                String nombreMedico = datosMedicos.get(0);
                String apellidoMedico = datosMedicos.get(1);
                LocalDate fechaNacimientoMedico = LocalDate.parse(datosMedicos.get(2));
                String numeroTelefonoMedico = datosMedicos.get(3);
                String contraseniaMedico = datosMedicos.get(4);

                scanner.nextLine();

                String rfcMedico;
                while (true) {
                    System.out.println("Ingresa el RFC del médico: ");
                    rfcMedico = scanner.nextLine();

                    if (hospital.buscarMedicoPorRFC(rfcMedico) != null) {
                        System.out.println("Error: Ya existe un médico con este RFC. Inténtalo de nuevo.");
                    } else {
                        break;
                    }
                }

                Medico medico = new Medico(idMedico, nombreMedico, apellidoMedico, fechaNacimientoMedico, numeroTelefonoMedico, rfcMedico, contraseniaMedico);

                hospital.registrarMedico(medico);
                System.out.println("Medico registrado exitosamente");

                break;
            case 3:
                scanner.nextLine();
                String idConsultorio = hospital.generarIdConsultorio();
                System.out.println("--Seleccionaste la opcion de registrar consultorio--");
                System.out.println("Ingresa el piso del consultorio: ");
                int piso = scanner.nextInt();

                System.out.println("Ingresa el numero del consultorio");
                int numConsultorio = scanner.nextInt();

                Consultorio consultorio = new Consultorio(idConsultorio, piso, numConsultorio);
                hospital.registrarConsultorio(consultorio);
                System.out.println("Consultorio registrado exitosamente");
                break;
            case 4:
                String idConsulta = hospital.generarIdConsulta();
                System.out.println("--Seleccionaste la opcion de registrar consulta--");

                System.out.println("Ingresa el dia de la consulta deseada: ");
                int diaConsulta = scanner.nextInt();

                System.out.println("Ingresa el mes de la consulta deseada: ");
                int mesConsulta = scanner.nextInt();

                System.out.println("Ingresa el año de la consulta deseada: ");
                int anioConsulta = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Ingresa la hora de la consulta: ");
                int horaConsulta = scanner.nextInt();

                System.out.println("Ingresa los minutos de la consulta: ");
                int minutoConsulta = scanner.nextInt();

                LocalDateTime fechaConsulta = LocalDateTime.of(anioConsulta, mesConsulta, diaConsulta, horaConsulta, minutoConsulta);

                if (fechaConsulta.isBefore(LocalDateTime.now())) {
                    System.out.println("Error: La fecha de la consulta no puede ser en el pasado. Inténtalo de nuevo.");
                }else {
                    break;
                }
                scanner.nextLine();

                Paciente paciente1 = null;
                while (paciente1 == null) {
                    scanner.nextLine();
                    System.out.println("Ingresa el ID del paciente: ");
                    String buscarPaciente = scanner.nextLine();
                    paciente1 = hospital.mostrarIdPaciente(buscarPaciente);

                    if (paciente1 == null) {
                        System.out.println("Error: No se encontró el paciente con el ID proporcionado. Inténtalo de nuevo.");
                    }else {
                        paciente1 = hospital.mostrarIdPaciente(buscarPaciente);
                    }
                }

                Medico medico1 = null;
                while (medico1 == null) {
                    System.out.println("Ingresa el ID del médico: ");
                    String idMed = scanner.nextLine();
                    medico1 = hospital.mostrarIdMedico(idMed);

                    if (medico1 == null) {
                        System.out.println("Error: No se encontró el médico con el ID proporcionado. Inténtalo de nuevo.");
                    }else {
                        medico1 = hospital.mostrarIdMedico(idMed);
                    }
                }

                Consultorio consultorio1 = null;
                while (consultorio1 == null) {
                    System.out.println("Ingresa el ID del consultorio: ");
                    String idCon = scanner.nextLine();
                    consultorio1 = hospital.mostrarIdConsultorio(idCon);

                    if (consultorio1 == null) {
                        System.out.println("Error: No se encontró el consultorio con el ID proporcionado. Inténtalo de nuevo.");
                    }else{
                        consultorio1 = hospital.mostrarIdConsultorio(idCon);
                    }
                }
                if (paciente1 != null && medico1 != null && consultorio1 != null) {

                    Consulta consulta = new Consulta(idConsulta, fechaConsulta, paciente1, medico1, consultorio1);
                    hospital.registrarConsulta(consulta);
                    hospital.agregarConsulta(consulta);
                    System.out.println("Consulta registrada con éxito.");

                } else {
                    System.out.println("Error: No se encontró el paciente, médico o consultorio con los IDs proporcionados.");
                }
                break;
            case 5:
                hospital.mostrarPacientes();
                break;
            case 6:
                hospital.mostrarMedicos();
                break;
            case 7:
                hospital.mostrarConsultorio();
                break;
            case 8:
                hospital.mostrarConsulta();
                break;

            case 9:
                System.out.println("Elegiste la opcion de buscar paciente por su ID");
                scanner.nextLine();
                System.out.print("Ingresa el ID del Paciente: ");
                String buscarIdPaciente = scanner.nextLine();
                hospital.mostrarPacientePorID(buscarIdPaciente);
                break;
            case 10:
                System.out.println("Elegiste la opcion de buscar medico por su ID");
                System.out.print("Ingresa el ID del Medico: ");
                String buscarIdMedico = scanner.nextLine();
                hospital.mostrarMedicoPorID(buscarIdMedico);
                break;
            case 11:
                System.out.println("Elegiste la opcion de buscar consultorio por su ID");
                System.out.print("Ingresa el ID del Consultorio: ");
                String buscarIdConsultorio = scanner.nextLine();
                hospital.mostrarConsultorioPorID(buscarIdConsultorio);
                break;
            case 12:
                System.out.println("Elegiste la opcion de buscar consulta por su ID");
                System.out.print("Ingresa el ID de la Consulta: ");
                String buscarIdConsulta = scanner.nextLine();
                hospital.mostrarConsultaPorID(buscarIdConsulta);
                break;
            case 13:
                hospital.verInformacionAdmin(administrador);
            case 14:
                System.out.println("Hasta luego");
                break;
        }
    }

    private ArrayList<String> obtenerDatosComun(Rol rol) {
        Hospital hospital = new Hospital();
        //Metodo Ternario
        String tipoUsuario = rol == Rol.PACIENTE ? "Paciente" : rol == Rol.MEDICO ? "Medico" : "Administrtador";

        ArrayList<String> datosComun = new ArrayList<>();
        System.out.println(String.format( "Ingresa el nombre del %s:", tipoUsuario));
        String nombre = scanner.nextLine();
        datosComun.add(nombre);

        System.out.println(String.format( "Ingresa el apellido del %s:", tipoUsuario));
        String apellido = scanner.nextLine();
        datosComun.add(apellido);

        System.out.println(String.format( "Ingresa el año de nacimiento del %s:", tipoUsuario));
        int anio = scanner.nextInt();
        datosComun.add(String.valueOf(anio));

        System.out.println(String.format( "Ingresa el mes de nacimiento del %s:", tipoUsuario));
        int mes = scanner.nextInt();
        datosComun.add(String.valueOf(mes));

        System.out.println(String.format( "Ingresa el dia de nacimiento del %s:", tipoUsuario));
        int dia = scanner.nextInt();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        datosComun.add(String.valueOf(fechaNacimiento));

        System.out.println(String.format( "Ingresa el telefono del %s:", tipoUsuario));
        String telefono = scanner.nextLine();
        datosComun.add(telefono);

        /*while (true) {
            System.out.println(String.format( "Ingresa el telefono del %s:", tipoUsuario));
            telefono = scanner.nextLine();
            datosComun.add(telefono);

            if (hospital.buscarMedicoPorTelefono(telefono) != null) {
                System.out.println("Error: Ya existe un médico con este número de teléfono. Inténtalo de nuevo.");
            } else {
                break;
            }
        }*/
        return datosComun;
    }
}
