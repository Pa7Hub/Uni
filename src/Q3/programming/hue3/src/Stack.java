package Q3.programming.hue3.src;

public interface Stack extends Container {

    /**
     *
     * @return [[boolean]] true iff Stack contains items of Type [[Entry]]
     */
    @Override
    default boolean isEmpty() {
        return false;
    }

    /** removes and returns the element on top of the Stack
     *
     * @return [[Data]] returns the object from top and removes it from the Stack
     */
    @Override
    default Data remove() {
        return null;
    }

    /** adds a new element to the top of a Stack
     *
     * @param d [[Data]] to be pushed to the top of a Stack
     */
    @Override
    default void push(Data d) {

    }

    /**
     *
     * @return [[Data]] returns element that is on top of the Stack
     */
    default Data peek() {
        return null;
    }

}
