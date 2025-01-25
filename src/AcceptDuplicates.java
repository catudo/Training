import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcceptDuplicates {

    public static int acceptDuplicates(int[] nums) {
        Map<Integer, Integer>  counter  = new HashMap<>();

        for (int num : nums) {
            counter.putIfAbsent(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int key : counter.keySet()) {
            if (counter.get(key) > 1) {
                for (int i=0; i<counter.get(key); i++) {
                    res.add(key);
                }
            }
        }

        return res.size();
    }

    public static void main(String[] args) {
        System.out.println(AcceptDuplicates.acceptDuplicates(new int[]{1,3,2,3,2,1,3}));
        System.out.println(AcceptDuplicates.acceptDuplicates(new int[]{1,5,3,1,5,3}));
    }

}
