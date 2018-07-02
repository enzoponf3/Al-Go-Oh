package algo3.fiuba.modelo.campo;

import algo3.fiuba.modelo.excepciones.CampoNoPermiteColocarCartaExcepcion;

import java.util.LinkedList;
import java.util.List;

public class ZonaCartas<T> {

    private List<T> cartas;
    private Integer limite;
    private T cartaNula;

    public ZonaCartas(Integer limite, T cartaNula) {
        this.limite = limite;
        this.cartas = new LinkedList<>();
        this.cartaNula = cartaNula;

        for (int i = 0; i < this.limite; i++) {
            cartas.add(cartaNula);
        }

    }

    public void agregar(T carta) {
        if (this.tamanio() >= limite)
            throw new CampoNoPermiteColocarCartaExcepcion(String.format("No se puede tener más de %d cartas de ese tipo en el campo.", limite));

        Integer indicePrimerCartaNula = 0;
        for (T c : cartas) {
            if (c.equals(cartaNula)) {
                break;
            }
            indicePrimerCartaNula++;
        }

        cartas.remove(cartaNula);
        cartas.add(indicePrimerCartaNula, carta);
    }

    public void remover(T carta) {
        Integer i = 0;
        for (T c : cartas) {
            if (carta.equals(c)) {
                cartas.add(i, cartaNula);
                break;
            }
            i++;
        }

        cartas.remove(carta);
    }

    public boolean contiene(T carta) {
        return cartas.contains(carta);
    }

    public boolean estaVacia() {
        return this.tamanio() == 0;
    }

    public Integer tamanio() {
        Integer tamanio = 0;
        for (T c : cartas) {
            if (!c.equals(cartaNula)) {
                tamanio++;
            }
        }

        return tamanio;
    }

    public List<T> getCartas() {
        return cartas;
    }
}
