package Q3.programming.hue13.operations.tests;

import Q3.programming.hue12.h50.topics.Topic;
import Q3.programming.hue13.ExhibitionHallController;
import Q3.programming.hue13.operations.Search.Search;
import Q3.programming.hue13.operations.Search.UnclearSearch;
import org.junit.jupiter.api.Test;

public class OperationsTests {

    @Test
    void SearchTest() {
        Topic topic = new Topic("Cool topic");
        Search search = new Search(topic);
        UnclearSearch unclearSearch = new UnclearSearch("Cool");
        ExhibitionHallController controller = new ExhibitionHallController();
        try {
            controller.expertSearcher(search);
        } catch (Exception e) {
            // will throw error without exhibition hall
            e.printStackTrace();
        }
    }

}
