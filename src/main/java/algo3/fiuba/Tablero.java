package algo3.fiuba;

public class Tablero {

    private static Tablero tableroInstance = new Tablero();

    public TableroJugador tableroJ1, tableroJ2;

    public static Tablero getInstance() {

        return tableroInstance;
    }

    public Tablero() {

        this.tableroJ1 = new TableroJugador();
        this.tableroJ2 = new TableroJugador();
    }

}
