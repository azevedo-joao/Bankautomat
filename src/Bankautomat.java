import javax.swing.text.NumberFormatter;
import java.text.DecimalFormat;

/**
 *
 */
public class Bankautomat {

    //TODO vorherige Transaktionen anzeigen lassen
    //TODO Applikation schließen

    private double _saldo;

    public Bankautomat() {
        //TODO Konstruktor
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

            System.out.println("Zahlen Sie bitte ein positiver Betrag ein");
        } else {

            _saldo += betrag;
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
}
