package algo3.fiuba.modelo;

import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.cartas.modificadores.Modificador;
import algo3.fiuba.modelo.excepciones.CampoNoPermiteColocarCartaExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;

import java.util.*;

public class Campo {

    private List<Monstruo> zonaMonstruos;
    private List<NoMonstruo> zonaNoMonstruos;
    private CartaCampo cartaCampo;
    private Set<Modificador> modificadoresActivos;

    private static final Integer LIMITE_CARTAS_EN_ZONA = 5;

    public Campo() {
        zonaMonstruos = new LinkedList<>();
        zonaNoMonstruos = new LinkedList<>();
        cartaCampo = null;
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


        carta.setEstado(enJuego); // !!! sacar
        zonaMonstruos.add(carta);
        this.agregarModificadoresAMonstruos();
    }

    public void colocarCarta(Magica carta, BocaArriba bocaArriba) {
        /*
        if (zonaNoMonstruos.size() >= LIMITE_CARTAS_EN_ZONA)
            throw new CampoNoPermiteColocarCartaExcepcion("No se puede tener más de 5 no monstruos en el campo.");

        zonaNoMonstruos.add(carta);
        */
        carta.setEstado(bocaArriba); // !!! sacar
        carta.activarEfecto();
    }

    public void colocarCarta(Magica carta, BocaAbajo bocaAbajo) {
        if (zonaNoMonstruos.size() >= LIMITE_CARTAS_EN_ZONA)
            throw new CampoNoPermiteColocarCartaExcepcion("No se puede tener más de 5 no monstruos en el campo.");

        carta.setEstado(bocaAbajo); // !!! sacar
        zonaNoMonstruos.add(carta);
    }

    public void colocarCarta(Trampa carta, EnJuego enJuego) {
        if (zonaNoMonstruos.size() >= LIMITE_CARTAS_EN_ZONA)
            throw new CampoNoPermiteColocarCartaExcepcion("No se puede tener más de 5 no monstruos en el campo.");

        carta.setEstado(enJuego); // !!! sacar
        zonaNoMonstruos.add(carta);
    }

    public void colocarCarta(CartaCampo carta, EnJuego enJuego) {
        if (cartaCampo != null)
            cartaCampo.mandarDelCampoAlCementerio();
        carta.setEstado(enJuego); // !!! sacar
        cartaCampo = carta;
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

    // Eh..... ?
    public boolean cartaEstaEnCampo(CartaCampo cartaCampo) {
        return this.cartaCampo == cartaCampo;
    }

    public void removerCarta(Monstruo carta) {
        zonaMonstruos.remove(carta);
    }

    public void removerCarta(NoMonstruo carta) {
        zonaNoMonstruos.remove(carta);
    }

    public void removerCarta(CartaCampo carta) {
        if (cartaCampo != null && cartaCampo.equals(carta)) {
            cartaCampo = null;
            for (Monstruo monstruo : zonaMonstruos) {
                //monstruo.removerModificador();
            }
        }
    }

    @Override
    public String toString() {
        return "Campo{" +
                "zonaMonstruos=" + zonaMonstruos +
                ", zonaNoMonstruos=" + zonaNoMonstruos +
                ", cartaCampo=" + cartaCampo +
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
        return cartaCampo;
    }
}
