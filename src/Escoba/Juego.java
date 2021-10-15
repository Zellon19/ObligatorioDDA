package Escoba;

import java.util.*;

public class Juego {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("*** Bienvenido a la Escoba del 15 ***");
            System.out.println("Seleccione una opción");
            System.out.println("1- Jugar");
            System.out.println("2- ¿Cómo jugar?");


            opcion = input.nextInt();

            switch(opcion) {
                case 1:

                    Jugador jugador1 = new Jugador("Jugador1"); //Jugadores se crean fuera de la ronda para poder reutilizarlos en varias rondas
                    Jugador jugador2 = new Jugador("Jugador2");
                    int puntosJuegoJ1 = 0;
                    int puntosJuegoJ2 = 0;


                    while(puntosJuegoJ1 < 21 && puntosJuegoJ2 < 21) { //Se repite mientras ningun jugador alcanze los 21 puntos
                        Ronda ronda = new Ronda(jugador1, jugador2);
                        ronda.repartirInicial();

                        while (ronda.getMazo().quedanCartas()) {

                            ronda.repartirJugadores();
                            System.out.println("Repartir");
                            System.out.println("--------------------");
                            for (int i = 0; i < 6; i++) {
                                ronda.jugarTurno();
                            }
                        }
                        ronda.calcularPuntos();

                        List<Carta> cartasJ1 = jugador1.getMazoAcumulado(); //Ordena los mazos de los jugadores y los muestra
                        List<Carta> cartasJ2 = jugador2.getMazoAcumulado(); //en pantalla al finalizar la ronda
                        cartasJ1.sort(Comparator.comparing(Carta::getValor));
                        cartasJ2.sort(Comparator.comparing(Carta::getValor));

                        System.out.println("Mazo Ordenado Jugador 1:");
                        System.out.println(cartasJ1);
                        System.out.println("Mazo Ordenado Jugador 2:");
                        System.out.println(cartasJ2);

                        jugador1.limpiar();
                        jugador2.limpiar();

                    }

                    if(jugador1.getPuntos() > jugador2.getPuntos()){
                        System.out.println("Gana el Jugador 1");
                        System.out.println("Puntos Jugador 1: " + jugador1.getPuntos());
                        System.out.println("Puntos Jugador 2: " + jugador2.getPuntos());
                    }
                    else if(jugador2.getPuntos() > jugador1.getPuntos()){
                        System.out.println("Gana el Jugador 2");
                        System.out.println("Puntos Jugador 1: " + jugador1.getPuntos());
                        System.out.println("Puntos Jugador 2: " + jugador2.getPuntos());
                    }
                    else{
                        System.out.println("Empate");
                        System.out.println("Puntos Jugador 1: " + jugador1.getPuntos());
                        System.out.println("Puntos Jugador 2: " + jugador2.getPuntos());
                    }

                    break;

                case 2:
                    tutorial();
                    break;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
                    opcion = 1;
                    continue;
            }
        }
        while(opcion != 0);
    }

    public static void tutorial(){ // mini tutorial uwu
        Scanner input = new Scanner(System.in);

        int opcion;
        do{
            System.out.println("*** Tutorial ***");
            System.out.println("1- Aprende lo básico");
            System.out.println("2- Puntaje");
            System.out.println("0- Volver");

            opcion = input.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Se empieza repartiendo 3 cartas de la baraja para cada jugador y poniendo cuatro " +
                            "cartas boca arriba sobre la mesa.");
                    System.out.println("El jugador que empieza (el mano) es el primero en jugar una carta para intentar hacer " +
                            "baza, el jugador siguiente jugará después que haya jugado el primero.");
                    System.out.println("Un jugador juega la carta que más le convenga de entre las que tiene en la mano " +
                            "(inicialmente 3), poniéndola sobre el tapete y tratando de sumar 15 puntos con esta " +
                            "carta y cuantas pueda de las que están en la mesa. Si lo consigue estas cartas se " +
                            "colocarán boca abajo en la mesa, junto al jugador que jugó la carta.");
                    System.out.println("Si se logra sumar 15 puntos con la carta jugada + todas las cartas de la mesa se " +
                            "hace escoba.");
                    break;
                case 2:
                    System.out.println("• Un punto por cada escoba\n" +
                                       "• Un punto al que tiene más cartas.\n" +
                                       "• Un punto al que tiene más oros. \n" +
                                       "• Un punto si tiene el 7 de oros (también llamado 7 de velo).\n" +
                                       "• Un punto si tiene el Rey de oros\n");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("¡Opción inválida!");
                    opcion = 1;
                    break;
            }
        }while(opcion != 0);

    }

}
