import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int sumFirstD = 0;
        int sumSecondD = 0;

        for (int i = 0, j=arr.size()-1; i <= arr.size() & j>=0; i++, j--) {
            List<Integer> subArray = arr.get(i);
            sumFirstD =sumFirstD + subArray.get(i);
            sumSecondD = sumSecondD + arr.get(i).get(j);
        }
        return Math.abs(sumFirstD - sumSecondD);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DiagonalDifference.diagonalDifference(arr);

        System.out.println(String.valueOf(result));
    }
}
