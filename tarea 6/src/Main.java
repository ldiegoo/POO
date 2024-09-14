import java.sql.SQLOutput;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
    Curso curso1=new Curso("Matematicas","MAT10234","Luis Dante");
    Curso curso2=new Curso("Quimica","QUI0983","Judith Gutierrez");
    Curso curso3=new Curso("Programacion Orientada a Objetos","POO9384","Eder Rivera Cisneros");

    Estudiantes estudiante1=new Estudiantes("Jovanny Jimenez","JOVJI02938");
    Estudiantes estudiante2=new Estudiantes("Jesus Eguiza","EGUIJES3467");
    Estudiantes estudiante3=new Estudiantes("Adrian Rodriguez","ADRROD7403");

    estudiante1.agregarCurso(curso1);
    estudiante1.agregarCurso(curso2);
    estudiante2.agregarCurso(curso3);
    estudiante3.agregarCurso(curso3);
    estudiante3.agregarCurso(curso2);

    estudiante1.mostrarInformacion();
        System.out.println();
    estudiante2.mostrarInformacion();
        System.out.println();
    estudiante3.mostrarInformacion();
    }
}