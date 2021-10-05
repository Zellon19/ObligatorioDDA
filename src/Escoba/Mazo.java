package Escoba;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Mazo {

    public static void main(String[] args) {
        generarMazo();
    }

    private static ArrayList<Carta> listaCartas = new ArrayList<>();

    public static void generarMazo() {
        for(int i=1; i<=12;i++) {
            listaCartas.add(new Carta(i,"Oro"));
            listaCartas.add(new Carta(i,"Copa"));
            listaCartas.add(new Carta(i,"Espada"));
            listaCartas.add(new Carta(i,"Basto"));
        }

        Collections.shuffle(listaCartas); //baraja las cartas
        for (Carta carta: listaCartas) {
            System.out.println(carta.getNumero() +" "+ carta.getPalo() + " " + carta.getValor() );
        }

    }

    public Carta getCarta() {
        Carta carta = listaCartas.get(0);
        listaCartas.remove(0);
        return carta;
    }

    public boolean quedanCartas() {
        return listaCartas.size()>0;
    }

    public Baraja() {
        generarBaraja();

    }
}

