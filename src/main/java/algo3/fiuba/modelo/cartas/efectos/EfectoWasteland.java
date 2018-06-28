package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.modificadores.Modificador;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.modificadores.ModificadorWastelandOponente;
import algo3.fiuba.modelo.cartas.modificadores.ModificadorWastelandPropio;

public class EfectoWasteland extends EfectoCarta {

    private Jugador jugador;
    private ModificadorWastelandPropio modificadorCampoPropio;
    private ModificadorWastelandOponente modificadorCampoOponente;

    public EfectoWasteland(CartaCampo cartaCampo, Jugador jugador) {
        this.jugador = jugador;
        this.modificadorCampoPropio = new ModificadorWastelandPropio();
        this.modificadorCampoOponente = new ModificadorWastelandOponente();

        cartaCampo.setModificadorCampoPropio(this.modificadorCampoPropio);
        cartaCampo.setModificadorCampoOponente(this.modificadorCampoOponente);
    }

    @Override
    public void activar(Carta carta) {
        jugador.agregarModificador(modificadorCampoPropio);
        jugador.getOponente().agregarModificador(modificadorCampoOponente);
    }

}
