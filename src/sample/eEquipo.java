package sample;

public enum eEquipo {
    BARÇA("FC Barcelona",1),
    JUVENTUS("Juventus FC",2),
    PSG("Paris Saint-Germain FC",3),
    BAYERN("FC Bayern München",4),
    MANCHESTER("Manchester United FC",5),
    PORTO("FC Oporto",6);

    private String nombreClub;
    private int idEquipo;

    private eEquipo(String nombreClub, int idEquipo) {
        this.nombreClub = nombreClub;
        this.idEquipo = idEquipo;
    }

    public String getNombreClub() {
        return nombreClub;
    }

    public int getIdEquipo() {
        return idEquipo;
    }
}
