package Q4.IIS.GroupProject;

import java.util.List;

public class Composite extends Component {
    private List<Component> _components;

    public List<Component> getComponents() {
        return this._components;
    }

    public void addToList(Component component) {
        component.addParent(this);
        this._components.add(component);
    }

    // Will return true if this component is the root of a given tree
    public Boolean isRoot() {
        return this.getParent().isPresent();
    }
}
