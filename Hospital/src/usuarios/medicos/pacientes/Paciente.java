package usuarios.medicos.pacientes;

import usuarios.medicos.Rol;
import usuarios.medicos.Usuario;

import java.time.LocalDate;

public class Paciente extends Usuario {

        public String tipoSangre;
        public char sexo;

        public Paciente(String id, String nombre, String apellido, LocalDate fechaNacimiento, String tipoSnagre, char sexo, String telefono, String contrasenia, Rol rol) {
            super(id, nombre, apellido, fechaNacimiento, telefono, contrasenia, Rol.PACIENTE);
            this.tipoSangre = tipoSnagre;
            this.sexo = sexo;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + String.format("| Tipo de Sangre: %s | Sexo: %s | ", tipoSangre, sexo);
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public char getSexo() {
        return sexo;
    }

    public void verInformacionPaciente(Paciente paciente) {
        System.out.println("Información personal del paciente:");
        System.out.println(paciente.mostrarDatos());
    }
}
