package hospital;

import consultas.Consulta;
import consultorios.Consultorio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import usuarios.medicos.Rol;
import usuarios.medicos.Usuario;
import usuarios.medicos.administradores.Administrador;
import usuarios.medicos.medicos.Medico;
import usuarios.medicos.pacientes.Paciente;

public class Hospital {
    public ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medico> listaMedicos = new ArrayList<>();
    public ArrayList<Consulta> consultasProgramadasMedico = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    public ArrayList<Administrador> listaAdministradores = new ArrayList<>();
    private ValidadorHospital validador = new ValidadorHospital();
    private  Scanner scanner = new Scanner(System.in);
    private Rol rol;

    public Hospital() {
        Administrador admin = new Administrador("AD01", "Pedro", "Perez", LocalDate.of(1990, 12, 12), "1234567890", "09876",23344,"342",3);
        this.listaUsuarios.add(admin);
        this.listaAdministradores.add(admin);
    }

    public void registrarPaciente(Paciente paciente) {
        this.listaPacientes.add(paciente);
        this.listaUsuarios.add(paciente);
    }
    public void registrarMedico(Medico medico) {
        this.listaMedicos.add(medico);
        this.listaUsuarios.add(medico);
    }

    public void registrarConsulta(Consulta consulta) {
        if (!validador.validarDisponibilidadEnFechaConsulta(consulta.getFechaHora(), consulta.getConsultorio().getNumConsultorio(), this.listaConsultas)) {
            System.out.println("Ya existe una consulta registrada para esa fecha");
            return;
        }
        if (!validador.validarDisponibilidadMedico(consulta.getFechaHora(), consulta.getMedico().getId(), this.listaConsultas)) {
            System.out.println("El médico no tiene disponibilidad para esa fecha");
            return;

        }

        this.listaConsultas.add(consulta);
    }

    public void registrarConsultorio(Consultorio consultorio) {
        this.listaConsultorios.add(consultorio);
    }

    public void mostrarPacientes() {
        System.out.println("\n** Pacientes del Hosopital **");
        for (Paciente paciente : this.listaPacientes) {
            System.out.println(paciente.mostrarDatos());
        }
    }

    public void mostrarMedicos() {
        System.out.println("\n** Medicos del Hosopital **");
        for (Medico medicos : this.listaMedicos) {
            System.out.println(medicos.mostrarDatos());
        }
    }

    public void mostrarConsultorio() {
        System.out.println("\n** Consultorios del Hospital **");
        for (Consultorio consultorios : this.listaConsultorios) {
            System.out.println(consultorios.mostrarDatosConsultorio());
        }
    }

    public void mostrarConsulta() {
        System.out.println("\n** Consultas del Hospital **");
        for (Consulta consulta : this.listaConsultas) {
            System.out.println(consulta.mostrarDatosConsulta());
        }
    }

    public String generarIdPaciente() {
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int anioActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudPacienteMasUno = this.listaPacientes.size()+1;
        int numeroAleatorio = random.nextInt();

        String idPaciente = String.format("P%d%d%d%d", anioActual, mesActual, longitudPacienteMasUno, numeroAleatorio);
        return idPaciente;
    }

    public Paciente obtenerPacientePorId(String idPaciente){
        return listaPacientes.stream().filter(p -> p.getId().equals(idPaciente)).findFirst().orElse(null);

    }

    //Mostrar paciente por ID
    public void mostrarPacientePorID(String idPaciente) {
        Paciente paciente = obtenerPacientePorId(idPaciente);

        if (paciente != null) {
            System.out.println(paciente.mostrarDatos());
        } else {
            System.out.println("No se encontro el paciente");
        }
    }

    public String generarIdMedico() {
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int anioActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudMedicoMasUno = this.listaMedicos.size()+1;
        int numeroAleatorio = random.nextInt();

        String idMedico = String.format("P%d%d%d%d", anioActual, mesActual, longitudMedicoMasUno, numeroAleatorio);
        return idMedico;
    }

//Mostrar Medico por su ID
    public void mostrarMedicoPorID(String idMedico) {
        Optional<Medico> medicoEncontrado = this.listaMedicos.stream().filter(medico -> medico.getId().equals(idMedico)).findFirst();

        if (medicoEncontrado.isPresent()) {
            System.out.println(medicoEncontrado.get().mostrarDatos());
        } else {
            System.out.println("No se encontro el paciente");
        }
    }

    public String generarIdConsultorio() {
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int anioActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudConsultorioMasUno = this.listaConsultorios.size()+1;
        int numeroAleatorio = random.nextInt();

        String idConsultorio = String.format("P%d%d%d%d", anioActual, mesActual, longitudConsultorioMasUno, numeroAleatorio);
        return idConsultorio;
    }

//Mostrar Consultorio por ID
    public void mostrarConsultorioPorID(String idConsultorio) {
        Optional<Consultorio> consultorioEncontrado = this.listaConsultorios.stream().filter(consultorio -> consultorio.getId().equals(idConsultorio)).findFirst();

        if (consultorioEncontrado.isPresent()) {
            System.out.println(consultorioEncontrado.get().mostrarDatosConsultorio());
        } else {
            System.out.println("No se encontro el paciente");
        }
    }

    public String generarIdConsulta() {
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int anioActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudConsultasMasUno = this.listaConsultas.size()+1;
        int numeroAleatorio = random.nextInt();

        String idConsulta = String.format("P%d%d%d%d", fecha, anioActual, mesActual, longitudConsultasMasUno, numeroAleatorio);
        return idConsulta;
    }

    public void mostrarConsultaPorID(String idConsulta) {
        Optional<Consulta> consultaEncontrada = this.listaConsultas.stream().filter(consulta -> consulta.getId().equals(idConsulta)).findFirst();

        if (consultaEncontrada.isPresent()) {
            System.out.println(consultaEncontrada.get().mostrarDatosConsulta());
        } else {
            System.out.println("No se encontro la consulta");
        }
    }

    public Consultorio mostrarIdConsultorio(String idConsultorio) {
        for (Consultorio consultorio : listaConsultorios) {
            if (consultorio.getId().equals(idConsultorio)) {
                return consultorio;
            }
        }
        return null;
    }

    public Medico mostrarIdMedico(String idMedico) {
        for (Medico medico : listaMedicos) {
            if (medico.getId().equals(idMedico)) {
                return medico;
            }
        }
        return null;
    }

    public Paciente mostrarIdPaciente(String idPaciente) {
        for (Paciente paciente : listaPacientes) {
            if (paciente.getId().equals(idPaciente)) {
                return paciente;
            }
        }
        return null;
    }

    public Paciente buscarPacientePorTelefono(String tel) {
        for (Paciente paciente : listaPacientes) {
            if (paciente.getTelefono().equals(tel)) {
                return paciente;
            }
        }
        return null;
    }

    public Medico buscarMedicoPorTelefono(String telMedico) {
        for (Medico medico : listaMedicos) {
            if (medico.getTelefono().equals(telMedico)) {
                return medico;
            }
        }
        return null;
    }

    public Medico buscarMedicoPorRFC(String rfcMedico) {
        for (Medico medico : listaMedicos) {
            if (medico.getRfc().equals(rfcMedico)) {
                return medico;
            }
        }
        return null;
    }

    public Usuario validarInicioSesion(String idUsuario, String contrasenia) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId().equals(idUsuario) && usuario.getContrasenia().equals(contrasenia)) {
                return usuario;
            }
        }
        return null;
    }

    public void verCOnsultasPaciente(String idPaciente) {
        boolean existenConsultas = false;

        for (Consulta consulta : listaConsultas) {
            if(idPaciente.equals(consulta.getPaciente().getId())) {
                existenConsultas = true;
            }
        }
    }

    public void agregarConsulta(Consulta consulta) {
        consultasProgramadasMedico.add(consulta);
    }

    public void verConsultasProgramadas() {
        if (consultasProgramadasMedico.isEmpty()) {
            System.out.println("No tienes consultas programadas.");
        } else {
            System.out.println("Consultas programadas:");
            for (Consulta consulta : consultasProgramadasMedico) {
                System.out.println(consulta);
            }
        }
    }

    public void verInformacionPaciente(Paciente paciente) {
        System.out.println("Información personal del paciente:");
        System.out.println(paciente.mostrarDatos());
    }

    public void verInformacionMedico(Medico medico) {
        System.out.println("Información personal del medico:");
        System.out.println(medico.mostrarDatos());
    }

    public void verInformacionAdmin(Administrador administrador) {
        System.out.println("Información personal del admin:");
        System.out.println(administrador.mostrarDatos());
    }
//Validaciones
private ArrayList<String> obtenerDatosComun(Rol rol, Hospital hospital) {
        //Metodo Ternario
        String tipoUsuario = rol == Rol.PACIENTE ? "Paciente" : rol == Rol.MEDICO ? "Medico" : "Administrtador";

        ArrayList<String> datosComun = new ArrayList<>();
        System.out.println(String.format( "Ingresa el nombre del %s:", tipoUsuario));
        String nombre = scanner.nextLine();
        datosComun.add(nombre);

        System.out.println(String.format( "Ingresa el apellido del %s:", tipoUsuario));
        String apellido = scanner.nextLine();
        datosComun.add(apellido);

        datosComun.add(obtenerFechaNacimientoUsuario(tipoUsuario));

        datosComun.add(obtenerTelefonoUsuario(tipoUsuario));

        return datosComun;
    }

    private boolean validarTelefonoRepetido(ArrayList<? extends Usuario> listaUsuarios, String telefono) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getTelefono().equals(telefono)) {
                System.out.println("Ya existe un ususario con ese telefono. Intenta de nuevo");
                return false;
            }
        }
        return true;
    }

    private String obtenerFechaNacimientoUsuario( String tipoUsuario) {
        boolean esFechaValuda = false;
        LocalDate fechaNacimiento = LocalDate.now();

        while (!esFechaValuda) {
            System.out.println(String.format( "Ingresa el año de nacimiento del %s:", tipoUsuario));
            int anio = scanner.nextInt();

            System.out.println(String.format( "Ingresa el mes de nacimiento del %s:", tipoUsuario));
            int mes = scanner.nextInt();

            scanner.nextLine();

            System.out.println(String.format( "Ingresa el dia de nacimiento del %s:", tipoUsuario));
            int dia = scanner.nextInt();

            fechaNacimiento = LocalDate.of(anio, mes, dia);

            if (fechaNacimiento.isAfter(LocalDate.now())) {
                System.out.println("La fecha de nacimiento no puede ser posterior al dia de hoy");
            }else {
                esFechaValuda = true;
            }
        }
        return fechaNacimiento.toString();
    }

    private String obtenerTelefonoUsuario(String tipoUsuario) {
        boolean esTelefonoValido = false;
        Hospital hospital = new Hospital();
        while (!esTelefonoValido) {
            String telefono;
            System.out.println(String.format("Ingresa el telefono del %s:", tipoUsuario));
            telefono = scanner.nextLine();
            esTelefonoValido = validarTelefonoRepetido(rol == Rol.MEDICO ? hospital.listaPacientes : hospital.listaMedicos, tipoUsuario);
        }
    return tipoUsuario;
    }
    private boolean validarEmailRepetido(ArrayList<? extends Usuario> listaUsuarios, String email) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getTelefono().equals(email)) {
                System.out.println("Ya existe un usuario con ese email. Intenta de nuevo");
                return false;
            }
        }
        return true;
    }
    private String obtenerTEmailUsuario(String tipoUsuario) {
        
        boolean esEmailValido = false;
        Hospital hospital = new Hospital();
        while (!esEmailValido) {
            String Email;
            System.out.println(String.format("Ingresa el telefono del %s:", tipoUsuario));
            Email = scanner.nextLine();
            esEmailValido = validarTelefonoRepetido(rol == Rol.MEDICO ? hospital.listaPacientes : hospital.listaMedicos, tipoUsuario);
        }
        return tipoUsuario;   
    }
}
