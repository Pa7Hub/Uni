package Q3.programming.hue12.h50.areas;

import Q3.programming.hue12.h50.people.Person;
import Q3.programming.hue12.h50.topics.Topic;
import Q3.programming.hue12.h50.visitor.IVisitor;

import java.util.HashMap;
import java.util.Map;

public class PresentationArea extends Area {
    Map<Person, Topic> _presentations;

    public PresentationArea(String name) {
        super(name);
        _presentations = new HashMap<>();
    }

    @Override
    public void accept(IVisitor<?> ehv) {
        ehv.handle(this);
    }

    public void addPresentation(Person person, Topic topic) {
        _presentations.put(person, topic);
    }

    public Topic getPresentationTopic(Person person) {
        return _presentations.get(person);
    }

    public Map<Person, Topic> getPresentations() {
        return _presentations;
    }

}
