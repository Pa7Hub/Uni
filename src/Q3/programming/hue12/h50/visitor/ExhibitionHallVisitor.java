package Q3.programming.hue12.h50.visitor;

import Q3.programming.hue12.h50.StringListPair;
import Q3.programming.hue12.h50.areas.Area;
import Q3.programming.hue12.h50.areas.Booth;
import Q3.programming.hue12.h50.areas.Gastronomy;
import Q3.programming.hue12.h50.areas.PresentationArea;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ExhibitionHallVisitor implements IVisitor<StringListPair> {
    StringListPair _allVisitedAreas;
    Function<Area, String> defaultFunc = a -> String.format("%nu: %na", a.getBoothNumber(), a.getBoothName());
    Optional<Function<Area, String>> formatFood;
    Optional<Function<Area, String>> formatNonFood;

    public ExhibitionHallVisitor() {
        // List1: Areas, List2: Gastronomy
        _allVisitedAreas = new StringListPair();
        formatFood = Optional.empty();
        formatNonFood = Optional.empty();
    }

    public ExhibitionHallVisitor(Function<Area, String> format) {
        // List1: Areas, List2: Gastronomy
        _allVisitedAreas = new StringListPair();
        formatFood = Optional.ofNullable(format);
        formatNonFood = Optional.ofNullable(format);
    }

    public ExhibitionHallVisitor(Function<Area, String> format, Function<Area, String> formatNF) {
        // List1: Areas, List2: Gastronomy
        _allVisitedAreas = new StringListPair();
        formatFood = Optional.ofNullable(format);
        formatNonFood = Optional.ofNullable(formatNF);
    }

    @Override
    public void handle(Booth booth) {
        if (this.formatNonFood.isPresent()) {
            _allVisitedAreas.addToList2(this.formatNonFood.get().apply(booth));
        } else {
            _allVisitedAreas.addToList2(this.defaultFunc.apply(booth));
        }
    }

    @Override
    public void handle(Gastronomy gastronomy) {
        if (this.formatFood.isPresent()) {
            _allVisitedAreas.addToList2(this.formatFood.get().apply(gastronomy));
        } else {
            _allVisitedAreas.addToList2(this.defaultFunc.apply(gastronomy));
        }
    }

    @Override
    public void handle(PresentationArea presentationArea) {
        if (this.formatNonFood.isPresent()) {
            _allVisitedAreas.addToList2(this.formatNonFood.get().apply(presentationArea));
        } else {
            _allVisitedAreas.addToList2(this.defaultFunc.apply(presentationArea));
        }
    }

    @Override
    public StringListPair getEstablishedData() {
        return _allVisitedAreas;
    }

    public List<String> getVisitedAreas() {
        return _allVisitedAreas.getList1();
    }

    public List<String> getVisitedGastronomy() {
        return _allVisitedAreas.getList2();
    }
}