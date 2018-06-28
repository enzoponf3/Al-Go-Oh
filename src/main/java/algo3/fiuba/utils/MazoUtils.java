package algo3.fiuba.utils;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.AgujeroNegro;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.Fisura;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.OllaDeLaCodicia;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.*;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas.CilindroMagico;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas.Refuerzos;
import algo3.fiuba.modelo.jugador.Jugador;

import java.util.Stack;

public class MazoUtils {

    public Stack<Carta> getMazoDosCartas1(Jugador jugador) {
        Stack<Carta> mazo = new Stack<>();

        mazo.add(new AgujeroNegro(jugador));
        mazo.add(new BebeDragon(jugador));

        return mazo;
    }

    public Stack<Carta> getMuestra1(Jugador jugador) {
        Stack<Carta> mazo = new Stack();

        mazo.add(new PetitAngel(jugador));
        mazo.add(new SevenColoredFish(jugador));
        mazo.add(new Griffore(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new Fisura(jugador));
        mazo.add(new Refuerzos(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new IncursorDelHacha(jugador));
        mazo.add(new AgujeroNegro(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new CilindroMagico(jugador));
        mazo.add(new GenioMisticoDeLaLampara(jugador));
        mazo.add(new OllaDeLaCodicia(jugador));
        mazo.add(new GuerreroCelta(jugador));
        mazo.add(new Kuriboh(jugador));
        mazo.add(new BebeDragon(jugador));

        return mazo;
    }

    public Stack<Carta> getMuestraOjosAzules(Jugador jugador) {
        Stack<Carta> mazo = new Stack();

        mazo.add(new PetitAngel(jugador));
        mazo.add(new SevenColoredFish(jugador));
        mazo.add(new Griffore(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new Fisura(jugador));
        mazo.add(new Refuerzos(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new AgujeroNegro(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new CilindroMagico(jugador));
        mazo.add(new GenioMisticoDeLaLampara(jugador));
        mazo.add(new DragonDefinitivoDeOjosAzules(jugador));
        mazo.add(new OllaDeLaCodicia(jugador));
        mazo.add(new DragonBlancoDeOjosAzules(jugador));
        mazo.add(new DragonBlancoDeOjosAzules(jugador));
        mazo.add(new OllaDeLaCodicia(jugador));
        mazo.add(new GuerreroCelta(jugador));
        mazo.add(new GuerreroCelta(jugador));
        mazo.add(new IncursorDelHacha(jugador));
        mazo.add(new IncursorDelHacha(jugador));
        mazo.add(new IncursorDelHacha(jugador));
        mazo.add(new DragonBlancoDeOjosAzules(jugador));

        return mazo;
    }

    public Stack<Carta> getMuestraExodia(Jugador jugador) {
        Stack<Carta> mazo = new Stack();

        mazo.add(new PetitAngel(jugador));
        mazo.add(new SevenColoredFish(jugador));
        mazo.add(new Griffore(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new Fisura(jugador));
        mazo.add(new Refuerzos(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new AgujeroNegro(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new CilindroMagico(jugador));
        mazo.add(new GenioMisticoDeLaLampara(jugador));
        mazo.add(new CabezaExodia(jugador));
        mazo.add(new PiernaIzquierdaExodia(jugador));
        mazo.add(new PiernaDerechaExodia(jugador));
        mazo.add(new IncursorDelHacha(jugador));
        mazo.add(new OllaDeLaCodicia(jugador));
        mazo.add(new OllaDeLaCodicia(jugador));
        mazo.add(new OllaDeLaCodicia(jugador));
        mazo.add(new OllaDeLaCodicia(jugador));
        mazo.add(new IncursorDelHacha(jugador));
        mazo.add(new BrazoIzquierdoExodia(jugador));
        mazo.add(new BrazoDerechoExodia(jugador));

        return mazo;
    }

    public Stack<Carta> getMuestra2cartas(Jugador jugador) {
        Stack<Carta> mazo = new Stack();

        mazo.add(new BebeDragon(jugador));
        mazo.add(new AgujeroNegro(jugador));

        return mazo;
    }
}
