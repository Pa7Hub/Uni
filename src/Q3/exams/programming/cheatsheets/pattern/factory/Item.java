package Q3.exams.programming.cheatsheets.pattern.factory;

public abstract class Item {
    protected Double _price;
    public Item(Double price) {
        this._price = price;
    }

    Double getPriceString() {
        return this._price;
    }
}
