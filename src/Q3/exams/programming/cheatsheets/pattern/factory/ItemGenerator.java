package Q3.exams.programming.cheatsheets.pattern.factory;

public class ItemGenerator {
    public Item createItem(Integer item) {
        switch (item) {
            case 1: {
                return new Item1();
            }
            case 2: {
                return new Item2();
            }
            case 3: {
                return new Item3();
            }
            default: {
                return null;
            }
        }
    }
}
