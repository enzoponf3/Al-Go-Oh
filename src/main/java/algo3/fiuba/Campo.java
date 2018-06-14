package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.EnJuego;

import java.util.LinkedList;

public class Campo {

    LinkedList<Carta> zonaMonstruos;
    LinkedList<Carta> zonaEspeciales;

    public Campo() {
        zonaMonstruos = new LinkedList<>();
        zonaEspeciales = new LinkedList<>();
    }

    public boolean campoColocarCarta(Carta carta, EnJuego tipoEnJuego ) {
        carta.colocarEnCampo(tipoEnJuego);
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

        // Se supone que con la interfaz gráfica deberiamos ahorrarnos esto...
        if (this.cantidadMonstruos() < monstruo.sacrificiosParaInvocar)
            throw new RuntimeException("No tienes suficientes monstruos para sacrificar!");
        for (int i = 0; i < monstruo.sacrificiosParaInvocar; i++) {
            zonaMonstruos.pop();
        }
        zonaMonstruos.add(monstruo);
    }

    public void colocarCartaEspecial(Carta especial) {
        zonaEspeciales.add(especial);
    }

    public boolean cartaSeEncuentaEnCampo(Carta carta) {
        return zonaMonstruos.contains(carta);
    }


}
