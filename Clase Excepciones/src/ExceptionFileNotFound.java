import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionFileNotFound {
    public void Ejecutar() {




        try{
            Scanner a = new Scanner(new File("archivo.txt"));
        } catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado"+e);
        }
    }
}
