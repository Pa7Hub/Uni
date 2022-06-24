package Q3.programming.hue8.src;

public class Hersteller {
    private String _name;
    private String _email;

    public Hersteller(String name, String email) {
        _name = name;
        _email = email;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getName() {
        return _name;
    }

    public void setEmail(String email) {
        this._email = email;
    }

    public String getEmail() {
        return _email;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Hersteller) {
            Hersteller a = (Hersteller) o;
            return a.getEmail().equals(this.getEmail())
                    && a.getName().equals(this.getName());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return getName() + ", " + getEmail();
    }

}
