package algo3.fiuba.modelo.cartas.estados_cartas;

public abstract class EnJuego implements EstadoCarta {

    @Override
    public boolean estaEnJuego() {
        return true;
    }

    @Override
    public void verificarQuePuedeAtacar() {
        return;
    }

}
