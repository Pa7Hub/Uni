package Q3.exams.programming.cheatsheets.pattern.factory;

/**
 * Bei dem Factory Pattern wird ein abstraktes Objekt (Item) definiert. Daraus werden dann weitere Subobjekte erstellt (Item1...Item3)
 * In einer Generator Klasse kann dann über Eingabe ein neues Objekt erstellt werden. Wir erstellen also die Subobjekte nicht selbst, sondern fordern
 * den Generator dazu auf, uns ein neues zu erstellen und übergeben.
 */
public class Example {
    public static void main(String[] args) {
        ItemGenerator generator = new ItemGenerator();
        Item item = generator.createItem(2);
        System.out.println("The price of the item is: " + item.getPriceString());
    }
}
