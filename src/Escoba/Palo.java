package Escoba;

public enum Palo {
    ORO(1, "Oro"),
    ESPADA(2, "Espada"),
    BASTO(3, "Basto"),
    COPA(4, "Copa");

    private int id;
    private String palo;

    Palo(int id, String palo) {
        this.id = id;
        this.palo = palo;
    }
}
