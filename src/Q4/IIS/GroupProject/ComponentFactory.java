package Q4.IIS.GroupProject;

public class ComponentFactory {

    /** WIll create a new Component Object based on passed operation type
     *
     * @param operation specifies if LEAF or COMPOSITE shall be created
     * @param name specifies the name of the Component that will be created
     * @param size if LEAF object shall be created, specify the size here. Otherwise leave as 0
     * @return new Object of type LEAF or COMPOSITE
     */
    public Component create(Operation operation, String name, Integer size) {
        if (operation.equals(Operation.LEAF)) {
            return new Leaf(size, name);
        } else {
            return new Composite(name);
        }
    }
}
