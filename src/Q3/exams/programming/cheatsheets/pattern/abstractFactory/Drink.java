package Q3.exams.programming.cheatsheets.pattern.abstractFactory;

public abstract class Drink {
    private final String _name;

    public Drink(String name) {
        _name = name;
    }

    public String getName() {
        return this._name;
    }
}
