import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        try {
            String[] sArray = s.split(" ");
            String[] patternArray = pattern.split("");

            Map<String, String> map = new HashMap<>();


            for (int i = 0; i < sArray.length; i++) {
                map.putIfAbsent(patternArray[i], sArray[i]);
            }

            Map<String, Integer> counter = new HashMap<>();
            List<String> list = new ArrayList<>(map.values());

            for (int i = 0; i < list.size(); i++) {
                counter.putIfAbsent(list.get(i), 0);
                counter.put(list.get(i), counter.get(list.get(i)) + 1);
            }

            ;
            boolean repeatedValues = counter.values().stream().anyMatch(s1 -> s1 > 1);

            if (repeatedValues) {
                return false;
            }


            String validator = new String();
            for (int i = 0; i < patternArray.length; i++) {
                validator += map.get(patternArray[i]) + " ";
            }
            return validator.trim().equals(s);

        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

}
