package algo3.fiuba.vista.vista_cartas.estado_carta_vista;

import algo3.fiuba.controladores.ControladorCantidadDeSacrificios;
import algo3.fiuba.controladores.botones.checkboxs.CheckBoxMonstruo;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.vista.vista_cartas.CartaVista;
import algo3.fiuba.vista.vista_cartas.MonstruoVista;

public class SacrificableVista extends EstadoCartaVista {

    @Override
    public void aniadirFuncionalidad(CartaVista cartaVista) {

    }

    @Override
    public void aniadirFuncionalidad(MonstruoVista cartaVista, Monstruo monstruo) {
        super.generarAtaqueYDefensaDinamica(cartaVista, monstruo);
        CheckBoxMonstruo checkBoxParaSacrificio = new CheckBoxMonstruo(monstruo);
        checkBoxParaSacrificio.setOnAction(new ControladorCantidadDeSacrificios());

        cartaVista.getChildren().add(checkBoxParaSacrificio);
    }
}
