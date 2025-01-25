public class ValidateBinarySearch {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  public static boolean isValidBST(TreeNode root) {

        if (root.left !=null ) {
            TreeNode left = root.left;
            if (left.val >= root.val) {
                return false;
            }
            isValidBST(left);

        }

        if (root.right !=null ) {
            TreeNode right = root.right;
            if (right.val <= root.val) {
                return false;
            }
            isValidBST(right);
        }

        return true;

  }

    public static void main(String[] args) {
        TreeNode leftRoot = new TreeNode(1);
        TreeNode rightInner = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        TreeNode rightRoot = new TreeNode(2, leftRoot, rightInner);
        TreeNode root = new TreeNode(5, leftRoot, rightRoot);

        System.out.println(isValidBST(root));

        TreeNode newRoot = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(isValidBST(newRoot));
    }


}
