package Q3.programming.hue3.tests;

import Q3.programming.hue3.src.Entry;
import Q3.programming.hue3.src.MyStack;
import org.junit.jupiter.api.Test;

class MyStackTest {

    Entry entry = new Entry("Yo");
    Entry entry2 = new Entry("Is this an entry?");
    MyStack stack = new MyStack();

    @Test
    void isEmpty() {
        assert(stack.isEmpty() == true);
    }

    @Test
    void push() {
        assert(stack.isEmpty() == true);
        stack.push(entry);
        assert(stack.isEmpty() == false);
    }

    @Test
    void peek() {
        assert(stack.isEmpty() == true);
        stack.push(entry);
        stack.push(entry2);
        assert(stack.peek() == entry2);
        assert(stack.peek() != entry);
    }

    @Test
    void remove() {
        assert(stack.isEmpty() == true);
        stack.push(entry);
        assert(stack.remove() == entry);
        assert(stack.isEmpty() == true);
    }
}