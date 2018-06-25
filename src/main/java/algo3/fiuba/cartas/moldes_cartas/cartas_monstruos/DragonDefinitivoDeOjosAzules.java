package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Campo;
import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.modo_monstruo.ModoDeAtaque;
import algo3.fiuba.excepciones.SacrificiosInsuficientesExcepcion;

public class DragonDefinitivoDeOjosAzules extends Monstruo {

    public DragonDefinitivoDeOjosAzules(Jugador jugador) {
        super("Dragon Definitivo de Ojos Azules", 4500, 3800, 10, new EfectoNulo());
        setJugador(jugador);
    }

    @Override
    public void colocarEnCampo(Campo campo, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        if (!sacrificiosSuficientes(sacrificios))
            throw new SacrificiosInsuficientesExcepcion("Se necesitan estrictamente 3 Dragones Blancos de Ojos Azules para invocarlo.");

        realizarSacrificios(campo, sacrificios);
        modoMonstruo = ModoDeAtaque.getInstancia();
        estadoCarta = tipoEnJuego;
        campo.colocarCarta(this, tipoEnJuego, sacrificios);
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
