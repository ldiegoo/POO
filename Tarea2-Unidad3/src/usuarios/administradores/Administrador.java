package usuarios.administradores;

import java.time.LocalDate;
import usuarios.Usuario;
import usuarios.utils.Rol;

public class Administrador extends Usuario {

    public double sueldo;
    public String rfc;
    public int antiguedad;

    public Administrador(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String contrasenia, double sueldo, String rfc, int antiguedad) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, Rol.ADMINISTRADOR, contrasenia);
        this.sueldo = sueldo;
        this.rfc = rfc;
        this.antiguedad = antiguedad;
    }

    public String mostrarDatos() {
        return String.format("Id: %s, nombre: %s, apellidos: %s, fecha de nacimiento: %s, teléfono: %s, sueldo: %f, RFC: %s, antiguedad: %d",
                getId(),
                getNombre(),
                getApellidos(),
                getFechaNacimiento(),
                getTelefono(),
                getSueldo(),
                getRfc(),
                getAntiguedad()
        );
    }

    public double getSueldo() {
        return sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public String getRfc() {
        return rfc;
    }
}
