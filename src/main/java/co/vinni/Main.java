package co.vinni;

import co.vinni.interaccion.GestorConsola;
import co.vinni.util.ManejadorPropiedades;

public class Main {
    public static void main(String[] args) {

        GestorConsola consola = new GestorConsola();
        consola.enviarCorreo();
    }
}
