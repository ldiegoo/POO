package pacientes;

public class Paciente {
    public int id;
    public String nombre;
    public String apellido;
    public String fechaNacimiento;
    public String sexo;
    private String telefono;
    public String tipoSangre;

    public Paciente(int id, String nombre, String apellido, String fechaNacimiento, String sexo, String telefono, String tipoSangre) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.telefono = telefono;
        this.tipoSangre = tipoSangre;
    }
}
