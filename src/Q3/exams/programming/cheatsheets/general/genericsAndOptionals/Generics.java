package Q3.exams.programming.cheatsheets.general.genericsAndOptionals;

public class Generics {
    public static void main(String[] args) {
        /*
            Entsprechend der Implementierung von StaticStack zu sehen ist, dass wir damit nur IntegerStacks erstellen können.
            Möchten mir aber gerne einen Stack für Strings haben, dann können wir das damit nicht machen.
            Und anstatt jetzt für jeden einzelnen Typ einen neuen Stack zu erstellen, können wir den Stack auch einfach Generic schreiben.
            Dadurch können wir einen Stack für ein von uns gewünschten Typ erstellen und nutzen.
         */
        StaticStack statStack = new StaticStack(); // only works with integers
        statStack.push(1);
//      FIXME statStack.push("This wont work");

        /*
            Der Dynamische Stack wäre dann entsprechend:
            !!Jeweilige Übergabe des Typen Integer!!
         */
        DynamicStack<Integer> dynStack = new DynamicStack<Integer>();
        dynStack.push(1); // <= erwartet jetzt einen Integer

        DynamicStack<String> dynStack2 = new DynamicStack<String>();
        dynStack2.push("This will work"); // <= erwartet jetzt einen String

        /*
            Das macht das erstellen von mehreren Klassen mit identischem Body sehr einfach und verhindert, dass man jedes mal den Code duplicaten muss.
            Typparameter T können aber auch für abstrakte Klassen, Interfaces, eigene Methoden und weiteren cases genutzt werden. Probiert es am besten einfach mal aus,
            bisherige Implementationen in Generics umzuwandeln, das zeigt es am besten.
         */

        /*
            IMPORTANT als wichtiges Beispiel hatten wir in der Vorlesung die Funktionsweise von Subtypen. Bspw. Integer, Long, Float und Double Untertypen von Number.
                 List<Integer> intList = new ArrayList<Integer>();
                 List<Number> numList = intList;
             Auf den ersten Blick sieht man da vielleicht nichts falsches dran. Das Problem ist nur, dass über die Referenz numList über push() ein beliebiges Element von Typ Number
             gepushed werden kann. Da wir dabei aber nicht garantieren können, dass das auch ein Integer ist, würde das nicht funktionieren.
             (IntelliJ gibt hier auch direkt einen Error, daher hab ich es jetzt erstmal kommentiert gelassen)
             Wenn er also eine Fangfrage in der Klausur stellt mit dieser Syntax, dann soll man direkt erkennen, dass eine Untertyp Liste nie als Referenz für eine
             Supertyp Liste genutzt werden kann.
         */

        anyFunction(1); // Funktioniert mit Integer
        anyFunction(1.11234123451); // Funktioniert mit Double
        anyFunction(1.121); // Funktioniert mit Float
        anyFunction(9223372036854775807L); // Funktioniert mit Long
        // anyFunction("yadayada"); // Funktioniert nicht mit String


    }

    /**
     * Generic T kann auch über extends eingeschränkt werden.
     */
    public static <T extends Number> T anyFunction(T anySortaNumba) {
        return anySortaNumba;
    }

}
