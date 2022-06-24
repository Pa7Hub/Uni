package Q3.programming.hue13;

import Q3.programming.hue12.h50.ExhibitionHall;
import Q3.programming.hue12.h50.areas.Area;
import Q3.programming.hue12.h50.areas.Booth;
import Q3.programming.hue12.h50.areas.Gastronomy;
import Q3.programming.hue12.h50.areas.PresentationArea;
import Q3.programming.hue12.h50.food.Food;
import Q3.programming.hue12.h50.people.Person;
import Q3.programming.hue12.h50.topics.Topic;
import Q3.programming.hue12.h50.visitor.FoodVisitor;
import Q3.programming.hue12.h50.visitor.IVisitor;
import Q3.programming.hue13.exceptions.ExhibitionHallUninitializedException;
import Q3.programming.hue13.exceptions.VisitorUninitializedException;
import Q3.programming.hue13.operations.Calculations.*;
import Q3.programming.hue13.operations.Search.ASearch;

import java.util.*;

// NOT TESTED YET

/**
 * Controller that handles all operations possible for the Exhibition hall.
 * This is a handier way of doing all these different operations all over the place and allocate them all in one class instead.
 * Its debatable if this is really as handy as I expected it to be.
 * TODO Currently all operations are moderated over Operations Objects. If we pass the operations as Strings we would have to check for all kinds of possible Strings.
 *  With the Operation type we can ensure that we have no invalid Operation Inputs, however you always have to initialize a new Operations Object for that, and they're kind of just littering around.
 *  This works well in JS but maybe not as much in Java. Re-think this whole Controller.
 */
public class ExhibitionHallController {
    Optional<IVisitor<?>> _currentVisitor;
    Optional<ExhibitionHall> _currentHall;

    public ExhibitionHallController() {
        // ???
    }

    public ExhibitionHallController(ExhibitionHall exhibitionHall) {
        _currentHall = Optional.ofNullable(exhibitionHall);
    }

    public void setCurrentExhibitionHall(ExhibitionHall exhibitionHall) {
        _currentHall = Optional.ofNullable(exhibitionHall);
    }

    public boolean exhibitionHallInitialized() {
        return _currentHall.isPresent();
    }

    public void clearExhibitionHall() {
        _currentHall = Optional.empty();
    }

    public boolean visitorInitialized() {
        return _currentVisitor.isPresent();
    }

    public void clearVisitor() {
        _currentVisitor = Optional.empty();
    }

    /**
     * @param operation Operation determining the search operation. Each ASearch object has a distinct searchTerm to search for.
     * @return List of all people related to search input
     * @throws ExhibitionHallUninitializedException if no Exhibition Hall has been initialized when calling method
     * operation could also be passed as string but we'd have to check for too much for that to work
     */
    // FIXME somehow throws warning for "unused return value" which apparently is a semi-bug according to SO. Could be suppressed, look into it again tho
    public List<Person> expertSearcher(ASearch<?> operation) throws ExhibitionHallUninitializedException {
        if (!this.exhibitionHallInitialized()) {
            throw new ExhibitionHallUninitializedException("Cannot use method 'expertSearch' with uninitialized ExhibitionHall in Controller!");
        }
        List<Area> areas = this._currentHall.get().getAreas();
        return searchForExperts(operation.getSearchTerm(), areas);
    }

    /**
     * Function that can clear- or unclear search for a given input. Operation type in expertSearcher determines Search operation.
     *
     * @param input either of type Topic or String; input to search for.
     * @param areas all current areas in Exhibition Hall.
     * @return List of all Persons related to the searched input.
     */
    private List<Person> searchForExperts(Object input, List<Area> areas) {
        List<Person> responsiblePeople = new ArrayList<>();
        // Clear Search
        if (input instanceof Topic) {
            Topic topic = (Topic) input;
            areas.forEach(a -> {
                if (a instanceof Booth && ((Booth) a).getTopic() == topic) {
                    responsiblePeople.addAll(((Booth) a).getPersonal());
                } else if (a instanceof PresentationArea) {
                    ((PresentationArea) a).getPresentations().forEach((p, t) -> {
                        if (t == topic) {
                            responsiblePeople.add(p);
                        }
                    });
                }
            });
            // Unclear Search
        } else if (input instanceof String) {
            // TODO doesn't account for empty string
            String unclearTopic = (String) input;
            areas.forEach(a -> {
//             FIXME this double getTopic() isn't really good syntax
                if (a instanceof Booth && ((Booth) a).getTopic().getTopic().contains(unclearTopic)) {
                    responsiblePeople.addAll(((Booth) a).getPersonal());
                } else if (a instanceof PresentationArea) {
                    ((PresentationArea) a).getPresentations().forEach((p, t) -> {
                        if (t.getTopic().contains(unclearTopic)) {
                            responsiblePeople.add(p);
                        }
                    });
                }
            });
        }
        return responsiblePeople;
    }

    /**
     * Calculator that can give certain statistics for the data of a FoodVisitor for a given food.
     * @param operation what to calculate and return for the given food
     * @param food food to operate with
     * @return {
     *      null iff food hasn't been found in list;
     *      Map(Gastronomy,Double) for Operation instanceof Max || Min; We return it as a Map to see exactly what Gastronomy has the cheapest/highest price.
     *      Integer for Operation instanceof AmountOfOffers;
     *      Double for Operation instanceof Average;
     * }
     * @throws VisitorUninitializedException iff the Visitor is not of type FoodVisitor or has not been initialized.
     */
    public Object foodStatisticsCalculations(ACalculation<?> operation, Food food) throws VisitorUninitializedException {
        if (!visitorInitialized() || !(this._currentVisitor.get() instanceof FoodVisitor)) {
            throw new VisitorUninitializedException("Cannot start Food Calculations for non-existent or non-Food Visitor!");
        }
        Map<Food, Map<Gastronomy, Double>> foodList = ((FoodVisitor) this._currentVisitor.get())
                .getEstablishedData();
        if (!foodList.containsKey(food)) {
            System.err.println("Specified food has not been found on list of FoodVisitors visited Gastronomies");
            return null;
        }
        Map<Gastronomy, Double> prices = foodList.get(food);

        // alternative: every object has its own calculate() function that does all these operations.
        // But whats the point of the controller then :D
        if (operation instanceof Min) {
            return min(prices);
        } else if (operation instanceof Max) {
            return max(prices);
        } else if (operation instanceof AmountOfOffers) {
            return average(prices);
        } else if (operation instanceof Average) {
            return amountOfOffers(prices);
        } else {
            System.err.println("Somehow managed to pass wrong operation type?!");
            return null;
        }
    }

    private Map<Gastronomy, Double> min(Map<Gastronomy, Double> prices) {
        Map<Gastronomy, Double> minimum = new HashMap<>();
        Double lowestPrice = 0.0;

        prices.forEach((gastronomy, price) -> {
            if (minimum.size() == 0) {
                minimum.put(gastronomy, price);
            } else {
                // iterator().next() will always return the correct element, as theres only 1 in the Map
                if (price < (minimum).values().iterator().next()) {
                    minimum.clear();
                    minimum.put(gastronomy, price);
                }
            }
        });
        return minimum;
    }

    private Map<Gastronomy, Double> max(Map<Gastronomy, Double> prices) {
        Map<Gastronomy, Double> maximum = new HashMap<>();

        prices.forEach((gastronomy, price) -> {
            if (maximum.size() == 0) {
                maximum.put(gastronomy, price);
            } else {
                if (price > (maximum).values().iterator().next()) {
                    maximum.clear();
                    maximum.put(gastronomy, price);
                }
            }
        });
        return maximum;
    }
    private Double average(Map<Gastronomy, Double> prices) {
        Double average = 0.0;
        for (Map.Entry<Gastronomy, Double> gp : prices.entrySet()) {
            average += gp.getValue();
        }
        return average / this.amountOfOffers(prices);
    }

    private Integer amountOfOffers(Map<Gastronomy, Double> prices) {
        Integer amountOfOffers = 0;
        for (Map.Entry<Gastronomy, Double> gp : prices.entrySet()) {
            amountOfOffers++;
        }
        return amountOfOffers;
    }

}
