package Q4.IIS.GroupProject;

import java.util.Optional;

public abstract class Component {
    private String _name;
    private Optional<Component> _parent;

    public Component(String name) {
        this._name = name;
    }

    public String getName() {
        return this._name;
    }

    public void addParent(Component parent) {
        this._parent = Optional.of(parent);
    }

    public Optional<Component> getParent() {
        return this._parent;
    }
}
