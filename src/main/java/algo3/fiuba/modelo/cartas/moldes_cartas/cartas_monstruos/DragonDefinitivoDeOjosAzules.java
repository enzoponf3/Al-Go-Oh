package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.cartas.modo_monstruo.ModoDeAtaque;
import algo3.fiuba.modelo.excepciones.SacrificiosIncorrectosExcepcion;

public class DragonDefinitivoDeOjosAzules extends Monstruo {

    public DragonDefinitivoDeOjosAzules(Jugador jugador) {
        super("Dragon Definitivo de Ojos Azules", 4500, 3800, 10, new EfectoNulo());
        setJugador(jugador);
    }

    @Override
    public void colocarEnCampo(Jugador jugador, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        if (!sacrificiosSuficientes(sacrificios))
            throw new SacrificiosIncorrectosExcepcion("Se necesitan estrictamente 3 Dragones Blancos de Ojos Azules para invocarlo.");

        realizarSacrificios(sacrificios);
        modoMonstruo = new ModoDeAtaque();
        estadoCarta = tipoEnJuego;
// !!!        super.colocarEnCampo(jugador, tipoEnJuego, sacrificios);
        jugador.colocarCartaEnCampo(this, tipoEnJuego, sacrificios);
    }

    private boolean sacrificiosSuficientes(Monstruo... sacrificios) {
        if (sacrificios.length != 3)
            return false;

        boolean sacrificioValido = true;
        for (Monstruo sacrificio : sacrificios) {
            sacrificioValido &= sacrificio.equals(new DragonBlancoDeOjosAzules(jugador));
        }

        return sacrificioValido;
    }
}
