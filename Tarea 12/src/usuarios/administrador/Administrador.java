package usuarios.administrador;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Administrador extends Usuario {
    private Double Sueldo;
    private String rfc;
    private int añosTrabajdos;

    public Administrador(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String contrasenia, Double sueldo, String rfc, int añosTrabajdos) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, contrasenia, Rol.ADMIN);
        Sueldo = sueldo;
        this.rfc = rfc;
        this.añosTrabajdos = añosTrabajdos;
    }
}
