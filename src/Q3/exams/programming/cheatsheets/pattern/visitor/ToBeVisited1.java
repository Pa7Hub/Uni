package Q3.exams.programming.cheatsheets.pattern.visitor;

public class ToBeVisited1 implements IToBeVisited {
    @Override
    public void accept(IVisitor v) {
        v.visit(this);
    }

    public String visited1Exclusive() {
        return "This is a certified visited1Exclusive";
    }
}
