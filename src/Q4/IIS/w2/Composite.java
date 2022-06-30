package Q4.IIS.w2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Composite implements Container, Contained {
    List<Contained> _contents;
    Optional<Container> _owner = Optional.empty();

    public Composite() {
        this._contents = new ArrayList<>();
    }

    @Override
    public void addToContents(Contained content) {
        if (content instanceof Composite) {
            if (!this.partOfTree(content, this.getRootOfTree())) {
                _contents.add(content);
                this.addSelfAsOwner(content);
            } else {
                System.out.println("Element is already in tree and may not be added another time!");
            }
        } else {
            if (((Leaf) content).getOwner().isPresent()) {
                System.out.println("Element that you're trying to add is already contained somewhere else in the tree!");
            } else {
                _contents.add(content);
                this.addSelfAsOwner(content);
            }
        }
    }

    public void addToContentsWithoutCheck(Contained content) {
        _contents.add(content);
        this.addSelfAsOwner(content);
    }

    /**
     * @return public for testing
     */
    public Container getRootOfTree() {
        if (this._owner.isPresent()) {
            if (this._owner.get() instanceof Root) {
                return this._owner.get();
            } else if (this._owner.get() instanceof Composite) {
                return ((Composite) this._owner.get()).getRootOfTree();
            }
        }
        return this;
    }

    public boolean partOfTree(Contained content, Container root) {
        for (Contained contained : root.getContents()) {
            if (contained instanceof Leaf) {
                if (contained.equals(content)) return true;
            } else if (contained instanceof Composite) {
                Composite composite = (Composite) contained;
                if (composite.equals(content)) return true;
                if (!composite.getContents().isEmpty()) {
                    if (composite.partOfTree(content, composite)) return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<Contained> getContents() {
        return _contents;
    }

    public void setOwner(Container owner) {
        _owner = Optional.of(owner);
    }

    public Object getOwner() {
        return _owner.get();
    }

    private void addSelfAsOwner(Contained content) {
        content.setOwner(this);
    }
}
