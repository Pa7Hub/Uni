package Q3.exams.programming.cheatsheets.general.genericsAndOptionals;

import java.util.List;

/**
 * Es gibt eine noch generellere "Generic" Implementation mit Wildcards '?'.
 * Das ist besser, wenn man es noch genereller schreiben möchte, macht aber auch gerne vieles kaputt und hat seine Grenzen.
 */
public class Wildcards {
    /*
     * IMPORTANT für einzelne Parameter funktioniert das nicht. Man kann die Wildcard nur als Referenz nutzen, nicht tatsächlich als Typ eines Parameters.
     *  Also für
     *      function2(? item)
     *  würde das ganze nicht funktionieren.
     */
    public static <T> void function1(List<T> list) {
        // do something with items of type T
    }

    public static void function2(List<?> list) {
        // do something with items of unknown type
    }

    /*
     * So funktioniert das auch noch. Wenn man die Funktion jetzt aber erweitert, sodass sie auch ein Item erwartet:
     */
    public static <T> void function3(List<T> list, T item) {
        list.add(item); // funktioniert, da beide vom Typ T sind.
    }

    public static void function4(List<?> list, Object item) {
        // list.add(item); // funktioniert nicht, da wir gar nicht wissen, welcher Typ die Liste enthält.
    }

    /*
        Wildcards können über extend auch erweitert werden. Generell sind Wildcards nur dann sinnvoll, wenn man eine kurze Funktion
        Generic typen möchte. Wenn man aber bspw. einen Wert von der Funktion erwartet, dann funktioniert das nicht mehr mit Wildcards, weil es ja ALLES sein könnte.
        Man könnte den Return Typ dann als Object typen, dann hat man aber wirklich garkeine Garantie, was da dann raus kommt. Man sollte das also lieber nur benutzen,
        wenn in einer kleinen Implementierung die Typisierung egal ist, in anderen allen Fällen ist statischen Typiseren aber besser.
     */
}
