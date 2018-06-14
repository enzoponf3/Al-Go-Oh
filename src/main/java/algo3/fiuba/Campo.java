package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Monstruo;

import java.util.LinkedList;

public class Campo {

    LinkedList<Carta> zonaMonstruos;
    LinkedList<Carta> zonaEspeciales;

    public Campo() {
        zonaMonstruos = new LinkedList<>();
        zonaEspeciales = new LinkedList<>();
    }

    public boolean colocarCarta(Carta carta, EnJuego tipoEnJuego) {
        carta.pasarAModoJuego(tipoEnJuego);
        return true;
    }

    public boolean estaVacio() {
        return (zonaMonstruos.isEmpty() && zonaEspeciales.isEmpty());
    }

    public Integer cantidadMonstruos() {
        return (zonaMonstruos.size());
    }

    public Integer cantidadEspeciales() {
        return (zonaEspeciales.size());
    }

    public void colocarCartaMonstruo(Monstruo monstruo) {
        zonaMonstruos.add(monstruo);
    }

    public void colocarCartaEspecial(Carta especial) {
        zonaEspeciales.add(especial);
    }
}
