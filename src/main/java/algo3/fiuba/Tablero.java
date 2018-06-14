package algo3.fiuba;

public class Tablero {

    private static Tablero INSTANCIA;

    private TableroJugador tableroJugador1;
    private TableroJugador tableroJugador2;

    private Tablero() {
        this.tableroJugador1 = new TableroJugador();
        this.tableroJugador2 = new TableroJugador();
    }

    public static Tablero getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new Tablero();

        return INSTANCIA;
    }

    public void empezarDuelo(Jugador jugador1, Jugador jugador2) {
        jugador1.setTableroJugador(tableroJugador1);
        jugador2.setTableroJugador(tableroJugador2);
    }

}
