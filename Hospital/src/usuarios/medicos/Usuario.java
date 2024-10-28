package usuarios.medicos;

import java.time.LocalDate;

public class Usuario {
    public String id;
    public String nombre;
    public String apellido;
    public LocalDate fechaNacimiento;
    public String telefono;
    public String contrasenia;
    public Rol rol;
    public String email;

    public Usuario(String id, String nombre, String apellido, LocalDate fechaNacimiento, String telefono,String contrasenia, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.email=email;
    }
    protected String mostrarDatos() {
        String nombreCompleto = this.nombre + "" + this.apellido;
        String datos = String.format("\nId: %s | Nombre Completo: %s | Fecha de Nacimiento: %s | telefono: %s| email: %s", this.id, nombreCompleto, fechaNacimiento, telefono, email);
        return datos;
    }
    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public Rol getRol() {
        return rol;
    }
}
