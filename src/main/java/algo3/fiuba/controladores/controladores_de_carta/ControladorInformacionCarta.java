package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.vista.VistaCarta;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseEvent;

public class ControladorInformacionCarta implements EventHandler<MouseEvent> {

    private VistaCarta vistaCarta;
    private ContextMenu menuOpciones;

    public ControladorInformacionCarta(VistaCarta vistaCarta, ContextMenu menuOpciones) {
        this.vistaCarta = vistaCarta;
        this.menuOpciones = menuOpciones;
    }

    @Override
    public void handle(MouseEvent event) {
        menuOpciones.show(vistaCarta,event.getX(),event.getY());
    }
}
