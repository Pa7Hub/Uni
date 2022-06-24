package Q3.programming.hue9.h33.src;

import java.util.ArrayList;
import java.util.List;

public class ListAggregator {
    private List<Integer> _list = new ArrayList<Integer>();

    public ListAggregator(List<Integer> list) {
        _list = list;
    }

    public List<Integer> getList() {
        return _list;
    }

    public int min() {
        return _list.get(0);
    }

    public int max() {
        return _list.get(_list.size()-1);
    }

    public int sum() {
        int sum = 0;
        for (int i : _list) {
            sum += i;
        }
        return sum;
    }

    public int mid() {
        return (this.sum() / _list.size());
    }


}
