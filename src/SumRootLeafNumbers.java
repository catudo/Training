public class SumRootLeafNumbers {

  public int solution(int[] tree) {
    return helper(tree, 0, 0);
  }

  private int helper(int[] tree, int index, int currentSum) {
    if (index >= tree.length) return 0;

    currentSum = currentSum * 10 + tree[index];

    int left = 2 * index + 1;
    int right = 2 * index + 2;

    if (left >= tree.length && right >= tree.length) {
      return currentSum;
    }

    return helper(tree, left, currentSum) + helper(tree, right, currentSum);
  }


  public static void main(String[] args) {
    System.out.println(new SumRootLeafNumbers().solution(new int[]{1,2,3}));
    System.out.println(new SumRootLeafNumbers().solution(new int[]{4,9,0,5,1}));
  }
}
