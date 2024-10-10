package menu;

import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import usuarios.Usuario;
import usuarios.administradores.Administrador;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import usuarios.utils.Rol;

public class Menu {
    public Hospital hospital = new Hospital();
    private Scanner scanner = new Scanner(System.in);


    public void login(){

        Administrador administrador = new Administrador(
            "001",
            "admin",
            "1",
            LocalDate.of(2004,9,17),
            "443 333 182", 
            "***",
            15000,
            "refadmin123",
            10
            );
            hospital.registrarAdministrador(administrador);

        int intentosMAXIMOS = 3, intentosUsuario = 0;
        System.out.println("BIENVENIDO");
        System.out.println("Inicia sesion para continuar");

        while(intentosUsuario < intentosMAXIMOS) {

            System.out.println("Ingresa el  usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa la contrasenia: ");
            String contrasenia = scanner.nextLine();

            Usuario usuarioEnSesion = hospital.validarInicioSesion(usuario,contrasenia); // Usuario || null
            if (usuarioEnSesion instanceof Usuario) {
                if(usuarioEnSesion.getRol() == Rol.PACIENTE) {
                    Paciente pacienteEnSesion = (Paciente) usuarioEnSesion;
                    this.mostrarMenuPaciente(pacienteEnSesion);
                    intentosUsuario=0;
                } else if(usuarioEnSesion.getRol() == Rol.MEDICO) {
                    Medico medicoEnSesion = (Medico) usuarioEnSesion;
                    this.mostrarMenuMedico(medicoEnSesion);
                    intentosUsuario=0;
                } else if(usuarioEnSesion.getRol() == Rol.ADMINISTRADOR) {
                    this.mostrarMenuAdmin();
                    intentosUsuario=0;
                }
            } else {
                intentosUsuario = mostrarErorInicioSesion(intentosUsuario);
            }
        }
    }

    private int mostrarErorInicioSesion(int intentoUsuario){
        System.out.println("\nUsuario o contrasenia incorrectos\n");
        return intentoUsuario + 1;
    }

    private void mostrarMenuPaciente(Paciente paciente){
        System.out.print("Ingresa tu Id: ");
        String id = scanner.nextLine();

        int opcion = 0;
        while(opcion !=2) {
            System.out.println("\n****BIENVENIDO****");
            System.out.println("1. Ver consultas");
            System.out.println("2. Salir");

            System.out.println("Selecciona una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    //ver consultas
                    System.out.println("\n--Seleccionaste la opción de ver consultas--");
                    hospital.mostrarConsultasPorPaciente(id);
                    break;
                case 2:
                    System.out.println("Saliendo del sistema");
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Numero no esta dentro de las opciones");
            }
        }
        scanner.nextLine();
    }


    private void mostrarMenuMedico(Medico medico){
        System.out.print("Ingresa tu Id: ");
        String id = scanner.nextLine();
        int opcion2 = 0;
        while(opcion2 !=3) {
            System.out.println("\n****BIENVENIDO****");
            System.out.println("1. Ver consultas");
            System.out.println("2. Ver mis usuarios.pacientes");
            System.out.println("3. Consultar Paciente");
            System.out.println("4. Salir");

            System.out.println("Selecciona una opcion: ");
            opcion2 = scanner.nextInt();
            switch (opcion2) {
                case 1:
                    //ver consultas
                    System.out.println("\n--Seleccionaste la opción de ver consultas--");
                    hospital.mostrarConsultasPorMedico(id);
                    break;
                case 2:
//                    ver mis usuarios.pacientes
                    System.out.println(hospital.obtenerNombresPacientesPorMedico(id));
                    break;
                case 3:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Numero no esta dentro de las opciones");
            }
        }
        scanner.nextLine();
    }


//    metodo para el menu de opciones
    private void mostrarMenuAdmin() {
        int opcion=0;

        while(opcion !=14) {
            System.out.println("\n****BIENVENIDO****");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Registrar medico");
            System.out.println("3. Registrar consultorio");
            System.out.println("4. Registrar consulta");
            System.out.println("5. Mostrar pacientes");
            System.out.println("6. Mostrar medicos");
            System.out.println("7. Mostrar consultorios");
            System.out.println("8. Mostrar consultas");
            System.out.println("9. Buscar pacientes por Id");
            System.out.println("10. Buscar medicos por Id");
            System.out.println("11. Buscar consultorios por Id");
            System.out.println("12. Registrar administrador");
            System.out.println("13. Mostrar administradores");
            System.out.println("14. Salir");
            System.out.print("\nSelecciona una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    //registrar paciente
                    System.out.println("\n Seleccionaste la opcion de registrar a un paciente");
                    scanner.nextLine();

                    System.out.println("Ingresa el nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Ingresa los apellidos: ");
                    String apellidos = scanner.nextLine();

                    System.out.println("Ingresa la contrasenia: ");
                    String contrasenia = scanner.nextLine();

                    System.out.println("Ingresa el anio de nacimiento: ");
                    int anioNacimiento = scanner.nextInt();

                    System.out.println("Ingresa el mes de nacimiento: ");
                    int mesNacimiento = scanner.nextInt();

                    System.out.println("Ingresa el dia de nacimiento: ");
                    int diaNacimiento = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ingresa el tipo de sangre: ");
                    String tipoSangre = scanner.nextLine();


                    System.out.println("Ingresa el sexo: ");
                    char sexo = scanner.nextLine().charAt(0);

                    String telefono = null;
                    while(telefono == null) {

                        System.out.println("Ingresa el telefono: ");
                        telefono = scanner.nextLine();
                        Paciente telefonoPaciente = hospital.obtenerTelefonoPaciente(telefono);
                        if(telefonoPaciente != null) {
                            System.out.println("\n☏☏    Ya existe ese numero de telefono, intenta con otro    ☏☏\n");
                            telefono = null;
                        }
                    }

                    String idPaciente = hospital.generarIdPaciente();
                    LocalDate fechaNacimiento = LocalDate.of(anioNacimiento,mesNacimiento,diaNacimiento);

                    Paciente paciente = new Paciente(idPaciente,nombre, apellidos,fechaNacimiento,tipoSangre,sexo,telefono, contrasenia);
                    hospital.registrarPaciente(paciente);
                    System.out.println("Paciente registrado exitosamente");
                    break;
                case 2:
                    //registrar medico
                    System.out.println("\n Seleccionaste la opcion de registrar a un medico");
                    scanner.nextLine();

                    System.out.println("Ingresa el nombre: ");
                    String nombreMedico = scanner.nextLine();


                    System.out.println("Ingresa los apellidos: ");
                    String apellidosMedico = scanner.nextLine();

                    System.out.println("Ingresa la contrasenia: ");
                    String contraseniaMedico = scanner.nextLine();

                    System.out.println("Ingresa el año de nacimiento: ");
                    int anioNacimientoMedico = scanner.nextInt();

                    System.out.println("Ingresa el mes de nacimiento: ");
                    int mesNacimientoMedico = scanner.nextInt();

                    System.out.println("Ingresa el dia de nacimiento: ");
                    int diaNacimientoMedico = scanner.nextInt();
                    scanner.nextLine();

                    LocalDate fechaNacimientoMedico = LocalDate.of(anioNacimientoMedico,mesNacimientoMedico,diaNacimientoMedico);

//                  metodo para verificar si no existe otro medico con ese telefono
                    String telefonoMedico = null;
                    while(telefonoMedico == null) {

                        System.out.println("Ingresa el telefono: ");
                        telefonoMedico = scanner.nextLine();
                        Medico telefonoMedico1 = hospital.obtenerTelefonoMedico(telefonoMedico);
                        if(telefonoMedico1 != null) {
                            System.out.println("\n☏☏    Ya existe ese numero de telefono, intenta con otro    ☏☏\n");
                            telefonoMedico = null;
                        }
                    }

//                    metodo para verificar si no existe es rfc en el sistema
                    String rfc = null;
                    while(rfc == null) {

                        System.out.println("Ingresa el RFC: ");
                        rfc = scanner.nextLine();
                        Medico rfcMedico1 = hospital.obtenerRfcMedico(rfc);
                        if(rfcMedico1 != null) {
                            System.out.println("\n☏☏    Ya existe ese RFC, intenta con otro    ☏☏\n");
                            rfc = null;
                        }
                    }


                    String idMedico = hospital.generarIdMedico(apellidosMedico,String.valueOf(fechaNacimientoMedico));

                    Medico medico = new Medico(idMedico, nombreMedico,apellidosMedico,fechaNacimientoMedico,telefonoMedico,rfc, contraseniaMedico);
                    hospital.registrarMedico(medico);
                    System.out.println("Medico registrado exitosamente");
                    break;
                case 3:
                    //registrar consultorio
                    System.out.println("\n Seleccionaste la opcion de registrar a un consultorio");

                    System.out.println("Ingresa el piso ");
                    int piso = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ingresa el numero de consultorio: ");
                    int numeroConsultorio = scanner.nextInt();

                    String idConsultorio = hospital.generarIdConsultorio();

                    Consultorio consultorio = new Consultorio(idConsultorio,piso,numeroConsultorio);
                    hospital.registrarConsultorio(consultorio);
                    break;
                case 4:
                    //registrar consulta
                    System.out.println("\n Seleccionaste la opcion de registrar una consulta");
                    scanner.nextLine();

//                    metodo para validar la fecha correta
                    LocalDateTime fechaConsulta = null;
                    while(fechaConsulta == null) {

                        System.out.println("Ingresa el año de la consulta: ");
                        int anioConsulta = scanner.nextInt();
                        System.out.println("Ingresa el mes de la consulta: ");
                        int mesConsulta = scanner.nextInt();
                        System.out.println("Ingresa el dia de la consulta: ");
                        int diaConsulta = scanner.nextInt();
                        System.out.println("Ingresa la hora de la consulta: ");
                        int horaConsulta = scanner.nextInt();
                        System.out.println("Ingresa los minutos de la consulta: ");
                        int minutosConsulta = scanner.nextInt();
                        fechaConsulta = LocalDateTime.of(anioConsulta,mesConsulta,diaConsulta,horaConsulta,minutosConsulta);

                        if (!hospital.validarFechaConsulta(fechaConsulta)) {

                            System.out.println("\nLa fecha no puede estar en el pasado, intenta de nuevo\n");
                            fechaConsulta = null;
                        }
                        scanner.nextLine();
                    }


//                    metodo para validar existencia del paciente
                    Paciente pacienteParaConsulta = null;
                    while (pacienteParaConsulta == null) {

                        System.out.println("Ingresa el id del paciente: ");
                        String pacienteConsulta = scanner.nextLine();
                        pacienteParaConsulta = hospital.obtenerPacienteporId(pacienteConsulta); // paciente | null

                        if(pacienteParaConsulta == null) {
                            System.out.println("\nNo se encontro el paciente, intenta de nuevo\n");
                        }
                    }

//                    metodo para validar existencia del medico
                    Medico medicoParaConsulta = null;
                    while (medicoParaConsulta == null) {

                        System.out.println("Ingresa el id del medico: ");
                        String medicoConsulta = scanner.nextLine();
                        medicoParaConsulta = hospital.obtenerMedicoPorId(medicoConsulta);
                        if(medicoParaConsulta == null) {
                            System.out.println("\nMedico no encontrado, intenta de nuevo\n");
                        }

                    }

//                    metodo para validar existencia del consultorio
                    Consultorio consultorioParaConsulta = null;
                    while (consultorioParaConsulta == null) {

                        System.out.println("Ingresa el id del consultorio: ");
                        String consultorioConsulta = scanner.nextLine();
                        consultorioParaConsulta = hospital.obtenerConsultorioPorId(consultorioConsulta);
                        if(consultorioParaConsulta == null) {
                            System.out.println("\nConsultorio no encontrado, intenta de nuevo\n");
                        }
                    }

                    Consulta consulta = new Consulta(fechaConsulta,pacienteParaConsulta,medicoParaConsulta,consultorioParaConsulta);

                    hospital.registrarConsulta(consulta);
                    System.out.println(hospital.listaConsultas.get(0));

                    break;
                case 5:
                    //mostrar usuarios.pacientes
                    System.out.println("\n--Seleccionaste la opción de mostrar usuarios.pacientes--");
                    hospital.mostrarPacientes();
                    break;
                case 6:
                    //mostrar usuarios.medicos
                    System.out.println("\n--Seleccionaste la opción de mostrar usuarios.medicos--");
                    hospital.mostrarMedicos();
                    break;
                case 7:
                    //mostrar consultorios
                    System.out.println("\n--Seleccionaste la opción de mostrar consultorios--");
                    hospital.mostrarConsultorio();
                    break;
                case 8:
                    //mostrar consultas
                    hospital.mostrarConsultas();
                    break;
                case 9:
                    // Buscar usuarios.pacientes por Id
                    System.out.println("\nAccediste a la opcion de buscar paciente por su Id: ");
                    System.out.print("Ingresa el Id del paciente: ");
                    scanner.nextLine();
                    String idPacienteBuscar = scanner.nextLine();
                    hospital.mostrarPacienteID(idPacienteBuscar);
                    break;
                case 10:
//                    mostrar usuarios.medicos por el id
                    System.out.println("\nAccediste a la opcion de mostrar usuarios.medicos por su Id");
                    System.out.print("Ingresa el Id del medico: ");
                    scanner.nextLine();
                    String idMedicoBuscar = scanner.nextLine();
                    hospital.mostrarMedicoID(idMedicoBuscar);
                    break;
                case 11:
//                    mostrarConsultorio por ID
                    System.out.println("\nAccediste a la opcion de mostrar consultorio por su Id");
                    System.out.print("Ingresa el Id del consultorio: ");
                    scanner.nextLine();
                    String idConsultorioBuscar = scanner.nextLine();
                    hospital.mostrarConsultorioID(idConsultorioBuscar);
                    break;
                case 12:
//                    opcion para registrar un admin
                    System.out.println("\nAccediste a la opcion de registrar un administrador");
                    scanner.nextLine();

                    System.out.println("Ingresa el nombre: ");
                    String nombreAdmin = scanner.nextLine();


                    System.out.println("Ingresa los apellidos: ");
                    String apellidosAdmin = scanner.nextLine();

                    System.out.println("Ingresa la contrasenia: ");
                    String contraseniaAdmin = scanner.nextLine();

                    System.out.println("Ingresa el año de nacimiento: ");
                    int anioNacimientoAdmin = scanner.nextInt();

                    System.out.println("Ingresa el mes de nacimiento: ");
                    int mesNacimientoAdmin = scanner.nextInt();

                    System.out.println("Ingresa el dia de nacimiento: ");
                    int diaNacimientoAdmin = scanner.nextInt();
                    scanner.nextLine();

                    LocalDate fechaNacimientoAdmin = LocalDate.of(anioNacimientoAdmin,mesNacimientoAdmin,diaNacimientoAdmin);

//                  metodo para verificar si no existe otro medico con ese telefono
                    String telefonoAdmin = null;
                    while(telefonoAdmin == null) {

                        System.out.println("Ingresa el telefono: ");
                        telefonoAdmin = scanner.nextLine();
                        Administrador telefonoAdmin1 = hospital.obtenerTelefonoAdmin(telefonoAdmin);
                        if(telefonoAdmin1 != null) {
                            System.out.println("\n☏☏    Ya existe ese numero de telefono, intenta con otro    ☏☏\n");
                            telefonoAdmin = null;
                        }
                    }

//                    metodo para verificar si no existe es rfc en el sistema
                    String rfcAdmin = null;
                    while(rfcAdmin == null) {

                        System.out.println("Ingresa el RFC: ");
                        rfcAdmin = scanner.nextLine();
                        Administrador rfcAdmin1 = hospital.obtenerRfcAdmin(rfcAdmin);
                        if(rfcAdmin1 != null) {
                            System.out.println("\n☏☏    Ya existe ese RFC, intenta con otro    ☏☏\n");
                            rfcAdmin = null;
                        }
                    }

                    System.out.println("Ingresa tu sueldo quincenal: ");
                    double sueldo = scanner.nextDouble();

                    System.out.println("Ingresa los anios que llevas laborando: ");
                    int antiguedad = scanner.nextInt();

                    String idAdmin = hospital.generarIdAdmin(apellidosAdmin,String.valueOf(fechaNacimientoAdmin));

                    Administrador administrador = new Administrador(idAdmin,nombreAdmin,apellidosAdmin,fechaNacimientoAdmin,telefonoAdmin, contraseniaAdmin,sueldo,rfcAdmin,antiguedad);
                    hospital.registrarAdministrador(administrador);

                    break;
                case 13:
//                    mostrar administradores
                    hospital.mostrarAdministradores();
                    break;
                case 14:
                    System.out.println("\n♛♛    Saliendo del sistema    ♛♛\n");
                    break;
                default:
                    System.out.println("\n☩ : ☩   Numero no esta dentro de las opciones   ☩ : ☩\n");
            }
        }
    }
}
