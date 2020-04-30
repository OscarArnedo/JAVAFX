package sample;

public class Contrato implements  Comparable<Contrato>{
    private int sueldo;
    private int duracion; //por años
    private int clausula;

    public Contrato(int sueldo, int duracion, int clausula) {
        this.sueldo = sueldo;
        this.duracion = duracion;
        this.clausula = clausula;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getClausula() {
        return clausula;
    }

    public void setClausula(int clausula) {
        this.clausula = clausula;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "sueldo=" + sueldo +
                ", duracion=" + duracion +
                ", clausula=" + clausula +
                '}';
    }

    public int compareTo(Contrato c) {
        int res;
        if(this.sueldo < c.sueldo){res = -1;}
        else if(this.sueldo > c.sueldo){res = 1;}
        else{res = 0;}

        return res;
    }
}
