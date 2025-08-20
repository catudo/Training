import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SummaryRanges {


  public static List<String> solution(int[] nums){

    List<String> result = new ArrayList<>();

    if (nums == null || nums.length == 0) return result;

    int min = nums[0];
    int max = nums[nums.length - 1];
    StringBuilder stringBuilder = new StringBuilder();
    boolean first = true;

    List<Integer> sortedNumbers = Arrays.stream(nums).boxed().collect(Collectors.toUnmodifiableList());
    for (int i = min; i <= max ; i++) {
      
      if (sortedNumbers.contains(i)&& first &&  !sortedNumbers.contains(i+1)) {
        stringBuilder.append(i);
        first = true;
        result.add(stringBuilder.toString());
        stringBuilder = new StringBuilder();
      } else if (sortedNumbers.contains(i) && first && sortedNumbers.contains(i+1) ) {
        stringBuilder.append(i);
        first = false;
      } else if (sortedNumbers.contains(i) && !first && !sortedNumbers.contains(i+1)) {
        stringBuilder.append( "->"+i);
        first = true;
        result.add(stringBuilder.toString());
        stringBuilder = new StringBuilder();
      }


    }

    return result;

  }

  public static void main(String[] args) {
    System.out.println(SummaryRanges.solution(new int[]{0,2,3,4,6,8,9}));



  }
}
