package Q4.IIS.GroupProject;

public class ComponentFactory {

    /** WIll create a new Component Factory based on passed operation type
     * @param operation specifies if LEAF or COMPOSITE Factory shall be created
     * @return new Factory of type LEAF or COMPOSITE
     */
    public ComponentFactory createFactory(Operation operation) {
        if (operation.equals(Operation.LEAF)) {
            return new LeafFactory();
        } else {
            return new CompositeFactory();
        }
    }
}
