package algo3.fiuba.modelo.cartas.modificadores;

public class ModificadorWastelandOponente implements Modificador {
    @Override
    public Integer modificarAtaque(Integer ataque) {
        return ataque;
    }

    @Override
    public Integer modificarDefensa(Integer defensa) {
        return (defensa + 300);
    }
}
