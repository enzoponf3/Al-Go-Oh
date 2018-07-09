package algo3.fiuba.vista.vista_cartas.estado_carta_vista;

import algo3.fiuba.controladores.ControladorMonstruoAAtacar;
import algo3.fiuba.controladores.botones.checkboxs.CheckBoxMonstruo;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.vista.vista_cartas.CartaVista;
import algo3.fiuba.vista.vista_cartas.MonstruoVista;

public class AtacableBocaArribaVista extends EstadoCartaVista {

    @Override
    public void aniadirFuncionalidad(CartaVista cartaVista) {

    }

    @Override
    public void aniadirFuncionalidad(MonstruoVista cartaVista, Monstruo monstruo) {
        super.generarAtaqueYDefensaDinamica(cartaVista, monstruo);
        CheckBoxMonstruo checkBoxMonstruoAAtacar = new CheckBoxMonstruo(monstruo);
        checkBoxMonstruoAAtacar.setOnAction(new ControladorMonstruoAAtacar());

        cartaVista.getChildren().add(checkBoxMonstruoAAtacar);
    }
}
