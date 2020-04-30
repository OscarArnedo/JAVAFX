package sample;

public class EquipoTecnico extends Trabajador {
    private String cargo;

    public EquipoTecnico(String nombre, String apellidos, String dni, int edad, int telefono, Contrato contrato, String cargo) {
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
        return "EquipoTecnico{" + super.toString() +
                "cargo='" + cargo + '\'' +
                "} ";
    }
}
