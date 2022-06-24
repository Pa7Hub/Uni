package Q3.programming.exams.a5.src;

public class Fahrzeug {
    State _state;

    public void mieten(Person fuer, Datum bis) throws FahrzeugVermietetException {
        if (_state instanceof Vermietet) {
            throw new FahrzeugVermietetException("Fahrzeug aktuell vermietet von " + ((Vermietet) _state).getVermieter() + " bis: " + ((Vermietet) _state).getBis());
        } else {
            _state = new Vermietet(fuer, bis);
        }
    }

    public void zurueckgeben() {
        _state = new Verfuegbar();
    }

}
