package Q3.programming.hue12.h50;

import java.util.ArrayList;
import java.util.List;

public class StringListPair {
    List<String> _list1;
    List<String> _list2;

    public StringListPair() {
        _list1 = new ArrayList<>();
        _list2 = new ArrayList<>();
    }

    public StringListPair(List<String> list1, List<String> list2) {
        _list1 = list1;
        _list2 = list2;
    }

    public void addToList1(String string) {
        _list1.add(string);
    }

    public void addToList2(String string) {
        _list2.add(string);
    }

    public List<String> getList1() {
        return _list1;
    }

    public List<String> getList2() {
        return _list2;
    }
}