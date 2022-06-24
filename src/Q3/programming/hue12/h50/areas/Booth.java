package Q3.programming.hue12.h50.areas;


import Q3.programming.hue12.h50.people.Person;
import Q3.programming.hue12.h50.topics.Topic;
import Q3.programming.hue12.h50.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class Booth extends Area {
    List<Person> _personal;
    Topic _topic;

    public Booth(String name) {
        super(name);
        _personal = new ArrayList<>();
    }

    @Override
    public void accept(IVisitor<?> ehv) {
        ehv.handle(this);
    }

    public Topic getTopic() {
        return _topic;
    }

    public void setTopic(Topic topic) {
        _topic = topic;
    }

    public List<Person> getPersonal() {
        return _personal;
    }

    public void setPersonal(List<Person> personal) {
        _personal = personal;
    }

    public void addPersonToPersonal(Person person) {
        _personal.add(person);
    }
}
