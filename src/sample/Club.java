package sample;

import java.util.ArrayList;
public class Club {
    private ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
    private eEquipo nombreC;
    private String cif;
    private int añoFundacion;
    private ePais pais;
    public float totalI, total, totalG;

    public Club(eEquipo nombreC, String cif, int añoFundacion, ePais pais) {
        this.nombreC = nombreC;
        this.cif = cif;
        this.añoFundacion = añoFundacion;
        this.pais = pais;
    }

    public eEquipo getNombreC() {
        return nombreC;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public int getAñoFundacion() {
        return añoFundacion;
    }

    public void setAñoFundacion(int añoFundacion) {
        this.añoFundacion = añoFundacion;
    }

    public ePais getPais() {
        return pais;
    }

    public void setPais(ePais pais) {
        this.pais = pais;
    }

    public void saldoTotal() {
        this.total = this.totalI - this.totalG;
    }

    public float getSaldoTotal() {
        return this.total;
    }

    @Override
    public String toString() {
        return "Club{" +
                "nombreC='" + nombreC + '\'' +
                ", cif='" + cif + '\'' +
                ", añoFundacion=" + añoFundacion +
                ", pais=" + pais +
                '}';
    }

    public void añadirTrabajador(Trabajador t){
        this.trabajadores.add(t);
    }

    public Trabajador getTrabajador(int i){
        return this.trabajadores.get(i);
    }
}
