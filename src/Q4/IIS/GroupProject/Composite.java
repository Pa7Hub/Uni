package Q4.IIS.GroupProject;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private List<Component> _components;

    public List<Component> getComponents() {
        return this._components;
    }

    public Composite(String name) {
        super(name, "Composite");
        this._components = new ArrayList<>();
    }

    public void addToList(Component component) {
        component.addParent(this);
        this._components.add(component);
    }

    public List<Component> getList() {
        return this._components;
    }

    // Will return true if this component is the root of a given tree
    public Boolean isRoot() {
        return this.getParent().isPresent();
    }

    /**
     * Will add a singular element to each layer until layer n is reached
     * This is useful for creating bloated trees for tests
     * @param depth
     */
    public void addElementsToNDepth(int depth) {
        ComponentFactory f = new ComponentFactory();
        CompositeFactory cf = (CompositeFactory) f.createFactory(Operation.COMPOSITE);
        Composite currentElement = this;
        int i;
        for (i = 0; i <= depth; i++) {
            Composite c = cf.create(String.valueOf(i + 2));
            currentElement.addToList(c);
            currentElement = c;
        }
    }
}
