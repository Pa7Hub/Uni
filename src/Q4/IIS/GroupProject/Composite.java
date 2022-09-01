package Q4.IIS.GroupProject;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private List<Component> _components;

    public List<Component> getComponents() {
        return this._components;
    }

    public Composite(String name) {
        super(name);
        this._components = new ArrayList<>();
    }

    public void addToList(Component component) {
        component.addParent(this);
        this._components.add(component);
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
        Composite currentElement = this;
        int i;
        for (i = 0; i <= depth; i++) {
            Composite c = (Composite) f.create(Operation.COMPOSITE, "Composite " + i, 0);
            currentElement.addToList(c);
            currentElement = c;
        }
    }
}
