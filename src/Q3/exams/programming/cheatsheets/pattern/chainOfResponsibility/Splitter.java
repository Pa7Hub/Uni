package Q3.exams.programming.cheatsheets.pattern.chainOfResponsibility;

public abstract class Splitter {
    protected Splitter _nextSplitter;

    public void setNextSplitter(Splitter splitter) {
        this._nextSplitter = splitter;
    }

    public abstract void dispense(Currency currency);
}
