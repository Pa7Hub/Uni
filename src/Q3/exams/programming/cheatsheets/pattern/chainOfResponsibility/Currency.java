package Q3.exams.programming.cheatsheets.pattern.chainOfResponsibility;

public class Currency {
    private Integer _amount;

    public Currency(Integer amount) {
        this._amount = amount;
    }

    public Integer getAmount() {
        return this._amount;
    }

    public void setAmount(Integer newAmount) {
        this._amount = newAmount;
    }
}
