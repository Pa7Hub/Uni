package Q3.programming.hue12.h50.people;

import java.util.Objects;

public class Person {
    String _name;

    public Person(String name) {
        _name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(_name, person._name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_name);
    }

    public void setName(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }
}
