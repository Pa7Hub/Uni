package Q3.exams.programming.cheatsheets.pattern.visitor;

public class ToBeVisited2 implements IToBeVisited{
    @Override
    public void accept(IVisitor v) {
        v.visit(this);
    }

    public String visited2Exclusive() {
        return "This is a certified visited2Exclusive";
    }
}
