package algo3.fiuba.controladores;

import algo3.fiuba.controladores.botones.checkboxs.CheckBoxMonstruo;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.Monstruo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.*;

public class ControladorMonstruoAAtacar implements EventHandler<ActionEvent>, Observer {

    private static List<CheckBoxMonstruo> checkBoxMonstruoAAtacar = new LinkedList<>();

    public ControladorMonstruoAAtacar() {
        Turno.getInstancia().addObserver(this);
    }

    public static Monstruo getMonstruoAAtacar() {
        return checkBoxMonstruoAAtacar.isEmpty() ? null : checkBoxMonstruoAAtacar.get(0).getMonstruo();
    }

    @Override
    public void handle(ActionEvent event) {
        CheckBoxMonstruo checkboxSeleccionadoParaAtacar = (CheckBoxMonstruo) event.getSource();

        if (checkboxSeleccionadoParaAtacar.isSelected()) {
            if (!checkBoxMonstruoAAtacar.isEmpty()) {
                checkBoxMonstruoAAtacar.get(0).setSelected(false);
            }
            checkBoxMonstruoAAtacar.clear();
            checkBoxMonstruoAAtacar.add(checkboxSeleccionadoParaAtacar);
        } else if (!checkBoxMonstruoAAtacar.isEmpty() && checkboxSeleccionadoParaAtacar.equals(checkBoxMonstruoAAtacar.get(0))) {
            checkBoxMonstruoAAtacar.clear();
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        if (!checkBoxMonstruoAAtacar.isEmpty())
            checkBoxMonstruoAAtacar.get(0).setSelected(false);
        checkBoxMonstruoAAtacar.clear();
    }
}
