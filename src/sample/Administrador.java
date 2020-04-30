package sample;

public class Administrador extends Trabajador {
    private String cargo;

    public Administrador(String nombre, String apellidos, String dni, int edad, int telefono, Contrato contrato, String cargo) {
        super(nombre, apellidos, dni, edad, telefono, contrato);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Administrador{" + super.toString() +
                "cargo='" + cargo + '\'' +
                "} ";
    }
}
