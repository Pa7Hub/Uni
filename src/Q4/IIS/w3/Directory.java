package Q4.IIS.w3;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Element {
    private List<Element> elements = new ArrayList<>();

    public void add(Element e) {
        // ...
    }

    public void remove(String name) {
        this.elements.removeIf(element -> element.getName().equals(name));
    }

    @Override
    public Integer getSize() {
        Integer size = 0;
        for (Element e : this.elements) {
            size += e.getSize();
        }
        return size;
    }
}
