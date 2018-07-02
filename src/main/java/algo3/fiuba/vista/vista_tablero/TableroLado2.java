package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.vista_tablero.Tablero;
import javafx.geometry.Insets;

public class TableroLado2 extends Tablero {

    public TableroLado2(Jugador jugador) {
        super(jugador);
    }

    @Override
    public void dibujar() {

        this.setPadding(new Insets(5));
        this.setVgap(5.5);
        this.setHgap(10);
        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloContenedorPrincipal.css");
        super.setMano(1, 2);
        super.setMazo(2, 2, zonaMano);
        super.setCampo(1, 1, 1, 0);
        super.setCementerio(2, 0);
        super.setCartaCampo(0, 0);
    }
}
