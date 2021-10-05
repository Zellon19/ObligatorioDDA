package Escoba;

import java.util.ArrayList;

public class Ronda {
    private Mano mano1 = new Mano();
    private Mano mano2 = new Mano();

    private ArrayList<Carta> listaSeleccionadas = new ArrayList<Carta>();
    private ArrayList<Carta> listaMesa = new ArrayList<Carta>();

    private Baraja baraja = new Baraja();

    private Juego juego = new Juego();

    private Jugador jugador1 = new Jugador("Jugador1");
    private Jugador jugador2 = new Jugador("Jugador2");


}
