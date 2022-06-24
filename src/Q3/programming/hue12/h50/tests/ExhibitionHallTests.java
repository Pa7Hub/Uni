package Q3.programming.hue12.h50.tests;

import Q3.programming.hue12.h50.ExhibitionHall;
import Q3.programming.hue12.h50.areas.Booth;
import Q3.programming.hue12.h50.areas.Gastronomy;
import Q3.programming.hue12.h50.areas.PresentationArea;
import Q3.programming.hue12.h50.food.Food;
import Q3.programming.hue12.h50.people.Person;
import Q3.programming.hue12.h50.topics.Topic;
import Q3.programming.hue12.h50.visitor.ExhibitionHallVisitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Some of the greatest test cases I've ever created
public class ExhibitionHallTests {
    ExhibitionHall _exhibitionHall = new ExhibitionHall();

    Booth _booth1 = new Booth("Math is cool A");
    Booth _booth2 = new Booth("Math is cool B");
    Booth _booth3 = new Booth("Programming is cool");
    Booth _booth4 = new Booth("Sport is fun");

    Gastronomy _gastronomy1 = new Gastronomy("Delicious Food A");
    Gastronomy _gastronomy2 = new Gastronomy("Cafe");
    Gastronomy _gastronomy3 = new Gastronomy("Delicious Food B");
    Gastronomy _gastronomy4 = new Gastronomy("Cheap Food");

    PresentationArea _presentation1 = new PresentationArea("Science A");
    PresentationArea _presentation2 = new PresentationArea("Science B");

    Person _person1 = new Person("Bob Bober");
    Person _person2 = new Person("Tom Tomer");
    Person _person3 = new Person("Pat Pater");
    Person _person4 = new Person("Kim Kimer");
    Person _person5 = new Person("Jon Joner");
    Person _person6 = new Person("Von Voner");
    Person _person7 = new Person("Nop Noper");
    Person _person8 = new Person("Don Doner");

    Map<Food, Double> _menu1;
    Map<Food, Double> _menu2;
    Map<Food, Double> _menu3;
    Map<Food, Double> _menu4;

    Food _food1 = new Food("Chicken");
    Food _food2 = new Food("Soup");
    Food _food3 = new Food("Sandwich");
    Food _food4 = new Food("Cola");
    Food _food5 = new Food("Sparkling Water");
    Food _food6 = new Food("Coffee");
    Food _food7 = new Food("Schnitzel");
    Food _food8 = new Food("Pizza");
    Food _food9 = new Food("Pastry");
    Food _food10 = new Food("Banana");

    @BeforeEach
    void initiateExhibitionHall() {
        _booth1.setTopic(new Topic("Math"));
        List<Person> personal1 = new ArrayList<>();
        personal1.add(_person1);
        personal1.add(_person2);
        personal1.add(_person3);
        _booth1.setPersonal(personal1);

        _booth2.setTopic(new Topic("Physics"));
        List<Person> personal2 = new ArrayList<>();
        personal1.add(_person4);
        personal1.add(_person5);
        personal1.add(_person6);
        _booth2.setPersonal(personal2);

        _booth3.setTopic(new Topic("Programming"));
        List<Person> personal3 = new ArrayList<>();
        personal1.add(_person7);
        personal1.add(_person8);
        _booth3.setPersonal(personal3);

        _booth4.setTopic(new Topic("Sport"));
        List<Person> personal4 = new ArrayList<>();
        personal1.add(_person1);
        personal1.add(_person5);
        personal1.add(_person8);
        _booth4.setPersonal(personal4);

        _menu1.put(_food1, 3.80);
        _menu1.put(_food2, 2.30);
        _menu1.put(_food7, 4.50);
        _menu1.put(_food8, 5.50);
        _menu1.put(_food4, 3.10);
        _menu1.put(_food5, 1.40);
        _gastronomy1.setMenu(_menu1);

        _menu2.put(_food6, 4.40);
        _menu2.put(_food9, 3.80);
        _menu2.put(_food3, 2.50);
        _menu2.put(_food5, 1.60);
        _menu2.put(_food4, 3.30);
        _menu2.put(_food10, 0.80);
        _gastronomy2.setMenu(_menu2);

        _menu3 = _menu1;
        _gastronomy3.setMenu(_menu3);

        _menu4.put(_food1, 1.80);
        _menu4.put(_food2, 0.90);
        _menu4.put(_food7, 2.20);
        _menu4.put(_food8, 3.00);
        _menu4.put(_food3, 1.50);
        _gastronomy4.setMenu(_menu4);

        _presentation1.addPresentation(_person1, new Topic("Math"));
        _presentation1.addPresentation(_person2, new Topic("Math"));
        _presentation1.addPresentation(_person5, new Topic("Programming"));
        _presentation1.addPresentation(_person6, new Topic("Physics"));

        _presentation2.addPresentation(_person3, new Topic("Physics"));
        _presentation2.addPresentation(_person4, new Topic("Physics"));
        _presentation2.addPresentation(_person7, new Topic("Programming"));
        _presentation2.addPresentation(_person8, new Topic("Math"));

        _exhibitionHall.addArea(_booth1);
        _exhibitionHall.addArea(_booth2);
        _exhibitionHall.addArea(_booth3);
        _exhibitionHall.addArea(_booth4);
        _exhibitionHall.addArea(_presentation1);
        _exhibitionHall.addArea(_presentation2);
        _exhibitionHall.addArea(_gastronomy1);
        _exhibitionHall.addArea(_gastronomy2);
        _exhibitionHall.addArea(_gastronomy3);
        _exhibitionHall.addArea(_gastronomy4);
    }

    @Test
    void testSimpleVisitor() {
        ExhibitionHallVisitor visitor = new ExhibitionHallVisitor();
        _exhibitionHall.visitAllAreas(visitor);
    }

    // TODO my motivation and patience ended here
    @Test
    void testPresentationVisitor() {

    }

    @Test
    void testFoodVisitor() {

    }

    @Test
    void testExpertSearcher() {

    }

    @Test
    void testFoodStatisticsCalculator() {

    }

}
