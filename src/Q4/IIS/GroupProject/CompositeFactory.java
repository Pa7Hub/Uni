package Q4.IIS.GroupProject;

public class CompositeFactory extends ComponentFactory {

    public Composite create(String name) {
        return new Composite(name);
    }

}
