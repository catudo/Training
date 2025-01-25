import java.util.List;
import java.util.stream.Collectors;

public class Median {
    public static int findMedian(List<Integer> arr) {
        // Write your code here
        List<Integer> arrCopy = arr.stream().sorted().collect(Collectors.toList());
        return arrCopy.get(arrCopy.size()/2);


    }

}
