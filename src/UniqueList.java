import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueList {
  public static void main(String[] args) {
    Set<String> list1 = new HashSet<>();
    list1.add("A");
    list1.add("B");
    list1.add("C");
    list1.add("D");
    list1.add("E");

    Set<String> list2 = new HashSet<>();
    list2.add("B");
    list2.add("C");
    list2.add("D");
    list2.add("E");
    list2.add("F");

    printUniqueElements(list1, list2);

  }
  /**
  public static void printUniqueElements(Set<String> list1, Set<String> list2) {
    HashMap mapCounter = new HashMap<String, Integer >();

    ArrayList<String> counterList = new ArrayList<String>();
    counterList.addAll(list1);
    counterList.addAll(list2);

    for (String s : counterList) {

      if(mapCounter.containsKey(s)){
        int count = (int) mapCounter.get(s);
        mapCounter.put(s, count + 1);
      }
      mapCounter.putIfAbsent(s, 0);
    }

    for (Object entry : mapCounter.entrySet()) {
      Map.Entry entry1 = (Map.Entry) entry;
      if((Integer)entry1.getValue() == 0){
        System.out.println(entry1.getKey());
      }
    }



  }
*/

  public static void printUniqueElements(Set<String> list1, Set<String> list2) {
    HashMap mapCounter = new HashMap<String, Integer >();

    ArrayList<String> counterList = new ArrayList<String>();
    counterList.addAll(list1);
    counterList.addAll(list2);

    for (String s : counterList) {
      mapCounter.putIfAbsent(s, 0);
      mapCounter.replace(s, (int) mapCounter.get(s) + 1);
    }


    mapCounter.keySet().stream().filter(key-> (int) mapCounter.get(key) == 1)
        .forEach(System.out::println);




  }

}
