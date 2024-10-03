package usuarios;

import java.time.LocalDate;

public class Usuario {
    public String id;
    public String nombre;
    public String apellidos;
    public LocalDate fechaNacimiento;
    public String telefono;
    private String contraseña;
    public Rol rol;

    public Usuario (String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.rol =rol;
    }
    protected String getContraseña(){
        return contraseña;
    }

}