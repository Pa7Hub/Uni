package Q3.programming.hue3.src;

import java.util.ArrayList;
import java.util.List;

public class MyStack implements Stack {

    private List<Data> stack;

    public MyStack() {
        this.stack = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public Data peek() {
        if (!isEmpty()) {
            return this.stack.get(last()); // To receive the latest element, we have to access the last item of the Arraylist
        } else {
            throw new NullPointerException("Cannot call 'peek' on empty Stack");
        }
    }

    @Override
    public Data remove() {
        if (!isEmpty()) {
            Data lastElement = this.stack.get(last()); // We have to store it, no other way
            this.stack.remove(last());
            return lastElement;
        } else {
            throw new NullPointerException("Cannot call 'remove' on empty Stack");
        }
    }

    @Override
    public void push(Data d) {
        this.stack.add(d);
    }

    /**
     *
     * @return [[int]] returns correct index of last element in a Stack. (Only implemented to shorten code a bit)
     */
    private int last() {
        return this.stack.size() - 1;
    } // -1 to account for correct index

    @Override
    public String toString() {
        String contents = "";

        for (Data d : this.stack) {
            contents += d.getContents() + "\n"; // actually better with StringBuilder but w/e
        }

        return contents;
    }

}
