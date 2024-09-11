public class Triangulo {
    public double ladouno;
    public double ladodos;
    public double ladotres;
    public double altura;
    public double base;

    public Triangulo(double ladouno, double ladodos, double ladotres,double altura,double base) {
        this.ladouno = ladouno;
        this.ladodos = ladodos;
        this.ladotres = ladotres;
        this.altura =altura;
        this.base = base;
    }
    public double calcularArea() {
        Double area= (this.base *this.altura)/2;
        return area;
    }
    public double calcularPerimetro() {
        return this.ladouno + this.ladodos + this.ladotres;
    }
    public double calcularArea(double base) {
        Double area= (this.base *this.altura)/2;
        return area;
    }
    public double calcularArea(double base, double altura) {
        Double area= (this.base *this.altura)/2;
        return area;
    }

}
