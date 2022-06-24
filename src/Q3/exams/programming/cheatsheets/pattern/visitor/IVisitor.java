package Q3.exams.programming.cheatsheets.pattern.visitor;

/**
 * Visitor, der dann die entsprechenden Objekte besucht.
 */
public interface IVisitor {
    void visit(ToBeVisited1 vis);
    void visit(ToBeVisited2 vis);
}
