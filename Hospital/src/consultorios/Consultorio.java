package consultorios;

public class Consultorio {
    public String id;
    public int piso;
    public int numConsultorio;

    public Consultorio(String idConsultorio, int piso, int numConsultorio) {
        this.id = idConsultorio;
        this.piso = piso;
        this.numConsultorio = numConsultorio;
    }

    public String mostrarDatosConsultorio() {
        String datos = String.format("IdConsultorio: %d | piso: %d | numConsultorio: %d", id, piso, numConsultorio);
        return datos;
    }

    public String getId() {
        return id;
    }

    public int getPiso() {
        return piso;
    }

    public int getNumConsultorio() {
        return numConsultorio;
    }
}
