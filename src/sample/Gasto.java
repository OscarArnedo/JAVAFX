package sample;

import java.util.Scanner;

public class Gasto implements IDinero, Cloneable{
    private int idGasto;
    private String tipoGasto;
    private String fecha;
    private float cantidad;
    private Club club;

    public Gasto(int idGasto, String tipoGasto, String fecha, float cantidad, Club club) {
        super();
        this.idGasto = idGasto;
        this.tipoGasto = tipoGasto;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.club = club;
        club.totalG = club.totalG + cantidad;
    }

    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public void sumaGastos () {
        club.totalG = club.totalG + cantidad;
    }

    @Override
    public String toString() {
        return "Gasto [id=" + idGasto + ", Tipo Gasto=" + tipoGasto + ", fecha=" + fecha + ", cantidad=" + cantidad
                + ", Club=" + club + "]";
    }

    @Override
    public void cambiarMoneda() {
        int opcion;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.println("1. Mostrar en Euros (€)");
        System.out.println("2. Mostrar en Dolares ($)");
        System.out.println("3. Mostrar en Libras (£)");
        opcion = keyboard.nextInt();

        switch(opcion) {
            case 1:
                System.out.println(cantidad +"€");
                break;
            case 2:
                System.out.println(cantidad *1.12 +"$");
                break;
            case 3:
                System.out.println(cantidad *0.86 +"£");
                break;
        }
    }

    public Gasto clone() throws CloneNotSupportedException {
        return (Gasto) super.clone();

    }
}
