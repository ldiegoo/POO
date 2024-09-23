package hospital;

import consultas.Consulta;
import consultorios.Consultorio;
import medicos.Medico;
import pacientes.Paciente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Hospital {

    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medico> listaMedicos = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    private ValidadorHospital validador = new ValidadorHospital();

    public void registrarPacientes(Paciente paciente) {
        this.listaPacientes.add(paciente);
    }

    public void registrarMedico(Medico medico) {
        this.listaMedicos.add(medico);
    }

    public void registrarConsulta(Consulta consulta) {
        //  No exista una consulta en la fecha deseada
        if (!validador.validarDisponibilidadEnFechaConsulta(consulta.getFechaHora(), consulta.getConsultorio().getNumeroConsultorio(), this.listaConsultas)) {
            System.out.println("Ya existe una consulta registrada para esa fecha");
            return;
        }

        // Validar disponibilidad del médico
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
        System.out.println("\n** Pacientes del Hospital **");
        for (Paciente paciente : this.listaPacientes) {
            System.out.println(paciente.mostrarDatos());
        }
    }
    public void mostrarMedicos() {
        System.out.println("\n** Medicos del Hospital **");
        for (Medico medico : this.listaMedicos) {
            System.out.println(medico.mostrarMedico());
        }
    }
    public void mostrarConsultorio(){
        System.out.println("** Consultorios del Hospital **");
        for (Consultorio consultorio : this.listaConsultorios) {
            System.out.println(consultorio.mostrarConsultorio());
        }
    }
    public void mostrarPacienteID(String id) {
        Optional<Paciente> pacienteEncontrado = this.listaPacientes.stream().filter(paciente -> paciente.getId().equals(id)).findFirst();

        if (pacienteEncontrado.isPresent()) {
            System.out.println(pacienteEncontrado.get().mostrarDatos());
        } else {
            System.out.println("No se encontro el paciente");
        }
       /* for (Paciente paciente: this.listaPacientes) {
            if (paciente.getId().equals(id)) {
                System.out.println(paciente.mostrarDatos());
                return;
            } else {
                System.out.println("Paciente no encontrado");
                return;
            }*/

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
    public String generarIdMedico(String letrasApellidos, char ultimoDigitoNaci){
        //M-{Primeras 2 letras de su apellido} - {ultimo dígito de su año de nacimiento} - {año actual} - {numero aleatorio entre 50 y 700000} - {longitud de la lista de medicos + 1}
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int anioActual = fecha.getYear();
        int longitudMedicoMasUno = this.listaMedicos.size() + 1;
        int numeroAleatorio = random.nextInt(700000+50);

        String idMedico = String.format("M%s%c%d%d%d",letrasApellidos, ultimoDigitoNaci, anioActual, numeroAleatorio,longitudMedicoMasUno);
        return idMedico;
    }
    public String generarIdConsultorio(){
        //C-{longitud de la lista de consultorios + 1}-{dia actual}-{año actual}-{numero aleatorio entre 1 y 500000}
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int anioActual = fecha.getYear();
        int diaActual = fecha.getDayOfMonth();
        int longitudConsultorio = this.listaConsultorios.size() + 1;
        int NumAleatorio = random.nextInt(500000);
        String idConsultorio =String.format("C%d%d%d",longitudConsultorio,diaActual,anioActual,NumAleatorio);
        return idConsultorio;
    }

public void mostrarMedicoPorId(String id){
Optional<Medico> medicoEncontrado=this.listaMedicos.stream().filter(medico -> medico.getId().equals(id)).findFirst();
if (medicoEncontrado.isPresent()) {
    System.out.println(medicoEncontrado.get().mostrarMedico());
}else{
    System.out.println("No se encontro el medico");
}
}
public void mostrarConsultorioPorId(String id){
        Optional<Consultorio> consultorioEncontrado =listaConsultorios.stream().filter(consultorio -> consultorio.getId().equals(id)).findFirst();
        if (consultorioEncontrado.isPresent()) {
            System.out.println(consultorioEncontrado.get().mostrarConsultorio());
        }else {
            System.out.println("No se encontro el consultorio");
        }
}
} // fin hospital