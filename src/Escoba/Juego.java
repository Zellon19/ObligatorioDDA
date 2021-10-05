package Escoba;

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
