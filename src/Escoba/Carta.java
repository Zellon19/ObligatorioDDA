package Escoba;

import java.util.ArrayList;
import java.util.List;

public class Carta {
    private Palo palo;
    private int numero;
    private int valor;
    private List<Carta> listaCartas = new ArrayList<>();


    public int getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public int getValor(){
        valor = numero;
        if(numero >= 10 ){
            switch (valor){
                case 10: valor = 8;
                break;
                case 11: valor = 9;
                    break;
                case 12: valor = 10;
                    break;
            }
        }
        return valor;
    }

    public Carta(int numero, Palo palo){
        this.numero = numero;
        this.palo = palo;
    }

    @Override
    public String toString() {
        return numero + " de " + palo;
    }
}
