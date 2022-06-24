package Q3.programming.hue12.h50.areas;

import Q3.programming.hue12.h50.food.Food;
import Q3.programming.hue12.h50.visitor.IVisitor;

import java.util.HashMap;
import java.util.Map;

public class Gastronomy extends Area {
    Map<Food, Double> _menu;

    public Gastronomy(String name) {
        super(name);
        _menu = new HashMap<>();
    }

    @Override
    public void accept(IVisitor<?> ehv) {
        ehv.handle(this);
    }

    public void setMenu(Map<Food, Double> menu) {
        _menu = menu;
    }

    public void addFoodToMenu(Food food, Double price) {
        _menu.put(food, price);
    }

    public Map<Food, Double> getMenu() {
        return _menu;
    }


}
