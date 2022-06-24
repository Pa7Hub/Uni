package Q3.programming.hue8.src;

public class BaugruppenScanner {

    public double berechnePreis(IBaugruppe baugruppe) {
        if (baugruppe instanceof Elementar) {
            return ((Elementar) baugruppe).getPreis();
        } else {
            double preis = 0;
            for (Elementar b : ((Zusammengesetzt) baugruppe).getBauteilListe()) {
                preis += b.getPreis();
            }
            if (((Zusammengesetzt) baugruppe).getHerstellerListe().size() == 1) {
                System.out.println(" Rabatt erkannt! ");
                return preis - (preis / 10);
            } else {
                System.out.println(" Kein Rabatt erkannt! ");
                return preis;
            }
        }
    }

}
