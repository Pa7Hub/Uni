package Q3.programming.hue12.h50.areas;

import Q3.programming.hue12.h50.visitor.IVisitor;

public abstract class Area {
    String _boothName;
    Integer _boothNumber; // FIXME  not an Integer, as in the task it says "C47"
    Integer _nextPossibleBooth = 1;

    public Area(String name) {
        _boothName = name;
        _boothNumber = _nextPossibleBooth;
        _nextPossibleBooth++;
    }

    public Integer getBoothNumber() {
        return _boothNumber;
    }

    public String getBoothName() {
        return _boothName;
    }

    public abstract void accept(IVisitor<?> ehv);
}
