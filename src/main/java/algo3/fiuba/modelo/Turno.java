package algo3.fiuba.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Turno extends Observable {

    private static Turno INSTANCIA;
    private List<Observer> observadores;
    private Integer numeroDeTurno;

    private Turno() {
        super();
        this.observadores = new LinkedList<>();
        this.numeroDeTurno = 1;
    }

    public static Turno getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new Turno();
        return INSTANCIA;
    }

    public void pasarTurno() {
        this.notifyObservers();
        numeroDeTurno++;
    }


    public boolean esElPrimerTurno() {
        return numeroDeTurno == 1;
    }


    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        observadores.add(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
        observadores.remove(o);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
        for (Observer o : observadores) {
            o.update(this, null);
        }
    }
}
