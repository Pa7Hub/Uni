package Q3.programming.hue2;

import java.util.LinkedList;
import java.util.List;

public class ListStuff {

    public static void main(String[] args) {
        List<String> listy = new LinkedList<String>();

        listy.add("Whats");
        listy.add("Up");
        listy.add("Yo");

        for (String entry : listy) {
            System.out.println(entry);
        }
    }

}
