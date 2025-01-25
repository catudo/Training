import java.util.List;

public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {

        int positives = 0, negatives=0, zeros = 0;

        for (Integer number : arr) {
            if(number > 0) {
                positives=positives+1;
            }else if(number < 0) {
                negatives=negatives+1;
            }else {
                zeros=zeros+1;
            }

        }

        double positivesQuantity   = positives/(double)arr.size();
        double negativesQuantity = negatives/(double)arr.size();
        double zerosQuantity   = zeros/(double)arr.size();


        System.out.printf("%.6f%n", positivesQuantity);
        System.out.printf("%.6f%n", negativesQuantity);
        System.out.printf("%.6f%n", zerosQuantity);


    }


    public static void main(String[] args) {
        List arr = List.of(1,1,0,-1,-1);
        plusMinus(arr);
    }
}