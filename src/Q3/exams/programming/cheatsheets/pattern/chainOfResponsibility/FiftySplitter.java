package Q3.exams.programming.cheatsheets.pattern.chainOfResponsibility;

public class FiftySplitter extends Splitter {
    public FiftySplitter() {
        super();
    }

    @Override
    public void dispense(Currency currency) {
        Integer amount = currency.getAmount();
        Integer remainder = amount;
        if (amount >= 50) {
            int count = amount / 50;
            remainder = amount % 50;
            System.out.println("Giving out " + count + " 50€ notes.");
        }
        if (remainder > 0 && this._nextSplitter != null) {
            this._nextSplitter.dispense(new Currency(remainder));
        }
    }
}
