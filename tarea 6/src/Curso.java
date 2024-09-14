import java.util.Random;

public class Curso {
    public String nombreCurso;
    public String codigoCurso;
    public String instructor;
    public Random random=new Random();

    public Curso(String nombreCurso, String codigoCurso, String instructor) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.instructor = instructor;
    }



    //getters
    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getcodigoCurso() {
        return codigoCurso;
    }

    public String getInstructor() {
        return instructor;
    }


    //setters
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    public void setcodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }



    public void mostrarInfoCurso() {
        System.out.println("Nombre del Curso: " + nombreCurso);
        System.out.println("Codigo del Curso: " + codigoCurso);
        System.out.println("Instructor: " + instructor);
    }

}