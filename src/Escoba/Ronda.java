package Escoba;

import java.util.ArrayList;
import java.util.Scanner;

public class Ronda {
//    private Mano mano1 = new Mano();
//    private Mano mano2 = new Mano();

    private ArrayList<Carta> listaSeleccionadas = new ArrayList<Carta>();
    private ArrayList<Carta> listaMesa = new ArrayList<Carta>();
    public Mazo getMazo(){
        return mazo;
    }

    private Mazo mazo = new Mazo();

    private Jugador jugador1 = new Jugador("Jugador1");
    private Jugador jugador2 = new Jugador("Jugador2");


    public void setupInicial(){
        repartirJugadores();
        for(int i=0; i<4; i++){
            listaMesa.add(mazo.getCarta());
        }
    }

    public void repartirJugadores(){
        for(int i=0; i<3; i++){
            jugador1.recibirCarta(mazo.getCarta());
            jugador2.recibirCarta(mazo.getCarta());
        }
    }

    public void cambiaTurno() {
        boolean turno = jugador1.getTurno();
        jugador1.setTurno(!turno);
        jugador2.setTurno(turno);
    }

    public void Turno(){
        cambiaTurno();

        if(jugador1.getTurno()){
            System.out.println("Turno Jugador 1");
            System.out.println("Cartas de la mesa:");
            System.out.println(listaMesa.toString());
            System.out.println("Cartas del Jugador 1");
            System.out.println(jugador1.getCartas().toString());
            boolean bool = true;
            while(bool){
                bool = TirarCartas(jugador1);
            }
            System.out.println("--------------------");

        }
        else{
            System.out.println("Turno Jugador 2");
            System.out.println("Cartas de la mesa:");
            System.out.println(listaMesa.toString());
            System.out.println("Cartas del Jugador 2");
            System.out.println(jugador2.getCartas().toString());
            boolean bool = true;
            while(bool){
                bool = TirarCartas(jugador2);
            }
            System.out.println("--------------------");
        }

    }

    public boolean TirarCartas(Jugador jugador){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que carta desea tirar?");
        int cartaTirar = scanner.nextInt();

        if(cartaTirar <= jugador.getCartas().size() && cartaTirar >= 0){
            System.out.println("Elija las cartas a levantar separadas por comas (0 para no levantar)");
            String cartasLevantar = scanner.next();

            if(!cartasLevantar.equals("0")){

                String[] cartas = cartasLevantar.split(",");

                int total = 0;
                for(String carta: cartas){
                    total += listaMesa.get(Integer.parseInt(carta) - 1).getValor();
                }
                total += jugador.getCartas().get(cartaTirar-1).getValor();
                if(total == 15){
                    System.out.println("Levantado con exito");

                    ArrayList<Carta> cartasASacar = new ArrayList<Carta>();
                    for(String carta: cartas) {
                        cartasASacar.add(listaMesa.get(Integer.parseInt(carta) - 1));
                    }

                    ArrayList<Carta> mazoCartas = new ArrayList<Carta>();

                    for(Carta carta: cartasASacar){
                         mazoCartas.add(carta);
                         listaMesa.remove(carta);
                    }
                    mazoCartas.add(jugador.getCartas().get(cartaTirar-1));

                    if(jugador1.getTurno()){
                        jugador1.AcumularCartas(mazoCartas);
                        jugador1.SacarCarta(cartaTirar-1);
                    }
                    else{
                        jugador2.AcumularCartas(mazoCartas);
                        jugador2.SacarCarta(cartaTirar-1);
                    }

                    return false;
                }
                else{
                    System.out.println("Error");
                    return true;
                }

            }
            else{
                listaMesa.add(jugador.getCartas().get(cartaTirar-1));
                if(jugador1.getTurno()){
                    jugador1.SacarCarta(cartaTirar-1);
                }
                else{
                    jugador2.SacarCarta(cartaTirar-1);
                }
                return false;
            }
        }
        return true;
    }


}
