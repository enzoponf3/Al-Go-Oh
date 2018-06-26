package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.NoMonstruo;
import algo3.fiuba.cartas.modificadores.Modificador;
import algo3.fiuba.excepciones.CampoNoPermiteColocarCartaExcepcion;
import algo3.fiuba.jugador.Jugador;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

    public void colocarCarta(NoMonstruo carta, EnJuego enJuego) {
        if (zonaNoMonstruos.size() >= LIMITE_CARTAS_EN_ZONA)
            throw new CampoNoPermiteColocarCartaExcepcion("No se puede tener más de 5 no monstruos en el campo.");

        carta.setEstado(enJuego); // !!! sacar
        zonaNoMonstruos.add(carta);
    }

    public void colocarCarta(CartaCampo carta, EnJuego enJuego) {
        
        // !!!Debería de verificar si ya había otra carta de campo.
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
        return this.cartaCampo.equals(cartaCampo);
    }

    public void removerCarta(Monstruo carta) {
        zonaMonstruos.remove(carta);
    }

    public void removerCarta(NoMonstruo carta) {
        zonaNoMonstruos.remove(carta);
    }

    public void removerCarta(CartaCampo carta) {
        if (cartaCampo.equals(carta))
            cartaCampo = null;
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

    private void agregarModificadoresAMonstruos() {
        for(Monstruo monstruo: zonaMonstruos) {
            for(Modificador modificador: modificadoresActivos) {
                monstruo.agregarModificador(modificador);
            }
        }
    }
}
