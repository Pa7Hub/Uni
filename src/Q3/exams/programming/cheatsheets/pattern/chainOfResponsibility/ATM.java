package Q3.exams.programming.cheatsheets.pattern.chainOfResponsibility;

/**
 * This is the class that builds our "Chain".
 */

/*
    IMPORTANT die Klasse ist etwas hacky geschrieben, es macht aber nix anderes, als eine Chain zu definieren und über eine withdraw() Funktion auf diese zuzugreifen.
 */
public class ATM {
    private static Splitter hundredSplitter = new HundredSplitter();
    private static Splitter fiftySplitter = new FiftySplitter();
    private static Splitter twentySplitter = new TwentySplitter();
    private static Splitter tenSplitter = new TenSplitter();
    private static Splitter splitterChain;
    static {
        hundredSplitter.setNextSplitter(fiftySplitter);
        fiftySplitter.setNextSplitter(twentySplitter);
        twentySplitter.setNextSplitter(tenSplitter);
        splitterChain = hundredSplitter;
    }

    /*
        Die Chain kann auch anders gebaut werden, wenn man dies möchte. Hier zeigt sich, dass jeder Splitter nur seinen nächsten Splitter kennt.
        Kommt jetzt also über withdraw(120) eine Anfrage rein, so wird diese erst an den HundredSplitter gegeben, der berechnet seinen Kram,
        hat einen rest von 20 und gibt den über dispense(20) an den nächsten FiftySplitter. Der kann damit nichts anfangen, gibt es also an
        twentySplitter, der die Berechnung dann beendet.
        tenSplitter ist der letzte Splitter in der Chain und sollte demnach eine "Abfang" Methode haben, die ggf. eine Exception wirft, wenn ein
        falscher Rest übrig bleibt.
     */

    public static void withdraw(Currency currency) {
        splitterChain.dispense(currency);
    }

}
