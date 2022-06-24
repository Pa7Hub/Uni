package Q3.programming.hue12.h50;

import Q3.programming.hue12.h50.areas.Area;
import Q3.programming.hue12.h50.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class ExhibitionHall {
    List<Area> _areas;

    public ExhibitionHall() {
        _areas = new ArrayList<>();
    }

    public void visitAllAreas(IVisitor<?> visitor) {
        _areas.forEach(area -> area.accept(visitor)); // Are we allowed to use this yet :D
    }

    public <T> T visitAllAreasAndGetEstablishedData(IVisitor<T> visitor) {
        _areas.forEach(area -> area.accept(visitor));
        return visitor.getEstablishedData();
    }

    public List<Area> getAreas() {
        return _areas;
    }

    public void addArea(Area area) {
        _areas.add(area);
    }
}
