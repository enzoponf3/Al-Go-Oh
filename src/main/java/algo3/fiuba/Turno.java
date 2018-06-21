package algo3.fiuba;

import java.util.Observable;
import java.util.Observer;

public class Turno extends Observable {

    private Turno INSTANCIA;
    private Observer observadores;

    private Turno() {
        super();
    }

    public Turno getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new Turno();
        return INSTANCIA;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }
}
