package algo3.fiuba.controladores.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BotonAyuda implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent action) {

        try {
            Desktop.getDesktop().browse(new URI("http://www.yugioh-card.com/es/rulebook/es.pdf"));
        } catch (Exception e) {
        }
    }
}
