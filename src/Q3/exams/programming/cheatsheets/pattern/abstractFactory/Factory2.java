package Q3.exams.programming.cheatsheets.pattern.abstractFactory;

/**
 * Produces only Products of group2
 */
public class Factory2 extends AbstractFactory {
    @Override
    public Food createFood() {
        return new FoodGrp2("Food from Group2");
    }

    @Override
    public Drink createDrink() {
        return new DrinkGrp2("Drink from Group2");
    }
}
