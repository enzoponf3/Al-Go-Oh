package algo3.fiuba.cartas;

import algo3.fiuba.Campo;
import algo3.fiuba.TableroJugador;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estado_en_turno.NoUsadaEnTurno;
import algo3.fiuba.cartas.estado_en_turno.UsadaEnTurno;
import algo3.fiuba.cartas.estrellas.Estrellas;
import algo3.fiuba.cartas.estrellas.EstrellasFactory;
import algo3.fiuba.cartas.modificadores.Modificador;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombate;
import algo3.fiuba.cartas.modo_monstruo.ModoDeAtaque;
import algo3.fiuba.cartas.modo_monstruo.ModoDeDefensa;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.modo_monstruo.ModoMonstruo;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombateNulo;

import java.util.HashSet;
import java.util.Set;

public class Monstruo extends Carta {

    private Integer ataqueBase;
    private Integer defensaBase;
    protected ModoMonstruo modoMonstruo;
    private Estrellas estrellas;
    private Integer sacrificiosParaInvocar;
    private Set<Modificador> modificadoresAtaque;
    private Set<Modificador> modificadoresDefensa;

    public Monstruo(String nombre, Integer ataque, Integer defensa, Integer estrellas, EfectoCarta efecto) {

        super(nombre, efecto);
        this.ataqueBase = ataque;
        this.defensaBase = defensa;
        this.estrellas = EstrellasFactory.obtenerEstrellas(estrellas);
        this.sacrificiosParaInvocar = 0;
        this.estadoEnTurno = new NoUsadaEnTurno(); // está solo para que pasen los tests
        this.modificadoresAtaque = new HashSet<>();
        this.modificadoresDefensa = new HashSet<>();
    }

    public void atacar(Monstruo otraCarta) {
        estadoCarta.verificarQuePuedeAtacar();
        estadoEnTurno = estadoEnTurno.verificarQueSePuedeUsar();
        ResultadoCombate resultadoCombate = modoMonstruo.atacar(this, otraCarta, this.getAtaque());
        resultadoCombate.afectarAtacante(this);
    }

    public ResultadoCombate recibirAtaque(Monstruo monstruoAtacante, Integer puntosAtaqueRival) {
        if (!jugador.recibirAtaque(monstruoAtacante)) {
            estadoCarta.recibirAtaque(this);
            ResultadoCombate resultadoCombate = modoMonstruo.recibirAtaque(puntosAtaqueRival, this.getAtaque(), this.getDefensa());
            resultadoCombate.afectarDefensor(this);
            return resultadoCombate;
        }
        return new ResultadoCombateNulo();

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

    public void colocarEnCampo(Campo campo, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        if (!estrellas.sacrificiosSuficientes(sacrificios))
            throw new RuntimeException(String.format("Se necesitan estrictamente %d sacrificios para invocarlo.", estrellas.sacrificiosRequeridos()));

        this.realizarSacrificios(campo, sacrificios);
        modoMonstruo = ModoDeAtaque.getInstancia();
        estadoCarta = tipoEnJuego;
        estadoEnTurno = new NoUsadaEnTurno();
        campo.colocarCarta(this, tipoEnJuego, sacrificios);
    }

    public void cambiarModo() {
        modoMonstruo = modoMonstruo.cambiarModoMonstruo();
    }

    protected void realizarSacrificios(Campo campo, Monstruo... sacrificios) {
        for (Monstruo sacrificio : sacrificios) {
            sacrificio.descartar();
            campo.removerCarta(sacrificio);
        }
    }

    @Override
    public void removerDelCampo(Campo campo) {
        campo.removerCarta(this);
    }

    public Integer getAtaque() {
        Integer ataqueModificado = ataqueBase;
        for (Modificador modificador : modificadoresAtaque) {
            ataqueModificado = modificador.modificarAtaque(ataqueModificado);
        }

        return ataqueModificado;
    }

    public Integer getDefensa() {
        Integer defensaModificada = defensaBase;
        for (Modificador modificador : modificadoresDefensa) {
            defensaModificada = modificador.modificarDefensa(defensaModificada);
        }

        return defensaModificada;
    }

}
