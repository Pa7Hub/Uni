package Q3.programming.hue8.src;

public class Elementar implements IBaugruppe {
    private int _nummer;
    private String _name;
    private double _preis;
    private Hersteller _hersteller;

    public Elementar(int nummer, String name, double preis, Hersteller hersteller) {
        _nummer = nummer;
        _name = name;
        _preis = preis;
        _hersteller = hersteller;
    }

    public void setNummer(int num) {
        this._nummer = num;
    }

    public int getNummer() {
        return _nummer;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getName() {
        return _name;
    }

    public void setPreis(double preis) {
        this._preis = preis;
    }

    @Override
    public double getPreis() {
        return _preis;
    }

    public void setHersteller(Hersteller hersteller) {
        this._hersteller = hersteller;
    }

    public Hersteller getHersteller() {
        return _hersteller;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Elementar) {
            Elementar a = (Elementar) o;
            return a.getPreis() == this.getPreis()
                    && a.getHersteller() == this.getHersteller()
                    && a.getName() == this.getName()
                    && a.getNummer() == this.getNummer();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Nummer: " + this.getNummer()
                + ", Name: " + this.getName()
                + ", Hersteller: " + this.getHersteller().toString()
                + ", Preis: " + this.getPreis();
    }

}
