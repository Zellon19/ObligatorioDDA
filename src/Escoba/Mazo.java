package Escoba;

import java.util.*;

public class Mazo {

    private static ArrayList<Carta> listaCartas = new ArrayList<>();

    public static void generarMazo() {
        for(int i=1; i<=12;i++) {
            if(i!=8 && i!=9) {
                listaCartas.add(new Carta(i, Palo.ORO));
                listaCartas.add(new Carta(i, Palo.ESPADA));
                listaCartas.add(new Carta(i, Palo.BASTO));
                listaCartas.add(new Carta(i, Palo.COPA));
            }
        }

        Collections.shuffle(listaCartas); //baraja las cartas

    }

    public Carta getCarta() {
        Carta carta = listaCartas.get(0);
        listaCartas.remove(0);
        return carta;
    }

    public boolean quedanCartas() {
        return listaCartas.size()>0;
    }

    public Mazo() {
        generarMazo();

    }
}

