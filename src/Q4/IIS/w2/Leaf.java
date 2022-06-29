package Q4.IIS.w2;

import java.util.Optional;

public class Leaf implements Contained {
    Optional<Container> _owner;

    @Override
    public void setOwner(Container owner) {
        this._owner = Optional.of(owner);
    }

    public Optional<Container> getOwner() {
        return this._owner;
    }
}
