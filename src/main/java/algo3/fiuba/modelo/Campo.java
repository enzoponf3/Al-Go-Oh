package algo3.fiuba.modelo;

import algo3.fiuba.modelo.campo.ZonaCartaCampo;
import algo3.fiuba.modelo.campo.ZonaCartaCampoVacia;
import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.cartas.modificadores.Modificador;
import algo3.fiuba.modelo.excepciones.CampoNoPermiteColocarCartaExcepcion;

import java.util.*;

public class Campo {

    private List<Monstruo> zonaMonstruos;
    private List<NoMonstruo> zonaNoMonstruos;
    private ZonaCartaCampo zonaCartaCampo;
    private Set<Modificador> modificadoresActivos;

    private static final Integer LIMITE_CARTAS_EN_ZONA = 5;

    public Campo() {
        zonaMonstruos = new LinkedList<>();
        zonaNoMonstruos = new LinkedList<>();
        zonaCartaCampo = new ZonaCartaCampoVacia();
        modificadoresActivos = new HashSet<>();
    }

    public boolean estaVacio() {
        return (zonaMonstruos.isEmpty() && zonaNoMonstruos.isEmpty());
    }

    public Integer cantidadMonstruos() {
        return (zonaMonstruos.size());
    }

    public Integer cantidadNoMonstruos() {
        return (zonaNoMonstruos.size());
    }

    public void colocarCarta(Monstruo carta, EnJuego enJuego) {
        if (zonaMonstruos.size() >= LIMITE_CARTAS_EN_ZONA)
            throw new CampoNoPermiteColocarCartaExcepcion("No se puede tener más de 5 monstruos en el campo.");

        carta.setEstado(enJuego);
        zonaMonstruos.add(carta);
        this.agregarModificadoresAMonstruos();
    }

    public void colocarCarta(Magica carta, BocaArriba bocaArriba) {
        carta.setEstado(bocaArriba);
        carta.activarEfecto();
    }

    public void colocarCarta(Magica carta, BocaAbajo bocaAbajo) {
        if (zonaNoMonstruos.size() >= LIMITE_CARTAS_EN_ZONA)
            throw new CampoNoPermiteColocarCartaExcepcion("No se puede tener más de 5 no monstruos en el campo.");

        carta.setEstado(bocaAbajo);
        zonaNoMonstruos.add(carta);
    }

    public void colocarCarta(Trampa carta, BocaArriba bocaArriba) {
        this.colocarCarta(carta, new BocaAbajo());
    }

    public void colocarCarta(Trampa carta, BocaAbajo bocaAbajo) {
        if (zonaNoMonstruos.size() >= LIMITE_CARTAS_EN_ZONA)
            throw new CampoNoPermiteColocarCartaExcepcion("No se puede tener más de 5 no monstruos en el campo.");

        carta.setEstado(bocaAbajo);
        zonaNoMonstruos.add(carta);
    }

    public void colocarCarta(CartaCampo carta, BocaArriba bocaArriba) {
        zonaCartaCampo = zonaCartaCampo.agregarCartaCampo(carta);
        carta.setEstado(bocaArriba);
    }

    public void colocarCarta(CartaCampo carta, BocaAbajo bocaAbajo) {
        this.colocarCarta(carta, new BocaArriba());
    }

    public boolean cartaEstaEnCampo(Carta carta) {
        return carta.estaEnCampo(this);
    }

    public boolean cartaEstaEnCampo(Monstruo carta) {
        return zonaMonstruos.contains(carta);
    }

    public boolean cartaEstaEnCampo(NoMonstruo carta) {
        return zonaNoMonstruos.contains(carta);
    }

    public boolean cartaEstaEnCampo(CartaCampo carta) {
        return zonaCartaCampo.cartaEstaEnZona(carta);
    }

    public void removerCarta(Monstruo carta) {
        zonaMonstruos.remove(carta);
    }

    public void removerCarta(NoMonstruo carta) {
        zonaNoMonstruos.remove(carta);
    }

    public void removerCarta(CartaCampo carta) {
        zonaCartaCampo = zonaCartaCampo.removerCartaCampo(carta);
    }

    @Override
    public String toString() {
        return "Campo{" +
                "zonaMonstruos=" + zonaMonstruos +
                ", zonaNoMonstruos=" + zonaNoMonstruos +
                ", zonaCartaCampo=" + zonaCartaCampo +
                '}';
    }

    public List<Monstruo> getMonstruos() {
        return zonaMonstruos;
    }

    public List<NoMonstruo> getNoMonstruos() {
        return zonaNoMonstruos;
    }

    public void agregarModificador(Modificador modificador) {
        modificadoresActivos.add(modificador);
        this.agregarModificadoresAMonstruos();
    }

    public void removerModificador(Modificador modificador) {
        modificadoresActivos.remove(modificador);
        this.removerModificadorAMonstruo(modificador);
    }

    private void agregarModificadoresAMonstruos() {
        for(Monstruo monstruo: zonaMonstruos) {
            for(Modificador modificador: modificadoresActivos) {
                monstruo.agregarModificador(modificador);
            }
        }
    }

    private void removerModificadorAMonstruo(Modificador modificador) {
        for(Monstruo monstruo: zonaMonstruos) {
            monstruo.removerModificador(modificador);
        }
    }

    public CartaCampo getCartaCampo() {
        return zonaCartaCampo.getCartaCampo();
    }
}
