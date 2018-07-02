package algo3.fiuba.controladores;

import algo3.fiuba.controladores.botones.checkboxs.CheckBoxSacrificio;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.Monstruo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.*;

public class ControladorMonstruoAAtacar implements EventHandler<ActionEvent>, Observer {

    private static List<CheckBoxSacrificio> checkBoxMonstruoAAtacar = new LinkedList<>();

    public ControladorMonstruoAAtacar() {
        Turno.getInstancia().addObserver(this);
    }

    public static Monstruo getMonstruoAAtacar() {
        System.out.println("getMonstruoAAtacar: " + (checkBoxMonstruoAAtacar.isEmpty() ? null : checkBoxMonstruoAAtacar.get(0).getMonstruo()));
        return checkBoxMonstruoAAtacar.isEmpty() ? null : checkBoxMonstruoAAtacar.get(0).getMonstruo();
    }

    @Override
    public void handle(ActionEvent event) {
        CheckBoxSacrificio checkboxSeleccionadoParaAtacar = (CheckBoxSacrificio) event.getSource();

        System.out.println("checkboxSeleccionadoParaAtacar: " + checkboxSeleccionadoParaAtacar.getMonstruo());
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
