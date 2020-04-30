package sample;

import java.util.Scanner;

public class Ingreso implements IDinero, Cloneable{
    private int idIngreso;
    private String tipoIngreso, fecha;
    private float cantidad;
    private Club club;

    public Ingreso(int idIngreso, String tipoIngreso, String fecha, float cantidad, Club club) {
        this.idIngreso = idIngreso;
        this.tipoIngreso = tipoIngreso;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.club = club;
        club.totalI = club.totalI + cantidad;
    }

    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
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

    public void sumaIngresos () {
        club.totalI = club.totalI + cantidad;
    }

    @Override
    public void cambiarMoneda() {
        int opcion;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.println("1. Mostrar en Euros (â‚¬)");
        System.out.println("2. Mostrar en Dolares ($)");
        System.out.println("3. Mostrar en Libras (Â£)");
        opcion = keyboard.nextInt();

        switch(opcion) {
            case 1:
                System.out.println(cantidad +"â‚¬");
                break;
            case 2:
                System.out.println(cantidad *1.12 +"$");
                break;
            case 3:
                System.out.println(cantidad *0.86 +"Â£");
                break;
        }
    }

    public Ingreso clone() throws CloneNotSupportedException {
        return (Ingreso) super.clone();

    }

    @Override
    public String toString() {
        return "Ingreso{" +
                "idIngreso=" + idIngreso +
                ", tipoIngreso='" + tipoIngreso + '\'' +
                ", fecha='" + fecha + '\'' +
                ", cantidad=" + cantidad +
                ", club=" + club +
                '}';
    }
}

