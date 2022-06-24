package Q3.exams.programming.cheatsheets.pattern.template;

/**
 * Beim Template Pattern wird über eine abstrakte Funtkion ein "Skelett" vorgegeben, von dem dann andere Subklassen erben.
 * Es gibt also einfach nur vor, was diese jeweiligen Methoden machen sollen. Wird üblicherweise für Vermeidung von Duplicate Code genutzt.
 * Egal, wie viele neue Lifter wir hier jetzt hinzufügen, die werden alle mit Aufruf von lift() ihre bestimmte Sache machen. lift() gibt dabei aber
 * eine klare Struktur an. Die Subklassen können nur festlegen, was in den einzelnen Schritten gemacht wird.
 */
public class Example {
    public static void main(String[] args) {
        StrongLifter stronk = new StrongLifter();
        stronk.lift();

        NormalLifter normal = new NormalLifter();
        normal.lift();
    }
}
