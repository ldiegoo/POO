package usuarios.medicos;

import java.time.LocalDate;
import usuarios.Usuario;
import usuarios.utils.Rol;
// para la herencia primero agregamos el extends y en el constructor el super
public class Medico extends Usuario {
    private String rfc;


    //constructor
    public Medico(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String rfc, String contrasenia) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, Rol.MEDICO, contrasenia);
        this.rfc = rfc;
    }

    public String mostrarDatos() {
        return String.format("Id: %s, nombre: %s, apellidos: %s, fecha de nacimiento: %s, teléfono: %s, RFC: %s",
                getId(),
                getNombre(),
                getApellidos(),
                getFechaNacimiento(),
                getTelefono(),
                getRfc()
        );
    }



    public String getRfc() {
        return rfc;
    }
}
