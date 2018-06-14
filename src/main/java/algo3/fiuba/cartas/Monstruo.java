package algo3.fiuba.cartas;

import algo3.fiuba.Campo;
import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.efectos_cartas.EfectoNulo;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombate;
import algo3.fiuba.cartas.estados_cartas.EnCementerio;
import algo3.fiuba.cartas.modo_monstruo.ModoDeAtaque;
import algo3.fiuba.cartas.modo_monstruo.ModoDeDefensa;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.modo_monstruo.ModoDeAtaque;
import algo3.fiuba.cartas.modo_monstruo.ModoDeDefensa;
import algo3.fiuba.cartas.modo_monstruo.ModoMonstruo;

public class Monstruo extends Carta {

    private Integer ataque;
    private Integer defensa;
    private ModoMonstruo modoMonstruo;
    private Integer estrellas;
    public Integer sacrificiosParaInvocar;

    public Monstruo(String nombre, Integer ataque, Integer defensa, Integer estrellas) {

        super(nombre,new EfectoNulo());
        this.ataque = ataque;
        this.defensa = defensa;
        this.estrellas = estrellas;
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

    public void colocarEnCampo(Campo campo) {
        if (this.estrellas >= 7) this.sacrificiosParaInvocar = 2;
        else if (this.estrellas >= 5) this.sacrificiosParaInvocar = 1;
        campo.colocarCartaMonstruo(this);
    }

    @Override
    public void colocarEnCampo(EnJuego tipoEnJuego) {
        estadoCarta = tipoEnJuego;
        modoMonstruo = ModoDeAtaque.getInstancia();
    }

    public void cambiarModo() {
        modoMonstruo = modoMonstruo.cambiarModoMonstruo();
    }

}
