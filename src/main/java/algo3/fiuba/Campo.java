package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.NoMonstruo;

import java.util.LinkedList;

public class Campo {

    LinkedList<Monstruo> zonaMonstruos;
    LinkedList<NoMonstruo> zonaNoMonstruos;

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

    public Integer cantidadNoEspeciales() {
        return (zonaNoMonstruos.size());
    }

    public void colocarCarta(Carta carta, EnJuego enJuego, Monstruo... sacrificios) {
        carta.colocarEnCampo(this, enJuego, sacrificios);
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

    public void colocarCarta(NoMonstruo carta) {
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

    public boolean cartaSeEncuentaEnCampo(Monstruo carta) {
        return zonaMonstruos.contains(carta);
    }

    public boolean cartaSeEncuentaEnCampo(NoMonstruo carta) {
        return zonaNoMonstruos.contains(carta);
    }


    public void activarEfectoSobreElementos(EfectoCarta efecto) {
        efecto.activar(zonaMonstruos);
    }

    public void eliminarCarta(Carta carta) {
        // Solo elimina cartas monstruos por el momento.
        zonaMonstruos.remove(carta);
    }
}
