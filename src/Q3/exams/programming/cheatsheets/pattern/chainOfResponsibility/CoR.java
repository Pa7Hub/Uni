package Q3.exams.programming.cheatsheets.pattern.chainOfResponsibility;

/**
 * Wenn ein Request getätigt wird, dann wollen wir verhindern, eine genaue Verbindung zwischen Request und Handler zu erstellen.
 * Wenn wir 50 unterschiedliche Requests haben, dann müssten wir für jede einzelne davon einen genauen Handler verknüpfen.
 * Für die Chain of Responsibility wird ein Request ausgeführt, der dann einfach von Handler zu Handler gegeben wird, bis ihn
 * einer nutzen kann. Dadurch müssen wir keine genaue Verbindung zwischen Request und Handler erstellen, sondern einfach der Chain einen
 * Handler hinzufügen, der die Request akzeptieren kann. Die Request wird dann abgeschickt mit der Absicht "irgendwer wird das schon annehmen"
 *
 * Jeder Handler hat eine Referenz zum "Head" der Chain und den nächsten Handler. Für unbehandelte Requests muss ein "Catch" aufgestellt werden,
 * der diese abfängt. Wenn bekannt ist, welcher Request von welchem Objekt behandelt werden soll und ein Zeitverlust wegen "Durchreichen
 * über die Kette" unerwünscht ist, dann sollte man die Chain of Responsibility nicht nutzen.
 */
public class CoR {
    public static void main(String[] args) {
        Integer amount = 580;
        ATM.withdraw(new Currency(amount));
    }
}
