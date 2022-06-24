package Q3.exams.programming.cheatsheets.pattern.abstractFactory;

/**
 * Mit der Abstract Factory werden Factories für jeweilige Families von Produkten erstellt. Wie auch beim Factory Pattern wird eine Factory erstellt,
 * die dann für die Erstellung von unterschiedlichen Produkten eines Typen zuständig ist. Hier ist es aber so, dass wir eine abstrakte Factory haben,
 * die uns eine konkrete Factory für eine Gruppe von Produkten gibt. Es abstrahiert als das bisherige Factory Pattern.
 */
public abstract class AbstractFactory {
    private static final Factory1 _factory1 = new Factory1();
    private static final Factory2 _factory2 = new Factory2();

    public static AbstractFactory getFactory(Integer type) {
        switch (type) {
            case 1: {
                return _factory1;
            }
            case 2: {
                return _factory2;
            }
            default: {
                // This is not an accurate default case. Its better for showing the purpose tho.
//                throw new Exception("Wrong factory type passed");
                return _factory2;
            }
        }
    }

    public abstract Food createFood();
    public abstract Drink createDrink();
}
