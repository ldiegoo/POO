import java.util.ArrayList;
public class Estudiantes {
    public String nombre;
    public String idEstudiante;
    public ArrayList<Curso> cursos;

    public Estudiantes(String nombre, String idEstudiante) {
        this.nombre = nombre;
        this.idEstudiante = idEstudiante;
        cursos = new ArrayList();
    }
    public void agregarCurso(Curso c) {
        cursos.add(c);
    }
    public void mostrarInformacion(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Id de estudiante: " + idEstudiante);
        System.out.println("Cursos inscrito: ");
        for (Curso curso : cursos) {
            System.out.println();
            curso.mostrarInfoCurso();
        }
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdEstudiante() {
        return idEstudiante;
    }
    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
}
