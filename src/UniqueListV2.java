import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueListV2 {
  public static void main(String[] args) {
    List<String> list1 = Arrays.asList("A", "B", "C", "D", "E");
    List<String> list2 = Arrays.asList("B", "C", "D", "E", "F");

    Set<String> set1 = new HashSet<>(list1);
    Set<String> set2 = new HashSet<>(list2);

    Set<String> uniqueToList1 = new HashSet<>(set1);
    uniqueToList1.removeAll(set2); // Elements only in list1

    Set<String> uniqueToList2 = new HashSet<>(set2);
    uniqueToList2.removeAll(set1); // Elements only in list2

    System.out.println("Unique to List 1: " + uniqueToList1);
    System.out.println("Unique to List 2: " + uniqueToList2);
  }
}
