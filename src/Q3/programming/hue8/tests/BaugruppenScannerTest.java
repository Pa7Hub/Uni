package Q3.programming.hue8.tests;

import Q3.programming.hue8.src.BaugruppenScanner;
import Q3.programming.hue8.src.Elementar;
import Q3.programming.hue8.src.Hersteller;
import Q3.programming.hue8.src.Zusammengesetzt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaugruppenScannerTest {
    public Hersteller hersteller1 = new Hersteller("Building Logistics", "logBuilding@builders.com");
    public Hersteller hersteller2 = new Hersteller("Tools Logistics", "logTools@builders.com");
    public Elementar bauteil1 = new Elementar(1, "Tischbein", 0.80, hersteller1);
    public Elementar bauteil2 = new Elementar(2, "Hammer", 1.20, hersteller1);
    public Elementar bauteil3 = new Elementar(3, "Zange", 1.80, hersteller2);
    public Zusammengesetzt baugruppe1 = new Zusammengesetzt("Tischbeine");
    public Zusammengesetzt baugruppe2 = new Zusammengesetzt("Bauset");

    @Test
    void testBerechnePreis() {
        baugruppe1.addBauteil(bauteil1);
        baugruppe1.addBauteil(bauteil1);
        baugruppe1.addBauteil(bauteil1);
        baugruppe1.addBauteil(bauteil1);
        BaugruppenScanner scanner = new BaugruppenScanner();
        assertEquals(0.80, scanner.berechnePreis(bauteil1));
        assertEquals(2.8800000000000003, scanner.berechnePreis(baugruppe1)); // FIXME: yes this sucks with double :D
    }

    @Test
    void testEquals() {
        assertEquals(true, bauteil1.equals(bauteil1)); // Elementar, true
        assertEquals(false, bauteil1.equals(bauteil2)); // Elementar, false
        assertEquals(true, baugruppe1.equals(baugruppe1)); // Zusammengesetzt, true
        assertEquals(false, baugruppe1.equals(baugruppe2)); // Zusammengesetzt, false
    }

    @Test
    void testToString() {
        baugruppe1.addBauteil(bauteil1);
        baugruppe1.addBauteil(bauteil1);
        baugruppe1.addBauteil(bauteil1);
        baugruppe1.addBauteil(bauteil1);
        assertEquals("Nummer: 1, Name: Tischbein, Hersteller: Building Logistics, logBuilding@builders.com, Preis: 0.8", bauteil1.toString());
        assertEquals("Building Logistics, logBuilding@builders.com", hersteller1.toString());
    }

    @Test
    void testRabatt() {
        baugruppe1.addBauteil(bauteil1);
        baugruppe1.addBauteil(bauteil1);
        baugruppe1.addBauteil(bauteil1);
        baugruppe1.addBauteil(bauteil1);
        baugruppe2.addBauteil(bauteil1);
        baugruppe2.addBauteil(bauteil2);
        baugruppe2.addBauteil(bauteil3);
        BaugruppenScanner scanner = new BaugruppenScanner();
        assertEquals(2.8800000000000003, scanner.berechnePreis(baugruppe1));
        assertEquals(3.80, scanner.berechnePreis(baugruppe2));
    }

}
