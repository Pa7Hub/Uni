package Q3.programming.hue9.h34.src;

public class SimpleAutomata {
    private final State _state = new State(0);

    /**
     *
     * @param word String to be inserted into the Automata and checked for validity
     * @return boolean, true IFF the whole word was accepted by the automata
     * method acceptSymbol() will throw ErrorStateException if character of entry parameter 'word' causes illegal state transitions
     *
     * FIXME: This is not state pattern. State pattern would be invoking a singular state, discarding it and then using a new one. Here I instead use a singular state at all times. So its wrong, duh.
     * FIXME: It is however possible to do it with pure state pattern, just make sure to remember the last state we were in.
     */
    public boolean acceptWord(String word) {
        boolean finalState = false;
        for (char c : word.toCharArray()) {
            try {
                finalState = _state.acceptSymbol(c);
            } catch (ErrorStateException e) {
                e.printStackTrace();
            }
        }
        return finalState;
    }

    public void setState(int state) throws IllegalStateAssignmentException {
        _state.setNewState(state);
    }

}
