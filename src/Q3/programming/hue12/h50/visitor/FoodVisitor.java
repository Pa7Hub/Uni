package Q3.programming.hue12.h50.visitor;

import Q3.programming.hue12.h50.areas.Booth;
import Q3.programming.hue12.h50.areas.Gastronomy;
import Q3.programming.hue12.h50.areas.PresentationArea;
import Q3.programming.hue12.h50.food.Food;

import java.util.HashMap;
import java.util.Map;

public class FoodVisitor implements IVisitor<Map<Food, Map<Gastronomy, Double>>> {
    Map<Food, Integer> _food; // food -> amount of times it was found at this Gastronomy
    Map<Food, Map<Gastronomy, Double>> _pricesForFood; // food -> Gastronomy and the Price

    public FoodVisitor() {
        _food = new HashMap<>();
        _pricesForFood = new HashMap<>();
    }

    @Override
    public void handle(Booth booth) {
        // do nothing
    }

    // TODO these functions have to be remade, as the Visitor itself is only supposed to collect these things, not calculated them!
    @Override
    public void handle(Gastronomy gastronomy) {
        gastronomy.getMenu().forEach((food, price) -> {
            if (_food.containsKey(food)) {
                _food.put(food, _food.get(food) + 1);
            } else {
                _food.put(food, 1);
            }
            // FIXME this is so messy :D
            Map<Gastronomy, Double> pricesAtGastronomy = new HashMap<>();
            if (_pricesForFood.containsKey(food)) {
                pricesAtGastronomy = _pricesForFood.get(food);
                pricesAtGastronomy.put(gastronomy, price);
                _pricesForFood.replace(food, pricesAtGastronomy);
            } else {
                pricesAtGastronomy.put(gastronomy, price);
                _pricesForFood.put(food, pricesAtGastronomy);
            }
        });
    }

    @Override
    public void handle(PresentationArea presentationArea) {
        // do nothing
    }

    @Override
    public Map<Food, Map<Gastronomy, Double>> getEstablishedData() {
        return _pricesForFood;
    }
}

//    public <T> Object getPriceStatistics(Food food, String operation) {
//        if (_food.containsKey(food)) {
//            Map<Gastronomy, Double> prices = _pricesForFood.get(food);
//            FoodStatisticsCalculator calculator = new FoodStatisticsCalculator(prices);
//            printPriceStatistics(calculator, food);
//            switch (operation) {
//                case "min": {
//                    return calculator.min();
//                }
//                case "max": {
//                    return calculator.max();
//                }
//                case "offers": {
//                    return calculator.amountOfOffers();
//                }
//                case "average": {
//                    return calculator.average();
//                }
//                default: {
//                    throw new RuntimeException("Invalid operation!");
//                }
//            }
//        } else {
//            return null;
//        }
//    }

//    private void printPriceStatistics(FoodStatisticsCalculator calculator, Food food) {
//        String foodName = food.getName();
//        Map<Gastronomy, Double> min = calculator.min();
//        Map<Gastronomy, Double> max = calculator.max();
//        Integer amountOfOffers = calculator.amountOfOffers();
//        Double average = calculator.average();
//
//        System.out.println("There were " + amountOfOffers + " offers for food " + foodName + " in total.");
//        //  we have to access the values here with a for loop, as otherwise we would have to know the Gastronomy
//        min.forEach(((gastronomy, price) -> {
//            System.out.println("The lowest price for " + foodName + " is " + price + "€ at Gastronomy " + gastronomy + ".");
//        }
//        ));
//        max.forEach(((gastronomy, price) -> {
//            System.out.println("The highest price for " + foodName + " is " + price + "€ at Gastronomy " + gastronomy + ".");
//        }));
//        System.out.println("The average price for food " + foodName + " was " + average + " .");
//    }


