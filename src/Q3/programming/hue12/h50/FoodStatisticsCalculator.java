package Q3.programming.hue12.h50;

import Q3.programming.hue12.h50.areas.Gastronomy;

import java.util.HashMap;
import java.util.Map;

/**
 * All these functions have been moved to the new ExhibitionHallController
 */
@Deprecated
public class FoodStatisticsCalculator {
    Map<Gastronomy, Double> _prices;
    Double _lowestPrice = 0.0;
    Double _highestPrice = 0.0;
    Double _average = 0.0;
    Integer _amountOfOffers = 0;

    public FoodStatisticsCalculator(Map<Gastronomy, Double> prices) {
        _prices = prices;
    }

    public Map<Gastronomy, Double> min() {
        Map<Gastronomy, Double> minimum = new HashMap<>();

        _prices.forEach((gastronomy, price) -> {
            if (minimum.size() == 0) {
                minimum.put(gastronomy, price);
                _lowestPrice = price;
            } else {
                if (price < _lowestPrice) {
                    minimum.clear();
                    minimum.put(gastronomy, price);
                    _lowestPrice = price;
                }
            }
        });
        return minimum;
    }

    public Map<Gastronomy, Double> max() {
        Map<Gastronomy, Double> maximum = new HashMap<>();

        _prices.forEach((gastronomy, price) -> {
            if (maximum.size() == 0) {
                maximum.put(gastronomy, price);
                _highestPrice = price;
            } else {
                if (price > _highestPrice) {
                    maximum.clear();
                    maximum.put(gastronomy, price);
                    _highestPrice = price;
                }
            }
        });
        return maximum;
    }

    public Integer amountOfOffers() {
        _prices.forEach((g, p) -> _amountOfOffers++);
        return _amountOfOffers;
    }

    public Double average() {
        _prices.forEach((g, p) -> _average += p);
        return _average / amountOfOffers();
    }

}
