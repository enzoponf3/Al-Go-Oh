package algo3.fiuba.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;

import javax.swing.event.HyperlinkEvent;


public class EventoAyuda implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent action) {

        Hyperlink ayuda = new Hyperlink("http://www.yugioh-card.com/es/rulebook/es.pdf");
        // ver como llamar a url
    }
}
