
import java.util.List;

public class HashExercise {

    public final static String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    public static long hash(String s) {
        long hash = 7;
        for (int i = 0; i < s.length(); i++) {

            hash = (hash * 37) + LETTERS.indexOf(s.charAt(i));
        }
        return hash;

    }

    public static long ReversedHash(String s) {
        long hash = 7;
        for (int i = 0; i < s.length(); i++) {

            hash = (hash / 37) + LETTERS.indexOf(s.charAt(i));
        }
        return hash;

    }


    public static List<String> findOriginal(long targetHash, int lenght) {

        List<String> result = List.of();
        generateCombinations("", lenght, result, targetHash);
        return result;
    }

    private static void generateCombinations(String current, int remain,
                                             List<String> result, long targetHash) {
        if (remain == 0) {
            if (hash(current) == targetHash) {
                result.add(current);

            }
            return;
        }


        for (int i = 0; i < LETTERS.length(); i++) {
            generateCombinations(current + LETTERS.charAt(i), remain - 1,
                    result, targetHash);
        }


    }


    public static void main(String[] args) {
      long targetHash = hash(LETTERS);
        System.out.println(targetHash);
        List<String> result = findOriginal(targetHash, LETTERS.length());
        System.out.println(result);



    }


}
