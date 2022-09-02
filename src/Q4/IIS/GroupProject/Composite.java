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
     * Will add a singular element to each layer until layer n is reached, with m amount of elements per layer
     * For each element per layer it has a 80% chance to generate a Leaf and 20% to generate a Composite
     *      If a Composite happens to be generated, it will also create anywhere from 0 to 10 Leaf or Composites for that Composite
     *      The same rules as above apply to the Composite elements as well
     * This is useful for creating bloated trees for tests
     * @param depth defines how many layers deep shall be created
     * @param perLayer defines how many Component elements shall be created for given layer
     */
    public void addElementsToNDepth(int depth, Integer perLayer) {
        ComponentFactory f = new ComponentFactory();
        CompositeFactory cf = (CompositeFactory) f.createFactory(Operation.COMPOSITE);
        Composite currentElement = this;
        int i;
        for (i = 0; i <= depth; i++) {
            Composite c = cf.create(String.valueOf(i + 2));
            this.addNRandomElementsToComposite(perLayer, i+1, c);
            currentElement.addToList(c);
            currentElement = c;
        }
    }

    public void addNRandomElementsToComposite(Integer amount, Integer depth ,Composite c) {
        ComponentFactory f = new ComponentFactory();
        CompositeFactory cf = (CompositeFactory) f.createFactory(Operation.COMPOSITE);
        LeafFactory lf = (LeafFactory) f.createFactory(Operation.LEAF);
        for (int i = 0; i < amount; i++) {
            if (Math.random() > 0.2) {
                c.addToList(lf.create(depth + ".L" + (i + 1)));
            } else {
                Composite tempComposite = cf.create(depth + ".C" + (i + 2));
                this.addNRandomElementsToComposite((int) (Math.random() * 10), depth+1, tempComposite);
                c.addToList(tempComposite);
            }
        }
    }
}