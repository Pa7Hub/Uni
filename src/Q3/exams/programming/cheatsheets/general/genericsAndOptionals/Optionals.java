package Q3.exams.programming.cheatsheets.general.genericsAndOptionals;

import java.util.Optional;
import java.util.Random;

/**
 * Optionals ist eine gute Lösung für den Umgang mit null.
 * Wenn man die Main Methode runned sieht man, dass die Zahl entweder 5 oder null sein kann.
 * Für die Zahl müssen dann nicht extra 50000 null checks eingefügt werden, sondern wir gehen einfach
 * dauerhaft von einem Optional aus und überprüfen an den richtigen Stellen, ob dort ein Wert present ist.
 * Wirklich wichtig wird das eigentlich erst mit Lambda Ausdrücken und .map() Operationen, weil wir da einfach
 * (wie unten zu sehen) shorthand inline Ausdrücke schreiben können.
 */
public class Optionals {
    public static void main(String[] args) {
        Optional<Integer> num = maybeInitializeNumber();
        num.ifPresent(System.out::println); // shorthand Schreibweise für 'if (num.isPresent()) System.out.println(num.get())'
    }

    public static Optional<Integer> maybeInitializeNumber() {
        // has a 50% chance to initialize the optional obj with a number
        if (new Random().nextInt() % 2  == 0) {
            return Optional.of(5); // erstellt neues Optional Objekt mit Wert 5
        }
        return Optional.empty(); // erstellt neues Optional Objekt mit Wert null
    }
}
