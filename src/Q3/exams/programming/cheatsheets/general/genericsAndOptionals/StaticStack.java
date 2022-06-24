package Q3.exams.programming.cheatsheets.general.genericsAndOptionals;

import java.util.ArrayList;
import java.util.List;

/**
 * Stack that is only able to hold Integer elements
 */
public class StaticStack {
    private List<Integer> _contents;

    public StaticStack() {
        _contents = new ArrayList<Integer>();
    }

    /**
     * Removes and returns the current top element of the Stack
     */
    public Integer pop() {
        return this._contents.remove(0);
    }

    /**
     * Puts a new element on top of the Stack
     * @param element new Integer to be pushed to the Stack
     */
    public void push(Integer element) {
        this._contents.add(element);
    }

    /**
     * Returns current top element of the Stack
     */
    public Integer peek() {
        return this._contents.get(0);
    }
}
