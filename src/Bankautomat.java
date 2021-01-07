
import java.util.Scanner;

/**
 *
 */
public class Bankautomat {

    //TODO vorherige Transaktionen anzeigen lassen
    //TODO Applikation schließen
    //TODO istAuszahlenMoeglich einbauen

    private double _saldo;
    private String _kundenname;
    private String _kontonummer;


    /**
     * Initialisiert ein neues Bankkonto
     *
     * @param name der Kundenname
     * @param kontonummer die Kontonummer
     */
    public Bankautomat(String name, String kontonummer) {

        _kundenname = name;
        _kontonummer = kontonummer;

        zeigeKontodaten();

        start();
    }

    /**
     * Startet das Programm. Läuft solange, bis das Programm vom Nutzer beendet
     * wird.
     */
    public void start() {

        System.out.println("Willkommen in deinem Bankautomat!");
        System.out.println("Wie können wir Ihnen weiter helfen? Drücken Sie bitte die zutreffende Ziffer");
        System.out.println("1: Kontostand anzeigen || 2: Geld einzahlen || 3: Geld auszahlen || 4: Zinsen Berechnen " +
                "|| 5: Session beenden");

        Scanner scanner = new Scanner(System.in);
        int eingabe;

        do {

            eingabe = scanner.nextInt();

            switch(eingabe) {


                case 1:
                    zeigeKontostand();
                    break;

                case 2:
                    double betrag = scanner.nextDouble();
                    zahleEin(betrag);
                    break;

                case 3:
                    betrag = scanner.nextDouble();
                    zahleAus(betrag);
                    break;
            }
        } while(istGueltigeEingabe(eingabe));
    }

    /**
     * Gibt den aktuellen Kontostand auf der Konsole aus.
     */
    public void zeigeKontostand() {

        System.out.printf("Ihr Kontostand beträgt: € %.2f\n", _saldo);
    }

    /**
     * Zahlt Geld auf das Konto ein. Einzuzahlender Betrag muss positiv sein.
     *
     * @param betrag der einzuzahlende Betrag
     */
    public void zahleEin(double betrag) {

        if(betrag <= 0) {

            System.out.println("Geben Sie bitte einen positiven Betrag ein");
        } else {

            _saldo += betrag;
            zeigeKontostand();
        }
    }

    /**
     * Zahlt Geld aus dem Konto aus. Einzuzahlender Betrag muss positiv sein
     *
     * @param betrag der auszuzahlende Betrag
     */
    public void zahleAus(double betrag) {

        if(betrag <= 0) {

            System.out.println("Geben Sie bitte einen positiven Betrag ein");
        } else {

            _saldo -= betrag;
            zeigeKontostand();
        }
    }

    /**
     * TODO Kommentare schreiben
     * @param prozent
     */
    public void berechneJahreszins(int prozent) {

        double zins;
        zins = (_saldo * prozent) / 100;

        System.out.printf("Der Jahreszins auf Ihr Kontostand beträgt: € %.2f\n", zins);
    }

    /**
     * Zeigt Kontodaten (Name, Kontonummer und Saldo) an.
     */
    private void zeigeKontodaten() {

        System.out.println("======================");
        System.out.println("Kunde: " + _kundenname);
        System.out.println("Kontonummer: " + _kontonummer);
        System.out.printf("Saldo: € %.2f\n", _saldo);
        System.out.println("======================");
    }

    private boolean istGueltigeEingabe(int eingabe) {

        return eingabe >= 1 && eingabe <= 5;
    }
}
