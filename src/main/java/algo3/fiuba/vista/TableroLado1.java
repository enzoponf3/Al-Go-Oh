package algo3.fiuba.vista;

import algo3.fiuba.modelo.jugador.Jugador;
import javafx.geometry.Insets;

public class TableroLado1 extends Tablero {

    public TableroLado1(Jugador jugador) {

        this.setGridLinesVisible(true); // si las quieren ver habiliten esta linea
        this.setPadding(new Insets(5));
        this.setVgap(5.5);
        this.setHgap(5.5);
        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloContenedorPrincipal.css");

        this.jugador = jugador;
        super.setMano(1, 0);
        super.setMazo(0, 0);
        super.setCampo(1, 1, 1, 2);
        super.setCementerio(0, 2);
        super.setCartaCampo(2, 2);
    }


}
