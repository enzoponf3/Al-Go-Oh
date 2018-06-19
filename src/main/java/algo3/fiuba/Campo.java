package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.NoMonstruo;

import java.util.LinkedList;
import java.util.List;

public class Campo {

    List<Monstruo> zonaMonstruos;
    List<NoMonstruo> zonaNoMonstruos;
    public CartaCampo cartaCampo;

    public Campo() {
        zonaMonstruos = new LinkedList<>();
        zonaNoMonstruos = new LinkedList<>();
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

    public void colocarCarta(Monstruo monstruo, EnJuego enJuego, Monstruo... sacrificios) {
        monstruo.colocarEnCampo(this, enJuego, sacrificios);
    }

    public void colocarCarta(Carta carta, EnJuego enJuego) {
        carta.colocarEnCampo(this, enJuego);
    }

    public void colocarCarta(Monstruo carta) {
        zonaMonstruos.add(carta);
    }

    public void colocarCarta(NoMonstruo carta) {
        zonaNoMonstruos.add(carta);
    }

    public void colocarCarta(CartaCampo carta) {
        cartaCampo = carta;
    }

    public boolean cartaSeEncuentaEnCampo(Monstruo carta) {
        return zonaMonstruos.contains(carta);
    }

    public boolean cartaSeEncuentaEnCampo(NoMonstruo carta) {
        return zonaNoMonstruos.contains(carta);
    }

    public void removerCarta(Monstruo carta) {
        zonaMonstruos.remove(carta);
    }

    public void removerCarta(NoMonstruo carta) {
        zonaNoMonstruos.remove(carta);
    }

    @Override
    public String toString() {
        return "Campo{" +
                "zonaMonstruos=" + zonaMonstruos +
                ", zonaNoMonstruos=" + zonaNoMonstruos +
                '}';
    }

    public void reiniciar() {
        zonaMonstruos = new LinkedList<>();
        zonaNoMonstruos = new LinkedList<>();
        cartaCampo = null;
    }

    public void matarMonstruos() {
        // Se deberían de agregar al cementerio también...
        for(Monstruo monstruo: zonaMonstruos) {
           monstruo.removerDelCampo(this);
        }
    }

    public void aumentarATK(int aumento) {
        for(Monstruo monstruo: zonaMonstruos) {
            monstruo.aumentarATK(aumento);
        }
    }

    public void aumentarDEF(int aumento) {
        for(Monstruo monstruo: zonaMonstruos) {
            monstruo.aumentarDEF(aumento);
        }
    }
}
