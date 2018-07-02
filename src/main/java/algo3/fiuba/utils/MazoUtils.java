package algo3.fiuba.utils;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo.Sogen;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo.Wasteland;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.AgujeroNegro;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.Fisura;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.OllaDeLaCodicia;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.*;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas.CilindroMagico;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas.Refuerzos;
import algo3.fiuba.modelo.jugador.Jugador;

import java.util.Collections;
import java.util.Stack;

public class MazoUtils {

    public Stack<Carta> getMazo40(Jugador jugador) {
        Stack<Carta> mazoJugador = new Stack<>();
        Stack<Carta> mazo = new Stack<>();
        mazo.addAll(this.getMuestraTodasLasCartas(jugador));
        mazo.addAll(this.getMuestraTodasLasCartas(jugador));
        Collections.shuffle(mazo);
        mazoJugador.addAll(mazo.subList(0, 40));
        return mazoJugador;
    }

    public Stack<Carta> getMuestraTodasLasCartas(Jugador jugador) {
        Stack<Carta> mazo = new Stack<>();

        mazo.add(new AgujeroNegro(jugador));
        mazo.add(new CilindroMagico(jugador));
        //mazo.add(new Refuerzos(jugador));
        mazo.add(new OllaDeLaCodicia(jugador));
        mazo.add(new Wasteland(jugador));
        mazo.add(new BrazoDerechoExodia(jugador));
        mazo.add(new BrazoIzquierdoExodia(jugador));
        mazo.add(new CabezaExodia(jugador));
        mazo.add(new ColmilloPlateado(jugador));
        //!!!mazo.add(new CraneoConvocado(jugador));
        mazo.add(new DiablilloSalvaje(jugador));
        mazo.add(new DragonBlancoDeOjosAzules(jugador));
        mazo.add(new DragonDefinitivoDeOjosAzules(jugador));
        mazo.add(new ElDragonAladoDeRa(jugador));
        mazo.add(new GenioMisticoDeLaLampara(jugador));
        mazo.add(new Griffore(jugador));
        mazo.add(new GuerreroCastor(jugador));
        //mazo.add(new GuerreroCelta(jugador));
        mazo.add(new IncursorDelHacha(jugador));
        mazo.add(new InsectoComeHombres(jugador));
        mazo.add(new Jinzo7(jugador));
        mazo.add(new Kuriboh(jugador));
        mazo.add(new MagoOscuro(jugador));
        mazo.add(new ObeliscoElAtormentador(jugador));
        mazo.add(new PetitAngel(jugador));
        mazo.add(new PiernaDerechaExodia(jugador));
        mazo.add(new PiernaIzquierdaExodia(jugador));
        mazo.add(new SliferElDragonDelCielo(jugador));
        mazo.add(new SoldadoGiganteDePiedra(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new DragonMilenario(jugador));
        mazo.add(new DragonNegroDeOjosRojos(jugador));
        mazo.add(new EspadachinDeLaLlama(jugador));
        mazo.add(new Fisura(jugador));
        mazo.add(new PezDe7Colores(jugador));
        mazo.add(new Sogen(jugador));

        return mazo;
    }

    public Stack<Carta> getMuestra9Cartas2(Jugador jugador) {
        Stack<Carta> mazo = new Stack<>();

        mazo.add(new DragonNegroDeOjosRojos(jugador));
        mazo.add(new EspadachinDeLaLlama(jugador));
        mazo.add(new Fisura(jugador));
        mazo.add(new PezDe7Colores(jugador));
        mazo.add(new AgujeroNegro(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new DragonMilenario(jugador));
        mazo.add(new Wasteland(jugador));

        return mazo;
    }

    public Stack<Carta> getMuestra1(Jugador jugador) {
        Stack<Carta> mazo = new Stack();

        mazo.add(new PetitAngel(jugador));
        mazo.add(new PezDe7Colores(jugador));
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
        mazo.add(new PezDe7Colores(jugador));
        mazo.add(new GuerreroCelta(jugador));
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
        mazo.add(new PezDe7Colores(jugador));
        mazo.add(new Griffore(jugador));
        mazo.add(new IncursorDelHacha(jugador));
        mazo.add(new IncursorDelHacha(jugador));
        mazo.add(new IncursorDelHacha(jugador));
        mazo.add(new DragonBlancoDeOjosAzules(jugador));

        return mazo;
    }

    public Stack<Carta> getMuestraExodia(Jugador jugador) {
        Stack<Carta> mazo = new Stack();

        mazo.add(new PetitAngel(jugador));
        mazo.add(new PezDe7Colores(jugador));
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

    public Stack<Carta> getMuestraCartasPedidas(Jugador jugador) {
        Stack<Carta> mazo = new Stack();

        mazo.add(new OllaDeLaCodicia(jugador));
        mazo.add(new Fisura(jugador));
        mazo.add(new Refuerzos(jugador));
        mazo.add(new AgujeroNegro(jugador));
        mazo.add(new Wasteland(jugador));
        mazo.add(new BebeDragon(jugador));
        mazo.add(new CilindroMagico(jugador));
        mazo.add(new OllaDeLaCodicia(jugador));
        mazo.add(new Jinzo7(jugador));
        mazo.add(new InsectoComeHombres(jugador));
        mazo.add(new Sogen(jugador));

        return mazo;
    }

    public Stack<Carta> getMuestra2cartas(Jugador jugador) {
        Stack<Carta> mazo = new Stack();

        mazo.add(new BebeDragon(jugador));
        mazo.add(new AgujeroNegro(jugador));

        return mazo;
    }
}
