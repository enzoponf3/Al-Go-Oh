package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.resultado_combate.NoMonstro;

import java.util.LinkedList;

public class Campo {

    LinkedList<Carta> zonaMonstruos;
    LinkedList<Carta> zonaNoMonstruos;

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

    public Integer cantidadEspeciales() {
        return (zonaNoMonstruos.size());
    }

    public void colocarCarta(Carta carta, EnJuego enJuego) {
        carta.colocarEnCampo(this, enJuego);

        zonaMonstruos.add(carta);
    }

    public void colocarCarta(Monstruo carta) {
        zonaMonstruos.add(carta);
        /*
        // Se supone que con la interfaz gráfica deberiamos ahorrarnos esto...
        if (this.cantidadMonstruos() < monstruo.sacrificiosParaInvocar)
            throw new RuntimeException("No tienes suficientes monstruos para sacrificar!");
        for (int i = 0; i < monstruo.sacrificiosParaInvocar; i++) {
            zonaMonstruos.pop();
        }
        zonaMonstruos.add(monstruo);
        */
    }

    public void colocarCarta(NoMonstro carta) {
        zonaNoMonstruos.add(carta);
        /*
        // Se supone que con la interfaz gráfica deberiamos ahorrarnos esto...
        if (this.cantidadMonstruos() < monstruo.sacrificiosParaInvocar)
            throw new RuntimeException("No tienes suficientes monstruos para sacrificar!");
        for (int i = 0; i < monstruo.sacrificiosParaInvocar; i++) {
            zonaMonstruos.pop();
        }
        zonaMonstruos.add(monstruo);
        */
    }


    public void colocarCartaEspecial(Carta especial) {
        zonaNoMonstruos.add(especial);
    }

    public boolean cartaSeEncuentaEnCampo(Carta carta) {
        return zonaMonstruos.contains(carta);
    }


}
