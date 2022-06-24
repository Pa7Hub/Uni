package Q3.exams.programming.cheatsheets.pattern.abstractFactory;

public abstract class Food {
    private final String _name;

    public Food(String name) {
        _name = name;
    }

    public String getName() {
        return this._name;
    }
}
