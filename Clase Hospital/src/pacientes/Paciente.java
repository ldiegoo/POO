package pacientes;


public class Paciente {
    public String id;
    public String nombre;
    public String apellidos;
    public String fechaNacimiento;
    public String tipoSangre;
    public char sexo;
    private String telefono;

    public Paciente(String id, String nombre, String apellidos, String fechaNacimiento, String tipoSangre, char sexo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
        this.telefono = telefono;
    }

    public String mostrarDatos() {
        String datos = String.format("Id: %s  |  Nombre: %s  |  Apellidos: %s  |  Fecha de Nacimiento: %s  |  Tipo de Sangre: %s  |  Sexo: %s  |  Telefono: %s",
                id, nombre, apellidos, fechaNacimiento, tipoSangre, sexo, telefono);

        return datos;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public char getSexo() {
        return sexo;
    }

    public String getTelefono() {
        return telefono;
    }
}