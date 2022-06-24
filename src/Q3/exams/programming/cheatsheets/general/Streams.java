package Q3.exams.programming.cheatsheets.general;

import Q3.exams.programming.cheatsheets.general.genericsAndOptionals.MockPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Streams sind ein "Datenstrom" der einem den Zugriff und die Operation auf Datenmengen deutlich vereinfacht.
 * Das im Skript gezeigte Beispiel ist eigentlich perfekt, um die Funktionsweise zu zeigen, daher hier nochmal aufgeschrieben:
 */
public class Streams {
    private List<MockPerson> _people;

    // Die erste Funktion soll alle Personen in _people auf eine Bedingung filtern
    public List<MockPerson> finder1() {
        List<MockPerson> correctPeople = new ArrayList<>();
        for (MockPerson p : _people) {
            if (p.getLastName().startsWith("S")) correctPeople.add(p);
        }
        return correctPeople;
    }

    // Die zweite Funktion soll alle Personen in _people auf zwei Bedingungen filtern
    public List<MockPerson> finder2() {
        List<MockPerson> correctPeople = new ArrayList<>();
        for (MockPerson p : _people) {
            if (p.getLastName().startsWith("S")) {
                if (p.getFirstName().startsWith("P")) {
                    correctPeople.add(p);
                }
            }
        }
        return correctPeople;
    }

    /*
        Man sieht, dass sich das dann immer mehr verschachtelt und unleserlich wird. Wenn wir jetzt auf 50 Bedingungen
        checken wollen (unrealistisch), dann würden wir 50 Verschachtelungen haben. Nicht cool.
        Wir können daher auch einfach über einen Stream sehr schnell mehrere Dinge ausführen:
     */
    public List<MockPerson> finder3() {
        return this._people.stream()
                .filter(p -> p.getFirstName().startsWith("P"))
                .collect(Collectors.toList());
    }

    public List<MockPerson> finder4() {
        return this._people.stream()
                .filter(p -> p.getLastName().startsWith("S")) // filtert ob die Personen mit S beginnen
                .map(MockPerson::getPartner) // holt für alle gefilterten Personen den Partner
                .filter(Objects::nonNull) // nimmt davon die, die nicht null sind (da Optional)
                .map(Optional::get) // für alle non-null Objekte holt er sich die Werte über Optional.get()
                .filter(partner -> partner.getFirstName().startsWith("I")) // filtert den geholten Partner auf den ersten Buchstaben I
                .collect(Collectors.toList()); // collected alles zusammen
    }

    /*
        Stream Blöcke bestehen immer aus ein oder mehreren Operationen (.filter(), .map(), ...)
        und einer abschließenden Operation (.collect(), findFirst(), ...)

        IMPORTANT der Code wird mit Stream Blöcken gerne mal sehr schnell unübersichtlich! Bei mir auf der Arbeit haben wir die "Regel", dass man unleserliche Blöcke (wie bspw. dem Stream Block)
         Jeweiligs pro Zeile kommentiert, damit Jeder nachvollziehen kann, was da passiert. (Das ist auch nicht nur auf meiner Arbeit so, sondern "common")
         Ansonsten checkt das niemand. Also immer angewöhnen, dass wenn man große Stream Blöcke erstellt, direkt zu kommentieren, was die Zeile da gerade macht.
     */


}