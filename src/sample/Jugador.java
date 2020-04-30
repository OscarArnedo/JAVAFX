package sample;

public class Jugador extends Trabajador{
    private ePosicion posicion;
    private int dorsal;
    private int goles;
    private int asistencias;
    private int tarjAmarillas;
    private int tarjRojas;
    private int partidos;

    public Jugador(String nombre, String apellidos, String dni, int edad, int telefono, Contrato contrato, ePosicion posicion, int dorsal, int goles, int asistencias, int tarjAmarillas, int tarjRojas, int partidos) {
        super(nombre,apellidos,dni,edad,telefono,contrato);
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.goles = goles;
        this.asistencias = asistencias;
        this.tarjAmarillas = tarjAmarillas;
        this.tarjRojas = tarjRojas;
        this.partidos = partidos;
    }

    public ePosicion getPosicion() {
        return posicion;
    }

    public void setPosicion(ePosicion posicion) {
        this.posicion = posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getTarjAmarillas() {
        return tarjAmarillas;
    }

    public void setTarjAmarillas(int tarjAmarillas) {
        this.tarjAmarillas = tarjAmarillas;
    }

    public int getTarjRojas() {
        return tarjRojas;
    }

    public void setTarjRojas(int tarjRojas) {
        this.tarjRojas = tarjRojas;
    }

    public int getPartidos() {
        return partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    @Override
    public String toString() {
        return "Jugador{" + super.toString() +
                "posicion=" + posicion +
                ", dorsal=" + dorsal +
                ", goles=" + goles +
                ", asistencias=" + asistencias +
                ", tarjAmarillas=" + tarjAmarillas +
                ", tarjRojas=" + tarjRojas +
                ", partidos=" + partidos +
                "} ";
    }
}
