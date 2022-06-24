package Q3.exams.programming.cheatsheets.pattern.visitor;

/**
 * Objekt, welches von einem Visitor besucht werden kann. Mit accept() wird die visit() Methode des Visitor gecalled und dabei das
 * zu besuchende Objekt mitgegeben. Dadurch hat der Visitor vollen Zugriff auf das Objekt.
 */
public interface IToBeVisited {
    void accept(IVisitor v);
}
