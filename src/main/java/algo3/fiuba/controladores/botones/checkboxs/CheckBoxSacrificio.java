package algo3.fiuba.controladores.botones.checkboxs;

import algo3.fiuba.modelo.cartas.Monstruo;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;

public class CheckBoxSacrificio extends CheckBox {

    private Monstruo monstruo;

    public CheckBoxSacrificio(Monstruo monstruo) {
        this.monstruo = monstruo;
        super.setStyle(
                "-fx-font-size: 10;"
                + "-fx-background-color: transparent;"
        );

    }

    public Monstruo getMonstruo() {
        return monstruo;
    }
}
