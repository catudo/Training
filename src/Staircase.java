public class Staircase {
    public static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            for (int k = n; k > i + 1; k--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Staircase.staircase(100);
    }
}
