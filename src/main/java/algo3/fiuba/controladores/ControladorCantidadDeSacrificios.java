package algo3.fiuba.controladores;

import algo3.fiuba.controladores.botones.checkboxs.CheckBoxSacrificio;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.Monstruo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class ControladorCantidadDeSacrificios implements EventHandler<ActionEvent>, Observer {

    private static List<Monstruo> monstruosASacrificar = new LinkedList<>();

    public ControladorCantidadDeSacrificios() {
        Turno.getInstancia().addObserver(this);
    }

    @Override
    public void handle(ActionEvent event) {
        CheckBoxSacrificio checkboxSeleccionadoParaSacrificio = (CheckBoxSacrificio) event.getSource();
        Monstruo monstruo = checkboxSeleccionadoParaSacrificio.getMonstruo();
        if (checkboxSeleccionadoParaSacrificio.isSelected()) {
            monstruosASacrificar.add(monstruo);
        } else {
            monstruosASacrificar.remove(monstruo);
        }
    }

    public static Monstruo[] getMonstruosASacrificar() {
        return monstruosASacrificar.toArray(new Monstruo[monstruosASacrificar.size()]);
    }

    @Override
    public void update(Observable o, Object arg) {
        monstruosASacrificar.clear();
    }
}
