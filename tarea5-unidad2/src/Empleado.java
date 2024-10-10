public class Empleado {
    public double sueldoBase;
    public double bonificacion;
    public int horasExtra;

    public double calcularSalario(double sueldoBase){
        return sueldoBase;
    }
    public double calcularSalario(double sueldoBase, double bonificacion){
        return sueldoBase + bonificacion;
    }
    public double calcularSalario(double sueldoBase, double bonificacion, int horasExtra){
        horasExtra = horasExtra*20;
        return sueldoBase + bonificacion + horasExtra;
    }  }