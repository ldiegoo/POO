package usuarios.medicos;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Medico extends Usuario {
    private String rfc;

    public Medico (String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String rfc,String contraseña) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, Rol.MEDICO);
        this.rfc = rfc;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }


    public String getRfc() {
        return rfc;
    }
    public String mostrarMedico() {
        return String.format("ID: %s Nombre: %s Apellido: %s Fecha Nacimiento: %s Num. Telefono: %s Rfc: %s",
                getId(), getNombre(), getApellidos(), getFechaNacimiento(), getTelefono(), getRfc());
    }


}