package usuarios.medicos.medicos;

import usuarios.medicos.Rol;
import usuarios.medicos.Usuario;

import java.time.LocalDate;

public class Medico extends Usuario {

    private String rfc;

    public Medico(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String rfc, String contrasenia) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, contrasenia,Rol.MEDICO);
        this.rfc = rfc;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + String.format("| RFC: %s", rfc);
    }

    public String getRfc() {
        return rfc;
    }

}
