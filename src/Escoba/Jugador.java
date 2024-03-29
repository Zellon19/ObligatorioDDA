package Escoba;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private boolean turno;
    private int puntos = 0;
    private List<Carta> cartas = new ArrayList<Carta>();
    private List<Carta> mazoAcumulado = new ArrayList<Carta>();

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void sumaPuntos(int p) {
        puntos=puntos+p;
    }

    public boolean getTurno() {
        return turno;
    }

    public void setTurno(boolean juega) {
        turno=juega;
    }
    public List<Carta> getCartas(){
        return cartas;
    }

    public List<Carta> getMazoAcumulado(){
        return mazoAcumulado;
    }


    public void acumularCartas(ArrayList<Carta> cartas){
        for(Carta carta: cartas){
            mazoAcumulado.add(carta);
        }
    }

    public void recibirCarta(Carta carta){
        cartas.add(carta);
    }

    public void sacarCarta(int i){
        cartas.remove(i);
    }

    public void limpiar(){
        mazoAcumulado.clear();
        cartas.clear();
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

}
