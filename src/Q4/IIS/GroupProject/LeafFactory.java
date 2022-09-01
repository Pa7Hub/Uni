package Q4.IIS.GroupProject;

public class LeafFactory extends ComponentFactory{

    public Leaf create(String name) {
        return new Leaf(name);
    }
}