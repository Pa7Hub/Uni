package Q3.exams.programming.cheatsheets.pattern.visitor;

public class Visitor1 implements IVisitor {
    @Override
    public void visit(ToBeVisited1 vis) {
        // do something exclusive to ToBeVisited1
        System.out.println(vis.visited1Exclusive());
    }

    @Override
    public void visit(ToBeVisited2 vis) {
        // do something exclusive to ToBeVisited2
        System.out.println(vis.visited2Exclusive());
    }
}
