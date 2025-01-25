
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class MiniMaxSum {

    public static void miniMaxSum(List<Integer> arr) {
        List<Integer> sortedList = new ArrayList<>(arr);
        Collections.sort(sortedList);
        List<Integer> minList = sortedList.subList(0, 4);
        List<Integer> maxList = sortedList.subList(1, 5);
        BigInteger min = minList.stream().map(r  -> new BigInteger(String.valueOf(r)) )
                .reduce((p,t) ->  p.add(t)).get();
        BigInteger max = maxList.stream().map(r  -> new BigInteger(String.valueOf(r)) )
                .reduce((p,t) ->  p.add(t)).get();;
        System.out.println(min + " " + max);

    }

    public static void main(String[] args) {

        miniMaxSum(List.of(1,3,5,7,9));
        miniMaxSum(List.of(793810624,895642170,685903712,623789054,468592370));

    }
}
