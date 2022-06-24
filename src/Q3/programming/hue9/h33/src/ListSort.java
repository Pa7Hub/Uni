package Q3.programming.hue9.h33.src;

import java.util.Collections;
import java.util.List;

public class ListSort implements ISortAlgorithm {

    @Override
    public List<Integer> sort(List<Integer> unsorted) {
        Collections.sort(unsorted);
        return unsorted;
    }

}
