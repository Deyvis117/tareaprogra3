public class Alumno extends Persona {
    private String carnet;
    private double promedio;

    public Alumno(String nombre, int edad, String carnet, double promedio) {
        super(nombre, edad);
        this.carnet = carnet;
        this.promedio = promedio;
    }

    public String getCarnet() { return carnet; }
    public double getPromedio() { return promedio; }

    public void setCarnet(String carnet) { this.carnet = carnet; }
    public void setPromedio(double promedio) { this.promedio = promedio; }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", carnet='" + carnet + '\'' +
                ", promedio=" + promedio +
                '}';
    }
}
