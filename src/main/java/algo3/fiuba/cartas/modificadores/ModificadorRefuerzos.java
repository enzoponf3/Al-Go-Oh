package algo3.fiuba.cartas.modificadores;

public class ModificadorRefuerzos implements Modificador {

    @Override
    public Integer modificarAtaque(Integer ataque) {
        return ataque + 500;
    }

    @Override
    public Integer modificarDefensa(Integer defensa) {
        return defensa;
    }
}
