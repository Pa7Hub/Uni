package Q3.exams.programming.cheatsheets.pattern.visitor;

/**
 * Beim Visitor Pattern wird zu einem zu besuchenden Objekt ein Visitor geschickt, der dann akzeptiert wird und auf dem Objekt Operationen ausführen kann.
 * Die zu besuchenden Objekte sind dabei statisch, die Visitor müssen aber für Jede Art von Visitable eine handle() Methode besitzen. Falls dies der Fall ist,
 * so können jegliche Art von Visitor das Objekt besuchen.
 */
public class Example {
    public static void main(String[] args) {
        Visitor1 vis = new Visitor1();
        ToBeVisited1 tbv1 = new ToBeVisited1();
        ToBeVisited2 tbv2 = new ToBeVisited2();

        tbv1.accept(vis);
        // expected output: "This is a certified visited1Exclusive"

        tbv2.accept(vis);
        // expected output: "This is a certified visited2Exclusive"
    }
}
