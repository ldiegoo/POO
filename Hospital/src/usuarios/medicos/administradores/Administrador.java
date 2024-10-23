package usuarios.medicos.administradores;

import usuarios.medicos.Rol;
import usuarios.medicos.Usuario;

import java.time.LocalDate;

public class Administrador extends Usuario {
    public double sueldo;
    public String RFC;
    public int aniosTrabajados;

    public Administrador(String id, String nombre, String apellido, LocalDate fechaNacimiento, String telefono, String contrasenia, double sueldo, String RFC, int aniosTrabajados) {
        super(id, nombre, apellido, fechaNacimiento, telefono, contrasenia, Rol.ADMIN);
        this.sueldo = sueldo;
        this.RFC = RFC;
        this.aniosTrabajados = aniosTrabajados;
    }

    public double getSueldo() {
        return sueldo;
    }
    public String getRFC() {
        return RFC;
    }
    public int getAniosTrabajados() {
        return aniosTrabajados;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + String.format("|  Sueldo: %s  |  Rfc: %s  | Años Trabajando: %s | ", sueldo, RFC, aniosTrabajados);
    }
}
