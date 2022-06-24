package Q3.exams.programming.cheatsheets.pattern.abstractFactory;

/**
 * Produces only Products of group1
 */
public class Factory1 extends AbstractFactory {

    @Override
    public Food createFood() {
        return new FoodGrp1("Food from Group1");
    }

    @Override
    public Drink createDrink() {
        return new DrinkGrp1("Drink from Group1");
    }
}
