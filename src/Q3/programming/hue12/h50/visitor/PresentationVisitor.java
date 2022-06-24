package Q3.programming.hue12.h50.visitor;

import Q3.programming.hue12.h50.areas.Booth;
import Q3.programming.hue12.h50.areas.Gastronomy;
import Q3.programming.hue12.h50.areas.PresentationArea;
import Q3.programming.hue12.h50.topics.Topic;

import java.util.Set;

public class PresentationVisitor implements IVisitor<Set<Topic>> {
    Set<Topic> _topics;

    @Override
    public void handle(Booth booth) {
        _topics.add(booth.getTopic());
    }

    @Override
    public void handle(Gastronomy gastronomy) {
        // do nothing
    }

    @Override
    public void handle(PresentationArea presentationArea) {
        _topics.addAll(presentationArea.getPresentations().values());
    }

    @Override
    public Set<Topic> getEstablishedData() {
        return _topics;
    }
}
