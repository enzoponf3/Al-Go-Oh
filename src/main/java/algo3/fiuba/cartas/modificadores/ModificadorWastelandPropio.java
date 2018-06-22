package algo3.fiuba.cartas.modificadores;

public class ModificadorWastelandPropio implements Modificador {
    @Override
    public Integer modificarAtaque(Integer ataque) {
        return (ataque + 200);
    }

    @Override
    public Integer modificarDefensa(Integer defensa) {
        return defensa;
    }
}
