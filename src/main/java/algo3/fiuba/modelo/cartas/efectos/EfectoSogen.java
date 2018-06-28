package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.modificadores.ModificadorWastelandOponente;
import algo3.fiuba.modelo.cartas.modificadores.ModificadorWastelandPropio;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.modificadores.ModificadorSogenOponente;
import algo3.fiuba.modelo.cartas.modificadores.ModificadorSogenPropio;

public class EfectoSogen extends EfectoCarta{

    private Jugador jugador;
    private ModificadorSogenPropio modificadorCampoPropio;
    private ModificadorSogenOponente modificadorCampoOponente;

    public EfectoSogen(CartaCampo cartaCampo, Jugador jugador) {
        this.jugador = jugador;
        this.modificadorCampoPropio = new ModificadorSogenPropio();
        this.modificadorCampoOponente = new ModificadorSogenOponente();

        cartaCampo.setModificadorCampoPropio(this.modificadorCampoPropio);
        cartaCampo.setModificadorCampoOponente(this.modificadorCampoOponente);

    }

    @Override
    public void activar(Carta carta) {
        jugador.agregarModificador(modificadorCampoPropio);
        jugador.getOponente().agregarModificador(modificadorCampoOponente);
    }
}
