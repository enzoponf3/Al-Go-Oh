package algo3.fiuba.controladores.botones.checkboxs;

import algo3.fiuba.modelo.cartas.Monstruo;
import javafx.scene.control.CheckBox;

public class CheckBoxSacrificio extends CheckBox {

    private Monstruo monstruo;

    public CheckBoxSacrificio(Monstruo monstruo) {
        this.monstruo = monstruo;

        super.setStyle( // !!!!
                "-fx-border-color: lightblue; "
                        + "-fx-font-size: 20;"
                        + "-fx-border-insets: -5; "
                        + "-fx-border-radius: 5;"
                        + "-fx-border-style: dotted;"
                        + "-fx-border-width: 2;"
        );

    }

    public Monstruo getMonstruo() {
        return monstruo;
    }
}
