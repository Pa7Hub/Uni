package Q3.programming.hue9.h34.src;

public class State {
    private int _state;
    private final int MAX_STATES_ALLOWED = 2;

    /**
     * Changes state from current to param beginningState
     *
     * @param beginningState
     */
    public State(int beginningState) {
        _state = beginningState;
    }

    /**
     * Checks if provided char c will be accepted by current state and - in turn - move to next state in range
     *
     * @param c character to be checked within current state
     * @return boolean, true IFF char c has been accepted
     * @throws ErrorStateException when char c has not been accepted by current state
     */
    public boolean acceptSymbol(char c) throws ErrorStateException {
        if (c == 'a' && _state == 0) {
            return true;
        } else if (c == 'b' && _state == 0) {
            _state = 1;
            return true;
        } else if (c == 'c' && _state == 1) {
            _state = 2;
            return true;
        } else { // any char other than a, b, c, or wrong state
            throw new ErrorStateException("Entered character [" + c + "] caused illegal state switch from state [" + _state + "]!");
            // FIXME: This isn't good. Right now it either returns true or throws an exception, but never false. NOT GOOD
            // FIXME: Also not good, every correct char will return true. Should maybe be done better? (although its due to the nature of the method)
        }
    }


    /**
     *
     * @param s
     * @throws IllegalStateAssignmentException
     */
    public void setNewState(int s) throws IllegalStateAssignmentException {
        if (s > MAX_STATES_ALLOWED) {
            throw new IllegalStateAssignmentException("State you wanted to create is not within range (" + MAX_STATES_ALLOWED + ") of allowed states for Automata");
        } else {
            _state = s;
        }
    }



}
