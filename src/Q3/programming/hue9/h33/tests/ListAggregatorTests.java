package Q3.programming.hue9.h33.tests;

import Q3.programming.hue9.h33.src.ListAggregator;
import Q3.programming.hue9.h33.src.ListContainer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListAggregatorTests {

    @Test
    void testAggregator() {
        ListContainer container = new ListContainer();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(5);
        list.add(11);
        list.add(4);
        list.add(28);
        list.add(25);
        list.add(3);
        list.add(7);
        // [1, 3, 4, 5, 7, 11, 25, 28]

        ListAggregator aggregator = new ListAggregator(container.sort(list));

        assertEquals(1, aggregator.min());
        assertEquals(28, aggregator.max());
        assertEquals(84, aggregator.sum());
        assertEquals(10, aggregator.mid());

    }

    @Test
    void testAggregator2() {
        ListContainer container = new ListContainer();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(8);

        ListAggregator aggregator = new ListAggregator(list);

        assertEquals(1, aggregator.min());
        assertEquals(8, aggregator.max());
        assertEquals(17, aggregator.sum());
        assertEquals(4, aggregator.mid());
    }

}
