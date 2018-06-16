package algo3.fiuba.cartas;

import algo3.fiuba.Campo;
import algo3.fiuba.TableroJugador;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.estrellas.Estrellas;
import algo3.fiuba.cartas.estrellas.EstrellasFactory;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombate;
import algo3.fiuba.cartas.modo_monstruo.ModoDeAtaque;
import algo3.fiuba.cartas.modo_monstruo.ModoDeDefensa;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.modo_monstruo.ModoMonstruo;

public class Monstruo extends Carta {

    private Integer ataque;
    private Integer defensa;
    private ModoMonstruo modoMonstruo;
    private Estrellas estrellas;
    public Integer sacrificiosParaInvocar;

    public Monstruo(String nombre, Integer ataque, Integer defensa, Integer estrellas) {

        super(nombre,new EfectoNulo());
        this.ataque = ataque;
        this.defensa = defensa;
        this.estrellas = EstrellasFactory.obtenerEstrellas(estrellas);
        this.sacrificiosParaInvocar = 0;
    }

    public void atacar(Monstruo otraCarta) {
        ResultadoCombate resultadoCombate = modoMonstruo.atacar(otraCarta, ataque);
        resultadoCombate.afectarAtacante(this);
    }

    public ResultadoCombate recibirAtaque(Integer puntosAtaqueRival) {
        ResultadoCombate resultadoCombate = modoMonstruo.recibirAtaque(puntosAtaqueRival, ataque, defensa);
        resultadoCombate.afectarDefensor(this);
        return resultadoCombate;
    }

    public void pasarAModoAtaque() {
        modoMonstruo = ModoDeAtaque.getInstancia();
    }

    public void pasarAModoDefensa() {
        modoMonstruo = ModoDeDefensa.getInstancia();
    }

    public void daniarJugador(Integer puntosDeDanio) {
        jugador.modificarPuntosDeVida(-puntosDeDanio);
    }

    @Override
    public boolean estaEnTablero(TableroJugador tableroJugador) {
        return tableroJugador.cartaEstaEnTablero(this);
    }

    @Override
    public void colocarEnCampo(Campo campo, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        if (!estrellas.sacrificiosSuficientes(sacrificios))
            throw new RuntimeException(String.format("Se necesitan estrictamente %d sacrificios para invocarlo.", estrellas.sacrificiosRequeridos()));

        this.realizarSacrificios(sacrificios);
        modoMonstruo = ModoDeAtaque.getInstancia();
        estadoCarta = tipoEnJuego;
        campo.colocarCarta(this);
    }

    /*
    @Override
    public boolean esSacrificable() {
        return true;
    }
    */

    public void cambiarModo() {
        modoMonstruo = modoMonstruo.cambiarModoMonstruo();
    }

    private void realizarSacrificios(Monstruo... sacrificios) {
        for (Monstruo sacrificio : sacrificios) {
            sacrificio.descartar();
            jugador.removerCartaDelTablero(sacrificio);
        }
    }

    @Override
    public void removerDelCampo(Campo campo) {
        campo.removerCarta(this);
    }
}
