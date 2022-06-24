package Q3.exams.programming.cheatsheets.general;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Lambda Expressions sind ein einfacher Weg, um Funktionalität auf kleinem Space zu schreiben. Man kann dadurch bspw. einer Methode
 * eine "Funktion" als Parameter reichen, indem man den als Lambda Expression formuliert. Funktionale Interfaces können für die Zuweisung
 * über eine Lambda Expression genutzt werden.
 */
public class LambdaExpressions {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(7);
        nums.add(9);

        // Lambda Expression für in-function calls
        nums.forEach((n) -> {
            System.out.println(n);
        });
        // Man kann das oben noch kürzer schreiben, indem man mit folgender Syntax eine Funktion ruft, die dann automatisch den Parameter nimmt.
        // Es ist nicht nötig, diese Schreibweise zu kennen. Ich kannte sie selbst auch noch nicht. Ist einfach handier.
        nums.forEach(System.out::println);


        // Anstatt die Expression direkt in der forEach zu definieren, können wir sie auch mithilfe eines Functional Interfaces vorbereiten und das dann mitgeben:
        // Man kann das hier auch wieder wie oben in shorthand schreiben, ist aber besser zur Veranschaulichung imo.
        Consumer<Integer> function = (n) -> {
            System.out.println(n);
        };
        nums.forEach(function);

        // Folgender Code definiert eine Lambda Expression und passed diese an eine Methode:
        Function<Integer, Integer> smallFunction = (n) -> {
            return n * 10;
        };
        Integer result = anyFunction(smallFunction);
        System.out.println("The random result is: " + result);

        // IMPORTANT Die Ergebnisse sind nicht (immer) gleich, da beide male eine zufällige Zahl gerolled wird!
        // Das ganze kann auch inline gemacht werden:
        Integer result2 = anyFunction((n) -> {
            return n * 10;
        });
        System.out.println("The random result is also: " + result2);
    }

    /**
     * Rolls a random number between 0 and 10 and applies it to the integer function
     */
    public static Integer anyFunction(Function<Integer, Integer> smallFunction) {
        Integer ranNum = new Random().nextInt(11);
        return smallFunction.apply(ranNum);
    }
}
