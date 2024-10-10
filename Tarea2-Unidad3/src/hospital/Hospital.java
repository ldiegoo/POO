package hospital;
import consultas.Consulta;
import consultorios.Consultorio;
import usuarios.Usuario;
import usuarios.administradores.Administrador;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
// grabar pantalla al terminar  y subir .gif  y subirlo a github
public class Hospital {

    public Hospital() {
        Administrador administrador = new Administrador(
                "A-PE-1-2021-12345-1",
                "Pedro",
                "Perez",
                LocalDate.of(1990, 12, 12),
                "1234567890",
                "09876",23.344,"342",3);
        this.listaAdministradores.add(administrador);
        this.listaUsuarios.add(administrador);
    }


    public ArrayList <Usuario> listaUsuarios = new ArrayList<>();
    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medico> listaMedicos = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    public ArrayList<Administrador> listaAdministradores = new ArrayList<>();
    private ValidadorHospital validador = new ValidadorHospital();



    Random random = new Random();

//    metodos para registrar usuarios
    public void registrarPaciente(Paciente paciente) {
        this.listaPacientes.add(paciente);
        this.listaUsuarios.add(paciente); // no marca error porque paciente tiene extends de usuario
    }
    public void registrarMedico(Medico medico) {
        this.listaMedicos.add(medico);
        this.listaUsuarios.add(medico);
    }
    public void registrarAdministrador(Administrador admin) {
        this.listaAdministradores.add(admin);
        this.listaUsuarios.add(admin);
    }

    public void registrarConsulta(Consulta consulta) {
        // paciente no tenga consulta en esa fecha

        if(!validador.validarDispolnibilidadEnFechaConsulta(consulta.getFechaHora().toString(),consulta.getConsultorio().getNumeroConsultorio(), this.listaConsultas)){
            System.out.println("Ya existe una consulta registrada para esa fecha");
            return;
        }
        /**
         * 1. No existe una consulta en la fecha indicafa en el consultorio indicado
         * 2. Fecha valida
         * 3. Medico no tenga una consulta en esa fecha en otro consultorio
         * 4. Paciente no tenga una consulta en esa fecha
         */

        if(!validador.validarDisponibilidadMedico(consulta.getFechaHora().toString(),consulta.getMedico().getId(),this.listaConsultas)){
            System.out.println("El medico no tiene disponibilidad en esa fecha");
            return;
        }

        this.listaConsultas.add(consulta);
    }



    public void registrarConsultorio(Consultorio consultorio) {
        this.listaConsultorios.add(consultorio);
    }

//    metods para mostrar datos
    public void mostrarPacientes() {
        System.out.println("\n** Pacientes del Hospital **");
        for (Paciente paciente : this.listaPacientes) {
            System.out.println(paciente.mostrarDatos());
        }
    }
    public void mostrarMedicos() {
        for(Medico medico : this.listaMedicos) {
            System.out.println(medico.mostrarDatos());
        }
    }
    public void mostrarAdministradores() {
        for(Administrador administrador : this.listaAdministradores) {
            System.out.println(administrador.mostrarDatos());
        }
    }
    public void mostrarConsultorio() {
        for(Consultorio consultorio : this.listaConsultorios) {
            System.out.println(consultorio.mostrarDatos());
        }
    }
    public void mostrarConsultas() {
        if(this.listaConsultas.isEmpty()) {
            System.out.println("\n❈     No hay consultas registradas     ❈\n");
        } else {
            System.out.println("\n❧     Consultas del Hospital      ❧\n");
            for(Consulta consulta : this.listaConsultas) {
                System.out.println(consulta.mostrarDatos());
            }
        }
    }


//    metodo para generar el id del medico
    public String generarIdMedico(String apellido, String fechaNacimiento) {
        LocalDate fecha = LocalDate.now();
        Random random = new Random();
        String ap = apellido.substring(0, 2).toUpperCase();
        char ultimoDigito = fechaNacimiento.charAt(fechaNacimiento.length()-1);
        int yearActual = fecha.getYear();
        int aleatorio = random.nextInt(51,70001);
        int lista = listaMedicos.size()+1;
        return String.format("M-%s-%s-%d-%d-%d",
                ap,
                ultimoDigito,
                yearActual,
                aleatorio,
                lista);
    }

    //    metodo para generar el id del admin
    public String generarIdAdmin(String apellido, String fechaNacimiento) {
        LocalDate fecha = LocalDate.now();
        Random random = new Random();
        String ap = apellido.substring(0, 2).toUpperCase();
        char ultimoDigito = fechaNacimiento.charAt(fechaNacimiento.length()-1);
        int yearActual = fecha.getYear();
        int aleatorio = random.nextInt(51,70001);
        int lista = listaAdministradores.size()+1;
        return String.format("A-%s-%s-%d-%d-%d",
                ap,
                ultimoDigito,
                yearActual,
                aleatorio,
                lista);
    }

//    metodo para generar el id del paciente
    public String generarIdPaciente() {
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int anioActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudPacienteMasUno = this.listaPacientes.size()+1;
        int numeroAleatorio = random.nextInt();

        return String.format("P%d%d%d%d", anioActual, mesActual, longitudPacienteMasUno, numeroAleatorio);
    }

//    metodo para generar el id del consultorio
    public String generarIdConsultorio(){
        //C-{longitud de la lista de consultorios + 1}-{dia actual}-{año actual}-{numero aleatorio entre 1 y 500000}
        LocalDate fecha = LocalDate.now();
        int anioActual = fecha.getYear();
        int diaActual = fecha.getDayOfMonth();
        int longitudConsultorio = this.listaConsultorios.size() + 1;
        int NumAleatorio = random.nextInt(500000);
        return String.format("C%d%d%d%d",longitudConsultorio,diaActual,anioActual,NumAleatorio);
    }


//    metodos para buscar usuarios.pacientes por id
    public Paciente obtenerPacienteporId(String idPaciente) {
        return listaPacientes.stream().filter(p -> p.getId().equals(idPaciente)).findFirst().orElse(null);
    }

    public void mostrarPacienteID(String idPaciente) {
        Paciente paciente = obtenerPacienteporId(idPaciente);
        if (paciente != null) {
            System.out.println("✓    -Paciente encontrado-     ✓");
            System.out.println(paciente.mostrarDatos());
        } else {
            System.out.println("No se encontro el paciente");
        }
    }

//    metodos para buscar al medico por su id
    public Medico obtenerMedicoPorId(String idMedico) {
        return listaMedicos.stream().filter(m -> m.getId().equals(idMedico)).findFirst().orElse(null);
    }

    public void mostrarMedicoID(String medicoID) {
        Medico medico = obtenerMedicoPorId(medicoID);
        if (medico != null) {
            System.out.println("✓    -Medico encontrado-     ✓");
            System.out.println(medico.mostrarDatos());
        } else {
            System.out.println("No se encontro el medico");
        }
    }


//    mostrar consultorio por Id
    public Consultorio obtenerConsultorioPorId(String idConsultorio) {
        return listaConsultorios.stream().filter(c -> c.getId().equals(idConsultorio)).findFirst().orElse(null);
    }

    public void mostrarConsultorioID(String idConsultorio) {
        Consultorio consultorio = obtenerConsultorioPorId(idConsultorio);

        if (consultorio!= null) {
            System.out.println("✓    -Consultorio encontrado-     ✓");
            System.out.println(consultorio.mostrarDatos());
        } else {
            System.out.println("No se encontro el consultorio");

        }
    }

//    obtener lista de consultas por nombre del paciente
    public Consulta consultaPaciente(String paciente) {
        return listaConsultas.stream().filter(c -> c.getPaciente().getId().equals(paciente)).findFirst().orElse(null);
    }

//    metodo para validar que la fecha de la consult sea la correcta
    public boolean validarFechaConsulta(LocalDateTime fechaDeseada) {
        return this.validador.validarFechaCorrecta(fechaDeseada);
    }


//    metodo para obtener el telefono del paciente
    public Paciente obtenerTelefonoPaciente(String telefonoPaciente) {
        return listaPacientes.stream().filter(p -> p.getTelefono().equals(telefonoPaciente)).findFirst().orElse(null);
    }

//    metodo para obtener el telefono del medico
    public Medico obtenerTelefonoMedico(String telefonoMedico) {
        return listaMedicos.stream().filter(m -> m.getTelefono().equals(telefonoMedico)).findFirst().orElse(null);
    }
    //    metodo para obtener el telefono del admin
    public Administrador obtenerTelefonoAdmin(String telefonoAdmin) {
        return listaAdministradores.stream().filter(a -> a.getTelefono().equals(telefonoAdmin)).findFirst().orElse(null);
    }

//    metodo para obtener el rfc del medico
    public Medico obtenerRfcMedico(String rfc) {
        return listaMedicos.stream().filter(m -> m.getRfc().equals(rfc)).findFirst().orElse(null);
    }

    //    metodo para obtener el rfc del admin
    public Administrador obtenerRfcAdmin(String rfc) {
        return listaAdministradores.stream().filter(a -> a.getRfc().equals(rfc)).findFirst().orElse(null);
    }

    public void mostrarConsultasPorPaciente(String idPaciente) {
        List<Consulta> consultasDelPaciente = listaConsultas.stream()
                .filter(c -> c.getPaciente().getId().equals(idPaciente))
                .collect(Collectors.toList());

        if (consultasDelPaciente.isEmpty()) {
            System.out.println("No se encontraron consultas: ");
        } else {
            System.out.println("Consultas registradas: ");
            for (Consulta consulta : consultasDelPaciente) {
                System.out.println(consulta.mostrarDatos());
            }
        }
    }


    public void mostrarConsultasPorMedico(String idMedico) {
        List<Consulta> consultasDelMedico = listaConsultas.stream()
                .filter(c -> c.getMedico().getId().equals(idMedico))
                .collect(Collectors.toList());

        if (consultasDelMedico.isEmpty()) {
            System.out.println("No se encontraron consultas: ");
        } else {
            System.out.println("Consultas registradas: ");
            for (Consulta consulta : consultasDelMedico) {
                System.out.println(consulta.mostrarDatos());
            }
        }
    }
    public List<String> obtenerNombresPacientesPorMedico(String idMedico) {
        return listaConsultas.stream()
                .filter(c -> c.getMedico().getId().equals(idMedico))
                .map(c -> c.getPaciente().mostrarDatos().concat("\n"))
                .collect(Collectors.toList());
    }

    public  Usuario validarInicioSesion(String idUsuario, String contrasenia) {
        for(Usuario usuario : this.listaUsuarios) {
            if(usuario.getId().equals(idUsuario) &&
                    usuario.getContrasenia().equals(contrasenia)) {
                return usuario;
            }
        }
        return null;
    }

//    metodos privados
}


