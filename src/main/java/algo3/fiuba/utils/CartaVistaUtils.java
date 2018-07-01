package algo3.fiuba.utils;

public class CartaVistaUtils {

    public String getImagenDeCarta(String nombreCarta) {
        return "/algo3/fiuba/resources/img/" + nombreCarta + ".jpg";
    }

    public String getImagenEspacioVacioNoMonstruo() {
        return "algo3/fiuba/resources/img/magica-atr.jpg";
    }

    public String getImagenEspacioVacioMonstruo() {
        return "algo3/fiuba/resources/img/monstruo-atr.jpg";
    }

    public String getImagenCartaBocaAbajo() {
        return "/algo3/fiuba/resources/img/carta-vista-trasera.png";
    }
}
