package Q3.exams.programming.cheatsheets.pattern.abstractFactory;

public class Example {
    public static void main(String[] args) {
        // Nachdem AbstractFactory implementiert wurde können wir nun eine beliebige Factory erstellen:
        AbstractFactory factory = AbstractFactory.getFactory(1); // factory is now a distinct Factory1 object
        Drink drink = factory.createDrink();
        Food food = factory.createFood();

        System.out.println("Created " + drink.getName() + " with " + food.getName() + "!");

        AbstractFactory factory2 = AbstractFactory.getFactory(2); // factory2 is now a distinct Factory2 object
        Drink drink2 = factory2.createDrink();
        Food food2 = factory2.createFood();

        System.out.println("Created " + drink2.getName() + " with " + food2.getName() + "!");

        /*
        Der Vorteil hier ist, dass wir eine beliebige Factory hinzufügen können und wir dann über die selbe Struktur
        unterschiedliche Produkte von einer Gruppe erstellen können. Wenn man das Prinzip des Factory Patterns
        verstanden hat, dann ist abstract Factory einfach eine Erweiterung.
         */
    }
}
