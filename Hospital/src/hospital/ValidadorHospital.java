package hospital;

import consultas.Consulta;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ValidadorHospital {
    public boolean validarDisponibilidadEnFechaConsulta(LocalDateTime fechaDeseada, int numeroConsultorio, ArrayList<Consulta> listaConsultas) {
        for (Consulta consulta : listaConsultas) {
            if (consulta.getFechaHora().isEqual(fechaDeseada) && numeroConsultorio == consulta.getConsultorio().getNumConsultorio()){
                return false;
            }
        }
        return true;
    }
    public boolean validarDisponibilidadMedico(LocalDateTime fechaDeseada, String idMedico, ArrayList<Consulta> listaConsultas) {
        for (Consulta consulta : listaConsultas) {
            if (consulta.getFechaHora().isEqual(fechaDeseada) && consulta.getMedico().getId().equals(idMedico)) {
                return false;
            }
        }
        return true;

    }
}
