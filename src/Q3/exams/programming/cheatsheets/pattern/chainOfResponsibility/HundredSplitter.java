package Q3.exams.programming.cheatsheets.pattern.chainOfResponsibility;

public class HundredSplitter extends Splitter {
    public HundredSplitter() {
        super();
    }

    @Override
    public void dispense(Currency currency) {
        Integer amount = currency.getAmount();
        Integer remainder = amount;
        if (amount >= 100) {
            int count = amount / 100;
            remainder = amount % 100;
            System.out.println("Giving out " + count + " 100€ notes.");
        }
        if (remainder > 0 && this._nextSplitter != null) {
            this._nextSplitter.dispense(new Currency(remainder));
        }
    }
}
