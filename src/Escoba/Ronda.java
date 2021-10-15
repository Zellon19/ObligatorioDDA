package Escoba;

import java.util.ArrayList;
import java.util.Scanner;

public class Ronda {

    private ArrayList<Carta> listaMesa = new ArrayList<Carta>();
    public Mazo getMazo(){
        return mazo;
    }

    private Mazo mazo = new Mazo();

    private Jugador jugador1;
    private Jugador jugador2;

    public Jugador getJugador1() {
        return jugador1;
    }
    public Jugador getJugador2() {
        return jugador2;
    }
    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }
    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Ronda(Jugador pJugador1, Jugador pJugador2){
        this.jugador1 = pJugador1;
        this.jugador2 = pJugador2;
    }


    public void repartirInicial(){ //Coloca 4 cartas en la mesa
        for(int i=0; i<4; i++){
            listaMesa.add(mazo.getCarta());
        }
    }

    public void repartirJugadores(){ //Reparte 3 cartas a cada jugador
        for(int i=0; i<3; i++){
            jugador1.recibirCarta(mazo.getCarta());
            jugador2.recibirCarta(mazo.getCarta());
        }
    }

    public void cambiarTurno() { //Invierte los turnos de los jugadores
        boolean turno = jugador1.getTurno();
        jugador1.setTurno(!turno);
        jugador2.setTurno(turno);
    }

    public void jugarTurno(){
        cambiarTurno();

        if(jugador1.getTurno()){ //Chequea de quien es el turno
            System.out.println("Turno Jugador 1");
            System.out.println("Cartas de la mesa:");
            System.out.println(listaMesa.toString());
            System.out.println("Cartas del Jugador 1");
            System.out.println(jugador1.getCartas().toString());
            while(TirarCartas(jugador1)); //Se repite hasta no dar error
            System.out.println("--------------------");

        }
        else{
            System.out.println("Turno Jugador 2");
            System.out.println("Cartas de la mesa:");
            System.out.println(listaMesa.toString());
            System.out.println("Cartas del Jugador 2");
            System.out.println(jugador2.getCartas().toString());
            while(TirarCartas(jugador2));
            System.out.println("--------------------");
        }

    }

    public boolean TirarCartas(Jugador jugador){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que carta desea tirar? (Escriba la posicion de la carta: 1, 2, etc)");
        int cartaTirar = scanner.nextInt();

        if(cartaTirar <= jugador.getCartas().size() && cartaTirar > 0){ //Chequea que el indice de la carta a tirar no este fuera de rango
            System.out.println("Elija las cartas a levantar separadas por comas sin espacios (0 para no levantar)");
            String cartasLevantar = scanner.next();

            if(!cartasLevantar.equals("0")){ //Chequea que se quiera levantar algo

                String[] cartas = cartasLevantar.split(",");

                int total = 0;
                for(String carta: cartas){ //Agrega el valor de cada seleccionada carta al total
                    if(Integer.parseInt(carta) <= listaMesa.size()) {
                        total += listaMesa.get(Integer.parseInt(carta) - 1).getValor();
                    }
                }

                total += jugador.getCartas().get(cartaTirar-1).getValor(); //Le suma el valor de la carta que se tira

                if(total == 15){ //Chequea que el total sea 15
                    System.out.println("Levantado con exito");

                    ArrayList<Carta> cartasASacar = new ArrayList<Carta>();
                    for(String carta: cartas) { //Agrega a una lista de cartas las cartas a sacar
                        cartasASacar.add(listaMesa.get(Integer.parseInt(carta) - 1));
                    }

                    ArrayList<Carta> mazoCartas = new ArrayList<Carta>();

                    for(Carta carta: cartasASacar){ //Saca las cartas de la mesa y las agrega a una lista de cartas
                         mazoCartas.add(carta);
                         listaMesa.remove(carta);
                    }
                    mazoCartas.add(jugador.getCartas().get(cartaTirar-1)); //Agrega tambien la carta que se tiro

                    if(listaMesa.size() == 0){ //Suma 1 punto si un jugador hace una escoba
                        System.out.println("Escoba");
                        if(jugador1.getTurno()){
                            jugador1.sumaPuntos(1);
                        }
                        else{
                            jugador2.sumaPuntos(1);
                        }
                    }

                    if(jugador1.getTurno()){ //Se le agrega la lista de cartas al mazo del jugador y se le saca la carta que tiro
                        jugador1.acumularCartas(mazoCartas);
                        jugador1.sacarCarta(cartaTirar-1);

                        if(!mazo.quedanCartas() && jugador2.getCartas().size() == 0){ //Solo en turno final para levantar las cartas que queden en la mesa
                            jugador1.acumularCartas(listaMesa);
                            listaMesa.clear();
                        }
                    }
                    else{
                        jugador2.acumularCartas(mazoCartas);
                        jugador2.sacarCarta(cartaTirar-1);

                        if(!mazo.quedanCartas() && jugador1.getCartas().size() == 0){
                            jugador2.acumularCartas(listaMesa);
                            listaMesa.clear();
                        }
                    }


                    return false;
                }
                else{
                    System.out.println("Error");
                    return true;
                }

            }
            else{ //Si se decide no levantar se saca la carta de la mano del jugador y se agrega a la mesa

                listaMesa.add(jugador.getCartas().get(cartaTirar-1));
                if(jugador1.getTurno()){
                    jugador1.sacarCarta(cartaTirar-1);

                    if(!mazo.quedanCartas() && jugador2.getCartas().size() == 0){
                        jugador1.acumularCartas(listaMesa);
                        listaMesa.clear();
                    }
                }
                else{
                    jugador2.sacarCarta(cartaTirar-1);

                    if(!mazo.quedanCartas() && jugador1.getCartas().size() == 0){
                        jugador2.acumularCartas(listaMesa);
                        listaMesa.clear();
                    }
                }
                return false;
            }
        }
        return true;
    }


    public void calcularPuntos(){
        int puntosJ1 = 0;
        int puntosJ2 = 0;

        if(jugador1.getMazoAcumulado().size() > jugador2.getMazoAcumulado().size()){ //Le suma 1 punto al jugador con mas cartas
            puntosJ1++;
        }
        else if(jugador2.getMazoAcumulado().size() > jugador1.getMazoAcumulado().size()){
            puntosJ2++;
        }


        int orosJ1 = 0;
        int orosJ2 = 0;
        for(Carta carta: jugador1.getMazoAcumulado()){ //Recorre la lista de cartas del Jugador
            if(carta.getPalo() == Palo.ORO) {
                orosJ1++; //Suma 1 al contador de oros

                if(carta.getValor() == 7 || carta.getNumero().equals("Rey")){ //El 12 y 7 de oro suman 1 punto
                    puntosJ1++;
                }
            }
        }
        for(Carta carta: jugador2.getMazoAcumulado()){
            if(carta.getPalo() == Palo.ORO) {
                orosJ2++;

                if(carta.getValor() == 7 || carta.getNumero().equals("Rey")){
                    puntosJ2++;
                }
            }
        }
        if(orosJ1 > orosJ2){
            puntosJ1++;
        }
        else if(orosJ2 > orosJ1){
            puntosJ2++;
        }

        jugador1.sumaPuntos(puntosJ1); //Se le suman los puntos a los jugadores
        jugador2.sumaPuntos(puntosJ2);
    }


}
