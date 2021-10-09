package Escoba;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private boolean turno;
//    private Mano mano;
    private int puntos = 0;
    private List<Carta> cartas = new ArrayList<Carta>();
    private List<Carta> mazoRobado = new ArrayList<Carta>();

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }

//    public Mano getMano() {
//        return mano;
//    }

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

    public List<Carta> getMazoRobado(){
        return mazoRobado;
    }

    public void AcumularCartas(ArrayList<Carta> cartas){
        for(Carta carta: cartas){
            mazoRobado.add(carta);
        }
    }

    public void recibirCarta(Carta carta){
        cartas.add(carta);
    }

    public void SacarCarta(int i){
        cartas.remove(i);
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }
}
