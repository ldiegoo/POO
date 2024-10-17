package customer;

import Rol;

import java.time.LocalDate;

public class Customer extends Users{
    public String CURP;
    public int totalFunciones;

    public Customer(String id, String nombre, String apellido, LocalDate fechaNacimiento, String direccion, String CURP, int totalFunciones) {
        super(id, nombre, apellido, fechaNacimiento, direccion, Rol.CLIENTES);

        this.CURP = CURP;
        this.totalFunciones = totalFunciones;

    }
    public String getCurp() {
        return CURP;
    }
    public int getTotalFunciones() {
        return totalFunciones;
    }

}

