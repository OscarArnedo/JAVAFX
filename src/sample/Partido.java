package sample;

public class Partido {
    private Club local;
    private Club visitante;
    private String golesLocal;
    private String golesVisitante;

    public Partido(Club local, Club visitante, String golesLocal, String golesVisitante) {
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public Club getLocal() {
        return local;
    }

    public void setLocal(Club local) {
        this.local = local;
    }

    public Club getVisitante() {
        return visitante;
    }

    public void setVisitante(Club visitante) {
        this.visitante = visitante;
    }

    public String getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(String golesLocal) {
        this.golesLocal = golesLocal;
    }

    public String getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(String golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    @Override
    public String toString() {
        return "Resultado: " + local + " " + golesLocal + " - " + golesVisitante + " " + visitante;
    }

}
