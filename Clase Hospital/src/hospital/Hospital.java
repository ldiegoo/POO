package hospital;

import consultas.Consulta;
import consultorios.Consultorio;
import medicos.Medico;
import pacientes.Paciente;

import java.util.ArrayList;

public class Hospital {
    public ArrayList<Paciente> listaPaciente=new ArrayList<>();
    public ArrayList<Medico> listaMedicos=new ArrayList<>();
    public ArrayList<Consulta> listaConsultas=new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios=new ArrayList<>();

    public void registrarPaciente(Paciente paciente){
        this.listaPaciente.add(paciente);
    }
    public void registrarMedico(Medico medico){
        this.listaMedicos.add(medico);
    }
    public void registrarConsulta(Consulta consulta){
        this.listaConsultas.add(consulta);
        //No exista una consulta en la fecha deseada
        if(!validarDisponibilidadenFechaConsulta(consulta.getFecha(), consulta.getConsultorio().getNumeroConsultorio())){
            System.out.println("Ya existe una consulta en esa fecha y hora");
            return;
        }





        /*
        1. No exista una consulta en la fecha indicada en el consultorio indicado
        2. Fecha valida
        3. Medico no tenga una consulta en esa fecha
        4. Paciente no tenga una consulta en esa fecha
         */
    }
    public void registrarConsultorio(Consultorio consultorio){
        this.listaConsultorios.add(consultorio);
    }
    private boolean validarDisponibilidadenFechaConsulta(String fechaDeseada, int numConsultorio){
        for(Consulta consulta: this.listaConsultas){
            if(consulta.getFecha().equals(fechaDeseada) && numConsultorio==consulta.getConsultorio().getNumeroConsultorio()){
                return false;
            }
        }
        return true;
    }
}