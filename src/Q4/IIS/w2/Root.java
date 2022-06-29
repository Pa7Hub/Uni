package Q4.IIS.w2;

import java.util.ArrayList;
import java.util.List;

public class Root implements Container {
    List<Contained> _contents;

    public Root() {
        this._contents = new ArrayList<>();
    }

    @Override
    public void addToContents(Contained content) {
        // TODO currently doesn't care if you add an already contained element
        this.addSelfAsOwner(content);
        _contents.add(content);
    }

    @Override
    public List<Contained> getContents() {
        return this._contents;
    }

    public void addSelfAsOwner(Contained content) {
        content.setOwner(this);
    }
}
