package Q3.programming.exams.a5.src;

public class Vermietet extends State {
    private Person _vermieter;
    private Datum _bis;

    public Vermietet(Person fuer, Datum bis) {

    }

    public Person getVermieter() {
        return _vermieter;
    }

    public Datum getBis() {
        return _bis;
    }

}
