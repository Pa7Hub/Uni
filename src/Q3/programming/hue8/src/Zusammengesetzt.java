package Q3.programming.hue8.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Zusammengesetzt implements IBaugruppe {
    private List<Elementar> _liste = new ArrayList<>();
    private String _name;
    private Set<Hersteller> _herstellerListe = new HashSet<>();

    public Zusammengesetzt(String name) {
        _name = name;
    }

    public void addBauteil(Elementar bauteil) {
        _liste.add(bauteil);
        _herstellerListe.add(bauteil.getHersteller());
    }

    public List<Elementar> getBauteilListe() {
        return _liste;
    }

    public Set<Hersteller> getHerstellerListe() {
        return _herstellerListe;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    @Override
    public double getPreis() {
        return 0;
    }

    @Override
    public String toString() {
        String str = "";
        System.out.println(" List consists of following components: ");
        for (Elementar e : _liste) {
            str += ("[" + e.toString()) + "], ";
        }
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Zusammengesetzt) {
            Zusammengesetzt a = (Zusammengesetzt) o;
            return a.getName().equals(this.getName())
                    && a.getPreis() == this.getPreis()
                    && a.getBauteilListe().equals(this.getBauteilListe())
                    && a.getHerstellerListe().equals(this.getHerstellerListe());
        } else {
            return false;
        }
    }
}
