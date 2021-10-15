package Escoba;

import java.util.ArrayList;
import java.util.List;

public class Carta {
    private Palo palo;
    private String numero;
    private int valor;
    private List<Carta> listaCartas = new ArrayList<>();

    public String getNumero() {
        return numero;
    }
    public Palo getPalo() {
        return palo;
    }
    public int getValor(){
        return valor;
    }

    public Carta(Integer valor, Palo palo){
        this.valor = valor;
        this.palo = palo;
        this.numero = valor.toString();

        if(valor >= 10 ){
            switch (valor){
                case 10:
                    this.numero = "Sota";
                    this.valor = 8;
                    break;
                case 11:
                    this.numero = "Caballo";
                    this.valor = 9;
                    break;
                case 12:
                    this.numero = "Rey";
                    this.valor = 10;
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return numero + " de " + palo;
    }
}
