import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        int array[] = {2,34,24,53,53,563,34};
        List repeatedList = Arrays.stream(array).boxed().toList();
        Set<Integer> list = new HashSet<>(repeatedList);
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }
}
