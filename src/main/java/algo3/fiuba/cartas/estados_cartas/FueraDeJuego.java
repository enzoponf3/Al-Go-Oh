package algo3.fiuba.cartas.estados_cartas;

public class FueraDeJuego implements EstadoCarta {

    public boolean estaEnJuego() {
        throw new RuntimeException("La carta no se ha jugado aún.");
    }

}
