package Q3.programming.hue9.h33.src;

import java.util.List;

public class ListContainer {

   public List<Integer> sort(List<Integer> list) {
       ListSort sorter = new ListSort();
       sorter.sort(list);
       return list;
   }

}
