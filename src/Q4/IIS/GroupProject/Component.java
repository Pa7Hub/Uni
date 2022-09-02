package Q4.IIS.GroupProject;

import java.util.Optional;

public abstract class Component {
    private String _name;
    private String _type;
    private Integer _depth;
    private Optional<Component> _parent;

    public Component(String name, String type) {
        this._name = name;
        this._type = type;
    }

    public String getName() {
        return this._name;
    }

    public void addParent(Component parent) {
        this._parent = Optional.of(parent);
    }

    public void addDepth(Integer depth) {
        this._depth = depth;
    }

    public Integer getDepth() {
        return this._depth;
    }

    public Optional<Component> getParent() {
        return this._parent;
    }

    public String getType() {
        return this._type;
    }
}
