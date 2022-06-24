package Q3.exams.programming.cheatsheets.pattern.chainOfResponsibility;

public class TenSplitter extends Splitter {
    public TenSplitter() {
        super();
    }

    @Override
    public void dispense(Currency currency) {
        Integer amount = currency.getAmount();
        Integer remainder = amount;
        if (amount >= 10) {
            int count = amount / 10;
            remainder = amount % 10;
            System.out.println("Giving out " + count + " 10€ notes.");
        }
        if (remainder > 0 && this._nextSplitter != null) {
            this._nextSplitter.dispense(new Currency(remainder));
        }
    }
}
