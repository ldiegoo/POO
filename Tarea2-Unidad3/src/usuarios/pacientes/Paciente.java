package usuarios.pacientes;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Paciente extends Usuario {
    public String tipoSangre;
    public char sexo;

//constructor
    public Paciente(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String tipoSangre, char sexo, String telefono, String contrasenia) {
        super(id, nombre, apellidos, fechaNacimiento, telefono,Rol.PACIENTE,contrasenia);
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
    }

    public String mostrarDatos() {
        return String.format("Id: %s, nombre: %s, apellidos: %s, fecha de nacimiento: %s, tipo de sangre: %s, sexo: %c, teléfono: %s",
                getId(),
                getNombre(),
                getApellidos(),
                getFechaNacimiento(),
                getTipoSangre(),
                getSexo(),
                getTelefono()
        );
    }


    public String getTipoSangre() {
        return tipoSangre;
    }

    public char getSexo() {
        return sexo;
    }


}
