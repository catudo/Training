import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SingleNumber {

  public static int findSingleNumber(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      map.putIfAbsent(num, 0);
      map.replace(num, map.get(num) + 1);
    }
    List<Integer> result = map.keySet().stream().filter(key-> map.get(key) ==1).collect(Collectors.toList());

    return result.isEmpty() ? -1 : result.get(0);

  }


  public static void main(String[] args) {
    System.out.println(findSingleNumber(new int[]{2,2,1}));
    System.out.println(findSingleNumber(new int[]{4,1,2,1,2}));
  }

}
