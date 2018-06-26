package algo3.fiuba.modelo.cartas.modificadores;

public class ModificadorSogenOponente implements Modificador {
    @Override
    public Integer modificarAtaque(Integer ataque) {
        return (ataque + 200);
    }

    @Override
    public Integer modificarDefensa(Integer defensa) {
        return defensa;
    }
}
