package algo3.fiuba.controladores;

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
        } catch (IOException e1) {
            System.out.println("ne");
        } catch (URISyntaxException e2) {
            System.out.println("nw");
        }
    }
}
