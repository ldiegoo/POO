package consultas;

import consultorios.Consultorio;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;

import java.time.LocalDateTime;
import java.util.Random;

public class Consulta {
    public int id;
    public LocalDateTime fechaHora;
    public Paciente paciente;
    public Medico medico;
    public Consultorio consultorio;

    Random random = new Random();

//    constructor
    public Consulta(LocalDateTime fechaHora, Paciente paciente, Medico medico, Consultorio consultorio) {
        this.id = this.random.nextInt(1,10001);
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }

    public String mostrarDatos() {
        return String.format("Id: %d, Fechay Hora: %s, Id Paciente: %s, Paciente: %s, Id Medico: %s, Medico %s, Piso Consultorio: %d, Numero Consultorio: %d",
                getId(),
                getFechaHora(),
                paciente.getId(),
                paciente.getNombre(),
                medico.getId(),
                medico.getNombre(),
                consultorio.getPiso(),
                consultorio.getNumeroConsultorio());
    }

//    getter

    public int getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }
}

