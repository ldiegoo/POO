package consultorios;

import java.util.Random;

public class Consultorio {
    public String id;
    public int piso;
    public int numeroConsultorio;


//    constructor

    public Consultorio(String id, int piso, int numeroConsultorio) {
        this.id = id;
        this.piso = piso;
        this.numeroConsultorio = numeroConsultorio;
    }

    public String mostrarDatos(){
        return String.format("Id: %s, Piso: %d, Numero de Consultorio: %d",
                getId(),
                getPiso(),
                getNumeroConsultorio()
        );
    }

//    getter

    public String getId() {
        return id;
    }

    public int getPiso() {
        return piso;
    }

    public int getNumeroConsultorio() {
        return numeroConsultorio;
    }
}
