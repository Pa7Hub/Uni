package Q3.exams.programming.cheatsheets.pattern.chainOfResponsibility;

public class TwentySplitter extends Splitter {
    public TwentySplitter() {
        super();
    }

    @Override
    public void dispense(Currency currency) {
        Integer amount = currency.getAmount();
        Integer remainder = amount;
        if (amount >= 20) {
            int count = amount / 20;
            remainder = amount % 20;
            System.out.println("Giving out " + count + " 20€ notes.");
        }
        if (remainder > 0 && this._nextSplitter != null) {
            this._nextSplitter.dispense(new Currency(remainder));
        }
    }
}
