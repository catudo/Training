import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Largest {

    public static Integer solution(int[] array){
        List<Integer> list = Arrays.stream(array).boxed().distinct().sorted()
                .collect(Collectors.toList());

        return list.get(list.size()-1);

    }


    public static void main(String[] args) {
        int []  array = {12, 35, 1, 10, 34, 1};
        System.out.println(solution(array));
    }
}
