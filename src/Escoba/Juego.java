package Escoba;

import java.util.Scanner;

public class Juego {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion = 1;
        do {
            System.out.println("*** Bienvenido a la Escoba del 15 ***");
            System.out.println("Seleccione una opción");
            System.out.println("1- Jugar");
            System.out.println("2- Ver puntajes");

            opcion = input.nextInt();

            switch(opcion) {
                case 1:

                    Jugador jugador1 = new Jugador("Jugador1"); //Jugadores se crean fuera de la ronda para poder reutilizarlos en varias rondas
                    Jugador jugador2 = new Jugador("Jugador2");
                    int puntosJuegoJ1 = 0;
                    int puntosJuegoJ2 = 0;


                    while(puntosJuegoJ1 < 21 && puntosJuegoJ2 < 21) {
                        Ronda ronda = new Ronda(jugador1, jugador2);
                        ronda.setupInicial();

                        while (ronda.getMazo().quedanCartas()) {

                            ronda.repartirJugadores();
                            System.out.println("Repartir");
                            for (int i = 0; i < 6; i++) {
                                ronda.Turno();
                            }
                        }
                        ronda.calcularPuntos();

                        jugador1.limpiar();
                        jugador2.limpiar();

                    }
                    break;

                case 2:

                    break;

                default:
                    System.out.println("Opción inválida, intente nuevamente.");
                    opcion = 1;
                    continue;
            }
        }
        while(opcion != 0);
    }

}
