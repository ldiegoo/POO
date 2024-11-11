import excepciones.HabitacionNoDisponibleException;
import excepciones.NumeroDeNochesInvalidoException;

public class Habitacion {
    private String tipo;
    private double precioPorNoche;
    private boolean disponible;

    public Habitacion(String tipo, double precioPorNoche) {
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = true; // Por defecto, la habitación está disponible
    }

    public void reservar(int noches) throws HabitacionNoDisponibleException, NumeroDeNochesInvalidoException {
        if (!disponible) {
            throw new HabitacionNoDisponibleException("La habitación no está disponible para reservar.");
        }
        if (noches < 1) {
            throw new NumeroDeNochesInvalidoException("El número de noches debe ser al menos 1.");
        }
        disponible = false; // Cambiar estado a no disponible
    }

    public void liberar() {
        disponible = true; // Cambiar estado a disponible
    }

    public void mostrarDetalles() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Precio por noche: " + precioPorNoche);
        System.out.println("Disponibilidad: " + (disponible ? "Disponible" : "No disponible"));
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
