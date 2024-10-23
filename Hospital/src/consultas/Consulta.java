package consultas;

import consultas.utils.Status;
import consultorios.Consultorio;
import usuarios.medicos.medicos.Medico;
import usuarios.medicos.pacientes.Paciente;

import java.time.LocalDateTime;

public class Consulta {

    public String id;
    public LocalDateTime fechaHora;
    public Paciente paciente;
    public Medico medico;
    public Consultorio consultorio;
    public Status status;

    public String getId() {
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
    public Status getStatus() {
        return status;
    }

    public Consulta(String id, LocalDateTime fechaHora, Paciente paciente, Medico medico, Consultorio consultorio) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
        this.status = Status.PENDIENTE;
    }

    public String mostrarDatosConsulta() {
        String datos = String.format("IdConsulta: %s | Fecho/Hora: %s | Paciente: %s | Medico: %s | Consultorio: %s", id, fechaHora, paciente, medico, consultorio);
        return datos;
    }
}
