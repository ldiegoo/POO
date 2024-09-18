package consultas;

import consultorios.Consultorio;
import medicos.Medico;
import pacientes.Paciente;

public class Consulta {
    public int id;
    public String fecha;
    public String hora;
    public Paciente paciente;
    public Medico medico;
    public Consultorio consultorio;

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
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
