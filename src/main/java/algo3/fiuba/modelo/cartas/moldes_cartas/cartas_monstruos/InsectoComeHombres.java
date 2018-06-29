package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.cartas.modo_monstruo.ModoDeAtaque;
import algo3.fiuba.modelo.excepciones.SacrificiosIncorrectosExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoInsectoComeHombres;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;
import algo3.fiuba.modelo.resultado_combate.ResultadoCombate;
import algo3.fiuba.modelo.resultado_combate.ResultadoCombateNulo;

import java.util.Observable;

public class InsectoComeHombres extends Monstruo {

    private boolean primerTurno;

    public InsectoComeHombres(Jugador jugador) {
        super("Insecto Come-HOMBRES", 450, 600, 2, new EfectoNulo());
        setJugador(jugador);
        setEfecto(new EfectoInsectoComeHombres(jugador));
        this.primerTurno = false;
    }

    @Override
    public ResultadoCombate recibirAtaque(Monstruo monstruoAtacante, Integer puntosAtaqueRival) {
        if (estadoCarta.estaBocaAbajo()) {
            girarCarta();
            return new ResultadoCombateNulo();
        } else {
            return super.recibirAtaque(monstruoAtacante, puntosAtaqueRival);
        }
    }

    @Override
    public void girarCarta() {
        if (!primerTurno) {
            activarEfecto();
        }
        estadoCarta = estadoCarta.girarCarta();
    }

    @Override
    public void activarEfecto() {
        if (!primerTurno) {
            efecto.activar(this);
        }
        estadoCarta = estadoCarta.girarCarta();
    }

    @Override
    public void colocarEnCampo(Jugador jugador, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        if (!nivel.sacrificiosSuficientes(sacrificios))
            throw new SacrificiosIncorrectosExcepcion(String.format("Se necesitan estrictamente %d sacrificios para invocarlo.", nivel.sacrificiosRequeridos()));

        this.realizarSacrificios(sacrificios);
        modoMonstruo = new ModoDeAtaque(); // !!! sacarg
        //super.colocarEnCampo(jugador, tipoEnJuego, sacrificios);
        jugador.colocarCartaEnCampo(this, tipoEnJuego, sacrificios);
        primerTurno = true;
    }

    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);
        primerTurno = false;
    }
}
