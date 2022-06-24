package Q3.programming.hue12.h50.food;

import java.util.Objects;

public class Food {
    String _name;

    public Food(String name) {
        _name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(_name, food._name);
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
